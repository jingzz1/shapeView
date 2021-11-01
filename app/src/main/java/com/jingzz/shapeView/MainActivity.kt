package com.jingzz.shapeView

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jingzz.shapeView.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            btn1.setOnClickListener { startActivity<ShapeViewActivity>() }
            btn2.setOnClickListener { startActivity<ShapeLayoutActivity>() }
            btn3.setOnClickListener { startActivity<ShapeTextViewActivity>() }
        }
    }

    inline fun <reified T : Activity> startActivity() {
        startActivity(Intent(this, T::class.java))
    }
    fun aaa(){

    }
}