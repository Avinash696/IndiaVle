package com.example.indiavle.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.panindia.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.title = "Login"
    }
}