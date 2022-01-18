package com.example.panindia.ui.activity.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.panindia.R
import com.example.panindia.adapter.joiningAdapter
import com.example.panindia.databinding.ActivityJoiningListBinding
import com.example.panindia.databinding.FragmentHome2Binding
import com.example.panindia.model.joiningModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [JoiningFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class JoiningFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : ActivityJoiningListBinding

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
        binding = ActivityJoiningListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populatingData()
    }
    fun populatingData(){
        var arrayList = ArrayList<joiningModel>()
//        arrayList.add(adminModel("Create Admin", R.drawable.admin_icon))
//        arrayList.add(adminModel("Create Super Distributer", R.drawable.admin_icon))
//        arrayList.add(adminModel("Create Distributer", R.drawable.admin_icon))
//        arrayList.add(adminModel("Create Retailer", R.drawable.admin_icon))
        arrayList.add(joiningModel("Dibya",1))
        arrayList.add(joiningModel("Dibya",2))
        arrayList.add(joiningModel("Dibya",3))
        arrayList.add(joiningModel("Dibya",4))
        //set adapter
        val adminHome = joiningAdapter(requireContext(),arrayList)
        binding?.lvJoining?.adapter =adminHome
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment JoiningFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            JoiningFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}