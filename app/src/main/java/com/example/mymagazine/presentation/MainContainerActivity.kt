package com.example.mymagazine.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mymagazine.R
import com.example.mymagazine.databinding.ActivityMainContainerBinding
import com.example.mymagazine.presentation.fragments.Page1Fragment
import com.example.mymagazine.presentation.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainContainerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainContainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        bottomNavigationView.selectedItemId = R.id.ic_profile
        bottomNavigationView.setOnNavigationItemSelectedListener {
            val profileFragment = ProfileFragment()
            val homeFragment = Page1Fragment()
            when (it.itemId) {
                R.id.ic_profile -> {
                    supportFragmentManager.popBackStack()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container_main_fragments, profileFragment)
                        .addToBackStack(null)
                        .commit()
                }
                R.id.ic_home -> {
                    supportFragmentManager.popBackStack()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container_main_fragments, homeFragment)
                        .addToBackStack(null)
                        .commit()
                }
            }
            true
        }
    }
}