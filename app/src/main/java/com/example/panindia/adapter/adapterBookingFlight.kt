package com.example.panindia.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.indiavle.ui.frag.MultiStopFragment
import com.example.panindia.ui.frag.OneWayFragment
import com.example.indiavle.ui.frag.RoundFragment
import com.example.panindia.ui.frag.MtTransactionHistory.TransactionHistoryFragment

class adapterBookingFlight (fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return  3
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> OneWayFragment()
            1 -> RoundFragment()
            2 -> MultiStopFragment()
            else -> TransactionHistoryFragment()
        }
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "One Way"
            1 -> "Round Way "
            2 -> "Multi Way"
            else -> "Else Tab"
        }
    }
}