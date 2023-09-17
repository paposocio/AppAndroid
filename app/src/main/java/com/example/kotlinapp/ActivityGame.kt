package com.example.kotlinapp

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class ActivityGame : AppCompatActivity() {
    private lateinit var resultadoTextView: TextView
    private lateinit var eleccionMaquinaImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val botonPiedra = findViewById<ImageButton>(R.id.imageButtonrock)
        val botonTijeras = findViewById<ImageButton>(R.id.imageButtonscissors)
        val botonPapel = findViewById<ImageButton>(R.id.imageButtonpaper)

        eleccionMaquinaImageView = findViewById(R.id.eleccionMaquinaImageView)

        // Configurar clics de botones
        botonPiedra.setOnClickListener {
            jugar("piedra")
        }

        botonTijeras.setOnClickListener {
            jugar("tijeras")
        }

        botonPapel.setOnClickListener {
            jugar("papel")
        }
    }

    private fun jugar(opcionUsuario: String) {
        val opciones = arrayOf("piedra", "papel", "tijeras")
        val opcionComputadora = opciones[Random.nextInt(0, 3)]

        // Determinar el resultado del juego
        val resultado = when {
            opcionUsuario == opcionComputadora -> "Empate"
            (opcionUsuario == "piedra" && opcionComputadora == "tijeras") ||
            (opcionUsuario == "papel" && opcionComputadora == "piedra") ||
            (opcionUsuario == "tijeras" && opcionComputadora == "papel") -> "Ganaste"
            else -> "Perdiste"
        }

        // Mostrar la elección de la máquina en el ImageView
        when (opcionComputadora) {
            "piedra" -> eleccionMaquinaImageView.setImageResource(R.drawable.rock)
            "papel" -> eleccionMaquinaImageView.setImageResource(R.drawable.paper)
            "tijeras" -> eleccionMaquinaImageView.setImageResource(R.drawable.scissors)
        }

        // Mostrar un mensaje emergente (Toast) con el resultado del juego
        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show()
    }
}
