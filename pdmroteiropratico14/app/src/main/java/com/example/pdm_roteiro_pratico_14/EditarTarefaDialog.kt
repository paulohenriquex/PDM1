package com.example.pdm_roteiro_pratico_14

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class EditarTarefaDialog(
    private val tarefa: Tarefa,
    private val aoSalvarOuExcluir: () -> Unit
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val view = layoutInflater.inflate(R.layout.dialog_editar, null)

        val edtDesc = view.findViewById<EditText>(R.id.edtEditDesc)
        val edtResp = view.findViewById<EditText>(R.id.edtEditResp)
        val seekBar = view.findViewById<SeekBar>(R.id.seekEditStatus)

        edtDesc.setText(tarefa.descricao)
        edtResp.setText(tarefa.responsavel)
        seekBar.progress = tarefa.status

        builder.setView(view)
            .setTitle("Editar Tarefa")
            .setPositiveButton("Atualizar") { _, _ ->
                val dbHelper = DatabaseHelper(requireContext())
                tarefa.descricao = edtDesc.text.toString()
                tarefa.responsavel = edtResp.text.toString()
                tarefa.status = seekBar.progress

                dbHelper.atualizarTarefa(tarefa)
                aoSalvarOuExcluir()
            }
            .setNeutralButton("Excluir") { _, _ ->
                val dbHelper = DatabaseHelper(requireContext())
                dbHelper.deletarTarefa(tarefa.id)
                aoSalvarOuExcluir()
            }
            .setNegativeButton("Cancelar", null)

        return builder.create()
    }
}