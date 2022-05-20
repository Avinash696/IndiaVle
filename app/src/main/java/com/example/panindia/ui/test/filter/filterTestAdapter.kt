//package com.example.panindia.ui.test.filter
//
//import android.R
//
//import android.view.LayoutInflater
//import android.view.View
//
//import android.view.ViewGroup
//
//import android.widget.TextView
//
//import androidx.recyclerview.widget.RecyclerView
//
//
//class DisplayAdapter(displayedList: List<DataHolder>) :
//    RecyclerView.Adapter<DisplayAdapter.MyViewHolder>() {
//    private val displayedList: List<DataHolder>
//
//    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        var english_d: TextView
//
//        init {
//            english_d = view.findViewById(R.id.engword)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyViewHolder {
//        // create a layout
//        val itemView: View =
//            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
//        return MyViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val content: DataHolder = displayedList[position]
//        holder.english_d.setText(content.getEnglish())
//    }
//
//    override fun getItemCount(): Int {
//        return displayedList.size
//    }
//
//    init {
//        this.displayedList = displayedList
//    }
//}