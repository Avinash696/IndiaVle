package com.example.panindia.ui.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.panindia.ui.activity.LoginActivity
import com.example.panindia.R
import com.google.android.material.navigation.NavigationView

class Drawablectivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    private val  TAG = "rawat"
    lateinit var navView :NavigationView
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawablectivity)
        init()
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menuLogin -> startActivity(Intent(this, LoginActivity::class.java))
            }
            true
        }
    }
    fun init() {
        drawerLayout = findViewById(R.id.drawer_layout)
        navView= findViewById(R.id.navView)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return  true
        }
        return super.onOptionsItemSelected(item)
    }
}