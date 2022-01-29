package com.example.panindia.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.panindia.ui.frag.*

internal class adapterMoneyTransfer(var context: Context, fm: FragmentManager?, var totalTabs: Int) :
    FragmentPagerAdapter(fm!!) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                MtHomeFragment()
            }
            1 -> {
                MtSearchKycFragment()
            }
            2 -> {
                MtTranactionHistoryFragment()
            } 3 -> {
                MtTransactionStatusFragment()
            } 4 -> {
                MtHowItWorksFragment()
            }
            else -> MtHomeFragment()
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}