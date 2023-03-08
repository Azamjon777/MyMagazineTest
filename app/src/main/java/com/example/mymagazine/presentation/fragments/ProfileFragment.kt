package com.example.mymagazine.presentation.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mymagazine.databinding.FragmentProfileBinding
import com.example.mymagazine.presentation.RegisterContainerActivity

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
        binding.cardLogOut.setOnClickListener {
            val intent = Intent(requireActivity(), RegisterContainerActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }

    private fun loadData() {
        val shared = requireActivity().getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val savedName = shared.getString("FIRST_NAME", null)

        binding.myName.text = savedName.toString()
    }
}