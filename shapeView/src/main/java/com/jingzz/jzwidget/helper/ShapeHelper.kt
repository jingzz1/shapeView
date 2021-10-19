package com.jingzz.jzwidget.helper

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.drawable.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.IntRange
import com.jingzz.jzwidget.R
import com.jingzz.jzwidget.drawber.ShadowDrawable

class ShapeHelper<T : View> : IShapeHelper<T> {

    lateinit var view: T
    private var shadowRadius: Float = 0f
    private var shadowColor: Int = Color.TRANSPARENT
    private var shadowDx: Float = 0f
    private var shadowDy: Float = 0f
    private var shadowAlpha: Int = 255

    private var topLeftRadius: Float = 0f
    private var topRightRadius: Float = 0f
    private var bottomLeftRadius: Float = 0f
    private var bottomRightRadius: Float = 0f
    private var isOver = false

    private var backgroundColor: Int = Color.TRANSPARENT
    private var strokeWidth: Int = 0
    private var strokeColor: Int = Color.TRANSPARENT
    private var strokeDash: Float = 0f
    private var strokeGap: Float = 0f

    private var focused_backgroundColor: Int = Color.TRANSPARENT
    private var focused_strokeWidth: Int = 0
    private var focused_strokeColor: Int = Color.TRANSPARENT
    private var focused_strokeDash: Float = 0f
    private var focused_strokeGap: Float = 0f

    private var checked_backgroundColor: Int = Color.TRANSPARENT
    private var checked_strokeWidth: Int = 0
    private var checked_strokeColor: Int = Color.TRANSPARENT
    private var checked_strokeDash: Float = 0f
    private var checked_strokeGap: Float = 0f

    private var selected_backgroundColor: Int = Color.TRANSPARENT
    private var selected_strokeWidth: Int = 0
    private var selected_strokeColor: Int = Color.TRANSPARENT
    private var selected_strokeDash: Float = 0f
    private var selected_strokeGap: Float = 0f

    private var unEnabled_backgroundColor: Int = Color.TRANSPARENT
    private var unEnabled_strokeWidth: Int = 0
    private var unEnabled_strokeColor: Int = Color.TRANSPARENT
    private var unEnabled_strokeDash: Float = 0f
    private var unEnabled_strokeGap: Float = 0f

    private var rippleColor = Color.TRANSPARENT

    fun initAttributeSet(context: Context, attrs: AttributeSet?) {
        context.obtainStyledAttributes(attrs, R.styleable.ShapeBase).apply {
            shapeShadowSize = getDimension(R.styleable.ShapeBase_shape_shadowSize, shadowRadius)
            shadowColor = getColor(R.styleable.ShapeBase_shape_shadowColor, shadowColor)
            shadowDx = getDimension(R.styleable.ShapeBase_shape_shadowDx, shadowDx)
            shadowDy = getDimension(R.styleable.ShapeBase_shape_shadowDy, shadowDy)
            shapeShadowAlpha = getInt(R.styleable.ShapeBase_shape_shadowAlpha, shadowAlpha)

            val shapeRadius = setShapeRadius(getDimension(R.styleable.ShapeBase_shape_radius, 0f))
            shapeTopLeftRadius =
                getDimension(R.styleable.ShapeBase_shape_topLeftRadius, topLeftRadius)
            shapeTopRightRadius =
                getDimension(R.styleable.ShapeBase_shape_topRightRadius, topRightRadius)
            shapeBottomLeftRadius =
                getDimension(R.styleable.ShapeBase_shape_bottomLeftRadius, bottomLeftRadius)
            shapeBottomRightRadius =
                getDimension(R.styleable.ShapeBase_shape_bottomRightRadius, bottomRightRadius)
            isShapeOver = getBoolean(R.styleable.ShapeBase_shape_isOver, false)

            shapeBackgroundColor =
                getColor(R.styleable.ShapeBase_shape_backgroundColor, backgroundColor)
            shapeStrokeColor = getColor(R.styleable.ShapeBase_shape_strokeColor, strokeColor)
            shapeStrokeDash = getDimension(R.styleable.ShapeBase_shape_strokeDash, strokeDash)
            shapeStrokeGap = getDimension(R.styleable.ShapeBase_shape_strokeGap, strokeGap)
            shapeStrokeWidth =
                getDimension(R.styleable.ShapeBase_shape_strokeWidth, strokeWidth.toFloat()).toInt()

            shapeFocusedBackgroundColor =
                getColor(R.styleable.ShapeBase_shape_focused_backgroundColor, backgroundColor)
            shapeFocusedStrokeColor =
                getColor(R.styleable.ShapeBase_shape_focused_strokeColor, strokeColor)
            shapeFocusedStrokeWidth =
                getDimension(
                    R.styleable.ShapeBase_shape_focused_strokeWidth,
                    strokeWidth.toFloat()
                ).toInt()
            shapeFocusedStrokeDash =
                getDimension(R.styleable.ShapeBase_shape_focused_strokeDash, strokeDash)
            shapeFocusedStrokeGap =
                getDimension(R.styleable.ShapeBase_shape_focused_strokeGap, strokeGap)

            shapeCheckedBackgroundColor =
                getColor(R.styleable.ShapeBase_shape_checked_backgroundColor, backgroundColor)
            shapeCheckedStrokeColor =
                getColor(R.styleable.ShapeBase_shape_checked_strokeColor, strokeColor)
            shapeCheckedStrokeWidth =
                getDimension(
                    R.styleable.ShapeBase_shape_checked_strokeWidth,
                    strokeWidth.toFloat()
                ).toInt()
            shapeCheckedStrokeDash =
                getDimension(R.styleable.ShapeBase_shape_checked_strokeDash, strokeDash)
            shapeCheckedStrokeGap =
                getDimension(R.styleable.ShapeBase_shape_checked_strokeGap, strokeGap)

            shapeSelectedBackgroundColor =
                getColor(R.styleable.ShapeBase_shape_selected_backgroundColor, backgroundColor)
            shapeSelectedStrokeColor =
                getColor(R.styleable.ShapeBase_shape_selected_strokeColor, strokeColor)
            shapeSelectedStrokeWidth =
                getDimension(
                    R.styleable.ShapeBase_shape_selected_strokeWidth,
                    strokeWidth.toFloat()
                ).toInt()
            shapeSelectedStrokeDash =
                getDimension(R.styleable.ShapeBase_shape_selected_strokeDash, strokeDash)
            shapeSelectedStrokeGap =
                getDimension(R.styleable.ShapeBase_shape_selected_strokeGap, strokeGap)

            shapeUnEnabledBackgroundColor =
                getColor(R.styleable.ShapeBase_shape_unEnabled_backgroundColor, backgroundColor)
            shapeUnEnabledStrokeColor =
                getColor(R.styleable.ShapeBase_shape_unEnabled_strokeColor, strokeColor)
            shapeUnEnabledStrokeWidth =
                getDimension(
                    R.styleable.ShapeBase_shape_unEnabled_strokeWidth,
                    strokeWidth.toFloat()
                ).toInt()
            shapeUnEnabledStrokeDash =
                getDimension(R.styleable.ShapeBase_shape_unEnabled_strokeDash, strokeDash)
            shapeUnEnabledStrokeGap =
                getDimension(R.styleable.ShapeBase_shape_unEnabled_strokeGap, strokeGap)

            val shapeRippleColor =
                setShapeRippleColor(getColor(R.styleable.ShapeBase_shape_rippleColor, rippleColor))

        }.recycle()
    }

    override fun shapeCreate() {
        val contentDrawable = getContentDrawble()
        if (Color.alpha(shadowColor) == 0) view.background = contentDrawable
        else {
            val shadowDrawable = ShadowDrawable(
                shadowRadius,
                shadowColor,
                shadowDx,
                shadowDy,
                shadowAlpha,
                topLeftRadius,
                topRightRadius,
                bottomLeftRadius,
                bottomRightRadius,
                isOver,
                strokeWidth
            )
            val layerDrawable = LayerDrawable(arrayOf(shadowDrawable, contentDrawable))
            layerDrawable.setLayerInset(
                1,
                (shadowRadius - shadowDx).toInt(),
                (shadowRadius - shadowDy).toInt(),
                (shadowRadius + shadowDx).toInt(),
                (shadowRadius + shadowDy).toInt()
            )
            view.background = layerDrawable
        }
    }

    private fun getContentDrawble(): Drawable {
        val stateListDrawable = StateListDrawable()
        val shape = if (isOver) GradientDrawable.OVAL else GradientDrawable.RECTANGLE
        val cornerRadii = floatArrayOf(
            topLeftRadius,
            topLeftRadius,
            topRightRadius,
            topRightRadius,
            bottomRightRadius,
            bottomRightRadius,
            bottomLeftRadius,
            bottomLeftRadius
        )

        val normalDrawable = GradientDrawable().apply {
            this.shape = shape
            this.cornerRadii = cornerRadii
            setColor(backgroundColor)
            setStroke(strokeWidth, strokeColor, strokeDash, strokeGap)
//            gradientType = GradientDrawable.RADIAL_GRADIENT
//            gradientRadius = 360f
        }

        val backDrawable = if (Color.alpha(rippleColor) == 0) normalDrawable
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                RippleDrawable(ColorStateList.valueOf(rippleColor), normalDrawable, normalDrawable)
            } else {
                StateListDrawable().apply {
                    addState(intArrayOf(android.R.attr.state_pressed),
                        LayerDrawable(arrayOf(normalDrawable,
                            GradientDrawable().apply {
                                this.shape = shape
                                this.cornerRadii = cornerRadii
                                setColor(
                                    Color.argb(
                                        Color.alpha(rippleColor) / 2,
                                        Color.red(rippleColor),
                                        Color.green(rippleColor),
                                        Color.blue(rippleColor)
                                    )
                                )
                                setStroke(strokeWidth, strokeColor, strokeDash, strokeGap)
                            }
                        ))
                    )
                    addState(intArrayOf(), normalDrawable)
                }
            }
        }

        stateListDrawable.apply {
            addState(intArrayOf(android.R.attr.state_focused),
                GradientDrawable().apply {
                    this.shape = shape
                    this.cornerRadii = cornerRadii
                    setColor(if (Color.alpha(focused_backgroundColor) == 0) backgroundColor else focused_backgroundColor)
                    setStroke(
                        focused_strokeWidth,
                        focused_strokeColor,
                        focused_strokeDash,
                        focused_strokeGap
                    )
                })
            addState(intArrayOf(android.R.attr.state_checked),
                GradientDrawable().apply {
                    this.shape = shape
                    this.cornerRadii = cornerRadii
                    setColor(if (Color.alpha(checked_backgroundColor) == 0) backgroundColor else checked_backgroundColor)
                    setStroke(
                        checked_strokeWidth,
                        checked_strokeColor,
                        checked_strokeDash,
                        checked_strokeGap
                    )
                })
            addState(intArrayOf(android.R.attr.state_selected),
                GradientDrawable().apply {
                    this.shape = shape
                    this.cornerRadii = cornerRadii
                    setColor(if (Color.alpha(selected_backgroundColor) == 0) backgroundColor else selected_backgroundColor)
                    setStroke(
                        selected_strokeWidth,
                        selected_strokeColor,
                        selected_strokeDash,
                        selected_strokeGap
                    )
                })

            unEnabled_backgroundColor = Color.RED

            addState(intArrayOf(-android.R.attr.state_enabled),
                GradientDrawable().apply {
                    this.shape = shape
                    this.cornerRadii = cornerRadii
                    setColor(if (Color.alpha(unEnabled_backgroundColor) == 0) backgroundColor else unEnabled_backgroundColor)
                    setStroke(
                        unEnabled_strokeWidth.run { if (this == 0) strokeWidth else this },
                        unEnabled_strokeColor.run { if(Color.alpha(this) == 0) strokeColor else this },
                        unEnabled_strokeDash.run { if(this == 0f) strokeDash else this },
                        unEnabled_strokeGap.run { if(this == 0f) strokeGap else this }
                    )
                })

            addState(intArrayOf(), backDrawable)
        }
        return stateListDrawable

    }


    override fun setShapeShadowSize(shadowSize: Float): T {
        this.shadowRadius = shadowSize
        return view
    }

    override fun setShapeShadowColor(shadowColor: Int): T {
        this.shadowColor = shadowColor
        return view
    }

    override fun setShapeShadowDx(shadowDx: Float): T {
        this.shadowDx = shadowDx
        return view
    }

    override fun setShapeShadowDy(shadowDy: Float): T {
        this.shadowDy = shadowDy
        return view
    }

    override fun setShapeShadowAlpha(@IntRange(from = 0, to = 255) shadowAlpha: Int): T {
        this.shadowAlpha = shadowAlpha.run {
            when {
                this <= 0 -> 0
                this >= 255 -> 255
                else -> this
            }
        }
        return view
    }

    override fun setShapeRadius(radius: Float): T {
        topLeftRadius = radius
        topRightRadius = radius
        bottomLeftRadius = radius
        bottomRightRadius = radius
        return view
    }

    override fun setShapeTopLeftRadius(topLeftRadius: Float): T {
        this.topLeftRadius = topLeftRadius
        return view
    }

    override fun setShapeTopRightRadius(topRightRadius: Float): T {
        this.topRightRadius = topRightRadius
        return view
    }

    override fun setShapeBottomLeftRadius(bottomLeftRadius: Float): T {
        this.bottomLeftRadius = bottomLeftRadius
        return view
    }

    override fun setShapeBottomRightRadius(bottomRightRadius: Float): T {
        this.bottomRightRadius = bottomRightRadius
        return view
    }

    override fun setShapeOver(over: Boolean): T {
        this.isOver = over
        return view
    }

    override fun setShapeBackgroundColor(backgroundColor: Int): T {
        this.backgroundColor = backgroundColor
        return view
    }

    override fun setShapeStrokeWidth(strokeWidth: Int): T {
        this.strokeWidth = strokeWidth
        return view
    }

    override fun setShapeStrokeColor(strokeColor: Int): T {
        this.strokeColor = strokeColor
        return view
    }

    override fun setShapeStrokeDash(strokeDash: Float): T {
        this.strokeDash = strokeDash
        return view
    }

    override fun setShapeStrokeGap(strokeGap: Float): T {
        this.strokeGap = strokeGap
        return view
    }

    override fun setShapeFocusedBackgroundColor(focused_backgroundColor: Int): T {
        this.focused_backgroundColor = focused_backgroundColor
        return view
    }

    override fun setShapeFocusedStrokeWidth(focused_strokeWidth: Int): T {
        this.focused_strokeWidth = focused_strokeWidth
        return view
    }

    override fun setShapeFocusedStrokeColor(focused_strokeColor: Int): T {
        this.focused_strokeColor = focused_strokeColor
        return view
    }

    override fun setShapeFocusedStrokeDash(focused_strokeDash: Float): T {
        this.focused_strokeDash = focused_strokeDash
        return view
    }

    override fun setShapeFocusedStrokeGap(focused_strokeGap: Float): T {
        this.focused_strokeGap = focused_strokeGap
        return view
    }

    override fun setShapeCheckedBackgroundColor(checked_backgroundColor: Int): T {
        this.checked_backgroundColor = checked_backgroundColor
        return view
    }

    override fun setShapeCheckedStrokeWidth(checked_strokeWidth: Int): T {
        this.checked_strokeWidth = checked_strokeWidth
        return view
    }

    override fun setShapeCheckedStrokeColor(checked_strokeColor: Int): T {
        this.checked_strokeColor = checked_strokeColor
        return view
    }

    override fun setShapeCheckedStrokeDash(checked_strokeDash: Float): T {
        this.checked_strokeDash = checked_strokeDash
        return view
    }

    override fun setShapeCheckedStrokeGap(checked_strokeGap: Float): T {
        this.checked_strokeGap = checked_strokeGap
        return view
    }

    override fun setShapeSelectedBackgroundColor(selected_backgroundColor: Int): T {
        this.selected_backgroundColor = selected_backgroundColor
        return view
    }

    override fun setShapeSelectedStrokeWidth(selected_strokeWidth: Int): T {
        this.selected_strokeWidth = selected_strokeWidth
        return view
    }

    override fun setShapeSelectedStrokeColor(selected_strokeColor: Int): T {
        this.selected_strokeColor = selected_strokeColor
        return view
    }

    override fun setShapeSelectedStrokeDash(selected_strokeDash: Float): T {
        this.selected_strokeDash = selected_strokeDash
        return view
    }

    override fun setShapeSelectedStrokeGap(selected_strokeGap: Float): T {
        this.selected_strokeGap = selected_strokeGap
        return view
    }

    override fun setShapeRippleColor(rippleColor: Int): T {
        this.rippleColor = rippleColor
        return view
    }

    override fun getShapeShadowSize(): Float = shadowRadius

    override fun getShapeShadowColor() = shadowColor

    override fun getShapeShadowDx() = shadowDx

    override fun getShapeShadowDy() = shadowDy

    override fun getShapeShadowAlpha() = shadowAlpha

    override fun getShapeTopLeftRadius() = topLeftRadius

    override fun getShapeTopRightRadius() = topRightRadius

    override fun getShapeBottomLeftRadius() = bottomLeftRadius

    override fun getShapeBottomRightRadius() = bottomRightRadius

    override fun isShapeOver() = isOver

    override fun getShapeStrokeWidth() = strokeWidth

    override fun getShapeStrokeColor() = strokeColor

    override fun getShapeStrokeDash() = strokeDash

    override fun getShapeStrokeGap() = strokeGap

    override fun getShapeFocusedBackgroundColor() = focused_backgroundColor

    override fun getShapeFocusedStrokeWidth() = focused_strokeWidth

    override fun getShapeFocusedStrokeColor() = focused_strokeColor

    override fun getShapeFocusedStrokeDash(): Float = focused_strokeDash

    override fun getShapeFocusedStrokeGap() = focused_strokeGap

    override fun getShapeCheckedBackgroundColor() = checked_backgroundColor

    override fun getShapeCheckedStrokeWidth() = checked_strokeWidth

    override fun getShapeCheckedStrokeColor() = checked_strokeColor

    override fun getShapeCheckedStrokeDash() = checked_strokeDash

    override fun getShapeCheckedStrokeGap() = checked_strokeGap

    override fun getShapeSelectedBackgroundColor() = selected_backgroundColor

    override fun getShapeSelectedStrokeWidth() = selected_strokeWidth

    override fun getShapeSelectedStrokeColor() = selected_strokeColor

    override fun getShapeSelectedStrokeDash() = selected_strokeDash

    override fun getShapeSelectedStrokeGap() = selected_strokeGap

    override fun getShapeRippleColor() = rippleColor
    override fun getShapeBackgroundColor() = backgroundColor
    override fun getShapeUnEnabledBackgroundColor() = unEnabled_backgroundColor

    override fun setShapeUnEnabledBackgroundColor(unEnabled_backgroundColor: Int): T {
        this.unEnabled_backgroundColor = unEnabled_backgroundColor
        return view
    }

    override fun getShapeUnEnabledStrokeWidth() = unEnabled_strokeWidth

    override fun setShapeUnEnabledStrokeWidth(unEnabled_strokeWidth: Int): T {
        this.unEnabled_strokeWidth = unEnabled_strokeWidth
        return view
    }

    override fun getShapeUnEnabledStrokeColor() = unEnabled_strokeColor

    override fun setShapeUnEnabledStrokeColor(unEnabled_strokeColor: Int): T {
        this.unEnabled_strokeColor = unEnabled_strokeColor
        return view
    }

    override fun getShapeUnEnabledStrokeDash() = unEnabled_strokeDash

    override fun setShapeUnEnabledStrokeDash(unEnabled_strokeDash: Float): T {
        this.unEnabled_strokeDash = unEnabled_strokeDash
        return view
    }

    override fun getShapeUnEnabledStrokeGap() = unEnabled_strokeGap

    override fun setShapeUnEnabledStrokeGap(unEnabled_strokeGap: Float): T {
        this.unEnabled_strokeGap = unEnabled_strokeGap
        return view
    }

}