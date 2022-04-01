package com.example.panindia.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.R
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.Result

class adapterSeachList(
    private val listSeachData :List<List<Result>>,
//    private val listSeachData :List<testSingle>,
    private val context: Context?) : RecyclerView.Adapter<adapterSeachList.ViewHolder>()  {

    class ViewHolder( view : View):
        RecyclerView.ViewHolder(view) {
        val tvSearchTakeOff: TextView = view.findViewById(R.id.tvSearchTakeOff)
        val tvOneWayFlight: TextView = view.findViewById(R.id.tvOneWayFlight)
        val tvTotalTime: TextView = view.findViewById(R.id.tvTotalTime)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("mozo", "onCreateViewHolder: ")
        val view = LayoutInflater.from(context).inflate(R.layout.custom_search_opeway,
            parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("mozo", "onBindViewHolder:")
        val data =  listSeachData[0][position]
        Log.d("dataTest", "onBindViewHolder:${data} ")
//            val data =  listSeachData[position]
//        Log.d("mozo", "data check:${data} ")
////        holder.takeOff.text = data[position].ResultIndex
//
        holder.tvTotalTime.text = data.AirlineCode
        holder.tvOneWayFlight.text = data.Segments[0][0].Origin.DepTime
        holder.tvPrice.text = data.ValidatingAirline
        holder.tvSearchTakeOff.text =data.AirlineRemark
        holder.tvTotalTime.text =data.AirlineCode
    }

    override fun getItemCount(): Int {
        Log.d("mozo", "getItemCount: ${listSeachData.size}")
        return listSeachData[0].size
    }

//    override fun getFilter(): Filter {
//        return  ture;
//    }
}

