package com.duomaker.couplelove.vatar

import android.app.Application
import android.util.Log
import com.tencent.mmkv.MMKV
import dagger.hilt.android.HiltAndroidApp
import java.io.File

@HiltAndroidApp                     // QUAN TRỌNG NHẤT – KHÔNG ĐƯỢC THIẾU
class MyApplication : Application() {
    companion object {
        lateinit var instance: MyApplication
            private set

        /** Dùng chung cho mọi màn hình: true nếu thiết bị là tablet. */
        val isTablet: Boolean
            get() = instance.resources.configuration.smallestScreenWidthDp >= 600
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        val mmkvDir = File(filesDir, "mmkv_store").also { it.mkdirs() }
//        AppOpenManager.getInstance().disableAppResumeWithActivity(MyApplication::class.java)
        MMKV.initialize(this, mmkvDir.absolutePath)
        Log.d("MyApplication", "MMKV initialized at: ${mmkvDir.absolutePath}")
    }

}
