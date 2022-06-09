package com.example.panindia.model.searchFlightModel.oneWay.responce

data class Result(
    val AirlineCode: String,
    val AirlineRemark: String,
    val Fare: Fare,
    val FareBreakdown: List<FareBreakdown>,
    val FareClassification: FareClassification,
    val FareRules: List<FareRule>,
    val GSTAllowed: Boolean,
    val IsCouponAppilcable: Boolean,
    val IsGSTMandatory: Boolean,
    val IsHoldAllowedWithSSR: Boolean,
    val IsLCC: Boolean,
    val IsPanRequiredAtBook: Boolean,
    val IsPanRequiredAtTicket: Boolean,
    val IsPassportRequiredAtBook: Boolean,
    val IsPassportRequiredAtTicket: Boolean,
    val IsRefundable: Boolean,
    val IsUpsellAllowed: Boolean,
    val LastTicketDate: Any,
    val MiniFareRules: List<List<MiniFareRule>>,
    val PenaltyCharges: PenaltyCharges,
    val ResultFareType: String,
    val ResultIndex: String,
    val Segments: List<List<Segment>>,
    val Source: Int,
    val TicketAdvisory: Any,
    val ValidatingAirline: String
)