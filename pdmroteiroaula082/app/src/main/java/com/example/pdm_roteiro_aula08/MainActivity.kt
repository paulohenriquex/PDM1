package com.example.pdm_roteiro_aula08

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextDestino = findViewById<EditText>(R.id.editTextDestino)
        val btnPlanejarViagem = findViewById<Button>(R.id.btnPlanejarViagem)

        btnPlanejarViagem.setOnClickListener {
            val destino = editTextDestino.text.toString()
            val intent = Intent(this, Destino::class.java).apply {
                putExtra("destino", destino)
            }
            startActivity(intent)
        }
    }
}