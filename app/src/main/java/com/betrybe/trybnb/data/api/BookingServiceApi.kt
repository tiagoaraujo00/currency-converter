package com.betrybe.trybnb.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BookingServiceApi {
    val instance : ApiService by lazy {

        val BASE_URL = "https://restful-booker.herokuapp.com"

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
}