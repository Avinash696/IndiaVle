package com.example.panindia.ui.activity.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.panindia.R
import com.example.panindia.databinding.FragmentHome2Binding
import com.example.panindia.ui.homeDrawable.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentHome2Binding

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
        binding = FragmentHome2Binding.inflate(inflater, container, false)
//        binding = FragmentHome2Binding.inflate(R.layout.fragment_home2, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.llPanCard.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    PanCardActivity::class.java
                )
            )
        }
        binding.llAeps.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    AepsActivity::class.java
                )
            )
        }
        binding.llMoneyTransfer.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    MoneyTransferActivity::class.java
                )
            )
        }
        binding.llbbps.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    BbpsActivity::class.java
                )
            )
        }
        binding.llflight.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    FlightActivity::class.java
                )
            )
        }
        binding.llRecharge.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    RechargeActivity::class.java
                )
            )
        }
        binding.llInsurance.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    InsuranceActivity::class.java
                )
            )
        }
        binding.llOthers.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    OthersActivity::class.java
                )
            )
        }
        binding.llothers2.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    OthersActivity::class.java
                )
            )
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    //not working
    override fun onClick(p0: View?) {
        when (p0) {
//           binding.llPanCard ->{ startActivity(Intent(requireContext(), PanCardActivity::class.java))}
//           R.id.llAeps ->{ startActivity(Intent(requireContext(), AepsActivity::class.java))}
//           R.id.llMoneyTransfer ->{ startActivity(Intent(requireContext(), MoneyTransferActivity::class.java))}
//           R.id.llbbps ->{startActivity(Intent(requireContext(), BbpsActivity::class.java))}
//           R.id.llflight ->{startActivity(Intent(requireContext(), FlightActivity::class.java))}
//           R.id.llRecharge ->{ startActivity(Intent(requireContext(), RechargeActivity::class.java))}
//           R.id.llInsurance ->{ startActivity(Intent(requireContext(), InsuranceActivity::class.java))}
//           R.id.llOthers ->{ startActivity(Intent(requireContext(), OthersActivity::class.java))}
//           R.id.llothers2 ->{ startActivity(Intent(requireContext(), OthersActivity::class.java))}
        }
    }
}