package com.example.mymagazine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mymagazine.data.models.FlashSaleItemList
import com.example.mymagazine.data.models.LatestItemList
import com.example.mymagazine.data.repository.Repository
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

    fun validatePassword(name: String, password: String): Boolean {
        return name.isNotEmpty() && password.isNotEmpty()
    }

}