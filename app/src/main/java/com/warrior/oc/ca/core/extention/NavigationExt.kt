package com.warrior.oc.ca.core.extention

import android.os.Bundle
import com.warrior.oc.ca.core.base.BaseActivity
import com.warrior.oc.ca.ui.language.LanguageActivity
import com.warrior.oc.ca.ui.main.catplay.CatPlayActivity
import com.warrior.oc.ca.ui.main.home.HomeActivity
import com.warrior.oc.ca.ui.main.setting.SettingActivity
import com.warrior.oc.ca.ui.onboarding.intro.IntroActivity
import com.warrior.oc.ca.ui.onboarding.permission.PermissionActivity
import com.warrior.oc.ca.R

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
    Bundle().apply { putBoolean(LanguageActivity.Companion.EXTRA_FROM_SETTING, true) }
)
fun BaseActivity<*, *>.toSettingFromLang() {
    finish()
    // Reverse transition: Settings slides in from the left while Language
    // slides out to the right, matching the system Back gesture.
    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
}
fun BaseActivity<*, *>.toIntroFromLanguage() = toIntro()
// Recreate Home with the new locale while keeping Language visible until Home
// draws its first frame. Clearing the whole task here causes a white flash.
fun BaseActivity<*, *>.toHomeFromLanguage(reverseAnimation: Boolean = false) {
    openActivity(
        HomeActivity::class.java,
        clearTop = true,
        recreateTarget = true
    )
    if (reverseAnimation) {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
fun BaseActivity<*, *>.toSettingFromHome() = openActivity(SettingActivity::class.java)
fun BaseActivity<*, *>.toCameraFromHome() = openActivity(CatPlayActivity::class.java)
