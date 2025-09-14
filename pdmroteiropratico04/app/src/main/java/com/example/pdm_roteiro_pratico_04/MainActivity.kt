package com.example.pdm_roteiro_pratico_04

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val TAG = "CicloDeVida"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate() chamado em MainActivity - Paulo Henrique Souza")

        val btnAbrirMain2: Button = findViewById(R.id.btn1)
        btnAbrirMain2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() chamado em MainActivity - Paulo Henrique Souza")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() chamado em MainActivity - Paulo Henrique Souza")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() chamado em MainActivity - Paulo Henrique Souza")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() chamado em MainActivity - Paulo Henrique Souza")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() chamado em MainActivity - Paulo Henrique Souza")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() chamado em MainActivity - Paulo Henrique Souza")
    }
}
