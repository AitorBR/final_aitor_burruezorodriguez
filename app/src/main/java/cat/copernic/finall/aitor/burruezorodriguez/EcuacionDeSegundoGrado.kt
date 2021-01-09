package cat.copernic.finall.aitor.burruezorodriguez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class EcuacionDeSegundoGrado : AppCompatActivity() {

    lateinit var etn_A: EditText
    lateinit var etn_B: EditText
    lateinit var etn_C: EditText
    lateinit var tv_Solucion1: TextView
    lateinit var tv_Solucion2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecuacion_de_segundo_grado)

        default()
    }

    private fun default() {
        etn_A = findViewById<EditText>(R.id.etn_A)
        etn_B = findViewById<EditText>(R.id.etn_B)
        etn_C = findViewById<EditText>(R.id.etn_C)
        tv_Solucion1 = findViewById<TextView>(R.id.tv_Solucion1)
        tv_Solucion2 = findViewById<TextView>(R.id.tv_Solucion2)
    }

    fun btn_Calcular(view: View) {
        var a: Double? = etn_A.text.toString().toDouble()
        var b: Double? = etn_B.text.toString().toDouble()
        var c: Double? = etn_C.text.toString().toDouble()

        a?.let {
            b?.let {
                c?.let {
                    calcularResultado(a, b, c)
                } ?: run {
                    Toast.makeText(this, R.string.nullInA, Toast.LENGTH_LONG).show()
                }
            } ?: run {
                Toast.makeText(this, R.string.nullInB, Toast.LENGTH_LONG).show()
            }
        } ?: run {
            Toast.makeText(this, R.string.nullInC, Toast.LENGTH_LONG).show()
        }
    }

    fun calcularResultado(a: Double, b: Double, c: Double) {
        val x1: Double = (-b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a)
        val x2: Double = (-b - Math.sqrt((b * b) - (4 * a * c))) / (2 * a)

        tv_Solucion1.setText("Resultado positivo: " + x1.toString())
        tv_Solucion2.setText("Resultado negativo: " + x2.toString())
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun btn_About(view: View) {
        Toast.makeText(this, R.string.textAbout, Toast.LENGTH_SHORT).show()
    }

    fun btn_Atras(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}