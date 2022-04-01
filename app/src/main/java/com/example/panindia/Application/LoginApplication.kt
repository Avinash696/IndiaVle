package com.example.panindia.Application

import android.app.Application
import com.example.panindia.Repositary.LoginRepositary
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper

class LoginApplication : Application() {

    private var apiService: ApiService = RetrofitHelper.getRetroInstance().create(ApiService::class.java)
    var repositary: LoginRepositary = LoginRepositary(apiService)

}