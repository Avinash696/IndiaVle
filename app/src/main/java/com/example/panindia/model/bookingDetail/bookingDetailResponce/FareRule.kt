package com.example.panindia.model.bookingDetail.bookingDetailResponce

data class FareRule(
    val Airline: String,
    val Destination: String,
    val FareBasisCode: String,
    val FareFamilyCode: String,
    val FareRestriction: String,
    val FareRuleDetail: String,
    val FareRuleIndex: String,
    val Origin: String
)