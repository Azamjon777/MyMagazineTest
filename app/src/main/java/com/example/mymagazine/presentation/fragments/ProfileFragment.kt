package com.example.mymagazine.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mymagazine.R
import com.example.mymagazine.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding
        get() = _binding ?: throw RuntimeException("FragmentProfileBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()

        clicks()
    }

    private fun clicks() {
        binding.bottomNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> {}
                R.id.ic_balans -> {}
                R.id.ic_shops -> {}
                R.id.ic_chat -> {}
                R.id.ic_profile -> {}
            }
            true
        }
    }

    private fun loadData() {
        val shared = requireActivity().getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val savedName = shared.getString("FIRST_NAME", null)

        binding.myName.text = savedName.toString()
    }
}