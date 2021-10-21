package com.jingzz.shapeView

import android.app.Activity
import android.content.Intent
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
import com.jingzz.shapeView.databinding.ActivityMainBinding
import com.jingzz.shapeView.helper.OnIconClickListener
import com.jingzz.shapeView.widget.ShapeEditText

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            btn1.setOnClickListener {
                Glide.with(btn1).load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2F1114%2F060421091316%2F210604091316-2-1200.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637385612&t=828bc045cea0a789a62cf06c640080ca").into(iv)
            }
        }
    }

    inline fun <reified T: Activity> startActivity(){
        startActivity(Intent(this,T::class.java))
    }
}

fun ImageView.load(url: Any? = "", error: Drawable? = null) {
    Glide.with(this).load(url).apply(RequestOptions.errorOf(error))
        .transition( DrawableTransitionOptions.with( DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()))
        .into(this)
}