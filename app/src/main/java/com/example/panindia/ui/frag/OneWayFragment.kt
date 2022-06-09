package com.example.panindia.ui.frag

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.panindia.R
import com.example.panindia.viewModel.LoginViewModel
import java.text.SimpleDateFormat
import java.util.*
import android.widget.AdapterView.OnItemSelectedListener
import com.example.panindia.ui.activity.searchAdapterList.SearchListActivity
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.collections.ArrayList

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

    var items = arrayOf("0", "1", "2", "3")
    val destination = arrayOf("Noida", "Lucknow")
    lateinit var viewlayout: View

    private lateinit var spWeight: Spinner
    private lateinit var spPassanger: Spinner
    lateinit var spKids: Spinner
    lateinit var etDepartDate: TextView
//    lateinit var etRetunDate: TextView

    //textview
    lateinit var tvSeachFlight: TextView

    //class
    lateinit var tvEconomy: TextView
    lateinit var tvBussiness: TextView
    lateinit var tvElite: TextView
    lateinit var departDate: ImageView
//    lateinit var returnDate: ImageView

    //autocomplteTv
    lateinit var sourceTv: AutoCompleteTextView
    lateinit var destinationTv: AutoCompleteTextView

    //var to send using intent
    lateinit var spPassangerString: String
    lateinit var spkidsString: String
    lateinit var spWeightString: String
    val classSelect = 0

    lateinit var adapterSource: ArrayAdapter<String>
    lateinit var adapterDestination: ArrayAdapter<String>

    var sourceTextView: AutoCompleteTextView? = null
    var destinationTextView: AutoCompleteTextView? = null

    //    var array = arrayOf("Lucknow ", "Delhi", "Noida","Orissa","Kanai")
    var array = ArrayList<String>()
    lateinit var arrayExcel: ArrayList<String>
    lateinit var arrayExcelFull: ArrayList<String>
    var adapterSour: ArrayAdapter<String>? = null
    var adapterdesti: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arrayExcel = arrayListOf()
        arrayExcelFull = arrayListOf()
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
        readDataExcel()
        val LTRadapter =
            ArrayAdapter(requireContext(), R.layout.text_center, arrayExcelFull)
        LTRadapter.setDropDownViewResource(R.layout.text_center)
        //number
        val numberOfDate =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, items)
        numberOfDate.setDropDownViewResource(R.layout.text_center)

        spPassanger.adapter = numberOfDate
        spKids.adapter = numberOfDate
        spWeight.adapter = numberOfDate

        return viewlayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sendOneWayData()
        //adapter of autocomplte
        sourceTextView = view.findViewById(R.id.spFromOneWay)

        adapterSour = ArrayAdapter<String>(requireContext(),
            android.R.layout.simple_list_item_1, arrayExcelFull)

        sourceTextView!!.setAdapter(adapterSour)

        //destination spinner
        destinationTextView = view.findViewById(R.id.spToOneWay)
        adapterdesti = ArrayAdapter<String>(requireContext(),
            android.R.layout.simple_list_item_1, arrayExcelFull)

        destinationTextView!!.setAdapter(adapterdesti)

        etDepartDate.setOnClickListener {
            DateDepart()
        }
        tvSeachFlight.setOnClickListener {
            val intent = Intent(requireContext(), SearchListActivity::class.java)

            val sk = sourceTextView!!.text
//            val splitMe = sk.split(",")
//            Log.d("skCheck", "${splitMe[1]} ")
            val dk = destinationTextView!!.text
            intent.putExtra("SourceKey", sk.split(",")[1])
            intent.putExtra("DestinationKey", dk.split(",")[1])
            intent.putExtra("Departkey", etDepartDate.text)
//            intent.putExtra("Returnkey", etRetunDate.text)
            intent.putExtra("Passengerkey", spPassangerString)
            intent.putExtra("kidskey", spkidsString)
            intent.putExtra("Weightkey", spWeightString)

            val classSelect = getPreferedAirLine()
            intent.putExtra("Classkey", classSelect.toString())
            intent.putExtra("JourneyType",1)
            context?.startActivity(intent)
        }

        departDate.setOnClickListener {
            DateDepart()
        }
//        etRetunDate.setOnClickListener {
//            DateReturn()
//        }
//        returnDate.setOnClickListener {
//            DateReturn()
//        }
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

//        val myFormat = "yyyy-MM-dd hh:mm:ss "
        val myFormat = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        etDepartDate.text = sdf.format(cal.time)
        //date to send - sdf.format(cal.time)
    }

    private fun updateDateReturn() {
        val myFormat = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
//        etRetunDate.text = sdf.format(cal.time)
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
//        etRetunDate = viewlayout.findViewById(R.id.etRetunDate)
        spPassanger = viewlayout.findViewById(R.id.spPassangers)
        spKids = viewlayout.findViewById(R.id.spKids)
        spWeight = viewlayout.findViewById(R.id.spWeight)
        //class filter
        tvEconomy = viewlayout.findViewById(R.id.tvEconomy)
        tvBussiness = viewlayout.findViewById(R.id.tvBussiness)
        tvElite = viewlayout.findViewById(R.id.tvElite)
        departDate = viewlayout.findViewById(R.id.ivDepartOneWay)
//        returnDate = viewlayout.findViewById(R.id.ivReturnOneWay)

        //autocomplete
        sourceTv = viewlayout.findViewById(R.id.spFromOneWay)
        destinationTv = viewlayout.findViewById(R.id.spToOneWay)
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

    private fun sendOneWayData() {
        spPassanger.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long,
            ) {
                spPassangerString = parent.getItemAtPosition(position).toString()
                Log.d(TAG, "passangers: $spPassangerString")
            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spKids.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long,
            ) {
                spkidsString = parent.getItemAtPosition(position).toString()
                Log.d(TAG, "kids: $spkidsString")
            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spWeight.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long,
            ) {
                spWeightString = parent.getItemAtPosition(position).toString()
                Log.d(TAG, "weight: $spWeightString")
            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun getPreferedAirLine(): Int {
        var kk = 0
        if (!checkElite || !checkBussiness || checkEconomy) {
            kk = 1
        } else if (!checkElite || checkBussiness || !checkEconomy) {
            kk = 2
        } else if (checkElite || !checkBussiness || !checkEconomy) {
            kk = 3
        }
        return kk
    }

    private fun readDataExcel() {

        val inputStream = resources.openRawResource(R.raw.excel_source)
        val reader = BufferedReader(InputStreamReader(inputStream))
        reader.lineSequence().forEach {
            val token = it.split(",")
            Log.d("newLoop", "readDataExcel: ${token[0]}  ${token[1]}")
//            arrayExcelLoc.add(token[1]+","+token[0])
//            arrayExcel.add(token[1]+","+token[0])
            array.add(token[0])
            arrayExcelFull.add(token[1]+","+token[0])
        }
    }
}