package com.example.panindia.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.panindia.Repositary.LoginRepositary
import com.example.panindia.model.authenticateModel.responceModel.ResponceModel
import com.example.panindia.model.authenticateModel.sendModel.SendModel

//class LoginViewModel(private val repo:LoginRepositary) : ViewModel() {
class LoginViewModel() : ViewModel() {

    private lateinit var loginViewModel : MutableLiveData<ResponceModel>

//     lateinit var name:MutableLiveData<String>
//     lateinit var password:MutableLiveData<String>
//     lateinit var tokenId :String
    fun loginUserAuth(){
         val TAG = "loginRepo"
        Log.d(TAG, " clicked")
//        val postObject =  SendModel("ApiIntegrationNew","192.168.11.120",password.value.toString(),
//            name.value.toString())
        //custom created model
//        repo.authLoginUser(postObject)
    }
}