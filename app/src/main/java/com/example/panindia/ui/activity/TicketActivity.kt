package com.example.panindia.ui.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.panindia.R
import com.example.panindia.Repositary.FareQuoteRepositary
import com.example.panindia.Repositary.FareRuleRepositary
import com.example.panindia.Repositary.TicketRepositary
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.model.FareQuote.SendFareQuote.SendFareQuoteModel
import com.example.panindia.model.TicketModel.SendTicketModel.SendTicketModel
import com.example.panindia.model.fareRule.sendFareRule.sendFareRuleModel
import com.example.panindia.viewModel.FareQuoteTicket.FareQuoteFactory
import com.example.panindia.viewModel.FareQuoteTicket.FareQuoteTicketViewModel
import com.example.panindia.viewModel.FareRuleFactoryModel
import com.example.panindia.viewModel.FareRuleViewModel

class TicketActivity : AppCompatActivity() {
    lateinit var fareQuote: FareQuoteTicketViewModel
    lateinit var intentData: Intent
    lateinit var tokenStr: String
    lateinit var traceIdStr: String
    lateinit var resultIndexStr: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)

        intentData = intent
        tokenStr = intentData.getStringExtra("TokenId").toString()
        traceIdStr = intentData.getStringExtra("TokenId").toString()
        resultIndexStr = intentData.getStringExtra("TokenId").toString()

        Log.d("ticketTokenCheck", "onCreate: $tokenStr $traceIdStr $resultIndexStr")
        //Both fn viewmodel obj
        val apiCall = RetrofitHelper.getRetroInstance().create(ApiService::class.java)
        val retroQuote = FareQuoteRepositary(apiCall)
        val retroTicket = TicketRepositary(apiCall)
        fareQuote = ViewModelProvider(this,
            FareQuoteFactory(retroQuote))[FareQuoteTicketViewModel::class.java]

        hitFareQuote(tokenStr, traceIdStr, resultIndexStr)
        hitTicket(tokenStr, traceIdStr, resultIndexStr)
    }

    private fun hitFareQuote(tokenStr: String, traceIdStr: String, resultIndexStr: String) {
        //now show data
        val dummyObj = SendFareQuoteModel("192.168.11.58", resultIndexStr, tokenStr, traceIdStr)
        fareQuote.hitFareQuote(dummyObj)

        fareQuote.repoLiveData.observe(this, {
            Log.d("hitQuote", "hitFareQuote: ${it.Response}")
        })
    }

    private fun hitTicket(tokenStr: String, traceIdStr: String, resultIndexStr: String) {
//        val dummyObj = SendTicketModel()
        Log.d("ticketActivity", "hitTicket: ")
        //viewmodel fun hit
//        fareQuote.hitTicketViewModel(dummyObj)
        fareQuote.repoTicketLiveData.observe(this, {
            Log.d("hitTicket", "hitTicket: ${it.Response.Response}")
        })
    }
}