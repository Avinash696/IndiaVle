package com.example.panindia.ui.activity.searchAdapterList


//import com.example.panindia.adapter.searchListAdapter
import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.SearchView
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
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.Result
import com.example.panindia.model.searchFlightModel.oneWay.req.FlightOneWayReqModel
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchListActivity : AppCompatActivity() {
    lateinit var searchField :SearchView
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
        val intent = intent
        Sourcekey = intent.getStringExtra("SourceKey")!!
        DestinationKey = intent.getStringExtra("DestinationKey")!!
        Departkey = intent.getStringExtra("Departkey")!!
//        Returnkey = intent.getStringExtra("Returnkey")!!
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
        val ll = LinearLayout(this)
        ll.gravity  = Gravity.CENTER

        hitAuthenticate()
    }


    private fun init() {
        rv = findViewById(R.id.rvSearchFlight)
        tvResultCount = findViewById(R.id.tvResultCount)
        searchField = findViewById(R.id.searchFlightFilter)
    }

    private fun hitIt(
        tokenNew: String,
        source: String,
        DestinationKey: String,
        Departkey: String,
        Passengerkey: String,
        kidskey: String,
        Weightkey: String,
        Classkey: String,
    ) {
        val d1 = Departkey + "T00: 00: 00 "
//        val d2 = Returnkey + "T00: 00: 00 "

//        val segmentSeach = Segment(DestinationKey, Classkey, source, d2)
        val segmentSeach = com.example.panindia.model.searchFlightModel.oneWay.req.Segment(DestinationKey,1,source,d1)

//        Log.d("twitMe", "hitIt: $Passengerkey $kidskey $Weightkey")
        val postDd = FlightOneWayReqModel(
            Integer.parseInt(Passengerkey),
            Integer.parseInt(kidskey),
            "false",
            "192.168.10.10",
            Integer.parseInt(Weightkey),
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
                    val gs = Gson()

                    Log.d(TAG, "twitter: ${ gs.toJson(result.Response.Results)}")
                    Log.d("twitter", "hitIt:${result.Response.Results[0][0].FareBreakdown.size} ")
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
//            tvResultCount.text = arrayList[0].size.toString()
            val adapterRec = adapterSeachList(tokenData, traceId, arrayList, applicationContext)
//            val count = adapterRec.itemCount
//            Log.d("checkyrCount", "populatingData:$count ")
//            tvResultCount.text = count.toString()
            rv.layoutManager = LinearLayoutManager(this)
            rv.adapter = adapterRec


            searchField.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(s: String): Boolean {
                    adapterRec.filter.filter(s)
                    return false
                }

                override fun onQueryTextChange(s: String): Boolean {
                    adapterRec.filter.filter(s)
                    return false
                }
            })
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
                    Passengerkey,
                    kidskey,
                    Weightkey,
                    Classkey)
            } else {
                Log.d(TAG, "hitApi: ${call.message()}")
//                Toast.makeText(
//                    this@SearchListActivity,
//                    "Please Check UserName & Password",
//                    Toast.LENGTH_SHORT
//                ).show()
            }
        }
    }
}