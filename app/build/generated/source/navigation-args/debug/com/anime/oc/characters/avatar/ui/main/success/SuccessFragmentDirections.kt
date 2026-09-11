package com.anime.oc.characters.avatar.ui.main.success

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.anime.oc.characters.avatar.R

public class SuccessFragmentDirections private constructor() {
  public companion object {
    public fun actionSuccessToHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_success_to_home)

    public fun actionSuccessToMyPony(): NavDirections =
        ActionOnlyNavDirections(R.id.action_success_to_myPony)
  }
}
