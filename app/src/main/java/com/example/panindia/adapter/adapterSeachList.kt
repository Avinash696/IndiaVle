package com.example.panindia.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.R
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.Result
import com.example.panindia.ui.activity.FareRuleActivity

class adapterSeachList(private val tokenValue:String,
                       private val traceId:String,
    private val listSeachData :List<List<Result>>,
    private val context: Context?) : RecyclerView.Adapter<adapterSeachList.ViewHolder>()  {

    class ViewHolder( view : View):
        RecyclerView.ViewHolder(view) {
        val tvTakeOff: TextView = view.findViewById(R.id.tvTakeOff)
        val tvLanding: TextView = view.findViewById(R.id.tvFlightLanding)
        val tvFlightName:TextView = view.findViewById(R.id.tvFlightName)
        val tvTotalTime: TextView = view.findViewById(R.id.tvTotalTime)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
//        val btnSelect :Button = view.findViewById(R.id.btnSelectNow)
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
        holder.tvTotalTime.text = data.Segments[0][0].AccumulatedDuration.toString()
        holder.tvTakeOff.text = data.Segments[0][0].Origin.DepTime
        holder.tvPrice.text = data.Fare.PublishedFare.toString()
        holder.tvLanding.text =data.Segments[0][0].Destination.ArrTime
        holder.tvFlightName.text =data.Segments[0][0].Airline.AirlineName

        holder.itemView.findViewById<Button>(R.id.btnSelectNow).setOnClickListener {
//            Toast.makeText(context, "ok selected $tokenValue", Toast.LENGTH_SHORT).show()
            val intent = Intent(context,FareRuleActivity::class.java)
            intent.putExtra("authToken",tokenValue)
            intent.putExtra("traceId",traceId)
            intent.putExtra("resultIndex",data.ResultIndex)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        Log.d("mozo", "getItemCount: ${listSeachData.size}")
        return listSeachData[0].size
    }

//    override fun getFilter(): Filter {
//        return  ture;
//    }
}

