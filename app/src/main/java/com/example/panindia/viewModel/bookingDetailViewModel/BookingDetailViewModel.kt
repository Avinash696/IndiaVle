package com.example.panindia.viewModel.bookingDetailViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.panindia.Repositary.GetBookingDetailRepositary
import com.example.panindia.model.TicketModel.ResponceTicketModel.ResponceTicketModel
import com.example.panindia.model.bookingDetail.bookingDetailReq.bookingDetailReqModel1
import com.example.panindia.model.bookingDetail.bookingDetailResponce.bookingDetailResponceModel1
import kotlinx.coroutines.launch

class BookingDetailViewModel(val bookingRepo :GetBookingDetailRepositary) :ViewModel(){

    fun bookingDetailVM(bookingDetailReqModel1: bookingDetailReqModel1){
        viewModelScope.launch {
            bookingRepo.bookingDetailRepo(bookingDetailReqModel1)
        }
    }

    val repoBookingLiveData : LiveData<bookingDetailResponceModel1>
        get() = bookingRepo.bookingShow
}