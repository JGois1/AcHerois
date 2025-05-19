package com.example.acherois

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Resultados : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)
        val textViewNomeHeroi = findViewById<TextView>(R.id.textViewNomeHeroi)
        val imageViewHeroi = findViewById<ImageView>(R.id.imageViewHeroi)
        val buttonPesquisarHeroi = findViewById<Button>(R.id.buttonPesquisarHeroi)
        val buttonRefazerQuiz = findViewById<Button>(R.id.buttonRefazerQuiz)

        // Receba as respostas da tela de perguntas
        val motivacao = intent.getStringExtra("motivacao")
        val poder = intent.getStringExtra("poder")
        val caracteristica = intent.getStringExtra("caracteristica")
        val acao = intent.getStringExtra("acao")

        var heroiResultado = ""

        // *** Lógica para determinar o aheroi baseado nas respostas ***
        if (motivacao == "Justiça" && poder == "Super Força" && caracteristica == "Coragem" && (acao == "Sozinho" || acao == "Em equipe")) {
            heroiResultado = "Super Homem"
        } else if (motivacao == "Proteger os inocentes" && poder == "Habilidade de voar" && caracteristica == "Coragem" && acao == "Em equipe") {
            heroiResultado = "Mulher Maravilha"
        } else if (poder == "Inteligência avançada" && caracteristica == "Inteligência" && (acao == "Sozinho" || acao == "Em equipe")) {
            heroiResultado = "Homem de Ferro"
        } else if (motivacao == "Vingança ou justiça" && poder == "Tecnologia e dinheiro" && (caracteristica == "Coragem" || caracteristica == "Inteligência") && acao == "Sozinho") {
            heroiResultado = "Batman"
        } else {
            heroiResultado = "Um heroi em potencial!" // Resultado padrão
        }

        textViewNomeHeroi.text = heroiResultado

        when (heroiResultado) {
            "Super Homem" -> imageViewHeroi.setImageResource(R.drawable.super_homem)
            "Mulher Maravilha" -> imageViewHeroi.setImageResource(R.drawable.mulher_maravilha)
            "Homem de Ferro" -> imageViewHeroi.setImageResource(R.drawable.homem_de_ferro)
            "Batman" -> imageViewHeroi.setImageResource(R.drawable.batman2) // Certifique-se de ter a imagem do Batman
            else -> imageViewHeroi.setImageResource(R.drawable.ic_launcher_foreground)
        }

        // Intent Implícita para pesquisar no Google ao clicar no botão
        buttonPesquisarHeroi.setOnClickListener {
            val pesquisa = "Informações sobre " + heroiResultado
            val intentNavegador = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=$pesquisa"))
            startActivity(intentNavegador)
        }

        buttonRefazerQuiz.setOnClickListener {
            val intentRefazer = Intent(this, MainActivity::class.java)
            intentRefazer.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intentRefazer)
            finish()
        }
    }
}