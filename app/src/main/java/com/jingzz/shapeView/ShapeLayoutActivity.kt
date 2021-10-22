package com.jingzz.shapeView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jingzz.shapeView.databinding.ActivityShapeLayoutBinding

class ShapeLayoutActivity : AppCompatActivity() {
    private val binding by lazy { ActivityShapeLayoutBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}