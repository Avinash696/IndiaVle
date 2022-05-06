package com.example.panindia.Repositary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.panindia.api.ApiService
import com.example.panindia.model.bookingDetail.bookingDetailReq.bookingDetailReqModel1
import com.example.panindia.model.bookingDetail.bookingDetailResponce.bookingDetailResponceModel1

class GetBookingDetailRepositary(val apiService: ApiService) {

private val bookingLiveData = MutableLiveData<bookingDetailResponceModel1>()

    val bookingShow :LiveData<bookingDetailResponceModel1>
    get() = bookingLiveData

    suspend fun bookingDetailRepo(bookingDetailReqModel1: bookingDetailReqModel1){
        val result = apiService.getBookingDetail(bookingDetailReqModel1)
        if(result.body() != null ){
            bookingLiveData.postValue(result.body())
        }
    }
}