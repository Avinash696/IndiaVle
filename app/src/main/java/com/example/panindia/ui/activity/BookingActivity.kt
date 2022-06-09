package com.example.panindia.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.panindia.Repositary.BookingRepositary
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.databinding.ActivityBookingBinding
import com.example.panindia.model.BookingForNLCC.BookingReq.BookingReqModel
import com.example.panindia.model.BookingForNLCC.BookingReq.Fare
import com.example.panindia.model.BookingForNLCC.BookingReq.Passenger
import com.example.panindia.viewModel.BookingViewModel.bookingFactoryViewModel
import com.example.panindia.viewModel.BookingViewModel.bookingViewModel

class BookingActivity : AppCompatActivity() {
    private lateinit var bookViewModel :bookingViewModel
    private lateinit var binding:ActivityBookingBinding
    val nameTitleArr = arrayOf("Mr","Mrs","Ms")
    val genderArr = arrayOf("Male","Female")
    val countryArr = arrayOf("India","Germany","Russia")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_booking)
        //viewModel
        val titleAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,nameTitleArr)
        binding.spTitle.adapter = titleAdapter
        val genderAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,genderArr)
        binding.spTitle.adapter = genderAdapter
        val countryAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,countryArr)
        binding.spTitle.adapter = countryAdapter
        //now show data
        val apiCall = RetrofitHelper.getRetroInstance().create(ApiService::class.java)
        val retro = BookingRepositary(apiCall)
        //intent  data get
        val intent = intent
        val resultIndex =intent.getStringExtra("resultIndex").toString()
        val tokenID =intent.getStringExtra("TokenId").toString()
        val TraceId =intent.getStringExtra("TraceId").toString()
        bookViewModel = ViewModelProvider(this,bookingFactoryViewModel(retro))[bookingViewModel::class.java]

        //gst onlclick

        binding.cbGst.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Log.d("checkbox", "onCheckedChanged: ")
                binding.llGstView.visibility = View.VISIBLE
//                binding.cbGst.isEnabled = false
            }
            else{
                binding.llGstView.visibility = View.GONE
            }
        }
        //btn click
            binding.btnBook.setOnClickListener {
//                startActivity(Intent(this,TicketActivity::class.java))
            }

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

        binding.btnBook.setOnClickListener {
            bookViewModel.bookingVM(dm)
//            startActivity(Intent(this,TicketActivity::class.java))
        }
        bookViewModel.repoBookingLiveData.observe(this,{
          //set ur value now

//            Toast.makeText(this, ""+it.Error.ErrorMessage
//                                +""+it.Response.Status, Toast.LENGTH_SHORT).show()
        })
    }
}