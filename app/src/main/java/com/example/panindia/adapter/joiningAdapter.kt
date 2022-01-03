package com.example.panindia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.panindia.R
import com.example.panindia.model.joiningModel

 class joiningAdapter(context: Context, arrayList: ArrayList<joiningModel>) :
    ArrayAdapter<joiningModel?>(context, 0, arrayList as List<joiningModel?>) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

            // convertView which is recyclable view
            var currentItemView = convertView

            // of the recyclable view is null then inflate the custom layout for the same
            if (currentItemView == null) {
                currentItemView =
                    LayoutInflater.from(context).inflate(R.layout.joining_row_adapter, parent, false)
            }

            // get the position of the view from the ArrayAdapter
            val currentNumberPosition = getItem(position)

            // then according to the position of the view assign the desired image for the same
            val numbersImage = currentItemView!!.findViewById<TextView>(R.id.tvSerno)
            assert(currentNumberPosition != null)
            numbersImage.text = currentNumberPosition!!.joinSerNo.toString()

            // then according to the position of the view assign the desired TextView 1 for the same
            val textData = currentItemView.findViewById<TextView>(R.id.tvJoiningName)
            textData.text = currentNumberPosition.joinName


            // then return the recyclable view
            return currentItemView
        }
    }
