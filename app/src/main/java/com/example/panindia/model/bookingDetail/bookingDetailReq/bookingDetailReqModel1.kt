package com.example.panindia.model.bookingDetail.bookingDetailReq

//data class bookingDetailReqModel1(
//    val BookingId: String,
//    override val EndUserIp: String,
//    val PNR: String,
//    val TokenId: String
//) : bookingDetailReqModelFirst(EndUserIp,PNR,TokenId){
//    override val EndUserIp: String
//        get() = super.EndUserIp
//    override val PNR: String
//        get() = super.PNR
//    override val TokenId: String
//        get() = super.TokenId
//}
//
//
// open class bookingDetailReqModelFirst(
//     open val EndUserIp: String,
//     open val PNR: String,
//     open val TokenId: String
//)

//data class bookingDetailReqModel1(
//    val EndUserIp: String,
//    val PNR: String,
//    val TokenId: String,
//    override val BookingId: String,
//) : ResourceBooking(BookingId)
//
//open class ResourceBooking(open val BookingId: String)


data class bookingDetailReqModel1(
    val BookingId: String,
    override val EndUserIp: String,
    override val PNR: String,
    override val TokenId: String,
) : bookingDetailResource(EndUserIp,
    PNR,
    TokenId)

open class bookingDetailResource(
    open val EndUserIp: String,
    open val PNR: String,
    open val TokenId: String,
)
