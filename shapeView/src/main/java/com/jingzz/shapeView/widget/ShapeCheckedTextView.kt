package com.jingzz.shapeView.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import com.jingzz.shapeView.helper.*
import com.jingzz.shapeView.interfaces.OnIconClickListener

class ShapeCheckedTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    private val helper: ShapeHelper<ShapeCheckedTextView> = ShapeHelper(),
    private val textHelper: ShapeTextHelper = ShapeTextHelper(),
) : androidx.appcompat.widget.AppCompatCheckedTextView(context, attrs),
IShapeHelper<ShapeCheckedTextView> by helper, IShapeTextHelper by textHelper{
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
        helper.shapeCreate()
        textHelper.shapeCreate()
    }
}