package com.example.panindia.ui.activity.searchAdapterList


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.R
import com.example.panindia.adapter.adapterApesHistoryEntry
import com.example.panindia.adapter.adapterSeachList
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.Result
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.ResponceFlightSeachModel
import com.example.panindia.model.searchFlightModel.sendModel.FlightSearchSendModel
import com.example.panindia.model.searchFlightModel.sendModel.Segment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SearchListActivity : AppCompatActivity() {
    lateinit var rv: RecyclerView
    private val TAG = "mozo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list)

        init()
        hitIt()
    }


    private fun init() {
        Log.d(TAG, "init:")
        rv = findViewById(R.id.rvSearchFlight)
    }

    private fun hitIt() {

        val segmentSeach = Segment("BOM", "1", "DEL",
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
            "6a8e8f1e-3492-42fd-9c2a-e4bab16dce18")
        val tt = RetrofitHelper.getRetroInstance().create(ApiService::class.java)

        GlobalScope.launch {
            val call = tt.searchFn(postDd)
            withContext(Dispatchers.Default) {

                val result = call.body()

                if (result != null) {

                    populatingData(result.Response.Results)

                } else {
                    Log.d(TAG, "hitIt: $call")
                }
            }

        }
    }

    private fun populatingData(arrayList: List<List<Result>>) {
//        Log.d(TAG, "populatingData: ${arrayList[0].size}")
        runOnUiThread(Runnable {
            val adapterRec = adapterSeachList(arrayList, applicationContext)
            rv.layoutManager = LinearLayoutManager(this)
            rv.adapter = adapterRec
        })
    }
}