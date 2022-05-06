package com.example.panindia.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.panindia.R
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.databinding.ActivityLoginBinding
import com.example.panindia.model.authenticateModel.sendModel.SendModel
import com.example.panindia.ui.activity.ui.HomeMainActivity
import com.example.panindia.ui.frag.OneWayFragment
import com.example.panindia.viewModel.LoginViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    val TAG = "loginActivity"
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        supportActionBar?.title = "Login"
        hideTopBar()

//        bundle = Bundle()
//        //application class set
//        val repo = (application as LoginApplication).repositary
//        loginViewModel = ViewModelProvider(this,LoginViewModelFactory(repo))[LoginViewModel::class.java]
//        binding.lifecycleOwner = this
//
//        //viewmodel without factory
//        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
//        binding.loginViewModel =loginViewModel
//        loginViewModel.loginUserAuth()

        loginViewModel =
            ViewModelProvider(this)[LoginViewModel::class.java]
        binding.loginViewModel = loginViewModel
        binding.lifecycleOwner = this

        //temparary btn
        binding.tvLogin.setOnClickListener {
            Log.d(TAG, "ur click works")
            hitApi(binding.etLoginName.text.toString(), binding.etLoginPassword.text.toString())
        }
    }

    fun hideTopBar() {
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    private fun hitApi(name: String, password: String) {
        val postDd = SendModel(
            "ApiIntegrationNew", "192.168.11.120", password, name
        )
        val api = RetrofitHelper.getRetroInstance().create(ApiService::class.java)
        GlobalScope.launch {
            val call = api.getAuth(postDd)
            val result = call!!.body()

            if (name == "bpind" && password == "bpind@122") {
//                Log.d(TAG, "hitApi: ${result.TokenId}")
                val intent = Intent(this@LoginActivity, FlightActivity::class.java)
                    intent.putExtra("loginToken", result!!.TokenId)
                startActivity(intent)
            } else {
                Log.d(TAG, "hitApi: ${call.message()}")
                Toast.makeText(
                    this@LoginActivity,
                    "Please Check UserName & Password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}