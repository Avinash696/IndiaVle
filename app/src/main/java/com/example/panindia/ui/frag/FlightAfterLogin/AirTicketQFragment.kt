package com.example.panindia.ui.frag.FlightAfterLogin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.indiavle.ui.frag.viewlayout
import com.example.panindia.R
import com.example.panindia.adapter.adapterAirTicketQ
import com.example.panindia.adapter.adapterSummary
import com.example.panindia.databinding.FragmentAirTicketQBinding
import com.example.panindia.model.airTicketQModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AirTicketQFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AirTicketQFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var lv: ListView
    private lateinit var viewLayout :View
    lateinit var binding :FragmentAirTicketQBinding

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
        binding = FragmentAirTicketQBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AirTicketQFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        lv = viewLayout.findViewById(R.id.lvAirTicketQ)
        populatingData()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun populatingData(){
        val arrayData = ArrayList<airTicketQModel>()
        arrayData.add(airTicketQModel("PNR : G8-OC18KA","Sectors : DEL - BOM","Booking Date : 01 Feb 21 6:04 PM","Ticket Date : 01 Feb 21 6:04 PM",
                        "Travel Date : 10 Feb 21 8:04 AM","Customer Price : 3276.00","Currency : INR ",
                        "Pay Mode : Cash ","OC18KA","MR. Kumar (ATD)","Normal Color View PDF"))
        arrayData.add(airTicketQModel("PNR : G8-OC18KA","Sectors : DEL - BOM","Booking Date : 01 Feb 21 6:04 PM","Ticket Date : 01 Feb 21 6:04 PM",
            "Travel Date : 10 Feb 21 8:04 AM","Customer Price : 3276.00","Currency : INR ",
            "Pay Mode : Cash ","OC18KA","MR. Kumar (ATD)","Normal Color View PDF"))

        val arrayAdapter = adapterAirTicketQ(requireContext(),arrayData)
       binding.lvAirTicketQ.adapter = arrayAdapter
    }
}