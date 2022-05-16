package com.example.panindia.viewModel.BookingViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.panindia.Repositary.BookingRepositary

class bookingFactoryViewModel(val repo:BookingRepositary):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return bookingViewModel(repo) as T
    }
}