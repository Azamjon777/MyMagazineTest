package com.example.mymagazine.presentation.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mymagazine.MyViewModel
import com.example.mymagazine.R
import com.example.mymagazine.databinding.FragmentSignInBinding
import com.example.mymagazine.presentation.MainContainerActivity

class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding: FragmentSignInBinding
        get() = _binding ?: throw RuntimeException("FragmentSignInBinding == null")

    private val viewModel: MyViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
        )[MyViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginText.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_loginFragment)
        }

        binding.btnSignIn.setOnClickListener {
            validAccount()
        }
    }

    private fun validAccount() {
        val email = binding.etEmail.text.toString()
        val name = binding.etFirstName.text.toString()
        if (viewModel.isEmailValid(email) && viewModel.validName(name)) {
            val shared = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val savedName = shared.getString("FIRST_NAME", null)
            if (name == savedName) {
                val intent = Intent(requireActivity(), MainContainerActivity::class.java)
                //снизу задаем флаг, то что мы будем закрывать за собой активити
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            } else {
                binding.etFirstName.error = getString(R.string.enter_correct_name)
            }
        } else {
            binding.etEmail.error = getString(R.string.fill_correct)
        }
    }
}