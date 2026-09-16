package com.duomaker.couplelove.vatar.ui.main.show

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duomaker.couplelove.vatar.MyApplication
import com.duomaker.couplelove.vatar.R
import com.duomaker.couplelove.vatar.core.base.BaseActivity
import com.duomaker.couplelove.vatar.core.extention.InternetExtension
import com.duomaker.couplelove.vatar.core.extention.gone
import com.duomaker.couplelove.vatar.core.extention.onClick
import com.duomaker.couplelove.vatar.core.extention.setImageActionBar
import com.duomaker.couplelove.vatar.core.extention.visible
import com.duomaker.couplelove.vatar.data.model.custom.BodyPartModel
import com.duomaker.couplelove.vatar.data.model.custom.SelectionIndex
import com.duomaker.couplelove.vatar.databinding.ActivityShowBinding
import com.duomaker.couplelove.vatar.ui.main.customize.ColorAdapter
import com.duomaker.couplelove.vatar.ui.main.customize.NavAdapter
import com.duomaker.couplelove.vatar.ui.main.customize.PartAdapter
import com.duomaker.couplelove.vatar.ui.main.successcosplay.SuccessCosplayActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale
import java.util.concurrent.atomic.AtomicInteger
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine

@AndroidEntryPoint
class ShowActivity : BaseActivity<ActivityShowBinding, ShowViewModel>(
    ActivityShowBinding::inflate,
    ShowViewModel::class.java
) {
    // ── Layer views (giống CustomizeActivity) ─────────────────────────────────
    private val layerViews = arrayListOf<AppCompatImageView>()
    private val navToLayerIndex = mutableMapOf<String, Int>()
    private val arrShowColor = mutableListOf<Boolean>()
    private var visibleNavIndices = emptyList<Int>()

    private val adapterNav by lazy { NavAdapter() }
    private val adapterColor by lazy { ColorAdapter() }
    private val adapterPart by lazy { PartAdapter() }

    private val pendingLoads = AtomicInteger(0)
    private var renderGeneration = 0L
    private var timerJob: Job? = null
    private var countDownJob: Job? = null
    private val totalSeconds = 10 * 60
    private var remainingSeconds = totalSeconds

    private var remainingSecondsOnPause: Int = totalSeconds
    private var hasNavigatedToSuccess = false
    private var scrollPartAfterRandom = false
    // ── INFLATE ───────────────────────────────────────────────────────────────
    private fun isOnlineTemplate(): Boolean {
        val templateId = intent.extras?.getString(ARG_TEMPLATE_ID)
        if (templateId != null) return templateId.startsWith("online_")

        val templateIndex = intent.extras?.getInt(ARG_TEMPLATE_INDEX, 0) ?: 0
        return appSession.templates.value
            .getOrNull(templateIndex)?.id?.startsWith("online_") == true
    }

    private fun checkOnlineNetworkOrShowDialog(): Boolean {
        if (!isOnlineTemplate()) return false
        return when {
            !InternetExtension.isInternetAvailable(this@ShowActivity) -> {
                showUnstableNetworkDialog(); true
            }
            !InternetExtension.isNetworkConnected(this@ShowActivity) -> {
                showUnstableNetworkDialog(); true
            }
            else -> false
        }
    }
    // ── INIT ──────────────────────────────────────────────────────────────────

    override fun initView() {

        // Mỗi lần mở một ván Show (kể cả Chơi lại) phải bắt đầu điểm từ 0,
        // không lấy lại phần trăm/kết quả của ván trước.
        appSession.cosplayPercent = 0
        appSession.userResultBitmap = null

        binding.apply {

            actionBar.apply {
                setImageActionBar(cvLogo, R.drawable.back_app)
//            setImageActionBar(btnActionBarRight, R.drawable.next_app)
//            setTextActionBar( tvCenter, "05:00" )
            }
        }

        setupAdapters()
        readArgsAndInit()
        // Show dùng một nhân vật duy nhất, không chuyển/tách theo gender.
//        binding.gender.gone()

        startCountDown()

        val bitmap = appSession.cosplayBitmap
        if (bitmap != null && !bitmap.isRecycled) {
            binding.imvImage2.setImageBitmap(bitmap)
            binding.imvImage.setImageBitmap(bitmap)
            binding.imvImage2.visibility = View.VISIBLE
        } else {
            binding.imvImage2.visibility = View.GONE
        }
    }
    private fun updateTimerUI(minutes: Int, seconds: Int) {
        binding.actionBar.tvCenter.text = String.format(
            Locale.US,
            "%02d:%02d",
            minutes,
            seconds
        )
    }
    private fun startTimer(fromSeconds: Int = totalSeconds) {
        timerJob?.cancel()
        remainingSeconds = fromSeconds

        timerJob = this@ShowActivity.lifecycleScope.launch {
            while (remainingSeconds >= 0) {
                val minutes = remainingSeconds / 60
                val seconds = remainingSeconds % 60
                updateTimerUI(minutes, seconds)

                if (remainingSeconds == 0) {
                    navigateToSuccess()
                    break
                }

                delay(1000)
                remainingSeconds--  // ← cập nhật liên tục
            }
        }
    }

    private fun startCountDown() {
        countDownJob?.cancel()
        binding.actionBar.cvLogo.isEnabled = false
        binding.actionBar.btnActionBarRight.isEnabled = false
        val colors = listOf(
            ContextCompat.getColor(this@ShowActivity, R.color.app_color5), // 3
            ContextCompat.getColor(this@ShowActivity, R.color.app_color6), // 2
            ContextCompat.getColor(this@ShowActivity, R.color.orange_F6)   // 1
        )

        binding.countDown.visibility = View.VISIBLE

        countDownJob = this@ShowActivity.lifecycleScope.launch {
            for (count in 3 downTo 1) {
                val colorIndex = 3 - count
                binding.tvCountDown.setTextColor(colors[colorIndex])
                binding.tvCountDown.text = count.toString()

                // reset state trước khi animate in
                binding.tvCountDown.scaleX = 0.4f
                binding.tvCountDown.scaleY = 0.4f
                binding.tvCountDown.alpha = 0f

                // pop in — chờ xong
                suspendCancellableCoroutine { cont ->
                    binding.tvCountDown.animate()
                        .scaleX(1f).scaleY(1f)
                        .alpha(1f)
                        .setDuration(350)
                        .withEndAction { cont.resume(Unit) {} }
                        .start()
                }

                // giữ 500ms
                delay(500)

                // pop out — chờ xong
                suspendCancellableCoroutine { cont ->
                    binding.tvCountDown.animate()
                        .scaleX(1.5f).scaleY(1.5f)
                        .alpha(0f)
                        .setDuration(250)
                        .withEndAction { cont.resume(Unit) {} }
                        .start()
                }
            }

            // Ẩn overlay, bắt đầu timer
            binding.countDown.visibility = View.GONE
            binding.actionBar.cvLogo.isEnabled = true
            binding.actionBar.btnActionBarRight.isEnabled = true
            binding.tvCountDown.alpha = 1f
            binding.tvCountDown.scaleX = 1f
            binding.tvCountDown.scaleY = 1f
            startTimer()
        }
    }
    private fun readArgsAndInit() {
        val fallbackIndex = intent.extras?.getInt(ARG_TEMPLATE_INDEX, 0) ?: 0
        val templateId = intent.extras?.getString(ARG_TEMPLATE_ID)
        val templateIndex = templateId?.let { id ->
            appSession.templates.value.indexOfFirst { it.id == id }.takeIf { it >= 0 }
        } ?: fallbackIndex
        val targetSelections: ArrayList<SelectionIndex> =
            intent.extras?.getParcelableArrayList(ARG_SELECTIONS) ?: return

        viewModel.init(templateIndex, targetSelections, templateId)
    }

    private fun setupAdapters() {
        binding.rcvNav.apply {
            adapter = adapterNav
            itemAnimator = null
            setHasFixedSize(true)
            setItemViewCacheSize(8)
        }
        binding.rcvColor.apply {
            adapter = adapterColor
            itemAnimator = null
            setHasFixedSize(true)
            setItemViewCacheSize(8)
        }
        binding.rcvPart.apply {
            adapter = adapterPart
            itemAnimator = null
            setHasFixedSize(true)
            setItemViewCacheSize(10)
            (layoutManager as? GridLayoutManager)?.spanCount =
                if (MyApplication.isTablet) 7 else 5
        }
    }
    private fun navigateToSuccess() {
        if (isFinishing || isDestroyed) return
        if (hasNavigatedToSuccess) return
        hasNavigatedToSuccess = true
        timerJob?.cancel()
        countDownJob?.cancel()

        // Nếu vẫn còn đang load ảnh → đợi
        if (pendingLoads.get() > 0) {
            this@ShowActivity.lifecycleScope.launch {
                while (pendingLoads.get() > 0) {
                    delay(50)
                }
                doNavigateToSuccess()
            }
        } else {
            doNavigateToSuccess()
        }
    }

    private fun doNavigateToSuccess() {
        if (isFinishing || isDestroyed) return

        val bitmap = renderLayersToBitmap()
        // Luôn ghi đè kết quả phiên hiện tại, tránh giữ lại ảnh người chơi cũ.
        appSession.userResultBitmap = bitmap

        appSession.cosplayPercent = viewModel.state.value.matchPercent

        val successIntent = Intent(
            this@ShowActivity,
            SuccessCosplayActivity::class.java
        ).apply {
            // Truyền toàn bộ dữ liệu của ShowActivity sang Success
            intent.extras?.let { putExtras(it) }
        }

        startActivity(successIntent)

        // Xóa màn Show cũ
        finish()
    }
    private fun renderLayersToBitmap(): Bitmap? {
        val root = binding.rlCharacter
        if (root.width == 0 || root.height == 0) return null
        val bitmap = Bitmap.createBitmap(root.width, root.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        layerViews.forEach { iv ->
            if (iv.visibility != View.VISIBLE) return@forEach
            val drawable = iv.drawable ?: return@forEach
            drawable.setBounds(0, 0, root.width, root.height)
            drawable.draw(canvas)
        }
        return bitmap
    }
    override fun handleBackPressed(): Boolean {
        confirmExit()
        return true
    }
    private fun confirmExit() {
        showConfirmDialog(
            message = getString(R.string.haven_t_saved_it_yet_do_you_want_to_exit),
            title = getString(R.string.exit),
            onYes = {
//                showInter {
                hideLoadingSafe()
                finish()
//                }
            },
            onNo = { hideLoadingSafe() }
        )
    }
    // ── LISTENERS ─────────────────────────────────────────────────────────────

    override fun viewListener() {
        binding.apply {
            actionBar.cvLogo.onClick {
                confirmExit()
//                finish()
            }
//            actionBar.btnActionBarRight.onClick { navigateToSuccess() }

            materialSmall.onClick {
                imgShowBig.visible()
            }
            close.onClick { imgShowBig.gone() }

        }

        // ── Nav ───────────────────────────────────────────────────────────────────
        adapterNav.onClick = { index ->
            if (!checkOnlineNetworkOrShowDialog()) {
                adapterNav.setPos(index)
                visibleNavIndices.getOrNull(index)?.let(viewModel::selectNav)
            }
        }

        // ── Color ─────────────────────────────────────────────────────────────────
        adapterColor.onClick = { index ->
            if (!checkOnlineNetworkOrShowDialog()) {
                adapterColor.setPos(index)
                viewModel.selectColor(index)
            }
        }

        // ── Part ──────────────────────────────────────────────────────────────────
        adapterPart.onClick = { idx, type ->
            if (!checkOnlineNetworkOrShowDialog()) {                              // ← guard
                when (type) {
                    "none" -> {
                        adapterPart.setPos(idx)
                        viewModel.selectNone()
                    }
                    "dice" -> {
                        scrollPartAfterRandom = true
                        viewModel.selectDiceCurrent()
                    }
                    else -> {
                        adapterPart.setPos(idx)
                        viewModel.selectPath(idx)
                    }
                }
            }
        }
    }

    // ── OBSERVE ───────────────────────────────────────────────────────────────

    // ShowActivity.observeData() — THÊM guard này
    // ✅ FIX — thêm flag giống CustomizeActivity
    private var hasTriggeredReInit = false

    override fun observeData() {

        this@ShowActivity.lifecycleScope.launch {
            this@ShowActivity.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest { state ->
                    if (state.listData.isEmpty()) {
                        if (!hasTriggeredReInit) {
                            hasTriggeredReInit = true
                            readArgsAndInit()
                        }
                        return@collectLatest
                    }
                    hasTriggeredReInit = false  // reset khi có data

                    if (layerViews.size != state.listData.size) {
                        buildLayerViews(state.listData)
                    }
                    renderLayers(state)
                    updateAdapters(state)
                    updateMatchUI(state.matchPercent)
                    if (state.matchPercent >= 100) {
                        navigateToSuccess()
                    }
                }
            }
        }
    }

    // ── BUILD LAYER VIEWS (giống CustomizeActivity.buildLayerViews) ───────────

    private fun buildLayerViews(parts: List<BodyPartModel>) {
        layerViews.clear()
        navToLayerIndex.clear()
        binding.rlCharacter.removeAllViews()

        parts.sortedBy { it.position }.forEachIndexed { layerIdx, bp ->
            val iv = AppCompatImageView(this@ShowActivity).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                scaleType = ImageView.ScaleType.FIT_CENTER
            }
            binding.rlCharacter.addView(iv)
            layerViews.add(iv)
            navToLayerIndex[bp.nav] = layerIdx
        }
    }

    // ── RENDER LAYERS (giống CustomizeActivity.renderLayers) ─────────────────

    private fun renderLayers(state: ShowState) {
        val generation = ++renderGeneration
        val pathsToLoad = state.listData.mapIndexedNotNull { i, bp ->
            val path = viewModel.resolveUserPathAt(i)
            val layerIndex = navToLayerIndex[bp.nav] ?: return@mapIndexedNotNull null
            val view = layerViews.getOrNull(layerIndex) ?: return@mapIndexedNotNull null

            if (path == null) {
                if (view.visibility != View.GONE) {
                    view.visibility = View.GONE
                    view.tag = null
                    Glide.with(binding.rlCharacter).clear(view)
                }
                return@mapIndexedNotNull null
            }
            if (view.tag == path &&
                view.visibility == View.VISIBLE &&
                view.drawable != null
            ) return@mapIndexedNotNull null
            Triple(view, path, layerIndex)
        }

        if (pathsToLoad.isEmpty()) {
            pendingLoads.set(0)
            viewModel.onLoadingComplete()
            return
        }

        pendingLoads.set(pathsToLoad.size)

        pathsToLoad.forEach { (view, path, _) ->
            view.tag = path
            view.visibility = View.VISIBLE
            loadImageIntoView(view, path, generation)
        }
    }

    private fun loadImageIntoView(view: ImageView, path: String, generation: Long) {
        Glide.with(binding.rlCharacter)
            .load(path)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .priority(Priority.IMMEDIATE)
            .skipMemoryCache(false)
            .dontAnimate()
            .dontTransform()
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?, model: Any?,
                    target: Target<Drawable>?, isFirstResource: Boolean
                ): Boolean {
                    onLoadFinished(generation); return false
                }

                override fun onResourceReady(
                    resource: Drawable?, model: Any?,
                    target: Target<Drawable>?, dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    onLoadFinished(generation); return false
                }
            })
            .into(view)
    }

    private fun onLoadFinished(generation: Long) {
        if (generation != renderGeneration) return
        if (pendingLoads.decrementAndGet() <= 0) {
            pendingLoads.set(0)
            binding.root.post { viewModel.onLoadingComplete() }
        }
    }

    // ── ADAPTERS (giống CustomizeActivity.updateAdapters) ────────────────────

    private fun updateAdapters(state: ShowState) {
        // Hiển thị toàn bộ bộ phận trong cùng một danh sách nhân vật.
        visibleNavIndices = state.listData.indices.toList()
        val visibleNavItems = visibleNavIndices.mapNotNull { state.listData.getOrNull(it) }
        val visibleNavPosition = visibleNavIndices.indexOf(state.currentNavIndex)
            .takeIf { it >= 0 } ?: 0

        if (adapterNav.items != visibleNavItems) {
            adapterNav.submitList(visibleNavItems)
        }
//        adapterNav.setPos(visibleNavPosition.coerceIn(0, maxOf(0, visibleNavItems.lastIndex)))
        val safeNavPosition = visibleNavPosition.coerceIn(
            0,
            maxOf(0, visibleNavItems.lastIndex)
        )

        adapterNav.setPos(safeNavPosition)

        val safeColorPosition = state.currentColorIndex.coerceIn(
            0,
            maxOf(0, state.currentColors.lastIndex)
        )
        adapterColor.setPos(safeColorPosition)

        // Khởi tạo arrShowColor
        if (arrShowColor.size != state.listData.size) {
            arrShowColor.clear()
            repeat(state.listData.size) { arrShowColor.add(true) }
        }

        val navPos = state.currentNavIndex

        if (state.hasMultipleColors) {
            if (adapterColor.items != state.currentColors) {
                adapterColor.submitList(state.currentColors)
            }
            updateColorSectionVisibility(
                showColors = true,
                expanded = navPos < arrShowColor.size && arrShowColor[navPos]
            )
        } else {
            updateColorSectionVisibility(showColors = false, expanded = false)
        }

        val bp = state.listData.getOrNull(state.currentNavIndex)
        val thumb = buildThumbList(bp, state.currentPaths)

        val safePartPosition = state.currentPathIndex.coerceIn(
            0,
            maxOf(0, state.currentPaths.lastIndex)
        )

        adapterPart.setPos(safePartPosition)

        val partContentChanged =
            adapterPart.items != state.currentPaths ||
                    adapterPart.listThumb != thumb

        adapterPart.listThumb = thumb

        if (partContentChanged) {
            adapterPart.submitList(state.currentPaths)
        }

// Random dice
        if (scrollPartAfterRandom) {
            scrollPartAfterRandom = false

            binding.rcvPart.post {
                ensurePositionVisible(
                    binding.rcvPart,
                    safePartPosition
                )
            }

        }

    }

    private fun ensurePositionVisible(recyclerView: RecyclerView, position: Int) {
        if (position < 0) return
        recyclerView.post {
            if (isFinishing || isDestroyed) return@post
            if (recyclerView.layoutManager?.findViewByPosition(position) == null) {
                recyclerView.scrollToPosition(position)
            }
        }
    }

    private fun updateColorSectionVisibility(showColors: Boolean, expanded: Boolean) {
        val showPanel = showColors && expanded
        if (showPanel &&
            (binding.llColor.visibility != View.VISIBLE || binding.llColor.alpha != 1f)
        ) {
            binding.llColor.animate().cancel()
            if (binding.llColor.visibility != View.VISIBLE) {
                binding.llColor.visibility = View.VISIBLE
                binding.llColor.alpha = 0f
            }
            binding.llColor.animate().alpha(1f).setDuration(150).start()
        } else if (!showPanel && binding.llColor.visibility == View.VISIBLE) {
            binding.llColor.animate().cancel()
            binding.llColor.animate().alpha(0f).setDuration(150).withEndAction {
                binding.llColor.visibility = View.GONE
            }.start()
        }
    }

    private fun buildThumbList(bp: BodyPartModel?, paths: List<String>): List<String> {
        val thumbs = bp?.listThumbPath ?: return paths
        if (thumbs.isEmpty()) return paths
        var idx = 0
        return paths.map { path ->
            when (path) {
                "none", "dice" -> path
                else -> thumbs.getOrElse(idx++) { path }
            }
        }
    }

    // ── PROGRESS (giống ShowActivity.updateMatchUI) ───────────────────────────

    private fun updateMatchUI(percent: Int) {
        val starCount = when (percent) {
            0 -> 0
            in 1..20 -> 1
            in 21..40 -> 2
            in 41..70 -> 3
            in 71..98 -> 4
            in 99..100 -> 5
            else -> 0
        }


        val percentText = "$percent%"
        binding.tvPercent.text = percentText
        binding.txtPercent2.text = percentText
    }
    // onPause — lưu remainingSeconds thực tế
    override fun onPause() {
        super.onPause()
        timerJob?.cancel()
        // remainingSeconds đã được cập nhật liên tục trong startTimer
    }
    // ── RESUME ────────────────────────────────────────────────────────────────

    override fun onResume() {
        super.onResume()
        pendingLoads.set(0)

        // ← Resume timer nếu đang đếm (chưa win/fail)
        if (remainingSeconds in 1 until totalSeconds
            && !hasNavigatedToSuccess
            && binding.countDown.visibility != View.VISIBLE
        ) {
            startTimer(remainingSeconds)
        }

        val currentState = viewModel.state.value
        if (currentState.listData.isEmpty()) {
            if (!hasTriggeredReInit) {
                hasTriggeredReInit = true
                readArgsAndInit()
            }
            return
        }

        val needRebuild = layerViews.isEmpty() ||
                layerViews.firstOrNull()?.isAttachedToWindow == false

        if (needRebuild) {
            buildLayerViews(currentState.listData)
            renderLayers(currentState)
            updateAdapters(currentState)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        timerJob?.cancel()
        countDownJob?.cancel()
    }
    override fun bindViewModel() {}

    // ── COMPANION ─────────────────────────────────────────────────────────────

    companion object {
        const val ARG_TEMPLATE_INDEX = "template_index"
        const val ARG_TEMPLATE_ID = "template_id"
        const val ARG_SELECTIONS = "selections"

        fun newArgshow(
            templateIndex: Int,
            targetSelections: ArrayList<SelectionIndex>,
            templateId: String? = null
        ) = Bundle().apply {
            putInt(ARG_TEMPLATE_INDEX, templateIndex)
            templateId?.let { putString(ARG_TEMPLATE_ID, it) }
            putParcelableArrayList(ARG_SELECTIONS, targetSelections)
        }
    }
}
