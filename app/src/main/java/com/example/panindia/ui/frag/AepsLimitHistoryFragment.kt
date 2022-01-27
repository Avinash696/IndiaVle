package com.example.panindia.ui.frag

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.R
import com.example.panindia.adapter.adapterLimitHistory
import com.example.panindia.model.limitHistoryModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
lateinit var rv: RecyclerView
private lateinit var m_view: View

class AepsLimitHistoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        Log.d(TAG, "onCreateView: ")
        m_view = inflater.inflate(R.layout.fragment_aeps_limit_history, container, false)
        return m_view
    }

    private fun init() {
        rv = m_view.findViewById(R.id.rvHistoryAeps)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        populatingData()
        super.onViewCreated(view, savedInstanceState)
    }

    fun populatingData() {
        val arrayData = ArrayList<limitHistoryModel>()
        arrayData.add(limitHistoryModel("20/03/2021", "Retailer"))
        arrayData.add(limitHistoryModel("01/03/2021", "Js-Admin"))
        arrayData.add(limitHistoryModel("01/03/2021", "HG098"))
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapterLimitHistory(arrayData, requireContext())
        Log.d(TAG, "populatingData: ")
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AepsLimitHistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}