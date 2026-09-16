package com.duomaker.couplelove.vatar.ui.main.show

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duomaker.couplelove.vatar.data.datalocal.manager.AppDataManager
import com.duomaker.couplelove.vatar.data.model.custom.BodyPartModel
import com.duomaker.couplelove.vatar.data.model.custom.SelectionIndex
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltViewModel
class ShowViewModel @Inject constructor(
    private val appDataManager: AppDataManager
) :
    ViewModel() {

    private val _state = MutableStateFlow(ShowState())
    val state: StateFlow<ShowState> = _state.asStateFlow()

    /** Phát khi đạt 100% — Activity lắng nghe để navigate */
    private val _onComplete = MutableSharedFlow<Unit>(replay = 0)
    val onComplete = _onComplete.asSharedFlow()


    // ── INIT — gọi từ Activity sau khi nhận args từ CosplayActivity ───────────

    /**
     * [templateIndex]   : index template random từ CosplayViewModel
     * [targetSelections]: selections random từ CosplayViewModel (đáp án)
     */
    fun init(
        templateIndex: Int,
        targetSelections: ArrayList<SelectionIndex>,
        templateId: String? = null
    ) {

        if (_state.value.listData.isNotEmpty()) return  // safe với process death


        val template = templateId?.let(appDataManager::getTemplateById)
            ?: appDataManager.getTemplateByIndex(templateIndex)
            ?: return
        val indexedSorted = template.listPath.withIndex()
            .sortedWith(compareBy<IndexedValue<BodyPartModel>> { it.value.zIndex }.thenBy { it.index })
        val sorted = indexedSorted.map { it.value }

        // Remap targetSelections từ unsorted sang sorted (giống CustomizeViewModel.initWithSelections)
        val remapped = indexedSorted.mapIndexed { sortedIdx, indexedBodyPart ->
            val originalIdx = indexedBodyPart.index
            val sel = targetSelections.getOrElse(originalIdx) { SelectionIndex(originalIdx, 0, 0) }
            SelectionIndex(sortedIdx, sel.colorIndex, sel.pathIndex)
        }

        // User bắt đầu với default (index 0) — giống "tạo nhân vật mới"
        val userDefault = buildDefaultSelections(sorted)
        val initialPercent = calculateMatchPercent(
            parts = sorted,
            target = remapped,
            user = userDefault
        )
        val navChar1 = firstNavIndexForChar(sorted, 1)
        val navChar2 = firstNavIndexForChar(sorted, 2)
        val activeCharacter = firstCharacterType(sorted)

        _state.value = ShowState(
            template         = template,
            listData         = sorted,
            targetSelections = remapped,
            userSelections   = userDefault,
            currentNavIndex  = if (activeCharacter == 2) navChar2 else navChar1,
            currentNavIndexChar1 = navChar1,
            currentNavIndexChar2 = navChar2,
            activeCharacter  = activeCharacter,
            isLoading        = true,
            // Part + màu mặc định đang hiển thị được chấm ngay nếu cùng đúng;
            // các nav đang ở "none" vẫn chưa được tính điểm.
            matchPercent     = initialPercent
        )
    }

    fun onLoadingComplete() = _state.update { it.copy(isLoading = false) }

    // ── USER INTERACTIONS (giống CustomizeViewModel) ──────────────────────────

    fun selectNav(navIndex: Int) {
        _state.update { state ->
            val safeNav = navIndex.coerceIn(0, maxOf(0, state.listData.lastIndex))
            state.copy(currentNavIndex = safeNav)
        }
    }

    fun toggleCharacter() {
        _state.update { state ->
            val nextCharacter = if (state.activeCharacter == 1) 2 else 1
            if (state.listData.none { it.charType == nextCharacter }) return@update state

            val storedNav = if (nextCharacter == 1) {
                state.currentNavIndexChar1
            } else {
                state.currentNavIndexChar2
            }
            state.copy(
                activeCharacter = nextCharacter,
                currentNavIndex = clampNavIndex(state.listData, nextCharacter, storedNav)
            )
        }
    }

    fun selectColor(colorIndex: Int) {
        updateUserSelection { state, old ->
            val bp        = state.listData.getOrNull(state.currentNavIndex) ?: return@updateUserSelection old
            val safeColor = colorIndex.coerceIn(0, bp.listPath.size - 1)
            val maxPath   = (bp.listPath.getOrNull(safeColor)?.listPath?.size ?: 1) - 1
            SelectionIndex(old.bodyPartIndex, safeColor, old.pathIndex.coerceIn(0, maxPath))
        }
    }

    fun selectPath(pathIndex: Int) {
        updateUserSelection { state, old ->
            val bp      = state.listData.getOrNull(state.currentNavIndex) ?: return@updateUserSelection old
            val maxPath = (bp.listPath.getOrNull(old.colorIndex)?.listPath?.size ?: 1) - 1
            SelectionIndex(old.bodyPartIndex, old.colorIndex, pathIndex.coerceIn(0, maxPath))
        }
    }

    fun selectNone() = selectPath(0)

    fun selectDiceCurrent() {
        updateUserSelection { state, old ->
            val bp    = state.listData.getOrNull(state.currentNavIndex) ?: return@updateUserSelection old
            val paths = bp.listPath.getOrNull(old.colorIndex)?.listPath ?: return@updateUserSelection old
            val start = startIndexAfterSpecial(paths)
            val idx   = if (paths.size > start) (start until paths.size).random() else start
            SelectionIndex(old.bodyPartIndex, old.colorIndex, idx)
        }
    }

    fun randomizeAll() {
        val state = _state.value
        val newSel = state.listData.mapIndexed { i, bp ->
            val colorIdx = if (bp.listPath.size > 1) (0 until bp.listPath.size).random() else 0
            val paths    = bp.listPath.getOrNull(colorIdx)?.listPath ?: emptyList()
            val start    = startIndexAfterSpecial(paths)
            val pathIdx  = if (paths.size > start) (start until paths.size).random() else start
            SelectionIndex(i, colorIdx, pathIdx)
        }
        val percent = calculateMatchPercent(
            parts = state.listData,
            target = state.targetSelections,
            user = newSel
        )
        _state.update { it.copy(userSelections = newSel, matchPercent = percent) }
        checkComplete(percent)
    }

    // ── PATH RESOLUTION ───────────────────────────────────────────────────────

    /** Path theo userSelections — để render nhân vật user đang tạo */
    fun resolveUserPathAt(bodyPartIndex: Int): String? {
        val s    = _state.value
        val bp   = s.listData.getOrNull(bodyPartIndex) ?: return null
        val sel  = s.userSelections.getOrNull(bodyPartIndex) ?: return null
        val path = bp.listPath.getOrNull(sel.colorIndex)?.listPath?.getOrNull(sel.pathIndex) ?: return null
        return if (path == "none" || path == "dice") null else path
    }

    /** Path theo targetSelections — để tính % (không render lên màn) */
    fun resolveTargetPathAt(bodyPartIndex: Int): String? {
        val s    = _state.value
        val bp   = s.listData.getOrNull(bodyPartIndex) ?: return null
        val sel  = s.targetSelections.getOrNull(bodyPartIndex) ?: return null
        val path = bp.listPath.getOrNull(sel.colorIndex)?.listPath?.getOrNull(sel.pathIndex) ?: return null
        return if (path == "none" || path == "dice") null else path
    }

    // ── HELPERS ───────────────────────────────────────────────────────────────

    private fun checkComplete(percent: Int) {
        if (percent >= 100) {
            viewModelScope.launch { _onComplete.emit(Unit) }
        }
    }

    private fun startIndexAfterSpecial(paths: List<String>): Int = when {
        paths.firstOrNull() == "none" -> 2
        paths.firstOrNull() == "dice" -> 1
        else -> 0
    }

    private fun buildDefaultSelections(parts: List<BodyPartModel>): List<SelectionIndex> =
        parts.mapIndexed { index, bodyPart ->
            val firstIndexForCharacter = parts.indexOfFirst {
                it.charType == bodyPart.charType
            }
            if (index == firstIndexForCharacter) SelectionIndex(index, 0, 1)
            else SelectionIndex(index, 0, 0)
        }

    private fun firstCharacterType(parts: List<BodyPartModel>): Int = when {
        parts.any { it.charType == 1 } -> 1
        parts.any { it.charType == 2 } -> 2
        else -> 1
    }

    private fun firstNavIndexForChar(parts: List<BodyPartModel>, charType: Int): Int =
        parts.indexOfFirst { it.charType == charType }.takeIf { it >= 0 } ?: 0

    private fun clampNavIndex(
        parts: List<BodyPartModel>,
        charType: Int,
        navIndex: Int
    ): Int {
        if (parts.getOrNull(navIndex)?.charType == charType) return navIndex
        return firstNavIndexForChar(parts, charType)
    }

    private fun updateUserSelection(
        transform: (ShowState, SelectionIndex) -> SelectionIndex
    ) {
        _state.update { state ->
            val navIdx  = state.currentNavIndex
            val old     = state.userSelections.getOrElse(navIdx) { SelectionIndex(navIdx, 0, 0) }
            val new     = transform(state, old)
            val updated = state.userSelections.toMutableList()
            if (navIdx < updated.size) updated[navIdx] = new
            else {
                while (updated.size < navIdx) updated.add(SelectionIndex(updated.size, 0, 0))
                updated.add(new)
            }
            val percent = calculateMatchPercent(
                parts = state.listData,
                target = state.targetSelections,
                user = updated
            )
            state.copy(userSelections = updated, matchPercent = percent)
        }
        checkComplete(_state.value.matchPercent)
    }
    // ShowViewModel.kt
    fun reset() {
        _state.value = ShowState()
    }
}

/**
 * Mỗi nav chỉ có điểm khi cả màu và part cùng khớp đáp án. Part được UI chọn sẵn
 * vẫn được chấm ngay. Target "none"/"dice" hoặc hỏng được bỏ khỏi mẫu số để 100%
 * luôn có thể đạt được.
 */
internal fun calculateMatchPercent(
    parts: List<BodyPartModel>,
    target: List<SelectionIndex>,
    user: List<SelectionIndex>
): Int {
    var matchedParts = 0
    var totalParts = 0

    parts.forEachIndexed { index, bodyPart ->
        val targetSelection = target.getOrNull(index) ?: return@forEachIndexed
        val userSelection = user.getOrNull(index)
        val targetColor = bodyPart.listPath.getOrNull(targetSelection.colorIndex)
        val targetPath = targetColor?.listPath?.getOrNull(targetSelection.pathIndex)
            ?: return@forEachIndexed
        if (targetPath.equals("none", ignoreCase = true) ||
            targetPath.equals("dice", ignoreCase = true)
        ) {
            return@forEachIndexed
        }

        totalParts++
        if (userSelection?.colorIndex == targetSelection.colorIndex &&
            userSelection.pathIndex == targetSelection.pathIndex
        ) {
            matchedParts++
        }
    }

    if (totalParts == 0) return 0
    return (matchedParts * 100f / totalParts).roundToInt().coerceIn(0, 100)
}
