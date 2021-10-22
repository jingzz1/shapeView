package com.jingzz.shapeView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.jingzz.shapeView.databinding.ActivityShapeTextViewBinding
import com.jingzz.shapeView.interfaces.OnIconClickListener

class ShapeTextViewActivity : AppCompatActivity() {
    private val binding by lazy { ActivityShapeTextViewBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.edit2.setOnIconClickListener { view, clickType ->
            //clickType 0：左 1:上 2:右 3:下
            when(clickType){
                0 -> Toast.makeText(this,"点击了左边图标",Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(this,"点击了上边图标",Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this,"点击了右边图标",Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(this,"点击了下边图标",Toast.LENGTH_SHORT).show()
            }
        }
    }
}