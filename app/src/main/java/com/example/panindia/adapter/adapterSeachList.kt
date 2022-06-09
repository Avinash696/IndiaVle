package com.example.panindia.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.R
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.Result
import com.example.panindia.ui.activity.FareRuleActivity
import com.google.gson.Gson
import java.util.*
import kotlin.collections.ArrayList


class adapterSeachList(
    private val tokenValue: String,
    private val traceId: String,
    private val listSeachData: List<List<Result>>,
    private val context: Context?,
) : RecyclerView.Adapter<adapterSeachList.ViewHolder>(), Filterable {

    public var mainList = ArrayList<Result>(listSeachData[0])
    var backList = ArrayList<Result>(listSeachData[0])
    init {
        Log.d("sendList", ":${Gson().toJson(listSeachData[0])} ")
        Log.d("setData", ":${Gson().toJson(mainList)} ")
    }

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val tvTakeOff: TextView = view.findViewById(R.id.tvTakeOff)
        val tvLanding: TextView = view.findViewById(R.id.tvFlightLanding)
        val tvFlightName: TextView = view.findViewById(R.id.tvFlightName)
        val tvTotalTime: TextView = view.findViewById(R.id.tvTotalTime)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("mozo", "onCreateViewHolder: ")
        val view = LayoutInflater.from(context).inflate(R.layout.custom_search_opeway,
            parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val data = backupList[position]
        val data = mainList[position]
        Log.d("viewMe", "onBindViewHolder: $backList")
        val gs = Gson()
        val tt = gs.toJson(mainList)
        Log.d("realList", "onBindViewHolder:$tt")

        holder.tvTotalTime.text = data.Segments[0][0].AccumulatedDuration.toString()
        holder.tvTakeOff.text = data.Segments[0][0].Origin.DepTime
        holder.tvPrice.text = data.Fare.PublishedFare.toString()
        holder.tvLanding.text = data.Segments[0][0].Destination.ArrTime
        holder.tvFlightName.text = data.Segments[0][0].Airline.AirlineName

        holder.itemView.findViewById<Button>(R.id.btnSelectNow).setOnClickListener {

            val intent = Intent(context, FareRuleActivity::class.java)
            intent.putExtra("authToken", tokenValue)
            intent.putExtra("traceId", traceId)
            intent.putExtra("resultIndex", data.ResultIndex)
            Log.d("Sourcekey", "onBindViewHolder: $data.ResultIndex")
            //detail show send
            intent.putExtra("airlineName", data.Segments[0][0].Airline.AirlineName)
            intent.putExtra("flightType", data.Segments[0][0].CabinClass.toString())
            intent.putExtra("flightNumber", data.Segments[0][0].Airline.FlightNumber)
            intent.putExtra("baseFare", data.FareBreakdown[0].BaseFare.toString())
            intent.putExtra("taxesAndFees", data.FareBreakdown[0].Tax.toString())
            intent.putExtra("totalFare", data.Fare.PublishedFare.toString())
            //source and destination
            intent.putExtra("srcInt",data.Segments[0][0].Origin.Airport.AirportName)
            intent.putExtra("desInt",data.Segments[0][0].Destination.Airport.AirportName)
            intent.putExtra("flightType",data.IsLCC)
            intent.putExtra("passangerCount",data.FareBreakdown.size.toString())
//            Log.d("trader", "onBindViewHolder: ${data.FareBreakdown[0].PassengerCount }  ${data.FareBreakdown[1].PassengerCount }" +
//                    "${data.FareBreakdown[2].PassengerCount } ")

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        Log.d("mozo", "getItemCount: ${mainList.size}")

        return mainList.size
    }

    override fun getFilter(): Filter {
        return filtersData
    }

    private val filtersData = object : Filter() {
        //on background thread
        override fun performFiltering(charSequence: CharSequence?): FilterResults {
            var filteredList = ArrayList<Result>()
            if (charSequence.toString().isEmpty()) {
                Log.d("viewMe", "performFiltering: Filter List ${filteredList[0]} ")
                filteredList.addAll(listSeachData[0])
                Log.d("viewMe" ,"performFiltering BAckList: $backList")
            } else {
                var filterPattern = charSequence.toString().lowercase(Locale.getDefault()).trim()
                Log.d("viewMe", "performFiltering: pattern $filterPattern")
                for (item: Result in backList) {
                    if (item.Segments[0][0].Airline.AirlineName.lowercase(Locale.getDefault()).trim()
                            .contains(filterPattern)
                    ) {
                        filteredList.add(item)
                        Log.d("someList", "performFiltering: $filteredList")
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        //run on ui thread
        override fun publishResults(
            charSequence: CharSequence?,
            filterResults: FilterResults?,
        ) {
            //now make realList with filterList
            mainList.clear()
            Log.d("viewMe", "publishResults: $filterResults")
            if (filterResults!!.values != null) {
                mainList.addAll(filterResults.values as ArrayList<Result>)
            }
            else{
                mainList.addAll(listSeachData[0])
            }
            notifyDataSetChanged()
        }
    }
}



