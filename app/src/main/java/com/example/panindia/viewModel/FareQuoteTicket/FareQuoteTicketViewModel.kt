package com.example.panindia.viewModel.FareQuoteTicket

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.panindia.Repositary.FareQuoteRepositary
import com.example.panindia.Repositary.TicketRepositary
import com.example.panindia.model.FareQuote.ResponceFareQuote.ResponceFareQuoteModel
import com.example.panindia.model.FareQuote.SendFareQuote.SendFareQuoteModel
import com.example.panindia.model.TicketModel.ResponceTicketModel.ResponceTicketModel
import com.example.panindia.model.TicketModel.SendTicketModel.SendTicketModel
import com.example.panindia.model.fareRule.receiveFareRule.fareRuleModel
import kotlinx.coroutines.launch

class FareQuoteTicketViewModel(val repoFareQuoteTicket: FareQuoteRepositary,
                                val repoTicket:TicketRepositary) : ViewModel() {

    fun hitFareQuote(sendFareQuoteModel: SendFareQuoteModel){
        viewModelScope.launch {
//            repoFareQuoteTicket.fareQuoteData
            repoFareQuoteTicket.fareQuote(sendFareQuoteModel)
        }
    }
    fun hitTicketViewModel(sendTicketModel: SendTicketModel) {
        viewModelScope.launch {
            repoTicket.getTicketFn(sendTicketModel)
        }
    }


    val repoLiveData: LiveData<ResponceFareQuoteModel>
        get() = repoFareQuoteTicket.fareQuoteData

    val repoTicketLiveData :LiveData<ResponceTicketModel>
    get() = repoTicket.ticketData

}