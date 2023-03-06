package com.example.mymagazine

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class MyViewModel(application: Application) : AndroidViewModel(application) {
    fun validatePassword(name: String, password: String): Boolean {
        return name.isNotEmpty() && password.isNotEmpty()
    }
}