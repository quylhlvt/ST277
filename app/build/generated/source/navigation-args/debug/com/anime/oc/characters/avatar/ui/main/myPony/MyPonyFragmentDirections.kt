package com.anime.oc.characters.avatar.ui.main.myPony

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.anime.oc.characters.avatar.R
import kotlin.Int
import kotlin.String

public class MyPonyFragmentDirections private constructor() {
  private data class ActionMyponyToView(
    public val imagePath: String,
    public val idEdit: String,
    public val imageType: Int = 0,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_mypony_to_view

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("imagePath", this.imagePath)
        result.putInt("imageType", this.imageType)
        result.putString("idEdit", this.idEdit)
        return result
      }
  }

  public companion object {
    public fun actionMyponyToCustom(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mypony_to_custom)

    public fun actionMyponyToView(
      imagePath: String,
      idEdit: String,
      imageType: Int = 0,
    ): NavDirections = ActionMyponyToView(imagePath, idEdit, imageType)

    public fun actionMyPonyToHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_my_pony_to_home)
  }
}
