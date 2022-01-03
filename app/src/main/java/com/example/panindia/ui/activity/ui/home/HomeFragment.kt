package com.example.panindia.ui.activity.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.panindia.R
import com.example.panindia.adapter.AdminHomeAdpter
import com.example.panindia.databinding.FragmentHomeBinding
import com.example.panindia.model.adminModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }
    fun populatingData(){
        var arrayList = ArrayList<adminModel>()
//        arrayList.add(adminModel("Create Admin", R.drawable.admin_icon))
//        arrayList.add(adminModel("Create Super Distributer", R.drawable.admin_icon))
//        arrayList.add(adminModel("Create Distributer", R.drawable.admin_icon))
//        arrayList.add(adminModel("Create Retailer", R.drawable.admin_icon))
        arrayList.add(adminModel("Home  Page", R.drawable.admin_icon))
        //set adapter
        val adminHome = AdminHomeAdpter(requireContext(),arrayList)
        _binding?.lvAdmin?.adapter =adminHome
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        populatingData()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}