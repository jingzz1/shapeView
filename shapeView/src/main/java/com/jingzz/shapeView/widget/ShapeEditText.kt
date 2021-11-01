package com.jingzz.shapeView.widget

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import com.jingzz.shapeView.helper.*
import com.jingzz.shapeView.interfaces.OnIconClickListener

class ShapeEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    val helper: ShapeHelper<ShapeEditText> = ShapeHelper(),
     val textHelper:ShapeTextHelper<ShapeEditText> = ShapeTextHelper()
) : androidx.appcompat.widget.AppCompatEditText(context, attrs),
IShapeHelper<ShapeEditText> by helper,IShapeTextHelper<ShapeEditText> by textHelper{
    private var coColor = 0
    init {
        helper.view = this
        helper.initAttributeSet(context,attrs)
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

    override fun shapeCreate() {
        helper.shapeCreate()
        textHelper.shapeCreate()
    }


    fun setOnIconClickListener(iconClick: OnIconClickListener) {
        textHelper.iconClick = iconClick
    }
}