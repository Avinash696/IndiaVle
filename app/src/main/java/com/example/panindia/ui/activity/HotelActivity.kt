package com.example.indiavle.ui.activity

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.panindia.R
import com.example.panindia.databinding.ActivityHotelBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.days

class HotelActivity : AppCompatActivity() ,View.OnClickListener{
    lateinit var binding: ActivityHotelBinding
    val destination = arrayOf("Noida", "Lucknow")
    val personHotel = arrayOf(1, 2, 3, 4, 5)
    lateinit var room:Spinner
    lateinit var night:Spinner
    lateinit var spWeight: Spinner
    lateinit var spPassanger: Spinner
    lateinit var spKids: Spinner
    var cal = Calendar.getInstance()
    lateinit var viewLayout:View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hotel)
        hideTopBar()
        init()
        binding.tvCheckIn.setOnClickListener {
            DatecheckIn()
        }
        binding.tvCheckOut.setOnClickListener {
            DatecheckOut()
        }
        //spinner set
        var spAdapter: ArrayAdapter<Int> =
            ArrayAdapter(this, R.layout.text_center, personHotel)
        spAdapter.setDropDownViewResource(R.layout.text_center)

        //spinner all var set
        binding.spPassangers.adapter = spAdapter
        binding.spKids.adapter = spAdapter
        binding.spWeight.adapter = spAdapter
        binding.spRoom.adapter = spAdapter
        binding.spNight.adapter = spAdapter
        //Destination  -- no use
        var spAdapterDes: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, destination)
        spAdapterDes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        binding.spDestination.adapter = spAdapterDes
    }

    fun init() {
        binding.tvCheckIn.setOnClickListener(this)
    }

    fun FnDestinationhotel(view: View) {
        Toast.makeText(this, "works", Toast.LENGTH_SHORT).show()
    }

    fun hideTopBar() {
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
    private fun updateDateCheckOut() {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        binding.tvCheckOut!!.text = sdf.format(cal.getTime())
    }

    fun DatecheckOut() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateCheckOut()
            }
        DatePickerDialog(
            this, dateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }


    fun updateDateCheckIn() {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        binding.tvCheckIn!!.text = sdf.format(cal.getTime())
    }


    fun DatecheckIn() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateCheckIn()
            }
        DatePickerDialog(
            this, dateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}
