package com.example.indiavle.ui.activity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.panindia.R
import com.example.panindia.databinding.ActivityBusBinding
import java.text.SimpleDateFormat
import java.util.*

class BusActivity : AppCompatActivity() {
    val destination = arrayOf("Noida", "Lucknow")
    var cal = Calendar.getInstance()
    lateinit var binding: ActivityBusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bus)
        hideTopBar()

        supportActionBar?.title = "Bus"
        //Destination
        var spAdapterDes: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, destination)
        spAdapterDes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        binding.etFromBus.adapter = spAdapterDes
//        binding.etToBus.adapter = spAdapterDes

    }

    fun FnBusCheck(view: View) {}
    fun hideTopBar() {
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    fun FnDateBus(view: View) {
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

    private fun updateDateCheckOut() {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        binding.etDepartdateBus.text = sdf.format(cal.time)
    }
}