package com.warrior.oc.ca.ui.main.home

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.warrior.oc.ca.core.base.BaseActivity
import com.warrior.oc.ca.core.audio.BackgroundMusicManager
import com.warrior.oc.ca.core.extention.goToSettings
import com.warrior.oc.ca.core.extention.onClick
import com.warrior.oc.ca.core.extention.setImageActionBar
import com.warrior.oc.ca.core.extention.toCameraFromHome
import com.warrior.oc.ca.core.extention.toSettingFromHome
import com.warrior.oc.ca.core.helper.RateHelper
import com.warrior.oc.ca.utils.state.RateState
import com.warrior.oc.ca.R
import com.warrior.oc.ca.databinding.ActivityHomeBinding
import com.warrior.oc.ca.ui.main.listcat.ListCatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(
    ActivityHomeBinding::inflate, HomeViewModel::class.java
) {

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
            setImageActionBar(
                btnActionBarLeft,
                if (BackgroundMusicManager.isEnabled(this@HomeActivity)) {
                    R.drawable.ic_music_on
                } else {
                    R.drawable.ic_music_off
                }
            )
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
        binding.actionBar.btnActionBarLeft.onClick {
            val enabled = !BackgroundMusicManager.isEnabled(this)
            BackgroundMusicManager.setEnabled(this, enabled)
            setImageActionBar(
                binding.actionBar.btnActionBarLeft,
                if (enabled) R.drawable.ic_music_on else R.drawable.ic_music_off
            )
        }
        binding.btnPlay.onClick(500) { openActivity(ListCatActivity::class.java) }
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

    override fun observeData() {
        binding.root.post {
            Log.d("PERF2", "HomeActivity first frame: ${System.currentTimeMillis()}")
        }
    }

    override fun bindViewModel() {}

    override fun handleBackPressed(): Boolean {
        if (viewModel.shouldAskForRatingOnBack()) {
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
