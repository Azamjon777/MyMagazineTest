package com.example.mymagazine.presentation

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mymagazine.R
import com.example.mymagazine.databinding.ActivityMainContainerBinding
import com.example.mymagazine.presentation.fragments.Page1Fragment
import com.example.mymagazine.presentation.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.InputStream

class MainContainerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainContainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        showFragment()
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        val fragment = supportFragmentManager.findFragmentById(R.id.container_main_fragments)
//        if (fragment != null) {
//            fragment.onActivityResult(requestCode, resultCode, data)
//        }

        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val selectedImageUri: Uri = data?.data ?: return
            val inputStream: InputStream? = contentResolver.openInputStream(selectedImageUri)
            val bitmap = BitmapFactory.decodeStream(inputStream)

        }
    }*/

    private fun showFragment() {
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