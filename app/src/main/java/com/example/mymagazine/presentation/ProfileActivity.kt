package com.example.mymagazine.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mymagazine.R
import com.example.mymagazine.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        loadData()

        clicks()
    }

    private fun clicks() {
        binding.bottomNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> {
                    val intent = Intent(this, Page1Activity::class.java)
                    startActivity(intent)
                }
                R.id.ic_balans -> {}
                R.id.ic_shops -> {}
                R.id.ic_chat -> {}
                R.id.ic_profile -> {}
            }
            true
        }
    }

    private fun loadData() {
        val shared = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val savedName = shared.getString("FIRST_NAME", null)

        binding.myName.text = savedName.toString()
    }
}