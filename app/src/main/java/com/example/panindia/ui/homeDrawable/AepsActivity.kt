package com.example.panindia.ui.homeDrawable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.panindia.ChangeCouponPriceFragment
import com.example.panindia.R
import com.example.panindia.databinding.ActivityAepsBinding
import com.example.panindia.databinding.ActivityPanCardBinding
import com.example.panindia.databinding.FragmentHome2Binding
import com.google.android.material.navigation.NavigationView

class AepsActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAepsBinding
    lateinit var fragHost :Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityAepsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        init()
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home
            ), drawerLayout
        )
        //change layout
        layoutApesChange(ChangeCouponPriceFragment())
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    fun init(){
//        fragHost = binding.fragApesHost
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

        }
        return super.onOptionsItemSelected(item)
    }
    fun layoutApesChange(fragData :Fragment){
        val frag = supportFragmentManager
        val ft :FragmentTransaction = frag.beginTransaction()
        ft.replace(R.id.fragApesHost,fragData)
        ft.addToBackStack(null)
        ft.commit()
    }
}