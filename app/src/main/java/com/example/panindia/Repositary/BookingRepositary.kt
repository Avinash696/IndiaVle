package com.example.panindia.Repositary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.panindia.Interface.IBookingRepositary
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.model.BookingForNLCC.BookingReq.BookingReqModel
import com.example.panindia.model.BookingForNLCC.BookingResponce.BookingResponceModel
import retrofit2.Retrofit

class BookingRepositary(val apiRepo :ApiService) {

    private val bookingLiveData = MutableLiveData<BookingResponceModel>()
    val bookingData :LiveData<BookingResponceModel>
    get() = bookingLiveData

    suspend fun booking(bookingReqModel: BookingReqModel){
        val result = apiRepo.getBooking(bookingReqModel)
        if(result.body() != null){
            bookingLiveData.postValue(result.body())
        }
    }

//    override fun getBookingReq(callback: IBookingRepositary.BookingRepositary) {
//        TODO("Not yet implemented")
//       val result= RetrofitHelper.getRetroInstance().create(ApiService::class.java)
//        val call = result.getBooking()
//    }
}