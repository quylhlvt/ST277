package com.warrior.oc.ca.ui.language

import android.content.res.Configuration
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.warrior.oc.ca.core.base.BaseActivity
import com.warrior.oc.ca.core.extention.invisible
import com.warrior.oc.ca.core.extention.onClick
import com.warrior.oc.ca.core.extention.setTextActionBar
import com.warrior.oc.ca.core.extention.toHomeFromLanguage
import com.warrior.oc.ca.core.extention.toIntroFromLanguage
import com.warrior.oc.ca.core.extention.toSettingFromLang
import com.warrior.oc.ca.core.extention.visible
import com.warrior.oc.ca.core.helper.LanguageHelper
import com.warrior.oc.ca.core.helper.SharedPreferencesManager
import com.warrior.oc.ca.utils.LanguageManager
import com.warrior.oc.ca.R
import com.warrior.oc.ca.databinding.ActivityLanguageBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LanguageActivity : BaseActivity<ActivityLanguageBinding, LanguageViewModel>(
    ActivityLanguageBinding::inflate, LanguageViewModel::class.java
) {
    private val languageAdapter by lazy { LanguageAdapter(this@LanguageActivity) }
    private var isFromSetting = false

    companion object {
        const val EXTRA_FROM_SETTING = "from_setting"
    }

    override fun handleBackPressed(): Boolean {

        when {
            isFromSetting -> {
                toSettingFromLang()
            }
            SharedPreferencesManager.isLanuageScreen() -> {
                finish()
            }
            else -> {
                this@LanguageActivity.finishAffinity()

            }
        }
        return true
    }
    override fun setupPreViews() {

        val isFirst = !SharedPreferencesManager.isLanuageScreen()

        binding.recycleLanguage.apply {
            adapter = languageAdapter
            itemAnimator = null
        }

        val currentLang = SharedPreferencesManager.isLanguageKey()
        viewModel.setFirstLanguage(isFirst = isFirst)
        viewModel.loadLanguages(currentLang)

        val list = viewModel.languageList.value
        if (list.isNotEmpty()) {
            languageAdapter.submitList(list)
        }
    }
    private fun updateActionBar(isFirst: Boolean) {
        binding.apply {
            if (isFirst) {
                setTextActionBar(actionBar.tvStart, getString(R.string.language))
                actionBar.btnActionBarRight.setImageResource(R.drawable.select_language)
            } else {
                setTextActionBar(actionBar.tvCenter, getString(R.string.language))
                actionBar.btnActionBarLeft.visible()
//                actionBar.btnActionBarRight.setImageResource(R.drawable.select_language)
            }
        }
        updateDoneButtonVisibility()
    }

    private fun updateDoneButtonVisibility() {
        val hasSelectedLanguage = viewModel.codeLang.value.isNotEmpty()
        if (hasSelectedLanguage) {
            binding.actionBar.btnActionBarRight.visible()
        } else {
            binding.actionBar.btnActionBarRight.invisible()
        }
    }
    override fun viewListener() {
        binding.apply {
            actionBar.btnActionBarRight.onClick {
                handleDone()
            }
            actionBar.btnActionBarLeft.onClick( 500) {
                // Dùng chung logic với onBackPressed
                handleBackPressed()
            }

        }

        handleRcv()
    }

    override fun initView() {
        binding.apply {
            actionBar.btnActionBarLeft.invisible()
            actionBar.btnActionBarRight.setImageResource(R.drawable.select_language)
        }
        isFromSetting = intent.getBooleanExtra(EXTRA_FROM_SETTING, false)
        binding.actionBar.apply {
            btnActionBarRight.invisible()
            btnActionBarLeft.setImageResource(R.drawable.back_app)
            tvStart.isSelected = true
            tvCenter.isSelected = true
        }

        // ✅ Bỏ initRcv() — đã làm trong setupPreViews
        updateActionBar(viewModel.isFirstLanguage.value)
    }

    override fun observeData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.isFirstLanguage.collect { isFirst ->
                        updateActionBar(isFirst)
                    }
                }
                launch {
                    viewModel.languageList.collect { list ->
                        if (list.isNotEmpty()) {
                            languageAdapter.submitList(list)
                        }
                    }
                }
                launch {
                    viewModel.codeLang.collect {
                        updateDoneButtonVisibility()
                    }
                }
            }
        }
    }

    override fun bindViewModel() {
    }

    private fun initRcv() {
        binding.recycleLanguage.apply {
            adapter = languageAdapter
            itemAnimator = null

        }
    }
    private fun handleRcv() {
        binding.apply {
            languageAdapter.onItemClick = { code ->
                viewModel.selectLanguage(code)
                updateDoneButtonVisibility()
            }
        }
    }

    private fun handleDone() {
        val code = viewModel.codeLang.value
        if (code.isEmpty()) {
            showToast(R.string.not_select_lang)
            return
        }

        sharedPreferences.setLanguageKey(code)
        LanguageHelper.setLocale(this@LanguageActivity, code)
        LanguageManager.updateLanguage(code)

        if (viewModel.isFirstLanguage.value) {
            sharedPreferences.setLanuageScreen(true)
            Log.d("LANG", "Navigating to Intro")
            toIntroFromLanguage()
        } else {
        // Update locale cho Activity context ngay lập tức
        val locale = Locale(code)
        val config = Configuration(this@LanguageActivity.resources.configuration)
        config.setLocale(locale)
        this@LanguageActivity.resources.updateConfiguration(config, this@LanguageActivity.resources.displayMetrics)

        // Rồi mới navigate
        // Khi đi tới Home từ Settings, dùng hiệu ứng trượt ngược như thao tác
        // Back (nhưng đích đến vẫn là Home).
        toHomeFromLanguage(reverseAnimation = isFromSetting)
    }
    }
}
