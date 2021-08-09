package com.jingzz.jzwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.jingzz.jzwidget.helper.RBaseHelper;
import com.jingzz.jzwidget.iface.RHelper;

/**
 * RConstraintLayout
 *
 * @author ZhongDaFeng
 */
public class JzConstraintLayout extends ConstraintLayout implements RHelper<RBaseHelper> {

    private RBaseHelper mHelper;

    public JzConstraintLayout(Context context) {
        this(context, null);
    }

    public JzConstraintLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JzConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHelper = new RBaseHelper(context, this, attrs);
    }

    @Override
    public RBaseHelper getHelper() {
        return mHelper;
    }

    @Override
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        mHelper.dispatchDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mHelper.onLayout(changed, left, top, right, bottom);
    }
}
