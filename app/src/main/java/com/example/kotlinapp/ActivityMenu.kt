package com.example.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ActivityMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val botoncartas=findViewById<ImageButton>(R.id.imageButtonCartas)
        val botoncalc=findViewById<ImageButton>(R.id.imageButtonCalculadora)
        val botonjuego=findViewById<ImageButton>(R.id.imageButtonJuego)
        
        botoncartas.setOnClickListener{
            val intento= Intent(this,ActivityCards::class.java)
            startActivity(intento)
        }

        botoncalc.setOnClickListener{
            val intento= Intent(this,ActivityCalculator::class.java)
            startActivity(intento)
        }

        botonjuego.setOnClickListener{
            val intento= Intent(this,ActivityGame::class.java)
            startActivity(intento)
        }
    }
}