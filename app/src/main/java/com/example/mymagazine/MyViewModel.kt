package com.example.mymagazine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mymagazine.data.models.LatestItemList
import com.example.mymagazine.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MyViewModel(application: Application) : AndroidViewModel(application) {
    var repository = Repository()
    val myLatestList: MutableLiveData<Response<LatestItemList>> = MutableLiveData()

    fun getLatest(){
        //это сопрограмма которая помогает работать в другом потоке
        viewModelScope.launch {
            myLatestList.value = repository.getLatest()
        }
    }

    fun validatePassword(name: String, password: String): Boolean {
        return name.isNotEmpty() && password.isNotEmpty()
    }

}