package com.example.panindia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.panindia.R
import com.example.panindia.model.distributeAepsModel

class adapterDistribute(context: Context, miniData: ArrayList<distributeAepsModel>) :
ArrayAdapter<distributeAepsModel>(context, 0,miniData) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertViewList = convertView
        if(convertView == null){
            convertViewList = LayoutInflater.from(context).inflate(R.layout.adapter_distribute_aeps,parent,false)
        }
        val currentPosition = getItem(position)
        //findvalue
        val userId = convertViewList!!.findViewById<TextView>(R.id.tvUserId)
        val  userName= convertViewList!!.findViewById<TextView>(R.id.tvUserName)
        val quantity = convertViewList!!.findViewById<TextView>(R.id.tvQuality)


        //setvalue
        userId.text = currentPosition!!.userId
        userName.text = currentPosition.userName
        quantity.text = currentPosition.quantity

        return convertViewList
    }
}