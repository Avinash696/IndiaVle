package com.example.panindia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.panindia.R
import com.example.panindia.Repositary.GetBookingDetailRepositary
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.databinding.ActivityGetBookingDetailBinding
import com.example.panindia.model.bookingDetail.bookingDetailReq.bookingDetailReqModel1
import com.example.panindia.model.bookingDetail.bookingDetailReq.bookingDetailResource
import com.example.panindia.viewModel.bookingDetailViewModel.BookingDetailFactory
import com.example.panindia.viewModel.bookingDetailViewModel.BookingDetailViewModel

class GetBookingDetailActivity : AppCompatActivity() {
    private lateinit var bookingViewModel: BookingDetailViewModel
    private lateinit var binding: ActivityGetBookingDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_booking_detail)
        binding = ActivityGetBookingDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //intent Data
        val intent = intent

        val stToken = intent.getStringExtra("stToken")
        val stPnr = intent.getStringExtra("stPnr")
        val stBookingId = intent.getStringExtra("stBookingId")
        Log.d("getBookingTT", "onCreate:$stToken $stPnr $stBookingId")
        //viewModel Def
        val apiCall = RetrofitHelper.getRetroInstance().create(ApiService::class.java)
        val retroBooking = GetBookingDetailRepositary(apiCall)
        bookingViewModel = ViewModelProvider(this,
            BookingDetailFactory(retroBooking))[BookingDetailViewModel::class.java]

        setBookingDetail(stToken!!, stPnr!!, stBookingId!!)
//        Log.d("testBookApi", "onCreate:$stToken $stPnr $dddd")
//        setBookingDetail(stToken, stPnr!!, dddd!!)
    }

    private fun setBookingDetail(stToken: String, stPnr: String, stBookingId: String) {
        val bookingDummyModel = bookingDetailReqModel1(stBookingId, "192.168.11.58", stPnr, stToken)

        val dd = bookingDetailResource("192.168.11.58", stPnr, stToken)
        bookingViewModel.bookingDetailVM(bookingDummyModel)
        bookingViewModel.repoBookingLiveData.observe(this, {
            Log.d("bookingConfirm", "setBookingDetail: ${it.Response}")
            binding.tvBookingNumber.text = it.Response.FlightItinerary.BookingId.toString()
            binding.tvFirstName.text = it.Response.FlightItinerary.Passenger[0].FirstName.toString()
            binding.tvLastName.text = it.Response.FlightItinerary.Passenger[0].LastName
            binding.tvEmail.text = it.Response.FlightItinerary.Passenger[0].Email
            binding.tvAddress.text = it.Response.FlightItinerary.Passenger[0].AddressLine1
            binding.tvCity.text = it.Response.FlightItinerary.Passenger[0].City
//            binding.tvZipCode.text = it.Response.FlightItinerary.Passenger[0]
            binding.tvCountry.text = it.Response.FlightItinerary.Passenger[0].CountryCode
        })
    }
}