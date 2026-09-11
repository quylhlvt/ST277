package com.anime.oc.characters.avatar.ui.language

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.anime.oc.characters.avatar.R

public class LanguageFragmentDirections private constructor() {
  public companion object {
    public fun actionLanguageToIntro(): NavDirections =
        ActionOnlyNavDirections(R.id.action_language_to_intro)
  }
}
