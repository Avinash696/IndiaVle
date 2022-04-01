package com.example.panindia.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.panindia.R
import com.example.panindia.api.model.sendModel.PresentSendModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PresentActivity : AppCompatActivity() {
    val TAG = "jack"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_present)

//        hitApi()
    }

//    private fun hitApi() {
//        val postDd = PresentSendModel(
//            "ApiIntegrationNew", "192.168.11.120", "bpind@122",
//            "bpind")
//        val api = RetrofitHelper.getRetroInstance().create(ApiService::class.java)
//        GlobalScope.launch {
//            val call = api.getAuth(postDd)
//
//            val result = call!!.body()
//
//            if (result != null) {
//                Log.d(TAG, "hitApi: ${result.TokenId}")
//            } else {
//                Log.d(TAG, "hitApi: ${call.message()}")
//            }
//        }
//    }
}