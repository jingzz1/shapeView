package com.jingzz.shapeView.helper

import android.view.MotionEvent




interface IShapeTextHelper<T> {
    fun onTouchEvent(ev: MotionEvent): Boolean
    fun shapeCreate()

    fun setDrawableTopWidth(drawableTopWidth: Int):T
    fun setDrawableLeftWidth(drawableLeftWidth: Int):T
    fun setDrawableRightWidth(drawableRightWidth: Int):T
    fun setDrawableBottomWidth(drawableBottomWidth: Int):T

    fun setDrawableTopHeight(drawableTopHeight: Int):T
    fun setDrawableLeftHeight(drawableLefHeight: Int):T
    fun setDrawableRightHeight(drawableRightHeight: Int):T
    fun setDrawableBottomHeight(drawableBottomHeight: Int):T

    fun getDrawableTopWidth(): Int
    fun getDrawableLeftWidth(): Int
    fun getDrawableRightWidth(): Int
    fun getDrawableBottomWidth(): Int

    fun getDrawableTopHeight(): Int
    fun getDrawableLeftHeight(): Int
    fun getDrawableRightHeight(): Int
    fun getDrawableBottomHeight(): Int
}