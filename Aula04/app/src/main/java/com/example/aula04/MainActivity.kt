package com.example.aula04

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etNome = findViewById<EditText>(R.id.etNomeUsuario)
        val btnEntrar = findViewById<Button>(R.id.btnSalvar)
        val tvMensagem = findViewById<TextView>(R.id.tvMensagem)
        val ivAvatar = findViewById<ImageView>(R.id.ivAvatar)

        btnEntrar.setOnClickListener {
            val nome = etNome.text.toString()
            val mensagemBoasVindas = "Olá, $nome!"
            tvMensagem.text = mensagemBoasVindas
            ivAvatar.setImageResource(R.drawable.img4)

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}