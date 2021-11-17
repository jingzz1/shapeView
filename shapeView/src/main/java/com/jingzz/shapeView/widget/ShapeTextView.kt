package com.jingzz.shapeView.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.MotionEvent
import com.jingzz.shapeView.helper.*
import com.jingzz.shapeView.interfaces.OnIconClickListener

class ShapeTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    private val helper: ShapeHelper<ShapeTextView> = ShapeHelper(),
    private val textHelper: ShapeTextHelper<ShapeTextView> = ShapeTextHelper(),
) : androidx.appcompat.widget.AppCompatTextView(context, attrs),
    IShapeHelper<ShapeTextView> by helper ,IShapeTextHelper<ShapeTextView> by textHelper{
    init {
        helper.view = this
        helper.initAttributeSet(context, attrs)
        textHelper.view = this
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
        if(helper.getShapeBackgroundColor() != Color.TRANSPARENT)
            helper.shapeCreate()
        textHelper.shapeCreate()
    }

}

