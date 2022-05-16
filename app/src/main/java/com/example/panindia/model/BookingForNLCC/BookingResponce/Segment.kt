package com.example.panindia.model.BookingForNLCC.BookingResponce

data class Segment(
    val AccumulatedDuration: Int,
    val Airline: Airline,
    val AirlinePNR: String,
    val Baggage: Any,
    val CabinBaggage: Any,
    val Craft: String,
    val Destination: Destination,
    val Duration: Int,
    val FlightStatus: String,
    val GroundTime: Int,
    val IsETicketEligible: Boolean,
    val Mile: Int,
    val Origin: Origin,
    val Remark: String,
    val SegmentIndicator: Int,
    val Status: String,
    val StopOver: Boolean,
    val StopPoint: String,
    val StopPointArrivalTime: String,
    val StopPointDepartureTime: String,
    val TripIndicator: Int
)