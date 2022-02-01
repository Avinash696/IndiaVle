package com.example.panindia.ui.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.panindia.R
import com.google.android.material.tabs.TabLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MoneyTransferFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoneyTransferFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var layView :View
    lateinit var tabLayout :TabLayout
    lateinit var viewPager :ViewPager

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
        layView= inflater.inflate(R.layout.fragment_money_transfer, container, false)
        return layView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        tabLayout.addTab(tabLayout.newTab().setText("first"))
        tabLayout.addTab(tabLayout.newTab().setText("second"))
        tabLayout.addTab(tabLayout.newTab().setText("third"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        super.onViewCreated(view, savedInstanceState)
    }
    private fun init(){
         tabLayout  = layView.findViewById(R.id.tabLayout)
         viewPager  = layView.findViewById(R.id.viewPager)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MoneyTransferFragment.
         */
        // TODO: Rename and change types and number of parameters
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