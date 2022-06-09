package com.example.panindia.model.TicketModel.SendTicketModel

data class Fare(
    val AdditionalTxnFeeOfrd: Int,
    val AdditionalTxnFeePub: Int,

    val BaseFare: Int,


    val OtherCharges: Int,


    val Tax: Int,


    val YQTax: Int,
)