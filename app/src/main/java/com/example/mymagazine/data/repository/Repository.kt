package com.example.mymagazine.data.repository

import com.example.mymagazine.data.api.RetrofitInstance
import com.example.mymagazine.domain.GetShops
import com.example.mymagazine.domain.models.LatestItemList
import  com.example.mymagazine.domain.models.FlashSaleItemList
import retrofit2.Response

//здесь реализовываем наши методы
class Repository : GetShops {
    override suspend fun getLatest(): Response<LatestItemList> {
        return RetrofitInstance.apiService.getLatestProducts()
    }

    override suspend fun getFlashSale(): FlashSaleItemList {
        return RetrofitInstance.apiService.getFlashSaleProducts()
    }
}