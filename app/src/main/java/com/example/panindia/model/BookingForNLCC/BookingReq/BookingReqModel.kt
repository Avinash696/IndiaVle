package com.example.panindia.model.BookingForNLCC.BookingReq

data class BookingReqModel(
    val EndUserIp: String,
    val Passengers: List<Passenger>,
    val ResultIndex: String,
    val TokenId: String,
    val TraceId: String
)