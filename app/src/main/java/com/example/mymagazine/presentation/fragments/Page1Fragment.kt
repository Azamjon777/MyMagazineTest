package com.example.mymagazine.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.mymagazine.MyViewModel
import com.example.mymagazine.databinding.FragmentPage1Binding
import com.example.mymagazine.presentation.adapter.AdapterFlashLatest
import com.example.mymagazine.presentation.adapter.AdapterLatest
import kotlinx.coroutines.launch

class Page1Fragment : Fragment() {
    private var _binding: FragmentPage1Binding? = null
    private val binding: FragmentPage1Binding
        get() = _binding ?: throw RuntimeException("FragmentPage1Binding == null")

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapterLatest: AdapterLatest
    private lateinit var myAdapterFlash: AdapterFlashLatest

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val viewModel = ViewModelProvider(requireActivity())[MyViewModel::class.java]
        _binding = FragmentPage1Binding.inflate(inflater, container, false)
        recyclerView = binding.recyclerLatest
        myAdapterLatest = AdapterLatest(requireActivity())
        recyclerView.adapter = myAdapterLatest
        lifecycleScope.launch {
            viewModel.getLatestList()
            viewModel.getFlashSaleList()
        }
        viewModel.myLatestList.observe(viewLifecycleOwner) {
            myAdapterLatest.setListLatest(it.body()!!.latest)
        }

        viewModel.myFlashSaleList.observe(viewLifecycleOwner) {
            myAdapterFlash.setFlashList(it.body()!!.flash_sale)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}