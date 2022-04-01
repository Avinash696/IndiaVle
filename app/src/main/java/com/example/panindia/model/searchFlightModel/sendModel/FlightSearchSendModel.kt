package com.example.panindia.model.searchFlightModel.sendModel

data class FlightSearchSendModel(
    val AdultCount: String,
    val ChildCount: String,
    val DirectFlight: String,
    val EndUserIp: String,
    val InfantCount: String,
    val JourneyType: String,
    val OneStopFlight: String,
    val PreferredAirlines: Any?,
    val Segments: List<Segment>,

    val TokenId: String
)