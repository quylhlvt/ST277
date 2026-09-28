package com.warrior.oc.ca.ui.onboarding.permission

import android.content.pm.PackageManager
import android.os.Build
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
    override fun initView() {
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
        updatePermissionUI(this@PermissionActivity.checkPermissions(viewModel.getStoragePermissions()), true)
        updatePermissionUI(this@PermissionActivity.checkPermissions(viewModel.getNotificationPermissions()), false)
        updateCameraPermissionUI(
            this@PermissionActivity.checkPermissions(viewModel.getCameraPermissions())
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

    private fun permissionsFor(requestCode: Int): Array<String> = viewModel.permissionsFor(requestCode)

    @StringRes
    private fun grantedMessageFor(requestCode: Int): Int = when (requestCode) {
        RequestKey.STORAGE_PERMISSION_CODE -> R.string.granted_storage
        RequestKey.NOTIFICATION_PERMISSION_CODE -> R.string.granted_notification
        RequestKey.CAMERA_PERMISSION_CODE -> R.string.granted_camera
        else -> R.string.go_to_setting_message
    }

    override fun onResume() {
        super.onResume()
        // A dismissed system popup may not invoke onRequestPermissionsResult.
        pendingPermissionRequestCode?.let { requestCode ->
            val permissions = permissionsFor(requestCode)
            if (!this@PermissionActivity.checkPermissions(permissions)) {
                viewModel.onPermissionResult(requestCode, granted = false)
            }
            pendingPermissionRequestCode = null
        }
        // ✅ Cập nhật lại UI khi quay về từ Settings hoặc sau khi grant
        updatePermissionUI(
            this@PermissionActivity.checkPermissions(viewModel.getStoragePermissions()),
            true
        )
        updatePermissionUI(
            this@PermissionActivity.checkPermissions(viewModel.getNotificationPermissions()),
            false
        )
        updateCameraPermissionUI(
            this@PermissionActivity.checkPermissions(viewModel.getCameraPermissions())
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
                    viewModel.onPermissionResult(requestCode, granted = true)
                } else if (requestWasPending) {
                    viewModel.onPermissionResult(requestCode, granted = false)
                }
                // ✅ Luôn update UI dù granted hay denied
                updatePermissionUI(granted, true)
            }
            RequestKey.NOTIFICATION_PERMISSION_CODE -> {
                if (granted) {
                    viewModel.onPermissionResult(requestCode, granted = true)
                } else if (requestWasPending) {
                    viewModel.onPermissionResult(requestCode, granted = false)
                }
                // ✅ Luôn update UI dù granted hay denied
                updatePermissionUI(granted, false)
            }
            RequestKey.CAMERA_PERMISSION_CODE -> {
                if (granted) {
                    viewModel.onPermissionResult(requestCode, granted = true)
                } else if (requestWasPending) {
                    viewModel.onPermissionResult(requestCode, granted = false)
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
        viewModel.onContinue()
        toHomeFromPermission()
    }

    override fun bindViewModel() {}

    override fun handleBackPressed(): Boolean {
        this@PermissionActivity.finishAffinity()

        return true
    }
}
