package com.duomaker.couplelove.vatar.ui.onboarding.permission

import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import com.duomaker.couplelove.vatar.R
import com.duomaker.couplelove.vatar.core.base.BaseActivity
import com.duomaker.couplelove.vatar.core.extention.checkPermissions
import com.duomaker.couplelove.vatar.core.extention.goToSettings
import com.duomaker.couplelove.vatar.core.extention.gone
import com.duomaker.couplelove.vatar.core.extention.onClick
import com.duomaker.couplelove.vatar.core.extention.requestPermission
import com.duomaker.couplelove.vatar.core.extention.select
import com.duomaker.couplelove.vatar.core.extention.setTextActionBar
import com.duomaker.couplelove.vatar.core.extention.toHomeFromPermission
import com.duomaker.couplelove.vatar.core.extention.visible
import com.duomaker.couplelove.vatar.core.helper.PermissionHelper
import com.duomaker.couplelove.vatar.core.helper.StringHelper
import com.duomaker.couplelove.vatar.databinding.ActivityPermissionBinding
import com.duomaker.couplelove.vatar.utils.key.RequestKey
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PermissionActivity : BaseActivity<ActivityPermissionBinding, PermissionViewModel>(
    ActivityPermissionBinding::inflate, PermissionViewModel::class.java
) {
    // Some tablet builds dismiss the system permission popup when tapping
    // outside and return an empty result. Track that request across onResume.
    private var pendingPermissionRequest = false
    private var pendingStorageRequest = false

    override fun viewListener() {
        binding.swPermission.onClick(1500) { handlePermissionRequest(isStorage = true) }
        binding.swNotification.onClick(1500) { handlePermissionRequest(isStorage = false) }
        binding.tvContinue.onClick(1000) {
                    handleContinue()}
    }
    private fun isNetworkAvailable(): Boolean {
        val cm = this@PermissionActivity.getSystemService(Context.CONNECTIVITY_SERVICE)
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
    }

    private fun ActivityPermissionBinding.setupActionBar() {
        actionBar.apply {
            tvCenter.select()
            setTextActionBar(tvCenter, getString(R.string.permission))
        }
    }

// ❌ Xóa 2 dòng này
// private var storageDenyCount = 0
// private var notificationDenyCount = 0

    private fun handlePermissionRequest(isStorage: Boolean) {
        val perms = if (isStorage) PermissionHelper.storagePermission
        else PermissionHelper.notificationPermission

        when {
            this@PermissionActivity.checkPermissions(perms) ->
                showToast(if (isStorage) R.string.granted_storage else R.string.granted_notification)

            // ✅ Dùng ViewModel thay vì local count
            viewModel.shouldGoToSettings(isStorage) -> this@PermissionActivity.goToSettings()

            else -> {
                pendingPermissionRequest = true
                pendingStorageRequest = isStorage
                requestPermission(
                    perms,
                    if (isStorage) RequestKey.STORAGE_PERMISSION_CODE
                    else RequestKey.NOTIFICATION_PERMISSION_CODE
                )
            }
        }
    }
    override fun onResume() {
        super.onResume()
        // A dismissed system popup may not invoke onRequestPermissionsResult.
        if (pendingPermissionRequest) {
            val isStorage = pendingStorageRequest
            val permissions = if (isStorage) PermissionHelper.storagePermission
            else PermissionHelper.notificationPermission
            if (!this@PermissionActivity.checkPermissions(permissions)) {
                if (isStorage) viewModel.onStorageDenied()
                else viewModel.onNotificationDenied()
            }
            pendingPermissionRequest = false
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
    }
    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val requestWasPending = pendingPermissionRequest
        pendingPermissionRequest = false

        val granted = grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }

        when (requestCode) {
            RequestKey.STORAGE_PERMISSION_CODE -> {
                if (granted) {
                    viewModel.onStorageGranted()
                } else if (requestWasPending) {
                    viewModel.onStorageDenied()
                }
                // ✅ Luôn update UI dù granted hay denied
                updatePermissionUI(granted, true)
            }
            RequestKey.NOTIFICATION_PERMISSION_CODE -> {
                if (granted) {
                    viewModel.onNotificationGranted()
                } else if (requestWasPending) {
                    viewModel.onNotificationDenied()
                }
                // ✅ Luôn update UI dù granted hay denied
                updatePermissionUI(granted, false)
            }
        }
    }

    private fun updatePermissionUI(granted: Boolean, isStorage: Boolean) {
        val imageView = if (isStorage) binding.swPermission else binding.swNotification
        imageView.setImageResource(if (granted) R.drawable.switch_on else R.drawable.switch_off)
    }

    override fun observeData() {}

    override fun initText() {
        binding.actionBar.tvCenter.select()
        val textRes = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            R.string.to_access_13 else R.string.to_access

//        binding.txtPermission.text = buildString {
//            append(getString(R.string.allow))
//            append(" ")
//            append(getString(R.string.app_name))
//            append(" ")
//            append(getString(textRes))
//        }
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
