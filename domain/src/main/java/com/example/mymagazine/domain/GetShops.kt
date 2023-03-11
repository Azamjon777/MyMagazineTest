package com.example.mymagazine.domain

import com.example.mymagazine.domain.models.FlashSaleItemListD
import com.example.mymagazine.domain.models.LatestItemListD

interface GetShops {
    suspend fun getLatest(): LatestItemListD
    suspend fun getFlashSale(): FlashSaleItemListD
}