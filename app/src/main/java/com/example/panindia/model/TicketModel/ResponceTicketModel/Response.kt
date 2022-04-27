package com.example.panindia.model.TicketModel.ResponceTicketModel

data class Response(
    val B2B2BStatus: Boolean,
    val Error: Error,
    val Response: ResponseX,
    val ResponseStatus: Int,
    val TraceId: String
)