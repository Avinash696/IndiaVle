package com.example.panindia.ui.activity

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.example.indiavle.ui.frag.multiStopRetunDate
import com.example.panindia.R
import com.example.panindia.Repositary.FareQuoteRepositary
import com.example.panindia.Repositary.TicketRepositary
import com.example.panindia.adapter.adapterAirTicketQ
import com.example.panindia.adapter.passangerCountTicket
import com.example.panindia.api.ApiService
import com.example.panindia.api.RetrofitHelper
import com.example.panindia.databinding.ActivityTicketBinding
import com.example.panindia.model.FareQuote.SendFareQuote.SendFareQuoteModel
import com.example.panindia.model.TicketModel.ResponceTicketModel.ChargeBU
import com.example.panindia.model.TicketModel.SendTicketModel.Fare
import com.example.panindia.model.TicketModel.SendTicketModel.Passenger
import com.example.panindia.model.TicketModel.SendTicketModel.SendTicketModel
import com.example.panindia.model.airTicketQModel
import com.example.panindia.model.passangerCountModel
import com.example.panindia.ui.frag.cal
import com.example.panindia.viewModel.FareQuoteTicket.FareQuoteFactory
import com.example.panindia.viewModel.FareQuoteTicket.FareQuoteTicketViewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import android.widget.ArrayAdapter
import androidx.core.view.size
import com.google.gson.Gson


class TicketActivity : AppCompatActivity() {

    lateinit var fareQuote: FareQuoteTicketViewModel
    private lateinit var binding: ActivityTicketBinding
    lateinit var intentData: Intent
    lateinit var tokenStr: String
    lateinit var traceIdStr: String
    private lateinit var resultIndexStr: String
    private  var adultCount: Int = 0
    private  var childCount: Int = 0
    private  var infantCount: Int = 0
    private lateinit var fAdult :ArrayList<Int>
    private lateinit var fInfant :ArrayList<Int>
    private lateinit var fChild :ArrayList<Int>
    val titleArr = arrayOf("Mr","Mrs")
    val genderArr = arrayOf(1,2)
    val nationalityArr = arrayOf("IN","US")
    val countryCodeArr = arrayOf("IN","US")
    //spinner
    lateinit var spTitle: Spinner
    lateinit var spGender: Spinner
    lateinit var spNationality: Spinner
    lateinit var spCountryCode: Spinner
    lateinit var titleString: String
     var genderString: Int =0
    lateinit var nationalityString: String
    lateinit var countryCodeString: String

    lateinit var fName: EditText
    lateinit var lName: EditText
    lateinit var passportNo: EditText
    lateinit var addressString: EditText
    lateinit var city: EditText
    lateinit var countryName: EditText
    lateinit var contact: EditText
    lateinit var email: EditText
    lateinit var dob: TextView
    lateinit var passportExpiry: TextView
    lateinit var arrayListPassanger :ArrayList<Passenger>
    lateinit var btnSave :Button

    val arrAdult = ArrayList<passangerCountModel>()
    val arrInfant = ArrayList<passangerCountModel>()
    val arrChild = ArrayList<passangerCountModel>()

    val arr = ArrayList<passangerCountModel>()

    private  var sizeFarebreakdown = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //dialog display
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.passenger_detail_fill)
        arrayListPassanger =ArrayList<Passenger>()

        intentData = intent
        tokenStr = intentData.getStringExtra("TokenId").toString()
        traceIdStr = intentData.getStringExtra("TraceId").toString()
        resultIndexStr = intentData.getStringExtra("ResultIndex").toString()
//        passangerCountStr = intentData.getStringExtra("passangerCount").toString()
        //iniit
        fAdult = ArrayList()
        fInfant = ArrayList()
        fChild = ArrayList()
        btnSave = dialog.findViewById<Button>(R.id.btSave)

//        Log.d("ticketTokenCheck", "onCreate: $passangerCountStr")
        //Both fn viewmodel obj
        val apiCall = RetrofitHelper.getRetroInstance().create(ApiService::class.java)
        val retroQuote = FareQuoteRepositary(apiCall)
        val retroTicket = TicketRepositary(apiCall)
        fareQuote = ViewModelProvider(this,
            FareQuoteFactory(retroQuote, retroTicket))[FareQuoteTicketViewModel::class.java]

        hitFareQuote(tokenStr, traceIdStr, resultIndexStr)
//        hitTicket(tokenStr, traceIdStr, resultIndexStr)
//        hitTicket("192.168.11.58", tokenStr, traceIdStr)
        val listView =  binding.lvAdultCount

    //dialog initilize
        spTitle = dialog.findViewById(R.id.spTitlePassDetail)
        spGender = dialog.findViewById(R.id.spGenderPassDetail)
        spNationality = dialog.findViewById(R.id.spNationalityPassDetail)
        spCountryCode = dialog.findViewById(R.id.spCountryCodePassDetail)

        //spinner adapter set
        val spTitleAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, titleArr)
        spTitleAdapter.setDropDownViewResource(R.layout.text_center)
        spTitle.adapter = spTitleAdapter

        val spGenderAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, genderArr)
        spGenderAdapter.setDropDownViewResource(R.layout.text_center)
        spGender.adapter = spGenderAdapter

        val spNationalityAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, nationalityArr)
        spNationalityAdapter.setDropDownViewResource(R.layout.text_center)
        spNationality.adapter = spNationalityAdapter

        val spCountryCodeAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, countryCodeArr)
        spCountryCodeAdapter.setDropDownViewResource(R.layout.text_center)
        spCountryCode.adapter = spCountryCodeAdapter
        //for adult
        binding.ivAddDetails.setOnClickListener{

            dialog.show()
            getValueFromDialog(dialog)
//adult
            btnSave.setOnClickListener {

                Log.d("savetest", "onCreateAdult: ${binding.lvAdultCount.size} $adultCount ")
                if(binding.lvAdultCount.size <  adultCount){
                    adultPassangerSet()

//                    adultCount -= 1

                if(binding.lvAdultCount.size <=  adultCount){
                    adultPassangerSet()

                    adultCount -= 1

                    dialog.dismiss()
                }
                else{
                    Toast.makeText(this, "All Adult Passenger Detail Filled", Toast.LENGTH_LONG).show()
                }
            }
        }
        //for child
        binding.ivAddDetailsChild.setOnClickListener {
            dialog.show()
            getValueFromDialog(dialog)

            //child
            btnSave.setOnClickListener {
                Log.d("savetest", "onCreate Child: ${binding.lvChildCount.size} $childCount ")

                if(binding.lvChildCount.size <  childCount){
                    childPassangerSet()

//                    childCount -= 1
            //child
            btnSave.setOnClickListener {
                if(binding.lvChildCount.size <=  childCount){
                    childPassangerSet()

                    childCount -= 1

                    dialog.dismiss()
                }
                else{
                    Toast.makeText(this, "All Child Passenger Detail Filled", Toast.LENGTH_LONG).show()
                }
            }
        }
        //for infant
        binding.ivAddDetailsInfant.setOnClickListener {
            dialog.show()
            getValueFromDialog(dialog)
            //infant
            btnSave.setOnClickListener {

                Log.d("savetest", "onCreate Infant: ${binding.lvInfantCount.size} $infantCount ")

                if(binding.lvInfantCount.size <  infantCount){
                    infantPassangerSet()

//                    infantCount -= 1

                if(binding.lvInfantCount.size <=  infantCount){
                    infantPassangerSet()

                    infantCount -= 1

                    dialog.dismiss()
                }
                else{
                    Toast.makeText(this, "All Infant Passenger Detail Filled", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.btSaveTicket.setOnClickListener {
            Log.d("sizeCheck", "btnSAve click: ${Gson().toJson(arrayListPassanger.size)} $sizeFarebreakdown")
            if(arrayListPassanger.size == sizeFarebreakdown){
                hitTicket(tokenStr, traceIdStr, resultIndexStr,arrayListPassanger)
            }
            else {
                Toast.makeText(this, "Fill all Passenger details ", Toast.LENGTH_SHORT).show()
            }
        }



        if(arrayListPassanger.size == sizeFarebreakdown){
            Log.d("sizeCheck", "onCreate: $arrayListPassanger $sizeFarebreakdown")
            hitTicket(tokenStr, traceIdStr, resultIndexStr,arrayListPassanger)
        }
        else {
            Toast.makeText(this, "Fill all Passenger details ", Toast.LENGTH_SHORT).show()
        }
    }
    private fun getValueFromDialog(dialog:Dialog){
        fName = dialog.findViewById<EditText>(R.id.etFirstNamePassDetail)
        lName = dialog.findViewById<EditText>(R.id.etLastNamePassDetail)
        passportNo = dialog.findViewById<EditText>(R.id.etPassportNoPassDetail)
        addressString = dialog.findViewById<EditText>(R.id.etAddressPassDetail)
        city = dialog.findViewById<EditText>(R.id.etCityPassDetail)
        countryName = dialog.findViewById<EditText>(R.id.etCountryNamePassDetail)
        contact = dialog.findViewById<EditText>(R.id.etContactNoPassDetail)
        email = dialog.findViewById<EditText>(R.id.etEmailPassDetail)
        dob = dialog.findViewById<TextView>(R.id.tvDobPassDetail)
        passportExpiry = dialog.findViewById<TextView>(R.id.tvPassportExpiryPassDetail)

        //sp onclick
        spTitle.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long,
            ) {
                titleString = parent.getItemAtPosition(position).toString()
                Log.d("mytitle", "kids: $titleString")
            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spCountryCode.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long,
            ) {
                countryCodeString = parent.getItemAtPosition(position).toString()

            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long,
            ) {
                genderString = parent.getItemAtPosition(position) as Int

            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spNationality.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long,
            ) {
                nationalityString = parent.getItemAtPosition(position).toString()
            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun hitFareQuote(tokenStr: String, traceIdStr: String, resultIndexStr: String) {
        //now show data
        val dummyObj = SendFareQuoteModel("192.168.11.58", resultIndexStr, tokenStr, traceIdStr)
        fareQuote.hitFareQuote(dummyObj)
        fareQuote.repoLiveData.observe(this, {

//            sizeFarebreakdown = it.Response.Results.FareBreakdown.size
            //all passenger count is defined
            Log.d("fareRes", "hitFareQuote: ${Gson().toJson(it.Response)} ")
            if(it.Response.Results.FareBreakdown.size == 1){
                adultCount = it.Response.Results.FareBreakdown[0].PassengerCount
                sizeFarebreakdown = adultCount

            sizeFarebreakdown = it.Response.Results.FareBreakdown.size
            //all passenger count is defined
            if(it.Response.Results.FareBreakdown.size == 1){
                adultCount = it.Response.Results.FareBreakdown[0].PassengerCount

            }
            else if(it.Response.Results.FareBreakdown.size == 2){
                adultCount = it.Response.Results.FareBreakdown[0].PassengerCount
                childCount = it.Response.Results.FareBreakdown[1].PassengerCount

                sizeFarebreakdown = adultCount +childCount
            }
            else if(it.Response.Results.FareBreakdown.size == 3){
                adultCount = it.Response.Results.FareBreakdown[0].PassengerCount
                childCount = it.Response.Results.FareBreakdown[1].PassengerCount
                infantCount = it.Response.Results.FareBreakdown[2].PassengerCount
                sizeFarebreakdown =adultCount +childCount +infantCount
            }

//            Log.d("myChild", "hitFareQuote: $adultCount $childCount $infantCount")

            }

            Log.d("myChild", "hitFareQuote: $adultCount $childCount $infantCount")

            val data = it.Response.Results.FareBreakdown

            //check if non null
            if((adultCount != 0) && (infantCount == 0) && (childCount == 0)){
                fAdult = arrayListOf<Int>(data[0].BaseFare,data[0].Tax)
            }
            else if((adultCount != 0) && (infantCount != 0) && (childCount == 0)){
                fAdult = arrayListOf<Int>(data[0].BaseFare,data[0].Tax)
                fInfant = arrayListOf<Int>(data[2].BaseFare,data[2].Tax)
            }
            else if((adultCount != 0) && (infantCount == 0) && (childCount != 0)) {
                fAdult = arrayListOf<Int>(data[0].BaseFare,data[0].Tax)
                fChild = arrayListOf<Int>(data[1].BaseFare,data[1].Tax)
            }
            else {
                fAdult = arrayListOf<Int>(data[0].BaseFare,data[0].Tax)
                fInfant = arrayListOf<Int>(data[2].BaseFare,data[2].Tax)
                fChild = arrayListOf<Int>(data[1].BaseFare,data[1].Tax)
                Log.d("myChild", "hitFareQuote: $fAdult $fInfant $fChild")
            }
        })
    }

    private fun hitTicket(tokenStr: String, traceIdStr: String,
                          resultIndexStr: String,passengerFullArray: ArrayList<Passenger>) {

        val dummySendTicketObj = SendTicketModel("192.168.11.58",
            passengerFullArray, null, resultIndexStr, tokenStr, traceIdStr)
        fareQuote.hitTicketViewModel(dummySendTicketObj)
        Log.d("onticket", "hitTicket: auto Hit Api Ticket")
        Log.d("timeZone", "check Responce: ${(arrayListPassanger)}")

        fareQuote.repoTicketLiveData.observe(this, {

            if(it.Response.ResponseStatus == 1 ){
                Log.d("onticket", "hitTicket: Got Responce Ticket")


                val intent = Intent(this,GetBookingDetailActivity::class.java)

                intent.putExtra("stToken",tokenStr)
                intent.putExtra("stPnr",it.Response.Response.PNR)
                intent.putExtra("stBookingId",it.Response.Response.BookingId)

                val bundle = Bundle()
                bundle.putString("tktToken",tokenStr)
                bundle.putString("tktTrace",traceIdStr)
                Log.d("timeZone", "hitTicket: ${Gson().toJson(arrayListPassanger)}")
                val intent = Intent(this,GetBookingDetailActivity::class.java)
                intent.putExtra("ticketBundle",bundle)

                startActivity(intent)
            }
            else{

                Log.d("onticket", "hitTicket:  Error ${it.Response.Error.ErrorMessage} ")
                Log.d("onticket", "hitTicket:  Error ${Gson().toJson(arrayListPassanger)}")
            }

        })
    }

    private fun adultPassangerSet(){

        arrAdult.add(passangerCountModel((fName.text.toString() +"-"+lName.text.toString()),R.drawable.edit))
        val customAdapter = passangerCountTicket(arrAdult,this)

        binding.lvAdultCount.adapter = customAdapter
        customAdapter.notifyDataSetChanged()
        Log.d("myChild", "adultPassangerSet: $fAdult")
        val f1 = Fare(0,0,fAdult[0],0,fAdult[1],0)
        val p1 = Passenger(addressString.text.toString(),addressString.text.toString(),city.text.toString(),contact.text.toString()

            ,countryCodeString,countryName.text.toString(), "1999-12-06T00:00:00",email.text.toString(),"6E",
            "123",f1,fName.text.toString(),genderString,true,lName.text.toString(),nationalityString,
            "2023-12-06T00:00:00","KJHHJKHKJH",1,titleString)

        arrayListPassanger.add(p1)
    }

    private fun childPassangerSet(){

        arrChild.add(passangerCountModel((fName.text.toString() +"-"+lName.text.toString()),R.drawable.edit))
        val customAdapter = passangerCountTicket(arrChild,this)
        binding.lvChildCount.adapter = customAdapter

        customAdapter.notifyDataSetChanged()
        Log.d("myChild", "childPassangerSet: $fChild $fAdult")
        val f3 = Fare(0,0,fChild[0],0,fChild[1],0)
        val p3 = Passenger(addressString.text.toString(),addressString.text.toString(),city.text.toString(),contact.text.toString(),

            countryCodeString,countryName.text.toString(),"2021-12-06T00:00:00",email.text.toString(),"6E",
            "123",f3,fName.text.toString(),genderString,true,lName.text.toString(),nationalityString,
            "2022-12-06T00:00:00","KJHHJKHKJH",1,titleString)

        arrayListPassanger.add(p3)
    }

    private fun infantPassangerSet(){

        arrInfant.add(passangerCountModel((fName.text.toString() +"-"+lName.text.toString()),R.drawable.edit))
        val customAdapter = passangerCountTicket(arr,this)
        binding.lvAdultCount.adapter = customAdapter
        customAdapter.notifyDataSetChanged()

        val f2 = Fare(0,0,fInfant[0],0,fInfant[1],0)
        val p2 = Passenger(addressString.text.toString(),addressString.text.toString(),city.text.toString(),contact.text.toString(),
            countryCodeString,countryName.text.toString(),"2015-12-06T00:00:00",email.text.toString(),"6E",
            "123",f2,fName.text.toString(),genderString,true,lName.text.toString(),nationalityString,
            "2022-12-06T00:00:00","KJHHJKHKJH",1,titleString)

        arrayListPassanger.add(p2)
    }
}