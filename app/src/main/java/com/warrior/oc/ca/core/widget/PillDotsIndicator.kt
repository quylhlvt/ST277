package com.warrior.oc.ca.core.widget

import android.content.Context
import android.graphics.drawable.GradientDrawable.Orientation
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.warrior.oc.ca.R

class PillDotsIndicator @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var pager: ViewPager2? = null
    private val pageCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            selectDot(position)
        }
    }

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER
    }

    fun attachTo(viewPager: ViewPager2) {
        pager?.unregisterOnPageChangeCallback(pageCallback)
        pager = viewPager
        viewPager.registerOnPageChangeCallback(pageCallback)
        createDots(viewPager.adapter?.itemCount ?: 0)
        selectDot(viewPager.currentItem)
    }

    private fun createDots(count: Int) {
        removeAllViews()
        repeat(count) {
            addView(View(context), dotLayoutParams(selected = false))
        }
    }

    private fun selectDot(selectedPosition: Int) {
        for (position in 0 until childCount) {
            val selected = position == selectedPosition
            getChildAt(position).apply {
                layoutParams = dotLayoutParams(selected)
                background = pillBackground(selected)
            }
        }
    }

    private fun dotLayoutParams(selected: Boolean) = LayoutParams(
        dp(if (selected) SELECTED_WIDTH_DP else DOT_SIZE_DP),
        dp(DOT_SIZE_DP)
    ).apply {
        marginStart = dp(DOT_SPACING_DP)
        marginEnd = dp(DOT_SPACING_DP)
    }

    private fun pillBackground(selected: Boolean) = GradientDrawable().apply {
        shape = GradientDrawable.RECTANGLE
        cornerRadius = dp(DOT_SIZE_DP) / 2f
        if (selected) {
            orientation = Orientation.TOP_BOTTOM
            colors = intArrayOf(
                ContextCompat.getColor(context, R.color.list_cat_selected_dot_top),
                ContextCompat.getColor(context, R.color.list_cat_selected_dot_bottom)
            )
        } else {
            setColor(ContextCompat.getColor(context, R.color.white))
        }
    }

    override fun onDetachedFromWindow() {
        pager?.unregisterOnPageChangeCallback(pageCallback)
        pager = null
        super.onDetachedFromWindow()
    }

    private fun dp(value: Int) = (value * resources.displayMetrics.density).toInt()

    private companion object {
        const val DOT_SIZE_DP = 8
        const val SELECTED_WIDTH_DP = 20
        const val DOT_SPACING_DP = 3
    }
}
