package com.example.indiavle.ui.frag

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import com.example.panindia.R
import com.example.panindia.databinding.FragmentOneWayBinding
import android.widget.ArrayAdapter




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OneWayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OneWayFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding :FragmentOneWayBinding
    lateinit var viewlayout :View
//    lateinit var spinnerPassanger :Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        var items = arrayOf("1", "2", "3")

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
        viewlayout =inflater.inflate(R.layout.fragment_one_way, container, false)
//        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerPassanger)
//        if(spinnerPassanger != null ){
//            val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, spinnerPassanger)
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            spinnerPassanger.adapter = adapter;
//        }

        return  viewlayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        super.onViewCreated(view, savedInstanceState)
    }
    fun init(){
//        spinnerPassanger =  viewlayout.findViewById(R.id.spPassangers)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OneWayFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OneWayFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}