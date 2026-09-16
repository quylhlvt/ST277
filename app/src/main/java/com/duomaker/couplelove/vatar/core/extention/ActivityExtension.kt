package com.duomaker.couplelove.vatar.core.extention
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.core.app.ShareCompat
import com.duomaker.couplelove.vatar.core.helper.RateHelper
import com.duomaker.couplelove.vatar.core.helper.SharedPreferencesManager
import com.duomaker.couplelove.vatar.utils.state.RateState

fun Activity.shareApp() {
    ShareCompat.IntentBuilder(this)
        .setType("text/plain")
        .setChooserTitle("Chooser title")
        .setText("http://play.google.com/store/apps/details?id=${this.packageName}")
        .startChooser()
}

fun Activity.policy() {
    val url = "https://sites.google.com/view/duo-maker-couple-avatar/home"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(intent)
}

fun Activity.rateApp(
    sharePreference: SharedPreferencesManager,
    onRateResult: (RateState) -> Unit = {}
) {
    RateHelper.showRateDialog(this, sharePreference, onRateResult)
}