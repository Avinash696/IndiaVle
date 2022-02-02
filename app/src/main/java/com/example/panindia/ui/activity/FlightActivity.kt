package com.example.indiavle.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
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
    var checkOne = false
    var checkMulti = false
    var checkRound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideTopBar()
        bindingFlightActivity = DataBindingUtil.setContentView(this, R.layout.activity_flight)
        supportActionBar?.setTitle("Flight")


        bindingFlightActivity.tvOneWay.setOnClickListener(this)
        bindingFlightActivity.tvRoundTrip.setOnClickListener(this)
        bindingFlightActivity.tvMultiStop.setOnClickListener(this)

        DefaultFrag()
    }
    fun DefaultFrag(){
        checkOne = true
        checkMulti = false
        checkRound = false
        FragSwitch(OneWayFragment())
        changeColor()
    }
    fun hideTopBar(){
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
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
            R.id.tvOneWay -> {
            checkOne = true
            checkMulti = false
            checkRound = false
            FragSwitch(OneWayFragment())
            changeColor()
        }
            R.id.tvRoundTrip ->{
                checkOne = false
                checkMulti = false
                checkRound = true
                FragSwitch(RoundFragment())
                changeColor()
            }
            R.id.tvMultiStop ->{
                checkOne = false
                checkMulti = true
                checkRound = false
                FragSwitch(MultiStopFragment())
                changeColor()
            }
            else -> {
                checkOne = false
                checkMulti = false
                checkRound = false
                FragSwitch(MultiStopFragment())
            }
        }
    }
    private fun changeColor() {
        if (checkOne) {
            bindingFlightActivity.tvOneWay.setBackgroundColor(resources.getColor(R.color.cream))
            bindingFlightActivity.tvMultiStop.setBackgroundColor(resources.getColor(R.color.white))
            bindingFlightActivity.tvRoundTrip.setBackgroundColor(resources.getColor(R.color.white))
        } else if(checkRound){
            bindingFlightActivity.tvRoundTrip.setBackgroundColor(resources.getColor(R.color.cream))
            bindingFlightActivity.tvMultiStop.setBackgroundColor(resources.getColor(R.color.white))
            bindingFlightActivity.tvOneWay.setBackgroundColor(resources.getColor(R.color.white))

        }
        else if(checkMulti){
            bindingFlightActivity.tvMultiStop.setBackgroundColor(resources.getColor(R.color.cream))
            bindingFlightActivity.tvOneWay.setBackgroundColor(resources.getColor(R.color.white))
            bindingFlightActivity.tvRoundTrip.setBackgroundColor(resources.getColor(R.color.white))
        }
    }
}