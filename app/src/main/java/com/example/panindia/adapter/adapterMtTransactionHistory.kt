package com.example.panindia.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.panindia.ui.frag.MtTransactionHistory.RaiseTransactionTicketFragment
import com.example.panindia.ui.frag.MtTransactionHistory.TransactionHistoryFragment
import com.example.panindia.ui.frag.MtTransactionHistory.TransactionTicketStatusFragment

class adapterMtTransactionHistory(fm:FragmentManager) :FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return  2
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> TransactionHistoryFragment()
            1 -> RaiseTransactionTicketFragment()
            2 -> TransactionTicketStatusFragment()
            else ->TransactionHistoryFragment()
        }
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Transaction History"
            1 -> "Raise Transaction Ticket"
            2 -> "Transaction Ticket Status"
            else -> "Else Tab"
        }
    }
}