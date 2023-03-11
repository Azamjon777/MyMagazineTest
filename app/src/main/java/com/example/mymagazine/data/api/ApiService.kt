package com.example.mymagazine.data.api

import com.example.mymagazine.domain.models.FlashSaleItemListD
import com.example.mymagazine.domain.models.LatestItemListD
import retrofit2.Response
import retrofit2.http.GET


//это как бы класс Dao в библиотеке Room. Здесь будут запросы
interface ApiService {

    /*здесь endPoint(то есть то, что после базового URL). Это вторая часть запроса. Первая находится
    в RetrofitInstance*/
    @GET("v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatestProducts(): Response<LatestItemListD>

    @GET("v3/a9ceeb6e-416d-4352-bde6-2203416576ac")//здесь можно без Response обойтись
    suspend fun getFlashSaleProducts(): FlashSaleItemListD
}