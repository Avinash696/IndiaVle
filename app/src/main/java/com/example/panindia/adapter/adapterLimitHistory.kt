package com.example.panindia.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.R
import com.example.panindia.model.limitHistoryModel
import com.example.panindia.ui.activity.TransactionFullDetailActivity

class adapterLimitHistory(private val apesData: ArrayList<limitHistoryModel>, var context: Context) :
    RecyclerView.Adapter<adapterLimitHistory.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_limit_apes, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val apesData = apesData[position]
        holder.dateTxt.text = apesData.date
        holder.roleTxt.text = apesData.role
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context,TransactionFullDetailActivity::class.java))
        }
    }

    override fun getItemCount(): Int {
        return apesData.size
    }

    class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val dateTxt: TextView = view.findViewById(R.id.tvDateLimitApes)
        val roleTxt: TextView = view.findViewById(R.id.tvRoleLimitApes)
    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        Log.d(TAG, "onCreateViewHolder: ")
//        val view = LayoutInflater.from(context).inflate(R.layout.adapter_limit_apes,parent,false)
//        return ViewHolder(view)
//    }
//
//
//    override fun getItemCount(): Int {
//        Log.d(TAG, "getItemCount: ")
//        return   apesData.size
//    }
//    class ViewHolder( val view : View):
//        RecyclerView.ViewHolder(view) {
//        val tvDateTrans : TextView =view.findViewById(R.id.tvDateTrans)
//        val tvBeneficiary : TextView =view.findViewById(R.id.tvBeneficiary)
//    }
//
//    override fun onBindViewHolder(holder: limitHistoryModel, position: Int) {
//        Log.d(TAG, "onBindViewHolder: ")
//        val data = apesData[position]
////        val textDate = holder.adapterPosition
////        data.transDate
//        holder.tvDateTrans.text = data.transDate
//        holder.tvBeneficiary.text = data.beneficiaryAcc
//    }
}