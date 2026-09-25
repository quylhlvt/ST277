package com.warrior.oc.ca.ui.onboarding.permission

import androidx.lifecycle.ViewModel
import com.warrior.oc.ca.core.helper.PermissionHelper
import com.warrior.oc.ca.core.helper.PermissionRequestState
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

    fun onStorageDenied() = permissionState.onStorageDenied()
    fun onStorageGranted() = permissionState.onStorageGranted()
    fun onNotificationDenied() = permissionState.onNotificationDenied()
    fun onNotificationGranted() = permissionState.onNotificationGranted()
    fun onCameraDenied() = permissionState.onCameraDenied()
    fun onCameraGranted() = permissionState.onCameraGranted()

    fun shouldGoToSettings(requestCode: Int): Boolean {
        val count = when (requestCode) {
            RequestKey.STORAGE_PERMISSION_CODE -> storageDenyCount.value
            RequestKey.NOTIFICATION_PERMISSION_CODE -> notificationDenyCount.value
            RequestKey.CAMERA_PERMISSION_CODE -> cameraDenyCount.value
            else -> 0
        }
        return count >= 2
    }

    fun getStoragePermissions()      = PermissionHelper.storagePermission
    fun getNotificationPermissions() = PermissionHelper.notificationPermission
    fun getCameraPermissions()       = PermissionHelper.cameraPermission
}
