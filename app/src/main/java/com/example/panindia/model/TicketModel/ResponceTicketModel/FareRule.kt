package com.example.panindia.model.TicketModel.ResponceTicketModel

data class FareRule(
    val Airline: String,
    val Destination: String,
    val FareBasisCode: String,
    val FareRestriction: Any,
    val FareRuleDetail: String,
    val Origin: String
)