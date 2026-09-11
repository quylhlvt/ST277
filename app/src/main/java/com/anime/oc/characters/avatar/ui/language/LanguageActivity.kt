package com.anime.oc.characters.avatar.ui.language

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.anime.oc.characters.avatar.R
import com.anime.oc.characters.avatar.core.base.BaseActivity
import com.anime.oc.characters.avatar.core.extention.gone
import com.anime.oc.characters.avatar.core.extention.invisible
import com.anime.oc.characters.avatar.core.extention.onClick
import com.anime.oc.characters.avatar.core.extention.setTextActionBar
import com.anime.oc.characters.avatar.core.extention.toHomeFromLanguage
import com.anime.oc.characters.avatar.core.extention.toIntroFromLanguage
import com.anime.oc.characters.avatar.core.extention.toSettingFromLang
import com.anime.oc.characters.avatar.core.extention.visible
import com.anime.oc.characters.avatar.core.helper.LanguageHelper
import com.anime.oc.characters.avatar.core.helper.SharedPreferencesManager
import com.anime.oc.characters.avatar.databinding.ActivityLanguageBinding
import com.anime.oc.characters.avatar.utils.LanguageManager
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
//                setTextActionBar(actionBar.tvCenter, getString(R.string.language))
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
        }  else {
        // Update locale cho Activity context ngay lập tức
        val locale = Locale(code)
        val config = Configuration(this@LanguageActivity.resources.configuration)
        config.setLocale(locale)
        this@LanguageActivity.resources.updateConfiguration(config, this@LanguageActivity.resources.displayMetrics)

        // Rồi mới navigate
        toHomeFromLanguage()
    }
    }
}
