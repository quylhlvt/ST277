package com.anime.oc.characters.avatar

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.SystemClock
import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage
import androidx.viewpager2.widget.ViewPager2
import com.anime.oc.characters.avatar.ui.language.LanguageActivity
import com.anime.oc.characters.avatar.ui.language.LanguageViewModel
import com.anime.oc.characters.avatar.ui.main.home.HomeActivity
import com.anime.oc.characters.avatar.ui.main.myPony.MyPonyActivity
import com.anime.oc.characters.avatar.ui.main.setting.SettingActivity
import com.anime.oc.characters.avatar.ui.main.success.SuccessActivity
import com.anime.oc.characters.avatar.ui.onboarding.intro.IntroActivity
import com.anime.oc.characters.avatar.ui.onboarding.permission.PermissionActivity
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityNavigationTest {
    private val instrumentation = InstrumentationRegistry.getInstrumentation()
    private val preferences = instrumentation.targetContext.getSharedPreferences("DEFAULT", Context.MODE_PRIVATE)
    private val preferenceKeys = listOf("language_key", "language_screen", "permission_screen")
    private lateinit var originalPreferences: Map<String, Any?>

    @Before
    fun preparePreferences() {
        originalPreferences = preferenceKeys.associateWith { preferences.all[it] }
        preferences.edit().putString("language_key", "en")
            .putBoolean("language_screen", true).putBoolean("permission_screen", false).commit()
    }

    @After
    fun closeActivitiesAndRestorePreferences() {
        instrumentation.runOnMainSync {
            val monitor = ActivityLifecycleMonitorRegistry.getInstance()
            Stage.values().filter { it != Stage.DESTROYED }
                .flatMap { monitor.getActivitiesInStage(it).toList() }.distinct()
                .forEach { it.finish() }
        }
        instrumentation.waitForIdleSync()
        val editor = preferences.edit()
        originalPreferences.forEach { (key, value) ->
            when (value) {
                is String -> editor.putString(key, value)
                is Boolean -> editor.putBoolean(key, value)
                else -> editor.remove(key)
            }
        }
        editor.commit()
    }

    @Test
    fun languageBackReturnsToSettingsAndSharesSessionAcrossActivities() {
        ActivityScenario.launch(HomeActivity::class.java).use { scenario ->
            val home = resumedActivity<HomeActivity>()
            onView(withId(R.id.btnActionBarRight)).perform(click())
            val settings = resumedActivity<SettingActivity>()
            assertSame(home.appSession, settings.appSession)

            onView(withId(R.id.btnLang)).perform(click())
            val language = resumedActivity<LanguageActivity>()
            assertTrue(language.intent.getBooleanExtra(LanguageActivity.EXTRA_FROM_SETTING, false))
            assertSame(home.appSession, language.appSession)

            pressBack()
            assertSame(settings, resumedActivity<SettingActivity>())
            pressBack()
            assertSame(home, resumedActivity<HomeActivity>())

            scenario.recreate()
            assertSame(home.appSession, resumedActivity<HomeActivity>().appSession)
        }
    }

    @Test
    fun savedDesignOpensAlbumAndBackReturnsDirectlyHome() {
        ActivityScenario.launch(HomeActivity::class.java).use {
            val home = resumedActivity<HomeActivity>()
            instrumentation.runOnMainSync {
                home.openActivity(SuccessActivity::class.java, Bundle().apply {
                    putString("imagePath", "migration-test.png")
                    putString("avatarUrl", "test-avatar")
                })
            }
            val success = resumedActivity<SuccessActivity>()
            assertEquals("migration-test.png", success.intent.getStringExtra("imagePath"))
            assertEquals("test-avatar", success.intent.getStringExtra("avatarUrl"))
            onView(withId(R.id.btnBottomLeft)).perform(click())
            resumedActivity<MyPonyActivity>()
            pressBack()
            assertSame(home, resumedActivity<HomeActivity>())
            assertTrue(success.isFinishing || success.isDestroyed)
        }
    }

    @Test
    fun changingLanguageRebuildsHomeWithTheSelectedLocale() {
        ActivityScenario.launch(HomeActivity::class.java).use {
            val oldHome = resumedActivity<HomeActivity>()
            onView(withId(R.id.btnActionBarRight)).perform(click())
            val settings = resumedActivity<SettingActivity>()
            onView(withId(R.id.btnLang)).perform(click())
            val language = resumedActivity<LanguageActivity>()
            instrumentation.runOnMainSync {
                ViewModelProvider(language)[LanguageViewModel::class.java].selectLanguage("fr")
            }
            onView(withId(R.id.btnActionBarRight)).perform(click())
            val newHome = resumedActivity<HomeActivity>()
            assertNotSame(oldHome, newHome)
            assertEquals("fr", newHome.resources.configuration.locales[0].language)
            assertEquals("fr", preferences.getString("language_key", null))
            assertTrue(newHome.isTaskRoot)
            assertTrue(settings.isFinishing || settings.isDestroyed)
            assertTrue(language.isFinishing || language.isDestroyed)
        }
    }

    @Test
    fun onboardingFinishesIntroAndPermissionBeforeHome() {
        ActivityScenario.launch(IntroActivity::class.java).use {
            val intro = resumedActivity<IntroActivity>()
            instrumentation.runOnMainSync {
                val pager = intro.findViewById<ViewPager2>(R.id.viewPager2)
                pager.setCurrentItem(pager.adapter!!.itemCount - 1, false)
            }
            onView(withId(R.id.btnNextPager)).perform(click())
            val permission = resumedActivity<PermissionActivity>()
            onView(withId(R.id.tvContinue)).perform(click())
            val home = resumedActivity<HomeActivity>()
            assertTrue(home.isTaskRoot)
            assertTrue(intro.isFinishing || intro.isDestroyed)
            assertTrue(permission.isFinishing || permission.isDestroyed)
            assertTrue(preferences.getBoolean("permission_screen", false))
        }
    }

    private inline fun <reified T : Activity> resumedActivity(): T {
        val deadline = SystemClock.uptimeMillis() + 10_000L
        while (SystemClock.uptimeMillis() < deadline) {
            var activity: T? = null
            instrumentation.waitForIdleSync()
            instrumentation.runOnMainSync {
                activity = ActivityLifecycleMonitorRegistry.getInstance()
                    .getActivitiesInStage(Stage.RESUMED).filterIsInstance<T>().firstOrNull()
            }
            activity?.let { return it }
            SystemClock.sleep(50)
        }
        throw AssertionError("${T::class.java.simpleName} did not resume")
    }
}
