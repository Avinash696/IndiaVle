package com.example.panindia

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

import androidx.databinding.DataBindingUtil
import com.example.indiavle.ui.activity.*
import com.example.panindia.databinding.ActivityMainBinding
import com.example.panindia.ui.activity.*

class MainActivity : AppCompatActivity() ,View.OnClickListener{
    lateinit var dialog: Dialog
    lateinit var tvHome :TextView
    lateinit var binding :ActivityMainBinding
    lateinit var tb:Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main);

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
       window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //init
        binding.rvHome.setOnClickListener(this)
        binding.rvPsaLogin.setOnClickListener(this)
        binding.rvCropingLogin.setOnClickListener(this)
        binding.rvCouponAdmin.setOnClickListener(this)
        binding.rvCouponRetailer.setOnClickListener(this)


//        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("3F51B5")))
//        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.gob_blue)))
        supportActionBar?.hide()
        actionBar?.hide()
        binding.tb.inflateMenu(R.menu.entry_menu)


//        binding.tb.setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener {
//            when(it.itemId){
//                R.id.menuLogin -> startActivity(Intent(this, LoginActivity::class.java))
//            }
//            return @OnMenuItemClickListener
//        })
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuLogin -> startActivity(Intent(this, LoginActivity::class.java))
            R.id.menuRegister -> registerDialog()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.entry_menu, menu)
        return true
    }

    fun registerDialog() {
        dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_register)
        dialog.show()
        dialog.findViewById<TextView>(R.id.dialogAdmin).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        dialog.findViewById<TextView>(R.id.dialogSuperDistrubuter).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        dialog.findViewById<TextView>(R.id.dialogDistrubuter).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        dialog.findViewById<TextView>(R.id.dialogRetailer).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    fun FnFlight(view: View) {
        startActivity(Intent(this, FlightActivity::class.java))
    }

    fun FnBus(view: View) {
        startActivity(Intent(this, BusActivity::class.java))
    }

    fun FnHotel(view: View) {
        startActivity(Intent(this, HotelActivity::class.java))
    }

    fun toRegister(view: View) {

    }

    fun FnFindId(view: View) {
        startActivity(Intent(this,FindIdActivity::class.java))
    }
//not working
    override fun onClick(p0: View?) {
        when(p0?.id){
//            R.id.rvHome -> Toast.makeText(applicationContext, "Home", Toast.LENGTH_SHORT).show()
            R.id.rvFindId -> startActivity(Intent(this,FindIdActivity::class.java))
            R.id.rvPsaLogin -> startActivity(Intent(this,PsaLoginActivity::class.java))
            R.id.rvCropingLogin -> startActivity(Intent(this,CropingToolsActivity::class.java))
            R.id.rvCouponRetailer -> startActivity(Intent(this,RetailerCoupanActivity::class.java))
            R.id.rvCouponAdmin -> startActivity(Intent(this,AdminCoupanActivity::class.java))
        }
    }

    fun fnHome(view: View) {
        Toast.makeText(applicationContext, "U R @ Home", Toast.LENGTH_SHORT).show()
    }
}