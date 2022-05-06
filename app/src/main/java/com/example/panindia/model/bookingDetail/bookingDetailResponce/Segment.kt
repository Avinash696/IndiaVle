package com.example.panindia.model.bookingDetail.bookingDetailResponce

data class Segment(
    val AccumulatedDuration: Int,
    val Airline: Airline,
    val AirlinePNR: String,
    val Baggage: Any,
    val CabinBaggage: Any,
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
    val StopPointArrivalTime: Any,
    val StopPointDepartureTime: Any,
    val TripIndicator: Int
)