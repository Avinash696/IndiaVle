package com.example.panindia.model.BookingForNLCC.BookingResponce

data class BookingResponceModel(
    val Error: Error,
    val Response: Response,
    val ResponseStatus: Int,
    val TraceId: String
)