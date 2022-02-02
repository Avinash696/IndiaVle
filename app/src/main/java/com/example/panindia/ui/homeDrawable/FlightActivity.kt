package com.example.panindia.ui.homeDrawable

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.panindia.R
import com.example.panindia.databinding.ActivityFlight2Binding
import com.example.panindia.ui.frag.FlightAfterLogin.AirTicketQFragment
import com.example.panindia.ui.frag.FlightAfterLogin.FlightAfterLoginFragment
import com.example.panindia.ui.frag.FlightAfterLogin.SummaryFragment
import com.google.android.material.navigation.NavigationView

class FlightActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener{

    private lateinit var binding: ActivityFlight2Binding
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlight2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.navView.setNavigationItemSelectedListener(this)
        //setting toggle
        supportActionBar?.setHomeButtonEnabled(true)
        toggle = ActionBarDrawerToggle(this,binding.drawerLayout,R.string.open,R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
         when(item.itemId){
           R.id.menu_bookingFlight -> {layoutChange(FlightAfterLoginFragment())
           binding.drawerLayout.close()}

           R.id.menu_summaryFlight -> {layoutChange(SummaryFragment())
               binding.drawerLayout.close()}
           R.id.menu_airTicketFlight -> {layoutChange(AirTicketQFragment())
               binding.drawerLayout.closeDrawer(GravityCompat.START)}
           else -> layoutChange(FlightAfterLoginFragment())
       }
       return true
    }
    private fun layoutChange(frg : Fragment){
        val fragManager = supportFragmentManager
        val ft = fragManager.beginTransaction()
        ft.replace(R.id.fragHostFlight,frg)
        ft.commit()
    }

}