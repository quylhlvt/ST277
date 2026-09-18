package com.duomaker.couplelove.vatar.ui.main.random

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.lifecycleScope
import com.duomaker.couplelove.vatar.R
import com.duomaker.couplelove.vatar.core.base.BaseActivity
import com.duomaker.couplelove.vatar.core.extention.InternetExtension.isInternetAvailable
import com.duomaker.couplelove.vatar.core.extention.InternetExtension.isNetworkConnected
import com.duomaker.couplelove.vatar.core.extention.gone
import com.duomaker.couplelove.vatar.core.extention.onClick
import com.duomaker.couplelove.vatar.core.extention.setImageActionBar
import com.duomaker.couplelove.vatar.core.extention.visible
import com.duomaker.couplelove.vatar.databinding.ActivityRandomBinding
import com.duomaker.couplelove.vatar.ui.main.customize.CustomizeActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.duomaker.couplelove.vatar.core.extention.setTextActionBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull

@AndroidEntryPoint
class RandomActivity : BaseActivity<ActivityRandomBinding, RandomViewModel>(
    ActivityRandomBinding::inflate, RandomViewModel::class.java
) {
    companion object {
        private const val RENDER_SIZE = 800
        private const val RENDER_TIMEOUT_MS = 15_000L
    }

    private var renderJob: Job? = null
    /** Random generation is started only after the user presses Random. */
    private var randomRequested = false

    private fun hasUsableNetwork(): Boolean {
        return isNetworkConnected(this@RandomActivity) &&
            isInternetAvailable(this@RandomActivity)
    }

    private fun checkOnlineNetworkOrShowDialog(templateId: String): Boolean {
        if (!templateId.startsWith("online_") || hasUsableNetwork()) return false
        showUnstableNetworkDialog()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBackPressHandler()
    }

    private fun setupBackPressHandler() {
        this@RandomActivity.onBackPressedDispatcher.addCallback(
            this@RandomActivity, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    finish()
                }
            })
    }

    override fun setupPreViews() {
        super.setupPreViews()
        // Show the actual GIF as soon as its first frame is decoded. Give it
        // priority so random layer requests cannot starve the animation.
        binding.imageGif.visible()
        Glide.with(binding.imageGif)
            .asGif()
            .load(R.drawable.gif)
            .priority(Priority.IMMEDIATE)
            .into(binding.imageGif)
    }

    override fun initView() {
        binding.imvImage.gone()
        binding.setupActionBar()
        // Start in the loading state. The first random result is requested as
        // soon as the template data is ready (see observeData()).
        randomRequested = true
        binding.btnEdit.visible()
        showLoading()
        binding.txtRandom.isSelected = true
        binding.txtEdit.isSelected = true
    }

    private fun ActivityRandomBinding.setupActionBar() {
        actionBar.apply {
            setImageActionBar(btnActionBarLeft, R.drawable.back_app)
            setTextActionBar(tvCenter, getString(R.string.random))

            setEditActionBarEnabled(false)
        }
    }

    override fun viewListener() {
        binding.apply {
            actionBar.btnActionBarLeft.onClick {
                finish()

            }
            btnRandom.onClick {
                randomRequested = true
                // Hiện nút Edit ngay khi bắt đầu random, nhưng khóa cho tới
                // khi ảnh đã render xong.
                btnEdit.visible()
                setEditActionBarEnabled(false)
                requestRandomCharacter()
            }
            btnEdit.onClick {
                if (!btnEdit.isEnabled) return@onClick
                val item = viewModel.randomItem.value ?: return@onClick
                if (checkOnlineNetworkOrShowDialog(item.template.id)) return@onClick
                val templateIndex = appSession.templates.value.indexOfFirst { it.id == item.template.id }
                if (templateIndex < 0) return@onClick
                openActivity(
                    CustomizeActivity::class.java,
                    CustomizeActivity.newArgs(
                        templateIndex = templateIndex,
                        templateId = item.template.id,
                        isEdit = false,
                        savedSelections = item.selections
                    )
                )
            }
        }
    }

    private fun requestRandomCharacter() {
        val hasNetwork = hasUsableNetwork()
        // The old render may still finish while the new random item is being
        // generated. It must not be allowed to repopulate the image view/cache.
        renderJob?.cancel()
        renderJob = null
        val started = viewModel.randomize(isOnline = hasNetwork)
        if (started) {
            showLoading()
            return
        }

        setControlsEnabled(
            canEdit = false,
            canRandom = true
        )
        if (hasNetwork) showLoadingDataDialog() else showUnstableNetworkDialog()
    }

    override fun observeData() {
        this@RandomActivity.lifecycleScope.launch {
            viewModel.isDataReady.collect { ready ->
                // Do not randomize automatically on entering from Home. If the
                // user tapped Random before data finished loading, continue the
                // requested action once templates become available.
                if (ready && randomRequested && viewModel.randomItem.value == null) {
                    requestRandomCharacter()
                }
            }
        }
        this@RandomActivity.lifecycleScope.launch {
            viewModel.randomItem.collectLatest { item ->
                if (!randomRequested) return@collectLatest
                item ?: return@collectLatest

                // ✅ Nếu đã có cache bitmap thì không render lại
                val cached = cachedBitmapFor(item)
                if (cached != null) {
                    showBitmap(cached)
                    return@collectLatest
                }

                renderCharacter(item)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // ✅ Khi back về: dùng lại bitmap đã cache
        if (!randomRequested) return
        val cached = viewModel.randomItem.value?.let(::cachedBitmapFor)
        if (cached != null) {
            showBitmap(cached)
        }
    }

    private fun cachedBitmapFor(item: RandomViewModel.RandomItem): Bitmap? {
        return viewModel.cachedBitmap?.takeIf {
            viewModel.cachedGeneration == item.generation && !it.isRecycled
        }
    }

    private fun renderCharacter(item: RandomViewModel.RandomItem) {
        renderJob?.cancel()
        renderJob = this@RandomActivity.lifecycleScope.launch {
            val paths = item.resolvedPaths.filterNotNull()
            if (paths.isEmpty()) {
                showRenderFailure(showNetworkDialog = false)
                return@launch
            }
            showLoading()

            val loaded = withTimeoutOrNull(RENDER_TIMEOUT_MS) {
                withContext(Dispatchers.IO) {
                    coroutineScope {
                        paths.map { path ->
                            async {
                                try {
                                    Glide.with(this@RandomActivity).asBitmap().load(path)
                                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                                        .override(RENDER_SIZE)
                                        .submit()
                                        .get()
                                } catch (error: CancellationException) {
                                    throw error
                                } catch (_: Exception) {
                                    null
                                }
                            }
                        }.awaitAll()
                    }
                }
            }
            if (!isActive) return@launch

            val bitmaps = loaded?.filterNotNull().orEmpty()
            if (bitmaps.size != paths.size) {
                showRenderFailure(showNetworkDialog = !hasUsableNetwork())
                return@launch
            }

            val merged = withContext(Dispatchers.Default) { mergeBitmaps(bitmaps) }
            if (!isActive ||
                !viewModel.isCurrentGeneration(item.generation) ||
                viewModel.randomItem.value != item
            ) {
                merged.recycle()
                return@launch
            }

            viewModel.setCachedBitmap(merged, item.generation)
            showBitmap(merged)
        }
    }

    private fun showRenderFailure(showNetworkDialog: Boolean) {
        binding.contrainFirst.gone()
        binding.imvImage.apply {
            setImageDrawable(null)
            gone()
        }
        binding.imageGif.visible()
        setControlsEnabled(canEdit = false, canRandom = true)
        if (showNetworkDialog) showUnstableNetworkDialog()
    }

    private fun showLoading() {
        binding.contrainFirst.gone()
        binding.imvImage.apply {
            setImageDrawable(null)
            gone()
        }
        binding.imageGif.visible()
        setControlsEnabled(canEdit = false, canRandom = false)
    }

    private fun showBitmap(bitmap: Bitmap) {
        binding.contrainFirst.gone()
        binding.imvImage.apply {
            scaleType = ImageView.ScaleType.CENTER_CROP
            setImageBitmap(bitmap)
            visible()
        }
        binding.imageGif.gone()
        setControlsEnabled(canEdit = true, canRandom = true)
    }

    private fun setControlsEnabled(canEdit: Boolean, canRandom: Boolean) {
        setEditActionBarEnabled(canEdit)
        binding.btnRandom.isEnabled = canRandom
        binding.btnRandom.isClickable = canRandom
        binding.btnRandom.alpha = if (canRandom) 1f else 0.5f
    }

    private fun setEditActionBarEnabled(enabled: Boolean) {
        binding.btnEdit.isEnabled = enabled
        binding.btnEdit.isClickable = enabled
        binding.btnEdit.alpha = if (enabled) 1f else 0.5f
    }

    private fun mergeBitmaps(bitmaps: List<Bitmap>): Bitmap {
        val merged = Bitmap.createBitmap(RENDER_SIZE, RENDER_SIZE, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(merged)
        bitmaps.forEach { bmp ->
            val scaled = if (bmp.width == RENDER_SIZE && bmp.height == RENDER_SIZE) bmp
            else Bitmap.createScaledBitmap(bmp, RENDER_SIZE, RENDER_SIZE, true)
            canvas.drawBitmap(scaled, 0f, 0f, null)
            if (scaled != bmp) scaled.recycle()
        }
        return merged
    }

    override fun onDestroy() {
        renderJob?.cancel()
        renderJob = null
        super.onDestroy()
    }

    override fun bindViewModel() {}
}
