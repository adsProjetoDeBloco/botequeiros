package com.example.botequeiros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Comanda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comanda)

        val getDivisao = intent.extras?.get("DIVISAO_CONTA")
        val getTotal = intent.extras!!.get("TOTAL")
        val txtDivisao = findViewById<TextView>(R.id.txt_divisao)
        val txtResultado = findViewById<TextView>(R.id.txt_total)

        txtDivisao.text = "Deu R$${"%.2f".format(getDivisao)} para cada pessoa."

        txtResultado.text = "R$${"%.2f".format(getTotal)}"



    }
}