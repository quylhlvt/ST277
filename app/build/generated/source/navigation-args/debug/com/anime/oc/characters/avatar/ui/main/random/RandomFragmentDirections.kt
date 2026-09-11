package com.anime.oc.characters.avatar.ui.main.random

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.anime.oc.characters.avatar.R

public class RandomFragmentDirections private constructor() {
  public companion object {
    public fun actionRandomToCustom(): NavDirections =
        ActionOnlyNavDirections(R.id.action_random_to_custom)
  }
}
