package br.com.yuriduarte.viagens

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class TelaConfirmacao : AppCompatActivity() {

    lateinit var textTransporte : TextView
    lateinit var textBagagem : TextView
    lateinit var textMochila : TextView
    lateinit var textBolsa : TextView
    lateinit var textDestino : TextView
    lateinit var botaoConfirma : Button
    lateinit var botaoCancela : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_confirmacao)

        textTransporte = findViewById(R.id.textView8)
        textBagagem = findViewById(R.id.textView9)
        textMochila = findViewById(R.id.textView10)
        textBolsa = findViewById(R.id.textView11)
        textDestino = findViewById(R.id.textView12)
        
        botaoConfirma = findViewById(R.id.botao_confirma)
        botaoCancela = findViewById(R.id.botao_cancela)

        val informacoes = intent
        val transporte =  informacoes.getStringExtra("transporte")
        val bagagem = informacoes.getBooleanExtra("bagagem", false)
        val mochila = informacoes.getBooleanExtra("mochila", false)
        val bolsa = informacoes.getBooleanExtra("bolsa", false)
        val destino = informacoes.getStringExtra("destino")

        val viajar = Intent(this, TelaVamosViajar::class.java)

        //Log.i("teste", "Transporte: $transporte\nBagagem: ${bagagem.toString()}\nMochila: $mochila\nBolsa: $bolsa\nDestino: $destino")

        textTransporte.append(transporte)

        if(bagagem){
            textBagagem.append("Sim")
        }
        else{
            textBagagem.append("Não")
        }

        if(mochila){
            textMochila.append("Sim")
        }
        else{
            textMochila.append("Não")
        }

        if(bolsa){
            textBolsa.append("Sim")
        }
        else{
            textBolsa.append("Não")
        }

        textDestino.append(destino)

        botaoConfirma.setOnClickListener {

            viajar.putExtra("transporte", transporte)

            startActivity(viajar)

        }

        botaoCancela.setOnClickListener {

            finish()

        }

    }
}

// TODO Prototipar a tela de confirmação no quadro e implementar
// TODO A tela de confrimação vai ter um botão, quando eu clicar ele vai para uma terceira tela que vai mostrar o meio de transporte numa animação e tocar uim som desse meio de transporte e fechar o app