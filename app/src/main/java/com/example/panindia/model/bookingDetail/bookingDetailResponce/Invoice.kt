package com.example.panindia.model.bookingDetail.bookingDetailResponce

data class Invoice(
    val CreditNoteGSTIN: Any,
    val GSTIN: Any,
    val InvoiceAmount: Int,
    val InvoiceCreatedOn: String,
    val InvoiceId: Int,
    val InvoiceNo: String,
    val InvoiceStatus: Int,
    val Remarks: String
)