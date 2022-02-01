package com.example.panindia.ui.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.panindia.R
import com.example.panindia.adapter.adapterMt
import com.google.android.material.tabs.TabLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MoneyTransferFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var layView: View
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        layView = inflater.inflate(R.layout.fragment_money_transfer, container, false)
        return layView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        setAdapter()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun init() {
        tabLayout = layView.findViewById(R.id.tabLayout)
        viewPager = layView.findViewById(R.id.vpMt)
    }

    private fun setAdapter() {
//        val adapterData = adapterMt(requireActivity().supportFragmentManager,
//            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
//        adapterData.addFragment(MtHomeFragment(), "Home")
//        adapterData.addFragment(MtSearchKycFragment(), "Seach Kyc")
//        adapterData.addFragment(MtTranactionHistoryFragment(), "Transaction History")
//        adapterData.addFragment(MtTransactionStatusFragment(), "Transaction Status")
//        adapterData.addFragment(MtHowItWorksFragment(), "How It Works")
        viewPager.adapter = adapterMt(requireActivity().supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
//        viewPager.adapter = adapterData
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MoneyTransferFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}