package com.jingzz.shapeView.helper;

import android.graphics.drawable.GradientDrawable;

public interface IShapeHelper<T> {
    public float getShapeShadowSize();
    public T setShapeShadowSize(float shadowRadius);
    public int getShapeShadowColor();
    public T setShapeShadowColor(int shadowColor);
    public float getShapeShadowDx();
    public T setShapeShadowDx(float shadowDx);
    public float getShapeShadowDy();
    public T setShapeShadowDy(float shadowDy);
    public int getShapeShadowAlpha();
    public T setShapeShadowAlpha(int shadowAlpha);

    public T setShapeRadius(float radius);
    public float getShapeTopLeftRadius();
    public T setShapeTopLeftRadius(float topLeftRadius);
    public float getShapeTopRightRadius();
    public T setShapeTopRightRadius(float topRightRadius);
    public float getShapeBottomLeftRadius();
    public T setShapeBottomLeftRadius(float bottomLeftRadius);
    public float getShapeBottomRightRadius();
    public T setShapeBottomRightRadius(float bottomRightRadius);
    public boolean isShapeOver();
    public T setShapeOver(boolean over);

    public int getShapeBackgroundColor();
    public T setShapeBackgroundColor(int backgroundColor);
    public int getShapeStrokeWidth();
    public T setShapeStrokeWidth(int strokeWidth);
    public int getShapeStrokeColor();
    public T setShapeStrokeColor(int strokeColor);
    public float getShapeStrokeDash();
    public T setShapeStrokeDash(float strokeDash);
    public float getShapeStrokeGap();
    public T setShapeStrokeGap(float strokeGap);

    public int getShapeFocusedBackgroundColor();
    public T setShapeFocusedBackgroundColor(int focused_backgroundColor);
    public int getShapeFocusedStrokeWidth();
    public T setShapeFocusedStrokeWidth(int focused_strokeWidth);
    public int getShapeFocusedStrokeColor();
    public T setShapeFocusedStrokeColor(int focused_strokeColor);
    public float getShapeFocusedStrokeDash();
    public T setShapeFocusedStrokeDash(float focused_strokeDash);
    public float getShapeFocusedStrokeGap();
    public T setShapeFocusedStrokeGap(float focused_strokeGap);

    public int getShapeCheckedBackgroundColor();
    public T setShapeCheckedBackgroundColor(int checked_backgroundColor);
    public int getShapeCheckedStrokeWidth();
    public T setShapeCheckedStrokeWidth(int checked_strokeWidth);
    public int getShapeCheckedStrokeColor();
    public T setShapeCheckedStrokeColor(int checked_strokeColor);
    public float getShapeCheckedStrokeDash();
    public T setShapeCheckedStrokeDash(float checked_strokeDash);
    public float getShapeCheckedStrokeGap();
    public T setShapeCheckedStrokeGap(float checked_strokeGap);

    public int getShapeSelectedBackgroundColor();
    public T setShapeSelectedBackgroundColor(int selected_backgroundColor);
    public int getShapeSelectedStrokeWidth();
    public T setShapeSelectedStrokeWidth(int selected_strokeWidth);
    public int getShapeSelectedStrokeColor();
    public T setShapeSelectedStrokeColor(int selected_strokeColor);
    public float getShapeSelectedStrokeDash();
    public T setShapeSelectedStrokeDash(float selected_strokeDash);
    public float getShapeSelectedStrokeGap();
    public T setShapeSelectedStrokeGap(float selected_strokeGap);

    public int getShapeUnEnabledBackgroundColor();
    public T setShapeUnEnabledBackgroundColor(int unEnabled_backgroundColor);
    public int getShapeUnEnabledStrokeWidth();
    public T setShapeUnEnabledStrokeWidth(int unEnabled_strokeWidth);
    public int getShapeUnEnabledStrokeColor();
    public T setShapeUnEnabledStrokeColor(int unEnabled_strokeColor);
    public float getShapeUnEnabledStrokeDash();
    public T setShapeUnEnabledStrokeDash(float unEnabled_strokeDash);
    public float getShapeUnEnabledStrokeGap();
    public T setShapeUnEnabledStrokeGap(float unEnabled_strokeGap);

    public int getShapeRippleColor();
    public T setShapeRippleColor(int rippleColor);


    public T setShapeGradientColors(int[] gradientColors);

    public T setShapeGradientOrientation(GradientDrawable.Orientation gradientOrientation);

    public T setShapeGradientType(int gradientType);

    public T setShapeGradientRadius(float gradientRadius);

    public T setShapeGradientCenterX(float gradientCenterX);

    public T setShapeGradientCenterY(float gradientCenterY);

    public T setShapeFocusedGradientColors(int[] focusedGradientColors);

    public T setShapeFocusedGradientOrientation(GradientDrawable.Orientation focusedGradientOrientation);

    public T setShapeFocusedGradientType(int focusedGradientType);

    public T setShapeFocusedGradientRadius(float focusedGradientRadius);

    public T setShapeFocusedGradientCenterX(float focusedGradientCenterX);

    public T setShapeFocusedGradientCenterY(float focusedGradientCenterY);

    public T setShapeCheckedGradientColors(int[] checkedGradientColors);

    public T setShapeCheckedGradientOrientation(GradientDrawable.Orientation checkedGradientOrientation);

    public T setShapeCheckedGradientType(int checkedGradientType);

    public T setShapeCheckedGradientRadius(float checkedGradientRadius);

    public T setShapeCheckedGradientCenterX(float checkedGradientCenterX);

    public T setShapeCheckedGradientCenterY(float checkedGradientCenterY);

    public T setShapeSelectedGradientColors(int[] selectedGradientColors);

    public T setShapeSelectedGradientOrientation(GradientDrawable.Orientation selectedGradientOrientation);

    public T setShapeSelectedGradientType(int selectedGradientType);

    public T setShapeSelectedGradientRadius(float selectedGradientRadius);

    public T setShapeSelectedGradientCenterX(float selectedGradientCenterX);

    public T setShapeSelectedGradientCenterY(float selectedGradientCenterY);

    public T setShapeUnEnabledGradientColors(int[] unEnabledGradientColors);

    public T setShapeUnEnabledGradientOrientation(GradientDrawable.Orientation unEnabledGradientOrientation);

    public T setShapeUnEnabledGradientType(int unEnabledGradientType);

    public T setShapeUnEnabledGradientRadius(float unEnabledGradientRadius);

    public T setShapeUnEnabledGradientCenterX(float unEnabledGradientCenterX);

    public T setShapeUnEnabledGradientCenterY(float unEnabledGradientCenterY);

    public int[] getShapeGradientColors();

    public GradientDrawable.Orientation getShapeGradientOrientation();

    public int getShapeGradientType();

    public float getShapeGradientRadius();

    public float getShapeGradientCenterX();

    public float getShapeGradientCenterY();

    public int[] getShapeFocusedGradientColors();

    public GradientDrawable.Orientation getShapeFocusedGradientOrientation();

    public int getShapeFocusedGradientType();

    public float getShapeFocusedGradientRadius();

    public float getShapeFocusedGradientCenterX();

    public float getShapeFocusedGradientCenterY();

    public int[] getShapeCheckedGradientColors();

    public GradientDrawable.Orientation getShapeCheckedGradientOrientation();

    public int getShapeCheckedGradientType();

    public float getShapeCheckedGradientRadius();

    public float getShapeCheckedGradientCenterX();

    public float getShapeCheckedGradientCenterY();

    public int[] getShapeSelectedGradientColors();

    public GradientDrawable.Orientation getShapeSelectedGradientOrientation();

    public int getShapeSelectedGradientType();

    public float getShapeSelectedGradientRadius();

    public float getShapeSelectedGradientCenterX();

    public float getShapeSelectedGradientCenterY();

    public int[] getShapeUnEnabledGradientColors();

    public GradientDrawable.Orientation getShapeUnEnabledGradientOrientation();

    public int getShapeUnEnabledGradientType();

    public float getShapeUnEnabledGradientRadius();

    public float getShapeUnEnabledGradientCenterX();

    public float getShapeUnEnabledGradientCenterY();


    public void shapeCreate();

}
