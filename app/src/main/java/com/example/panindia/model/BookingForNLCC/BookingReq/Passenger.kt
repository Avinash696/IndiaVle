package com.example.panindia.model.BookingForNLCC.BookingReq

data class Passenger(
    val AddressLine1: String,
    val AddressLine2: String,
    val CellCountryCode: String,
    val City: String,
    val ContactNo: String,
    val CountryCode: String,
    val DateOfBirth: String,
    val Email: String,
    val FFAirlineCode: Any?,
    val FFNumber: String,
    val Fare: Fare,
    val FirstName: String,
    val GSTCompanyAddress: String,
    val GSTCompanyContactNumber: String,
    val GSTCompanyEmail: String,
    val GSTCompanyName: String,
    val GSTNumber: String,
    val Gender: Int,
    val IsLeadPax: Boolean,
    val LastName: String,
    val Nationality: String,
    val PassportExpiry: String,
    val PassportNo: String,
    val PaxType: Int,
    val Title: String
)