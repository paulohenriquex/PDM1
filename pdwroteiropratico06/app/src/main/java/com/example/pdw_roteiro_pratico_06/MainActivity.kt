package com.example.pdw_roteiro_pratico_06

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referenciando os componentes da UI
        val etPeso = findViewById<EditText>(R.id.etPeso)
        val etAltura = findViewById<EditText>(R.id.etAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Configurando o listener para o botão
        btnCalcular.setOnClickListener {
            calcularImc(etPeso, etAltura, tvResultado)
        }
    }

    private fun calcularImc(etPeso: EditText, etAltura: EditText, tvResultado: TextView) {
        val pesoStr = etPeso.text.toString()
        val alturaStr = etAltura.text.toString()

        // Validação da entrada
        if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val peso = pesoStr.toDouble()
            val altura = alturaStr.toDouble()

            // Prevenindo divisão por zero
            if (altura == 0.0) {
                Toast.makeText(this, "A altura não pode ser zero.", Toast.LENGTH_SHORT).show()
                return
            }

            val imc = peso / (altura * altura)

            // Formatando o resultado para duas casas decimais
            val resultadoFinal = "Seu IMC é: %.2f".format(imc)

            // Determinando a classificação do IMC
            val classificacao = when {
                imc < 18.5 -> "Abaixo do peso"
                imc < 25.0 -> "Peso ideal (Parabéns!)"
                imc < 30.0 -> "Levemente acima do peso"
                imc < 35.0 -> "Obesidade grau I"
                imc < 40.0 -> "Obesidade grau II (severa)"
                else -> "Obesidade grau III (mórbida)"
            }

            // Exibindo o resultado final com o seu nome, como pedido
            tvResultado.text = "$resultadoFinal\n$classificacao\n\nCalculado por PH"

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Entrada inválida. Use apenas números.", Toast.LENGTH_SHORT).show()
        }
    }
}