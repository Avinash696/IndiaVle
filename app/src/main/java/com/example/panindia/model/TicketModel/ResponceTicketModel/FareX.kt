package com.example.panindia.model.TicketModel.ResponceTicketModel

data class FareX(
    val AdditionalTxnFeeOfrd: Int,
    val AdditionalTxnFeePub: Int,
    val BaseFare: Int,
    val ChargeBU: List<ChargeBUX>,
    val CommissionEarned: Int,
    val Currency: String,
    val Discount: Double,
    val IncentiveEarned: Int,
    val OfferedFare: Double,
    val OtherCharges: Double,
    val PGCharge: Int,
    val PLBEarned: Int,
    val PublishedFare: Double,
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