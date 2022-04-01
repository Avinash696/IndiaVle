package com.example.panindia.api.model.responceModel

data class ResponcePresentModel(
    val Error: Error,
    val Member: Member,
    val Status: Int,
    val TokenId: String
)