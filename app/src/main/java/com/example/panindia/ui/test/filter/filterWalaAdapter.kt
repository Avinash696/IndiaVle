package com.example.panindia.ui.test.filter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.R
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.Result
//
//class filterWalaAdapter(val context : Context,val arrayData :ArrayList<String>) :
//    RecyclerView.Adapter<filterWalaAdapter.CustomViewModel>() ,Filterable{
//     var backup :ArrayList<String> = arrayData
//
//
//    class CustomViewModel(val view:View) : RecyclerView.ViewHolder(view) {
//       val tvLine1: TextView = view.findViewById(R.id.tvFilterWaliTest)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewModel {
//        Log.d("typer", "onCreateViewHolder: $backup")
//        Log.d("beauty", "onCreateViewHolder: ")
//        val view  = LayoutInflater.from(context).inflate(R.layout.custom_filter_wali,parent,false)
//        return CustomViewModel(view)
//    }
//
//    override fun onBindViewHolder(holder: CustomViewModel, position: Int) {
//        Log.d("beauty", "onBindViewHolder: ")
//        val data = backup[position]
//        holder.tvLine1.text = data
//    }
//
//    override fun getItemCount(): Int {
//        Log.d("beauty", "getItemCount: ")
//        return backup.size
//    }
//
//    override fun getFilter(): Filter {
//        return  filtersData
//    }
//    private val filtersData = object :Filter(){
//        override fun performFiltering(keyword: CharSequence?): FilterResults {
//            Log.d("typer", "performFiltering: $backup")
//            var filteredData =ArrayList<String>()
//            if (keyword.toString().isEmpty()) {
//                filteredData.addAll(arrayData)
//            } else {
////                var filterPattern = keyword.toString().toLowerCase().trim()
//                for (item in backup) {
//                    if (item.toLowerCase().trim()
//                            .contains(keyword.toString().toLowerCase().trim())
//                    ) {
//                        filteredData.add(item)
//                    }
//                }
//            }
//            val results = FilterResults()
//            results.values = filteredData
//            return results
//        }
//
//        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
//            //now make realList with filterList
//            backup.clear()
//            Log.d("viewMe", "publishResults: ${filterResults?.values}")
//            backup.addAll(filterResults?.values as ArrayList<String>)
//            notifyDataSetChanged()
//        }
//    }
//}

