package com.anime.oc.characters.avatar.ui.main.random

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anime.oc.characters.avatar.data.datalocal.manager.AppDataManager
import com.anime.oc.characters.avatar.data.model.custom.CustomModel
import com.anime.oc.characters.avatar.data.model.custom.SelectionIndex
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomViewModel @Inject constructor(
    private val appDataManager: AppDataManager
) : ViewModel() {
    companion object {
        private const val MAX_DIFFERENT_RESULT_ATTEMPTS = 8
    }

    private val _isDataReady = MutableStateFlow(false)
    val isDataReady: StateFlow<Boolean> = _isDataReady.asStateFlow()
    private val _randomItem = MutableStateFlow<RandomItem?>(null)
    val randomItem: StateFlow<RandomItem?> = _randomItem.asStateFlow()
    private var _cachedBitmap: Bitmap? = null
    val cachedBitmap get() = _cachedBitmap
    private var randomizeJob: Job? = null
    private var generationCounter = 0L

    init {
        viewModelScope.launch {
            appDataManager.templates
                .filter { it.isNotEmpty() }
                .take(1)
                .collect {
                    _isDataReady.value = true
                }
        }
    }

    data class RandomItem(
        val templateIndex: Int,
        val template     : CustomModel,
        val selections   : ArrayList<SelectionIndex>,
        val resolvedPaths: List<String?>,
        val generation   : Long
    )
    fun setCachedBitmap(bmp: Bitmap) { _cachedBitmap = bmp }
    override fun onCleared() {
        super.onCleared()
        randomizeJob?.cancel()
        _cachedBitmap = null
    }

    /**
     * Creates a new random character. Returns false when the current data set
     * has no template that can be rendered (for example, only online templates
     * are available while the device is offline).
     */
    fun randomize(isOnline: Boolean = true): Boolean {
        val allTemplates = appDataManager.templates.value
        val candidates = allTemplates.filter { template ->
            (isOnline || !template.isOnlineTemplate()) && template.hasRenderableLayer()
        }
        if (candidates.isEmpty()) return false

        _cachedBitmap = null
        randomizeJob?.cancel()
        val generation = ++generationCounter
        randomizeJob = viewModelScope.launch(Dispatchers.Default) {
            val previous = _randomItem.value
            var next = createRandomItem(allTemplates, candidates.random(), generation)
            var attempt = 1

            while (next.hasSameResultAs(previous) &&
                attempt < MAX_DIFFERENT_RESULT_ATTEMPTS
            ) {
                next = createRandomItem(allTemplates, candidates.random(), generation)
                attempt++
            }

            // generation makes StateFlow emit even when the data set only has
            // one possible character and a different result cannot be created.
            _randomItem.value = next
        }
        return true
    }

    private fun createRandomItem(
        allTemplates: List<CustomModel>,
        template: CustomModel,
        generation: Long
    ): RandomItem {
        val selections = randomSelections(template)
        return RandomItem(
            templateIndex = allTemplates.indexOfFirst { it.id == template.id },
            template = template,
            selections = selections,
            resolvedPaths = resolvePaths(template, selections),
            generation = generation
        )
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

    /** Resolve layers in drawing order while keeping selections in source order. */
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

            ResolvedLayer(bodyPart.zIndex, bodyPartIndex, path)
        }
            .sortedWith(compareBy<ResolvedLayer> { it.zIndex }.thenBy { it.sourceIndex })
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

    private fun RandomItem.hasSameResultAs(other: RandomItem?): Boolean {
        return other != null && template.id == other.template.id && selections == other.selections
    }

    private data class ResolvedLayer(
        val zIndex: Int,
        val sourceIndex: Int,
        val path: String
    )
}
