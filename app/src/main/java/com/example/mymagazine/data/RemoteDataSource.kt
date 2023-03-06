package com.example.mymagazine.data

import com.example.mymagazine.data.models.ModelLatestProducts
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("v3/{name}")//cc0071a1-f06e-48fa-9e90-b1c2a61eaca7
    suspend fun getListLatestProducts(@Path("name") product: String?): ModelLatestProducts

    @GET("v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getListLatestProductsSimple(): ModelLatestProducts
}

var retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://run.mocky.io/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var serviceApi: APIService = retrofit.create(APIService::class.java)