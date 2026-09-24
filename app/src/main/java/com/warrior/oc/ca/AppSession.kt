package com.warrior.oc.ca

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import com.warrior.oc.ca.data.datalocal.manager.AppDataManager
import com.warrior.oc.ca.data.model.addcharacter.BackgroundCategoryModel
import com.warrior.oc.ca.data.model.addcharacter.SpeechCategoryModel
import com.warrior.oc.ca.data.model.addcharacter.StickerCategoryModel
import com.warrior.oc.ca.data.model.custom.CustomModel
import com.warrior.oc.ca.data.model.custom.LayerTransform
import com.warrior.oc.ca.data.model.custom.SelectionIndex
import com.warrior.oc.ca.data.usecase.GetCatalogueUseCase
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dagger.hilt.android.qualifiers.ApplicationContext
import java.net.HttpURLConnection
import java.net.URL
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.util.Collections

@Singleton
class AppSession @Inject constructor(
    private val getCatalogueUseCase: GetCatalogueUseCase,
    val appDataManager: AppDataManager,
    private val networkFlow: Flow<Boolean>,
    @ApplicationContext private val context: Context
) {
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    // ── EXPOSED FLOWS ─────────────────────────────────────────────────────────

    val characters:           StateFlow<List<CustomModel>> = appDataManager.characters
    val templates:            StateFlow<List<CustomModel>> = appDataManager.templates
    val customizedCharacters: StateFlow<List<CustomModel>> = appDataManager.customizedCharacters
    val backgrounds:          StateFlow<List<String>>      = appDataManager.backgrounds
    val backgroundTexts:      StateFlow<List<String>>      = appDataManager.backgroundTexts
    val stickers:             StateFlow<List<String>>      = appDataManager.stickers
    val speechs:              StateFlow<List<String>>      = appDataManager.speechs
    val myDesignPaths:        StateFlow<List<String>>      = appDataManager.myDesignPaths
    val isLoading:            StateFlow<Boolean>           = appDataManager.isLoading
    val error:                StateFlow<String?>           = appDataManager.error
    private val _bgStickerFailed = MutableStateFlow(false)
    val bgStickerFailed: StateFlow<Boolean> = _bgStickerFailed.asStateFlow()
    private val _bgStickerReady = MutableStateFlow(false)
    val bgStickerReady: StateFlow<Boolean> = _bgStickerReady.asStateFlow()
    private val _bgLoading = MutableStateFlow(false)
    var bgQuantity: Int = 0
        private set
    var stickerQuantity: Int = 0
        private set
    val bgBaseUrl = "https://lvtglobal.tech/public/app/ST301_FantasyAvatarOCMaker/bg"
    private val _backgroundCategories = MutableStateFlow<List<BackgroundCategoryModel>>(emptyList())
    val backgroundCategories: StateFlow<List<BackgroundCategoryModel>> =
        _backgroundCategories.asStateFlow()
    private val _stickerCategories = MutableStateFlow<List<StickerCategoryModel>>(emptyList())
    val stickerCategories: StateFlow<List<StickerCategoryModel>> = _stickerCategories.asStateFlow()
    private val _speechCategories = MutableStateFlow<List<SpeechCategoryModel>>(emptyList())
    val speechCategories: StateFlow<List<SpeechCategoryModel>> = _speechCategories.asStateFlow()
    var cosplayBitmap: Bitmap? = null
    var userResultBitmap: Bitmap? = null
    var customizeBitmap: Bitmap? = null
    var cosplayPercent: Int = 0
    val networkOnline: StateFlow<Boolean> = networkFlow
        .stateIn(
            scope = applicationScope,
            started = SharingStarted.Eagerly, // ← Eagerly để không miss network event
            initialValue = false,
        )

    // Guard chống gọi fetch trùng từ nhiều fragment
    private val _isFetchingOnline = MutableStateFlow(false)
    val isFetchingOnlineFlow: StateFlow<Boolean> = _isFetchingOnline.asStateFlow()
    private val _imagesReady = MutableStateFlow(false)
    val imagesReady: StateFlow<Boolean> = _imagesReady.asStateFlow()
    private val _localDataReady = MutableStateFlow(false)
    val localDataReady: StateFlow<Boolean> = _localDataReady.asStateFlow()
    fun notifyImagesReady() {
        _imagesReady.value = true
    }
    // ── INIT ──────────────────────────────────────────────────────────────────

    init {
        Log.d("PERF2", "AppSession created: ${System.currentTimeMillis()}")
        loadInitialData()
    }

    private suspend fun loadUrlList(baseUrl: String, ext: String): List<String> {
        val results = Collections.synchronizedMap(mutableMapOf<Int, String>())
        var shouldStop = false
        var start = 1

        while (!shouldStop) {
            val end = start + 9
            coroutineScope {
                (start..end).map { i ->
                    async(Dispatchers.IO) {
                        if (shouldStop) return@async
                        val url = "$baseUrl$i.$ext"
                        try {
                            val connection = URL(url).openConnection() as HttpURLConnection
                            connection.requestMethod = "HEAD"
                            connection.connectTimeout = 5000
                            connection.readTimeout = 5000
                            val code = connection.responseCode
                            connection.disconnect()
                            if (code == 403 || code == 404) shouldStop = true
                            else results[i] = url
                        } catch (e: Exception) {
                            shouldStop = true
                        }
                    }
                }.awaitAll()
            }
            start += 10
        }
        return results.toSortedMap().values.toList()
    }

    private data class BackgroundCatalog(
        val backgroundCategories: List<BackgroundCategoryModel>,
        val stickerCategories: List<StickerCategoryModel>,
        val speechCategories: List<SpeechCategoryModel>
    ) {
        val backgrounds: List<String>
            get() = backgroundCategories.flatMap { it.imageUrls() }
    }

    private fun loadBackgroundCatalog(): BackgroundCatalog {
        val connection = URL("$bgBaseUrl/bg.json").openConnection() as HttpURLConnection
        return try {
            connection.connectTimeout = 10_000
            connection.readTimeout = 10_000
            val json = connection.inputStream.bufferedReader().use { it.readText() }
            val jsonObject = JSONObject(json)

            val backgroundCategories = buildList {
                val items = jsonObject.getJSONArray("background")
                for (itemIndex in 0 until items.length()) {
                    val item = items.getJSONObject(itemIndex)
                    add(
                        BackgroundCategoryModel(
                            category = item.getString("category"),
                            quantity = item.getInt("quantity")
                        )
                    )
                }
            }
            val stickerCategories = buildList {
                val items = jsonObject.getJSONArray("sticker")
                for (itemIndex in 0 until items.length()) {
                    val item = items.getJSONObject(itemIndex)
                    add(
                        StickerCategoryModel(
                            category = item.getString("category"),
                            quantity = item.getInt("quantity")
                        )
                    )
                }
            }
            val speechCategories = buildList {
                val items = jsonObject.getJSONArray("SpeechBubbles")
                for (itemIndex in 0 until items.length()) {
                    val item = items.getJSONObject(itemIndex)
                    add(
                        SpeechCategoryModel(
                            category = item.getString("category"),
                            quantity = item.getInt("quantity")
                        )
                    )
                }
            }

            BackgroundCatalog(backgroundCategories, stickerCategories, speechCategories)
        } finally {
            connection.disconnect()
        }
    }
    // ✅ Fix — gọi đúng hàm đã có
    fun preloadBackgroundsAndStickers() {
        if (_bgStickerReady.value) return
        loadBackgroundsAndStickers() // ← hàm này đã có trong AppSession
    }

    fun loadBackgroundsAndStickers() {
        if (_bgLoading.value) return
        if (_bgStickerReady.value && !_bgStickerFailed.value) return

        applicationScope.launch(Dispatchers.IO) {
            _bgLoading.value = true
            _bgStickerReady.value = false
            try {
                val catalog = loadBackgroundCatalog()
                check(
                    catalog.backgrounds.isNotEmpty() &&
                        catalog.stickerCategories.isNotEmpty() &&
                        catalog.speechCategories.isNotEmpty()
                ) {
                    "Background/Sticker/Speech catalog is empty"
                }

                bgQuantity = catalog.backgrounds.size
                stickerQuantity = catalog.stickerCategories.sumOf { it.quantity }
                _backgroundCategories.value = catalog.backgroundCategories
                _stickerCategories.value = catalog.stickerCategories
                _speechCategories.value = catalog.speechCategories
                appDataManager.updateBackgroundsStickersAndSpeech(
                    bgs = catalog.backgrounds,
                    stickers = catalog.stickerCategories.flatMap { it.imageUrls() },
                    speech = catalog.speechCategories.flatMap { it.imageUrls() }
                )
                _bgStickerFailed.value = false
                _bgStickerReady.value = true
                Log.d(
                    "AppSession",
                    "✅ backgrounds=$bgQuantity " +
                        "backgroundCategories=${catalog.backgroundCategories.size} " +
                        "stickerCategories=${catalog.stickerCategories.size} " +
                        "speechCategories=${catalog.speechCategories.size}"
                )
            } catch (e: Exception) {
                Log.e("AppSession", "❌ loadBgSticker: ${e.message}")
                _bgStickerFailed.value = true
            } finally {
                _bgLoading.value = false
            }
        }
    }

    private fun loadInitialData() {
        applicationScope.launch {
            try {
                val hasCache = withContext(Dispatchers.IO) {
                    appDataManager.loadQuickData()
                }
                if (!hasCache) appDataManager.loadInitialData()
                _localDataReady.value = true

                // ← Load song song
                launch { fetchOnlineTemplatesInternal() }
                launch { loadBackgroundsAndStickers() }
                launch { observeNetworkForRetry() }

            } catch (e: Exception) {
                Log.e("AppSession", "❌ Init error: ${e.message}", e)
            }
        }
    }
    private suspend fun observeNetworkForRetry() {
        networkOnline.collect { isOnline ->
            if (isOnline && _bgStickerFailed.value && !_bgLoading.value) {
                Log.d("AppSession", "🔄 Network restored, retrying...")
                _bgStickerFailed.value = false
                loadBackgroundsAndStickers()
            }
        }
    }
    // ── FETCH (duy nhất 1 hàm, có guard) ─────────────────────────────────────

    /**
     * Gọi từ mọi nơi đều an toàn — guard đảm bảo chỉ 1 request chạy tại 1 thời điểm.
     * BaseActivity gọi khi vào màn + có mạng + chưa có online data.
     */
    private suspend fun fetchOnlineTemplatesInternal() {
        if (_isFetchingOnline.value) {
            Log.d("AppSession", "⏭️ Already fetching, skip")
            return
        }
        _isFetchingOnline.value = true
        try {
            Log.d("AppSession", "📡 fetchOnlineTemplates start")
            val result = getCatalogueUseCase()
            if (result.isSuccess) {
                val newTemplates = result.getOrNull() ?: return
                appDataManager.saveApiCache(newTemplates)
                appDataManager.mergeApiTemplates(newTemplates)
                prefetchTemplateImages(newTemplates)
                Log.d("AppSession", "✅ Online templates loaded: ${newTemplates.size}")
            } else {
                Log.e("AppSession", "❌ API failed: ${result.exceptionOrNull()?.message}")
            }
        } catch (e: Exception) {
            Log.e("AppSession", "❌ fetchOnlineTemplates error: ${e.message}", e)
        } finally {
            _isFetchingOnline.value = false
            _imagesReady.value = true
        }
    }

    /** Public — BaseActivity và pull-to-refresh gọi */
    fun fetchOnlineTemplates() {
        applicationScope.launch(Dispatchers.IO){ fetchOnlineTemplatesInternal() }
    }

    fun forceReloadAll() {
        applicationScope.launch {
            _localDataReady.value = false  // ✅ reset trước
            appDataManager.forceReloadAll()
            _localDataReady.value = true   // ✅ xong
        }
    }
    fun refreshApiData() {
        applicationScope.launch { appDataManager.refreshFromApi() }
    }

    // ── PREFETCH IMAGES ───────────────────────────────────────────────────────

    private suspend fun prefetchTemplateImages(templates: List<CustomModel>) {
        withContext(Dispatchers.IO) {
            templates.take(5).forEach { template ->
                template.listPath.forEach { bp ->
                    val firstColor = bp.listPath.firstOrNull() ?: return@forEach
                    val firstPath  = firstColor.listPath
                        .firstOrNull { it != "none" && it != "dice" }
                        ?: return@forEach
                    runCatching {
                        Glide.with(context)
                            .asBitmap()
                            .load(firstPath)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .override(256, 256)
                            .preload()
                    }
                }
            }
        }
    }

    // ── QUERIES ───────────────────────────────────────────────────────────────

    fun getCharacterByIndex(index: Int): CustomModel? = appDataManager.getCharacterByIndex(index)
    fun getCharacterById(id: String): CustomModel?    = appDataManager.getCharacterById(id)
    fun isTemplate(id: String): Boolean               = appDataManager.isTemplate(id)
    fun getTemplateIndexByAvt(avt: String): Int       = appDataManager.getTemplateIndexByAvt(avt)
    fun getCharacterIndexById(id: String): Int        = characters.value.indexOfFirst { it.id == id }

    fun getTemplateIndexForCustomized(customizedId: String): Int {
        val customized = customizedCharacters.value.firstOrNull { it.id == customizedId }
            ?: return -1

        // ✅ Ưu tiên templateId
        val byTemplateId = customized.templateId?.let { tplId ->
            templates.value.indexOfFirst { it.id == tplId }.takeIf { it >= 0 }
        }
        if (byTemplateId != null) return byTemplateId

        // ✅ Fallback avatar
        val byAvatar = templates.value.indexOfFirst { it.avatar == customized.avatar }
            .takeIf { it >= 0 }
        if (byAvatar != null) return byAvatar

        Log.w("AppSession", "⚠️ Template not found for customizedId=$customizedId, templateId=${customized.templateId}")
        return -1
    }

    /**
     * Kiểm tra các index đã lưu của character trước khi mở màn hình Edit.
     * Dữ liệu cũ/corrupt có thể chứa colorIndex hoặc pathIndex không còn nằm
     * trong template hiện tại.
     */
    fun hasValidSelectionsForCustomized(customizedId: String): Boolean {
        val customized = customizedCharacters.value.firstOrNull { it.id == customizedId }
            ?: return false
        val templateIndex = getTemplateIndexForCustomized(customizedId)
        val template = templates.value.getOrNull(templateIndex) ?: return false
        val parts = template.listPath.sortedBy { it.zIndex }

        if (customized.selections.size > parts.size) return false

        return customized.selections.withIndex().all { (index, selection) ->
            val part = parts.getOrNull(index) ?: return false
            val color = part.listPath.getOrNull(selection.colorIndex) ?: return false
            color.listPath.getOrNull(selection.pathIndex) != null
        }
    }

    // ── CRUD ──────────────────────────────────────────────────────────────────

    fun saveCharacterWithSelections(
        character: CustomModel,
        selections: List<SelectionIndex>,
        imageSave:  String  = "",
        isFlipped:  Boolean = false,
        layerTransforms: Map<Int, LayerTransform> = emptyMap()
    ) {
        applicationScope.launch {
            val toSave = if (isTemplate(character.id)) {
                character.copy(
                    id         = UUID.randomUUID().toString(),
                    templateId = character.id,
                    selections = ArrayList(selections),
                    imageSave  = imageSave,
                    isFlipped  = isFlipped,
                    layerTransforms = layerTransforms,
                    createdAt  = System.currentTimeMillis(),
                    updatedAt  = System.currentTimeMillis()
                    // ✅ KHÔNG set listPath — giữ nguyên từ template
                )
            } else {
                character.copy(
                    selections = ArrayList(selections),
                    imageSave  = imageSave,
                    isFlipped  = isFlipped,
                    layerTransforms = layerTransforms,
                    updatedAt  = System.currentTimeMillis()
                    // ✅ KHÔNG set listPath
                )
            }
            Log.d("AppSession", "💾 Saving: id=${toSave.id}, templateId=${toSave.templateId}, imageSave=${toSave.imageSave}")
            appDataManager.updateCustomizedCharacter(toSave)
        }
    }

    fun deleteCharacter(characterId: String) {
        applicationScope.launch {
            if (isTemplate(characterId)) return@launch
            appDataManager.deleteCustomizedCharacter(characterId)
        }
    }

    // ── SELECTION HELPERS ─────────────────────────────────────────────────────

    fun resolvePath(character: CustomModel, sel: SelectionIndex): String? =
        appDataManager.resolvePathFromSelection(character, sel)

    fun resolveAllPaths(character: CustomModel, selections: List<SelectionIndex>): List<Pair<Int, String>> =
        appDataManager.resolveAllPaths(character, selections)

    // ── MY DESIGNS ────────────────────────────────────────────────────────────

    fun addMyDesign(path: String)    { applicationScope.launch { appDataManager.addMyDesignPath(path) } }
    fun removeMyDesign(path: String) { applicationScope.launch { appDataManager.removeMyDesignPath(path) } }

    // ── CLEAR ─────────────────────────────────────────────────────────────────

    fun clearData() { appDataManager.clearData() }
}
