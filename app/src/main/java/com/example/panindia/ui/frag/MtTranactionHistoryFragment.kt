package com.example.panindia.ui.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.panindia.adapter.adapterMtTransactionHistory
import com.example.panindia.databinding.FragmentMtTranactionHistoryBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MtTranactionHistoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
//    lateinit var tabLayout:TabLayout
//    lateinit var viewPager : ViewPager
     lateinit var binding : FragmentMtTranactionHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        init()
        setAdapterMtThree()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun init(){
//         tabLayout = binding.tl
//         viewPager = binding.vpMtTransactionThree
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMtTranactionHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MtTranactionHistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun setAdapterMtThree(){
        binding.vpMtTransactionThree.adapter = adapterMtTransactionHistory(requireActivity().supportFragmentManager)
        binding.tl.setupWithViewPager(binding.vpMtTransactionThree)
    }
}