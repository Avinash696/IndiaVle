package com.example.panindia.viewModel.BookingViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.panindia.Repositary.BookingRepositary
import com.example.panindia.model.BookingForNLCC.BookingReq.BookingReqModel
import com.example.panindia.model.BookingForNLCC.BookingResponce.BookingResponceModel
import com.example.panindia.model.bookingDetail.bookingDetailReq.bookingDetailReqModel1
import com.example.panindia.model.bookingDetail.bookingDetailResponce.bookingDetailResponceModel1
import kotlinx.coroutines.launch

class bookingViewModel(val repoRepo:BookingRepositary):ViewModel() {
    fun bookingVM(bookingReqModel: BookingReqModel){
        viewModelScope.launch {
            repoRepo.booking(bookingReqModel)
        }
    }

    val repoBookingLiveData : LiveData<BookingResponceModel>
        get() = repoRepo.bookingData
}