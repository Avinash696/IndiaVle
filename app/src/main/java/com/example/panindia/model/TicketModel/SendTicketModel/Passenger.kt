package com.example.panindia.model.TicketModel.SendTicketModel

data class Passenger(
    val AddressLine1: String,
    val AddressLine2: String,
    val City: String,
    val ContactNo: String,
    val CountryCode: String,
    val CountryName: String,
    val DateOfBirth: String,
    val Email: String,
    val FFAirlineCode: String,
    val FFNumber: String,
    val Fare: Fare,
    val FirstName: String,

    val Gender: Int,
    val IsLeadPax: Boolean,
    val LastName: String,
    val Nationality: String,
    val PassportExpiry: String,
    val PassportNo: String,

    val PaxType: Int,

    val Title: String,
)