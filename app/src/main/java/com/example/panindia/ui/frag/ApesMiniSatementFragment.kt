package com.example.panindia.ui.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import com.example.panindia.R
import com.example.panindia.adapter.adapterFullListMini
import com.example.panindia.adapter.adapterMini
import com.example.panindia.databinding.FragmentApesMiniSatementBinding

import com.example.panindia.model.ApesMiniStatementModel
import com.example.panindia.model.miniStatementListModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ApesMiniSatementFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : FragmentApesMiniSatementBinding

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
        binding = FragmentApesMiniSatementBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        populatingDate()
        populatingListData()
        super.onViewCreated(view, savedInstanceState)
    }
    private  fun init(){

    }
    private fun populatingDate(){
        val arrayList = ArrayList<ApesMiniStatementModel>()
        arrayList.add(ApesMiniStatementModel("Available Balance","Rs. 6000.32","20 April 2021 : 05:00:00"))
        arrayList.add(ApesMiniStatementModel("Bank Name","State Bank Of India",""))
        arrayList.add(ApesMiniStatementModel("Transaction Id","230883648493908373",""))
        arrayList.add(ApesMiniStatementModel("Aadhaar Number / VID","**********9867",""))

        val miniAdapter = adapterMini(requireContext(),arrayList)
        binding.gvMiniStatement.adapter = miniAdapter
    }
    private fun populatingListData(){
        val arrayList = ArrayList<miniStatementListModel>()
        arrayList.add(miniStatementListModel("1","20-09-2022","Debit","To Transfer 0000000009753","- Rs 300.00"))
        arrayList.add(miniStatementListModel("2","20-09-2022","Credit  ","To Transfer 0000000009753","+Rs 200.00"))
        val miniData = adapterFullListMini(requireContext(),arrayList)
        binding.lvListMini.adapter = miniData
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ApesMiniSatementFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}