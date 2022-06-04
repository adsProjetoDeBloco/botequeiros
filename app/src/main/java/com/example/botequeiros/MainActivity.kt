package com.example.botequeiros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pessoas = findViewById<TextView>(R.id.txt_pessoasMesa)

        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)

        btnCadastrar.setOnClickListener {


            val intentConta = Intent(this, Conta::class.java)

            intentConta.putExtra("PESSOAS_NA_MESA", pessoas.text.toString().toInt())

            startActivity(intentConta)

        }


    }
}