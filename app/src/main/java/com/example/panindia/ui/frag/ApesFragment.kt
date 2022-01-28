package com.example.panindia.ui.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.panindia.R
import com.example.panindia.databinding.FragmentApesBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
    
class ApesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentApesBinding
    lateinit var miniStatement: Spinner

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
        binding = FragmentApesBinding.inflate(inflater, container, false)
        return binding.root
    }
    private fun init() {
        miniStatement = binding.spMiniStaement
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        adapterSet()
        super.onViewCreated(view, savedInstanceState)
    }

    fun adapterSet() {
        val service = arrayOf("Mini Statement", "Balance Enquiry", "Cash Withdrawal")
        var spAdapter: ArrayAdapter<String> =
            ArrayAdapter(requireContext(), R.layout.text_center, service)
        spAdapter.setDropDownViewResource(R.layout.text_center)

        //setadapter
        binding.spMiniStaement.adapter = spAdapter
        binding.spDeviceType.adapter = spAdapter
        binding.spType.adapter = spAdapter
        binding.spSelectBank.adapter = spAdapter
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ApesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}