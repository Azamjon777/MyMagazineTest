package com.example.mymagazine

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {
    fun validatePassword(name: String, password: String): Boolean {
        return name.isNotEmpty() && password.isNotEmpty()
    }
}