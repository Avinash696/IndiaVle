package com.example.panindia.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.panindia.R
import com.example.panindia.databinding.ActivityLoginBinding
import com.example.panindia.ui.activity.ui.HomeMainActivity
import com.example.panindia.ui.activity.ui.PanAdminActivity

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_login)
        supportActionBar?.title = "Login"
        hideTopBar()
        binding.tvLogin.setOnClickListener {
            Toast.makeText( this, "ok", Toast.LENGTH_SHORT).show()
//            startActivity(Intent(this,PanCardAdminActivity::class.java))
            startActivity(Intent(this,PanAdminActivity::class.java))
//            startActivity(Intent(this,HomeMainActivity::class.java))
        }
    }
    fun hideTopBar(){
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    fun fnHomeMainActivity(view: View) {
        startActivity(Intent(this,HomeMainActivity::class.java))
    }
}