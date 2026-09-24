package com.warrior.oc.ca.ui.onboarding.intro

import androidx.annotation.StringRes
import com.warrior.oc.ca.data.model.intro.IntroModel
import com.warrior.oc.ca.R

class IntroContact {
}
data class IntroUiState(
    val pagesSplash: List<IntroModel>? = emptyList(),
    val page: Int = 0,
    @StringRes val textButtonRes: Int = R.string.next
)

sealed class IntroSingleEvent {
    data object NavigateToNextScreen : IntroSingleEvent()
}