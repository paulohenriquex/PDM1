package com.example.pdm_roteiro_pratico_12

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        val destino = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("destino", Destino::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("destino") as? Destino
        }

        if (destino != null) {
            val imagemDetalhe: ImageView = findViewById(R.id.imagem_detalhe)
            val nomeDetalhe: TextView = findViewById(R.id.nome_detalhe)
            val descricaoDetalhe: TextView = findViewById(R.id.descricao_detalhe)

            imagemDetalhe.setImageResource(destino.imagem)
            nomeDetalhe.text = destino.nome
            descricaoDetalhe.text = destino.descricao
        }
    }
}