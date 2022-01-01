package com.example.indiavle.ui.frag

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import com.example.panindia.R
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
lateinit var multiStopDate: TextView
@SuppressLint("StaticFieldLeak")
lateinit var multiStopDate1: TextView
lateinit var multiStopDate2: TextView
lateinit var multiStopDate3: TextView
lateinit var multiStopDate4: TextView

lateinit var multiStopRetunDate: TextView
lateinit var viewlayout: View
lateinit var spAdult: Spinner
lateinit var spChild: Spinner
lateinit var spInfant: Spinner
lateinit var spClass: Spinner
lateinit var ivAddReturnDate: ImageView
lateinit var ivRemoveReturnDate: ImageView
//lateinit var cvReturnDate: CardView
//lateinit var cvReturnDate2: CardView
//lateinit var cvReturnDate3: CardView
//lateinit var cvReturnDate4: CardView
lateinit var cvReturnDate: RelativeLayout
lateinit var cvReturnDate2: RelativeLayout
lateinit var cvReturnDate3: RelativeLayout
lateinit var cvReturnDate4: RelativeLayout
var items = arrayOf("1", "2", "3")
var itemsClass = arrayOf("Economy", "Bussiness", "Elite")

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
        viewlayout = inflater.inflate(R.layout.fragment_multi_stop, container, false)
        return viewlayout
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            MultiStopFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun init() {
        multiStopDate = viewlayout.findViewById(R.id.multiStopDate)
        multiStopDate1 = viewlayout.findViewById(R.id.multiStopDate1)
        multiStopDate2 = viewlayout.findViewById(R.id.multiStopDate2)
        multiStopDate3 = viewlayout.findViewById(R.id.multiStopDate3)
        multiStopDate4 = viewlayout.findViewById(R.id.multiStopDate4)
        spAdult = viewlayout.findViewById(R.id.spAdultMulti)
        spChild = viewlayout.findViewById(R.id.spChildMulti)
        spInfant = viewlayout.findViewById(R.id.spInfantMulti)
        spClass = viewlayout.findViewById(R.id.spClassMulti)
        ivAddReturnDate = viewlayout.findViewById(R.id.ivAddReturnDate)
        ivRemoveReturnDate = viewlayout.findViewById(R.id.ivRemoveReturnDate)
        cvReturnDate = viewlayout.findViewById(R.id.cvReturnDate1)
        cvReturnDate2 = viewlayout.findViewById(R.id.cvReturnDate2)
        cvReturnDate3 = viewlayout.findViewById(R.id.cvReturnDate3)
        cvReturnDate4 = viewlayout.findViewById(R.id.cvReturnDate4)
        multiStopRetunDate = viewlayout.findViewById(R.id.multiStopDate)
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
    fun DateDepart1() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                //set date
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val myFormat = "dd/MM/yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                multiStopDate1.text = sdf.format(cal.time)
            }
        DatePickerDialog(
            requireContext(), dateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
    fun DateDepart2() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                //set date
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val myFormat = "dd/MM/yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                multiStopDate2.text = sdf.format(cal.time)
            }
        DatePickerDialog(
            requireContext(), dateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
    fun DateDepart3() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                //set date
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val myFormat = "dd/MM/yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                multiStopDate3.text = sdf.format(cal.time)
            }
        DatePickerDialog(
            requireContext(), dateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
    fun DateDepart4() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                //set date
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val myFormat = "dd/MM/yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                multiStopDate4.text = sdf.format(cal.time)
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
        multiStopDate.text = sdf.format(cal.time)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        multiStopDate.setOnClickListener {
            DateDepart()
        }
        //date 1
        multiStopDate1.setOnClickListener { DateDepart1() }
        //date 2
        multiStopDate2.setOnClickListener { DateDepart2() }
        //date 3
        multiStopDate3.setOnClickListener { DateDepart3() }
        //date 4
        multiStopDate4.setOnClickListener { DateDepart4() }
        //number
        val numberOfDate =
            ArrayAdapter(requireContext(), R.layout.text_center, items)
        numberOfDate.setDropDownViewResource(R.layout.text_center)
        //class
        val classSelection =
            ArrayAdapter(requireContext(), R.layout.text_center, itemsClass)
        numberOfDate.setDropDownViewResource(R.layout.text_center)

        spAdult.adapter = numberOfDate
        spChild.adapter = numberOfDate
        spInfant.adapter = numberOfDate
        spClass.adapter = classSelection
        var count = 0
        ivAddReturnDate.setOnClickListener {
            count++
            checkCountAdd(count)
        }
        ivRemoveReturnDate.setOnClickListener {
            count--
            checkCountRemove(count)
        }

//            cvReturnDate.isVisible =true

        multiStopRetunDate.setOnClickListener {
            multiStopDepartDate()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    fun checkCountAdd(count: Int) {
        if (count == 1) {
            cvReturnDate.isVisible = true
        } else if (count == 2) {
            cvReturnDate.isVisible = true
            cvReturnDate2.isVisible = true
        } else if (count == 3) {
            cvReturnDate.isVisible = true
            cvReturnDate2.isVisible = true
            cvReturnDate3.isVisible = true
        } else if (count == 4) {
            cvReturnDate.isVisible = true
            cvReturnDate2.isVisible = true
            cvReturnDate3.isVisible = true
            cvReturnDate4.isVisible = true
        }
    }
    fun checkCountRemove(count: Int) {
        if(count==0){
            cvReturnDate.isVisible = false
            cvReturnDate2.isVisible = false
            cvReturnDate3.isVisible = false
            cvReturnDate4.isVisible = false
        }
        else if(count == 1) {
            cvReturnDate.isVisible = true
            cvReturnDate2.isVisible = false
            cvReturnDate3.isVisible = false
            cvReturnDate4.isVisible = false
        } else if (count == 2) {
            cvReturnDate.isVisible = true
            cvReturnDate2.isVisible = true
            cvReturnDate3.isVisible = false
            cvReturnDate4.isVisible = false
        } else if (count == 3) {
            cvReturnDate.isVisible = true
            cvReturnDate2.isVisible = true
            cvReturnDate3.isVisible = true
            cvReturnDate4.isVisible = false
        } else if (count == 4) {
            cvReturnDate.isVisible = true
            cvReturnDate2.isVisible = true
            cvReturnDate3.isVisible = true
            cvReturnDate4.isVisible = true
        }
    }

    private fun multiStopDepartDate() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateDepartMulti()
            }
        DatePickerDialog(
            requireContext(), dateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun updateDateDepartMulti() {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        multiStopRetunDate!!.text = sdf.format(cal.getTime())
    }
}