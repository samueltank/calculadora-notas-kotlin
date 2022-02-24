package br.senai.ctlnotas

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    private lateinit var nomeEditText: EditText;    // Global Scope run later : lateinit var
    private lateinit var nota1EditText: EditText;   // Global Scope
    private lateinit var nota2EditText: EditText;   // Global Scope

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val calcular = findViewById<Button>(R.id.calcular);
        val sair     = findViewById<Button>(R.id.sair);

        sair.setOnClickListener {finish()}

        calcular.setOnClickListener {
            nota1EditText         = findViewById(R.id.nota1);
            nota2EditText         = findViewById(R.id.nota2);
            nomeEditText          = findViewById(R.id.Nome);
            val resultTextView    = findViewById<TextView>(R.id.resultado);

            if (validate()) {
                var nota1 = convertToStringToInt(nota1EditText);
                var nota2 = convertToStringToInt(nota2EditText);
                val media = calcMedia(nota1, nota2, 10, 10, 10);

                val intent = Intent(this, RelatorioActivity::class.java);

                intent.putExtra("nome", nomeEditText.text.toString());
                intent.putExtra("nota1", nota1.toString())
                intent.putExtra("nota2", nota2.toString())
                intent.putExtra("media", media.toString())
                intent.putExtra("situacao", alunoStatus(media))

                startActivity(intent);

//                val msgNota1   = findViewById<TextView>(R.id.msgNota1)
//                val msgNota2   = findViewById<TextView>(R.id.msgNota2)
//                val msgName    = findViewById<TextView>(R.id.msgName)
//                val msgMedia   = findViewById<TextView>(R.id.msgMedia)
//
//                msgName.text    = "Nome: ${nomeEditText.text}"
//                msgNota1.text   = "Nota 1: ${nota1}";
//                msgNota2.text   = "Nota 2: ${nota2}";
//                msgMedia.text   = "Media:  ${media}";
//
//                resultTextView.text = alunoStatus(media);
            }
        }
    }


    private fun validate() : Boolean
    {
        var noError = true;
        if (nomeEditText.text.isBlank())
        {
            nomeEditText.setError("Digite o seu nome");
            noError = false;
        }

        if (nota1EditText.text.isBlank())
        {
            nota1EditText.setError("Digite sua nota 1");
            noError = false;
        }

        if (nota1EditText.text.isBlank())
        {
            nota2EditText.setError("Digite sua nota 2");
            noError = false;
        }

        return noError;
    }

    private fun convertToStringToInt(variable: EditText) : Int
    {
        val vari = variable.text.toString().toInt();
        return vari;
    }
}