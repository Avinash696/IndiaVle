package com.example.panindia.model.searchFlightModel.oneWay.req

<<<<<<< HEAD
//data class Segment(
//    val Destination: String,
//    val FlightCabinClass: Int,
//    val Origin: String,
//    val PreferredDepartureTime: String,
//    override val PreferredArrivalTime: String
//) :PreferredArrivalTimeResource(PreferredArrivalTime)
//
//open class PreferredArrivalTimeResource(open val PreferredArrivalTime:String)


data class Segment(
        val Destination: String,
    val FlightCabinClass: Int,
    val Origin: String,
    val PreferredDepartureTime: String,
)

class PreferredArrivalTimeResource(val PreferredArrivalTime: String, FlightCabinClass: Int,
                                   Destination:String,Origin:String,PreferredDepartureTime:String)
    :Segment(Destination,FlightCabinClass,Origin,PreferredDepartureTime)
=======
data class Segment(
    val Destination: String,
    val FlightCabinClass: Int,
    val Origin: String,
    val PreferredDepartureTime: String
)
>>>>>>> origin/master
