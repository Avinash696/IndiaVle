package com.example.indiavle.ui.activity

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.panindia.R

class HotelActivity : AppCompatActivity() {
    val destination = arrayOf("Noida","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel)
        hideTopBar()
//        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.purple_700)))
    }

    fun FnDestinationhotel(view: View) {
        Toast.makeText(this, "works", Toast.LENGTH_SHORT).show()
    }
    fun hideTopBar(){
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

}