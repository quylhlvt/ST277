package com.anime.oc.characters.avatar.ui.main.cosplay

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anime.oc.characters.avatar.data.datalocal.manager.AppDataManager
import com.anime.oc.characters.avatar.data.model.custom.CustomModel
import com.anime.oc.characters.avatar.data.model.custom.SelectionIndex
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CosplayViewModel @Inject constructor(
    private val appDataManager: AppDataManager
) : ViewModel() {
    // ✅ Khai báo HẾT property TRƯỚC init
    private val _randomItem = MutableStateFlow<RandomItem?>(null)
    val randomItem: StateFlow<RandomItem?> = _randomItem.asStateFlow()
    private val _isDataReady = MutableStateFlow(false)
    val isDataReady: StateFlow<Boolean> = _isDataReady.asStateFlow()
    private var _cachedBitmap: Bitmap? = null
    val cachedBitmap get() = _cachedBitmap
    private var _cachedGeneration: Long? = null
    val cachedGeneration get() = _cachedGeneration
    private var randomizeJob: kotlinx.coroutines.Job? = null
    @Volatile
    private var generationCounter = 0L
    init {
        viewModelScope.launch {
            appDataManager.templates
                .filter { templates -> templates.isNotEmpty() }
                .take(1) // Chỉ trigger lần đầu
                .collect {   _isDataReady.value = true }
        }
    }


    data class RandomItem(
        val templateIndex: Int,
        val template     : CustomModel,
        val selections   : ArrayList<SelectionIndex>,
        val resolvedPaths: List<String?>,
        val generation   : Long
    )
    fun setCachedBitmap(bmp: Bitmap, generation: Long) {
        _cachedBitmap = bmp
        _cachedGeneration = generation
    }
    fun isCurrentGeneration(generation: Long): Boolean = generationCounter == generation
    override fun onCleared() {
        super.onCleared()
        randomizeJob?.cancel()
        // ImageView/RenderThread có thể vẫn đang vẽ bitmap ở frame cuối.
        // Không recycle thủ công; để GC thu hồi sau khi view được giải phóng.
        _cachedBitmap = null
        _cachedGeneration = null
    }
    fun randomize(isOnline: Boolean = true): Boolean {
        val allTemplates = appDataManager.templates.value
        val filtered = allTemplates.filter { template ->
            (isOnline || !template.isOnlineTemplate()) && template.hasRenderableLayer()
        }
        if (filtered.isEmpty()) return false

        _cachedBitmap = null
        _cachedGeneration = null
        randomizeJob?.cancel()
        val generation = ++generationCounter
        randomizeJob = viewModelScope.launch(Dispatchers.IO) {
            val template = filtered.random()
            // ✅ Lấy index từ allTemplates, không phải filtered
            val realIndex = allTemplates.indexOf(template)

            val sel   = randomSelections(template)
            val paths = resolvePaths(template, sel)

            // The work above has no suspension point, so a cancelled old job
            // could otherwise publish after a newer random request.
            if (!isCurrentGeneration(generation)) return@launch

            _randomItem.value = RandomItem(
                templateIndex = realIndex,  // ✅
                template      = template,
                selections    = sel,
                resolvedPaths = paths,
                generation    = generation
            )
        }
        return true
    }

    private fun randomSelections(template: CustomModel): ArrayList<SelectionIndex> {
        return ArrayList(template.listPath.mapIndexed { bodyPartIndex, bodyPart ->
            val choices = bodyPart.listPath.flatMapIndexed { colorIndex, color ->
                color.listPath.mapIndexedNotNull { pathIndex, path ->
                    if (path.isRenderablePath()) colorIndex to pathIndex else null
                }
            }
            val choice = choices.randomOrNull()
            SelectionIndex(
                bodyPartIndex = bodyPartIndex,
                colorIndex = choice?.first ?: 0,
                pathIndex = choice?.second ?: 0
            )
        })
    }

    private fun resolvePaths(
        template: CustomModel,
        selections: List<SelectionIndex>
    ): List<String?> {
        return template.listPath.mapIndexedNotNull { bodyPartIndex, bodyPart ->
            val selection = selections.getOrNull(bodyPartIndex) ?: return@mapIndexedNotNull null
            val path = bodyPart.listPath
                .getOrNull(selection.colorIndex)
                ?.listPath
                ?.getOrNull(selection.pathIndex)
                ?.takeIf { it.isRenderablePath() }
                ?: return@mapIndexedNotNull null

            ResolvedLayer(bodyPart.position, bodyPart.zIndex, bodyPartIndex, path)
        }
            .sortedWith(
                compareBy<ResolvedLayer> { it.position }
                    .thenBy { it.zIndex }
                    .thenBy { it.sourceIndex }
            )
            .map { it.path }

    }

    private fun CustomModel.isOnlineTemplate() = id.startsWith("online_")

    private fun CustomModel.hasRenderableLayer(): Boolean {
        return listPath.any { bodyPart ->
            bodyPart.listPath.any { color -> color.listPath.any { it.isRenderablePath() } }
        }
    }

    private fun String.isRenderablePath(): Boolean {
        return isNotBlank() && !equals("none", ignoreCase = true) &&
            !equals("dice", ignoreCase = true)
    }

    private data class ResolvedLayer(
        val position: Int,
        val zIndex: Int,
        val sourceIndex: Int,
        val path: String
    )
}
