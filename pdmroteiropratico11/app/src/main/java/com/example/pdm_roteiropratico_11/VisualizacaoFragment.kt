package com.example.pdm_roteiropratico_11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment // 💡 ESTE IMPORT É OBRIGATÓRIO

// CRÍTICO: Deve herdar de Fragment para ser um Fragmento válido!
class VisualizacaoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla o layout específico para a aba de Visualização
        // (Certifique-se de que este layout XML exista e se chame fragment_visualizacao.xml)
        return inflater.inflate(R.layout.fragment_visualizacao, container, false)
    }
}