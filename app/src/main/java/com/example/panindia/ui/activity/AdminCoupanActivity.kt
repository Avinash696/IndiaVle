package com.example.panindia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import com.example.panindia.R
import com.example.panindia.databinding.ActivityAdminCoupanBinding

class AdminCoupanActivity : AppCompatActivity() {
    lateinit var spCopanType: Spinner
    lateinit var binding :ActivityAdminCoupanBinding
    val arrCoupan = arrayOf("P - Type","E - Type")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_admin_coupan)
        hideTopBar()
        //copons
        val coupanSelection =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, arrCoupan)
        coupanSelection.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding.spCopanTypeAdmin.adapter = coupanSelection
    }
    fun hideTopBar(){
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}