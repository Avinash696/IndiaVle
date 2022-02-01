package com.example.panindia.ui.homeDrawable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil

import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.panindia.R
import com.example.panindia.databinding.ActivityMoneyTransferBinding
import com.example.panindia.ui.frag.AepsDistributeFragment
import com.example.panindia.ui.frag.MoneyTransferFragment
import com.google.android.material.navigation.NavigationView

class MoneyTransferActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var vp: FrameLayout
    private lateinit var tb: Toolbar
    private lateinit var drawer: DrawerLayout
    lateinit var navView: NavigationView
    private lateinit var binding: ActivityMoneyTransferBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_money_transfer)
        init()

        setSupportActionBar(tb)

        toggle = ActionBarDrawerToggle(this, drawer, tb, R.string.open, R.string.close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    fun init() {
        vp = binding.vpMoneyTransf
        tb = binding.toolbar
        drawer = binding.drawerLayout
        navView = binding.navView
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_mt -> {
                fragmentLayout(MoneyTransferFragment())
                drawer.close()
            }
            R.id.action_dmt -> {
                fragmentLayout(AepsDistributeFragment())
                drawer.close()
            }
        }
        return true
    }

    private fun fragmentLayout(frag: Fragment) {
        val fragManager = supportFragmentManager
        val ft = fragManager.beginTransaction()
        ft.replace(R.id.vpMoneyTransf, frag)
        ft.commit()
    }
}