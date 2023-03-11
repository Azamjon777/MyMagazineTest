package com.example.mymagazine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mymagazine.data.repository.Repository
import com.example.mymagazine.domain.models.FlashSaleItemList
import com.example.mymagazine.domain.models.LatestItemList
import retrofit2.Response

class MyViewModel(application: Application) : AndroidViewModel(application) {
    var repository = Repository()
    val myLatestList: MutableLiveData<Response<LatestItemList>> = MutableLiveData()
    val myFlashSaleList: MutableLiveData<FlashSaleItemList> = MutableLiveData()

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