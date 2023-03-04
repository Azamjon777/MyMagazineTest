package com.example.mymagazine.presentation

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.mymagazine.MainViewModel
import com.example.mymagazine.R
import com.example.mymagazine.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private var isShowPass = false

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        clicks()
    }

    private fun clicks() {
        binding.visibleTrue.setOnClickListener {
            isShowPass = !isShowPass
            showPassword(isShowPass)
        }
        showPassword(isShowPass)

        binding.btnLogin.setOnClickListener {
            val name = binding.etFirstNameLogin.text.toString()
            val password = binding.etPassword.text.toString()
            if (viewModel.validatePassword(name, password)) {
                val intent = Intent(this, ProfileActivity::class.java)
                //снизу задаем флаг, то что мы будем закрывать за собой активити
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }
    }

    private fun showPassword(isShow: Boolean) {
        if (isShow) {
            binding.etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.visibleTrue.setImageResource(R.drawable.ic_eye_off)
        } else {
            binding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.visibleTrue.setImageResource(R.drawable.ic_eye_enable)
        }
        binding.etPassword.setSelection(binding.etPassword.text.toString().length)
    }
}