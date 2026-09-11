package com.anime.oc.characters.avatar.ui.main.home

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.anime.oc.characters.avatar.R

public class HomeFragmentDirections private constructor() {
  public companion object {
    public fun actionHomeToCreatePony(): NavDirections =
        ActionOnlyNavDirections(R.id.action_home_to_createPony)

    public fun actionHomeToMyPony(): NavDirections =
        ActionOnlyNavDirections(R.id.action_home_to_myPony)

    public fun actionHomeToCosplay(): NavDirections =
        ActionOnlyNavDirections(R.id.action_home_to_cosplay)

    public fun actionHomeToRandom(): NavDirections =
        ActionOnlyNavDirections(R.id.action_home_to_random)

    public fun actionHomeToSetting(): NavDirections =
        ActionOnlyNavDirections(R.id.action_home_to_setting)
  }
}
