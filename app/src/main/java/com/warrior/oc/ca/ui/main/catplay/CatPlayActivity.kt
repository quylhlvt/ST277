package com.warrior.oc.ca.ui.main.catplay

import android.Manifest
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.pm.PackageManager
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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.warrior.oc.ca.R
import com.warrior.oc.ca.core.base.BaseActivity
import com.warrior.oc.ca.core.extention.onClick
import com.warrior.oc.ca.core.extention.setImageActionBar
import com.warrior.oc.ca.databinding.ActivityCatPlayBinding
import com.warrior.oc.ca.ui.main.listcat.ListCatActivity
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
    private var cameraProvider: ProcessCameraProvider? = null
    private val selectedCat by lazy {
        intent.getIntExtra(ListCatActivity.EXTRA_SELECTED_CAT, 1).coerceIn(1, 5)
    }
    private var lastTouchX = 0f
    private var lastTouchY = 0f
    private var renderedCatStage: CatStage? = null
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
            txtScore.text = viewModel.uiState.value.score.toString()
            comb.bringToFront()
        }
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            finish()
            return
        }
        if (!packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)) {
            showToast(R.string.camera_unavailable)
            finish()
            return
        }
        startCameraPreview()
    }

    override fun viewListener() {
        binding.btnActionBarLeft.onClick { finish() }
        binding.gameArea.setOnTouchListener(::onGameAreaTouch)
    }

    private fun onGameAreaTouch(view: View, event: MotionEvent): Boolean {
        if (viewModel.uiState.value.stage == CatStage.LOST) return false
        val comb = binding.comb
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                moveCombTo(event.x, event.y)
                lastTouchX = event.x
                lastTouchY = event.y
                view.parent.requestDisallowInterceptTouchEvent(true)
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                val moved = hypot(event.x - lastTouchX, event.y - lastTouchY)
                moveCombTo(event.x, event.y)
                if (moved > 0f && isCombOverCat(comb)) {
                    binding.root.removeCallbacks(stopBrushSound)
                    playSound(BRUSH_SOUND_PATH)
                    binding.root.postDelayed(stopBrushSound, BRUSH_SOUND_IDLE_DELAY_MS)
                    val furCount = viewModel.onBrush(moved, resources.displayMetrics.density)
                    repeat(furCount) { createFallingFur() }
                }

                lastTouchX = event.x
                lastTouchY = event.y
                return true
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
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
        binding.comb.isEnabled = false

        // Show the final reaction, then move to the native Lost screen.
        binding.draw.postDelayed({
            if (isFinishing || isDestroyed) return@postDelayed
            binding.draw.animate()
                .scaleX(1.8f)
                .scaleY(1.8f)
                .setDuration(850L)
                .withEndAction {
                    openActivity(
                        LostActivity::class.java,
                        android.os.Bundle().apply {
                            putInt(LostActivity.EXTRA_SCORE, score)
                            putInt(LostActivity.EXTRA_SELECTED_CAT, selectedCat)
                        },
                        finishCurrent = true
                    )
                }
                .start()
        }, 120L)
    }

    private fun showCatStage(stage: CatStage) {
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
        if (currentAudioPath == audioPath && stageSoundPlayer?.isPlaying == true) return
        stageSoundPlayer?.release()
        stageSoundPlayer = null
        currentAudioPath = null

        runCatching {
            assets.openFd(audioPath).use { audio ->
                MediaPlayer().apply {
                    setDataSource(audio.fileDescriptor, audio.startOffset, audio.length)
                    isLooping = audioPath == CatStage.NORMAL.audioPath ||
                        audioPath == BRUSH_SOUND_PATH
                    setOnCompletionListener { player ->
                        player.release()
                        if (stageSoundPlayer === player) {
                            stageSoundPlayer = null
                            currentAudioPath = null
                        }
                    }
                    setOnErrorListener { player, _, _ ->
                        player.release()
                        if (stageSoundPlayer === player) {
                            stageSoundPlayer = null
                            currentAudioPath = null
                        }
                        true
                    }
                    prepare()
                    start()
                    stageSoundPlayer = this
                    currentAudioPath = audioPath
                }
            }
        }.onFailure { error ->
            Log.e("CatPlayActivity", "Unable to play cat sound: $audioPath", error)
        }
    }

    private fun startCameraPreview() {
        val providerFuture = ProcessCameraProvider.getInstance(this)
        providerFuture.addListener({
            if (isFinishing || isDestroyed) return@addListener

            runCatching {
                val provider = providerFuture.get()
                val preview = Preview.Builder().build().also {
                    it.surfaceProvider = binding.previewView.surfaceProvider
                }
                val selector = CameraSelector.DEFAULT_FRONT_CAMERA
                check(provider.hasCamera(selector)) { "No front camera is available" }

                provider.unbindAll()
                provider.bindToLifecycle(this, selector, preview)
                cameraProvider = provider
            }.onFailure { error ->
                Log.e("CatPlayActivity", "Unable to start camera preview", error)
                showToast(R.string.camera_unavailable)
                finish()
            }
        }, ContextCompat.getMainExecutor(this))
    }

    override fun onDestroy() {
        binding.root.removeCallbacks(stopBrushSound)
        stopBreathingAnimation()
        stageSoundPlayer?.release()
        stageSoundPlayer = null
        currentAudioPath = null
        catImageTarget?.let { Glide.with(this).clear(it) }
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
                        showCatStage(state.stage)
                        if (state.stage == CatStage.LOST) showLostAnimation(state.score)
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
    }

    private fun dp(value: Int) = (value * resources.displayMetrics.density).toInt()
}
