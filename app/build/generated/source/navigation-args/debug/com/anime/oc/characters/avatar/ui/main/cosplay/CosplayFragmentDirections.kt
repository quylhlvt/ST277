package com.anime.oc.characters.avatar.ui.main.cosplay

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.anime.oc.characters.avatar.R

public class CosplayFragmentDirections private constructor() {
  public companion object {
    public fun actionCosplayToShow(): NavDirections =
        ActionOnlyNavDirections(R.id.action_cosplay_to_show)
  }
}
