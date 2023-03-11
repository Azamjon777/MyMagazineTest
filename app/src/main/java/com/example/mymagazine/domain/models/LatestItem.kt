package com.example.mymagazine.domain.models

data class LatestItem(
    val category: String,
    val image_url: String,
    val name: String,
    val price: Int
)