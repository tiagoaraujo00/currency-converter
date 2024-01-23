package com.betrybe.trybnb.data.repository

import com.betrybe.trybnb.data.api.BookingServiceApi
import com.betrybe.trybnb.data.models.Login
import com.betrybe.trybnb.data.models.Token

class TokenRepository {
    private val apiService = BookingServiceApi.instance
    suspend fun getToken(email: String, password: String): Token? = apiService.authLogin(
        Login(email, password)
    ).takeIf { it.isSuccessful }?.body()
}
