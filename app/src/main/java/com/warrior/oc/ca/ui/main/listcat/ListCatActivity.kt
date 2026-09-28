package com.warrior.oc.ca.ui.main.listcat

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
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
    override fun initView() {
        val cats = viewModel.uiState.value.cats
        binding.txtBrush.isSelected= true
        binding.actionBar.apply {
            setImageActionBar(btnActionBarLeft, R.drawable.back_app)
        }
        binding.catPager.apply {
            adapter = ListCatAdapter(cats)
            offscreenPageLimit = 3
            clipToPadding = false
            clipChildren = false
            val sidePadding = resources.getDimensionPixelSize(R.dimen.dimension_56)
            setPadding(sidePadding, 0, sidePadding, 0)
            (getChildAt(0) as RecyclerView).apply {
                clipToPadding = false
                clipChildren = false
                overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            }
            setPageTransformer { page, position ->
                val distance = abs(position).coerceAtMost(1f)
                page.translationX = -resources.getDimension(R.dimen.dimension_72) * position

                val scale = 1.08f - 0.36f * distance
                page.scaleX = scale
                page.scaleY = scale
                page.alpha = 1f - 0.32f * distance
            }
            // Match the reference: start on the middle cat so both neighbours
            // are visible immediately instead of starting at the first page.
            setCurrentItem(viewModel.uiState.value.selectedCat - 1, false)
        }
        binding.catPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewModel.selectCat(position)
            }
        })
        binding.dotsIndicator.attachTo(binding.catPager)
    }

    override fun viewListener() {
        binding.actionBar.btnActionBarLeft.onClick { onBackPressedDispatcher.onBackPressed() }
        binding.btnBrush.onClick(500) { openPlayScreen() }
    }

    override fun bindViewModel() = Unit

    private fun openPlayScreen() {
        viewModel.selectCat(binding.catPager.currentItem)
        openActivity(
            CatPlayActivity::class.java,
            Bundle().apply { putInt(EXTRA_SELECTED_CAT, viewModel.uiState.value.selectedCat) }
        )
    }

    companion object {
        const val EXTRA_SELECTED_CAT = "selected_cat"
    }
}
