package com.example.panindia.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.panindia.Interface.NavigationManager
import com.example.panindia.R
import com.example.panindia.databinding.ActivityPanCardAdminBinding
import com.google.android.material.navigation.NavigationView


class PanCardAdminActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityPanCardAdminBinding
    lateinit var mDrawerLayout: DrawerLayout
    lateinit var mActivityTitle: PanCardAdminActivity
    lateinit var items: String
//    lateinit var expandableListView: ExpandableListView
    lateinit var listGroup: List<String>
    lateinit var listItem: Map<String, List<String>>
    lateinit var navigationManager: NavigationManager
    //
    var groupList: MutableList<String?>? = null
    var childList: List<String>? = null
    var mobileCollection: Map<String, List<String>>? = null
    var expandableListView: ExpandableListView? = null
    var expandableListAdapter: ExpandableListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPanCardAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
//        setSupportActionBar(binding.appBarPanCardAdmin.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
//        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_pan_card_admin)

//
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)

    }
//
    fun init() {
        mDrawerLayout = binding.drawerLayout
//        mActivityTitle = getText().toString()
            expandableListView = binding.elvMobiles
//        navigationManager = FragmentNavigationManger.getmInstance(this)
        listGroup =ArrayList()
        listItem =HashMap()
        initListData()
    }
    fun initListData(){
        listGroup= listOf(arrayListOf(R.string.GroupAdmin).toString())
        var array =ArrayList<String>()
        val list =ArrayList<String>()
        array.add(getString(R.string.GroupAdmin))

        Log.d("###", "initListData: "+listGroup)
            val arrayname = arrayOf(1, 2, 3, 4, 5)
        for( item in   array){
            list.add(items)
        }
    }

    //menu top right
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.pan_card_admin, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_admin -> Toast.makeText(applicationContext, "ok", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_pan_card_admin)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }
//    private fun createGroupList() {
//        groupList = java.util.ArrayList()
//        groupList.add("Samsung")
//        groupList.add("Google")
//        groupList.add("Redmi")
//        groupList.add("Vivo")
//        groupList.add("Nokia")
//        groupList.add("Motorola")
//    }
}