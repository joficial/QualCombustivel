package sephs.eu.qualcombustivel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val verificationButton = findViewById<Button>(R.id.buttonVerification)
        val getGasolina = findViewById<EditText>(R.id.getGasolina)
        val getAlcool = findViewById<EditText>(R.id.getAlcool)
        val showResult = findViewById<TextView>(R.id.outResult)

        verificationButton.setOnClickListener{

            // Já tem conversores de valores dentro de Kotlin
            // isso é maravilhoso
            val valueGasolina = getGasolina.text.toString().toFloatOrNull()
            val valueAlcool = getAlcool.text.toString().toFloatOrNull()


            //Realizar os cáculos
            if (valueAlcool!=null && valueGasolina!=null){
                val result = valueAlcool / valueGasolina

                if (result >= 0.7){
                    //Gasolina
                    showResult.setText("Rapaz...\nÉ melhor colocar Gasosa")
                }else{
                    //Álcool
                    showResult.setText("Rapaz...\nÉ melhor colocar Álcool")
                }

                getAlcool.setText("")
                getGasolina.setText("")
            }else {
                Toast.makeText(this@MainActivity, "Informe os dois valores!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
