package com.duomaker.couplelove.vatar.ui.onboarding.intro

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.duomaker.couplelove.vatar.R
import com.duomaker.couplelove.vatar.core.base.BaseActivity
import com.duomaker.couplelove.vatar.core.extention.gone
import com.duomaker.couplelove.vatar.core.extention.onClick
import com.duomaker.couplelove.vatar.core.extention.toHome
import com.duomaker.couplelove.vatar.core.extention.toPermission
import com.duomaker.couplelove.vatar.core.extention.visible
import com.duomaker.couplelove.vatar.databinding.ActivityIntroBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.launch

@AndroidEntryPoint
class IntroActivity : BaseActivity<ActivityIntroBinding, IntroViewModel>(
    ActivityIntroBinding::inflate,
    IntroViewModel::class.java
) {
    @Inject
    lateinit var introAdapter: IntroAdapter

    override fun viewListener() {
        binding.btnNextPager.root.onClick(200) {
            Log.d("PERF", "1. Button clicked: ${System.currentTimeMillis()}")
            viewModel.nextPage(binding.viewPager2.currentItem, introAdapter.itemCount)
        }
        binding.viewPager2.registerOnPageChangeCallback(object :
            OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updatePageIndicator(position)
//                if (position == 1) {
//                    binding.nativeAds.gone()
//                } else {
//                    binding.nativeAds.visible()
//                }
            }
        })
//        binding.viewPager2.registerOnPageChangeCallback(object :
//            ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                if (position == 1) {
//                    binding.nativeAds.gone()
//                } else {
//                    binding.nativeAds.visible()
//                }
//            }
//        })
    }

    override fun initView() {

        binding.viewPager2.adapter = introAdapter
        updatePageIndicator(binding.viewPager2.currentItem)
        setOnChangeViewPager2()
//        binding.textView.text = "Home Activity"
//        binding.btnTest.setOnClickListener {
//            showSnackbar("Xin chào từ Home!")
//        }
    }

    override fun observeData() {
//        viewModel.data.observe(this@IntroActivity) { text ->
//            binding.textView.text = text
//        }
    }

    override fun bindViewModel() {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                introAdapter.submitList(state.pagesSplash)
                binding.apply {
                    viewPager2.currentItem = state.page
                    btnNextPager.tvButton.text = getString(state.textButtonRes)
                }
            }
        }

        lifecycleScope.launch {
            viewModel.singleEvent.collect { event ->
                when (event) {
                    is IntroSingleEvent.NavigateToNextScreen ->
                        if (sharedPreferences.isPermissionScreen())
                            toHome()
                        else
                            toPermission()
                }
            }
        }
    }

    private fun setOnChangeViewPager2() {
        binding.viewPager2.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                viewModel.getPage(binding.viewPager2.currentItem, introAdapter.itemCount)
            }
        })
    }

    private fun updatePageIndicator(selectedPosition: Int) {
        val indicators = listOf(
            binding.introDotFirst,
            binding.introDotSecond,
            binding.introDotThird
        )
        indicators.forEachIndexed { index, indicator ->
            indicator.setBackgroundResource(
                if (index == selectedPosition) {
                    R.drawable.bg_intro_dot_active
                } else {
                    R.drawable.bg_intro_dot_inactive
                }
            )
        }
    }

    override fun handleBackPressed(): Boolean {
        this@IntroActivity.finishAffinity()

        return  true
    }
}
