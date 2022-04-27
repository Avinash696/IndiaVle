package com.example.panindia.Repositary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.panindia.api.ApiService
import com.example.panindia.model.FareQuote.ResponceFareQuote.ResponceFareQuoteModel
import com.example.panindia.model.FareQuote.SendFareQuote.SendFareQuoteModel

class FareQuoteRepositary(val apiFareQuote:ApiService) {
    private val TAG = "fareQuote"
    private val fareQuoteLiveData =MutableLiveData<ResponceFareQuoteModel>()


    suspend fun fareQuote(sendFareQuoteModel: SendFareQuoteModel){
        val result = apiFareQuote.getFareQuote(sendFareQuoteModel)
        if(result.body() != null){
            fareQuoteLiveData.postValue(result.body())
        }
        else{
            Log.d(TAG, "fareQuote: ${result.errorBody()}")
        }
    }
    val fareQuoteData:LiveData<ResponceFareQuoteModel>
        get() = fareQuoteLiveData
}