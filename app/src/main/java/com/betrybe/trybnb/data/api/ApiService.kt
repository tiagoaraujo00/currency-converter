package com.betrybe.trybnb.data.api

import com.betrybe.trybnb.data.models.Bookingids
import com.betrybe.trybnb.data.models.Bookings
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {
    @GET("/booking")
    suspend fun getBooking(): Response<List<Bookings>>

    @GET("/booking/{id}")
    suspend fun getBookingId(
        @Header("Accept") accept: String,
        @Path("id") id: String
    ): Response<Bookingids>
}
