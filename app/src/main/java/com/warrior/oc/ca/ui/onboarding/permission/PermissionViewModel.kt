package com.warrior.oc.ca.ui.onboarding.permission

import androidx.lifecycle.ViewModel
import com.warrior.oc.ca.core.helper.PermissionHelper
import com.warrior.oc.ca.core.helper.PermissionRequestState
import com.warrior.oc.ca.core.helper.SharedPreferencesManager
import com.warrior.oc.ca.utils.key.RequestKey
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class PermissionViewModel @Inject constructor(
    private val permissionState: PermissionRequestState
) : ViewModel() {
    val storageDenyCount = permissionState.storageDenyCount
    val notificationDenyCount = permissionState.notificationDenyCount
    val cameraDenyCount = permissionState.cameraDenyCount

    fun onPermissionResult(requestCode: Int, granted: Boolean) {
        when (requestCode) {
            RequestKey.STORAGE_PERMISSION_CODE ->
                if (granted) permissionState.onStorageGranted() else permissionState.onStorageDenied()
            RequestKey.NOTIFICATION_PERMISSION_CODE ->
                if (granted) permissionState.onNotificationGranted() else permissionState.onNotificationDenied()
            RequestKey.CAMERA_PERMISSION_CODE ->
                if (granted) permissionState.onCameraGranted() else permissionState.onCameraDenied()
        }
    }

    fun shouldGoToSettings(requestCode: Int): Boolean {
        val count = when (requestCode) {
            RequestKey.STORAGE_PERMISSION_CODE -> storageDenyCount.value
            RequestKey.NOTIFICATION_PERMISSION_CODE -> notificationDenyCount.value
            RequestKey.CAMERA_PERMISSION_CODE -> cameraDenyCount.value
            else -> 0
        }
        return count >= 2
    }

    fun permissionsFor(requestCode: Int): Array<String> = when (requestCode) {
        RequestKey.STORAGE_PERMISSION_CODE -> getStoragePermissions()
        RequestKey.NOTIFICATION_PERMISSION_CODE -> getNotificationPermissions()
        RequestKey.CAMERA_PERMISSION_CODE -> getCameraPermissions()
        else -> emptyArray()
    }

    fun getStoragePermissions()      = PermissionHelper.storagePermission
    fun getNotificationPermissions() = PermissionHelper.notificationPermission
    fun getCameraPermissions()       = PermissionHelper.cameraPermission

    fun onContinue() = SharedPreferencesManager.setPermissionScreen(true)
}
