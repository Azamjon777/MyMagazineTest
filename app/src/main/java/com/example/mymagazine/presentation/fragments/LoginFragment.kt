package com.example.mymagazine.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mymagazine.MyViewModel
import com.example.mymagazine.R
import com.example.mymagazine.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding ?: throw RuntimeException("FragmentLoginBinding == null")

    private var isShowPass = false


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
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clicks()
    }

    private fun clicks() {
        binding.visibleTrue.setOnClickListener {
            isShowPass = !isShowPass
            showPassword(isShowPass)
        }
        showPassword(isShowPass)

        binding.btnLogin.setOnClickListener {
            val name = binding.etFirstNameLogin.text.toString()
            val password = binding.etPassword.text.toString()
            if (viewModel.validatePassword(name, password)) {
               /* val intent = Intent(requireActivity(), ProfileActivity::class.java)
                //снизу задаем флаг, то что мы будем закрывать за собой активити
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)*/
            }
        }
    }

    private fun showPassword(isShow: Boolean) {
        if (isShow) {
            binding.etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.visibleTrue.setImageResource(R.drawable.ic_eye_off)
        } else {
            binding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.visibleTrue.setImageResource(R.drawable.ic_eye_enable)
        }
        binding.etPassword.setSelection(binding.etPassword.text.toString().length)
    }
}