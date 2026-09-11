package com.anime.oc.characters.avatar.ui.main.add_character

import android.os.Bundle
import androidx.navigation.NavDirections
import com.anime.oc.characters.avatar.R
import kotlin.Int
import kotlin.String

public class AddCharacterFragmentDirections private constructor() {
  private data class ActionAddCharacterFragmentToSuccessFragment(
    public val imagePath: String = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_addCharacterFragment_toSuccessFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("imagePath", this.imagePath)
        return result
      }
  }

  public companion object {
    public fun actionAddCharacterFragmentToSuccessFragment(imagePath: String = ""): NavDirections =
        ActionAddCharacterFragmentToSuccessFragment(imagePath)
  }
}
