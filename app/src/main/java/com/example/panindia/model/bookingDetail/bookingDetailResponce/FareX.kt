package com.example.panindia.model.bookingDetail.bookingDetailResponce

data class FareX(
    val AdditionalTxnFeeOfrd: Int,
    val AdditionalTxnFeePub: Int,
    val BaseFare: Int,
    val ChargeBU: List<ChargeBUX>,
    val CommissionEarned: Int,
    val Currency: String,
    val Discount: Int,
    val IncentiveEarned: Int,
    val OfferedFare: Int,
    val OtherCharges: Int,
    val PGCharge: Int,
    val PLBEarned: Int,
    val PublishedFare: Int,
    val ServiceFee: Int,
    val Tax: Int,
    val TaxBreakup: List<TaxBreakupX>,
    val TdsOnCommission: Int,
    val TdsOnIncentive: Int,
    val TdsOnPLB: Int,
    val TotalBaggageCharges: Int,
    val TotalMealCharges: Int,
    val TotalSeatCharges: Int,
    val TotalSpecialServiceCharges: Int,
    val YQTax: Int
)