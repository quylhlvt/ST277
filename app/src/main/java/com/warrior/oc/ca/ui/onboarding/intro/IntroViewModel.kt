package com.warrior.oc.ca.ui.onboarding.intro

import androidx.lifecycle.ViewModel
import com.warrior.oc.ca.core.helper.SharedPreferencesManager
import com.warrior.oc.ca.utils.DataLocal
import com.warrior.oc.ca.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
@HiltViewModel
class IntroViewModel @Inject constructor( private val sharedPreferences: SharedPreferencesManager
) : ViewModel() {

    private val _uiState = MutableStateFlow(IntroUiState())
    val uiState: StateFlow<IntroUiState> get() = _uiState

    private val _singleEvent = MutableSharedFlow<IntroSingleEvent>(extraBufferCapacity = 1)
    val singleEvent: Flow<IntroSingleEvent> get() = _singleEvent

    init {
        getData()
//        checkSplashScreenStatus()
    }

    private fun getData() {
        val list = DataLocal.itemIntroList
        _uiState.update { state ->
            state.copy(pagesSplash = list)
        }
        onPageChanged(currentPage = 0)
    }


    private fun navigateToNextScreen() {
        _singleEvent.tryEmit(IntroSingleEvent.NavigateToNextScreen)
    }

    fun onPageChanged(currentPage: Int) {
        _uiState.update {
            it.copy(
                page = currentPage,
                textButtonRes = R.string.next
            )
        }
    }

    fun nextPage() {
        val state = _uiState.value
        val isLastPage = state.page >= state.pagesSplash.lastIndex
        if (isLastPage) {
            navigateToNextScreen()
        } else {
            _uiState.update { state ->
                state.copy(
                    page = state.page + 1
                )
            }
        }
    }

    fun shouldOpenHomeAfterIntro(): Boolean = sharedPreferences.isPermissionScreen()


}
