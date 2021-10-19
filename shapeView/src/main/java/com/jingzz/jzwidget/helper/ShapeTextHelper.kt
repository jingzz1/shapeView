package com.jingzz.jzwidget.helper

import android.content.Context
import android.graphics.Region
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.TextView
import com.jingzz.jzwidget.R

class ShapeTextHelper:IShapeTextHelper {
    lateinit var view:TextView
    var iconClick: OnIconClickListener? = null

    private var drawableTopWidth:Int = 0
    private var drawableTopHeight:Int = 0
    private var drawableLeftWidth:Int = 0
    private var drawableLeftHeight:Int = 0
    private var drawableRightWidth:Int = 0
    private var drawableRightHeight:Int = 0
    private var drawableBottomWidth:Int = 0
    private var drawableBottomHeight:Int = 0

    fun initAttributeSet(context: Context, attrs: AttributeSet?){
        context.obtainStyledAttributes(attrs, R.styleable.ShapeTextBase).apply {
            drawableTopWidth = getDimension(R.styleable.ShapeTextBase_shape_drawableTop_width,0f).toInt()
            drawableTopHeight = getDimension(R.styleable.ShapeTextBase_shape_drawableTop_height,0f).toInt()
            drawableLeftWidth = getDimension(R.styleable.ShapeTextBase_shape_drawableLeft_width,0f).toInt()
            drawableLeftHeight = getDimension(R.styleable.ShapeTextBase_shape_drawableLeft_height,0f).toInt()
            drawableRightWidth = getDimension(R.styleable.ShapeTextBase_shape_drawableRight_width,0f).toInt()
            drawableRightHeight = getDimension(R.styleable.ShapeTextBase_shape_drawableRight_height,0f).toInt()
            drawableBottomWidth = getDimension(R.styleable.ShapeTextBase_shape_drawableBottom_width,0f).toInt()
            drawableBottomHeight = getDimension(R.styleable.ShapeTextBase_shape_drawableBottom_height,0f).toInt()
        }.recycle()
    }

    override fun onTouchEvent(ev: MotionEvent):Boolean {
        if (iconClick == null) false
        return when (ev.action) {
            MotionEvent.ACTION_DOWN -> true
            MotionEvent.ACTION_UP -> {
                //0左边图片 1 上边图片 2右边图片 3 下边图片
                val dl = view.compoundDrawables[0]
                val dt = view.compoundDrawables[1]
                val dr = view.compoundDrawables[2]
                val db = view.compoundDrawables[3]

                val clickX = ev.x.toInt()
                val clickY = ev.y.toInt()

                if (dl != null) {
                    if ( Region(view.paddingStart,
                            view.height/2-dl.bounds.height()/2,
                            view.paddingStart+dl.bounds.width(),
                            view.height/2+dl.bounds.height()/2).contains(clickX,clickY)) {
                        iconClick?.click(view, 0)
                        return true
                    }
                }

                if (dr != null) {
                    if (Region(view.let { it.width - it.paddingEnd - dr.bounds.width() },
                            view.height/2-dr.bounds.height()/2,
                            view.let { it.width - it.paddingEnd },
                            view.height/2+dr.bounds.height()/2).contains(clickX,clickY)) {
                        iconClick?.click(view, 2)
                        return true
                    }
                }

                if (dt != null) {
                    if ( Region(
                            view.width/2 - dt.bounds.centerX(),
                            view.paddingTop,
                            view.width/2+ dt.bounds.centerX(),
                            view.paddingTop+dt.bounds.height()
                        ).contains(clickX,clickY)) {
                        iconClick?.click(view, 1)
                        return true
                    }
                }
                if (db != null) {
                    if (
                        Region(view.width/2 - db.bounds.centerX() ,
                            view.height - view.paddingBottom - db.bounds.height(),
                            view.width/2+ db.bounds.centerX(),
                            view.height - view.paddingBottom).contains(clickX,clickY)) {
                        iconClick?.click(view, 3)
                        return true
                    }
                }

                false
            }
            else -> false
        }
    }

    override fun shapeCreate() {
        val dl = view.compoundDrawables[0]
        val dt = view.compoundDrawables[1]
        val dr = view.compoundDrawables[2]
        val db = view.compoundDrawables[3]
        if((drawableLeftWidth != 0 || drawableLeftHeight != 0) && dl != null){
            val width = if(drawableLeftWidth == 0) dl.intrinsicWidth else drawableLeftWidth
            val height = if(drawableLeftHeight == 0) dl.intrinsicHeight else drawableLeftHeight
            dl.setBounds(0,0,width,height)
        }
        if((drawableTopWidth != 0 || drawableTopHeight != 0) && dt != null){
            val width = if(drawableTopWidth == 0) dt.intrinsicWidth else drawableTopWidth
            val height = if(drawableTopHeight == 0) dt.intrinsicHeight else drawableTopHeight
            dt.setBounds(0,0,width,height)
        }
        if((drawableRightWidth != 0 || drawableRightHeight != 0) && dr != null){
            val width = if(drawableRightWidth == 0) dr.intrinsicWidth else drawableRightWidth
            val height = if(drawableRightHeight == 0) dr.intrinsicHeight else drawableRightHeight
            dr.setBounds(0,0,width,height)
        }
        if((drawableBottomWidth != 0 || drawableBottomHeight != 0) && db != null){
            val width = if(drawableBottomWidth == 0) db.intrinsicWidth else drawableBottomWidth
            val height = if(drawableBottomHeight == 0) db.intrinsicHeight else drawableBottomHeight
            db.setBounds(0,0,width,height)
        }
        view.setCompoundDrawables(dl,dt,dr,db)
    }

    override fun setDrawableTopWidth(drawableTopWidth: Int) {
        this.drawableTopWidth = drawableTopWidth
    }

    override fun setDrawableLeftWidth(drawableLeftWidth: Int) {
        this.drawableLeftWidth = drawableLeftWidth
    }

    override fun setDrawableRightWidth(drawableRightWidth: Int) {
        this.drawableRightWidth = drawableRightWidth
    }

    override fun setDrawableBottomWidth(drawableBottomWidth: Int) {
        this.drawableBottomWidth = drawableBottomWidth
    }

    override fun setDrawableTopHeight(drawableTopHeight: Int) {
        this.drawableTopHeight = drawableTopHeight
    }

    override fun setDrawableLeftHeight(drawableLeftHeight: Int) {
        this.drawableLeftHeight = drawableLeftHeight
    }

    override fun setDrawableRightHeight(drawableRightHeight: Int) {
        this.drawableRightHeight = drawableRightHeight
    }

    override fun setDrawableBottomHeight(drawableBottomHeight: Int) {
        this.drawableBottomHeight = drawableBottomHeight
    }

    override fun getDrawableTopWidth() = drawableTopWidth

    override fun getDrawableLeftWidth() = drawableLeftWidth

    override fun getDrawableRightWidth() = drawableRightWidth

    override fun getDrawableBottomWidth() = drawableBottomWidth

    override fun getDrawableTopHeight() = drawableTopHeight

    override fun getDrawableLeftHeight() = drawableLeftHeight

    override fun getDrawableRightHeight() = drawableRightHeight

    override fun getDrawableBottomHeight() = drawableBottomHeight
}


interface OnIconClickListener {
    //clickType:点击的图标位置 0：左边 1:上边 2:右边 3:下边
    fun click(view: TextView, clickType: Int)
}