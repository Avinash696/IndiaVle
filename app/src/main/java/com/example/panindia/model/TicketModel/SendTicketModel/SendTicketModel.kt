package com.example.panindia.model.TicketModel.SendTicketModel

data class SendTicketModel(
    val EndUserIp: String,
    val Passengers: List<Passenger>,
    val PreferredCurrency: Any?,
    val ResultIndex: String,
    val TokenId: String,
    val TraceId: String
)