package com.jingzz.shapeView.helper

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Region
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.TextView
import com.jingzz.shapeView.R
import com.jingzz.shapeView.interfaces.OnIconClickListener

class ShapeTextHelper<T:TextView>:IShapeTextHelper<T> {
    lateinit var view:T
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
                //计算中心点
                val x = (view.width - view.paddingStart - view.paddingEnd - (dl?.bounds?.width() ?: 0) - (dr?.bounds?.width()?:0))/2+view.paddingStart+(dl?.bounds?.width()?:0)
                val y = view.run { height - paddingTop - paddingBottom-(dt?.bounds?.height()?:0)-(db?.bounds?.height()?:0) }/2+view.paddingTop+(dt?.bounds?.height()?:0)

                if (dl != null) {
                    if ( Region(view.paddingStart,
                            y-dl.bounds.height()/2,
                            view.paddingStart+dl.bounds.width(),
                            y+dl.bounds.height()/2).contains(clickX,clickY)) {
                        iconClick?.click(view, 0)
                        return true
                    }
                }

                if (dr != null) {
                    if (Region(view.let { it.width - it.paddingEnd - dr.bounds.width() },
                            y-dr.bounds.height()/2,
                            view.let { it.width - it.paddingEnd },
                            y+dr.bounds.height()/2).contains(clickX,clickY)) {
                        iconClick?.click(view, 2)
                        return true
                    }
                }

                if (dt != null) {
                    if ( Region(
                            x - dt.bounds.width()/2,
                            view.paddingTop,
                            x+ dt.bounds.width()/2,
                            view.paddingTop+dt.bounds.height()
                        ).contains(clickX,clickY)) {
                        iconClick?.click(view, 1)
                        return true
                    }
                }
                if (db != null) {
                    if (
                        Region(x - db.bounds.centerX() ,
                            view.height - view.paddingBottom - db.bounds.height(),
                            x+ db.bounds.centerX(),
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

    override fun setDrawableTopWidth(drawableTopWidth: Int):T {
        this.drawableTopWidth = drawableTopWidth
        return view
    }

    override fun setDrawableLeftWidth(drawableLeftWidth: Int):T {
        this.drawableLeftWidth = drawableLeftWidth
        return view
    }

    override fun setDrawableRightWidth(drawableRightWidth: Int):T {
        this.drawableRightWidth = drawableRightWidth
        return view
    }

    override fun setDrawableBottomWidth(drawableBottomWidth: Int):T {
        this.drawableBottomWidth = drawableBottomWidth
        return view
    }

    override fun setDrawableTopHeight(drawableTopHeight: Int):T {
        this.drawableTopHeight = drawableTopHeight
        return view
    }

    override fun setDrawableLeftHeight(drawableLeftHeight: Int):T {
        this.drawableLeftHeight = drawableLeftHeight
        return view
    }

    override fun setDrawableRightHeight(drawableRightHeight: Int):T {
        this.drawableRightHeight = drawableRightHeight
        return view
    }

    override fun setDrawableBottomHeight(drawableBottomHeight: Int):T {
        this.drawableBottomHeight = drawableBottomHeight
        return view
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
