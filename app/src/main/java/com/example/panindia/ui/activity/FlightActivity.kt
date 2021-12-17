package com.example.indiavle.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.indiavle.ui.frag.MultiStopFragment
import com.example.indiavle.ui.frag.OneWayFragment
import com.example.indiavle.ui.frag.RoundFragment
import com.example.panindia.R
import com.example.panindia.databinding.ActivityFlightBinding

class FlightActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var bindingFlightActivity: ActivityFlightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingFlightActivity = DataBindingUtil.setContentView(this, R.layout.activity_flight)
        supportActionBar?.setTitle("Flight")
        supportActionBar?.hide()

        bindingFlightActivity.tvOneWay.setOnClickListener(this)
        bindingFlightActivity.tvRoundTrip.setOnClickListener(this)
        bindingFlightActivity.tvMultiStop.setOnClickListener(this)

    }
    fun init(){

    }

    fun FragSwitch(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frgFlightHost, fragment)
//        ft.add(R.id.frgHostMain, fragment)
        ft.commit()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvOneWay -> FragSwitch(OneWayFragment())
            R.id.tvRoundTrip -> FragSwitch(RoundFragment())
            R.id.tvMultiStop -> FragSwitch(MultiStopFragment())
            else -> FragSwitch(MultiStopFragment())
        }
    }
}