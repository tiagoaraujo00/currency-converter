package com.betrybe.trybnb.data.api

import com.betrybe.trybnb.data.models.Bookingids
import com.betrybe.trybnb.data.models.Bookings
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/booking")
    suspend fun getBooking(): Response<List<Bookings>>

    @GET("/booking")
    suspend fun getBookingId(): Response<Bookingids>
}
