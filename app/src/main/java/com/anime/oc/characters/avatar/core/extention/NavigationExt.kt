package com.anime.oc.characters.avatar.core.extention

import android.os.Bundle
import com.anime.oc.characters.avatar.core.base.BaseActivity
import com.anime.oc.characters.avatar.ui.language.LanguageActivity
import com.anime.oc.characters.avatar.ui.main.home.HomeActivity
import com.anime.oc.characters.avatar.ui.main.setting.SettingActivity
import com.anime.oc.characters.avatar.ui.onboarding.intro.IntroActivity
import com.anime.oc.characters.avatar.ui.onboarding.permission.PermissionActivity

fun BaseActivity<*, *>.toLanguage() =
    openActivity(LanguageActivity::class.java, finishCurrent = true)

fun BaseActivity<*, *>.toIntro() =
    openActivity(IntroActivity::class.java, finishCurrent = true)

fun BaseActivity<*, *>.toPermission() =
    openActivity(PermissionActivity::class.java, finishCurrent = true)

fun BaseActivity<*, *>.toHome() =
    openActivity(HomeActivity::class.java, finishCurrent = true)

fun BaseActivity<*, *>.toHomeFromPermission() = toHome()

fun BaseActivity<*, *>.toLangFromSetting() = openActivity(
    LanguageActivity::class.java,
    Bundle().apply { putBoolean(LanguageActivity.EXTRA_FROM_SETTING, true) }
)

fun BaseActivity<*, *>.toSettingFromLang() = finish()

fun BaseActivity<*, *>.toIntroFromLanguage() = toIntro()

// Rebuild the task so all screens receive the newly selected locale.
fun BaseActivity<*, *>.toHomeFromLanguage() =
    openActivity(HomeActivity::class.java, clearTask = true)

fun BaseActivity<*, *>.toSettingFromHome() = openActivity(SettingActivity::class.java)
