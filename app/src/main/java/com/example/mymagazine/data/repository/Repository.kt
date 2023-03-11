package com.example.mymagazine.data.repository

import com.example.mymagazine.data.api.RetrofitInstance
import com.example.mymagazine.domain.GetShops
import com.example.mymagazine.domain.models.LatestItemListD
import  com.example.mymagazine.domain.models.FlashSaleItemListD
import retrofit2.Response

//здесь реализовываем наши методы
class Repository : GetShops {
    override suspend fun getLatest(): Response<LatestItemListD> {
        return RetrofitInstance.apiService.getLatestProducts()
    }

    override suspend fun getFlashSale(): FlashSaleItemListD {
        return RetrofitInstance.apiService.getFlashSaleProducts()
    }
}