package com.example.panindia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.panindia.R
import com.example.panindia.Repositary.BookingRepositary
import com.example.panindia.Repositary.FareRuleRepositary
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.model.BookingForNLCC.BookingReq.BookingReqModel
import com.example.panindia.model.BookingForNLCC.BookingReq.Fare
import com.example.panindia.model.BookingForNLCC.BookingReq.Passenger
import com.example.panindia.viewModel.BookingViewModel.bookingFactoryViewModel
import com.example.panindia.viewModel.BookingViewModel.bookingViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BookingActivity : AppCompatActivity() {
    lateinit var bookViewModel :bookingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        //viewModel
        //now show data
        val apiCall = RetrofitHelper.getRetroInstance().create(ApiService::class.java)
        val retro = BookingRepositary(apiCall)
        //intent  data get
        val intent = intent
        val resultIndex =intent.getStringExtra("resultIndex").toString()
        val tokenID =intent.getStringExtra("TokenId").toString()
        val TraceId =intent.getStringExtra("TraceId").toString()
        bookViewModel = ViewModelProvider(this,bookingFactoryViewModel(retro))[bookingViewModel::class.java]

        hitBookingApi(resultIndex,tokenID,TraceId)
    }

    private fun hitBookingApi(resultIndex:String,tokenID:String,TraceId:String){
        val fare = Fare(0.0,0.0,3171.0,"INR", 0.0,4355.03,
        116.96,4581.96,10.0,1284.0,6.34,6.22,9.14,0.0)
        val passanger = Passenger("123, Test","123, Test","+92581-",
            "Gurgaon","1234567890","IN","1987-12-06T00:00:00","harsh@tbtq.in"
        ,null,"",fare,"hgjsshsxsgjh","","",
        "","","",1,true,"tbotest",
        "IN","2023-12-06T00:00:00","KJHHJKHKJH",1,"Mr"  )
        val dm = BookingReqModel("192.168.11.58", listOf(passanger),resultIndex,tokenID,TraceId)

        bookViewModel.bookingVM(dm)

        bookViewModel.repoBookingLiveData.observe(this,{
          //set ur value now
            it.Response
        })
    }
}