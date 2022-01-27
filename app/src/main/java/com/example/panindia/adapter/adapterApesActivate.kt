package com.example.panindia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.panindia.R
import com.example.panindia.model.apesDetailList

class adapterApesActivate(context: Context,arrayListData: ArrayList<apesDetailList>) :
    ArrayAdapter<apesDetailList>(context,0,arrayListData) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var layoutView = convertView
        if(layoutView == null){
            layoutView = LayoutInflater.from(context).inflate(R.layout.adapter_activate,parent,false)
        }
        val currentPosition = getItem(position)
        val activationCost = layoutView!!.findViewById<TextView>(R.id.tvActivateCost)
        val booked = layoutView.findViewById<TextView>(R.id.tvBooked)
        val activated = layoutView.findViewById<TextView>(R.id.tvActivated)
        val idLeft = layoutView.findViewById<TextView>(R.id.tvLeft)
        //setting data in variable
        activationCost.text = currentPosition!!.activationCost.toString()
        booked.text = currentPosition.booked.toString()
        activated.text = currentPosition.activated.toString()
        idLeft.text = currentPosition.left.toString()
        return layoutView
    }
}