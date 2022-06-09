package com.example.panindia.Repositary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.panindia.api.ApiService
import com.example.panindia.model.TicketModel.ResponceTicketModel.ResponceTicketModel
import com.example.panindia.model.TicketModel.SendTicketModel.SendTicketModel

class TicketRepositary(val apiFareQuote: ApiService) {

    private val ticketLiveData = MutableLiveData<ResponceTicketModel>()

    val ticketData :LiveData<ResponceTicketModel>
    get() = ticketLiveData

    suspend fun getTicketFn(sendTicketModel: SendTicketModel){
        val result = apiFareQuote.getTicketDetail(sendTicketModel)
        ticketLiveData.postValue(result.body())
    }
}