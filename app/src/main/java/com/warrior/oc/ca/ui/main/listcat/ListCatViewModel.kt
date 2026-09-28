package com.warrior.oc.ca.ui.main.listcat

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class ListCatUiState(
    val cats: List<String> = (1..5).map { "listcatall/$it.png" },
    val selectedCat: Int = 3
)

@HiltViewModel
class ListCatViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(ListCatUiState())
    val uiState: StateFlow<ListCatUiState> = _uiState.asStateFlow()

    fun selectCat(pageIndex: Int) {
        val state = _uiState.value
        _uiState.value = state.copy(selectedCat = (pageIndex + 1).coerceIn(1, state.cats.size))
    }
}
