package com.anime.oc.characters.avatar.ui.main.setting

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.anime.oc.characters.avatar.R

public class SettingFragmentDirections private constructor() {
  public companion object {
    public fun actionSettingToHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_setting_to_home)

    public fun actionSettingToLanguage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_setting_to_language)
  }
}
