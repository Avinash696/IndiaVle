package com.example.indiavle.ui.frag

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import com.example.panindia.R
import com.example.panindia.databinding.FragmentOneWayBinding
import android.widget.ArrayAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
var cal = Calendar.getInstance()

/**
 * A simple [Fragment] subclass.
 * Use the [OneWayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OneWayFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var items = arrayOf("1", "2", "3")
    val destination = arrayOf("Noida", "Lucknow")
    lateinit var viewlayout: View
    lateinit var spFromOneWay: Spinner
    lateinit var spToOneWay: Spinner
    lateinit var etDepartDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewlayout = inflater.inflate(R.layout.fragment_one_way, container, false)
        init()
        val spFromOneWay: Spinner = viewlayout.findViewById(R.id.spFromOneWay)
        val LTRadapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, destination)
        LTRadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spFromOneWay.adapter = LTRadapter
//        spToOneWay.adapter = LTRadapter
        etDepartDate
        return viewlayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        etDepartDate.setOnClickListener {
            DatecheckOut()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    fun DatecheckOut() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateCheckOut()
            }
        DatePickerDialog(
            requireContext(), dateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    fun updateDateCheckOut() {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        etDepartDate!!.text = sdf.format(cal.getTime())
    }

    fun init() {
//        tvFrom =  viewlayout.findViewById(R.id.tvFrom)
        spFromOneWay = viewlayout.findViewById(R.id.spFromOneWay)
        spToOneWay = viewlayout.findViewById(R.id.spToOneWay)
        etDepartDate = viewlayout.findViewById(R.id.etDepartDate)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OneWayFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OneWayFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}