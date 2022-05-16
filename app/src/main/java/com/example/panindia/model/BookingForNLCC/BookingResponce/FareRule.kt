package com.example.panindia.model.BookingForNLCC.BookingResponce

data class FareRule(
    val Airline: String,
    val Destination: String,
    val FareBasisCode: String,
    val FareRestriction: String,
    val FareRuleDetail: String,
    val Origin: String
)