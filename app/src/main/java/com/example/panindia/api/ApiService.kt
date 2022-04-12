package com.example.panindia.api

import com.example.panindia.model.authenticateModel.responceModel.ResponceModel
import com.example.panindia.model.authenticateModel.sendModel.SendModel
import com.example.panindia.model.fareRule.receiveFareRule.PenaltyCharges
import com.example.panindia.model.fareRule.sendFareRule.sendFareRuleModel
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.ResponceFlightSeachModel
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

    @POST("BookingEngineService_Air/AirService.svc/rest/Search/")
    suspend fun searchFn(@Body searchSendModel: FlightSearchSendModel)
            : Response<ResponceFlightSeachModel>

    @POST("BookingEngineService_Air/AirService.svc/rest/FareRule")
    suspend fun getFareRule(@Body sendFareRuleModel: sendFareRuleModel)
                    :Response<PenaltyCharges>
}