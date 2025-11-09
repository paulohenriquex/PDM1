package com.example.pdm_roteiropratico_11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment // OBRIGATÓRIO

// CRÍTICO: Deve herdar de Fragment e não ser uma classe vazia.
class CadastroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla o layout fragment_cadastro
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }
}