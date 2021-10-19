package com.jingzz.jzwidget.drawber

import android.graphics.*
import android.graphics.drawable.Drawable

data class ShadowDrawable(
    val shadowRadius: Float = 0f,
    val shadowColor: Int = Color.WHITE,
    val shadowDx: Float = 0f,
    val shadowDy: Float = 0f,
    val shadowAlpha: Int = 255,
    val topLeftRadius: Float = 0f,
    val topRightRadius: Float = 0f,
    val bottomLeftRadius: Float = 0f,
    val bottomRightRadius: Float = 0f,
    val isOver: Boolean = false,
    val strokeWidth:Int = 0
) : Drawable() {
    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)

    init {
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.color = shadowColor
        paint.alpha = shadowAlpha
        paint.strokeCap = Paint.Cap.ROUND
        paint.isAntiAlias = true
        paint.strokeJoin = Paint.Join.MITER
        paint.isDither = false
        paint.pathEffect = CornerPathEffect(0f)
        paint.setShadowLayer(shadowRadius, shadowDx, shadowDx, shadowColor)
    }

    override fun draw(canvas: Canvas) {
        val newRound = RectF(
            bounds.left - shadowDx + shadowRadius,
            bounds.top - shadowDy + shadowRadius,
            bounds.right - shadowDx - shadowRadius,
            bounds.bottom - shadowDy - shadowRadius
        )
        val path = Path()
        if (isOver) {
            path.addOval(newRound, Path.Direction.CW)
        } else
            path.addRoundRect(
                newRound,
                floatArrayOf(
                    topLeftRadius+strokeWidth/2,
                    topLeftRadius+strokeWidth/2,
                    topRightRadius+strokeWidth/2,
                    topRightRadius+strokeWidth/2,
                    bottomRightRadius+strokeWidth/2,
                    bottomRightRadius+strokeWidth/2,
                    bottomLeftRadius+strokeWidth/2,
                    bottomLeftRadius+strokeWidth/2
                ),
                Path.Direction.CW
            )
        canvas.drawPath(path, paint)
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getOpacity() = PixelFormat.TRANSLUCENT

}