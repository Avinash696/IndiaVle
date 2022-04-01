package com.example.panindia.model.authenticateModel.sendModel

data class SendModel(
    val ClientId: String,
    val EndUserIp: String,
    val Password: String,
    val UserName: String
)