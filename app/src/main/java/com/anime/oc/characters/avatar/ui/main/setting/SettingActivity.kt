package com.anime.oc.characters.avatar.ui.main.setting

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.anime.oc.characters.avatar.R
import com.anime.oc.characters.avatar.core.base.BaseActivity
import com.anime.oc.characters.avatar.core.extention.gone
import com.anime.oc.characters.avatar.core.extention.onClick
import com.anime.oc.characters.avatar.core.extention.policy
import com.anime.oc.characters.avatar.core.extention.setImageActionBar
import com.anime.oc.characters.avatar.core.extention.setTextActionBar
import com.anime.oc.characters.avatar.core.extention.shareApp
import com.anime.oc.characters.avatar.core.extention.toLangFromSetting
import com.anime.oc.characters.avatar.core.extention.visible
import com.anime.oc.characters.avatar.core.helper.RateHelper
import com.anime.oc.characters.avatar.databinding.ActivitySettingBinding
import com.anime.oc.characters.avatar.utils.state.RateState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingActivity : BaseActivity<ActivitySettingBinding, SettingViewModel>(
    ActivitySettingBinding::inflate,
    SettingViewModel::class.java
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBackPressHandler()
    }

    private fun setupBackPressHandler() {
        this@SettingActivity.onBackPressedDispatcher.addCallback(
            this@SettingActivity,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    finish()
                }
            }
        )
    }

    override fun initView() {
        binding.apply {

            setupActionBar()
            setupActionTiltleBar()
            setupRateButton()
        }
    }

    private fun ActivitySettingBinding.setupActionBar() {
        actionBar.apply {
            setImageActionBar(
                btnActionBarLeft,
                R.drawable.back_app
            )
        }
    }

    private fun ActivitySettingBinding.setupActionTiltleBar() {
        binding.apply {
            txt1.isSelected = true
            txt2.isSelected = true
            txt3.isSelected = true
            txt4.isSelected = true
//
//            setTextActionBar(
//                actionBar.tvCenter,
//                getString(R.string.settings)
//            )
            actionBar.tvCenter.isSelected = true
        }

    }

    private fun ActivitySettingBinding.setupRateButton() {
        if (sharedPreferences.isRateRequest()) {
            btnRate.gone()
        } else {
            btnRate.visible()
        }
    }

    override fun viewListener() {
        binding.apply {
            setupActionBarListeners()
            setupNavigationListeners()
        }
    }

    private fun ActivitySettingBinding.setupActionBarListeners() {
        actionBar.btnActionBarLeft.onClick {
            finish()
        }
    }

    private fun ActivitySettingBinding.setupNavigationListeners() {
        btnLang.onClick {
            toLangFromSetting()
        }

        btnPolicy.onClick {
            policy()
        }

        btnRate.onClick {
            RateHelper.showRateDialog(this@SettingActivity, sharedPreferences) { state ->
                if (state != RateState.CANCEL) {
                    btnRate.gone()
                    showToast(R.string.have_rated)
                }
            }
        }

        btnShare.onClick {
            shareApp()
        }
    }

    override fun observeData() {}

    override fun bindViewModel() {}
}
