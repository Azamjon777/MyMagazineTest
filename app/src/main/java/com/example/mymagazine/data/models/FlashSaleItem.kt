package com.example.mymagazine.data.models

data class FlashSaleItem(
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double
)