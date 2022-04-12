package com.example.panindia.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.panindia.Repositary.FareRuleRepositary
import com.example.panindia.model.fareRule.receiveFareRule.fareRuleModel
import com.example.panindia.model.fareRule.sendFareRule.sendFareRuleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FareRuleViewModel(private val fareRuleRepositary: FareRuleRepositary) : ViewModel() {

    fun hitFareRule(sendFareRuleModel: sendFareRuleModel){
        viewModelScope.launch {
            fareRuleRepositary.fareUser(sendFareRuleModel)
        }
    }
    val repoLiveData: LiveData<fareRuleModel>
        get() = fareRuleRepositary.fareCost

}