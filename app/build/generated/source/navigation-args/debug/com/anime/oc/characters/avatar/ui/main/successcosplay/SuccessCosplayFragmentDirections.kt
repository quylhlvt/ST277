package com.anime.oc.characters.avatar.ui.main.successcosplay

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.anime.oc.characters.avatar.R

public class SuccessCosplayFragmentDirections private constructor() {
  public companion object {
    public fun actionSuccessCosplayToHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_successCosplay_to_home)

    public fun actionSuccessCosplayBackShow(): NavDirections =
        ActionOnlyNavDirections(R.id.action_successCosplay_back_show)
  }
}
