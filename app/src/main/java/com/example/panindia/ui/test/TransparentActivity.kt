package com.example.panindia.ui.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.panindia.R

class TransparentActivity : AppCompatActivity() {
    lateinit var listData:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transparent)
    }
    fun populatingData(){

    }
}