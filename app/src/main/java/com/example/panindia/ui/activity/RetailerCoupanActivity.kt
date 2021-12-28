package com.example.panindia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import com.example.panindia.R
import com.example.panindia.databinding.ActivityRetailerCoupanBinding

class RetailerCoupanActivity : AppCompatActivity() {
    lateinit var spCopanType:Spinner
    lateinit var binding:ActivityRetailerCoupanBinding
    val arrCoupan = arrayOf("P - Type","E - Type")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil. setContentView(this,R.layout.activity_retailer_coupan)
        hideTopBar()
        //copons
        val coupanSelection =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, arrCoupan)
        coupanSelection.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding.spCopanType.adapter = coupanSelection
    }
    fun hideTopBar(){
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

}