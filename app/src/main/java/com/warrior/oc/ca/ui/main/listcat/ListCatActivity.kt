package com.warrior.oc.ca.ui.main.listcat

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.warrior.oc.ca.R
import com.warrior.oc.ca.core.base.BaseActivity
import com.warrior.oc.ca.core.extention.onClick
import com.warrior.oc.ca.core.extention.setImageActionBar
import com.warrior.oc.ca.databinding.ActivityListCatBinding
import com.warrior.oc.ca.ui.main.catplay.CatPlayActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.abs

@AndroidEntryPoint
class ListCatActivity : BaseActivity<ActivityListCatBinding, ListCatViewModel>(
    ActivityListCatBinding::inflate, ListCatViewModel::class.java
) {
    private val cats = (1..5).map { "listcatall/$it.png" }

    private val cameraPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) openPlayScreen()
    }

    override fun initView() {
        binding.actionBar.apply {
            setImageActionBar(btnActionBarLeft, R.drawable.back_app)
        }
        binding.catPager.apply {
            adapter = ListCatAdapter(cats)
            offscreenPageLimit = 3
            clipToPadding = false
            clipChildren = false
            setPadding(dp(58), 0, dp(58), 0)
            (getChildAt(0) as RecyclerView).apply {
                clipToPadding = false
                clipChildren = false
                overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            }
            setPageTransformer { page, position ->
                val distance = abs(position).coerceAtMost(1f)
                // Pull the neighbouring pages into the viewport. The PNG files
                // have transparent space around each cat, so padding alone is
                // not enough to reveal the actual cat at either edge.
                page.translationX = -dp(72).toFloat() * position
                // The focused cat is intentionally dominant; neighbours stay
                // small and slightly faded, like the supplied mock-up.
                val scale = 1.08f - 0.36f * distance
                page.scaleX = scale
                page.scaleY = scale
                page.alpha = 1f - 0.32f * distance
            }
            // Match the reference: start on the middle cat so both neighbours
            // are visible immediately instead of starting at the first page.
            setCurrentItem(cats.size / 2, false)
        }
        binding.dotsIndicator.attachTo(binding.catPager)
    }

    override fun viewListener() {
        binding.actionBar.btnActionBarLeft.onClick { onBackPressedDispatcher.onBackPressed() }
        binding.btnBrush.onClick(500) { openPlayWithCamera() }
    }

    override fun bindViewModel() = Unit

    private fun openPlayWithCamera() {
        if (!packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)) {
            showToast(R.string.camera_unavailable)
            return
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            openPlayScreen()
        } else {
            cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    private fun openPlayScreen() {
        openActivity(
            CatPlayActivity::class.java,
            Bundle().apply { putInt(EXTRA_SELECTED_CAT, binding.catPager.currentItem + 1) }
        )
    }

    private fun dp(value: Int) = (value * resources.displayMetrics.density).toInt()

    companion object {
        const val EXTRA_SELECTED_CAT = "selected_cat"
    }
}
