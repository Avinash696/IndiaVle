package com.example.panindia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.panindia.R
import com.example.panindia.model.summaryModel

class adapterSummary(context: Context, arrayData :List<summaryModel>):
                    ArrayAdapter<summaryModel>(context,0,arrayData) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var currentItemView = convertView
        if(currentItemView == null){
            currentItemView =
                LayoutInflater.from(context).inflate(R.layout.adapter_summary, parent, false)
        }
        // get the position of the view from the ArrayAdapter
        val currentNumberPosition = getItem(position)


        // then according to the position of the view assign the desired TextView 1 for the same
        val trasDate = currentItemView!!.findViewById<TextView>(R.id.tvTransDateSummary)
        trasDate.text = currentNumberPosition!!.transDate
        val transId = currentItemView.findViewById<TextView>(R.id.tvTransIdSummary)
        transId.text = currentNumberPosition.trasId
        val transAmt = currentItemView.findViewById<TextView>(R.id.tvAmountSummary)
        transAmt.text = currentNumberPosition.amt

        currentItemView.setOnClickListener {
            Toast.makeText(context, "touched$currentNumberPosition", Toast.LENGTH_SHORT).show()
        }
        // then return the recyclable view
        return currentItemView
    }
}