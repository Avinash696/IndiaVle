package com.example.panindia.ui.activity.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.panindia.ui.homeDrawable.OthersActivity
import com.example.panindia.R
import com.example.panindia.ui.homeDrawable.*

class HomeMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_main)
    }

    fun fnPanCard(view: View) {
        startActivity(Intent(this,PanCardActivity::class.java))
    }

    fun fnAeps(view: View) {
        startActivity(Intent(this,AepsActivity::class.java))
    }
    fun fnMoneyTransfer(view: View) {
        startActivity(Intent(this,MoneyTransferActivity::class.java))
    }
    fun fnBBPS(view: View) {
        startActivity(Intent(this,BbpsActivity::class.java))
    }
    fun fnFlight(view: View) {
        startActivity(Intent(this,FlightActivity::class.java))
    }
    fun fnRecharge(view: View) {
        startActivity(Intent(this,RechargeActivity::class.java))
    }
    fun fnInsurance(view: View) {
        startActivity(Intent(this,InsuranceActivity::class.java))
    }
    fun fnOthers(view: View) {
        startActivity(Intent(this, OthersActivity::class.java))
    }
}