package com.example.mymagazine.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.mymagazine.R
import com.example.mymagazine.data.serviceApi
import com.example.mymagazine.databinding.FragmentPage1Binding
import kotlinx.coroutines.launch

class Page1Fragment : Fragment() {
    private var _binding: FragmentPage1Binding? = null
    private val binding: FragmentPage1Binding
        get() = _binding ?: throw RuntimeException("FragmentPage1Binding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            initializeLatest()
        }
        initializeFlashSale()
    }

    private fun initializeFlashSale() {

        Glide.with(this)
            .load("https://newbalance.ru/upload/iblock/697/iz997hht_nb_02_i.jpg")
            .into(binding.itemImgFlash1)

        Glide.with(this)
            .load("https://assets.reebok.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/3613ebaf6ed24a609818ac63000250a3_9366/Classic_Leather_Shoes_-_Toddler_White_FZ2093_01_standard.jpg")
            .into(binding.itemImgFlash2)

        Glide.with(this)
            .load("https://newbalance.ru/upload/iblock/697/iz997hht_nb_02_i.jpg")
            .into(binding.itemImgFlash3)
    }

    private suspend fun initializeLatest() {
        val products = serviceApi.getListLatestProductsSimple()
        binding.itemProductNameLatest1.text = products.name
        binding.itemCategoryLatest1.text = products.category
        binding.itemPriceOfModelLatest1.text = products.price.toString()


//        val product2 = products.modelLatest[1]
//        val product3 = products.modelLatest[2]
//        val product4 = products.modelLatest[3]

//        binding.itemProductNameLatest1.text = product1.name
//        binding.itemPriceOfModelLatest1.text = product1.price.toString()
//        binding.itemCategoryLatest1.text = product1.category
//
//        binding.itemProductNameLatest2.text = product2.name
//        binding.itemPriceOfModelLatest2.text = product2.price.toString()
//        binding.itemCategoryLatest2.text = product2.category
//
//        binding.itemProductNameLatest3.text = product3.name
//        binding.itemPriceOfModelLatest3.text = product3.price.toString()
//        binding.itemCategoryLatest3.text = product3.category
//
//        binding.itemProductNameLatest4.text = product4.name
//        binding.itemPriceOfModelLatest4.text = product4.price.toString()
//        binding.itemCategoryLatest4.text = product4.category


        Glide.with(this)
            .load("https://www.dhresource.com/0x0/f2/albu/g8/M01/9D/19/rBVaV1079WeAEW-AAARn9m_Dmh0487.jpg")
            .into(binding.itemImgLatest1)

        Glide.with(this)
            .load("https://avatars.mds.yandex.net/get-mpic/6251774/img_id4273297770790914968.jpeg/orig")
            .into(binding.itemImgLatest2)

        Glide.with(this)
            .load("https://www.tradeinn.com/f/13754/137546834/microsoft-xbox-xbox-one-s-1tb-console-additional-controller.jpg")
            .into(binding.itemImgLatest3)

        Glide.with(this)
            .load("https://mirbmw.ru/wp-content/uploads/2022/01/manhart-mhx6-700-01.jpg")
            .into(binding.itemImgLatest4)
    }
}