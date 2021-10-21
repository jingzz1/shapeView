package com.jingzz.shapeView.helper

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.IntRange
import androidx.annotation.StyleableRes
import com.jingzz.shapeView.R
import com.jingzz.shapeView.drawber.ShadowDrawable

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
    private var gradientColors = intArrayOf()
    private var gradientOrientation = GradientDrawable.Orientation.TOP_BOTTOM
    private var gradientType = GradientDrawable.SWEEP_GRADIENT
    private var gradientRadius = -1f
    private var gradientCenterX = 0.5f
    private var gradientCenterY = 0.5f

    private var focused_backgroundColor: Int = Color.TRANSPARENT
    private var focused_strokeWidth: Int = 0
    private var focused_strokeColor: Int = Color.TRANSPARENT
    private var focused_strokeDash: Float = 0f
    private var focused_strokeGap: Float = 0f
    private var focused_gradientColors = intArrayOf()
    private var focused_gradientOrientation = GradientDrawable.Orientation.TOP_BOTTOM
    private var focused_gradientType = GradientDrawable.SWEEP_GRADIENT
    private var focused_gradientRadius = -1f
    private var focused_gradientCenterX = 0.5f
    private var focused_gradientCenterY = 0.5f

    private var checked_backgroundColor: Int = Color.TRANSPARENT
    private var checked_strokeWidth: Int = 0
    private var checked_strokeColor: Int = Color.TRANSPARENT
    private var checked_strokeDash: Float = 0f
    private var checked_strokeGap: Float = 0f
    private var checked_gradientColors = intArrayOf()
    private var checked_gradientOrientation = GradientDrawable.Orientation.TOP_BOTTOM
    private var checked_gradientType = GradientDrawable.SWEEP_GRADIENT
    private var checked_gradientRadius = -1f
    private var checked_gradientCenterX = 0.5f
    private var checked_gradientCenterY = 0.5f

    private var selected_backgroundColor: Int = Color.TRANSPARENT
    private var selected_strokeWidth: Int = 0
    private var selected_strokeColor: Int = Color.TRANSPARENT
    private var selected_strokeDash: Float = 0f
    private var selected_strokeGap: Float = 0f
    private var selected_gradientColors = intArrayOf()
    private var selected_gradientOrientation = GradientDrawable.Orientation.TOP_BOTTOM
    private var selected_gradientType = GradientDrawable.SWEEP_GRADIENT
    private var selected_gradientRadius = -1f
    private var selected_gradientCenterX = 0.5f
    private var selected_gradientCenterY = 0.5f

    private var unEnabled_backgroundColor: Int = Color.TRANSPARENT
    private var unEnabled_strokeWidth: Int = 0
    private var unEnabled_strokeColor: Int = Color.TRANSPARENT
    private var unEnabled_strokeDash: Float = 0f
    private var unEnabled_strokeGap: Float = 0f
    private var unEnabled_gradientColors = intArrayOf()
    private var unEnabled_gradientOrientation = GradientDrawable.Orientation.TOP_BOTTOM
    private var unEnabled_gradientType = GradientDrawable.SWEEP_GRADIENT
    private var unEnabled_gradientRadius = -1f
    private var unEnabled_gradientCenterX = 0.5f
    private var unEnabled_gradientCenterY = 0.5f

    private var rippleColor = Color.TRANSPARENT

    fun initAttributeSet(context: Context, attrs: AttributeSet?) {
        context.obtainStyledAttributes(attrs, R.styleable.ShapeBase).apply {
            shapeShadowSize = getDimension(R.styleable.ShapeBase_shape_shadowSize, shadowRadius)
            shadowColor = getColor(R.styleable.ShapeBase_shape_shadowColor, shadowColor)
            shadowDx = getDimension(R.styleable.ShapeBase_shape_shadowDx, shadowDx)
            shadowDy = getDimension(R.styleable.ShapeBase_shape_shadowDy, shadowDy)
            shapeShadowAlpha = getInt(R.styleable.ShapeBase_shape_shadowAlpha, shadowAlpha)

            setShapeRadius(getDimension(R.styleable.ShapeBase_shape_radius, 0f))
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

            shapeRippleColor = getColor(R.styleable.ShapeBase_shape_rippleColor, rippleColor)

            shapeGradientColors =
                initColors(context, this, R.styleable.ShapeBase_shape_gradientColors)
            shapeGradientOrientation =
                initGradientOrientation(this, R.styleable.ShapeBase_shape_gradientOrientation)
            shapeGradientType = initGradientType(this, R.styleable.ShapeBase_shape_gradientType)
            shapeGradientRadius = getDimension(R.styleable.ShapeBase_shape_gradientRadius, -1f)
            shapeGradientCenterX = getFloat(R.styleable.ShapeBase_shape_gradientCenterX, 0.5f)
            shapeGradientCenterY = getFloat(R.styleable.ShapeBase_shape_gradientCenterY, 0.5f)

            shapeFocusedGradientColors =
                initColors(context, this, R.styleable.ShapeBase_shape_focused_gradientColors)
            shapeFocusedGradientOrientation = initGradientOrientation(
                this,
                R.styleable.ShapeBase_shape_focused_gradientOrientation
            )
            shapeFocusedGradientType =
                initGradientType(this, R.styleable.ShapeBase_shape_focused_gradientType)
            shapeFocusedGradientRadius =
                getDimension(R.styleable.ShapeBase_shape_focused_gradientRadius, -1f)
            shapeFocusedGradientCenterX =
                getFloat(R.styleable.ShapeBase_shape_focused_gradientCenterX, 0.5f)
            shapeFocusedGradientCenterY =
                getFloat(R.styleable.ShapeBase_shape_focused_gradientCenterY, 0.5f)

            shapeCheckedGradientColors =
                initColors(context, this, R.styleable.ShapeBase_shape_checked_gradientColors)
            shapeCheckedGradientOrientation = initGradientOrientation(
                this,
                R.styleable.ShapeBase_shape_checked_gradientOrientation
            )
            shapeCheckedGradientType =
                initGradientType(this, R.styleable.ShapeBase_shape_checked_gradientType)
            shapeCheckedGradientRadius =
                getDimension(R.styleable.ShapeBase_shape_checked_gradientRadius, -1f)
            shapeCheckedGradientCenterX =
                getFloat(R.styleable.ShapeBase_shape_checked_gradientCenterX, 0.5f)
            shapeCheckedGradientCenterY =
                getFloat(R.styleable.ShapeBase_shape_checked_gradientCenterY, 0.5f)

            shapeSelectedGradientColors =
                initColors(context, this, R.styleable.ShapeBase_shape_selected_gradientColors)
            shapeSelectedGradientOrientation = initGradientOrientation(
                this,
                R.styleable.ShapeBase_shape_selected_gradientOrientation
            )
            shapeSelectedGradientType =
                initGradientType(this, R.styleable.ShapeBase_shape_selected_gradientType)
            shapeSelectedGradientRadius =
                getDimension(R.styleable.ShapeBase_shape_selected_gradientRadius, -1f)
            shapeSelectedGradientCenterX =
                getFloat(R.styleable.ShapeBase_shape_selected_gradientCenterX, 0.5f)
            shapeSelectedGradientCenterY =
                getFloat(R.styleable.ShapeBase_shape_selected_gradientCenterY, 0.5f)

            shapeUnEnabledGradientColors =
                initColors(context, this, R.styleable.ShapeBase_shape_unEnabled_gradientColors)
            shapeUnEnabledGradientOrientation = initGradientOrientation(
                this,
                R.styleable.ShapeBase_shape_unEnabled_gradientOrientation
            )
            shapeUnEnabledGradientType =
                initGradientType(this, R.styleable.ShapeBase_shape_unEnabled_gradientType)
            shapeUnEnabledGradientRadius =
                getDimension(R.styleable.ShapeBase_shape_unEnabled_gradientRadius, -1f)
            shapeUnEnabledGradientCenterX =
                getFloat(R.styleable.ShapeBase_shape_unEnabled_gradientCenterX, 0.5f)
            shapeUnEnabledGradientCenterY =
                getFloat(R.styleable.ShapeBase_shape_unEnabled_gradientCenterY, 0.5f)
        }.recycle()
    }

    private fun initGradientType(typedArray: TypedArray, styleableRes: Int) =
        when (typedArray.getInt(styleableRes, 0)) {
            0 -> GradientDrawable.LINEAR_GRADIENT
            1 -> GradientDrawable.RADIAL_GRADIENT
            2 -> GradientDrawable.SWEEP_GRADIENT
            else -> GradientDrawable.LINEAR_GRADIENT
        }

    private fun initGradientOrientation(
        typedArray: TypedArray,
        styleableRes: Int
    ): GradientDrawable.Orientation {
        return when (typedArray.getInt(styleableRes, 0)) {
            0 -> GradientDrawable.Orientation.TOP_BOTTOM
            1 -> GradientDrawable.Orientation.TR_BL
            2 -> GradientDrawable.Orientation.RIGHT_LEFT
            3 -> GradientDrawable.Orientation.BR_TL
            4 -> GradientDrawable.Orientation.BOTTOM_TOP
            5 -> GradientDrawable.Orientation.BL_TR
            6 -> GradientDrawable.Orientation.LEFT_RIGHT
            7 -> GradientDrawable.Orientation.TL_BR
            else -> GradientDrawable.Orientation.TOP_BOTTOM
        }
    }

    private fun initColors(
        context: Context,
        array: TypedArray,
        @StyleableRes styleableRes: Int
    ): IntArray {
        val resId = array.getResourceId(styleableRes, 0)
        val list = mutableListOf<Int>()
        if (resId != 0) {
            //获取颜色列表
            if (context.resources.getResourceTypeName(resId) == "array") {
                context.resources.getIntArray(resId).forEach {
                    if (it != 0) list.add(it)
                }
                context.resources.getStringArray(resId).forEach {
                    kotlin.runCatching {
                        Color.parseColor(it).also {
                            if (it != 0) list.add(it)
                        }
                    }
                }
            }
        }
        return list.toIntArray()
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
            if (gradientColors.size > 1) {
                colors = gradientColors
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    setGradientCenter(
                        this@ShapeHelper.gradientCenterX,
                        this@ShapeHelper.gradientCenterY
                    )
                }
                gradientRadius = this@ShapeHelper.gradientRadius
                gradientType = this@ShapeHelper.gradientType
                orientation = gradientOrientation
            } else setColor(backgroundColor)
            this.shape = shape
            this.cornerRadii = cornerRadii
//            setColor(backgroundColor)
            setStroke(strokeWidth, strokeColor, strokeDash, strokeGap)

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
                    if (focused_gradientColors.size > 1) {
                        colors = focused_gradientColors
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            setGradientCenter(
                                this@ShapeHelper.focused_gradientCenterX,
                                this@ShapeHelper.focused_gradientCenterY
                            )
                        }
                        gradientRadius = this@ShapeHelper.focused_gradientRadius
                        gradientType = this@ShapeHelper.focused_gradientType
                        orientation = focused_gradientOrientation
                    } else setColor(if (Color.alpha(focused_backgroundColor) == 0) backgroundColor else focused_backgroundColor)

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
                    if (checked_gradientColors.size > 1) {
                        colors = checked_gradientColors
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            setGradientCenter(
                                this@ShapeHelper.checked_gradientCenterX,
                                this@ShapeHelper.checked_gradientCenterY
                            )
                        }
                        gradientRadius = this@ShapeHelper.checked_gradientRadius
                        gradientType = this@ShapeHelper.checked_gradientType
                        orientation = checked_gradientOrientation
                    } else
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
                    if (selected_gradientColors.size > 1) {
                        colors = selected_gradientColors
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            setGradientCenter(
                                this@ShapeHelper.selected_gradientCenterX,
                                this@ShapeHelper.selected_gradientCenterY
                            )
                        }
                        gradientRadius = this@ShapeHelper.selected_gradientRadius
                        gradientType = this@ShapeHelper.selected_gradientType
                        orientation = selected_gradientOrientation
                    } else
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
                    if (unEnabled_gradientColors.size > 1) {
                        colors = unEnabled_gradientColors
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            setGradientCenter(
                                this@ShapeHelper.unEnabled_gradientCenterX,
                                this@ShapeHelper.unEnabled_gradientCenterY
                            )
                        }
                        gradientRadius = this@ShapeHelper.unEnabled_gradientRadius
                        gradientType = this@ShapeHelper.unEnabled_gradientType
                        orientation = unEnabled_gradientOrientation
                    } else
                        setColor(if (Color.alpha(unEnabled_backgroundColor) == 0) backgroundColor else unEnabled_backgroundColor)
                    setStroke(
                        unEnabled_strokeWidth.run { if (this == 0) strokeWidth else this },
                        unEnabled_strokeColor.run { if (Color.alpha(this) == 0) strokeColor else this },
                        unEnabled_strokeDash.run { if (this == 0f) strokeDash else this },
                        unEnabled_strokeGap.run { if (this == 0f) strokeGap else this }
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

    override fun setShapeGradientColors(gradientColors: IntArray): T {
        this.gradientColors = gradientColors
        return view
    }

    override fun setShapeGradientOrientation(gradientOrientation: GradientDrawable.Orientation): T {
        this.gradientOrientation = gradientOrientation
        return view
    }

    override fun setShapeGradientType(gradientType: Int): T {
        this.gradientType = gradientType
        return view
    }

    override fun setShapeGradientRadius(gradientRadius: Float): T {
        this.gradientRadius = gradientRadius
        return view
    }

    override fun setShapeGradientCenterX(gradientCenterX: Float): T {
        this.gradientCenterX = gradientCenterX
        return view
    }

    override fun setShapeGradientCenterY(gradientCenterY: Float): T {
        this.gradientCenterY = gradientCenterY
        return view
    }

    override fun setShapeFocusedGradientColors(focusedGradientColors: IntArray): T {
        focused_gradientColors = focusedGradientColors
        return view
    }

    override fun setShapeFocusedGradientOrientation(focusedGradientOrientation: GradientDrawable.Orientation): T {
        focused_gradientOrientation = focusedGradientOrientation
        return view
    }

    override fun setShapeFocusedGradientType(focusedGradientType: Int): T {
        focused_gradientType = focusedGradientType
        return view
    }

    override fun setShapeFocusedGradientRadius(focusedGradientRadius: Float): T {
        focused_gradientRadius = focusedGradientRadius
        return view
    }

    override fun setShapeFocusedGradientCenterX(focusedGradientCenterX: Float): T {
        focused_gradientCenterX = focusedGradientCenterX
        return view
    }

    override fun setShapeFocusedGradientCenterY(focusedGradientCenterY: Float): T {
        focused_gradientCenterY = focusedGradientCenterY
        return view
    }

    override fun setShapeCheckedGradientColors(checkedGradientColors: IntArray): T {
        checked_gradientColors = checkedGradientColors
        return view
    }

    override fun setShapeCheckedGradientOrientation(checkedGradientOrientation: GradientDrawable.Orientation): T {
        checked_gradientOrientation = checkedGradientOrientation
        return view
    }

    override fun setShapeCheckedGradientType(checkedGradientType: Int): T {
        checked_gradientType = checkedGradientType
        return view
    }

    override fun setShapeCheckedGradientRadius(checkedGradientRadius: Float): T {
        checked_gradientRadius = checkedGradientRadius
        return view
    }

    override fun setShapeCheckedGradientCenterX(checkedGradientCenterX: Float): T {
        checked_gradientCenterX = checkedGradientCenterX
        return view
    }

    override fun setShapeCheckedGradientCenterY(checkedGradientCenterY: Float): T {
        checked_gradientCenterY = checkedGradientCenterY
        return view
    }

    override fun setShapeSelectedGradientColors(selectedGradientColors: IntArray): T {
        selected_gradientColors = selectedGradientColors
        return view
    }

    override fun setShapeSelectedGradientOrientation(selectedGradientOrientation: GradientDrawable.Orientation): T {
        selected_gradientOrientation = selectedGradientOrientation
        return view
    }

    override fun setShapeSelectedGradientType(selectedGradientType: Int): T {
        selected_gradientType = selectedGradientType
        return view
    }

    override fun setShapeSelectedGradientRadius(selectedGradientRadius: Float): T {
        selected_gradientRadius = selectedGradientRadius
        return view
    }

    override fun setShapeSelectedGradientCenterX(selectedGradientCenterX: Float): T {
        selected_gradientCenterX = selectedGradientCenterX
        return view
    }

    override fun setShapeSelectedGradientCenterY(selectedGradientCenterY: Float): T {
        selected_gradientCenterY = selectedGradientCenterY
        return view
    }

    override fun setShapeUnEnabledGradientColors(unEnabledGradientColors: IntArray): T {
        unEnabled_gradientColors = unEnabledGradientColors
        return view
    }

    override fun setShapeUnEnabledGradientOrientation(unEnabledGradientOrientation: GradientDrawable.Orientation): T {
        unEnabled_gradientOrientation = unEnabledGradientOrientation
        return view
    }

    override fun setShapeUnEnabledGradientType(unEnabledGradientType: Int): T {
        unEnabled_gradientType = unEnabledGradientType
        return view
    }

    override fun setShapeUnEnabledGradientRadius(unEnabledGradientRadius: Float): T {
        unEnabled_gradientRadius = unEnabledGradientRadius
        return view
    }

    override fun setShapeUnEnabledGradientCenterX(unEnabledGradientCenterX: Float): T {
        unEnabled_gradientCenterX = unEnabledGradientCenterX
        return view
    }

    override fun setShapeUnEnabledGradientCenterY(unEnabledGradientCenterY: Float): T {
        unEnabled_gradientCenterY = unEnabledGradientCenterY
        return view
    }

    override fun getShapeGradientColors(): IntArray = gradientColors

    override fun getShapeGradientOrientation() = gradientOrientation

    override fun getShapeGradientType() = gradientType

    override fun getShapeGradientRadius() = gradientRadius

    override fun getShapeGradientCenterX() = gradientCenterX

    override fun getShapeGradientCenterY() = gradientCenterY

    override fun getShapeFocusedGradientColors() = focused_gradientColors

    override fun getShapeFocusedGradientOrientation() = focused_gradientOrientation

    override fun getShapeFocusedGradientType() = focused_gradientType

    override fun getShapeFocusedGradientRadius() = focused_gradientRadius

    override fun getShapeFocusedGradientCenterX() = focused_gradientCenterX

    override fun getShapeFocusedGradientCenterY() = focused_gradientCenterY
    override fun getShapeCheckedGradientColors() = checked_gradientColors

    override fun getShapeCheckedGradientOrientation() = checked_gradientOrientation

    override fun getShapeCheckedGradientType() = checked_gradientType

    override fun getShapeCheckedGradientRadius() = shapeFocusedGradientRadius

    override fun getShapeCheckedGradientCenterX() = checked_gradientCenterX

    override fun getShapeCheckedGradientCenterY() = checked_gradientCenterY

    override fun getShapeSelectedGradientColors() = selected_gradientColors

    override fun getShapeSelectedGradientOrientation() = selected_gradientOrientation

    override fun getShapeSelectedGradientType() = selected_gradientType

    override fun getShapeSelectedGradientRadius() = selected_gradientRadius

    override fun getShapeSelectedGradientCenterX() = selected_gradientCenterX

    override fun getShapeSelectedGradientCenterY() = selected_gradientCenterY

    override fun getShapeUnEnabledGradientColors() = unEnabled_gradientColors

    override fun getShapeUnEnabledGradientOrientation() = unEnabled_gradientOrientation

    override fun getShapeUnEnabledGradientType() = unEnabled_gradientType

    override fun getShapeUnEnabledGradientRadius() = unEnabled_gradientRadius

    override fun getShapeUnEnabledGradientCenterX() = unEnabled_gradientCenterX

    override fun getShapeUnEnabledGradientCenterY() = unEnabled_gradientCenterY

}