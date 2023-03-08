package com.example.mymagazine.data.repository

import com.example.mymagazine.data.api.RetrofitInstance
import com.example.mymagazine.data.models.LatestItemList
import retrofit2.Response

//здесь реализовываем наши методы
class Repository {
    suspend fun getLatest(): Response<LatestItemList> {
        return RetrofitInstance.apiService.getLatestProducts()
    }
}