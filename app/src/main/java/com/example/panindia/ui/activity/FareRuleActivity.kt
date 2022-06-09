package com.example.panindia.ui.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.panindia.Repositary.FareRuleRepositary
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.databinding.ActivityFareRuleBinding
import com.example.panindia.model.fareRule.sendFareRule.sendFareRuleModel
import com.example.panindia.viewModel.FareRuleFactoryModel
import com.example.panindia.viewModel.FareRuleViewModel
import com.google.gson.Gson

class FareRuleActivity : AppCompatActivity() {

    //only viewBinding used
    lateinit var fareViewModel: FareRuleViewModel
    private lateinit var binding: ActivityFareRuleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//       binding = DataBindingUtil.setContentView(this,R.layout.activity_fare_rule)
        binding = ActivityFareRuleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val authToken = intent.getStringExtra("authToken")
        val traceId = intent.getStringExtra("traceId")
        val resultIndex = intent.getStringExtra("resultIndex")
//receive
        val airlineNameInt = intent.getStringExtra("airlineName")
//        val flightTypeInt = intent.getStringExtra("flightType")
        val flightNumberInt = intent.getStringExtra("flightNumber")
        val baseFareInt = intent.getStringExtra("baseFare")
        val taxesInt = intent.getStringExtra("taxesAndFees")
        val totalFareInt = intent.getStringExtra("totalFare")

        //source and desti
        val srcName = intent.getStringExtra("srcInt")
        val destiName = intent.getStringExtra("desInt")
//        val flightType = intent.extras!!.getBoolean("flightType")
        val flightTT = intent.extras?.getBoolean("flightType")
        val countPassanger = intent.getStringExtra("passangerCount")
        Log.d("trader", "onCreate: $countPassanger")
        Log.d("fareDd", "onCreate: " +
                "$airlineNameInt $flightTT $flightNumberInt $baseFareInt $taxesInt $totalFareInt")
        hitFareRule(authToken!!, traceId!!, resultIndex!!)
        setViewData(airlineNameInt!!, flightTT!!, flightNumberInt!!, baseFareInt!!,
            taxesInt!!, totalFareInt!!, srcName!!, destiName!!)
        //redirect acc to flight type
        binding.btBookNow.setOnClickListener {
            if (flightTT) {
                //lcc
                val intent = Intent(this, TicketActivity::class.java)
                intent.putExtra("TokenId", authToken)
                intent.putExtra("TraceId", traceId)
                intent.putExtra("ResultIndex", resultIndex)
                intent.putExtra("passangerCount", countPassanger)
                startActivity(intent)
            } else {
                //non LCc
                val typeLcc = Intent(this, BookingActivity::class.java)
                typeLcc.putExtra("TokenId", authToken)
                typeLcc.putExtra("resultIndex", resultIndex)
                typeLcc.putExtra("TraceId", traceId)
                startActivity(typeLcc)
            }
        }
    }


    private fun setViewData(
        airlineName: String,
        flightTypeInt: Boolean,
        flightNumberInt: String,
        baseFareInt: String,
        taxesInt: String,
        totalFareInt: String,
        srcDef: String,
        destiDef: String
    )
    {
        binding.tvAirline.text = airlineName
        binding.tvFlightType.text = flightTypeInt.toString()
        binding.tvFlightNumber.text = flightNumberInt
        binding.tvBaseFare.text = baseFareInt
        binding.tvTaxesAndFees.text = taxesInt
        binding.tvTotalPrice.text = totalFareInt
        binding.tvLocations.text = "$srcDef-->$destiDef"
    }

    private fun hitFareRule(authToken: String, traceId: String, resultIndex: String) {
        //check if fight is lCC or non
        val fightType: Boolean
        Log.d("resultCheckOnAll", "hitFareRule: $resultIndex")
        val dd = sendFareRuleModel("192.168.11.58", resultIndex, authToken, traceId)

        //now show data
        val apiCall = RetrofitHelper.getRetroInstance().create(ApiService::class.java)
        val retro = FareRuleRepositary(apiCall)

        fareViewModel =
            ViewModelProvider(this, FareRuleFactoryModel(retro))[FareRuleViewModel::class.java]
        fareViewModel.hitFareRule(dd)
        fareViewModel.repoLiveData.observe(this, {
            Log.d("myNight", "hitFareRule:${Gson().toJson( it.Response)} ")
            binding.tvFareRuleDetail.text = it.Response.FareRules[0].FareRuleDetail

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                binding.tvFareRuleDetail.text =
                    (Html.fromHtml(it.Response.FareRules[0].FareRuleDetail,
                        Html.FROM_HTML_MODE_COMPACT))
            };
        })

    }
}