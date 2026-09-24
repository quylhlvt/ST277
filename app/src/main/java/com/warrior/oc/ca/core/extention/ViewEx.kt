package com.warrior.oc.ca.core.extention

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.warrior.oc.ca.utils.DataLocal

fun Context.strings(resId: Int): String = getString(resId)

fun setImageActionBar(imageView: ImageView, res: Int) {
    imageView.setImageResource(res)
    imageView.visible()
}

fun setTextActionBar(textView: TextView, text: String) {
    textView.text = text
    textView.visible()
    textView.isSelected = true
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.select() {
    isSelected = true
}

fun View.onClick(interval: Long = 200, action: (View) -> Unit) {
    setOnClickListener {
        val lastClickTime = (getTag(DataLocal.KEY_LAST_CLICK_TIME) as? Long) ?: 0L
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime >= interval) {
            action(it)
            setTag(DataLocal.KEY_LAST_CLICK_TIME, currentTime)
        }
    }
}
