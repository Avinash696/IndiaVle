package com.example.panindia.ui.frag

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.indiavle.ui.frag.cal
import com.example.panindia.R
import com.example.panindia.adapter.adapterLimitHistory
import com.example.panindia.model.limitHistoryModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
lateinit var rv: RecyclerView
private lateinit var m_view: View
lateinit var stDate :TextView
lateinit var endDate :TextView

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
        stDate = m_view.findViewById(R.id.tvStartDate)
        endDate =m_view.findViewById(R.id.tvEndDate)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        populatingData()
        stDate.setOnClickListener {
            dateStart()
        }
        endDate.setOnClickListener {
            dateEnd()
        }
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
    private fun dateStart(){
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//                updateDateDepart()
                val myFormat = "dd/MM/yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                stDate!!.text = sdf.format(cal.getTime())
            }
        DatePickerDialog(requireContext(), dateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)).show()
    }
    private fun dateEnd(){
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//                updateDateDepart()
                val myFormat = "dd/MM/yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                endDate!!.text = sdf.format(cal.getTime())
            }
        DatePickerDialog(requireContext(), dateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)).show()
    }
}