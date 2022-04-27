package com.example.panindia.viewModel.FareQuoteTicket

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.panindia.Repositary.FareQuoteRepositary
import com.example.panindia.model.FareQuote.ResponceFareQuote.ResponceFareQuoteModel
import com.example.panindia.model.FareQuote.SendFareQuote.SendFareQuoteModel
import com.example.panindia.model.fareRule.receiveFareRule.fareRuleModel
import kotlinx.coroutines.launch

class FareQuoteTicketViewModel(val repoFareQuoteTicket: FareQuoteRepositary) : ViewModel() {

    fun hitFareQuote(sendFareQuoteModel: SendFareQuoteModel){
        viewModelScope.launch {
            repoFareQuoteTicket.fareQuoteData
        }
    }

    val repoLiveData: LiveData<ResponceFareQuoteModel>
        get() = repoFareQuoteTicket.fareQuoteData
}