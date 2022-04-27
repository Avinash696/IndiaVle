package com.example.panindia.model.FareQuote.ResponceFareQuote

data class Response(
    val Error: Error,
    val FlightDetailChangeInfo: Any,
    val IsPriceChanged: Boolean,
    val ResponseStatus: Int,
    val Results: Results,
    val TraceId: String
)