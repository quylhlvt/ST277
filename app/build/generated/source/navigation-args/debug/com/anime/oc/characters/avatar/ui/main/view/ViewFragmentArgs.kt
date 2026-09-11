package com.anime.oc.characters.avatar.ui.main.view

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.String
import kotlin.jvm.JvmStatic

public data class ViewFragmentArgs(
  public val imagePath: String,
  public val idEdit: String,
  public val imageType: Int = 0,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("imagePath", this.imagePath)
    result.putInt("imageType", this.imageType)
    result.putString("idEdit", this.idEdit)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("imagePath", this.imagePath)
    result.set("imageType", this.imageType)
    result.set("idEdit", this.idEdit)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ViewFragmentArgs {
      bundle.setClassLoader(ViewFragmentArgs::class.java.classLoader)
      val __imagePath : String?
      if (bundle.containsKey("imagePath")) {
        __imagePath = bundle.getString("imagePath")
        if (__imagePath == null) {
          throw IllegalArgumentException("Argument \"imagePath\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"imagePath\" is missing and does not have an android:defaultValue")
      }
      val __imageType : Int
      if (bundle.containsKey("imageType")) {
        __imageType = bundle.getInt("imageType")
      } else {
        __imageType = 0
      }
      val __idEdit : String?
      if (bundle.containsKey("idEdit")) {
        __idEdit = bundle.getString("idEdit")
        if (__idEdit == null) {
          throw IllegalArgumentException("Argument \"idEdit\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"idEdit\" is missing and does not have an android:defaultValue")
      }
      return ViewFragmentArgs(__imagePath, __idEdit, __imageType)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): ViewFragmentArgs {
      val __imagePath : String?
      if (savedStateHandle.contains("imagePath")) {
        __imagePath = savedStateHandle["imagePath"]
        if (__imagePath == null) {
          throw IllegalArgumentException("Argument \"imagePath\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"imagePath\" is missing and does not have an android:defaultValue")
      }
      val __imageType : Int?
      if (savedStateHandle.contains("imageType")) {
        __imageType = savedStateHandle["imageType"]
        if (__imageType == null) {
          throw IllegalArgumentException("Argument \"imageType\" of type integer does not support null values")
        }
      } else {
        __imageType = 0
      }
      val __idEdit : String?
      if (savedStateHandle.contains("idEdit")) {
        __idEdit = savedStateHandle["idEdit"]
        if (__idEdit == null) {
          throw IllegalArgumentException("Argument \"idEdit\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"idEdit\" is missing and does not have an android:defaultValue")
      }
      return ViewFragmentArgs(__imagePath, __idEdit, __imageType)
    }
  }
}
