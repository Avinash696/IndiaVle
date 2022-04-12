package com.example.panindia.model.fareRule.receiveFareRule

data class Response(
    val Error: Error,
    val FareRules: List<FareRule>,
    val PenaltyCharges: PenaltyCharges,
    val ResponseStatus: Int,
    val TraceId: String
)