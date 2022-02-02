package com.example.panindia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.example.panindia.R
import com.example.panindia.model.airTicketQModel

    class adapterAirTicketQ(context: Context, arrayData: ArrayList<airTicketQModel>) :
    ArrayAdapter<airTicketQModel>(context, 0, arrayData) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var layoutView = convertView
        if (layoutView == null) {
            layoutView =
                LayoutInflater.from(context).inflate(R.layout.adapter_air_ticket_q, parent, false)
        }

        val currentPosition = getItem(position)
        val pnr = layoutView!!.findViewById<TextView>(R.id.tvPnr)
        val sec = layoutView.findViewById<TextView>(R.id.tvSector)
        val bookingDate = layoutView.findViewById<TextView>(R.id.tvBookingDate)
        val ticketDate = layoutView.findViewById<TextView>(R.id.tvTicketDate)
        val travelDate = layoutView.findViewById<TextView>(R.id.tvTravelDate)
        val customerPrice = layoutView.findViewById<Button>(R.id.btCustomerPrice)
        val currency = layoutView.findViewById<TextView>(R.id.tvCurrency)
        val payMode = layoutView.findViewById<TextView>(R.id.tvPaymode)
        val ticketNo = layoutView.findViewById<TextView>(R.id.tvTicketNo)
        val payName = layoutView.findViewById<TextView>(R.id.tvPayName)
        val viewTicket = layoutView.findViewById<TextView>(R.id.tvViewTicket)

        //setting data in variable
        pnr.text = currentPosition!!.pnr
        sec.text = currentPosition!!.sector
        bookingDate.text = currentPosition!!.bookingDate
        ticketDate.text = currentPosition!!.tktDate.toString()
        travelDate.text = currentPosition!!.travelDate.toString()
        customerPrice.text = currentPosition!!.customerPrice.toString()
        currency.text = currentPosition!!.currency.toString()
        payMode.text = currentPosition!!.payMode.toString()
        ticketNo.text = currentPosition!!.ticketNo.toString()
        payName.text = currentPosition!!.payName.toString()
        viewTicket.text = currentPosition!!.viewTicket.toString()

        return layoutView
    }
}