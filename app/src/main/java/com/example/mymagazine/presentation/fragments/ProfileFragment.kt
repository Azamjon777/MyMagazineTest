package com.example.mymagazine.presentation.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
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

    private var imageUri: Uri? = null


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

        binding.textChangePhoto.setOnClickListener {
//            val intent = Intent(Intent.ACTION_GET_CONTENT)
//            intent.type = "image/*"
//            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)

            val galleryIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            imageUri = data.data
            // Далее вы можете сделать что-то с изображением
            if (imageUri != null) {
                binding.profileImg.setImageURI(imageUri)
            }
        }
    }

    private fun loadData() {
        val shared = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedName = shared.getString("FIRST_NAME", null)
        binding.myName.text = savedName.toString()
    }

    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }

}