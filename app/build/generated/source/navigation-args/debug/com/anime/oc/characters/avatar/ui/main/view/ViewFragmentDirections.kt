package com.anime.oc.characters.avatar.ui.main.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.anime.oc.characters.avatar.R

public class ViewFragmentDirections private constructor() {
  public companion object {
    public fun actionViewToMyPony(): NavDirections =
        ActionOnlyNavDirections(R.id.action_view_to_myPony)

    public fun actionViewToCustomize(): NavDirections =
        ActionOnlyNavDirections(R.id.action_view_to_customize)
  }
}
