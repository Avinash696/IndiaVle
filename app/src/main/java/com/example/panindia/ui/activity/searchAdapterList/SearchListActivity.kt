package com.example.panindia.ui.activity.searchAdapterList


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.adapter.adapterApesHistoryEntry
import com.example.panindia.adapter.adapterSeachList
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.Result
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.ResponceFlightSeachModel
import com.example.panindia.model.searchFlightModel.sendModel.FlightSearchSendModel
import com.example.panindia.model.searchFlightModel.sendModel.Segment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class SearchListActivity : AppCompatActivity() {
    lateinit var rv :RecyclerView
    private val TAG = "mozo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.panindia.R.layout.activity_search_list)

        init()
        seachFlight()
    }

    private fun seachFlight() {
        Log.d("mozo", "seachFlight: ")
        val segmentSeach = Segment(
            "BOM", "1", "DEL",
            "2022-12-07T00: 00: 00", "2022-12-06T00: 00: 00"
        )
        val postDd = FlightSearchSendModel(
            "1",
            "0",
            "false",
            "192.168.10.10",
            "0",
            "1",
            "false",
            null,
            listOf(segmentSeach),
            "6a8e8f1e-3492-42fd-9c2a-e4bab16dce18"
        )
        val retro = RetrofitHelper.getRetroInstance().create(ApiService::class.java)
        GlobalScope.launch {
            val call = retro.seachFlight(postDd)
            val result = call.body()
//            val result = call[0].body()
            if (result != null) {
                Log.d(TAG, "success response: ")
                populateSearchList(result.Response.Results[0])
            } else {
                Log.d(TAG, "no Error $call")
            }
        }
    }
    private fun populateSearchList( listSearchData :List<Result>){
        Log.d(TAG, "populateSearchList:  Clicked ")
        Log.d(TAG, "got response  ${listSearchData[0]}")      //listSearchData
        val adapterData = adapterSeachList(listSearchData,this)
        rv.layoutManager = LinearLayoutManager(applicationContext)
        rv.adapter = adapterData
        Log.d(TAG, "setAdapter ")
    }
    private fun init(){
        Log.d(TAG, "init:")
        rv = findViewById(com.example.panindia.R.id.rvSearchFlight)
    }
}