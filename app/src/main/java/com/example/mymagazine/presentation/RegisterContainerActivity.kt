package com.example.mymagazine.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mymagazine.R

class RegisterContainerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_container)
        supportActionBar?.hide()

    }
}