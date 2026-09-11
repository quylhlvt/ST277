package com.anime.oc.characters.avatar.ui.onboarding.intro

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.anime.oc.characters.avatar.R

public class IntroFragmentDirections private constructor() {
  public companion object {
    public fun actionIntroToPermission(): NavDirections =
        ActionOnlyNavDirections(R.id.action_intro_to_permission)

    public fun actionIntroToHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_intro_to_home)
  }
}
