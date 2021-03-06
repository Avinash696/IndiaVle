package com.example.panindia.ui.frag

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.panindia.adapter.adapterApesHistoryEntry

import com.example.panindia.databinding.FragmentTransitionHistoryBinding
import com.example.panindia.model.TranHistoryModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
 const val  TAG ="###"

class TransitionHistoryFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var rvTranHistory:RecyclerView
    lateinit var binding:FragmentTransitionHistoryBinding

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
//        return inflater.inflate(R.layout.fragment_transition_history, container, false)
        binding = FragmentTransitionHistoryBinding.inflate(inflater,container,false)
        return binding.root
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TransitionHistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun init(){
        rvTranHistory = binding.rvTranHistory
        populatingData()
    }
    private fun  populatingData(){
        val arrayData = ArrayList<TranHistoryModel>()
        Log.d(TAG, "populatingData: ")
        arrayData.add(TranHistoryModel("24/12/2020 12:00:00","1028364534373848 Shubham Kumar"))
        arrayData.add(TranHistoryModel("24/12/2020 12:00:00","1028364534373848 Shubham Kumar"))
        arrayData.add(TranHistoryModel("24/12/2020 12:00:00","1028364534373848 Shubham Kumar"))
        arrayData.add(TranHistoryModel("24/12/2020 12:00:00","1028364534373848 Shubham Kumar"))
        arrayData.add(TranHistoryModel("24/12/2020 12:00:00","1028364534373848 Shubham Kumar"))
   //adapter set
        val apesAdapter = adapterApesHistoryEntry(arrayData,requireContext())
        binding.rvTranHistory.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTranHistory.adapter =apesAdapter
        apesAdapter.notifyDataSetChanged()
        Log.d(TAG, "setAdapter: ")
    }
}