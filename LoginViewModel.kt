package com.example.mobileapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> = _loginSuccess

    fun login(email: String, password: String) {
        // Lógica de validação (exemplo simplificado)
        _loginSuccess.value = email == "user@example.com" && password == "password"
    }

    fun signUp(email: String, password: String) {
        // Lógica de cadastro (pode adicionar lógica aqui)
        _loginSuccess.value = true
    }
}
