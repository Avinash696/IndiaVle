package com.example.panindia.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.panindia.Repositary.FareQuoteRepositary
import com.example.panindia.Repositary.TicketRepositary
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.databinding.ActivityTicketBinding
import com.example.panindia.model.FareQuote.SendFareQuote.SendFareQuoteModel
import com.example.panindia.model.TicketModel.ResponceTicketModel.ChargeBU
import com.example.panindia.model.TicketModel.SendTicketModel.Fare
import com.example.panindia.model.TicketModel.SendTicketModel.Passenger
import com.example.panindia.model.TicketModel.SendTicketModel.SendTicketModel
import com.example.panindia.viewModel.FareQuoteTicket.FareQuoteFactory
import com.example.panindia.viewModel.FareQuoteTicket.FareQuoteTicketViewModel

class TicketActivity : AppCompatActivity() {

    lateinit var fareQuote: FareQuoteTicketViewModel
    private lateinit var binding :ActivityTicketBinding
    lateinit var intentData: Intent
    lateinit var tokenStr: String
    lateinit var traceIdStr: String
    lateinit var resultIndexStr: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intentData = intent
        tokenStr = intentData.getStringExtra("TokenId").toString()
        traceIdStr = intentData.getStringExtra("TraceId").toString()
        resultIndexStr = intentData.getStringExtra("ResultIndex").toString()

        Log.d("ticketTokenCheck", "onCreate: $tokenStr $traceIdStr $resultIndexStr")
        //Both fn viewmodel obj
        val apiCall = RetrofitHelper.getRetroInstance().create(ApiService::class.java)
        val retroQuote = FareQuoteRepositary(apiCall)
        val retroTicket = TicketRepositary(apiCall)
        fareQuote = ViewModelProvider(this,
            FareQuoteFactory(retroQuote,retroTicket))[FareQuoteTicketViewModel::class.java]

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
        val hhmap = HashMap<String,Int>()
        hhmap["TBOMARKUP"] = 0
        hhmap.put("GLOBALPROCUREMENTCHARGE",0)
        hhmap.put("OTHERCHARGE",0)
        hhmap["CONVENIENCECHARGE"] = 0
        val chargeBuObj = ChargeBU("aa",0)
        val taxBreakupObj = ChargeBU("aa",0)
        val ssr = arrayListOf<String>()
        val dummyFareObj = Fare(0,0,100,chargeBuObj,0,"INR",0
            ,0,0,0,0,0,657,taxBreakupObj,0,0,0
        ,0,0,0,0,200)
        val dummyPassanagerObj = Passenger(binding.tlAddress.text.toString(),binding.tlAddress.text.toString(),binding.tlAddress.text.toString(),binding.tlAddress.text.toString()
                ,binding.tlAddress.text.toString(),binding.tlAddress.text.toString(),binding.tlAddress.text.toString(),binding.tlAddress.text.toString(),binding.tlAddress.text.toString()
        ,binding.tlAddress.text.toString(),dummyFareObj,binding.tlAddress.text.toString(),binding.tlAddress.text.toString(),binding.tlAddress.text.toString()
        ,binding.tlAddress.text.toString(),"Test","12ASDFH1234K1Z1",1,true,"tbo","IN"
        ,"2022-12-06T00:00:00","KJHHJKHKJH",2873844,1,ssr,"Mr")
        val dummySendTicketObj = SendTicketModel(binding.tlEtName.text.toString(),
            listOf(dummyPassanagerObj),null,resultIndexStr,tokenStr,traceIdStr)
        Log.d("ticketActivity", "hitTicket: ")

        //viewmodel fun hit
//        fareQuote.hitTicketViewModel(dummyObj)
        fareQuote.repoTicketLiveData.observe(this, {
                Log.d("hitTicket", "hitTicket: ${it.Response.Response}")
        })

        binding.btConfirmTicket.setOnClickListener {
            fareQuote.hitTicketViewModel(dummySendTicketObj)
            startActivity(Intent(this,GetBookingDetailActivity::class.java))
        }
    }
}