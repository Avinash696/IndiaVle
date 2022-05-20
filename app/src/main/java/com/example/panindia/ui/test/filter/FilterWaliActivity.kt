package com.example.panindia.ui.test.filter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.R
import com.example.panindia.adapter.AdminHomeAdpter
import com.example.panindia.adapter.joiningAdapter
import com.example.panindia.databinding.ActivityFilterWaliBinding
import com.example.panindia.model.joiningModel

class FilterWaliActivity : AppCompatActivity() {
    private lateinit var binding :ActivityFilterWaliBinding
//    private lateinit var adminHome:filterWalaAdapter
    private lateinit var adpDante:DisplayFilterWaliAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterWaliBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("beauty", "onCreate: ")


        binding.svFilter.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String?): Boolean {
//                adminHome.filter.filter(s)
                return false
            }

            override fun onQueryTextChange(s: String?): Boolean {
                adpDante.filter.filter(s)
                return false
            }

        })
        populatingData()

    }
    private fun getHit(){

    }
    private fun populatingData(){

        var arrayList = ArrayList<filterModel>()
        arrayList.add(filterModel("hi"))
        arrayList.add(filterModel("titan"))
        arrayList.add(filterModel("hero"))
        arrayList.add(filterModel("hitlar"))
        arrayList.add(filterModel("Dibya"))

        //set adapter
        adpDante = DisplayFilterWaliAdapter(arrayList,this)
        binding.rvTestFrag.layoutManager = LinearLayoutManager(this)
        binding.rvTestFrag?.adapter = adpDante

        Log.d("beauty", "populatingData: ")
    }
}