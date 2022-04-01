package com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel

data class FareBreakdown(
    val AdditionalTxnFeeOfrd: Int,
    val AdditionalTxnFeePub: Int,
    val BaseFare: Int,
    val Currency: String,
    val PGCharge: Int,
    val PassengerCount: Int,
    val PassengerType: Int,
    val SupplierReissueCharges: Int,
    val Tax: Int,
    val TaxBreakUp: List<TaxBreakUpX>,
    val YQTax: Int
)