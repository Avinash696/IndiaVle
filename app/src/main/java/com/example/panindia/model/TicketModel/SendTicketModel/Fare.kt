package com.example.panindia.model.TicketModel.SendTicketModel

data class Fare(
    val AdditionalTxnFeeOfrd: Int,
    val AdditionalTxnFeePub: Int,
    val BaseFare: Int,
    val ChargeBU: Any?,
    val CommissionEarned: Int,
    val Currency: Any?,
    val Discount: Int,
    val IncentiveEarned: Int,
    val OtherCharges: Int,
    val PGCharge: Int,
    val PLBEarned: Int,
    val ServiceFee: Int,
    val Tax: Int,
    val TaxBreakup: Any?,
    val TdsOnCommission: Int,
    val TdsOnIncentive: Int,
    val TdsOnPLB: Int,
    val TotalBaggageCharges: Int,
    val TotalMealCharges: Int,
    val TotalSeatCharges: Int,
    val TotalSpecialServiceCharges: Int,
    val YQTax: Int
)