package br.com.yuriduarte.viagens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaInicial : AppCompatActivity() {

    lateinit var groupTransporte : RadioGroup
    lateinit var checkBagagem : CheckBox
    lateinit var checkMochila: CheckBox
    lateinit var checkBolsa : CheckBox
    lateinit var escreveDestino : EditText
    lateinit var confirma : Button

    var bagagem = false
    var mochila = false
    var bolsa = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_inicial)

        groupTransporte = findViewById(R.id.radioGroup)
        checkBagagem = findViewById(R.id.checkBox)
        checkMochila = findViewById(R.id.checkBox2)
        checkBolsa = findViewById(R.id.checkBox3)
        escreveDestino = findViewById(R.id.editTextText)
        confirma = findViewById(R.id.button)

        val telaConfirmacao = Intent(this, TelaConfirmacao::class.java)

        checkBagagem.setOnCheckedChangeListener { buttonView, isChecked -> isChecked
            bagagem = if(isChecked){true} else{false}
        }

        checkMochila.setOnCheckedChangeListener { buttonView, isChecked -> isChecked
            mochila = if(isChecked){true} else{false}
        }

        checkBolsa.setOnCheckedChangeListener { buttonView, isChecked -> isChecked
            bolsa = if(isChecked){true} else{false}
        }

        confirma.setOnClickListener {
            try{
                val transporte : RadioButton
                transporte = findViewById(groupTransporte.checkedRadioButtonId)

                telaConfirmacao.putExtra("transporte", transporte.text.toString())

                if(escreveDestino.text.isNotEmpty()) {
                    val destino = escreveDestino.text.toString()

                    telaConfirmacao.putExtra("destino", destino)

                    telaConfirmacao.putExtra("bagagem", bagagem)
                    telaConfirmacao.putExtra("mochila", mochila)
                    telaConfirmacao.putExtra("bolsa", bolsa)

                    startActivity(telaConfirmacao)

                }
                else{
                    Toast.makeText(applicationContext, "Digite um destino antes de prosseguir", Toast.LENGTH_LONG).show()
                }
            }
            catch(e: Exception){
                Toast.makeText(applicationContext, "Selecione um meio de transporte", Toast.LENGTH_LONG).show()
            }
        }

    }
}