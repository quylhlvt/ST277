package com.warrior.oc.ca.ui.main.home

import android.app.Activity
import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.warrior.oc.ca.core.base.BaseActivity
import com.warrior.oc.ca.core.extention.InternetExtension
import com.warrior.oc.ca.core.extention.goToSettings
import com.warrior.oc.ca.core.extention.onClick
import com.warrior.oc.ca.core.extention.setImageActionBar
import com.warrior.oc.ca.core.extention.toCameraFromHome
import com.warrior.oc.ca.core.extention.toSettingFromHome
import com.warrior.oc.ca.core.helper.RateHelper
import com.warrior.oc.ca.utils.state.RateState
import com.warrior.oc.ca.R
import com.warrior.oc.ca.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(
    ActivityHomeBinding::inflate, HomeViewModel::class.java
) {

    private var countRate = 0

    private val cameraPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            viewModel.onCameraPermissionGranted()
            toCameraFromHome()
        } else {
            viewModel.onCameraPermissionDenied()
        }
    }

    companion object {
        const val EXTRA_OPEN_ALBUM = "open_album"
    }

    override fun initView() {
        binding.txtPlay.isSelected = true
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

        Log.d("PERF2", "HomeActivity onResume: ${System.currentTimeMillis()}")
    }

    override fun viewListener() {
        binding.actionBar.btnActionBarRight.onClick { toSettingFromHome() }
        binding.btnPlay.onClick(500) { openCamera() }
    }

    private fun openCamera() {
        val cameraGranted = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED

        when {
            cameraGranted -> {
                viewModel.onCameraPermissionGranted()
                toCameraFromHome()
            }

            viewModel.shouldGoToCameraSettings() -> goToSettings()

            else -> cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    private fun onHomeMenuClick(action: HomeMenuAction) {
//        when (action) {
//            HomeMenuAction.CREATE -> navigateWithCheck(ChoosePonyActivity::class.java)
//
//            HomeMenuAction.COSPLAY -> navigateWithCheck(CosplayActivity::class.java)
//            HomeMenuAction.RANDOM -> navigateWithCheck(RandomActivity::class.java)
//            HomeMenuAction.MY_ALBUM -> {
////                showInter {
//                    openActivity(MyPonyActivity::class.java)
////                }
//            }
//        }
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
