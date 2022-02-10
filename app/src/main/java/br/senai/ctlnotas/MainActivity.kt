package br.senai.ctlnotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calular = findViewById<Button>(R.id.calcular)
        val sair    = findViewById<Button>(R.id.sair)

        sair.setOnClickListener {
            finish()
        }

        calular.setOnClickListener {
            val notaOne   = findViewById<EditText>(R.id.nota1).text.toString().toInt()
            val notaTwo   = findViewById<EditText>(R.id.nota2).text.toString().toInt()
            val faltas    = findViewById<EditText>(R.id.faltas).text.toString().toInt()
            val resultado = findViewById<TextView>(R.id.resultado)
            val media     = ((notaOne + notaTwo) / 2)

            val msgNota1  = findViewById<TextView>(R.id.msgNota1)
            val msgNota2  = findViewById<TextView>(R.id.msgNota2)
            val msgFaltas = findViewById<TextView>(R.id.msgFaltas)
            val msgMedia  = findViewById<TextView>(R.id.msgMedia)

            msgNota1.text   = "Nota 1: ${notaOne}"
            msgNota2.text   = "Nota 2: ${notaTwo}"
            msgFaltas.text  = "Faltas: ${faltas}"
            msgMedia.text   = "Media:  ${media}"

            if(media >= 5) {
                resultado.text = "Aprovado";
                resultado.setTextColor(Color.GREEN)
            } else {
                resultado.text = "Reprovada";
                resultado.setTextColor(Color.RED)
            }
        }
    }
}