package com.example.mymagazine.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mymagazine.databinding.ActivityPage1Binding

class Page1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityPage1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPage1Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}