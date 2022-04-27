package com.example.panindia.model.FareQuote.ResponceFareQuote

data class Segment(
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
    val Origin: Origin,
    val Remark: Any,
    val SegmentIndicator: Int,
    val Status: String,
    val StopOver: Boolean,
    val StopPoint: String,
    val StopPointArrivalTime: String,
    val StopPointDepartureTime: String,
    val TripIndicator: Int
)