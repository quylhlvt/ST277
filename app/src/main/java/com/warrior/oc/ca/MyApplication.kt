package com.warrior.oc.ca

import android.app.Application
import com.warrior.oc.ca.core.audio.BackgroundMusicManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        BackgroundMusicManager.register(this)
    }

}
