package com.example.acherois

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast

class Perguntas : AppCompatActivity() {

    private lateinit var radioGroupMotivacao: RadioGroup
    private lateinit var radioGroupPoder: RadioGroup
    private lateinit var radioGroupCaracteristica: RadioGroup
    private lateinit var radioGroupAcao: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas)

        radioGroupMotivacao = findViewById(R.id.radioGroupMotivacao)
        radioGroupPoder = findViewById(R.id.radioGroupPoder)
        radioGroupCaracteristica = findViewById(R.id.radioGroupCaracteristica)
        radioGroupAcao = findViewById(R.id.radioGroupAcao)
        val buttonFinalizarPerguntas = findViewById<Button>(R.id.buttonFinalizarPerguntas)

        buttonFinalizarPerguntas.setOnClickListener {
            val respostaMotivacaoId = radioGroupMotivacao.checkedRadioButtonId
            val respostaPoderId = radioGroupPoder.checkedRadioButtonId
            val respostaCaracteristicaId = radioGroupCaracteristica.checkedRadioButtonId
            val respostaAcaoId = radioGroupAcao.checkedRadioButtonId

            if (respostaMotivacaoId != -1 && respostaPoderId != -1 && respostaCaracteristicaId != -1 && respostaAcaoId != -1) {
                val respostaMotivacao = findViewById<android.widget.RadioButton>(respostaMotivacaoId).text.toString()
                val respostaPoder = findViewById<android.widget.RadioButton>(respostaPoderId).text.toString()
                val respostaCaracteristica = findViewById<android.widget.RadioButton>(respostaCaracteristicaId).text.toString()
                val respostaAcao = findViewById<android.widget.RadioButton>(respostaAcaoId).text.toString()

                val intent = Intent(this, Resultados::class.java)

                intent.putExtra("motivacao", respostaMotivacao)
                intent.putExtra("poder", respostaPoder)
                intent.putExtra("caracteristica", respostaCaracteristica)
                intent.putExtra("acao", respostaAcao)

                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, responda todas as perguntas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}