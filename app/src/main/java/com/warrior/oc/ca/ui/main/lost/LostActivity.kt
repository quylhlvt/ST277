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
    private val selectedCat by lazy {
        intent.getIntExtra(EXTRA_SELECTED_CAT, 1).coerceIn(1, 5)
    }

    override fun initView() {
        binding.txtFinalScore.text = intent.getIntExtra(EXTRA_SCORE, 0).toString()
        Glide.with(binding.imgLostCat)
            .load("file:///android_asset/listcat/cat$selectedCat/3.webp")
            .fitCenter()
            .into(binding.imgLostCat)
    }

    override fun viewListener() {
        binding.btnRetry.onClick(500) {
            openActivity(
                CatPlayActivity::class.java,
                Bundle().apply { putInt(EXTRA_SELECTED_CAT, selectedCat) },
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
