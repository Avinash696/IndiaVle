package com.example.retro.presentView.model.responceModel

data class Member(
    val AgencyId: Int,
    val Email: String,
    val FirstName: String,
    val LastName: String,
    val LoginDetails: String,
    val LoginName: String,
    val MemberId: Int,
    val isPrimaryAgent: Boolean
)