package com.anime.oc.characters.avatar.ui.main.add_character

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class AddCharacterFragmentArgs(
  public val imagePath: String = "",
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("imagePath", this.imagePath)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("imagePath", this.imagePath)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): AddCharacterFragmentArgs {
      bundle.setClassLoader(AddCharacterFragmentArgs::class.java.classLoader)
      val __imagePath : String?
      if (bundle.containsKey("imagePath")) {
        __imagePath = bundle.getString("imagePath")
        if (__imagePath == null) {
          throw IllegalArgumentException("Argument \"imagePath\" is marked as non-null but was passed a null value.")
        }
      } else {
        __imagePath = ""
      }
      return AddCharacterFragmentArgs(__imagePath)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): AddCharacterFragmentArgs {
      val __imagePath : String?
      if (savedStateHandle.contains("imagePath")) {
        __imagePath = savedStateHandle["imagePath"]
        if (__imagePath == null) {
          throw IllegalArgumentException("Argument \"imagePath\" is marked as non-null but was passed a null value")
        }
      } else {
        __imagePath = ""
      }
      return AddCharacterFragmentArgs(__imagePath)
    }
  }
}
