package com.example.panindia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.panindia.R
import com.example.panindia.Repositary.FareRuleRepositary
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.model.fareRule.sendFareRule.sendFareRuleModel
import com.example.panindia.viewModel.FareRuleFactoryModel
import com.example.panindia.viewModel.FareRuleViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FareRuleActivity : AppCompatActivity() {
    private val TAG = "fareRule"
    lateinit var fareViewModel :FareRuleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fare_rule)

        val intent = intent
        val authToken = intent.getStringExtra("authToken")
        val traceId = intent.getStringExtra("traceId")
        val resultIndex = intent.getStringExtra("resultIndex")

        Log.d(TAG, "onCreate:$authToken $traceId $resultIndex ")

        hitFareRule()

    }

    fun hitFareRule(){
        val quoteServie = RetrofitHelper.getRetroInstance().create(ApiService::class.java)
        val dd = sendFareRuleModel("192.168.11.58","OB1",
            "434c6a31-b102-441a-9096-50628c4c4947","56f5744d-bcc7-463e-ab58-66f410ff9cac")
        val repositary = quoteServie.getFareRule(dd)
        fareViewModel = ViewModelProvider(this,FareRuleFactoryModel(repositary))[FareRuleViewModel::class.java]
        GlobalScope.launch {

            val tt = fareViewModel.fareRuleView()
            if(tt != null){

            }
            Log.d(TAG, "hitFareRule: $tt")
        }
    }
}