package com.example.panindia.model.TicketModel.ResponceTicketModel

data class Invoice(
    val CreditNoteGSTIN: Any,
    val GSTIN: Any,
    val InvoiceAmount: Double,
    val InvoiceCreatedOn: String,
    val InvoiceId: Int,
    val InvoiceNo: String,
    val InvoiceStatus: Int,
    val Remarks: String
)