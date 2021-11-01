package com.jingzz.shapeView.helper

import android.graphics.drawable.GradientDrawable


interface IShapeHelper<T> {
    fun getShapeShadowSize(): Float
    fun setShapeShadowSize(shadowRadius: Float): T
    fun getShapeShadowColor(): Int
    fun setShapeShadowColor(shadowColor: Int): T
    fun getShapeShadowDx(): Float
    fun setShapeShadowDx(shadowDx: Float): T
    fun getShapeShadowDy(): Float
    fun setShapeShadowDy(shadowDy: Float): T
    fun getShapeShadowAlpha(): Int
    fun setShapeShadowAlpha(shadowAlpha: Int): T

    fun setShapeRadius(radius: Float): T
    fun getShapeTopLeftRadius(): Float
    fun setShapeTopLeftRadius(topLeftRadius: Float): T
    fun getShapeTopRightRadius(): Float
    fun setShapeTopRightRadius(topRightRadius: Float): T
    fun getShapeBottomLeftRadius(): Float
    fun setShapeBottomLeftRadius(bottomLeftRadius: Float): T
    fun getShapeBottomRightRadius(): Float
    fun setShapeBottomRightRadius(bottomRightRadius: Float): T
    fun isShapeOver(): Boolean
    fun setShapeOver(over: Boolean): T

    fun getShapeBackgroundColor(): Int
    fun setShapeBackgroundColor(backgroundColor: Int): T
    fun getShapeStrokeWidth(): Int
    fun setShapeStrokeWidth(strokeWidth: Int): T
    fun getShapeStrokeColor(): Int
    fun setShapeStrokeColor(strokeColor: Int): T
    fun getShapeStrokeDash(): Float
    fun setShapeStrokeDash(strokeDash: Float): T
    fun getShapeStrokeGap(): Float
    fun setShapeStrokeGap(strokeGap: Float): T

    fun getShapeFocusedBackgroundColor(): Int
    fun setShapeFocusedBackgroundColor(focused_backgroundColor: Int): T
    fun getShapeFocusedStrokeWidth(): Int
    fun setShapeFocusedStrokeWidth(focused_strokeWidth: Int): T
    fun getShapeFocusedStrokeColor(): Int
    fun setShapeFocusedStrokeColor(focused_strokeColor: Int): T
    fun getShapeFocusedStrokeDash(): Float
    fun setShapeFocusedStrokeDash(focused_strokeDash: Float): T
    fun getShapeFocusedStrokeGap(): Float
    fun setShapeFocusedStrokeGap(focused_strokeGap: Float): T

    fun getShapeCheckedBackgroundColor(): Int
    fun setShapeCheckedBackgroundColor(checked_backgroundColor: Int): T
    fun getShapeCheckedStrokeWidth(): Int
    fun setShapeCheckedStrokeWidth(checked_strokeWidth: Int): T
    fun getShapeCheckedStrokeColor(): Int
    fun setShapeCheckedStrokeColor(checked_strokeColor: Int): T
    fun getShapeCheckedStrokeDash(): Float
    fun setShapeCheckedStrokeDash(checked_strokeDash: Float): T
    fun getShapeCheckedStrokeGap(): Float
    fun setShapeCheckedStrokeGap(checked_strokeGap: Float): T

    fun getShapeSelectedBackgroundColor(): Int
    fun setShapeSelectedBackgroundColor(selected_backgroundColor: Int): T
    fun getShapeSelectedStrokeWidth(): Int
    fun setShapeSelectedStrokeWidth(selected_strokeWidth: Int): T
    fun getShapeSelectedStrokeColor(): Int
    fun setShapeSelectedStrokeColor(selected_strokeColor: Int): T
    fun getShapeSelectedStrokeDash(): Float
    fun setShapeSelectedStrokeDash(selected_strokeDash: Float): T
    fun getShapeSelectedStrokeGap(): Float
    fun setShapeSelectedStrokeGap(selected_strokeGap: Float): T

    fun getShapeUnEnabledBackgroundColor(): Int
    fun setShapeUnEnabledBackgroundColor(unEnabled_backgroundColor: Int): T
    fun getShapeUnEnabledStrokeWidth(): Int
    fun setShapeUnEnabledStrokeWidth(unEnabled_strokeWidth: Int): T
    fun getShapeUnEnabledStrokeColor(): Int
    fun setShapeUnEnabledStrokeColor(unEnabled_strokeColor: Int): T
    fun getShapeUnEnabledStrokeDash(): Float
    fun setShapeUnEnabledStrokeDash(unEnabled_strokeDash: Float): T
    fun getShapeUnEnabledStrokeGap(): Float
    fun setShapeUnEnabledStrokeGap(unEnabled_strokeGap: Float): T

    fun getShapeRippleColor(): Int
    fun setShapeRippleColor(rippleColor: Int): T


    fun setShapeGradientColors(gradientColors: IntArray): T

    fun setShapeGradientOrientation(gradientOrientation: GradientDrawable.Orientation): T

    fun setShapeGradientType(gradientType: Int): T

    fun setShapeGradientRadius(gradientRadius: Float): T

    fun setShapeGradientCenterX(gradientCenterX: Float): T

    fun setShapeGradientCenterY(gradientCenterY: Float): T

    fun setShapeFocusedGradientColors(focusedGradientColors: IntArray): T

    fun setShapeFocusedGradientOrientation(focusedGradientOrientation: GradientDrawable.Orientation): T

    fun setShapeFocusedGradientType(focusedGradientType: Int): T

    fun setShapeFocusedGradientRadius(focusedGradientRadius: Float): T

    fun setShapeFocusedGradientCenterX(focusedGradientCenterX: Float): T

    fun setShapeFocusedGradientCenterY(focusedGradientCenterY: Float): T

    fun setShapeCheckedGradientColors(checkedGradientColors: IntArray): T

    fun setShapeCheckedGradientOrientation(checkedGradientOrientation: GradientDrawable.Orientation): T

    fun setShapeCheckedGradientType(checkedGradientType: Int): T

    fun setShapeCheckedGradientRadius(checkedGradientRadius: Float): T

    fun setShapeCheckedGradientCenterX(checkedGradientCenterX: Float): T

    fun setShapeCheckedGradientCenterY(checkedGradientCenterY: Float): T

    fun setShapeSelectedGradientColors(selectedGradientColors: IntArray): T

    fun setShapeSelectedGradientOrientation(selectedGradientOrientation: GradientDrawable.Orientation): T

    fun setShapeSelectedGradientType(selectedGradientType: Int): T

    fun setShapeSelectedGradientRadius(selectedGradientRadius: Float): T

    fun setShapeSelectedGradientCenterX(selectedGradientCenterX: Float): T

    fun setShapeSelectedGradientCenterY(selectedGradientCenterY: Float): T

    fun setShapeUnEnabledGradientColors(unEnabledGradientColors: IntArray): T

    fun setShapeUnEnabledGradientOrientation(unEnabledGradientOrientation: GradientDrawable.Orientation): T

    fun setShapeUnEnabledGradientType(unEnabledGradientType: Int): T

    fun setShapeUnEnabledGradientRadius(unEnabledGradientRadius: Float): T

    fun setShapeUnEnabledGradientCenterX(unEnabledGradientCenterX: Float): T

    fun setShapeUnEnabledGradientCenterY(unEnabledGradientCenterY: Float): T

    fun getShapeGradientColors(): IntArray

    fun getShapeGradientOrientation(): GradientDrawable.Orientation

    fun getShapeGradientType(): Int

    fun getShapeGradientRadius(): Float

    fun getShapeGradientCenterX(): Float

    fun getShapeGradientCenterY(): Float

    fun getShapeFocusedGradientColors(): IntArray

    fun getShapeFocusedGradientOrientation(): GradientDrawable.Orientation

    fun getShapeFocusedGradientType(): Int

    fun getShapeFocusedGradientRadius(): Float

    fun getShapeFocusedGradientCenterX(): Float

    fun getShapeFocusedGradientCenterY(): Float

    fun getShapeCheckedGradientColors(): IntArray

    fun getShapeCheckedGradientOrientation(): GradientDrawable.Orientation

    fun getShapeCheckedGradientType(): Int

    fun getShapeCheckedGradientRadius(): Float

    fun getShapeCheckedGradientCenterX(): Float

    fun getShapeCheckedGradientCenterY(): Float

    fun getShapeSelectedGradientColors(): IntArray

    fun getShapeSelectedGradientOrientation(): GradientDrawable.Orientation

    fun getShapeSelectedGradientType(): Int

    fun getShapeSelectedGradientRadius(): Float

    fun getShapeSelectedGradientCenterX(): Float

    fun getShapeSelectedGradientCenterY(): Float

    fun getShapeUnEnabledGradientColors(): IntArray

    fun getShapeUnEnabledGradientOrientation(): GradientDrawable.Orientation

    fun getShapeUnEnabledGradientType(): Int

    fun getShapeUnEnabledGradientRadius(): Float

    fun getShapeUnEnabledGradientCenterX(): Float

    fun getShapeUnEnabledGradientCenterY(): Float


    fun shapeCreate()
}