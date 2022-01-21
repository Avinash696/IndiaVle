package com.example.panindia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.R
import com.example.panindia.adapter.ApesHistoryEntry.*
import com.example.panindia.databinding.AdapterTransHistoryBinding
import com.example.panindia.model.TranHistoryModel

class ApesHistoryEntry(  val apesData :ArrayList<TranHistoryModel>, var context :Context):
    RecyclerView.Adapter<ViewHolder>() {
    class ViewHolder( val view : View):
        RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_trans_history,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val data = apesData[position]
//        val textDate = holder.adapterPosition
//        data.transDate
        holder.view
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}