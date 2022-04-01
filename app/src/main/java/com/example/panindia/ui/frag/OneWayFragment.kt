package com.example.panindia.ui.frag

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.panindia.R
import com.example.panindia.adapter.adapterSeachList
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.ResponceFlightSeachModel
import com.example.panindia.model.searchFlightModel.sendModel.FlightSearchSendModel
import com.example.panindia.model.searchFlightModel.sendModel.Segment
import com.example.panindia.viewModel.LoginViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.ui.activity.JoiningListActivity
import com.example.panindia.ui.activity.searchAdapterList.SearchListActivity

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
var cal = Calendar.getInstance()

class OneWayFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    var checkElite = false
    var checkBussiness = false
    var checkEconomy = false
    lateinit var loginViewModel: LoginViewModel

    var items = arrayOf("1", "2", "3")
    val destination = arrayOf("Noida", "Lucknow")
    lateinit var viewlayout: View

    private lateinit var spWeight: Spinner
    private lateinit var spPassanger: Spinner
    lateinit var spKids: Spinner
    lateinit var etDepartDate: TextView
    lateinit var etRetunDate: TextView

    //textview
    lateinit var tvSeachFlight:TextView
    //class
    lateinit var tvEconomy: TextView
    lateinit var tvBussiness: TextView
    lateinit var tvElite: TextView
    lateinit var departDate: ImageView
    lateinit var returnDate: ImageView

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
        viewlayout = inflater.inflate(R.layout.fragment_one_way, container, false)
        init()
        val LTRadapter =
            ArrayAdapter(requireContext(), R.layout.text_center, destination)
        LTRadapter.setDropDownViewResource(R.layout.text_center)
        //number
        val numberOfDate =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, items)
        numberOfDate.setDropDownViewResource(R.layout.text_center)

        spPassanger.adapter = numberOfDate
        spKids.adapter = numberOfDate
        spWeight.adapter = numberOfDate

        //class define
        return viewlayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        etDepartDate.setOnClickListener {
            DateDepart()
        }
        tvSeachFlight.setOnClickListener {
            startActivity(Intent(requireContext(),SearchListActivity::class.java))
        }

        departDate.setOnClickListener {
            DateDepart()
        }
        etRetunDate.setOnClickListener {
            DateReturn()
        }
        returnDate.setOnClickListener {
            DateReturn()
        }
        //changing color
        tvElite.setOnClickListener {
            checkEconomy = false
            checkBussiness = false
            checkElite = true
            changeColor()
        }
        tvEconomy.setOnClickListener {
            checkEconomy = true
            checkBussiness = false
            checkElite = false
            changeColor()
        }
        tvBussiness.setOnClickListener {
            checkEconomy = false
            checkBussiness = true
            checkElite = false
            changeColor()
        }
        super.onViewCreated(view, savedInstanceState)
    }



    private fun changeColor() {
        when {
            checkElite -> {
                tvElite.setBackgroundColor(resources.getColor(R.color.cream))
                tvBussiness.setBackgroundColor(resources.getColor(R.color.white))
                tvEconomy.setBackgroundColor(resources.getColor(R.color.white))
            }
            checkEconomy -> {
                tvEconomy.setBackgroundColor(resources.getColor(R.color.cream))
                tvBussiness.setBackgroundColor(resources.getColor(R.color.white))
                tvElite.setBackgroundColor(resources.getColor(R.color.white))

            }
            checkBussiness -> {
                tvBussiness.setBackgroundColor(resources.getColor(R.color.cream))
                tvEconomy.setBackgroundColor(resources.getColor(R.color.white))
                tvElite.setBackgroundColor(resources.getColor(R.color.white))
            }
        }
    }

    private fun DateDepart() {
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

    private fun updateDateReturn() {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        etRetunDate!!.text = sdf.format(cal.getTime())
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

    fun init() {
        //textview btn
        tvSeachFlight = viewlayout.findViewById(R.id.tvSeachFlight)

        etDepartDate = viewlayout.findViewById(R.id.etDepartDate)
        etRetunDate = viewlayout.findViewById(R.id.etRetunDate)
        spPassanger = viewlayout.findViewById(R.id.spPassangers)
        spKids = viewlayout.findViewById(R.id.spKids)
        spWeight = viewlayout.findViewById(R.id.spWeight)
        //class filter
        tvEconomy = viewlayout.findViewById(R.id.tvEconomy)
        tvBussiness = viewlayout.findViewById(R.id.tvBussiness)
        tvElite = viewlayout.findViewById(R.id.tvElite)
        departDate = viewlayout.findViewById(R.id.ivDepartOneWay)
        returnDate = viewlayout.findViewById(R.id.ivReturnOneWay)

    }

    companion object {
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