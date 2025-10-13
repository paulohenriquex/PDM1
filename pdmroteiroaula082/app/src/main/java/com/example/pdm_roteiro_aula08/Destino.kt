package com.example.pdm_roteiro_aula08

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Destino : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destino)

        val destino = intent.getStringExtra("destino")
        val textViewDestino = findViewById<TextView>(R.id.textViewDestino)
        textViewDestino.text = "Destino: $destino"

        val btnVerMapa = findViewById<Button>(R.id.btnVerMapa)
        val btnPesquisarVoos = findViewById<Button>(R.id.btnPesquisarVoos)
        val btnVerFotos = findViewById<Button>(R.id.btnVerFotos)
        val btnPartilhar = findViewById<Button>(R.id.btnPartilhar)

        btnVerMapa.setOnClickListener {
            val uri = Uri.parse("geo:0,0?q=$destino")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnPesquisarVoos.setOnClickListener {
            val uri = Uri.parse("https://www.google.com/search?q=voos+para+$destino")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnVerFotos.setOnClickListener {
            val uri = Uri.parse("https://www.google.com/search?q=$destino&tbm=isch")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnPartilhar.setOnClickListener {
            val textoCompartilhar = "Estou a planear uma viagem para $destino!"
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, textoCompartilhar)
            }
            startActivity(Intent.createChooser(intent, "Partilhar destino..."))
        }
    }
}