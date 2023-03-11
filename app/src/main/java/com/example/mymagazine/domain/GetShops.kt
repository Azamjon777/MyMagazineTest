package com.example.mymagazine.domain

import com.example.mymagazine.domain.models.FlashSaleItemListD
import com.example.mymagazine.domain.models.LatestItemListD
import retrofit2.Response

interface GetShops {
    suspend fun getLatest(): Response<LatestItemListD>
    suspend fun getFlashSale(): FlashSaleItemListD
}