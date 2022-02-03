package com.example.panindia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

import com.example.panindia.R
import com.example.panindia.databinding.ActivityFlightAfterLoginBinding
import com.example.panindia.databinding.ActivityHotelBinding
import com.example.panindia.ui.frag.FlightAfterLogin.AirTicketQFragment
import com.example.panindia.ui.frag.FlightAfterLogin.FlightAfterLoginFragment
import com.example.panindia.ui.frag.FlightAfterLogin.SummaryFragment
import com.example.panindia.ui.frag.FlightAfterLogin.VisaFragment
import com.google.android.material.navigation.NavigationView

class FlightAfterLoginActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener{
    private lateinit var binding: ActivityFlightAfterLoginBinding
    private lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_flight_after_login)

        binding.navFlightAfterLogin.setNavigationItemSelectedListener(this)
        //toggle
        toggle =ActionBarDrawerToggle(this,binding.dlAfterLogin,R.string.open,R.string.close)

    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
       when(item.itemId){
           R.id.menu_summaryFlight -> {
               changeLayout(SummaryFragment())
               binding.dlAfterLogin.close()
           }
           R.id.menu_bookingFlight -> {
               changeLayout(FlightAfterLoginFragment())
               binding.dlAfterLogin.close()
           }
           R.id.menu_airTicketFlight -> {
               changeLayout(AirTicketQFragment())
               binding.dlAfterLogin.close()
           }

           R.id.menu_flightMarkupSetting -> {
               changeLayout(SummaryFragment())
               binding.dlAfterLogin.close()
           }
           R.id.menu_Visa -> {
               changeLayout(VisaFragment())
               binding.dlAfterLogin.close()
           }
       }
        return true
    }
    private fun changeLayout(frag :Fragment){
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.fragHostAfterLogin,frag)
        ft.commit()
    }
}