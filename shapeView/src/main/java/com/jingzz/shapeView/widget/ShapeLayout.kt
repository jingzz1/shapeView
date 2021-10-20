package com.jingzz.shapeView.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.jingzz.shapeView.helper.IShapeHelper
import com.jingzz.shapeView.helper.ShapeHelper

class ShapeLinearLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    private val helper: ShapeHelper<ShapeLinearLayout> = ShapeHelper()
) : LinearLayout(context, attrs),
    IShapeHelper<ShapeLinearLayout> by helper {

    init {
        helper.view = this
        helper.initAttributeSet(context, attrs)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        shapeCreate()
    }

}

class ShapeRelativeLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    private val helper: ShapeHelper<ShapeRelativeLayout> = ShapeHelper()
) : RelativeLayout(context, attrs),
    IShapeHelper<ShapeRelativeLayout> by helper {

    init {
        helper.view = this
        helper.initAttributeSet(context, attrs)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        shapeCreate()
    }

}

class ShapeFrameLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    private val helper: ShapeHelper<ShapeFrameLayout> = ShapeHelper()
) : FrameLayout(context, attrs),
    IShapeHelper<ShapeFrameLayout> by helper {

    init {
        helper.view = this
        helper.initAttributeSet(context, attrs)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        shapeCreate()
    }

}

class ShapeConstraintLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    private val helper: ShapeHelper<ShapeConstraintLayout> = ShapeHelper()
) : ConstraintLayout(context, attrs),
    IShapeHelper<ShapeConstraintLayout> by helper {

    init {
        helper.view = this
        helper.initAttributeSet(context, attrs)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        shapeCreate()
    }

}