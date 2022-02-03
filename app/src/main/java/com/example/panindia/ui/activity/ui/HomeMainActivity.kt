package com.example.panindia.ui.activity.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.ExpandableListView.OnGroupExpandListener
import android.widget.FrameLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.panindia.R
import com.example.panindia.adapter.MyExpandableListAdapter
import com.example.panindia.databinding.ActivityHomeMainBinding
import com.example.panindia.ui.activity.fragment.HomeFragment
import com.example.panindia.ui.activity.fragment.JoiningFragment
import com.example.panindia.ui.activity.fragment.RegisterAdminFragment
import com.google.android.material.appbar.AppBarLayout
import java.util.ArrayList
import java.util.HashMap

class HomeMainActivity : AppCompatActivity() {

    lateinit var groupList: ArrayList<String>
    lateinit var childList: ArrayList<String>
    var mobileCollection: Map<String, List<String>>? = null
    lateinit var expandableListView: ExpandableListView
    var expandableListAdapter: ExpandableListAdapter? = null
    lateinit var navBinding: View
    lateinit var vpHomeMain: ViewPager2
    lateinit var frameLay :FrameLayout
     lateinit var binding:ActivityHomeMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_home_main)

        defaultLayout()
        navBinding =LayoutInflater.from(applicationContext).inflate(R.layout.nav_header, null, false)

        createGroupList()
        createCollection()
        init()
//        setSupportActionBar(binding.appBarHome.toolbar)
        expandableListAdapter = MyExpandableListAdapter(this, groupList, mobileCollection)
        expandableListView.setAdapter(expandableListAdapter)
        expandableListView.setOnGroupExpandListener(object : OnGroupExpandListener {
            var lastExpandedPosition = -1
            override fun onGroupExpand(i: Int) {
                if (lastExpandedPosition != -1 && i != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition)
                }
                lastExpandedPosition = i
            }
        })
        expandableListView.setOnChildClickListener { _, _, i, i1, _ ->
            val selected =
                (expandableListAdapter as MyExpandableListAdapter).getChild(i, i1).toString()
            onClickExpandableListView(selected)
            Toast.makeText(applicationContext, "Selected: $selected", Toast.LENGTH_SHORT).show()
            true
        }
    }

    fun init() {
        expandableListView = findViewById(R.id.expList)
//        vpHomeMain = findViewById(R.id.vpHomeMainHost)
        frameLay = findViewById(R.id.fragHost)
    }
    fun defaultLayout(){
        val frag = supportFragmentManager
        val fragtrans = frag.beginTransaction()
        fragtrans.replace(R.id.fragHost, HomeFragment())
        fragtrans.addToBackStack(null);
        fragtrans.commit();
    }
    private fun onClickExpandableListView(selected: String) {

        when (selected) {
            "Create Admin" -> {
                selectedLayoutShow(RegisterAdminFragment())
    //            startActivity(Intent(this, RegisterActivity::class.java))
            }
            "Create Super Distributer" -> {
//                startActivity(Intent(this, RegisterActivity::class.java))
                selectedLayoutShow(RegisterAdminFragment())
            }
            "Create Distributer" -> {
//                startActivity(Intent(this, RegisterActivity::class.java))
                selectedLayoutShow(RegisterAdminFragment())
            }
            "Create Retailer" -> {
//                startActivity(Intent(this, RegisterActivity::class.java))
                selectedLayoutShow(RegisterAdminFragment())
            }
            "Create Admin Join" -> {
//                startActivity(Intent(this, JoiningListActivity::class.java))
                selectedLayoutShow(JoiningFragment())
            }
            "Home" -> {
//                startActivity(Intent(this, HomeMainActivity::class.java))
                selectedLayoutShow(HomeFragment())
            }
        }
    }

    private fun selectedLayoutShow(layoutData: Fragment) {
        val frag = supportFragmentManager
        val fragtrans = frag.beginTransaction()
        fragtrans.replace(R.id.fragHost, layoutData)
        fragtrans.addToBackStack(null);
        fragtrans.commit();
    }

    private fun createCollection() {
        val homeModel = arrayOf("Home")
        val samsungModels = arrayOf(
            "Create Admin", "Create Super Distributer",
            "Create Distributer", "Create Retailer"
        )
        val googleModels = arrayOf(
            "Create Admin Join", "Create Super Distributer",
            "Create Distributer", "Create Retailer"
        )
        val redmiModels =
            arrayOf("Distributer Valut", "Balance Upload", "WL Limit Distributer", "Payout")
        val vivoModels =
            arrayOf("Full Valut History", "WL Limit History", "IP Search", "Settlement History")
        val nokiaModels = arrayOf(
            "Create Notification Request",
            "Markup Setting",
            "Order ID Verify",
            "Transition Id Verify",
            "Change Website",
            "Change Own password",
            "Activate/Deactivate",
            "User Req"
        )
        val motorolaModels = arrayOf("Motorola One Fusion+", "Motorola E7 Plus", "Motorola G9")
        mobileCollection = HashMap()
        for (group in groupList) {
            if (group == "Create Partner") {
                loadChild(samsungModels)
            } else if (group == "Home") {
                loadChild(homeModel)
            } else if (group == "Joining List") loadChild(googleModels) else if (group == "Accounts") loadChild(
                redmiModels
            ) else if (group == "History") loadChild(vivoModels) else if (group == "Setting") loadChild(
                nokiaModels
            ) else loadChild(motorolaModels)
            (mobileCollection as HashMap<String, List<String>>)[group] = childList!!
        }
    }

    private fun loadChild(mobileModels: Array<String>) {
        childList = ArrayList()
        for (model in mobileModels) {
            childList.add(model)
        }
    }

    private fun createGroupList() {
        groupList = ArrayList<String>()
        groupList.add("Home")
        groupList.add("Create Partner")
        groupList.add("Joining List")
        groupList.add("Accounts")
        groupList.add("History")
        groupList.add("Setting")
    }
}