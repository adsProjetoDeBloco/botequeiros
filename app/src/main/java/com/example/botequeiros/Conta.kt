package com.example.botequeiros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class Conta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta)

        val getPessoas = intent.extras?.get("PESSOAS_NA_MESA")
        val getPreco = findViewById<TextView>(R.id.txt_preco)
        val getQuantidade = findViewById<TextView>(R.id.txt_quantidade)
        val btnFecharConta = findViewById<Button>(R.id.btn_dividir)



        btnFecharConta.setOnClickListener {
            val pessoas = getPessoas.toString().toInt()
            val preco = getPreco.text.toString().toFloat()
            val quantidade = getQuantidade.text.toString().toInt()

            var total = preco * quantidade
            var divisao = total / pessoas

            val intentComanda = Intent(this, Comanda::class.java)

            intentComanda.putExtra("DIVISAO_CONTA", divisao)
            intentComanda.putExtra("TOTAL", total)

            startActivity(intentComanda)

        }

    }

}