package com.example.mymagazine.domain

import com.example.mymagazine.domain.models.FlashSaleItemList
import com.example.mymagazine.domain.models.LatestItemList
import retrofit2.Response

interface GetShops {
    suspend fun getLatest(): Response<LatestItemList>
    suspend fun getFlashSale(): FlashSaleItemList
}