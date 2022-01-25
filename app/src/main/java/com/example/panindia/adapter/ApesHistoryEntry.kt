package com.example.panindia.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.R
import com.example.panindia.adapter.ApesHistoryEntry.*
import com.example.panindia.databinding.AdapterTransHistoryBinding
import com.example.panindia.model.TranHistoryModel

class ApesHistoryEntry(  val apesData :ArrayList<TranHistoryModel>, var context :Context):
    RecyclerView.Adapter<ViewHolder>() {
    private  val TAG = "###"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "onCreateViewHolder: ")
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_trans_history,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: ")
       val data = apesData[position]
//        val textDate = holder.adapterPosition
//        data.transDate
        holder.tvDateTrans.text = data.transDate
        holder.tvBeneficiary.text = data.beneficiaryAcc
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: ")
     return   apesData.size
    }
    class ViewHolder( val view : View):
        RecyclerView.ViewHolder(view) {
        val tvDateTrans :TextView =view.findViewById(R.id.tvDateTrans)
        val tvBeneficiary :TextView =view.findViewById(R.id.tvBeneficiary)
    }
}