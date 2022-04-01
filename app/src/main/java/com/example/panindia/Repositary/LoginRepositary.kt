package com.example.panindia.Repositary

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.panindia.api.ApiService
import com.example.panindia.model.authenticateModel.responceModel.ResponceModel
import com.example.panindia.model.authenticateModel.sendModel.SendModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginRepositary(private val loginService: ApiService) {
    private val TAG = "loginRepo"
    private lateinit var loginDetail :MutableLiveData<ResponceModel>
    fun authLoginUser( sendModel: SendModel) {
        GlobalScope.launch {
            val result = loginService.getAuth(sendModel)
            if (result?.body() == null) {
                loginDetail.postValue(result?.body())
                Log.d(TAG, "authLoginUser: ${loginDetail.value?.TokenId}")

//                Log.d(TAG, "authLoginUser: ${loginDetail.value}")
            } else {
                Log.d(TAG, "authLoginUser: " + result.errorBody())
            }
        }
    }
}