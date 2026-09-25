package com.warrior.oc.ca.core.helper

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

/** Permission denial counts survive Activity and process recreation. */
@Singleton
class PermissionRequestState @Inject constructor(
    private val store: PermissionDenialStore
) {
    private val storageDenials = MutableStateFlow(store.storageDenials())
    private val notificationDenials = MutableStateFlow(store.notificationDenials())
    private val cameraDenials = MutableStateFlow(store.cameraDenials())
    val storageDenyCount = storageDenials.asStateFlow()
    val notificationDenyCount = notificationDenials.asStateFlow()
    val cameraDenyCount = cameraDenials.asStateFlow()

    fun onStorageDenied() {
        storageDenials.value++
        store.setStorageDenials(storageDenials.value)
    }

    fun onStorageGranted() {
        storageDenials.value = 0
        store.setStorageDenials(0)
    }

    fun onNotificationDenied() {
        notificationDenials.value++
        store.setNotificationDenials(notificationDenials.value)
    }

    fun onNotificationGranted() {
        notificationDenials.value = 0
        store.setNotificationDenials(0)
    }

    fun onCameraDenied() {
        cameraDenials.value++
        store.setCameraDenials(cameraDenials.value)
    }

    fun onCameraGranted() {
        cameraDenials.value = 0
        store.setCameraDenials(0)
    }
}

interface PermissionDenialStore {
    fun storageDenials(): Int
    fun setStorageDenials(count: Int)
    fun notificationDenials(): Int
    fun setNotificationDenials(count: Int)
    fun cameraDenials(): Int
    fun setCameraDenials(count: Int)
}
