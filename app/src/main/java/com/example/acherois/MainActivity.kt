package com.example.acherois

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoComecar = findViewById<Button>(R.id.buttonComecar)
        botaoComecar.setOnClickListener {
            val intent = Intent(this, Perguntas::class.java)
            startActivity(intent)
        }
    }
}