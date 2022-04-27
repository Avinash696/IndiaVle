package com.example.panindia.ui.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.panindia.R
import com.example.panindia.Repositary.FareQuoteRepositary
import com.example.panindia.Repositary.FareRuleRepositary
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.model.FareQuote.SendFareQuote.SendFareQuoteModel
import com.example.panindia.model.fareRule.sendFareRule.sendFareRuleModel
import com.example.panindia.viewModel.FareQuoteTicket.FareQuoteFactory
import com.example.panindia.viewModel.FareQuoteTicket.FareQuoteTicketViewModel
import com.example.panindia.viewModel.FareRuleFactoryModel
import com.example.panindia.viewModel.FareRuleViewModel

class TicketActivity : AppCompatActivity() {
    lateinit var fareQuote : FareQuoteTicketViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)
    }

    private fun hitFareQuote(){
        //now show data
        val apiCall = RetrofitHelper.getRetroInstance().create(ApiService::class.java)
        val retro = FareQuoteRepositary(apiCall)
        fareQuote = ViewModelProvider(this,FareQuoteFactory(retro))[FareQuoteTicketViewModel::class.java]

        val dd = SendFareQuoteModel()
        fareQuote.hitFareQuote(dd)

        fareQuote.repoLiveData.observe(this,{
            Log.d("ticket Activity", "hitFareQuote: ${it.Response}")
        })
    }
}