package com.example.panindia.model.authenticateModel.responceModel

import com.example.panindia.api.model.responceModel.Error
import com.example.panindia.api.model.responceModel.Member

data class ResponceModel(
    val Error: Error,
    val Member: Member,
    val Status: Int,
    val TokenId: String
)