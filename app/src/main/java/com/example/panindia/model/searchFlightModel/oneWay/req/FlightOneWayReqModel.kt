package com.example.panindia.model.searchFlightModel.oneWay.req

data class FlightOneWayReqModel(
    val AdultCount: Int,
    val ChildCount: Int,
    val DirectFlight: String,
    val EndUserIp: String,
    val InfantCount: Int,
    val JourneyType: String,
    val OneStopFlight: String,
    val PreferredAirlines: Any?,
    val Segments: List<Segment>,
    val TokenId: String
)