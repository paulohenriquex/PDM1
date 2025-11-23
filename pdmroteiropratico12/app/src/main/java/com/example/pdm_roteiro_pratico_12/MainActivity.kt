package com.example.pdm_roteiro_pratico_12

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val destinosListView: ListView = findViewById(R.id.destinos_list_view)

        val destinos = listOf(
            Destino("Paris", R.drawable.paris, "A cidade do amor, com a Torre Eiffel e o Museu do Louvre."),
            Destino("Tóquio", R.drawable.tokyo, "A vibrante capital do Japão, onde o tradicional encontra o moderno."),
            Destino("Rio de Janeiro", R.drawable.rio_de_janeiro, "Famoso pelo Cristo Redentor, Pão de Açúcar e suas praias deslumbrantes."),
            Destino("Roma", R.drawable.roma, "Um mergulho na história antiga, com o Coliseu, Fórum Romano e Vaticano."),
            Destino("Cairo", R.drawable.cairo, "Lar das Pirâmides de Gizé e da Esfinge, um portal para o Egito antigo."),
            Destino("Sydney", R.drawable.sydney, "Conhecida por sua Opera House e a Harbour Bridge.")
        )

        val adapter = DestinoAdapter(this, destinos)
        destinosListView.adapter = adapter

        destinosListView.setOnItemClickListener { _, _, position, _ ->
            val destinoSelecionado = destinos[position]
            val intent = Intent(this, DetalheActivity::class.java)
            intent.putExtra("destino", destinoSelecionado)
            startActivity(intent)
        }
    }
}