package com.warrior.oc.ca.ui.main.lost

import android.os.Bundle
import com.bumptech.glide.Glide
import com.warrior.oc.ca.core.base.BaseActivity
import com.warrior.oc.ca.core.extention.onClick
import com.warrior.oc.ca.databinding.ActivityLostBinding
import com.warrior.oc.ca.ui.main.catplay.CatPlayActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LostActivity : BaseActivity<ActivityLostBinding, LostViewModel>(
    ActivityLostBinding::inflate, LostViewModel::class.java
) {
    override fun initView() {
        viewModel.initialize(
            score = intent.getIntExtra(EXTRA_SCORE, 0),
            selectedCat = intent.getIntExtra(EXTRA_SELECTED_CAT, 1)
        )
        val state = viewModel.uiState.value
        binding.txtTryAgain.isSelected = true
        binding.txtChoose.isSelected = true
        binding.txtFinalScore.text = state.score.toString()

    }

    override fun viewListener() {
        binding.btnRetry.onClick(500) {
            openActivity(
                CatPlayActivity::class.java,
                Bundle().apply { putInt(EXTRA_SELECTED_CAT, viewModel.uiState.value.selectedCat) },
                finishCurrent = true
            )
        }
        binding.btnChooseCat.onClick(500) { finish() }
    }

    override fun bindViewModel() = Unit

    companion object {
        const val EXTRA_SCORE = "lost_score"
        const val EXTRA_SELECTED_CAT = "selected_cat"
    }
}
