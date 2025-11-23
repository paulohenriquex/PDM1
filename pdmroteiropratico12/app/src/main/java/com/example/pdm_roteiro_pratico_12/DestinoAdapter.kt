package com.example.pdm_roteiro_pratico_12

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class DestinoAdapter(private val context: Context, private val destinos: List<Destino>) : BaseAdapter() {

    override fun getCount(): Int {
        return destinos.size
    }

    override fun getItem(position: Int): Any {
        return destinos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_destino, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val destino = getItem(position) as Destino
        viewHolder.nomeDestino.text = destino.nome
        viewHolder.imagemDestino.setImageResource(destino.imagem)

        return view
    }

    private class ViewHolder(view: View) {
        val nomeDestino: TextView = view.findViewById(R.id.nome_destino)
        val imagemDestino: ImageView = view.findViewById(R.id.imagem_destino)
    }
}