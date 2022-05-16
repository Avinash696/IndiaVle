package com.example.panindia.model.BookingForNLCC.BookingResponce

data class Fare(
    val AdditionalTxnFeeOfrd: Double,
    val AdditionalTxnFeePub: Double,
    val BaseFare: Double,
    val ChargeBU: List<ChargeBUX>,
    val CommissionEarned: Double,
    val Currency: String,
    val Discount: Double,
    val IncentiveEarned: Double,
    val OfferedFare: Double,
    val OtherCharges: Double,
    val PGCharge: Double,
    val PLBEarned: Double,
    val PublishedFare: Double,
    val ServiceFee: Double,
    val Tax: Double,
    val TaxBreakup: List<TaxBreakupX>,
    val TdsOnCommission: Double,
    val TdsOnIncentive: Double,
    val TdsOnPLB: Double,
    val TotalBaggageCharges: Double,
    val TotalMealCharges: Double,
    val TotalSeatCharges: Double,
    val TotalSpecialServiceCharges: Double,
    val YQTax: Double
)