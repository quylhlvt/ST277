package com.anime.oc.characters.avatar.ui.onboarding.permission

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.anime.oc.characters.avatar.R

public class PermissionFragmentDirections private constructor() {
  public companion object {
    public fun actionPermissionToHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_permission_to_home)
  }
}
