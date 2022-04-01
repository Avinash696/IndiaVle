package com.example.panindia.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel

class SeachFlightViewModel :ViewModel(){
    val TAG = "seachFlightViewModel"

    fun searchFlight(){
        Log.d(TAG, "searchFlight: Clicked")
    }
}