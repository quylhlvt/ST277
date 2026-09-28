package com.warrior.oc.ca.ui.onboarding.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.warrior.oc.ca.core.helper.SharedPreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _navigateSignal = MutableStateFlow(false)
    val navigateSignal: StateFlow<Boolean> = _navigateSignal.asStateFlow()

    private val initTime = System.currentTimeMillis()

    fun triggerNavigate() { viewModelScope.launch {
        val remaining = 5_000L - (System.currentTimeMillis() - initTime)
        if (remaining > 0) delay(remaining)
        _navigateSignal.value = true
    } }

    fun shouldOpenLanguageScreen(): Boolean = !SharedPreferencesManager.isLanuageScreen()

}
