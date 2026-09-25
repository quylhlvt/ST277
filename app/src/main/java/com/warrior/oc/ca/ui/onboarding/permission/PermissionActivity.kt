package com.warrior.oc.ca.ui.onboarding.permission

import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import com.warrior.oc.ca.core.base.BaseActivity
import com.warrior.oc.ca.core.extention.checkPermissions
import com.warrior.oc.ca.core.extention.goToSettings
import com.warrior.oc.ca.core.extention.gone
import com.warrior.oc.ca.core.extention.onClick
import com.warrior.oc.ca.core.extention.requestPermission
import com.warrior.oc.ca.core.extention.setTextActionBar
import com.warrior.oc.ca.core.extention.toHomeFromPermission
import com.warrior.oc.ca.core.extention.visible
import com.warrior.oc.ca.core.helper.PermissionHelper
import com.warrior.oc.ca.core.helper.StringHelper
import com.warrior.oc.ca.utils.key.RequestKey
import com.warrior.oc.ca.R
import com.warrior.oc.ca.databinding.ActivityPermissionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PermissionActivity : BaseActivity<ActivityPermissionBinding, PermissionViewModel>(
    ActivityPermissionBinding::inflate, PermissionViewModel::class.java
) {
    // Some tablet builds dismiss the system permission popup when tapping
    // outside and return an empty result. Track that request across onResume.
    private var pendingPermissionRequestCode: Int? = null

    override fun viewListener() {
        binding.swPermission.onClick(1500) {
            handlePermissionRequest(RequestKey.STORAGE_PERMISSION_CODE)
        }
        binding.swNotification.onClick(1500) {
            handlePermissionRequest(RequestKey.NOTIFICATION_PERMISSION_CODE)
        }
        binding.swCamera.onClick(1500) {
            handlePermissionRequest(RequestKey.CAMERA_PERMISSION_CODE)
        }
        binding.tvContinue.onClick(1000) {
                    handleContinue()}
    }
    private fun isNetworkAvailable(): Boolean {
        val cm = this@PermissionActivity.getSystemService(CONNECTIVITY_SERVICE)
                as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = cm.activeNetwork ?: return false
            val caps = cm.getNetworkCapabilities(network) ?: return false
            caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            @Suppress("DEPRECATION")
            cm.activeNetworkInfo?.isConnected == true
        }
    }
    private fun updateContinueMargin() {
        val marginPx = if (!isNetworkAvailable()) {
            resources.getDimensionPixelSize(R.dimen.dimension_200)
        } else {
            resources.getDimensionPixelSize(R.dimen.dimension_10)
        }
        val params = binding.tvContinue.layoutParams as? ViewGroup.MarginLayoutParams
        params?.bottomMargin = marginPx  // hoặc topMargin tuỳ layout
        binding.tvContinue.layoutParams = params
    }

    override fun initView() {
//        updateContinueMargin()

        binding.setupActionBar()
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            binding.btnStorage.visible()
            binding.btnNotification.gone()
            binding.space.gone()
        } else {
            binding.btnNotification.visible()
            binding.btnStorage.gone()
            binding.space.gone()
        }
        // cập nhật UI switch khi vào màn
        updatePermissionUI(this@PermissionActivity.checkPermissions(PermissionHelper.storagePermission), true)
        updatePermissionUI(this@PermissionActivity.checkPermissions(PermissionHelper.notificationPermission), false)
        updateCameraPermissionUI(
            this@PermissionActivity.checkPermissions(PermissionHelper.cameraPermission)
        )
    }

    private fun ActivityPermissionBinding.setupActionBar() {
        actionBar.apply {
            setTextActionBar(tvStart, getString(R.string.permission))
        }
    }

// ❌ Xóa 2 dòng này
// private var storageDenyCount = 0
// private var notificationDenyCount = 0

    private fun handlePermissionRequest(requestCode: Int) {
        val permissions = permissionsFor(requestCode)

        when {
            this@PermissionActivity.checkPermissions(permissions) ->
                showToast(grantedMessageFor(requestCode))

            viewModel.shouldGoToSettings(requestCode) -> this@PermissionActivity.goToSettings()

            else -> {
                pendingPermissionRequestCode = requestCode
                requestPermission(permissions, requestCode)
            }
        }
    }

    private fun permissionsFor(requestCode: Int): Array<String> = when (requestCode) {
        RequestKey.STORAGE_PERMISSION_CODE -> PermissionHelper.storagePermission
        RequestKey.NOTIFICATION_PERMISSION_CODE -> PermissionHelper.notificationPermission
        RequestKey.CAMERA_PERMISSION_CODE -> PermissionHelper.cameraPermission
        else -> emptyArray()
    }

    @StringRes
    private fun grantedMessageFor(requestCode: Int): Int = when (requestCode) {
        RequestKey.STORAGE_PERMISSION_CODE -> R.string.granted_storage
        RequestKey.NOTIFICATION_PERMISSION_CODE -> R.string.granted_notification
        RequestKey.CAMERA_PERMISSION_CODE -> R.string.granted_camera
        else -> R.string.go_to_setting_message
    }

    private fun onPermissionDenied(requestCode: Int) {
        when (requestCode) {
            RequestKey.STORAGE_PERMISSION_CODE -> viewModel.onStorageDenied()
            RequestKey.NOTIFICATION_PERMISSION_CODE -> viewModel.onNotificationDenied()
            RequestKey.CAMERA_PERMISSION_CODE -> viewModel.onCameraDenied()
        }
    }

    private fun onPermissionGranted(requestCode: Int) {
        when (requestCode) {
            RequestKey.STORAGE_PERMISSION_CODE -> viewModel.onStorageGranted()
            RequestKey.NOTIFICATION_PERMISSION_CODE -> viewModel.onNotificationGranted()
            RequestKey.CAMERA_PERMISSION_CODE -> viewModel.onCameraGranted()
        }
    }

    override fun onResume() {
        super.onResume()
        // A dismissed system popup may not invoke onRequestPermissionsResult.
        pendingPermissionRequestCode?.let { requestCode ->
            val permissions = permissionsFor(requestCode)
            if (!this@PermissionActivity.checkPermissions(permissions)) {
                onPermissionDenied(requestCode)
            }
            pendingPermissionRequestCode = null
        }
        // ✅ Cập nhật lại UI khi quay về từ Settings hoặc sau khi grant
        updatePermissionUI(
            this@PermissionActivity.checkPermissions(PermissionHelper.storagePermission),
            true
        )
        updatePermissionUI(
            this@PermissionActivity.checkPermissions(PermissionHelper.notificationPermission),
            false
        )
        updateCameraPermissionUI(
            this@PermissionActivity.checkPermissions(PermissionHelper.cameraPermission)
        )
    }
    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val requestWasPending = pendingPermissionRequestCode == requestCode
        pendingPermissionRequestCode = null

        val granted = grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }

        when (requestCode) {
            RequestKey.STORAGE_PERMISSION_CODE -> {
                if (granted) {
                    onPermissionGranted(requestCode)
                } else if (requestWasPending) {
                    onPermissionDenied(requestCode)
                }
                // ✅ Luôn update UI dù granted hay denied
                updatePermissionUI(granted, true)
            }
            RequestKey.NOTIFICATION_PERMISSION_CODE -> {
                if (granted) {
                    onPermissionGranted(requestCode)
                } else if (requestWasPending) {
                    onPermissionDenied(requestCode)
                }
                // ✅ Luôn update UI dù granted hay denied
                updatePermissionUI(granted, false)
            }
            RequestKey.CAMERA_PERMISSION_CODE -> {
                if (granted) {
                    onPermissionGranted(requestCode)
                } else if (requestWasPending) {
                    onPermissionDenied(requestCode)
                }
                updateCameraPermissionUI(granted)
            }
        }
    }

    private fun updatePermissionUI(granted: Boolean, isStorage: Boolean) {
        val imageView = if (isStorage) binding.swPermission else binding.swNotification
        imageView.setImageResource(if (granted) R.drawable.switch_on else R.drawable.switch_off)
    }

    private fun updateCameraPermissionUI(granted: Boolean) {
        binding.swCamera.setImageResource(
            if (granted) R.drawable.switch_on else R.drawable.switch_off
        )
    }

    override fun observeData() {}

    override fun initText() {
        val textRes = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            R.string.to_access_13 else R.string.to_access

        binding.txtPermission.text = buildString {
            append(getString(R.string.allow))
            append(" ")
            append(getString(R.string.app_name))
            append(" ")
            append(getString(textRes))
        }
    }

    private fun handleContinue() {
        sharedPreferences.setPermissionScreen(true)
        toHomeFromPermission()
    }

    override fun bindViewModel() {}

    private fun createColoredText(
        @StringRes textRes: Int,
        @ColorRes colorRes: Int,
        font: Int = R.font.baloo2_bold
    ) = StringHelper.changeColor(this@PermissionActivity, getString(textRes), colorRes, font)

    override fun handleBackPressed(): Boolean {
        this@PermissionActivity.finishAffinity()

        return true
    }
}
