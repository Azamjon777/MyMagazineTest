package com.example.mymagazine.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//здесь создается Instance нашего Retrofit
object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //здесь создаем переменную, чтобы его можно было создать с нашим ApiService
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}