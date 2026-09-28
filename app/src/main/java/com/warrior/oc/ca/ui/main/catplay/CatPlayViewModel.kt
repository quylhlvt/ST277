package com.warrior.oc.ca.ui.main.catplay

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import android.os.SystemClock
import com.warrior.oc.ca.core.helper.PermissionRequestState
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

enum class CameraPermissionAction {
    START_CAMERA,
    REQUEST_PERMISSION,
    OPEN_SETTINGS
}

@HiltViewModel
class CatPlayViewModel @Inject constructor(
    private val permissionState: PermissionRequestState
) : ViewModel() {
    private val _uiState = MutableStateFlow(CatPlayUiState())
    val uiState: StateFlow<CatPlayUiState> = _uiState.asStateFlow()

    private var reactionFurCount = 0
    private var brushDistance = 0f
    private var angryBrushElapsed = 0f
    private var reactionImageReadyAt = 0L
    private var biteRequested = false
    private var isBrushInteractionActive = false
    private var idleResetJob: Job? = null
    private var pendingBiteJob: Job? = null

    fun onCameraPermissionResult(granted: Boolean) {
        if (granted) permissionState.onCameraGranted() else permissionState.onCameraDenied()
    }

    fun cameraPermissionAction(isGranted: Boolean): CameraPermissionAction {
        if (isGranted) {
            permissionState.onCameraGranted()
            return CameraPermissionAction.START_CAMERA
        }
        return if (permissionState.cameraDenyCount.value >= MAX_CAMERA_DENIALS) {
            CameraPermissionAction.OPEN_SETTINGS
        } else {
            CameraPermissionAction.REQUEST_PERMISSION
        }
    }

    fun onReactionImageShown() {
        if (_uiState.value.stage != CatStage.REACTING || reactionImageReadyAt != 0L) return
        reactionImageReadyAt = SystemClock.uptimeMillis()
        scheduleBiteWhenReactionWasShown()
    }

    fun onBrushInteractionStarted() {
        isBrushInteractionActive = true
        idleResetJob?.cancel()
        idleResetJob = null
    }

    fun onBrushInteractionEnded() {
        isBrushInteractionActive = false
        if (_uiState.value.stage == CatStage.REACTING) {
            // Releasing the brush as soon as the cat turns should cancel an
            // attack that was queued while the reaction image was loading.
            angryBrushElapsed = 0f
            biteRequested = false
            pendingBiteJob?.cancel()
            pendingBiteJob = null
            scheduleIdleReset()
        }
    }

    fun onBrush(
        distancePx: Float,
        density: Float,
        brushSpeedDpPerSecond: Float,
        deltaSeconds: Float
    ): Int {
        if (_uiState.value.stage == CatStage.LOST) return 0
        brushDistance += distancePx
        // Match the original game's angry timer: count only active, fast brush movement.
        if (_uiState.value.stage == CatStage.REACTING &&
            brushSpeedDpPerSecond > MIN_ANGRY_BRUSH_SPEED_DP_PER_SECOND
        ) {
            angryBrushElapsed += deltaSeconds.coerceAtLeast(0f)
            val difficulty = (_uiState.value.score / MAX_DIFFICULTY_SCORE.toFloat())
                .coerceIn(0f, 1f)
            val attackDelay = MAX_ATTACK_DELAY_SECONDS -
                (MAX_ATTACK_DELAY_SECONDS - MIN_ATTACK_DELAY_SECONDS) * difficulty
            if (angryBrushElapsed >= attackDelay) {
                biteRequested = true
                scheduleBiteWhenReactionWasShown()
            }
        }

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
        val wasReacting = _uiState.value.stage == CatStage.REACTING
        val nextScore = _uiState.value.score + furCount
        reactionFurCount += furCount
        val nextStage = when {
            reactionFurCount >= REACTION_FUR_COUNT -> CatStage.REACTING
            else -> _uiState.value.stage
        }
        if (!wasReacting && nextStage == CatStage.REACTING) {
            // Do not let brush distance collected before the cat turned around
            // count toward brushing while the cat is reacting.
            brushDistance = 0f
            angryBrushElapsed = 0f
            reactionImageReadyAt = 0L
            biteRequested = false
        }
        _uiState.value = _uiState.value.copy(
            score = nextScore,
            stage = nextStage
        )

        if (nextStage == CatStage.REACTING) scheduleIdleReset() else idleResetJob?.cancel()
        return furCount
    }

    private fun scheduleIdleReset() {
        if (isBrushInteractionActive) return
        idleResetJob?.cancel()
        idleResetJob = viewModelScope.launch {
            delay(IDLE_RESET_DELAY_MS)
            if (_uiState.value.stage == CatStage.REACTING) {
                brushDistance = 0f
                reactionFurCount = 0
                angryBrushElapsed = 0f
                reactionImageReadyAt = 0L
                biteRequested = false
                pendingBiteJob?.cancel()
                pendingBiteJob = null
                _uiState.value = _uiState.value.copy(stage = CatStage.NORMAL)
            }
        }
    }

    private fun transitionToLost() {
        idleResetJob?.cancel()
        pendingBiteJob?.cancel()
        pendingBiteJob = null
        _uiState.value = _uiState.value.copy(stage = CatStage.LOST)
    }

    private fun scheduleBiteWhenReactionWasShown() {
        if (!biteRequested || reactionImageReadyAt == 0L ||
            _uiState.value.stage != CatStage.REACTING
        ) return

        val remainingDisplayTime = MIN_REACTION_DISPLAY_MS -
            (SystemClock.uptimeMillis() - reactionImageReadyAt)
        pendingBiteJob?.cancel()
        pendingBiteJob = viewModelScope.launch {
            if (remainingDisplayTime > 0L) delay(remainingDisplayTime)
            if (_uiState.value.stage == CatStage.REACTING && biteRequested) {
                transitionToLost()
            }
        }
    }

    companion object {
        private const val MAX_CAMERA_DENIALS = 2
        private const val REACTION_FUR_COUNT = 6
        private const val MIN_REACTION_DISPLAY_MS = 700L
        private const val MIN_ANGRY_BRUSH_SPEED_DP_PER_SECOND = 20f
        private const val MAX_ATTACK_DELAY_SECONDS = 0.6f
        private const val MIN_ATTACK_DELAY_SECONDS = 0.2f
        private const val MAX_DIFFICULTY_SCORE = 120
        private const val IDLE_RESET_DELAY_MS = 3_000L
    }
}
