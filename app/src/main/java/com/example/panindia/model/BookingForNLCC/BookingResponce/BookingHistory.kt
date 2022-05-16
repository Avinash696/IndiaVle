package com.example.panindia.model.BookingForNLCC.BookingResponce

data class BookingHistory(
    val BookingId: Int,
    val CreatedBy: Int,
    val CreatedByName: String,
    val CreatedOn: String,
    val EventCategory: Int,
    val LastModifiedBy: Int,
    val LastModifiedByName: String,
    val LastModifiedOn: String,
    val Remarks: String
)