package com.example.panindia.ui.test.excel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.panindia.R
import java.io.BufferedReader
import java.io.InputStreamReader

class ExcelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excel)

        readDataExcel()
    }





    private fun readDataExcel() {
        val inputStream = resources.openRawResource(R.raw.excel_source)
        val reader = BufferedReader(InputStreamReader(inputStream))
        reader.lineSequence().forEach {
            val token = it.split(",")
            Log.d("newLoop", "readDataExcel: ${token[0]}  ${token[1]}")
//            arrayExcelLoc.add(token[1]+","+token[0])
        }
    }
}