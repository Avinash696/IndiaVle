package com.example.panindia.model.bookingDetail.bookingDetailResponce

data class Ticket(
    val ConjunctionNumber: String,
    val IssueDate: String,
    val Remarks: String,
    val ServiceFeeDisplayType: String,
    val Status: String,
    val TicketId: Int,
    val TicketNumber: String,
    val TicketType: String,
    val ValidatingAirline: String
)