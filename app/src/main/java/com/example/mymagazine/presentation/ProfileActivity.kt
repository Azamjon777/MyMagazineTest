package com.example.mymagazine.presentation

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mymagazine.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
    }

    private fun loadData() {
        val shared = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val savedName = shared.getString("FIRST_NAME", null)

        binding.myName.text = savedName.toString()
    }
}