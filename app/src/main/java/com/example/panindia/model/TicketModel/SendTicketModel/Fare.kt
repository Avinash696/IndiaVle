package com.example.panindia.model.TicketModel.SendTicketModel

data class Fare(
    val AdditionalTxnFeeOfrd: Double,
    val AdditionalTxnFeePub: Double,
    val BaseFare: Double,
    val ChargeBU: Any,
    val CommissionEarned: Double,
    val Currency: Any,
    val Discount: Double,
    val IncentiveEarned: Double,
    val OtherCharges: Double,
    val PGCharge: Double,
    val PLBEarned: Double,
    val ServiceFee: Double,
    val Tax: Double,
    val TaxBreakup: Any,
    val TdsOnCommission: Double,
    val TdsOnIncentive: Double,
    val TdsOnPLB: Double,
    val TotalBaggageCharges: Double,
    val TotalMealCharges: Double,
    val TotalSeatCharges: Double,
    val TotalSpecialServiceCharges: Double,
    val YQTax: Double
)