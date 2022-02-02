package com.example.panindia.ui.frag.FlightAfterLogin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.indiavle.ui.frag.viewlayout
import com.example.panindia.R
import com.example.panindia.adapter.adapterMtTransactionHistory
import com.google.android.material.tabs.TabLayout

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FlightAfterLoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var layoutView:View
    lateinit var tl :TabLayout
    lateinit var  vp:ViewPager


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
        layoutView = inflater.inflate(R.layout.fragment_flight_after_login, container, false)
        return layoutView
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FlightAfterLoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         tl = layoutView.findViewById<TabLayout>(R.id.tl)
         vp = layoutView.findViewById<ViewPager>(R.id.tl)
        setAdapter()
//        tl.setOnClickListener {
//            when(it.id){
//                R.id.tiOneWay -> Toast.makeText(requireContext(), "One way", Toast.LENGTH_SHORT).show()
//            }
//        }

        super.onViewCreated(view, savedInstanceState)
    }
    fun setAdapter(){
        vp.adapter = adapterMtTransactionHistory(requireActivity().supportFragmentManager)
        tl.setupWithViewPager(vp)
    }
    private fun layoutChange(frg : Fragment){
        val fragManager = requireActivity().supportFragmentManager
        val ft = fragManager.beginTransaction()
        ft.replace(R.id.fragHostFlight,frg)
        ft.commit()
    }
}