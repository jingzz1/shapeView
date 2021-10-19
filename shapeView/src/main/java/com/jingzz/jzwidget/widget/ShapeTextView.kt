package com.jingzz.jzwidget.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import com.jingzz.jzwidget.helper.*

class ShapeTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    private val helper: ShapeHelper<ShapeTextView> = ShapeHelper(),
    private val textHelper: ShapeTextHelper = ShapeTextHelper(),
) : androidx.appcompat.widget.AppCompatTextView(context, attrs),
    IShapeHelper<ShapeTextView> by helper ,IShapeTextHelper by textHelper{
    init {
        helper.view = this
        helper.initAttributeSet(context, attrs)
//        textHelper.view = this
        textHelper.initAttributeSet(context,attrs)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        super.onTouchEvent(event)
        return textHelper.onTouchEvent(event)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        shapeCreate()
    }

    fun setOnIconClickListener(iconClick: OnIconClickListener) {
        textHelper.iconClick = iconClick
    }

    override fun shapeCreate() {
        helper.shapeCreate()
        textHelper.shapeCreate()
    }

}

