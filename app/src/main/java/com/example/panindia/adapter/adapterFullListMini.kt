package com.example.panindia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.panindia.R
import com.example.panindia.model.miniStatementListModel

 class adapterFullListMini(context: Context, miniData: ArrayList<miniStatementListModel>) :
    ArrayAdapter<miniStatementListModel>(context, 0,miniData) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertViewList = convertView
        if(convertView == null){
            convertViewList = LayoutInflater.from(context).inflate(R.layout.adapter_full_mini_statement,parent,false)
        }
        val currentPosition = getItem(position) 
        //findvalue
        val sNo = convertViewList!!.findViewById<TextView>(R.id.tvFullSno)
        val  date= convertViewList!!.findViewById<TextView>(R.id.tvFullDate)
        val cardType = convertViewList!!.findViewById<TextView>(R.id.tvFullCard)
        val remark = convertViewList!!.findViewById<TextView>(R.id.tvFullRemark)
        val amt = convertViewList!!.findViewById<TextView>(R.id.tvFullAmount)

        //setvalue
        sNo.text = currentPosition!!.sNo
        date.text = currentPosition.date
        cardType.text = currentPosition.type
        remark.text = currentPosition.transRemark
        amt.text = currentPosition.amount
        return convertViewList
    }
}