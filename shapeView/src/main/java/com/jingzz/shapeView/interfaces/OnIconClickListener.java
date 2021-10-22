package com.jingzz.shapeView.interfaces;

import android.widget.TextView;

public interface OnIconClickListener {
    //clickType:点击的图标位置 0：左边 1:上边 2:右边 3:下边
    void click(TextView view,int clickType);
}
