package com.warrior.oc.ca.ui.main.lost

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class LostUiState(val score: Int = 0, val selectedCat: Int = 1)

@HiltViewModel
class LostViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(LostUiState())
    val uiState: StateFlow<LostUiState> = _uiState.asStateFlow()

    fun initialize(score: Int, selectedCat: Int) {
        _uiState.value = LostUiState(score.coerceAtLeast(0), selectedCat.coerceIn(1, 5))
    }
}
