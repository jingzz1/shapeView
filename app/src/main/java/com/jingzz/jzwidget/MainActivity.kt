package com.jingzz.jzwidget

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.jingzz.jzwidget.helper.OnIconClickListener
import com.jingzz.jzwidget.widget.ShapeEditText
import com.jingzz.jzwidget.widget.ShapeTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<ShapeEditText>(R.id.text2)
        tv.setOnIconClickListener(object : OnIconClickListener {
            override fun click(view: TextView, clickType: Int) {
                Log.e("clickType-->",clickType.toString())
            }
        })
    }
}

fun ImageView.load(url: Any? = "", error: Drawable? = null) {
    Glide.with(this).load(url).apply(RequestOptions.errorOf(error))
        .transition( DrawableTransitionOptions.with( DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()))
        .into(this)
}