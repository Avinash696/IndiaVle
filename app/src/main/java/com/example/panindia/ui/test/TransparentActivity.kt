package com.example.panindia.ui.test

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.ListView
import android.widget.TextView
import com.example.panindia.R
import java.text.SimpleDateFormat
import java.util.*

class TransparentActivity : AppCompatActivity() {
    lateinit var listData:ListView
    lateinit var bt :Button
    lateinit var tv :TextView
    var cal = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transparent)
        bt = findViewById(R.id.btDate)
        tv= findViewById(R.id.tvSetDate)


        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }

        bt!!.setOnClickListener {
            DatePickerDialog(
                this@TransparentActivity,
                dateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun updateDateInView() {
//        val myFormat = "MM/dd/yyyy"
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        tv.text = sdf.format(cal.time)
        Log.d("rawat", "updateDateInView: "+sdf.format(cal.time))
    }


}