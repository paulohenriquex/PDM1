package com.example.pdm_roteiro_pratico_14

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaFragment : Fragment(R.layout.fragment_lista) {

    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewTarefas)
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onResume() {
        super.onResume()
        atualizarLista()
    }

    private fun atualizarLista() {
        val dbHelper = DatabaseHelper(requireContext())
        val lista = dbHelper.listarTarefas()

        val adapter = TarefaAdapter(lista) { tarefaClicada ->
            mostrarDialogEdicao(tarefaClicada)
        }
        recyclerView.adapter = adapter
    }

    private fun mostrarDialogEdicao(tarefa: Tarefa) {
        val dialog = EditarTarefaDialog(tarefa) {
            atualizarLista()
        }
        dialog.show(parentFragmentManager, "EditarTarefa")
    }
}