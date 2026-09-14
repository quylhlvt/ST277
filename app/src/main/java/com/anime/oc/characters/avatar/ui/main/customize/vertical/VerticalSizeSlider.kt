package com.anime.oc.characters.avatar.ui.main.customize.vertical

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import com.anime.oc.characters.avatar.R
import kotlin.math.roundToInt

/**
 * Slider kích thước nằm ngang: giá trị tăng từ trái sang phải.
 *
 * Tên class cũ được giữ lại để tương thích với các layout đang sử dụng view này.
 */
class VerticalSizeSlider @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    var progress: Float = 0.5f // 0.0 -> 1.0
        set(value) {
            val newValue = value.coerceIn(0f, 1f)
            if (field == newValue) return
            field = newValue
            invalidate()
            onProgressChanged?.invoke(field)
        }

    var onProgressChanged: ((Float) -> Unit)? = null

    private val trackPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#FFA6A6")
        style = Paint.Style.FILL
    }
    private val thumbDrawable = requireNotNull(
        AppCompatResources.getDrawable(context, R.drawable.ic_scale_hor)
    ).mutate()
    private val trackPath = Path()

    private val thumbRadiusDp = 14f
    private val trackSmallHalfHeightDp = 3f
    private val trackLargeHalfHeightDp = 8f

    private val Float.dp: Float
        get() = this * resources.displayMetrics.density

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = (191f + thumbRadiusDp * 2f).dp.toInt() + paddingLeft + paddingRight
        val desiredHeight = (thumbRadiusDp * 2f).dp.toInt() + paddingTop + paddingBottom

        setMeasuredDimension(
            resolveSize(desiredWidth, widthMeasureSpec),
            resolveSize(desiredHeight, heightMeasureSpec)
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val radius = thumbRadius()
        val startX = paddingLeft + radius
        val endX = (width - paddingRight - radius).coerceAtLeast(startX)
        val centerY = paddingTop + contentHeight() / 2f

        val largeHalfHeight = minOf(trackLargeHalfHeightDp.dp, contentHeight() / 2f)
        val smallHalfHeight = minOf(trackSmallHalfHeightDp.dp, largeHalfHeight)
        val capControlRatio = 4f / 3f

        trackPath.reset()
        trackPath.moveTo(startX, centerY - smallHalfHeight)
        trackPath.cubicTo(
            startX - smallHalfHeight * capControlRatio,
            centerY - smallHalfHeight,
            startX - smallHalfHeight * capControlRatio,
            centerY + smallHalfHeight,
            startX,
            centerY + smallHalfHeight
        )
        trackPath.lineTo(endX, centerY + largeHalfHeight)
        trackPath.cubicTo(
            endX + largeHalfHeight * capControlRatio,
            centerY + largeHalfHeight,
            endX + largeHalfHeight * capControlRatio,
            centerY - largeHalfHeight,
            endX,
            centerY - largeHalfHeight
        )
        trackPath.close()
        canvas.drawPath(trackPath, trackPaint)

        val thumbX = startX + progress * (endX - startX)
        thumbDrawable.setBounds(
            (thumbX - radius).roundToInt(),
            (centerY - radius).roundToInt(),
            (thumbX + radius).roundToInt(),
            (centerY + radius).roundToInt()
        )
        thumbDrawable.draw(canvas)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (!isEnabled) return false

        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                parent?.requestDisallowInterceptTouchEvent(true)
                updateProgress(event.x)
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                updateProgress(event.x)
                return true
            }

            MotionEvent.ACTION_UP -> {
                updateProgress(event.x)
                parent?.requestDisallowInterceptTouchEvent(false)
                performClick()
                return true
            }

            MotionEvent.ACTION_CANCEL -> {
                parent?.requestDisallowInterceptTouchEvent(false)
                return true
            }
        }

        return super.onTouchEvent(event)
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }

    private fun updateProgress(touchX: Float) {
        val radius = thumbRadius()
        val startX = paddingLeft + radius
        val trackLength = (width - paddingLeft - paddingRight - radius * 2f)
            .coerceAtLeast(1f)

        progress = (touchX - startX) / trackLength
    }

    private fun thumbRadius(): Float = minOf(
        thumbRadiusDp.dp,
        contentHeight() / 2f,
        (width - paddingLeft - paddingRight).coerceAtLeast(0) / 2f
    )

    private fun contentHeight(): Float =
        (height - paddingTop - paddingBottom).coerceAtLeast(0).toFloat()
}
