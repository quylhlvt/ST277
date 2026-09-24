package com.warrior.oc.ca.core.widget

import android.content.Context
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatTextView
import com.warrior.oc.ca.R

class GradientTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.textViewStyle
) : AppCompatTextView(context, attrs, defStyleAttr) {

    @ColorInt
    private var startColor = DEFAULT_START_COLOR

    @ColorInt
    private var endColor = DEFAULT_END_COLOR

    init {
        context.obtainStyledAttributes(
            attrs,
            R.styleable.GradientTextView,
            defStyleAttr,
            0
        ).apply {
            startColor = getColor(
                R.styleable.GradientTextView_gradientStartColor,
                DEFAULT_START_COLOR
            )
            endColor = getColor(
                R.styleable.GradientTextView_gradientEndColor,
                DEFAULT_END_COLOR
            )
            recycle()
        }
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        updateGradient()
    }

    fun setGradientColors(@ColorInt startColor: Int, @ColorInt endColor: Int) {
        this.startColor = startColor
        this.endColor = endColor
        updateGradient()
    }

    private fun updateGradient() {
        if (height <= 0) return

        val gradientTop = extendedPaddingTop.toFloat()
        val gradientBottom = (height - extendedPaddingBottom)
            .coerceAtLeast(extendedPaddingTop + 1)
            .toFloat()

        paint.shader = LinearGradient(
            0f,
            gradientTop,
            0f,
            gradientBottom,
            startColor,
            endColor,
            Shader.TileMode.CLAMP
        )
        invalidate()
    }

    private companion object {
        val DEFAULT_START_COLOR: Int = Color.parseColor("#32D3F5")
        val DEFAULT_END_COLOR: Int = Color.parseColor("#0DA1FF")
    }
}
