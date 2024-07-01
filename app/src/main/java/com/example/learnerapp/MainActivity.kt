package com.example.learnerapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Apply window insets to the main view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get references to the buttons
        val button1: Button = findViewById(R.id.buttonOne)
        val button2: Button = findViewById(R.id.buttonTwo)
        val button3: Button = findViewById(R.id.buttonThree)
        val button4: Button = findViewById(R.id.buttonFour)
        val button5: Button = findViewById(R.id.buttonFive)
        val button6: Button = findViewById(R.id.buttonSix)
        val button7: Button = findViewById(R.id.buttonSeven)
        val button8: Button = findViewById(R.id.buttonEight)
        val button9: Button = findViewById(R.id.buttonNine)
        val button0: Button = findViewById(R.id.buttonZero)

        val buttonDot: Button = findViewById(R.id.buttonDot)
        val buttonClear: Button = findViewById(R.id.buttonClear)
        val buttonBackspace: Button = findViewById(R.id.buttonBackspace)

        val buttonEqual: Button = findViewById(R.id.buttonEqual)
        val buttonPlus: Button = findViewById(R.id.buttonPlus)
        val buttonMinus: Button = findViewById(R.id.buttonMinus)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        val buttonPercent: Button = findViewById(R.id.buttonPercent)
        val buttonOpenBracket: Button = findViewById(R.id.buttonOpenBracket)
        val buttonCloseBracket: Button = findViewById(R.id.buttonCloseBracket)

        var result = ""

        val Screen: TextView = findViewById(R.id.NumberScreen)

        fun updateResult(textView: TextView) {
            textView.text = result
        }

        // Set click listeners for each button
        button1.setOnClickListener {
            result += "1"
            updateResult(Screen)
        }

        button2.setOnClickListener {
            result += "2"
            updateResult(Screen)
        }

        button3.setOnClickListener {
            result += "3"
            updateResult(Screen)
        }

        button4.setOnClickListener {
            result += "4"
            updateResult(Screen)
        }

        button5.setOnClickListener {
            result += "5"
            updateResult(Screen)
        }

        button6.setOnClickListener {
            result += "6"
            updateResult(Screen)
        }

        button7.setOnClickListener {
            result += "7"
            updateResult(Screen)
        }

        button8.setOnClickListener {
            result += "8"
            updateResult(Screen)
        }

        button9.setOnClickListener {
            result += "9"
            updateResult(Screen)
        }

        button0.setOnClickListener {
            result += "0"
            updateResult(Screen)
        }

        buttonDot.setOnClickListener {
            result += "."
            updateResult(Screen)
        }

        buttonClear.setOnClickListener {
            result = ""
            updateResult(Screen)
        }

        buttonBackspace.setOnClickListener {
            if (result.isNotEmpty()) {
                result = result.substring(0, result.length - 1)
                updateResult(Screen)
            }
        }

        buttonPlus.setOnClickListener {
            result += "+"
            updateResult(Screen)
        }

        buttonMinus.setOnClickListener {
            result += "-"
            updateResult(Screen)
        }

        buttonMultiply.setOnClickListener {
            result += "*"
            updateResult(Screen)
        }

        buttonDivide.setOnClickListener {
            result += "/"
            updateResult(Screen)
        }

        buttonPercent.setOnClickListener {
            result += "%"
            updateResult(Screen)
        }

        buttonOpenBracket.setOnClickListener {
            result += "("
            updateResult(Screen)
        }

        buttonCloseBracket.setOnClickListener {
            result += ")"
            updateResult(Screen)
        }

        buttonEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(result).build()
                val evaluatedResult = expression.evaluate()
                result = evaluatedResult.toString()
                updateResult(Screen)
            } catch (e: Exception) {
                Toast.makeText(this, "Invalid Expression", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
