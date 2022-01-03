package com.example.panindia.Helper

import androidx.fragment.app.FragmentManager
import com.example.panindia.Interface.NavigationManager
import com.example.panindia.ui.activity.PanCardAdminActivity

public class FragmentNavigationManger :NavigationManager{
    lateinit var mFragmentNavigationManger:FragmentNavigationManger
    lateinit var mFragmentManger :FragmentManager
    lateinit var panCardAdminActivity: PanCardAdminActivity

      private fun  getmInstance() :FragmentNavigationManger{
        if(mFragmentNavigationManger == null){
            mFragmentNavigationManger = FragmentNavigationManger()
          }
        return mFragmentNavigationManger
    }
    fun configure(panCardAdminActivity: PanCardAdminActivity){
            this.panCardAdminActivity = PanCardAdminActivity()
        mFragmentManger = panCardAdminActivity.supportFragmentManager
    }

    override fun showFragment(title: String) {
        TODO("Not yet implemented")
    }
}