package com.betrybe.trybnb.data.models

data class Bookingids(
    val firstname: String,
    val lastname: String,
    val totalprice: Int,
    val depositpaid: Boolean,
    val bookingdates: BookingDatesData,
    val additionalneeds: String,
)
