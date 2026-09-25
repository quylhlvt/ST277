package com.warrior.oc.ca.core.helper

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

/** Permission denial counts are shared by all screens in the current app session. */
@Singleton
class PermissionRequestState @Inject constructor() {
    private val storageDenials = MutableStateFlow(0)
    private val notificationDenials = MutableStateFlow(0)
    private val cameraDenials = MutableStateFlow(0)
    val storageDenyCount = storageDenials.asStateFlow()
    val notificationDenyCount = notificationDenials.asStateFlow()
    val cameraDenyCount = cameraDenials.asStateFlow()

    fun onStorageDenied() { storageDenials.value++ }
    fun onStorageGranted() { storageDenials.value = 0 }
    fun onNotificationDenied() { notificationDenials.value++ }
    fun onNotificationGranted() { notificationDenials.value = 0 }
    fun onCameraDenied() { cameraDenials.value++ }
    fun onCameraGranted() { cameraDenials.value = 0 }
}
