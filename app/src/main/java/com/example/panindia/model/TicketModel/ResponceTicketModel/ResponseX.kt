package com.example.panindia.model.TicketModel.ResponceTicketModel

data class ResponseX(
    val BookingId: Int,
    val FlightItinerary: FlightItinerary,
    val IsPriceChanged: Boolean,
    val IsTimeChanged: Boolean,
    val PNR: String,
    val SSRDenied: Boolean,
    val SSRMessage: Any,
    val Status: Int,
    val TicketStatus: Int
)