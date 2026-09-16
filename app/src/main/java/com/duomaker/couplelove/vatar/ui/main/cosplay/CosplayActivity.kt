package com.duomaker.couplelove.vatar.ui.main.cosplay

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.text.SpannableString
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.duomaker.couplelove.vatar.R
import com.duomaker.couplelove.vatar.core.base.BaseActivity
import com.duomaker.couplelove.vatar.core.extention.InternetExtension
import com.duomaker.couplelove.vatar.core.extention.InternetExtension.isInternetAvailable
import com.duomaker.couplelove.vatar.core.extention.InternetExtension.isNetworkConnected
import com.duomaker.couplelove.vatar.core.extention.changeText
import com.duomaker.couplelove.vatar.core.extention.gone
import com.duomaker.couplelove.vatar.core.extention.onClick
import com.duomaker.couplelove.vatar.core.extention.select
import com.duomaker.couplelove.vatar.core.extention.setImageActionBar
import com.duomaker.couplelove.vatar.core.extention.setTextActionBar
import com.duomaker.couplelove.vatar.core.extention.visible
import com.duomaker.couplelove.vatar.databinding.ActivityCosplayBinding
import com.duomaker.couplelove.vatar.ui.main.show.ShowActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class CosplayActivity : BaseActivity<ActivityCosplayBinding, CosplayViewModel>(
    ActivityCosplayBinding::inflate,
    CosplayViewModel::class.java
) {
    private var renderJob: Job? = null

    companion object {
        const val EXTRA_START_CHALLENGE = "start_challenge"
        private const val STATE_START_CHALLENGE = "pending_challenge"
        private const val MISSING_LAYER_RETRY_DELAY_MS = 700L
        private const val NETWORK_RECHECK_DELAY_MS = 500L
    }
    private var startChallengeWhenReady = false
    private var randomRequestPending = false

    private fun hasUsableNetwork(): Boolean {
        return isNetworkConnected(this@CosplayActivity) &&
            isInternetAvailable(this@CosplayActivity)
    }

    private fun requestRandomCharacter(isOnline: Boolean): Boolean {
        if (randomRequestPending) return true

        val started = viewModel.randomize(isOnline = isOnline)
        if (!started) {
            val currentItem = viewModel.randomItem.value
            setControlsEnabled(
                canShow = currentItem?.let(::cachedBitmapFor) != null,
                canRandom = true
            )
            if (isOnline) showLoadingDataDialog() else showUnstableNetworkDialog()
            return false
        }

        randomRequestPending = true
        renderJob?.cancel()
        renderJob = null
        showLoading()
        return true
    }

    private fun startChallenge() {
        val item = viewModel.randomItem.value ?: return
        val bitmap = cachedBitmapFor(item) ?: return
        if (bitmap.isRecycled || checkOnlineNetworkOrShowDialog(item.template.id)) return
        startChallengeWhenReady = false
        appSession.cosplayBitmap = bitmap
        openActivity(
            ShowActivity::class.java,
            ShowActivity.newArgshow(item.templateIndex, item.selections, item.template.id)
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(STATE_START_CHALLENGE, startChallengeWhenReady)
        super.onSaveInstanceState(outState)
    }

    private fun checkOnlineNetworkOrShowDialog(templateId: String): Boolean {
        if (!templateId.startsWith("online_")) return false
        return when {
            !InternetExtension.isInternetAvailable(this@CosplayActivity) -> {
                showUnstableNetworkDialog(); true
            }

            !InternetExtension.isNetworkConnected(this@CosplayActivity) -> {
                showUnstableNetworkDialog(); true
            }

            else -> false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startChallengeWhenReady = savedInstanceState?.getBoolean(STATE_START_CHALLENGE) ?: false
        setupBackPressHandler()
    }

    private fun setupBackPressHandler() {
        this@CosplayActivity.onBackPressedDispatcher.addCallback(
            this@CosplayActivity,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    finish()
                }
            }
        )
    }

    override fun setupPreViews() {
        super.setupPreViews()
        Glide.with(binding.imageGif).asGif().load(R.drawable.gif).into(binding.imageGif)
    }
    override fun initView() {
        binding.imvImage.gone()
        binding.imageGif.visible()
        binding.setupActionBar()
        setShowButtonEnabled(false)
        binding.txtRandom.isSelected = true
        binding.txtShow.isSelected = true

        // Chỉ randomize lần đầu, nếu chưa có item nào
//        if (viewModel.randomItem.value == null) {
//            viewModel.randomize()
//        }
    }

    private fun ActivityCosplayBinding.setupActionBar() {
        actionBar.apply {
//            tvCenter.select()
            setImageActionBar(btnActionBarLeft, R.drawable.back_app)
            setImageActionBar(btnActionBarRight, R.drawable.guid)
//            setTextActionBar(tvCenter, getString(R.string.cosplay))
        }
    }

    override fun viewListener() {
        binding.apply {

            actionBar.btnActionBarLeft.onClick { finish() }

            random.onClick {
                requestRandomCharacter(isOnline = hasUsableNetwork())
            }
            actionBar.btnActionBarRight.onClick {
                showGuide.visible()
            }
            closeGuide.onClick {
                showGuide.gone()
            }
            show.onClick {
                if (!show.isEnabled) return@onClick
                val item = viewModel.randomItem.value ?: return@onClick
                if (checkOnlineNetworkOrShowDialog(item.template.id)) return@onClick
                val cached = cachedBitmapFor(item)
                if (cached != null) {
                    appSession.cosplayBitmap = cached
                }
                val args = ShowActivity.newArgshow(
                    templateIndex = item.templateIndex,
                    targetSelections = item.selections,
                    templateId = item.template.id
                )
                openActivity(ShowActivity::class.java, args)
            }
        }
    }

    override fun observeData() {
        this@CosplayActivity.lifecycleScope.launch {
            viewModel.isDataReady.collect { ready ->
                if (ready && viewModel.randomItem.value == null) {
                    requestRandomCharacter(isOnline = hasUsableNetwork())
                }
            }
        }
        this@CosplayActivity.lifecycleScope.launch {
            viewModel.randomItem.collectLatest { item ->
                item ?: return@collectLatest
                randomRequestPending = false

                // ✅ Nếu đã có cache bitmap thì không render lại
                val cached = cachedBitmapFor(item)
                if (cached != null) {
                    showBitmap(cached)
                    return@collectLatest
                }

                renderCharacter(item)
            }
        }
        this@CosplayActivity.lifecycleScope.launch {
            appSession.networkOnline.collectLatest { online ->
                if (online &&
                    viewModel.isDataReady.value &&
                    viewModel.randomItem.value == null &&
                    !randomRequestPending
                ) {
                    // If the screen was opened offline and no item could be
                    // selected, start automatically as soon as network returns.
                    requestRandomCharacter(isOnline = true)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (intent.getBooleanExtra(EXTRA_START_CHALLENGE, false)) {
            intent.removeExtra(EXTRA_START_CHALLENGE)
            startChallengeWhenReady = true
            if (!requestRandomCharacter(isOnline = hasUsableNetwork())) {
                startChallengeWhenReady = false
            }
            return
        }
        // ✅ Guard: chỉ access viewModel khi fragment đã attach xong
        if (isFinishing || isDestroyed) return

        val cached = viewModel.randomItem.value?.let(::cachedBitmapFor)
        if (cached != null) {
            showBitmap(cached)
        }
    }

    private fun cachedBitmapFor(item: CosplayViewModel.RandomItem): Bitmap? {
        return viewModel.cachedBitmap?.takeIf {
            viewModel.cachedGeneration == item.generation && !it.isRecycled
        }
    }

    private fun renderCharacter(item: CosplayViewModel.RandomItem) {
        renderJob?.cancel()
        setShowButtonEnabled(false)
        renderJob = this@CosplayActivity.lifecycleScope.launch {
            val paths = item.resolvedPaths.filterNotNull()
            if (paths.isEmpty()) return@launch
            showLoading()

            var networkDialogShown = false
            val loadedBitmaps = MutableList<Bitmap?>(paths.size) { null }

            while (isActive &&
                viewModel.isCurrentGeneration(item.generation) &&
                viewModel.randomItem.value == item
            ) {
                val missingIndices = loadedBitmaps.indices.filter { loadedBitmaps[it] == null }
                if (missingIndices.isEmpty()) break

                val loaded = withContext(Dispatchers.IO) {
                    coroutineScope {
                        missingIndices.map { index ->
                            async {
                                val bitmap = try {
                                    Glide.with(this@CosplayActivity).asBitmap().load(paths[index])
                                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                                        .override(512).submit().get()
                                } catch (error: CancellationException) {
                                    throw error
                                } catch (_: Exception) {
                                    null
                                }
                                index to bitmap
                            }
                        }.awaitAll()
                    }
                }
                loaded.forEach { (index, bitmap) ->
                    if (bitmap != null) loadedBitmaps[index] = bitmap
                }
                if (loadedBitmaps.all { it != null }) break

                if (!hasUsableNetwork()) {
                    if (!networkDialogShown) {
                        showUnstableNetworkDialog()
                        networkDialogShown = true
                    }

                    // Keep the same selections and all successfully loaded
                    // layers. Resume only the missing paths when network returns.
                    while (isActive &&
                        viewModel.isCurrentGeneration(item.generation) &&
                        viewModel.randomItem.value == item &&
                        !hasUsableNetwork()
                    ) {
                        appSession.networkOnline.filter { it }.first()
                        if (!hasUsableNetwork()) delay(NETWORK_RECHECK_DELAY_MS)
                    }
                } else {
                    delay(MISSING_LAYER_RETRY_DELAY_MS)
                }
            }

            if (!isActive ||
                !viewModel.isCurrentGeneration(item.generation) ||
                viewModel.randomItem.value != item
            ) return@launch

            val bitmaps = loadedBitmaps.map { it ?: return@launch }

            val merged = mergeBitmaps(bitmaps)

            if (!isActive ||
                !viewModel.isCurrentGeneration(item.generation) ||
                viewModel.randomItem.value != item
            ) {
                merged.recycle()
                return@launch
            }

            // ✅ Lưu vào cache
            viewModel.setCachedBitmap(merged, item.generation)

            withContext(Dispatchers.Main) {
                showBitmap(merged)
            }
        }
    }

    private fun showLoading() {
        binding.imvImage.apply {
            setImageDrawable(null)
            gone()
        }
        binding.imageGif.visible()
        setShowButtonEnabled(false)
    }

    private fun showBitmap(bitmap: Bitmap) {
        binding.imvImage.apply {
            scaleType = ImageView.ScaleType.CENTER_CROP
            setImageBitmap(bitmap)
            visible()
        }
        binding.imageGif.gone()
        setShowButtonEnabled(true)
        binding.root.post {
            if (startChallengeWhenReady && lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
                startChallenge()
            }
        }
    }

    private fun setShowButtonEnabled(enabled: Boolean) {
        setControlsEnabled(canShow = enabled, canRandom = enabled)
    }

    private fun setControlsEnabled(canShow: Boolean, canRandom: Boolean) {
        binding.show.isEnabled = canShow
        binding.show.isClickable = canShow
        binding.show.alpha = if (canShow) 1f else 0.5f
        binding.random.isEnabled = canRandom
        binding.random.isClickable = canRandom
        binding.random.alpha = if (canRandom) 1f else 0.5f
    }

    private fun mergeBitmaps(bitmaps: List<Bitmap>): Bitmap {
        val size = 512
        val merged = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(merged)
        bitmaps.forEach { bmp ->
            val scaled = if (bmp.width == size && bmp.height == size) bmp
            else Bitmap.createScaledBitmap(bmp, size, size, true)
            canvas.drawBitmap(scaled, 0f, 0f, null)
            if (scaled != bmp) scaled.recycle()
        }
        return merged
    }

    override fun bindViewModel() {}
}
