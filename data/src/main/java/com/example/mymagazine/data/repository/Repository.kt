package com.example.mymagazine.data.repository

import com.example.mymagazine.data.api.RetrofitInstance
import com.example.mymagazine.domain.GetShops
import com.example.mymagazine.domain.models.FlashSaleItemListD
import com.example.mymagazine.domain.models.LatestItemListD

//здесь реализовываем наши методы
class Repository : GetShops {
    override suspend fun getLatest(): LatestItemListD {
        return RetrofitInstance.apiService.getLatestProducts()
    }

    override suspend fun getFlashSale(): FlashSaleItemListD {
        return RetrofitInstance.apiService.getFlashSaleProducts()
    }
}