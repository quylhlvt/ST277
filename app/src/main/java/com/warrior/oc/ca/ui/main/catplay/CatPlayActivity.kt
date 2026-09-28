package com.warrior.oc.ca.ui.main.catplay

import android.Manifest
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.RectF
import android.media.MediaPlayer
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.warrior.oc.ca.R
import com.warrior.oc.ca.core.base.BaseActivity
import com.warrior.oc.ca.core.extention.goToSettings
import com.warrior.oc.ca.core.extention.onClick
import com.warrior.oc.ca.core.extention.requestPermission
import com.warrior.oc.ca.core.extention.setImageActionBar
import com.warrior.oc.ca.core.helper.PermissionHelper
import com.warrior.oc.ca.databinding.ActivityCatPlayBinding
import com.warrior.oc.ca.ui.main.listcat.ListCatActivity
import com.warrior.oc.ca.utils.key.RequestKey
import com.warrior.oc.ca.ui.main.lost.LostActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.hypot
import kotlin.random.Random
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CatPlayActivity : BaseActivity<ActivityCatPlayBinding, CatPlayViewModel>(
    ActivityCatPlayBinding::inflate,
    CatPlayViewModel::class.java
) {
    private var pendingCameraPermissionRequest = false
    private var cameraProvider: ProcessCameraProvider? = null
    private var isCameraEnabled = false
    private var isCameraStarting = false
    private var isDarkTheme = true
    private val selectedCat by lazy {
        intent.getIntExtra(ListCatActivity.EXTRA_SELECTED_CAT, 1).coerceIn(1, 5)
    }
    private var lastTouchX = 0f
    private var lastTouchY = 0f
    private var lastTouchEventTime = 0L
    private var renderedCatStage: CatStage? = null
    private var lostAnimationStarted = false
    private var catImageTarget: CustomTarget<Drawable>? = null
    private var breathingAnimator: AnimatorSet? = null
    private var stageSoundPlayer: MediaPlayer? = null
    private var currentAudioPath: String? = null
    private val stopBrushSound = Runnable {
        if (currentAudioPath == BRUSH_SOUND_PATH) {
            playSound(viewModel.uiState.value.stage.audioPath)
        }
    }

    override fun initView() {
        binding.apply {
            setImageActionBar(btnActionBarLeft, R.drawable.back_app)
            setImageActionBar(btnActionBarRight, R.drawable.ic_camera_off)
            btnTheme.setImageResource(R.drawable.ic_dark)
            root.setBackgroundColor(Color.BLACK)
            updateStatusBarIconTheme()
            previewView.isVisible = false
            txtScore.text = viewModel.uiState.value.score.toString()
            comb.bringToFront()
        }
    }

    override fun viewListener() {
        binding.btnActionBarLeft.onClick { finish() }
        binding.btnActionBarRight.onClick { toggleCameraPreview() }
        binding.btnTheme.onClick { toggleTheme() }
        binding.gameArea.setOnTouchListener(::onGameAreaTouch)
    }

    private fun toggleTheme() {
        isDarkTheme = !isDarkTheme
        binding.root.setBackgroundColor(if (isDarkTheme) Color.BLACK else Color.WHITE)
        updateStatusBarIconTheme()
        binding.btnTheme.setImageResource(
            if (isDarkTheme) R.drawable.ic_dark else R.drawable.ic_light
        )
    }

    private fun updateStatusBarIconTheme() {
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars =
            !isDarkTheme
    }

    private fun toggleCameraPreview() {
        if (isCameraStarting) return
        if (isCameraEnabled) {
            stopCameraPreview()
        } else {
            when (viewModel.cameraPermissionAction(hasCameraPermission())) {
                CameraPermissionAction.START_CAMERA -> startCameraPreview()
                CameraPermissionAction.REQUEST_PERMISSION -> {
                    pendingCameraPermissionRequest = true
                    requestPermission(
                        PermissionHelper.cameraPermission,
                        RequestKey.CAMERA_PERMISSION_CODE
                    )
                }
                CameraPermissionAction.OPEN_SETTINGS -> goToSettings()
            }
        }
    }

    private fun hasCameraPermission(): Boolean = ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED

    private fun stopCameraPreview() {
        cameraProvider?.unbindAll()
        cameraProvider = null
        isCameraEnabled = false
        isCameraStarting = false
        binding.previewView.isVisible = false
        binding.btnActionBarRight.isEnabled = true
        binding.btnActionBarRight.setImageResource(R.drawable.ic_camera_off)
    }

    private fun onGameAreaTouch(view: View, event: MotionEvent): Boolean {
        if (viewModel.uiState.value.stage == CatStage.LOST) return false
        val comb = binding.comb
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                viewModel.onBrushInteractionStarted()
                moveCombTo(event.x, event.y)
                lastTouchX = event.x
                lastTouchY = event.y
                lastTouchEventTime = event.eventTime
                view.parent.requestDisallowInterceptTouchEvent(true)
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                val moved = hypot(event.x - lastTouchX, event.y - lastTouchY)
                val moveDurationMs = (event.eventTime - lastTouchEventTime).coerceAtLeast(1L)
                val density = resources.displayMetrics.density
                val brushSpeedDpPerSecond = moved / density / (moveDurationMs / 1_000f)
                moveCombTo(event.x, event.y)
                if (moved > 0f && isCombOverCat(comb)) {
                    binding.root.removeCallbacks(stopBrushSound)
                    playSound(BRUSH_SOUND_PATH)
                    binding.root.postDelayed(stopBrushSound, BRUSH_SOUND_IDLE_DELAY_MS)
                    val furCount = viewModel.onBrush(
                        distancePx = moved,
                        density = density,
                        brushSpeedDpPerSecond = brushSpeedDpPerSecond,
                        deltaSeconds = moveDurationMs / 1_000f
                    )
                    repeat(furCount) { createFallingFur() }
                }

                lastTouchX = event.x
                lastTouchY = event.y
                lastTouchEventTime = event.eventTime
                return true
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                viewModel.onBrushInteractionEnded()
                view.parent.requestDisallowInterceptTouchEvent(false)
                view.performClick()
                binding.root.removeCallbacks(stopBrushSound)
                playSound(viewModel.uiState.value.stage.audioPath)
                return true
            }
        }
        return false
    }

    private fun moveCombTo(touchX: Float, touchY: Float) {
        val comb = binding.comb
        comb.x = (touchX - comb.width / 2f)
            .coerceIn(0f, (binding.gameArea.width - comb.width).toFloat())
        comb.y = (touchY - comb.height / 2f)
            .coerceIn(0f, (binding.gameArea.height - comb.height).toFloat())
    }

    private fun isCombOverCat(comb: View): Boolean {
        val cat = binding.draw
        // Ignore the transparent outer edge of the square cat asset.
        val insetX = cat.width * 0.16f
        val insetY = cat.height * 0.08f
        val catArea = RectF(
            cat.x + insetX,
            cat.y + insetY,
            cat.x + cat.width - insetX,
            cat.y + cat.height - insetY
        )
        val combCenterX = comb.x + comb.width / 2f
        val combCenterY = comb.y + comb.height / 2f
        return catArea.contains(combCenterX, combCenterY)
    }

    private fun createFallingFur() {
        val size = dp(Random.nextInt(22, 34))
        val fur = ImageView(this).apply {
            setImageResource(R.drawable.ic_fur)
            rotation = Random.nextInt(-35, 36).toFloat()
            alpha = 0.95f
            layoutParams = FrameLayout.LayoutParams(size, size)
            x = binding.comb.x + binding.comb.width * 0.25f + Random.nextInt(-12, 13)
            y = binding.comb.y + binding.comb.height * 0.35f
        }
        binding.furLayer.addView(fur)
        fur.animate()
            .translationXBy(Random.nextInt(-80, 81).toFloat())
            .translationYBy(dp(Random.nextInt(100, 190)).toFloat())
            .rotationBy(Random.nextInt(-140, 141).toFloat())
            .alpha(0f)
            .setDuration(Random.nextLong(900L, 1_500L))
            .withEndAction { binding.furLayer.removeView(fur) }
            .start()
    }

    private fun showLostAnimation(score: Int) {
        if (lostAnimationStarted) return
        lostAnimationStarted = true
        binding.comb.isEnabled = false

        // Let the loaded image 3 render before zooming, then move to Lost.
        binding.draw.postDelayed({
            if (isFinishing || isDestroyed) return@postDelayed
            val mouthPivotX = binding.draw.width * MOUTH_PIVOT_X
            val mouthPivotY = binding.draw.height * MOUTH_PIVOT_Y
            binding.draw.pivotX = mouthPivotX
            binding.draw.pivotY = mouthPivotY
            binding.draw.animate()
                .translationX(binding.draw.width / 2f - mouthPivotX)
                .translationY(binding.draw.height / 2f - mouthPivotY)
                .scaleX(1.8f)
                .scaleY(1.8f)
                .setDuration(850L)
                .withEndAction {
                    binding.lostFadeOverlay.apply {
                        alpha = 0f
                        visibility = View.VISIBLE
                        bringToFront()
                    }
                    binding.lostFadeOverlay.animate()
                        .alpha(1f)
                        .setDuration(450L)
                        .withEndAction {
                            if (!isFinishing && !isDestroyed) {
                                openActivity(
                                    LostActivity::class.java,
                                    android.os.Bundle().apply {
                                        putInt(LostActivity.EXTRA_SCORE, score)
                                        putInt(LostActivity.EXTRA_SELECTED_CAT, selectedCat)
                                    },
                                    finishCurrent = true
                                )
                            }
                        }
                        .start()
                }
                .start()
        }, 120L)
    }

    private fun showCatStage(stage: CatStage, score: Int) {
        if (stage.isBreathing) {
            startBreathingAnimation()
        } else {
            stopBreathingAnimation()
        }
        playSound(stage.audioPath)

        // Load into a detached target first. Loading directly into the ImageView
        // clears its current drawable immediately and causes a blank frame while
        // switching between stage 1, 2 and 3.
        catImageTarget?.let { Glide.with(this).clear(it) }
        catImageTarget = object : CustomTarget<Drawable>() {
            override fun onResourceReady(
                resource: Drawable,
                transition: Transition<in Drawable>?
            ) {
                if (viewModel.uiState.value.stage == stage && !isFinishing && !isDestroyed) {
                    binding.draw.setImageDrawable(resource)
                    when (stage) {
                        CatStage.REACTING -> viewModel.onReactionImageShown()
                        CatStage.LOST -> showLostAnimation(score)
                        CatStage.NORMAL -> Unit
                    }
                }
            }

            override fun onLoadCleared(placeholder: Drawable?) = Unit
        }.also { target ->
            Glide.with(this)
                .load("file:///android_asset/listcat/cat$selectedCat/${stage.imageNumber}.webp")
                .into(target)
        }
    }

    private fun startBreathingAnimation() {
        if (breathingAnimator?.isRunning == true) return
        binding.draw.post {
            if (viewModel.uiState.value.stage != CatStage.NORMAL || isFinishing || isDestroyed) {
                return@post
            }
            // Anchor the image at its bottom edge so it only stretches upward.
            binding.draw.pivotX = binding.draw.width / 2f
            binding.draw.pivotY = binding.draw.height.toFloat()
            val scaleY = ObjectAnimator.ofFloat(
                binding.draw,
                View.SCALE_Y,
                1f,
                BREATH_MAX_SCALE_Y
            ).apply {
                duration = BREATH_DURATION_MS
                repeatMode = ObjectAnimator.REVERSE
                repeatCount = ObjectAnimator.INFINITE
            }
            breathingAnimator = AnimatorSet().apply {
                play(scaleY)
                start()
            }
        }
    }

    private fun stopBreathingAnimation() {
        breathingAnimator?.cancel()
        breathingAnimator = null
        binding.draw.scaleX = 1f
        binding.draw.scaleY = 1f
    }

    private fun playSound(audioPath: String) {
        // Keep an already playing or still-preparing sound. In particular,
        // brush events arrive continuously while the looped brush sound loads.
        if (currentAudioPath == audioPath && stageSoundPlayer != null) return
        stageSoundPlayer?.let { player -> runCatching { player.release() } }
        stageSoundPlayer = null
        currentAudioPath = null

        var newPlayer: MediaPlayer? = null
        runCatching {
            assets.openFd(audioPath).use { audio ->
                MediaPlayer().also { player ->
                    newPlayer = player
                    stageSoundPlayer = player
                    currentAudioPath = audioPath
                    player.isLooping = audioPath == CatStage.NORMAL.audioPath ||
                        audioPath == BRUSH_SOUND_PATH
                    player.setOnPreparedListener { prepared ->
                        if (stageSoundPlayer === prepared && currentAudioPath == audioPath &&
                            !isFinishing && !isDestroyed
                        ) {
                            runCatching { prepared.start() }
                                .onFailure { error ->
                                    Log.e("CatPlayActivity", "Unable to start sound: $audioPath", error)
                                    if (stageSoundPlayer === prepared) {
                                        stageSoundPlayer = null
                                        currentAudioPath = null
                                    }
                                    runCatching { prepared.release() }
                                }
                        }
                    }
                    player.setOnCompletionListener { completed ->
                        completed.release()
                        if (stageSoundPlayer === completed) {
                            stageSoundPlayer = null
                            currentAudioPath = null
                        }
                    }
                    player.setOnErrorListener { failed, _, _ ->
                        failed.release()
                        if (stageSoundPlayer === failed) {
                            stageSoundPlayer = null
                            currentAudioPath = null
                        }
                        true
                    }
                    player.setDataSource(audio.fileDescriptor, audio.startOffset, audio.length)
                    player.prepareAsync()
                }
            }
        }.onFailure { error ->
            newPlayer?.let { player ->
                if (stageSoundPlayer === player) {
                    stageSoundPlayer = null
                    currentAudioPath = null
                }
                runCatching { player.release() }
            }
            Log.e("CatPlayActivity", "Unable to play cat sound: $audioPath", error)
        }
    }

    private fun releaseStageSound() {
        stageSoundPlayer?.let { player -> runCatching { player.release() } }
        stageSoundPlayer = null
        currentAudioPath = null
    }

    override fun onPause() {
        binding.root.removeCallbacks(stopBrushSound)
        releaseStageSound()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        updateStatusBarIconTheme()
        if (pendingCameraPermissionRequest) {
            if (!hasCameraPermission()) viewModel.onCameraPermissionResult(granted = false)
            pendingCameraPermissionRequest = false
        }
        if (!hasCameraPermission() && (isCameraEnabled || isCameraStarting)) {
            stopCameraPreview()
        }
        if (hasCameraPermission()) viewModel.onCameraPermissionResult(granted = true)
        val state = viewModel.uiState.value
        if (state.stage != CatStage.LOST) {
            playSound(state.stage.audioPath)
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) updateStatusBarIconTheme()
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode != RequestKey.CAMERA_PERMISSION_CODE) return

        val requestWasPending = pendingCameraPermissionRequest
        pendingCameraPermissionRequest = false
        val granted = grantResults.isNotEmpty() &&
            grantResults.all { it == PackageManager.PERMISSION_GRANTED }

        if (granted) {
            viewModel.onCameraPermissionResult(granted = true)
            startCameraPreview()
        } else {
            if (requestWasPending) viewModel.onCameraPermissionResult(granted = false)
            stopCameraPreview()
        }
    }

    private fun startCameraPreview() {
        if (isCameraStarting || isCameraEnabled) return
        if (!hasCameraPermission()) {
            stopCameraPreview()
            return
        }
        isCameraStarting = true
        binding.btnActionBarRight.isEnabled = false
        val providerFuture = ProcessCameraProvider.getInstance(this)
        providerFuture.addListener({
            if (isFinishing || isDestroyed) {
                isCameraStarting = false
                return@addListener
            }
            if (!hasCameraPermission()) {
                stopCameraPreview()
                return@addListener
            }

            runCatching {
                val provider = providerFuture.get()
                check(packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)) {
                    "No front camera is available"
                }
                val preview = Preview.Builder().build().also {
                    it.surfaceProvider = binding.previewView.surfaceProvider
                }
                val selector = CameraSelector.DEFAULT_FRONT_CAMERA
                check(provider.hasCamera(selector)) { "No front camera is available" }

                provider.unbindAll()
                provider.bindToLifecycle(this, selector, preview)
                cameraProvider = provider
                isCameraEnabled = true
                binding.previewView.isVisible = true
                binding.btnActionBarRight.setImageResource(R.drawable.ic_camera_on)
            }.onFailure { error ->
                Log.e("CatPlayActivity", "Unable to start camera preview", error)
                showToast(R.string.camera_unavailable)
            }
            isCameraStarting = false
            binding.btnActionBarRight.isEnabled = true
        }, ContextCompat.getMainExecutor(this))
    }

    override fun onDestroy() {
        binding.root.removeCallbacks(stopBrushSound)
        stopBreathingAnimation()
        releaseStageSound()
        catImageTarget?.let { Glide.with(applicationContext).clear(it) }
        catImageTarget = null
        binding.draw.animate().cancel()
        cameraProvider?.unbindAll()
        cameraProvider = null
        super.onDestroy()
    }

    override fun observeData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    binding.txtScore.text = state.score.toString()
                    if (renderedCatStage != state.stage) {
                        renderedCatStage = state.stage
                        showCatStage(state.stage, state.score)
                    }
                }
            }
        }
    }

    override fun bindViewModel() = Unit

    companion object {
        private const val BREATH_DURATION_MS = 1_350L
        private const val BREATH_MAX_SCALE_Y = 1.035f
        private const val BRUSH_SOUND_PATH = "audio_extracted/audio04.mp3"
        private const val BRUSH_SOUND_IDLE_DELAY_MS = 220L
        private const val MOUTH_PIVOT_X = 0.55f
        private const val MOUTH_PIVOT_Y = 0.47f
    }

    private fun dp(value: Int) = (value * resources.displayMetrics.density).toInt()
}
