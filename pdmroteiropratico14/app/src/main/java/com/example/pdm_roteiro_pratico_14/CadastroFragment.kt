package com.example.pdm_roteiro_pratico_14

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment

// CadastroFragment.kt
class CadastroFragment : Fragment(R.layout.fragment_cadastro) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edtDesc = view.findViewById<EditText>(R.id.edtDescricao)
        val edtResp = view.findViewById<EditText>(R.id.edtResponsavel)
        val seekBar = view.findViewById<SeekBar>(R.id.seekBarStatus)
        val btnSalvar = view.findViewById<Button>(R.id.btnSalvar)
        val dbHelper = DatabaseHelper(requireContext())

        btnSalvar.setOnClickListener {
            val desc = edtDesc.text.toString()
            val resp = edtResp.text.toString()
            val status = seekBar.progress

            if (desc.isNotEmpty() && resp.isNotEmpty()) {
                val novaTarefa = Tarefa(descricao = desc, responsavel = resp, status = status)
                dbHelper.inserirTarefa(novaTarefa)

                Toast.makeText(context, "Tarefa Salva!", Toast.LENGTH_SHORT).show()
                edtDesc.text.clear()
                edtResp.text.clear()
                seekBar.progress = 0
            }
        }
    }
}