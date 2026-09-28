package com.warrior.oc.ca.ui.main.setting

import androidx.lifecycle.ViewModel
import com.warrior.oc.ca.core.helper.SharedPreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
@HiltViewModel
class SettingViewModel  @Inject constructor() : ViewModel() {
    private val _isRateButtonVisible = MutableStateFlow(!SharedPreferencesManager.isRateRequest())
    val isRateButtonVisible: StateFlow<Boolean> = _isRateButtonVisible.asStateFlow()

    fun onRateRequestCompleted() {
        _isRateButtonVisible.value = false
    }

}
