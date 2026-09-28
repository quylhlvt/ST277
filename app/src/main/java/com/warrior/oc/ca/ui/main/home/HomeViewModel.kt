package com.warrior.oc.ca.ui.main.home

import androidx.lifecycle.ViewModel
import com.warrior.oc.ca.core.helper.PermissionRequestState
import com.warrior.oc.ca.core.helper.SharedPreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val permissionState: PermissionRequestState
) : ViewModel() {
    fun onCameraPermissionDenied() = permissionState.onCameraDenied()

    fun onCameraPermissionGranted() = permissionState.onCameraGranted()

    fun shouldGoToCameraSettings(): Boolean = permissionState.cameraDenyCount.value >= 2

    fun shouldAskForRatingOnBack(): Boolean {
        val backCount = SharedPreferencesManager.isBackRequest() + 1
        SharedPreferencesManager.setBackRequest(backCount)
        return !SharedPreferencesManager.isRateRequest() && backCount % 2 == 0
    }
}
