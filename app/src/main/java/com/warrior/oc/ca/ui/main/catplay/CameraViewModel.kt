package com.warrior.oc.ca.ui.main.catplay

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class CatStage(
    val imageNumber: Int,
    val audioPath: String,
    val isBreathing: Boolean
) {
    NORMAL(1, "audio_extracted/audio01.mp3", true),
    REACTING(2, "audio_extracted/audio02.mp3", false),
    LOST(3, "audio_extracted/audio03.mp3", false)
}

data class CatPlayUiState(
    val score: Int = 0,
    val stage: CatStage = CatStage.NORMAL
)

@HiltViewModel
class CatPlayViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(CatPlayUiState())
    val uiState: StateFlow<CatPlayUiState> = _uiState.asStateFlow()

    private var reactionFurCount = 0
    private var brushDistance = 0f
    private var idleResetJob: Job? = null

    fun onBrush(distancePx: Float, density: Float): Int {
        if (_uiState.value.stage == CatStage.LOST) return 0
        brushDistance += distancePx
        val distancePerFurDp = when {
            _uiState.value.score < 15 -> 240f
            _uiState.value.score < 40 -> 210f
            _uiState.value.score < 70 -> 180f
            else -> 155f
        }
        val distancePerFur = density * distancePerFurDp
        val furCount = (brushDistance / distancePerFur).toInt().coerceAtMost(1)
        if (furCount == 0) {
            if (_uiState.value.stage == CatStage.REACTING) scheduleIdleReset()
            return 0
        }

        brushDistance %= distancePerFur
        reactionFurCount += furCount
        val nextStage = when {
            reactionFurCount >= LOSE_REACTION_FUR_COUNT -> CatStage.LOST
            reactionFurCount >= REACTION_FUR_COUNT -> CatStage.REACTING
            else -> _uiState.value.stage
        }
        _uiState.value = _uiState.value.copy(
            score = _uiState.value.score + furCount,
            stage = nextStage
        )

        if (nextStage == CatStage.REACTING) scheduleIdleReset() else idleResetJob?.cancel()
        return furCount
    }

    private fun scheduleIdleReset() {
        idleResetJob?.cancel()
        idleResetJob = viewModelScope.launch {
            delay(IDLE_RESET_DELAY_MS)
            if (_uiState.value.stage == CatStage.REACTING) {
                brushDistance = 0f
                reactionFurCount = 0
                _uiState.value = _uiState.value.copy(stage = CatStage.NORMAL)
            }
        }
    }

    companion object {
        private const val REACTION_FUR_COUNT = 6
        private const val LOSE_REACTION_FUR_COUNT = 14
        private const val IDLE_RESET_DELAY_MS = 3_000L
    }
}
