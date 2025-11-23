package com.example.pdm_roteiro_pratico_13

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit


class MainActivity : AppCompatActivity() {
    private var edtNota: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtNota = findViewById(R.id.edtNota)
        carregarAnotacao()
    }


    override fun onPause() {
        super.onPause()
        salvarAnotacao()
    }

    private fun carregarAnotacao() {
        val sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        val textoSalvo = sharedPreferences.getString(KEY_NOTA, "")
        edtNota?.setText(textoSalvo)
    }

    private fun salvarAnotacao() {
        val sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        sharedPreferences.edit {
            putString(KEY_NOTA, edtNota?.text.toString())
        }
    }

    companion object {
        private const val PREFS_NAME = "PreferenciasBlocoNotas"
        private const val KEY_NOTA = "anotacao_rapida"
    }
}