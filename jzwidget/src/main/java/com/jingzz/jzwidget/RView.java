package com.jingzz.jzwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.jingzz.jzwidget.helper.RBaseHelper;
import com.jingzz.jzwidget.iface.RHelper;

/**
 * RView
 *
 * @author ZhongDaFeng
 */
public class RView extends View implements RHelper<RBaseHelper> {


    private RBaseHelper mHelper;

    public RView(Context context) {
        this(context, null);
    }

    public RView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHelper = new RBaseHelper(context, this, attrs);
    }

    @Override
    public RBaseHelper getHelper() {
        return mHelper;
    }
}
