package com.example.panindia.viewModel.FareQuoteTicket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.panindia.Repositary.FareQuoteRepositary
import com.example.panindia.Repositary.TicketRepositary

class FareQuoteFactory(private val repo :FareQuoteRepositary,
                       private val repoTicket:TicketRepositary):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FareQuoteTicketViewModel(repo,repoTicket) as T
    }
}