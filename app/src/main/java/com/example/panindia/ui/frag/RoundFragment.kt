package com.example.indiavle.ui.frag

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.panindia.R
import com.example.panindia.ui.activity.searchAdapterList.SearchListActivity
import com.example.panindia.ui.frag.TAG
import com.example.panindia.ui.frag.cal
import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
var array = ArrayList<String>()
lateinit var arrayExcelFull: ArrayList<String>

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
    //string spinner var
    lateinit var spPassangerString :String
    lateinit var spkidsString :String
    lateinit var spWeightString :String
//    lateinit var llRoundDepart:LinearLayout
//    lateinit var llReturnDate:LinearLayout
    lateinit var etSourceRound :AutoCompleteTextView
    var items = arrayOf("1", "2", "3")
    var itemsClass = arrayOf("Economy", "Bussiness", "Elite")
    //location
    var sourceTextView: AutoCompleteTextView? = null
    var destinationTextView: AutoCompleteTextView? = null
    var adapterSour: ArrayAdapter<String>? = null
    var adapterdesti: ArrayAdapter<String>? = null
    lateinit var tvSeachFlight:TextView

    //    lateinit var etDepartDate: EditText
    lateinit var etDepartDate: TextView
    lateinit var tvReturnDate: TextView
    lateinit var viewlayout: View
    var checkElite = false
    var checkBussiness = false
    var checkEconomy = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arrayExcelFull = arrayListOf()
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
        sourceTextView = view?.findViewById(R.id.etSourceRound)
        destinationTextView = view?.findViewById(R.id.etDestiRound)

        etDepartDate = viewlayout.findViewById(R.id.tvDepartDateRound)
        tvReturnDate = viewlayout.findViewById(R.id.tvReturnDateRound)
        spPassanger = viewlayout.findViewById(R.id.spPassangersRound)
        spKids = viewlayout.findViewById(R.id.spKidsRound)
        spWeight = viewlayout.findViewById(R.id.spWeightRound)
        //class filter
        spClass= viewlayout.findViewById(R.id.Round_class)
//        llRoundDepart= viewlayout.findViewById(R.id.llRoundDepart)
//        llReturnDate= viewlayout.findViewById(R.id.llReturnDate)
        tvSeachFlight = viewlayout.findViewById(R.id.tvSeachFlight)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        readDataExcel()
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
        //spinner data take
        spPassanger.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

        spKids.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

        spWeight.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
//        spPassanger.onItemSelectedListener { adapterView, view, i, l ->
//            spPassangerString = adapterView.getItemAtPosition(i).toString()
//        }
//        spKids.onItemSelectedListener { adapterView, view, i, l ->
//            spkidsString = adapterView.getItemAtPosition(i).toString()
//        }
//        spWeight.onItemSelectedListener { adapterView, view, i, l ->
//            spWeightString = adapterView.getItemAtPosition(i).toString()
//        }
        etDepartDate.setOnClickListener {
            DateDepart()
        }
//        llRoundDepart.setOnClickListener{
//            DateDepart()
//        }
        tvReturnDate.setOnClickListener {
            DateReturn()
        }
//        llReturnDate.setOnClickListener {
//            DateReturn()
//        }

        adapterSour = ArrayAdapter<String>(requireContext(),
            android.R.layout.simple_list_item_1, arrayExcelFull)
        sourceTextView!!.setAdapter(adapterSour)

        //destination spinner

        adapterdesti = ArrayAdapter<String>(requireContext(),
            android.R.layout.simple_list_item_1, arrayExcelFull)

        destinationTextView!!.setAdapter(adapterdesti)

        tvSeachFlight.setOnClickListener {

            val intent = Intent(requireContext(), SearchListActivity::class.java)

            val sk = sourceTextView!!.text
            val dk = destinationTextView!!.text
            intent.putExtra("SourceKey", sk.split(",")[1])
            intent.putExtra("DestinationKey", dk.split(",")[1])
            intent.putExtra("Departkey", etDepartDate.text)
<<<<<<< HEAD
            intent.putExtra("ReturnkeyRound", tvReturnDate.text)
            intent.putExtra("Passengerkey", spPassangerString)
            intent.putExtra("kidskey", spkidsString)
            intent.putExtra("Weightkey", spWeightString)
            intent.putExtra("JourneyType",2)
=======
            intent.putExtra("Returnkey", tvReturnDate.text)
            intent.putExtra("Passengerkey", spPassangerString)
            intent.putExtra("kidskey", spkidsString)
            intent.putExtra("Weightkey", spWeightString)

>>>>>>> origin/master
            val classSelect = 1
            intent.putExtra("Classkey", classSelect.toString())
            context?.startActivity(intent)
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
        tvReturnDate!!.text = sdf.format(cal.time)
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
        etDepartDate!!.text = sdf.format(cal.time)
    }

    private fun readDataExcel() {

        val inputStream = resources.openRawResource(R.raw.excel_source)
        val reader = BufferedReader(InputStreamReader(inputStream))
        reader.lineSequence().forEach {
            val token = it.split(",")
            Log.d("newLoop", "readDataExcel: ${token[0]}  ${token[1]}")
            array.add(token[0])
            arrayExcelFull.add(token[1]+","+token[0])
        }
    }

}