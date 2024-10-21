package com.example.mobileapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    private val _userData = MutableLiveData<User>()
    val userData: LiveData<User> = _userData

    fun loadUserData() {
        // Simulação de carregamento de dados de um repositório
        _userData.value = User("John Doe", "john@example.com", "https://example.com/profile.jpg")
    }

    fun saveUserData(name: String, email: String) {
        // Salvar informações editadas
        _userData.value = _userData.value?.copy(name = name, email = email)
    }
}
