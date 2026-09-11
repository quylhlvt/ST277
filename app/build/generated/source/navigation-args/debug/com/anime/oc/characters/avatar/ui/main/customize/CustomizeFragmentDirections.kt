package com.anime.oc.characters.avatar.ui.main.customize

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.anime.oc.characters.avatar.R
import kotlin.Int
import kotlin.String

public class CustomizeFragmentDirections private constructor() {
  private data class ActionCustomizeFragmentToAddFragment(
    public val imagePath: String = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_customizeFragment_to_addFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("imagePath", this.imagePath)
        return result
      }
  }

  public companion object {
    public fun actionCustomizeFragmentToAddFragment(imagePath: String = ""): NavDirections =
        ActionCustomizeFragmentToAddFragment(imagePath)

    public fun actionCustomToMyPony(): NavDirections =
        ActionOnlyNavDirections(R.id.action_custom_to_myPony)
  }
}
