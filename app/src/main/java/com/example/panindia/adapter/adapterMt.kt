//package com.example.panindia.adapter
//
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentManager
//import androidx.fragment.app.FragmentPagerAdapter
//import com.example.panindia.ui.activity.fragment.HomeFragment
//import com.example.panindia.ui.frag.*
//
//class adapterMt(fm :FragmentManager) : FragmentPagerAdapter(fm) {
//    override fun getCount(): Int {
//       return  5
//    }
//
//    override fun getItemd(position: Int): Fragment {
//        return when(position){
//            0 -> MtHomeFragment()
//            1 -> MtSearchKycFragment()
//            2 -> MtTranactionHistoryFragment()
//            3 -> MtTransactionStatusFragment()
//            4 -> MtHowItWorksFragment()
//            else -> MtHomeFragment()
//        }
//    }
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        return when(position){
//            0 -> "Home"
//            1 -> "Search Kyc "
//            2 -> "Transaction History"
//            3 -> "Transaction Status"
//            4 -> "How It Works"
//            else -> "Else Tab "
//        }
//    }
//
//}