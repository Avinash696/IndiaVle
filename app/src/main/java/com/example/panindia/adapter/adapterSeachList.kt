package com.example.panindia.adapter

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.R
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.Result
import com.example.panindia.ui.activity.FareRuleActivity

class adapterSeachList(
    private val tokenValue: String,
    private val traceId: String,
    private val listSeachData: List<List<Result>>,
    private val context: Context?,
) : RecyclerView.Adapter<adapterSeachList.ViewHolder>(), Filterable {
    var ListFiltered: List<List<Result>> = ArrayList()
    var airlineFilterList :List<String> =ArrayList()

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
        Log.d("mozo", "onBindViewHolder:")
        val data = listSeachData[0][position]
        Log.d("dataTest", "onBindViewHolder:${data} ")
//        val factory = LayoutInflater.from(context)
//        val dialogView: View = factory.inflate(R.layout.dialog_search_fight_detail, null)
//        val deleteDialog: AlertDialog = AlertDialog.Builder(context!!).create()
//
//        deleteDialog.setView(dialogView)


        holder.tvTotalTime.text = data.Segments[0][0].AccumulatedDuration.toString()
        holder.tvTakeOff.text = data.Segments[0][0].Origin.DepTime
        holder.tvPrice.text = data.Fare.PublishedFare.toString()
        holder.tvLanding.text = data.Segments[0][0].Destination.ArrTime
        holder.tvFlightName.text = data.Segments[0][0].Airline.AirlineName

        //set all airline list
        for (dd in data.Segments[0][0].Airline.AirlineName){
//            airlineFilterList[0][0] = dd
        }

        //custom dialog var link
//        dialogView.findViewById<TextView>(R.id.tvAirline).text = data.Segments[0][0].Airline.AirlineName
//        dialogView.findViewById<TextView>(R.id.tvFlightType).text = data.Segments[0][0].CabinClass.toString()
//        dialogView.findViewById<TextView>(R.id.tvFlightNumber).text = data.Segments[0][0].Airline.FlightNumber
////            dialogView.findViewById<TextView>(R.id.tvSeatAndBaggage).text = data.Segments[0][1].CabinBaggage+"/"+data.Segments[0][1].Baggage
//        dialogView.findViewById<TextView>(R.id.tvBaseFare).text = data.FareBreakdown[0].BaseFare.toString()
//        dialogView.findViewById<TextView>(R.id.tvTaxesAndFees).text = data.FareBreakdown[0].Tax.toString()
//        dialogView.findViewById<TextView>(R.id.tvpu).text = data.Fare.PublishedFare.toString()

        holder.itemView.findViewById<Button>(R.id.btnSelectNow).setOnClickListener {
//            Toast.makeText(context, "ok selected $tokenValue", Toast.LENGTH_SHORT).show()
//            val dialog = Dialog(context!!)

//            deleteDialog.show()

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

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        Log.d("mozo", "getItemCount: ${listSeachData.size}")
        return listSeachData[0].size
    }

    override fun getFilter(): Filter {
        return filter
    }

//    private val filtersData = object : Filter() {
//        //on background thread
//        override fun performFiltering(charSequence: CharSequence?): FilterResults {
//            var filteredList: List<List<Result>> = ArrayList()
//            filteredList = listSeachData
//            if (charSequence.toString().isEmpty()) {
//                filteredList = mutableListOf(ListFiltered) as List<List<Result>>
//            } else {
//                for (flightIt in filteredList) {
////                    listSeachData[0][position]
////                    data.Segments[0][0].Airline.AirlineName
////                    if(listSeachData[0])
//                }
//            }
//
//        }
//
//        //run on ui thread
//        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
//            TODO("Not yet implemented")
//        }
//
//    }
}


