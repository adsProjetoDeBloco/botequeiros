package com.example.botequeiros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
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
        val getPorcentagem = findViewById<TextView>(R.id.txt_porcentagem)

        val getSeekBar = findViewById<SeekBar>(R.id.txt_seekBar)
        getSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                getPorcentagem.text = progress.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })



        btnFecharConta.setOnClickListener {
            val pessoas = getPessoas.toString().toInt()
            val preco = getPreco.text.toString().toFloat()
            val quantidade = getQuantidade.text.toString().toInt()
            val gorjeta = getPorcentagem.text.toString().toFloat()


            var total = (preco * quantidade) * (1 + gorjeta / 100)
            var divisao = total / pessoas

            val intentComanda = Intent(this, Comanda::class.java)

            intentComanda.putExtra("DIVISAO_CONTA", divisao)
            intentComanda.putExtra("TOTAL", total)

            startActivity(intentComanda)

        }

    }

}