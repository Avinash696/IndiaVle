package com.example.panindia.model.searchFlightModel.sendModel

data class Segment(
    val Destination: String,
    val FlightCabinClass: Int,
    val Origin: String,
    val PreferredArrivalTime: String,
    val PreferredDepartureTime: String
)

