package com.anime.oc.characters.avatar.ui.main.random

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.lifecycleScope
import com.anime.oc.characters.avatar.R
import com.anime.oc.characters.avatar.core.base.BaseActivity
import com.anime.oc.characters.avatar.core.extention.InternetExtension.isInternetAvailable
import com.anime.oc.characters.avatar.core.extention.InternetExtension.isNetworkConnected
import com.anime.oc.characters.avatar.core.extention.gone
import com.anime.oc.characters.avatar.core.extention.onClick
import com.anime.oc.characters.avatar.core.extention.select
import com.anime.oc.characters.avatar.core.extention.setImageActionBar
import com.anime.oc.characters.avatar.core.extention.visible
import com.anime.oc.characters.avatar.databinding.ActivityRandomBinding
import com.anime.oc.characters.avatar.ui.main.customize.CustomizeActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
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
        Glide.with(binding.imageGif).asGif().load(R.drawable.gif).into(binding.imageGif)
    }

    override fun initView() {
        binding.imvImage.gone()
        binding.imageGif.visible()
        setControlsEnabled(canEdit = false, canRandom = false)
        binding.setupActionBar()
        binding.txtRandom.isSelected = true
        binding.txtEdit.isSelected = true
    }

    private fun ActivityRandomBinding.setupActionBar() {
        actionBar.apply {
            tvCenter.select()
            setImageActionBar(btnActionBarLeft, R.drawable.back_app)
//            setTextActionBar(tvCenter, getString(R.string.random))
        }
    }

    override fun viewListener() {
        binding.apply {
            actionBar.btnActionBarLeft.onClick {
                finish()

            }
            random.onClick {
                requestRandomCharacter()
            }
            btnEdit.onClick {
                if (!btnEdit.isEnabled) return@onClick
                val item = viewModel.randomItem.value ?: return@onClick
                if (checkOnlineNetworkOrShowDialog(item.template.id)) return@onClick

                // Online refreshes can reorder the template list. Resolve the
                // live index from the stable id before opening Customize.
                val templateIndex = appSession.templates.value
                    .indexOfFirst { it.id == item.template.id }
                if (templateIndex < 0) {
                    showLoadingDataDialog()
                    return@onClick
                }
                val args = CustomizeActivity.newArgs(
                    templateIndex = templateIndex,
                    templateId = item.template.id,
                    isEdit = false,
                    savedSelections = item.selections
                )
                openActivity(CustomizeActivity::class.java, args)

            }
        }
    }

    private fun requestRandomCharacter() {
        val hasNetwork = hasUsableNetwork()
        val started = viewModel.randomize(isOnline = hasNetwork)
        if (started) {
            showLoading()
            return
        }

        val cached = viewModel.cachedBitmap
        setControlsEnabled(
            canEdit = cached != null && !cached.isRecycled,
            canRandom = true
        )
        if (hasNetwork) showLoadingDataDialog() else showUnstableNetworkDialog()
    }

    override fun observeData() {
        this@RandomActivity.lifecycleScope.launch {
            viewModel.isDataReady.collect { ready ->
                if (ready && viewModel.randomItem.value == null) {
                    requestRandomCharacter()
                }
            }
        }
        this@RandomActivity.lifecycleScope.launch {
            viewModel.randomItem.collectLatest { item ->
                item ?: return@collectLatest

                // ✅ Nếu đã có cache bitmap thì không render lại
                val cached = viewModel.cachedBitmap
                if (cached != null && !cached.isRecycled) {
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
        val cached = viewModel.cachedBitmap
        if (cached != null && !cached.isRecycled) {
            showBitmap(cached)
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
            if (!isActive || viewModel.randomItem.value != item) {
                merged.recycle()
                return@launch
            }

            viewModel.setCachedBitmap(merged)
            showBitmap(merged)
        }
    }

    private fun showRenderFailure(showNetworkDialog: Boolean) {
        binding.imvImage.apply {
            setImageDrawable(null)
            gone()
        }
        binding.imageGif.visible()
        setControlsEnabled(canEdit = false, canRandom = true)
        if (showNetworkDialog) showUnstableNetworkDialog()
    }

    private fun showLoading() {
        binding.imvImage.apply {
            setImageDrawable(null)
            gone()
        }
        binding.imageGif.visible()
        setControlsEnabled(canEdit = false, canRandom = false)
    }

    private fun showBitmap(bitmap: Bitmap) {
        binding.imvImage.apply {
            scaleType = ImageView.ScaleType.CENTER_CROP
            setImageBitmap(bitmap)
            visible()
        }
        binding.imageGif.gone()
        setControlsEnabled(canEdit = true, canRandom = true)
    }

    private fun setControlsEnabled(canEdit: Boolean, canRandom: Boolean) {
        binding.btnEdit.isEnabled = canEdit
        binding.btnEdit.isClickable = canEdit
        binding.btnEdit.alpha = if (canEdit) 1f else 0.5f

        binding.random.isEnabled = canRandom
        binding.random.isClickable = canRandom
        binding.random.alpha = if (canRandom) 1f else 0.5f
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
