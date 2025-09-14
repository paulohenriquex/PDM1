package com.example.pdm_roteiro_pratico_04


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    companion object {
        private const val TAG = "CicloDeVida"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        Log.d(TAG, "onCreate() chamado em MainActivity2 - Paulo Henrique Souza")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() chamado em MainActivity2 - Paulo Henrique Souza")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() chamado em MainActivity2 - Paulo Henrique Souza")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() chamado em MainActivity2 - Paulo Henrique Souza")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() chamado em MainActivity2 - Paulo Henrique Souza")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() chamado em MainActivity2 - Paulo Henrique Souza")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() chamado em MainActivity2 - Paulo Henrique Souza")
    }
}