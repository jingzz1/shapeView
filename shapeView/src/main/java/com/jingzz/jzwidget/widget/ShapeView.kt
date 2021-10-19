package com.jingzz.jzwidget.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.jingzz.jzwidget.helper.IShapeHelper
import com.jingzz.jzwidget.helper.ShapeHelper

class ShapeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
    private val helper: ShapeHelper<ShapeView> = ShapeHelper()
) : View(context, attrs, defStyleAttr),
    IShapeHelper<ShapeView> by helper{

    init {
        helper.view = this
        helper.initAttributeSet(context,attrs)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        shapeCreate()

    }
}


