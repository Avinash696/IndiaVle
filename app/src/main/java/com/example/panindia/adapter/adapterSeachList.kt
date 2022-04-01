package com.example.panindia.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.R
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.Result

class adapterSeachList(
    private val listSeachData :List<Result>,
    val context: Context?) : RecyclerView.Adapter<adapterSeachList.ViewHolder>() {

    class ViewHolder( val view : View):
        RecyclerView.ViewHolder(view) {
        val takeOff : TextView =view.findViewById(R.id.tvSearchTakeOff)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("mozo", "onCreateViewHolder: ")
        val view = LayoutInflater.from(context).inflate(R.layout.custom_search_opeway,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("mozo", "onBindViewHolder: ")
        val data =  listSeachData[position]
        holder.takeOff.text = data.Segments[0][position].Origin.DepTime
        //time holder set
    }

    override fun getItemCount(): Int {
        Log.d("mozo", "getItemCount: ")
        return listSeachData.size
    }
}

