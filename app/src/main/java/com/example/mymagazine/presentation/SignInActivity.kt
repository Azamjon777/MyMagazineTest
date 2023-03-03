package com.example.mymagazine.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mymagazine.MainViewModel
import com.example.mymagazine.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.loginText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignIn.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {
        val name1 = binding.etFirstName.text.toString()

        val shared = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val editor = shared.edit()
        editor.apply {
            putString("FIRST_NAME", name1)
        }.apply()

        val intent = Intent(this, ProfileActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    /*  private fun retrievePerson() {
          lifecycleScope.launch(Dispatchers.IO) {
              val persons = (applicationContext as App).repository.getAllPerson()
              launch(Dispatchers.Main) {

              }
          }
      }*/
}