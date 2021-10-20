package com.jingzz.shapeView

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
        binding.check.setOnClickListener {
            binding.check.isChecked = !binding.check.isChecked
        }
    }
}

fun ImageView.load(url: Any? = "", error: Drawable? = null) {
    Glide.with(this).load(url).apply(RequestOptions.errorOf(error))
        .transition( DrawableTransitionOptions.with( DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()))
        .into(this)
}