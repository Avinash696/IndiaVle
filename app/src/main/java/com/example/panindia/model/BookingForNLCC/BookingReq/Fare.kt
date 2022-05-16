package com.example.panindia.model.BookingForNLCC.BookingReq

data class Fare(
    val AdditionalTxnFeeOfrd: Double,
    val AdditionalTxnFeePub: Double,
    val BaseFare: Double,
    val Currency: String,
    val Discount: Double,
    val OfferedFare: Double,
    val OtherCharges: Double,
    val PublishedFare: Double,
    val ServiceFee: Double,
    val Tax: Double,
    val TdsOnCommission: Double,
    val TdsOnIncentive: Double,
    val TdsOnPLB: Double,
    val YQTax: Double
)