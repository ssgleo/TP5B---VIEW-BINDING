package com.example.mobileapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.mobileapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        // Carrega os dados do usuário
        viewModel.loadUserData()

        viewModel.userData.observe(this, Observer { user ->
            binding.etName.setText(user.name)
            binding.etEmail.setText(user.email)
            // Carrega a imagem de perfil com Coil
            binding.ivProfilePic.load(user.profileImageUrl)
        })

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            viewModel.saveUserData(name, email)
        }
    }
}
