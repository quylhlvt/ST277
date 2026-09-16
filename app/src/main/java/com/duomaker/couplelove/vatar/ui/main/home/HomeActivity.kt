package com.duomaker.couplelove.vatar.ui.main.home

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.duomaker.couplelove.vatar.R
import com.duomaker.couplelove.vatar.core.base.BaseActivity
import com.duomaker.couplelove.vatar.core.extention.InternetExtension
import com.duomaker.couplelove.vatar.core.extention.onClick
import com.duomaker.couplelove.vatar.core.extention.setImageActionBar
import com.duomaker.couplelove.vatar.core.extention.toSettingFromHome
import com.duomaker.couplelove.vatar.core.helper.RateHelper
import com.duomaker.couplelove.vatar.databinding.ActivityHomeBinding
import com.duomaker.couplelove.vatar.ui.main.cosplay.CosplayActivity
import com.duomaker.couplelove.vatar.ui.main.createPony.ChoosePonyActivity
import com.duomaker.couplelove.vatar.ui.main.myPony.MyPonyActivity
import com.duomaker.couplelove.vatar.ui.main.random.RandomActivity
import com.duomaker.couplelove.vatar.utils.BlockableFrameLayout
import com.duomaker.couplelove.vatar.utils.state.RateState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
//import com.duomaker.couplelove.vatar.core.extention.loadNativeCollabAds
//import com.duomaker.couplelove.vatar.core.extention.showInter

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(
    ActivityHomeBinding::inflate, HomeViewModel::class.java
) {

    private var countRate = 0

    companion object {
        const val EXTRA_OPEN_ALBUM = "open_album"
    }

    override fun initView() {
        binding.rcvMain.adapter = HomeMenuAdapter(::onHomeMenuClick)
        binding.actionBar.apply {
            setImageActionBar(btnActionBarRight, R.drawable.ic_settings)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("PERF2", "HomeActivity onCreate: ${System.currentTimeMillis()}")
    }

    override fun onResume() {
        super.onResume()
        if (intent.getBooleanExtra(EXTRA_OPEN_ALBUM, false)) {
            intent.removeExtra(EXTRA_OPEN_ALBUM)
            openActivity(MyPonyActivity::class.java)
        }
        Log.d("PERF2", "HomeActivity onResume: ${System.currentTimeMillis()}")
    }

    override fun viewListener() {
        binding.actionBar.btnActionBarRight.onClick { toSettingFromHome() }
    }

    private fun onHomeMenuClick(action: HomeMenuAction) {
        when (action) {
            HomeMenuAction.CREATE -> navigateWithCheck(ChoosePonyActivity::class.java)

            HomeMenuAction.COSPLAY -> navigateWithCheck(CosplayActivity::class.java)
            HomeMenuAction.RANDOM -> navigateWithCheck(RandomActivity::class.java)
            HomeMenuAction.MY_ALBUM -> {
//                showInter {
                    openActivity(MyPonyActivity::class.java)
//                }
            }
        }
    }

    private fun navigateWithCheck(destination: Class<out Activity>) {
        val hasNetwork = InternetExtension.isInternetAvailable(this@HomeActivity) &&
                InternetExtension.isNetworkConnected(this@HomeActivity)
        val hasData = appSession.templates.value.isNotEmpty()

        when {
            !hasNetwork -> showUnstableNetworkDialog()
            !hasData -> {
                appSession.fetchOnlineTemplates()
                showLoadingDataDialog()
            }

            else -> openActivity(destination)
        }
    }

    override fun observeData() {
        binding.root.post {
            Log.d("PERF2", "HomeActivity first frame: ${System.currentTimeMillis()}")
            if (isFinishing || isDestroyed) return@post
            this@HomeActivity.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    appSession.error.collect { error ->
                        error?.let { Log.e("HomeActivity", "❌ $it") }
                    }
                }
            }
        }
    }

    override fun bindViewModel() {}

    override fun handleBackPressed(): Boolean {
        countRate = sharedPreferences.isBackRequest() + 1
        sharedPreferences.setBackRequest(countRate)
        if (!sharedPreferences.isRateRequest() && countRate % 2 == 0) {
            RateHelper.showRateDialog(this@HomeActivity, sharedPreferences) { state ->
                if (state != RateState.CANCEL) showToast(R.string.have_rated)
                this@HomeActivity.finishAffinity()

            }
        } else {
            this@HomeActivity.finishAffinity()

        }
        return true
    }
}
