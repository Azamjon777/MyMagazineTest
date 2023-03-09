package com.example.mymagazine.data.repository

import com.example.mymagazine.data.api.RetrofitInstance
import com.example.mymagazine.data.models.FlashSaleItemList
import com.example.mymagazine.data.models.LatestItemList
import retrofit2.Response

//здесь реализовываем наши методы
class Repository {
    suspend fun getLatest(): Response<LatestItemList> {
        return RetrofitInstance.apiService.getLatestProducts()
    }

    suspend fun getFlashSale(): FlashSaleItemList {
        return RetrofitInstance.apiService.getFlashSaleProducts()
    }
}