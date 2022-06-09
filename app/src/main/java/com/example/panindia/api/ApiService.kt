package com.example.panindia.api

import com.example.panindia.model.BookingForNLCC.BookingReq.BookingReqModel
import com.example.panindia.model.BookingForNLCC.BookingResponce.BookingResponceModel
import com.example.panindia.model.FareQuote.ResponceFareQuote.ResponceFareQuoteModel
import com.example.panindia.model.FareQuote.SendFareQuote.SendFareQuoteModel
import com.example.panindia.model.TicketModel.ResponceTicketModel.ResponceTicketModel
import com.example.panindia.model.TicketModel.SendTicketModel.SendTicketModel
import com.example.panindia.model.authenticateModel.responceModel.ResponceModel
import com.example.panindia.model.authenticateModel.sendModel.SendModel
import com.example.panindia.model.bookingDetail.bookingDetailReq.bookingDetailReqModel1
import com.example.panindia.model.bookingDetail.bookingDetailResponce.bookingDetailResponceModel1
import com.example.panindia.model.fareRule.receiveFareRule.FareRule
import com.example.panindia.model.fareRule.receiveFareRule.PenaltyCharges
import com.example.panindia.model.fareRule.receiveFareRule.fareRuleModel
import com.example.panindia.model.fareRule.sendFareRule.sendFareRuleModel
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.ResponceFlightSeachModel
import com.example.panindia.model.searchFlightModel.oneWay.req.FlightOneWayReqModel
import com.example.panindia.model.searchFlightModel.sendModel.FlightSearchSendModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("SharedServices/SharedData.svc/rest/Authenticate")
    suspend   fun getAuth(@Body sendModel: SendModel): Response<ResponceModel?>?
//    http://api.tektravels.com/BookingEngineService_Air/AirService.svc/rest/Search

    @POST("BookingEngineService_Air/AirService.svc/rest/Search")
    suspend fun seachFlight(@Body flightSeach: FlightSearchSendModel)
                        :Response<ResponceFlightSeachModel?>

//    @POST("BookingEngineService_Air/AirService.svc/rest/Search/")
//    suspend fun searchFn(@Body searchSendModel: FlightSearchSendModel)
//            : Response<ResponceFlightSeachModel>

    @POST("BookingEngineService_Air/AirService.svc/rest/Search/")
    suspend fun searchFn(@Body searchSendModel: FlightOneWayReqModel)
            : Response<ResponceFlightSeachModel>

    @POST("BookingEngineService_Air/AirService.svc/rest/FareRule/")
    suspend fun getFareRule(@Body sendFareRuleModel: sendFareRuleModel)
                    :Response<fareRuleModel>

    @POST("BookingEngineService_Air/AirService.svc/rest/FareQuote")
    suspend fun getFareQuote(@Body sendFareQuoteMode:SendFareQuoteModel)
            :Response<ResponceFareQuoteModel>

    @POST("BookingEngineService_Air/AirService.svc/rest/Ticket")
    suspend fun getTicketDetail(@Body sendTicketModel: SendTicketModel)
                :Response<ResponceTicketModel>

    @POST("BookingEngineService_Air/AirService.svc/rest/GetBookingDetails")
    suspend fun getBookingDetail(@Body bookingDetailReqModel1: bookingDetailReqModel1)
    :Response<bookingDetailResponceModel1>

    @POST("BookingEngineService_Air/AirService.svc/rest/Book")
    suspend fun getBooking(@Body bookingDetailReq:BookingReqModel)
    :Response<BookingResponceModel>
}