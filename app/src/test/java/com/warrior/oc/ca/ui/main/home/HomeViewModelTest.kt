package com.warrior.oc.ca.ui.main.home

import com.warrior.oc.ca.core.helper.PermissionRequestState
import com.warrior.oc.ca.core.helper.PermissionDenialStore
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeViewModelTest {
    @Test
    fun cameraSettingsAreRequiredAfterTwoDenials() {
        val viewModel = HomeViewModel(PermissionRequestState(InMemoryPermissionDenialStore()))

        assertFalse(viewModel.shouldGoToCameraSettings())

        viewModel.onCameraPermissionDenied()
        assertFalse(viewModel.shouldGoToCameraSettings())

        viewModel.onCameraPermissionDenied()
        assertTrue(viewModel.shouldGoToCameraSettings())

        viewModel.onCameraPermissionGranted()
        assertFalse(viewModel.shouldGoToCameraSettings())
    }

    private class InMemoryPermissionDenialStore : PermissionDenialStore {
        private var storageCount = 0
        private var notificationCount = 0
        private var cameraCount = 0

        override fun storageDenials() = storageCount
        override fun setStorageDenials(count: Int) { storageCount = count }
        override fun notificationDenials() = notificationCount
        override fun setNotificationDenials(count: Int) { notificationCount = count }
        override fun cameraDenials() = cameraCount
        override fun setCameraDenials(count: Int) { cameraCount = count }
    }
}
