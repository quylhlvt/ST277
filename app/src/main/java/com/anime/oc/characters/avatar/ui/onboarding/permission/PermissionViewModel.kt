package com.anime.oc.characters.avatar.ui.onboarding.permission

import androidx.lifecycle.ViewModel
import com.anime.oc.characters.avatar.core.helper.PermissionHelper
import com.anime.oc.characters.avatar.core.helper.PermissionRequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class PermissionViewModel @Inject constructor(
    private val permissionState: PermissionRequestState
) : ViewModel() {
    val storageDenyCount = permissionState.storageDenyCount
    val notificationDenyCount = permissionState.notificationDenyCount

    fun onStorageDenied() = permissionState.onStorageDenied()
    fun onStorageGranted() = permissionState.onStorageGranted()
    fun onNotificationDenied() = permissionState.onNotificationDenied()
    fun onNotificationGranted() = permissionState.onNotificationGranted()

    fun shouldGoToSettings(isStorage: Boolean): Boolean {
        val count = if (isStorage) storageDenyCount.value else notificationDenyCount.value
        return count >= 2
    }

    fun getStoragePermissions()      = PermissionHelper.storagePermission
    fun getNotificationPermissions() = PermissionHelper.notificationPermission
}
