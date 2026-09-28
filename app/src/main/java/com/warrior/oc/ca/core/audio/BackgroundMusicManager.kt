package com.warrior.oc.ca.core.audio

import android.app.Activity
import android.app.Application
import android.content.Context
import android.media.MediaPlayer
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.warrior.oc.ca.R
import com.warrior.oc.ca.ui.main.catplay.CatPlayActivity
import com.warrior.oc.ca.ui.main.home.HomeActivity
import com.warrior.oc.ca.ui.main.listcat.ListCatActivity
import com.warrior.oc.ca.ui.main.lost.LostActivity
import com.warrior.oc.ca.ui.main.setting.SettingActivity

/** Plays the app theme while the user is in the app outside active gameplay. */
object BackgroundMusicManager : Application.ActivityLifecycleCallbacks {
    private const val TAG = "BackgroundMusic"
    private const val PREFERENCES = "DEFAULT"
    private const val ENABLED_KEY = "background_music_enabled"
    private const val BACKGROUND_PAUSE_DELAY_MS = 500L

    private val mainHandler = Handler(Looper.getMainLooper())
    private val delayedBackgroundPause = Runnable {
        resumedActivity = null
        pausePlayer()
    }
    private var appContext: Context? = null
    private var resumedActivity: Activity? = null
    private var player: MediaPlayer? = null
    private var isPrepared = false

    fun register(application: Application) {
        if (appContext != null) return
        appContext = application.applicationContext
        application.registerActivityLifecycleCallbacks(this)
    }

    fun isEnabled(context: Context): Boolean = preferences(context).getBoolean(ENABLED_KEY, true)

    fun setEnabled(context: Context, enabled: Boolean) {
        preferences(context).edit().putBoolean(ENABLED_KEY, enabled).apply()
        syncPlayback()
    }

    private fun preferences(context: Context) =
        context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)

    private fun syncPlayback() {
        val context = appContext ?: return
        val activity = resumedActivity
        val shouldPlay = isEnabled(context) && activity != null && !activity.isFinishing &&
            activity.isMusicScreen()

        if (!shouldPlay) {
            pausePlayer()
            return
        }

        val currentPlayer = player ?: createPlayer(context).also { player = it } ?: return
        if (isPrepared) runCatching {
            if (!currentPlayer.isPlaying) currentPlayer.start()
        }
    }

    private fun createPlayer(context: Context): MediaPlayer? = runCatching {
        MediaPlayer().apply {
            isLooping = true
            setOnPreparedListener { preparedPlayer ->
                if (player === preparedPlayer) {
                    isPrepared = true
                    syncPlayback()
                }
            }
            setOnErrorListener { failedPlayer, what, extra ->
                Log.e(TAG, "Music playback failed (what=$what, extra=$extra)")
                if (player === failedPlayer) releasePlayer()
                true
            }
            context.resources.openRawResourceFd(R.raw.music_theme).use { descriptor ->
                setDataSource(
                    descriptor.fileDescriptor,
                    descriptor.startOffset,
                    descriptor.length
                )
            }
            prepareAsync()
        }
    }.onFailure { Log.e(TAG, "Unable to load background music: R.raw.music_theme", it) }
        .getOrNull()

    private fun pausePlayer() {
        val currentPlayer = player ?: return
        if (isPrepared) runCatching {
            if (currentPlayer.isPlaying) currentPlayer.pause()
        }
    }

    private fun releasePlayer() {
        player?.let { current -> runCatching { current.release() } }
        player = null
        isPrepared = false
    }

    private fun Activity.isMusicScreen(): Boolean = when (this) {
        is HomeActivity, is ListCatActivity, is SettingActivity, is LostActivity -> true
        is CatPlayActivity -> false
        else -> false
    }

    override fun onActivityResumed(activity: Activity) {
        mainHandler.removeCallbacks(delayedBackgroundPause)
        resumedActivity = activity
        syncPlayback()
    }

    override fun onActivityPaused(activity: Activity) {
        if (resumedActivity === activity) {
            mainHandler.removeCallbacks(delayedBackgroundPause)
            mainHandler.postDelayed(delayedBackgroundPause, BACKGROUND_PAUSE_DELAY_MS)
        }
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: android.os.Bundle?) = Unit
    override fun onActivityStarted(activity: Activity) = Unit
    override fun onActivityStopped(activity: Activity) = Unit
    override fun onActivitySaveInstanceState(activity: Activity, outState: android.os.Bundle) = Unit
    override fun onActivityDestroyed(activity: Activity) {
        if (resumedActivity === activity) resumedActivity = null
    }
}
