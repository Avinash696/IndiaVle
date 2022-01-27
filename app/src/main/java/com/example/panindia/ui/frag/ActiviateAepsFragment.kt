package com.example.panindia.ui.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.panindia.R
import com.example.panindia.adapter.adapterApesActivate
import com.example.panindia.databinding.FragmentActiviateAepsBinding
import com.example.panindia.databinding.FragmentApesBinding
import com.example.panindia.model.apesDetailList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ActiviateAepsFragment : Fragment() {
    lateinit var binding :FragmentActiviateAepsBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        binding = FragmentActiviateAepsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        populating()
        populatingValue()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun populating(){
//        val arrayData = ArrayList<apesDetailList>()
//        arrayData.add(apesDetailList(200,10,10,5))
//        val arrayDataAdapter = adapterApesActivate(requireContext(),arrayData)
//        binding.lvActivateAeps.adapter = arrayDataAdapter

    }
    private fun populatingValue(){
        binding.tvActivateCost.text = "200"
        binding.tvActivated.text = "200"
        binding.tvBooked.text = "200"
        binding.tvIDLeft.text = "200"
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ActiviateAepsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}