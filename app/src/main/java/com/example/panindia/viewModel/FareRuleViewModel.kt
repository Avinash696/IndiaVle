package com.example.panindia.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.panindia.Repositary.FareRuleRepositary
import com.example.panindia.model.fareRule.receiveFareRule.fareRuleModel
import com.example.panindia.model.fareRule.sendFareRule.sendFareRuleModel

class FareRuleViewModel(private val fareRuleRepositary: FareRuleRepositary): ViewModel() {
private val TAG = "myfare"
    private lateinit var fareMutableLiveData :MutableLiveData<fareRuleModel>
    private lateinit var fareLiveData :LiveData<fareRuleModel>

    suspend fun fareRuleView(){
        val dd = sendFareRuleModel("192.168.11.58","OB1",
        "434c6a31-b102-441a-9096-50628c4c4947","56f5744d-bcc7-463e-ab58-66f410ff9cac")
        val result = fareRuleRepositary.fareUser(dd)
//        fareMutableLiveData.postValue(result)
        Log.d(TAG, "fareRuleView: ${result}")
    }
}