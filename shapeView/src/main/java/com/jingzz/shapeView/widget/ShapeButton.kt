package com.jingzz.shapeView.widget

import android.content.Context
import android.util.AttributeSet
import com.jingzz.shapeView.helper.IShapeHelper
import com.jingzz.shapeView.helper.ShapeHelper

class ShapeButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    private val helper: ShapeHelper<ShapeButton> = ShapeHelper()
) : androidx.appcompat.widget.AppCompatButton(context, attrs),
IShapeHelper<ShapeButton> by helper{
    init {
        helper.view = this
        helper.initAttributeSet(context,attrs)
    }
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        shapeCreate()
    }
}