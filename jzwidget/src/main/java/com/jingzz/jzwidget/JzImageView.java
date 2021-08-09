package com.jingzz.jzwidget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * RImageView
 *
 * @author ZhongDaFeng
 */
public class JzImageView extends AppCompatImageView {

    //圆角
    private float mCorner = -1;
    private float mCornerTopLeft = 0;
    private float mCornerTopRight = 0;
    private float mCornerBottomLeft = 0;
    private float mCornerBottomRight = 0;
    //边框
    private float mBorderWidth = 0;
    private int mBorderColor = Color.BLACK;
    //是否圆形
    private boolean mIsCircle = false;
    //没有图片时的默认颜色
    private int default_color = Color.TRANSPARENT;


    private Drawable mDrawable;
    private ScaleType mScaleType;
    private int mResource;
    private ColorFilter mColorFilter;
    private PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_ATOP;

    public JzImageView(Context context) {
        this(context, null);
    }

    public JzImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttributeSet(attrs);
    }

    /**
     * 初始化自定义属性
     *
     * @param attrs
     */
    private void initAttributeSet(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.JzImageView);
        mIsCircle = a.getBoolean(R.styleable.JzImageView_jz_is_circle, false);
        mCorner = a.getDimensionPixelSize(R.styleable.JzImageView_jz_corner_radius, -1);
        mCornerTopLeft = a.getDimensionPixelSize(R.styleable.JzImageView_jz_corner_radius_top_left, 0);
        mCornerTopRight = a.getDimensionPixelSize(R.styleable.JzImageView_jz_corner_radius_top_right, 0);
        mCornerBottomLeft = a.getDimensionPixelSize(R.styleable.JzImageView_jz_corner_radius_bottom_left, 0);
        mCornerBottomRight = a.getDimensionPixelSize(R.styleable.JzImageView_jz_corner_radius_bottom_right, 0);
        mBorderWidth = a.getDimensionPixelSize(R.styleable.JzImageView_jz_border_width, 0);
        mBorderColor = a.getColor(R.styleable.JzImageView_jz_border_color, Color.BLACK);
        default_color = a.getColor(R.styleable.JzImageView_jz_default_color,default_color);
        //get system attrs
        String namespace = "http://schemas.android.com/apk/res/android";//android的命名空间
        int tintColor = attrs.getAttributeResourceValue(namespace, "tint", 0);
        if (tintColor != 0)
            mColorFilter = new PorterDuffColorFilter(getResources().getColor(tintColor), mTintMode);
        int tintMode = attrs.getAttributeIntValue(namespace, "tintMode", 0);
        if (tintMode != 0) mTintMode = wrapTintMode(tintMode);

        a.recycle();
        updateDrawableAttrs();
    }


    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override
    public void setScaleType(ScaleType scaleType) {
        super.setScaleType(scaleType);
        if (mScaleType != scaleType) {
            mScaleType = scaleType;
            updateDrawableAttrs();
            invalidate();
        }
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        mResource = 0;
        mDrawable = RoundDrawable.fromBitmap(bm);
        updateDrawableAttrs();
        super.setImageDrawable(mDrawable);
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        mResource = 0;
        mDrawable = RoundDrawable.fromDrawable(drawable);
        updateDrawableAttrs();
        super.setImageDrawable(mDrawable);
    }

    @Override
    public void setImageResource(@DrawableRes int resId) {
        if (mResource != resId) {
            mResource = resId;
            mDrawable = resolveResource();
            updateDrawableAttrs();
            super.setImageDrawable(mDrawable);
        }
    }

    @Override
    public void setImageTintList(@Nullable ColorStateList tint) {
        super.setImageTintList(tint);
        this.mColorFilter = new PorterDuffColorFilter(tint.getDefaultColor(), mTintMode);
        setColorFilter();
    }


    @Override
    public void setImageTintMode(@Nullable PorterDuff.Mode tintMode) {
        super.setImageTintMode(tintMode);
        this.mTintMode = tintMode;
        setColorFilter();
    }


    public void setColorFilter() {
        if (mColorFilter != null && mDrawable != null) {
            //ColorFilter filter = new PorterDuffColorFilter(Color.parseColor("#00FF00"), PorterDuff.Mode.SRC_ATOP);
            mDrawable.setColorFilter(mColorFilter);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawEmptyBitmap();
    }

    private Drawable resolveResource() {
        Resources resources = getResources();
        if (resources == null) {
            return null;
        }
        Drawable d = null;
        if (mResource != 0) {
            try {
                d = resources.getDrawable(mResource);
            } catch (Exception e) {
                mResource = 0;
            }
        }
        return RoundDrawable.fromDrawable(d);
    }

    private void updateDrawableAttrs() {
        updateAttrs(mDrawable, mScaleType);
        setColorFilter();
    }

    private void updateAttrs(Drawable drawable, ScaleType scaleType) {
        if (drawable instanceof RoundDrawable) {
            ((RoundDrawable) drawable).setParams(scaleType, mBorderWidth, mBorderColor, mIsCircle, mCorner, mCornerTopLeft, mCornerTopRight, mCornerBottomLeft, mCornerBottomRight);
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable ld = ((LayerDrawable) drawable);
            for (int i = 0, layers = ld.getNumberOfLayers(); i < layers; i++) {
                updateAttrs(ld.getDrawable(i), scaleType);
            }
        }
    }

    /**
     * 绘制空Bitmap
     */
    private void drawEmptyBitmap() {
        if (mDrawable == null) {//未设置Bitmap
            if(mScaleType != ScaleType.CENTER && mScaleType != ScaleType.CENTER_INSIDE)
            setImageDrawable(new ColorDrawable(default_color));
            else  setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    public JzImageView isCircle(boolean isCircle) {
        this.mIsCircle = isCircle;
        updateDrawableAttrs();
        return this;
    }

    /************************
     * Border
     ************************/
    public float getBorderWidth() {
        return mBorderWidth;
    }

    public JzImageView setBorderWidth(int borderWidth) {
        this.mBorderWidth = borderWidth;
        updateDrawableAttrs();
        return this;
    }

    public int getBorderColor() {
        return mBorderColor;
    }

    public JzImageView setBorderColor(@ColorInt int borderColor) {
        this.mBorderColor = borderColor;
        updateDrawableAttrs();
        return this;
    }

    /************************
     * Corner
     ************************/
    public float getCorner() {
        return mCorner;
    }

    public JzImageView setCorner(float corner) {
        this.mCorner = corner;
        updateDrawableAttrs();
        return this;
    }

    public float getCornerTopLeft() {
        return mCornerTopLeft;
    }

    public JzImageView setCornerTopLeft(float cornerTopLeft) {
        this.mCorner = -1;
        this.mCornerTopLeft = cornerTopLeft;
        updateDrawableAttrs();
        return this;
    }

    public float getCornerTopRight() {
        return mCornerTopRight;
    }

    public JzImageView setCornerTopRight(float cornerTopRight) {
        this.mCorner = -1;
        this.mCornerTopRight = cornerTopRight;
        updateDrawableAttrs();
        return this;
    }

    public float getCornerBottomLeft() {
        return mCornerBottomLeft;
    }

    public JzImageView setCornerBottomLeft(float cornerBottomLeft) {
        this.mCorner = -1;
        this.mCornerBottomLeft = cornerBottomLeft;
        updateDrawableAttrs();
        return this;
    }

    public float getCornerBottomRight() {
        return mCornerBottomRight;
    }

    public JzImageView setCornerBottomRight(float cornerBottomRight) {
        this.mCorner = -1;
        this.mCornerBottomRight = cornerBottomRight;
        updateDrawableAttrs();
        return this;
    }

    public JzImageView setCorner(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        this.mCorner = -1;
        this.mCornerTopLeft = topLeft;
        this.mCornerTopRight = topRight;
        this.mCornerBottomRight = bottomRight;
        this.mCornerBottomLeft = bottomLeft;
        updateDrawableAttrs();
        return this;
    }

    /**
     * 转化TintMode
     *
     * @param tintMode
     * @return
     */
    private PorterDuff.Mode wrapTintMode(int tintMode) {
        switch (tintMode) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            case 9:
            default:
                return PorterDuff.Mode.SRC_ATOP;
        }
    }
}