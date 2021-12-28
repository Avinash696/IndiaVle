package com.example.indiavle.ui.frag

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.panindia.R
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
lateinit var multiStopDate:TextView
lateinit var viewlayout: View
lateinit var spAdult :Spinner
lateinit var spChild :Spinner
lateinit var spInfant :Spinner
lateinit var spClass :Spinner
var items = arrayOf("1", "2", "3")
var itemsClass = arrayOf("Economy", "Bussiness", "Elite")
/**
 * A simple [Fragment] subclass.
 * Use the [MultiStopFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MultiStopFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var checkElite = false
    var checkBussiness = false
    var checkEconomy = false

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
       viewlayout= inflater.inflate(R.layout.fragment_multi_stop, container, false)
        return  viewlayout
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MultiStopFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MultiStopFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    fun init(){
        multiStopDate = viewlayout.findViewById(R.id.multiStopDate)
        spAdult = viewlayout.findViewById(R.id.spAdultMulti)
        spChild = viewlayout.findViewById(R.id.spChildMulti)
        spInfant = viewlayout.findViewById(R.id.spInfantMulti)
        spClass = viewlayout.findViewById(R.id.spClassMulti)

    }
    fun DateDepart() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateDepart()
            }
        DatePickerDialog(
            requireContext(), dateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
    private fun updateDateDepart() {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        multiStopDate!!.text = sdf.format(cal.getTime())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        multiStopDate.setOnClickListener {
            DateDepart()
        }
        //number
        val numberOfDate =
            ArrayAdapter(requireContext(), R.layout.text_center, items)
        numberOfDate.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        //class
        val classSelection =
            ArrayAdapter(requireContext(), R.layout.text_center, itemsClass)
        numberOfDate.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        spAdult.adapter = numberOfDate
        spChild.adapter = numberOfDate
        spInfant.adapter = numberOfDate
        spClass.adapter =classSelection
        super.onViewCreated(view, savedInstanceState)
    }
}