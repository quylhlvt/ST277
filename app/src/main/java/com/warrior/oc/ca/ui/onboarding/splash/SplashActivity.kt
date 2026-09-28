package com.warrior.oc.ca.ui.onboarding.splash

import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import com.warrior.oc.ca.R
import com.warrior.oc.ca.core.base.BaseActivity
import com.warrior.oc.ca.core.extention.toIntro
import com.warrior.oc.ca.core.extention.toLanguage
import com.warrior.oc.ca.databinding.ActivitySplashBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(
    ActivitySplashBinding::inflate,
    SplashViewModel::class.java
)  {
    private var navigateJob: Job? = null

    private var hasNavigated = false

    // ── INIT ──────────────────────────────────────────────────────────────────

    override fun initView() {
        preloadHomeDrawables()
        // Warm up the intro font while the splash screen is visible.
        ResourcesCompat.getFont(this@SplashActivity, R.font.baloo2_extrabold)

        viewModel.triggerNavigate()
    }

    private fun preloadHomeDrawables() {
        // This work only warms Glide's caches and must not be tied to the Activity.
        // A decorView callback may run after the Activity has already been destroyed.
        val requestManager = Glide.with(applicationContext)
        val flagResIds = listOf(
            R.drawable.ic_flag_hindi,
            R.drawable.ic_flag_spanish,
            R.drawable.ic_flag_french,
            R.drawable.ic_flag_english,
            R.drawable.ic_flag_portugeese,
            R.drawable.ic_flag_indo,
            R.drawable.ic_flag_germani,
            R.drawable.ic_select_lang,
            R.drawable.ic_un_select_lang,
            R.drawable.select_language,
            R.drawable.back_app,
        )

        flagResIds.forEach { resId ->
            requestManager
                .load(resId)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .override(64, 64)
                .preload()
        }
    }

    override fun viewListener() {}

    override fun bindViewModel() {}

    private fun goToHome() {
        if (hasNavigated) return
        hasNavigated = true
        if (isFinishing || isDestroyed) return
        doNavigate()
    }
    private fun doNavigate() {
        if (viewModel.shouldOpenLanguageScreen()) { toLanguage(); return }
        toIntro()
    }
    override fun onPause() {
        super.onPause()
        navigateJob?.cancel()
    }

    override fun onResume() {
        super.onResume()
        if (hasNavigated) return

        if (viewModel.navigateSignal.value) {
            goToHome()
            return
        }

        navigateJob?.cancel()
        navigateJob = this@SplashActivity.lifecycleScope.launch {
            viewModel.navigateSignal.first { it }
            goToHome()
        }
    }

    override fun onDestroy() {
        navigateJob?.cancel()
        navigateJob = null
        super.onDestroy()
    }

    override fun handleBackPressed(): Boolean {
        return true
    }
}
