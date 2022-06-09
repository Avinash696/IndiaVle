package com.example.panindia.model.searchFlightModel.oneWay.responce

data class Response(
    val Destination: String,
    val Error: Error,
    val Origin: String,
    val ResponseStatus: Int,
    val Results: List<List<Result>>,
    val TraceId: String
)