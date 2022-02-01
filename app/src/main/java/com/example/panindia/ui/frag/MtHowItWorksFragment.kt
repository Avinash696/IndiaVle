package com.example.panindia.ui.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.indiavle.ui.frag.viewlayout
import com.example.panindia.R
import com.example.panindia.databinding.FragmentMtHowItWorksBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
 class MtHowItWorksFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewLayout:View
    lateinit var binding :FragmentMtHowItWorksBinding
    lateinit var sp :Spinner

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
        binding =  FragmentMtHowItWorksBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        spinnerSet()
        super.onViewCreated(view, savedInstanceState)
    }
    fun spinnerSet(){
        val arrayList = ArrayList<String>()
        arrayList.add("NEFT")
        arrayList.add("IMPS")
        val arrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,arrayList)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spChoice.adapter = arrayAdapter
//
    //        val spinnerArrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item,)
    //        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    //
    //        val spinner = binding.spChoice
    //        spinner.adapter = spinnerArrayAdapter
    }

    fun init(){
//         sp = viewLayout.findViewById(R.id.spChoice)
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MtHowItWorksFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}