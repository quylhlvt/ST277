package com.anime.oc.characters.avatar.ui.onboarding.splash

import android.animation.ValueAnimator
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import com.anime.oc.characters.avatar.R
import com.anime.oc.characters.avatar.core.base.BaseActivity
import com.anime.oc.characters.avatar.core.extention.toIntro
import com.anime.oc.characters.avatar.core.extention.toLanguage
import com.anime.oc.characters.avatar.core.helper.SharedPreferencesManager
import com.anime.oc.characters.avatar.databinding.ActivitySplashBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.tencent.mmkv.MMKV
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.atomic.AtomicInteger
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(
    ActivitySplashBinding::inflate,
    SplashViewModel::class.java
)  {
    private var pendingNavigate = false
    private var navigateJob: Job? = null

    private var progressAnimator: ValueAnimator? = null
    private var currentOverlayFraction = 1f
    private var hasNavigated = false

    companion object {
        private const val MIN_SPLASH_MS  = 3_000L
        private const val API_TIMEOUT_MS = 8_000L
    }

    // ── INIT ──────────────────────────────────────────────────────────────────

    override fun initView() {
        preloadHomeDrawables { appSession.notifyImagesReady() }
        // ✅ Warm up font — giữ nguyên, nhẹ
        ResourcesCompat.getFont(this@SplashActivity, R.font.baloo2_extrabold)

//        interCallBack = object : InterCallback() {
//            override fun onNextAction() {
//                super.onNextAction()
                viewModel.triggerNavigate()
//            }
//        }

//        Admob.getInstance().loadSplashInterAds(
//            this@SplashActivity, getString(R.string.inter_splash), 30000, 3000, interCallBack
//        )
    }

    private fun preloadHomeDrawables(onDone: () -> Unit) {
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

        val total = flagResIds.size
        val doneCount = AtomicInteger(0)
        val checkDone = { if (doneCount.incrementAndGet() == total) onDone() }

        // ✅ Flag icons — nhỏ, dùng override nhỏ + memory cache
        flagResIds.forEach { resId ->
            requestManager
                .load(resId)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .override(64, 64)           // ← giảm xuống 64 cho flag
                .preload()                  // ← preload vào memory cache
            checkDone()                     // ← không cần đợi callback
        }
    }

    override fun viewListener() {}

    // Trong Activity, observeData():
    override fun observeData() {
        viewModel.startSplashTimer(
            hasNetwork = isNetworkAvailable(),
            hasOnlineTemplates = appSession.templates.value.any { it.id.startsWith("online_") },
            templatesFlow = appSession.templates,
            imagesReadyFlow = appSession.imagesReady,
            localDataReadyFlow = appSession.localDataReady
        )
        this@SplashActivity.lifecycleScope.launch {
            viewModel.dataReadySignal.first { it }
            if (!isNetworkAvailable()) viewModel.triggerNavigate()
            else withTimeoutOrNull(30_000L) { viewModel.navigateSignal.first { it } }
                ?: viewModel.triggerNavigate()
        }

    }

    override fun bindViewModel() {}

    // ── PROGRESS ──────────────────────────────────────────────────────────────

    // ── NAVIGATE ──────────────────────────────────────────────────────────────

    private fun goToHome() {
        if (hasNavigated) return
        hasNavigated = true  // ✅ set trước

        if (isFinishing || isDestroyed) {
            pendingNavigate = true  // ✅ defer sang onResume
            return
        }
        doNavigate()
    }
    private fun doNavigate() {
        if (!SharedPreferencesManager.isLanuageScreen()) { toLanguage(); return }
        toIntro()
    }
    // ── NETWORK ───────────────────────────────────────────────────────────────

    private fun isNetworkAvailable(): Boolean = try {
        val cm = this@SplashActivity.getSystemService(ConnectivityManager::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val caps = cm.getNetworkCapabilities(cm.activeNetwork ?: return false) ?: return false
            caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                    caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } else {
            @Suppress("DEPRECATION")
            cm.activeNetworkInfo?.isConnected == true
        }
    } catch (e: Exception) { false }

    // ── LIFECYCLE ─────────────────────────────────────────────────────────────
    override fun onPause() {
        super.onPause()
        progressAnimator?.pause()
        navigateJob?.cancel()  // ✅ Cancel khi pause, onResume sẽ tạo lại
    }

    override fun onResume() {
        super.onResume()
        progressAnimator?.resume()

        if (hasNavigated) return

        // ✅ Check ngay nếu đã ready
        if (viewModel.navigateSignal.value) {
            goToHome()
            return
        }

        // ✅ Cancel job cũ trước khi tạo mới, tránh chồng chéo
        navigateJob?.cancel()
        navigateJob = this@SplashActivity.lifecycleScope.launch {
            viewModel.navigateSignal.first { it }
            goToHome()
        }
    }

    override fun onDestroy() {
        navigateJob?.cancel()
        navigateJob = null
        progressAnimator?.cancel()
        progressAnimator = null
        super.onDestroy()
    }

    override fun handleBackPressed(): Boolean {
        return true
    }
}
