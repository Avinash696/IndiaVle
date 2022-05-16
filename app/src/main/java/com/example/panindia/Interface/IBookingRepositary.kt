package com.example.panindia.Interface

import com.example.panindia.model.BookingForNLCC.BookingReq.BookingReqModel

interface IBookingRepositary {

    interface BookingRepositary {
        fun onDataLoaded(responseBody: BookingReqModel?)

        fun onDataNotAvailable()
    }

    fun getBookingReq(callback: BookingRepositary)

}