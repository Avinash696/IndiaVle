package com.example.panindia.model.searchFlightModel.oneWay.responce

data class Segment(
    val AccumulatedDuration: Int,
    val Airline: Airline,
    val Baggage: String,
    val CabinBaggage: String,
    val CabinClass: Int,
    val Craft: String,
    val Destination: Destination,
    val Duration: Int,
    val FlightInfoIndex: String,
    val FlightStatus: String,
    val GroundTime: Int,
    val IsETicketEligible: Boolean,
    val Mile: Int,
    val NoOfSeatAvailable: Int,
    val Origin: Origin,
    val Remark: Any,
    val SegmentIndicator: Int,
    val Status: String,
    val StopOver: Boolean,
    val StopPoint: String,
    val StopPointArrivalTime: Any,
    val StopPointDepartureTime: Any,
    val TripIndicator: Int
)