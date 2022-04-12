package com.example.panindia.model.fareRule.receiveFareRule

data class FareRule(
    val Airline: String,
    val DepartureTime: String,
    val Destination: String,
    val FareBasisCode: String,
    val FareRestriction: String,
    val FareRuleDetail: String,
    val FlightId: Int,
    val Origin: String,
    val ReturnDate: String
)