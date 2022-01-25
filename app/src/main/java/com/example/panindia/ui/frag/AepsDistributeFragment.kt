package com.example.panindia.ui.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.panindia.R
import com.example.panindia.adapter.adapterDistribute
import com.example.panindia.model.distributeAepsModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AepsDistributeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AepsDistributeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var lvDistrube :ListView
    lateinit var viewData :View

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
        viewData= inflater.inflate(R.layout.fragment_aeps_distribute, container, false)
        return viewData
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        populatingData()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun init(){
    lvDistrube = viewData.findViewById(R.id.lvDistribute)
    }
    private fun populatingData(){
        val arrayData = ArrayList<distributeAepsModel>()
        arrayData.add(distributeAepsModel("R008765","DIBYA SUNDAR SAHU","10"))
        arrayData.add(distributeAepsModel("R008765","DIBYA SUNDAR SAHU","6"))
        arrayData.add(distributeAepsModel("R008765","DIBYA SUNDAR SAHU","1"))
        val arrayListData = adapterDistribute(requireContext(),arrayData)
        lvDistrube.adapter = arrayListData
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AepsDistributeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}