package cat.copernic.finall.aitor.burruezorodriguez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class OperacionesBasicas : AppCompatActivity() {

    lateinit var etn_Valor1: EditText
    lateinit var etn_Valor2: EditText
    lateinit var tv_Resultado: TextView
    lateinit var rg_RadioGroup: RadioGroup
    /*lateinit var rb_Sumar: RadioButton
    lateinit var rb_Restar: RadioButton
    lateinit var rb_Multiplicar: RadioButton
    lateinit var rb_Dividir: RadioButton*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operaciones_basicas)

        default()
        listenerRadioGroup()
    }

    private fun default() {
        etn_Valor1 = findViewById<EditText>(R.id.etn_Valor1)
        etn_Valor2 = findViewById<EditText>(R.id.etn_Valor2)
        rg_RadioGroup = findViewById(R.id.radioGroup)
        tv_Resultado = findViewById(R.id.tv_resultado)
        /*rb_Sumar = findViewById<RadioButton>(R.id.rb_Sumar)
        rb_Restar = findViewById<RadioButton>(R.id.rb_Restar)
        rb_Multiplicar = findViewById<RadioButton>(R.id.rb_Multiplicar)
        rb_Dividir = findViewById<RadioButton>(R.id.rb_dividir)*/
    }

    private fun listenerRadioGroup() {
        rg_RadioGroup.setOnCheckedChangeListener() { radioGroup, i ->
            var rb = findViewById<RadioButton>(i)
            if (rb != null) {
                if (rb.text == getString(R.string.rb_sumar)) {
                    sumar()
                } else if (rb.text == getString(R.string.rb_restar)) {
                    restar()
                } else if (rb.text == getString(R.string.rb_multiplicar)) {
                    multiplicar()
                } else if (rb.text == getString(R.string.rb_dividir)) {
                    dividir()
                }
            }
        }
    }

    private fun sumar() {
        val valor1 = etn_Valor1.text.toString().toDouble()
        val valor2 = etn_Valor2.text.toString().toDouble()

        tv_Resultado.setText((valor1 + valor2).toString())
    }

    private fun restar() {
        val valor1 = etn_Valor1.text.toString().toDouble()
        val valor2 = etn_Valor2.text.toString().toDouble()

        tv_Resultado.setText((valor1 - valor2).toString())
    }

    private fun multiplicar() {
        val valor1 = etn_Valor1.text.toString().toDouble()
        val valor2 = etn_Valor2.text.toString().toDouble()

        tv_Resultado.setText((valor1 * valor2).toString())
    }

    private fun dividir() {
        val valor1 = etn_Valor1.text.toString().toDouble()
        val valor2 = etn_Valor2.text.toString().toDouble()

        tv_Resultado.setText((valor1 / valor2).toString())
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun btn_Atras(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun btn_About(view: View) {
        Toast.makeText(this, R.string.textAbout, Toast.LENGTH_SHORT).show()
    }
}