package cat.copernic.finall.aitor.burruezorodriguez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // varaibles()
    }

    private fun varaibles() {

        var empezamosEsto = "hola"

        println(empezamosEsto)

        val noCambia = "aaaaa"

        println(noCambia)

        val holaString: String = "es un String"

        // el if funciona =

        // el switch case es when

        val pruebaWhen = "cataluña"

        when (pruebaWhen) {

            "cataluña" -> {
                println("cataluñá bien")
            }
            "españa", "puedeSerEsteOtro" -> {
                println("españa bien")
            }
            else -> {
                println("no ta")
            }

        }

        val age = 5

        when (age) {

            0, 1, 2 -> {
                println("bebe")
            }
            in 3..10 -> {
                println("niño")
            }

        }

        // array

        val myArray = arrayListOf<String>()

        myArray.add("hola")
        myArray.add("hola2")
        myArray.add("hola3")
        myArray.add("hola4")

        println(myArray)

        myArray.addAll(listOf("hola", "adios"))


        myArray.forEach {       // imprime todo el array
            println(it)
        }

        println(myArray.count())

        myArray.clear() //borra todo


        // map

        var myMap: Map<String, Int> = mapOf()

        myMap = mutableMapOf("hola" to 1, "asd" to 3, "123" to 5)          // no se pueden añadir mas valores si es mapOf

        myMap["nada"] = 7
        myMap.put("adios", 7)
        myMap.put("adios", 5)    //actualiza el dato

        println(myMap)
        println(myMap["nada"])  // imprime solo ese valor

        myMap.remove("nada")


        // for

        for (valor in myArray) {
            println(valor)
        }

        for (value in myMap) {
            println("${value.key}-${value.value}")
        }

        for (i in 0..10) {  // imprime del 0 al 10 si no quieres el 10 pones until por le in (una tonteria a mi parecer)
            println(i)
        }


        for (i in 0..10 step 2) {  // de 2 en 2
            println(i)
        }

        for (i in 10 downTo 0 step 2) {  // de 2 en 2
            println(i)
        }

        //while

        var x = 0

        while (x < 0) {
            println(x)
            x++
        }

        var okNull: String? = "puedo estar vacio"
        okNull = null
        println(okNull)
        println(okNull?.length)     // el interrogante hace que si es nulo no lo ejecuta

        val let = okNull?.let {       // si no es nulo se ejecuta el codigo
            println(it)
        } ?: run {
            println("es nulo")
        }

        // funciones

        sayMyName("aitor")
        sayMyName2("aitor", "aaaa")

        val suma = sumar(1, 2)


        //clases

        var clase = coso()
        clase.code()

    }

    private fun sumar(valor1: Int, valor2: Int): Any {      // any puede ser int
        return valor1 + valor2
    }

    private fun sayMyName2(name: String, random: String) {
        println(name + random)
    }

    private fun sayMyName(name: String) {
        println(name)
    }


    override fun onBackPressed() {
        salirAppDialog()
    }

    fun btn_Atras(view: View)  {
        salirAppDialog()
    }

    private fun salirAppDialog() {
        AlertDialog.Builder(this)
            .setTitle(R.string.salirApp)
            .setPositiveButton(R.string.si) { _, _ ->
                Toast.makeText(this, R.string.closeApp, Toast.LENGTH_SHORT).show()
                finish()
                super.onBackPressed()
            }
            .setNegativeButton(R.string.no) { _, _ ->
                // nada
            }
            .create()
            .show()

    }

    fun btn_OperacionesBasicas(view: View) {
        startActivity(Intent(this, OperacionesBasicas::class.java))
        finish()
    }

    fun btn_EcuacionDeSegundoGrado(view: View) {
        startActivity(Intent(this, EcuacionDeSegundoGrado::class.java))
        finish()
    }

    fun btn_About(view: View) {
        Toast.makeText(this, R.string.textAbout, Toast.LENGTH_SHORT).show()
    }
}