package com.example.kotlinapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class ActivityCalculator : AppCompatActivity() {

    private lateinit var inputTextView: TextView
    private lateinit var outputTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        inputTextView = findViewById(R.id.input)
        outputTextView = findViewById(R.id.output)

        // Obtener referencias a los botones numéricos y de operación
        val button0: Button = findViewById(R.id.button_0)
        val button1: Button = findViewById(R.id.button_1)
        val button2: Button = findViewById(R.id.button_2)
        val button3: Button = findViewById(R.id.button_3)
        val button4: Button = findViewById(R.id.button_4)
        val button5: Button = findViewById(R.id.button_5)
        val button6: Button = findViewById(R.id.button_6)
        val button7: Button = findViewById(R.id.button_7)
        val button8: Button = findViewById(R.id.button_8)
        val button9: Button = findViewById(R.id.button_9)
        val mas:Button = findViewById(R.id.button_addition)
        val menos:Button = findViewById(R.id.button_subtraction)
        val por:Button = findViewById(R.id.button_multiply)
        val div:Button = findViewById(R.id.button_division)
        val dot:Button = findViewById(R.id.button_dot)
        val buttonClear: Button = findViewById(R.id.button_clear)
        val buttonEquals: Button = findViewById(R.id.button_equals)

        button0.setOnClickListener {
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "0"
        }
        button1.setOnClickListener{
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "1"
        }
        button2.setOnClickListener{
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "2"
        }
        button3.setOnClickListener{
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "3"
        }
        button4.setOnClickListener{
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "4"
        }
        button5.setOnClickListener{
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "5"
        }
        button6.setOnClickListener{
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "6"
        }
        button7.setOnClickListener{
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "7"
        }
        button8.setOnClickListener{
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "8"
        }
        button9.setOnClickListener{
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "9"
        }

        buttonClear.setOnClickListener {
            inputTextView.text = ""
            outputTextView.text = ""
        }

        mas.setOnClickListener {
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "+"
        }

        menos.setOnClickListener {
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "-"
        }

        por.setOnClickListener {
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "×"
        }

        div.setOnClickListener {
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "÷"
        }

        dot.setOnClickListener {
            val currentInput = inputTextView.text.toString()
            inputTextView.text = currentInput + "."
        }

        // Función para evaluar la expresión matemática
        fun evalExpression(expression: String): String
        {
            val operators = setOf('+', '-', '×', '÷')
            var result:String= ""

            // Encontrar el índice del primer operador en la cadena
            val operatorIndex = expression.indexOfFirst { it in operators }

            if (operatorIndex != -1) {
                // Extraer el primer número
                val firstNumber = expression.substring(0, operatorIndex).trim()

                // Extraer el número restante
                val remainingExpression = expression.substring(operatorIndex + 1).trim()

                if (expression.contains("+")) {
                    val res = firstNumber.toDouble() + remainingExpression.toDouble()
                    result = res.toString()
                } else if (expression.contains("-")) {
                    val res = firstNumber.toDouble() - remainingExpression.toDouble()
                    result = res.toString()
                } else if (expression.contains("×")) {
                    val res = firstNumber.toDouble() * remainingExpression.toDouble()
                    result = res.toString()
                } else if (expression.contains("÷")) {
                    val res = firstNumber.toDouble() / remainingExpression.toDouble()
                    result = res.toString()
                }
            } else {
                result = "E"
            }

            return result
        }

        buttonEquals.setOnClickListener {
            val expression = inputTextView.text.toString()
            val result = evalExpression(expression)

            if (result.contains("E")){
                outputTextView.text = "Error"
            }
            else{
                outputTextView.text = result.toString()
            }
        }

    }

}