package com.example.panindia.ui.homeDrawable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
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
import com.example.panindia.ui.frag.*
import com.google.android.material.navigation.NavigationView

class AepsActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener{
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAepsBinding
    lateinit var fragApesHost: FrameLayout
//    lateinit var listData :ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAepsBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setSupportActionBar(binding.toolbar)
//        val drawerLayout: DrawerLayout = binding.drawerLayout
//        val navView: NavigationView = binding.navView
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
        init()

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.nav_home
//            ), drawerLayout
//        )
//        //change layout
//        layoutApesChange(ChangeCouponPriceFragment())
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
//        populatingData()
//        listData.setOnItemClickListener { adapterView, view, i, l ->
//            Toast.makeText(this, ""+i, Toast.LENGTH_SHORT).show()
//        }
        binding.navView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_apes ->layoutApesChange(ApesFragment())
                R.id.menu_transition ->layoutApesChange(TransitionHistoryFragment())
                R.id.menu_mini_statement ->layoutApesChange(ApesMiniSatementFragment())
                R.id.menu_apes_distribution ->layoutApesChange(AepsDistributeFragment())
                else -> layoutApesChange(ApesFragment())
            }
            return@OnNavigationItemSelectedListener true
        })
    }
    fun init() {
        fragApesHost = findViewById(R.id.fragApesHost)
    }

    fun layoutCheck( frag :Fragment){
        val fragManager = supportFragmentManager
        val ft = fragManager.beginTransaction()
        ft.replace(R.id.fragApesHost,frag)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    private fun layoutApesChange(fragData: Fragment) {
        val frag = supportFragmentManager
        val ft: FragmentTransaction = frag.beginTransaction()
        ft.replace(R.id.fragApesHost, fragData)
        ft.addToBackStack(null)
        ft.commit()
    }

    //right on item click
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.aeps_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
////        when (item?.itemId) {
////            R.id.menu_transition -> Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
////            R.id.menu_mini_statement -> Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
////        }
//        if(item.itemId == R.id.menu_transition){
//            Toast.makeText(applicationContext, "ok", Toast.LENGTH_SHORT).show()
//        }
//        return true
//    }

    private fun populatingData(){
        val arrayData = arrayOf("h","jj")
        val arrayAdapter =ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arrayData)
//        listData.adapter = arrayAdapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
       when(item.itemId){
           R.id.menu_transition -> Toast.makeText(applicationContext, "koko", Toast.LENGTH_SHORT).show()
       }
        return true
    }
}