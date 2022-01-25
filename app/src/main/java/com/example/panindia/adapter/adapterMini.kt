package com.example.panindia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.panindia.R
import com.example.panindia.model.ApesMiniStatementModel

class adapterMini( context: Context , arrayList: ArrayList<ApesMiniStatementModel>) :
    ArrayAdapter<ApesMiniStatementModel>(context,0,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var converItemView = convertView
        //if view is null  lets create
        if(converItemView ==  null){
            converItemView = LayoutInflater.from(context).inflate(R.layout.adapter_mini_statement,parent,false)
        }
        // current position
        val currentPosition =getItem(position)
        //find value
        val tvName = converItemView!!.findViewById<TextView>(R.id.tvMiniName)
        val tvValue = converItemView.findViewById<TextView>(R.id.tvMiniValue)
        val tvDate = converItemView.findViewById<TextView>(R.id.tvMiniDate)
        //set data
        tvName.text = currentPosition!!.name
        tvValue.text = currentPosition.nameValue
        tvDate.text = currentPosition.date
        return converItemView
    }
}