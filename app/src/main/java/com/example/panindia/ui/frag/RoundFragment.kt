package com.example.indiavle.ui.frag

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.panindia.R
import com.example.panindia.ui.frag.cal
import java.text.SimpleDateFormat
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RoundFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RoundFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var spWeight: Spinner
    lateinit var spPassanger: Spinner
    lateinit var spKids: Spinner
    lateinit var spClass :Spinner
    lateinit var llRoundDepart:LinearLayout
    lateinit var llReturnDate:LinearLayout
    var items = arrayOf("1", "2", "3")
    var itemsClass = arrayOf("Economy", "Bussiness", "Elite")

    //    lateinit var etDepartDate: EditText
    lateinit var etDepartDate: TextView
    lateinit var tvReturnDate: TextView
    lateinit var viewlayout: View
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
        viewlayout = inflater.inflate(R.layout.fragment_round, container, false)
        return viewlayout
    }

    fun init() {

        etDepartDate = viewlayout.findViewById(R.id.etDepartDate)
        tvReturnDate = viewlayout.findViewById(R.id.tvReturnDate)
        spPassanger = viewlayout.findViewById(R.id.spPassangers)
        spKids = viewlayout.findViewById(R.id.spKids)
        spWeight = viewlayout.findViewById(R.id.spWeight)
        //class filter
        spClass= viewlayout.findViewById(R.id.Round_class)
        llRoundDepart= viewlayout.findViewById(R.id.llRoundDepart)
        llReturnDate= viewlayout.findViewById(R.id.llReturnDate)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        //number
        val numberOfDate =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, items)
        numberOfDate.setDropDownViewResource(R.layout.text_center)
        //class
        val classSelection =
            ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, itemsClass)
        numberOfDate.setDropDownViewResource(R.layout.text_center)

        spPassanger.adapter = numberOfDate
        spKids.adapter = numberOfDate
        spWeight.adapter = numberOfDate
        spClass.adapter =classSelection
        etDepartDate.setOnClickListener {
            DateDepart()
        }
        llRoundDepart.setOnClickListener{
            DateDepart()
        }
        tvReturnDate.setOnClickListener {
            DateReturn()
        }
        llReturnDate.setOnClickListener {
            DateReturn()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun DateReturn() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateReturn()
            }
        DatePickerDialog(
            requireContext(), dateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun updateDateReturn() {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        tvReturnDate!!.text = sdf.format(cal.getTime())
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
        etDepartDate!!.text = sdf.format(cal.getTime())
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RoundFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RoundFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}