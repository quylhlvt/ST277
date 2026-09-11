package com.anime.oc.characters.avatar.ui.main.show

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.anime.oc.characters.avatar.R

public class ShowFragmentDirections private constructor() {
  public companion object {
    public fun actionShowToSuccessCosplay(): NavDirections =
        ActionOnlyNavDirections(R.id.action_show_to_successCosplay)
  }
}
