package com.example.mymagazine.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.mymagazine.R
import com.example.mymagazine.databinding.FragmentPage1Binding
import com.example.mymagazine.presentation.MyViewModel
import com.example.mymagazine.presentation.adapter.AdapterFlashSale
import com.example.mymagazine.presentation.adapter.AdapterLatest
import kotlinx.coroutines.launch


class Page1Fragment : Fragment(), AdapterFlashSale.Listener {
    private var _binding: FragmentPage1Binding? = null
    private val binding: FragmentPage1Binding
        get() = _binding ?: throw RuntimeException("FragmentPage1Binding == null")

    private lateinit var recyclerViewLatest: RecyclerView
    private lateinit var recyclerViewFlashSale: RecyclerView
    private lateinit var myAdapterLatest: AdapterLatest
    private lateinit var myAdapterFlash: AdapterFlashSale

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val viewModel = ViewModelProvider(requireActivity())[MyViewModel::class.java]
        _binding = FragmentPage1Binding.inflate(inflater, container, false)

        recyclerViewLatest = binding.recyclerLatest
        recyclerViewFlashSale = binding.recyclerFlashSale

        myAdapterLatest = AdapterLatest(requireActivity())
        myAdapterFlash = AdapterFlashSale(requireActivity(), this)

        recyclerViewLatest.adapter = myAdapterLatest
        recyclerViewFlashSale.adapter = myAdapterFlash

        lifecycleScope.launch {
            viewModel.getLatestList()
            viewModel.getFlashSaleList()
        }

        viewModel.myLatestList.observe(viewLifecycleOwner) {
            myAdapterLatest.setListLatest(it.latest)
        }

        viewModel.myFlashSaleList.observe(viewLifecycleOwner) {
            myAdapterFlash.setFlashList(it.flash_sale)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressBar.visibility = View.VISIBLE
        binding.accountImg.setOnClickListener {
            val profileFragment = ProfileFragment()
            requireActivity().supportFragmentManager.popBackStack()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container_main_fragments, profileFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onClick(flashItem: com.example.mymagazine.domain.models.FlashSaleItemD) {

        //этот клик так для себя
        val page2Fragment = Page2Fragment()

        val args = Bundle().apply {
            putString("category", flashItem.category)
            putString("image_url", flashItem.image_url)
            putString("name", flashItem.name)
            putString("discount", flashItem.discount.toString())
            putString("price", flashItem.price.toString())
        }
        page2Fragment.arguments = args

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container_main_fragments, page2Fragment)
            .addToBackStack(null)
            .commit()
    }
}