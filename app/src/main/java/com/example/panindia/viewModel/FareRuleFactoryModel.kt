package com.example.panindia.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.panindia.Repositary.FareRuleRepositary

class FareRuleFactoryModel(val respo:FareRuleRepositary) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FareRuleViewModel(respo) as T
    }
}