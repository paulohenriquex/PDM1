package com.example.pdm_roteiropratico_11

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val nome = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    fun setNome(value: String) {
        nome.value = value
    }

    fun setEmail(value: String) {
        email.value = value
    }
}
