package com.example.panindia.model.bookingDetail.bookingDetailResponce

data class Response(
    val Error: Error,
    val FlightItinerary: FlightItinerary,
    val ResponseStatus: Int,
    val TraceId: String
)