package com.example.panindia.Repositary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.panindia.api.ApiService
import com.example.panindia.model.fareRule.receiveFareRule.PenaltyCharges
import com.example.panindia.model.fareRule.sendFareRule.sendFareRuleModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FareRuleRepositary (private val fareService:ApiService){
private val TAG = ""
    private lateinit var fareDetail :MutableLiveData<PenaltyCharges>

    fun fareUser(sendFareRuleModel: sendFareRuleModel){
          suspend {
              val result  = fareService.getFareRule(sendFareRuleModel)
              if(result.body() != null){
                  fareDetail.postValue(result.body())
                  Log.d(TAG, "fareUser:Success Response ${result.body()}")
              }
              else{
                  Log.d(TAG, "fareUser: No response ${result.errorBody()}")
              }
          }
    }
}