package com.example.pdm_roteiro_pratico_14

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TarefaAdapter(
    private val listaTarefas: List<Tarefa>,
    private val onClick: (Tarefa) -> Unit
) : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    inner class TarefaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtDesc = view.findViewById<TextView>(R.id.txtDescricao)
        val txtResp = view.findViewById<TextView>(R.id.txtResponsavel)
        val progress = view.findViewById<ProgressBar>(R.id.progressBarItem)

        fun bind(tarefa: Tarefa) {
            txtDesc.text = tarefa.descricao
            txtResp.text = "Resp: ${tarefa.responsavel}"
            progress.progress = tarefa.status

            itemView.setOnClickListener { onClick(tarefa) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefa, parent, false)
        return TarefaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        holder.bind(listaTarefas[position])
    }

    override fun getItemCount() = listaTarefas.size
}