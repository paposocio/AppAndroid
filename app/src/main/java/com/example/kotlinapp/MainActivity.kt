package com.example.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user=findViewById<EditText>(R.id.editTextUsuario)
        val clave=findViewById<EditText>(R.id.editTextPassword)
        val boton=findViewById<Button>(R.id.buttonIniciar)
        boton.setOnClickListener{
            if (user.text.toString()==("usuario")&& clave.text.toString() == "clave"){
                val intento= Intent(this,ActivityMenu::class.java)
                startActivity(intento)
            }
            else{
                Toast.makeText(this, "Acceso denegado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}