package com.example.panindia.model.searchFlightModel.oneWay.req

data class Segment(
    val Destination: String,
    val FlightCabinClass: Int,
    val Origin: String,
    val PreferredDepartureTime: String
)