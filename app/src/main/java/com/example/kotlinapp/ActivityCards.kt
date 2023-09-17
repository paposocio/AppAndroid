package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class ActivityCards : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

        val cartaTextView = findViewById<TextView>(R.id.TextViewCardType)
        val numeroCartaTextView = findViewById<TextView>(R.id.textViewCardNumber)
        val boton = findViewById<Button>(R.id.buttonIniciar)

        boton.setOnClickListener {
            // Definir los números de las cartas y los palos
            val numerosCartas = listOf("2", "3", "4", "5", "6", "7", "8", "9", "10")
            val palos = listOf("♠", "♣", "♦", "♥")

            // Generar un número de carta y un palo al azar
            val numeroAleatorio = numerosCartas[Random.nextInt(0, numerosCartas.size)]
            val paloAleatorio = palos[Random.nextInt(0, palos.size)]

            // Mostrar el número de la carta y el palo en los TextView
            numeroCartaTextView.text = numeroAleatorio
            cartaTextView.text = paloAleatorio
            cartaTextView.visibility = View.VISIBLE // Mostrar la carta

        }
    }
}
