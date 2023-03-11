package com.example.mymagazine.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mymagazine.data.repository.Repository
import com.example.mymagazine.domain.models.FlashSaleItemListD
import com.example.mymagazine.domain.models.LatestItemListD

class MyViewModel(application: Application) : AndroidViewModel(application) {
    var repository = Repository()
    val myLatestList: MutableLiveData<LatestItemListD> = MutableLiveData()
    val myFlashSaleList: MutableLiveData<FlashSaleItemListD> = MutableLiveData()

    suspend fun getLatestList() {
        //это сопрограмма которая помогает работать в другом потоке
        myLatestList.value = repository.getLatest()
    }

    suspend fun getFlashSaleList() {
        //это сопрограмма которая помогает работать в другом потоке
        myFlashSaleList.value = repository.getFlashSale()
    }

    fun validatePassword(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun validateName(name: String): Boolean {
        return name.isNotEmpty()
    }

    fun isEmailValid(email: String): Boolean {
        val pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
        return email.matches(pattern)
    }

    fun validName(name: String): Boolean {
        return name.isNotEmpty()
    }
}