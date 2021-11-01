package com.jingzz.shapeView.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import com.jingzz.shapeView.R

class ShapeImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatImageView(context, attrs) {
    private var isOver = false
    private var shadowSize: Float = 0f
    private var shadowColor: Int = 0
    private var shadowDx: Float = 0f
    private var shadowDy: Float = 0f
    private var shapeBackgroundColor: Int = 0

    private var strokeWidth: Float = 0f
    private var strokeColor: Int = 0
    private var strokeDash: Float = 0f
    private var strokeGap: Float = 0f

    private var topLeftRadius: Float = 0f
    private var topRightRadius: Float = 0f
    private var bottomLeftRadius: Float = 0f
    private var bottomRightRadius: Float = 0f
    private val paint = Paint()

    init {
        context.obtainStyledAttributes(attrs, R.styleable.ShapeImageView).apply {
            isOver = getBoolean(R.styleable.ShapeImageView_shape_isOver, false)
            shadowSize = getDimension(R.styleable.ShapeImageView_shape_shadowSize, 0f)
            shadowColor = getColor(R.styleable.ShapeImageView_shape_shadowColor, 0)
            shadowDx = getDimension(R.styleable.ShapeImageView_shape_shadowDx, 0f)
            shadowDy = getDimension(R.styleable.ShapeImageView_shape_shadowDy, 0f)

            shapeBackgroundColor = getColor(R.styleable.ShapeImageView_shape_backgroundColor, 0)

            strokeWidth = getDimension(R.styleable.ShapeImageView_shape_strokeWidth, 0f)
            strokeColor = getColor(R.styleable.ShapeImageView_shape_strokeColor, 0)
            strokeDash = getDimension(R.styleable.ShapeImageView_shape_strokeDash, 0f)
            strokeGap = getDimension(R.styleable.ShapeImageView_shape_strokeGap, 0f)

            val radius = getDimension(R.styleable.ShapeImageView_shape_radius, 0f)
            topLeftRadius = getDimension(R.styleable.ShapeImageView_shape_topLeftRadius, radius)
            topRightRadius = getDimension(R.styleable.ShapeImageView_shape_topRightRadius, radius)
            bottomLeftRadius =
                getDimension(R.styleable.ShapeImageView_shape_bottomLeftRadius, radius)
            bottomRightRadius =
                getDimension(R.styleable.ShapeImageView_shape_bottomRightRadius, radius)
        }.recycle()
        paint.isAntiAlias = true
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        canvas.save()
        paint.color = shapeBackgroundColor
        paint.style = Paint.Style.FILL
        if (shadowSize > 0 || Color.alpha(shadowColor) != 0) {
            if (Color.alpha(paint.color) == 0) {
                paint.color = shadowColor
            }
            paint.setShadowLayer(shadowSize, shadowDx, shadowDy, shadowColor)
        }
        val path = Path()
        //计算绘制区域
        val rect = RectF(
            paddingStart + shadowSize * 6 / 5 - shadowDx,
            paddingTop + shadowSize * 6 / 5 - shadowDy,
            width - paddingEnd - shadowDx - shadowSize * 6 / 5,
            height - paddingBottom - shadowDy - shadowSize * 6 / 5
        )
        if (isOver)
            path.addOval(rect, Path.Direction.CW)
        else path.addRoundRect(
            rect, floatArrayOf(
                if (topLeftRadius == 0f) 0f else topLeftRadius + strokeWidth / 2,
                if (topLeftRadius == 0f) 0f else topLeftRadius + strokeWidth / 2,
                if (topRightRadius == 0f) 0f else topRightRadius + strokeWidth / 2,
                if (topRightRadius == 0f) 0f else topRightRadius + strokeWidth / 2,
                if (bottomRightRadius == 0f) 0f else bottomRightRadius + strokeWidth / 2,
                if (bottomRightRadius == 0f) 0f else bottomRightRadius + strokeWidth / 2,
                if (bottomLeftRadius == 0f) 0f else bottomLeftRadius + strokeWidth / 2,
                if (bottomLeftRadius == 0f) 0f else bottomLeftRadius + strokeWidth / 2
            ), Path.Direction.CW
        )
        if (Color.alpha(shapeBackgroundColor) == 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                canvas.clipOutPath(path)
            } else canvas.clipPath(path, Region.Op.DIFFERENCE)
            canvas.drawPath(path, paint)
            canvas.restore()
            canvas.save()
        } else canvas.drawPath(path, paint)
        canvas.clipPath(path)
        super.onDraw(canvas)
        canvas.restore()
        if (strokeWidth > 0) {
            val strokeRect = RectF(
                rect.left + strokeWidth / 2,
                rect.top + strokeWidth / 2,
                rect.right - strokeWidth / 2,
                rect.bottom - strokeWidth / 2
            )
            val strokePath = Path()
            if (isOver) strokePath.addOval(strokeRect, Path.Direction.CW)
            else strokePath.addRoundRect(
                strokeRect,
                floatArrayOf(
                    topLeftRadius,
                    topLeftRadius,
                    topRightRadius,
                    topRightRadius,
                    bottomRightRadius,
                    bottomRightRadius,
                    bottomLeftRadius,
                    bottomLeftRadius
                ),
                Path.Direction.CW
            )
            paint.apply {
                setShadowLayer(0f, 0f, 0f, 0)
                color = strokeColor
                strokeWidth = this@ShapeImageView.strokeWidth
                if (strokeDash != 0f)
                    this.pathEffect = DashPathEffect(floatArrayOf(strokeDash, strokeGap), 0f)
                style = Paint.Style.STROKE
            }
            canvas.drawPath(strokePath, paint)
        }
    }

    fun shapeCreate() = apply { invalidate() }

    fun setShapeShadowSize(shadowSize: Float): ShapeImageView {
        this.shadowSize = shadowSize
        return this
    }

    fun setShapeShadowColor(shadowColor: Int): ShapeImageView {
        this.shadowColor = shadowColor
        return this
    }

    fun setShapeShadowDx(shadowDx: Float): ShapeImageView {
        this.shadowDx = shadowDx
        return this
    }

    fun setShapeShadowDy(shadowDy: Float): ShapeImageView {
        this.shadowDy = shadowDy
        return this
    }

    fun setShapeRadius(radius: Float): ShapeImageView {
        topLeftRadius = radius
        topRightRadius = radius
        bottomLeftRadius = radius
        bottomRightRadius = radius
        return this
    }

    fun setShapeTopLeftRadius(topLeftRadius: Float): ShapeImageView {
        this.topLeftRadius = topLeftRadius
        return this
    }

    fun setShapeTopRightRadius(topRightRadius: Float): ShapeImageView {
        this.topRightRadius = topRightRadius
        return this
    }

    fun setShapeBottomLeftRadius(bottomLeftRadius: Float): ShapeImageView {
        this.bottomLeftRadius = bottomLeftRadius
        return this
    }

    fun setShapeBottomRightRadius(bottomRightRadius: Float): ShapeImageView {
        this.bottomRightRadius = bottomRightRadius
        return this
    }

    fun setShapeOver(over: Boolean): ShapeImageView {
        this.isOver = over
        return this
    }

    fun setShapeBackgroundColor(backgroundColor: Int): ShapeImageView {
        this.shapeBackgroundColor = backgroundColor
        return this
    }

    fun setShapeStrokeWidth(strokeWidth: Float): ShapeImageView {
        this.strokeWidth = strokeWidth
        return this
    }

    fun setShapeStrokeColor(strokeColor: Int): ShapeImageView {
        this.strokeColor = strokeColor
        return this
    }

    fun setShapeStrokeDash(strokeDash: Float): ShapeImageView {
        this.strokeDash = strokeDash
        return this
    }

    fun setShapeStrokeGap(strokeGap: Float): ShapeImageView {
        this.strokeGap = strokeGap
        return this
    }

    fun getShapeShadowSize(): Float = shadowSize

    fun getShapeShadowColor() = shadowColor

    fun getShapeShadowDx() = shadowDx

    fun getShapeShadowDy() = shadowDy

    fun getShapeTopLeftRadius() = topLeftRadius

    fun getShapeTopRightRadius() = topRightRadius

    fun getShapeBottomLeftRadius() = bottomLeftRadius

    fun getShapeBottomRightRadius() = bottomRightRadius

    fun isShapeOver() = isOver

    fun getShapeStrokeWidth() = strokeWidth

    fun getShapeStrokeColor() = strokeColor

    fun getShapeStrokeDash() = strokeDash

    fun getShapeStrokeGap() = strokeGap
}