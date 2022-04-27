package com.example.panindia.ui.activity.searchAdapterList


import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View.VISIBLE
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.R
import com.example.panindia.adapter.adapterSeachList
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.model.authenticateModel.sendModel.SendModel
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.ResponceFlightSeachModel
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.Result
import com.example.panindia.model.searchFlightModel.sendModel.FlightSearchSendModel
import com.example.panindia.model.searchFlightModel.sendModel.Segment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SearchListActivity : AppCompatActivity() {
    lateinit var rv: RecyclerView
    private val TAG = "mozo"
    private lateinit var tvResultCount: TextView
    lateinit var tokenData: String

    //all tokens
    lateinit var Sourcekey: String
    lateinit var DestinationKey: String
    lateinit var Departkey: String
    lateinit var Returnkey: String
    lateinit var Passengerkey: String
    lateinit var kidskey: String
    lateinit var Weightkey: String
    lateinit var Classkey: String

    //    lateinit var  responceData :ResponceFlightSeachModel
    //progress
    lateinit var pDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list)

        init()
        var intent = intent
        Sourcekey = intent.getStringExtra("SourceKey")!!
        DestinationKey = intent.getStringExtra("DestinationKey")!!
        Departkey = intent.getStringExtra("Departkey")!!
        Returnkey = intent.getStringExtra("Returnkey")!!
        Passengerkey = intent.getStringExtra("Passengerkey")!!
        kidskey = intent.getStringExtra("kidskey")!!
        Weightkey = intent.getStringExtra("Weightkey")!!
        Classkey = intent.getStringExtra("Classkey")!!

        //action bar
        supportActionBar?.title = "$Sourcekey-->$DestinationKey"

//        hitIt(Sourcekey!!,DestinationKey!!,Departkey!!,Returnkey!!,Passengerkey!!,kidskey!!,Weightkey!!,Classkey!!)
        pDialog = ProgressDialog(this)
        pDialog.setCancelable(false)
        pDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small)
        pDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        pDialog.show()

        hitAuthenticate()
    }


    private fun init() {
        rv = findViewById(R.id.rvSearchFlight)
        tvResultCount = findViewById(R.id.tvResultCount)
    }

    private fun hitIt(
        tokenNew: String,
        source: String,
        DestinationKey: String,
        Departkey: String,
        Returnkey: String,
        Passengerkey: String,
        kidskey: String,
        Weightkey: String,
        Classkey: String,
    ) {
        val d1 = Departkey + "T00: 00: 00 "
        val d2 = Returnkey + "T00: 00: 00 "

        Log.d("dName", "date we want 2022-12-07T00: 00: 00    2022-12-06T00: 00: 00")
//        val segmentSeach = Segment(DestinationKey, Classkey, source, d2, d1)
        val segmentSeach = Segment(DestinationKey, Classkey, source, d2, d1)
        Log.d("dName", " date we got $d1 $d2")
        val postDd = FlightSearchSendModel(
            Passengerkey,
            kidskey,
            "false",
            "192.168.10.10",
            Weightkey,
            "1",
            "false",
            null,
            listOf(segmentSeach),
            tokenNew)
        val tt = RetrofitHelper.getRetroInstance().create(ApiService::class.java)

        GlobalScope.launch {
            val call = tt.searchFn(postDd)
            withContext(Dispatchers.Default) {

                val result = call.body()

                if (result != null) {
                    Log.d(TAG, "hitIt: ${result.Response.Results}")
                    pDialog.dismiss()
                    populatingData(tokenNew, result.Response.TraceId, result.Response.Results)

                } else {
                    Log.d(TAG, "hitIt: $call")
                    Toast.makeText(applicationContext, "No Result Found", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun populatingData(tokenData: String, traceId: String, arrayList: List<List<Result>>) {
        Log.d(TAG, "populatingData: ")
        runOnUiThread(Runnable {
            tvResultCount.text = arrayList[0].size.toString()
            val adapterRec = adapterSeachList(tokenData, traceId, arrayList, applicationContext)
            rv.layoutManager = LinearLayoutManager(this)
            rv.adapter = adapterRec
        })
    }

    private fun hitAuthenticate() {
        val postDd = SendModel(
            "ApiIntegrationNew", "192.168.11.120", "bpind@122", "bpind"
        )
        val api = RetrofitHelper.getRetroInstance().create(ApiService::class.java)
        GlobalScope.launch {
            val call = api.getAuth(postDd)
            val result = call!!.body()

            if (result != null) {
                tokenData = result.TokenId
                hitIt(tokenData,
                    Sourcekey,
                    DestinationKey,
                    Departkey,
                    Returnkey,
                    Passengerkey,
                    kidskey,
                    Weightkey,
                    Classkey)
            } else {
                Log.d(TAG, "hitApi: ${call.message()}")
                Toast.makeText(
                    this@SearchListActivity,
                    "Please Check UserName & Password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}