package com.warrior.oc.ca.core.extention
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.core.app.ShareCompat

fun Activity.shareApp() {
    ShareCompat.IntentBuilder(this)
        .setType("text/plain")
        .setChooserTitle("Chooser title")
        .setText("http://play.google.com/store/apps/details?id=${this.packageName}")
        .startChooser()
}

fun Activity.policy() {
    val url = "https://sites.google.com/view/warrior-cat-oc-maker-avatar/home"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(intent)
}
