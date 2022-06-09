package com.example.panindia.adapter

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.R
import com.example.panindia.model.TranHistoryModel
import com.example.panindia.model.passangerCountModel
import com.example.panindia.ui.activity.TransactionFullDetailActivity

class passangerCountTicket( apesData :ArrayList<passangerCountModel>,  context : Context) :
ArrayAdapter<passangerCountModel>(context, 0, apesData) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var layoutView = convertView
        if (layoutView == null) {
            layoutView =
                LayoutInflater.from(context).inflate(R.layout.card_ticket_passanger, parent, false)
        }

        val currentPosition = getItem(position)
        val tvNameCardTicket = layoutView!!.findViewById<TextView>(R.id.tvNameCardTicket)
        val ivEditCardTicket = layoutView!!.findViewById<ImageView>(R.id.ivEditCardTicket)

        //setting data in variable
        tvNameCardTicket.text = currentPosition!!.name
        ivEditCardTicket.setImageResource(R.drawable.edit)
//        ivEditCardTicket.setOnClickListener {
//            //dialog display
//            val dialog = Dialog(context)
//            dialog.setContentView(R.layout.activity_find_id)
//            dialog.show()
//        }

        return layoutView
    }
}