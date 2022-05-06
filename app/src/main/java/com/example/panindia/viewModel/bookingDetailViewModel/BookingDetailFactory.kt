package com.example.panindia.viewModel.bookingDetailViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.panindia.Repositary.GetBookingDetailRepositary

class BookingDetailFactory(private val repositary: GetBookingDetailRepositary) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  BookingDetailViewModel(repositary) as T
    }
}