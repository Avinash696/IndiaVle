package com.example.panindia.model.BookingForNLCC.BookingResponce

data class Response(
    val BookingId: Int,
    val FlightItinerary: FlightItinerary,
    val IsPriceChanged: Boolean,
    val IsTimeChanged: Boolean,
    val PNR: String,
    val SSRDenied: Boolean,
    val SSRMessage: Any,
    val Status: Int
)