package com.example.panindia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import com.example.panindia.R
import com.example.panindia.adapter.AdminHomeAdpter
import com.example.panindia.adapter.joiningAdapter
import com.example.panindia.databinding.ActivityJoiningListBinding
import com.example.panindia.model.adminModel
import com.example.panindia.model.joiningModel

class JoiningListActivity : AppCompatActivity() {
    lateinit var _binding :ActivityJoiningListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       _binding=DataBindingUtil.setContentView(this,R.layout.activity_joining_list)
        populatingData()
    }
    fun populatingData(){
        var arrayList = ArrayList<joiningModel>()
//        arrayList.add(adminModel("Create Admin", R.drawable.admin_icon))
//        arrayList.add(adminModel("Create Super Distributer", R.drawable.admin_icon))
//        arrayList.add(adminModel("Create Distributer", R.drawable.admin_icon))
//        arrayList.add(adminModel("Create Retailer", R.drawable.admin_icon))
        arrayList.add(joiningModel("Dibya",1))
        arrayList.add(joiningModel("Dibya",2))
        arrayList.add(joiningModel("Dibya",3))
        arrayList.add(joiningModel("Dibya",4))
        //set adapter
        val adminHome = joiningAdapter(this,arrayList)
        _binding?.lvJoining?.adapter =adminHome
    }
}