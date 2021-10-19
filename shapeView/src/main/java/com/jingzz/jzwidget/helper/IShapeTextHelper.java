package com.jingzz.jzwidget.helper;

import android.view.MotionEvent;

public interface IShapeTextHelper{
    boolean onTouchEvent(MotionEvent ev);
    void shapeCreate();

    void setDrawableTopWidth(int drawableTopWidth);
    void setDrawableLeftWidth(int drawableLeftWidth);
    void setDrawableRightWidth(int drawableRightWidth);
    void setDrawableBottomWidth(int drawableBottomWidth);

    void setDrawableTopHeight(int drawableTopHeight);
    void setDrawableLeftHeight(int drawableLefHeight);
    void setDrawableRightHeight(int drawableRightHeight);
    void setDrawableBottomHeight(int drawableBottomHeight);

    int getDrawableTopWidth();
    int getDrawableLeftWidth();
    int getDrawableRightWidth();
    int getDrawableBottomWidth();

    int getDrawableTopHeight();
    int getDrawableLeftHeight();
    int getDrawableRightHeight();
    int getDrawableBottomHeight();

}
