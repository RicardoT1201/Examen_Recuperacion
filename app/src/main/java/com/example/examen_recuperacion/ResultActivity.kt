package com.example.examen_recuperacion

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
        private var numEmployees = 1

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_result)

            val totalAmount = intent.getDoubleExtra("totalAmount", 0.0)

            findViewById<TextView>(R.id.txtTotalAmount).text = "Total Tips: $totalAmount"

            findViewById<TextView>(R.id.txtNumEmployees).text = numEmployees.toString()

            findViewById<Button>(R.id.btnIncreaseEmployees).setOnClickListener {
                numEmployees++
                findViewById<TextView>(R.id.txtNumEmployees).text = numEmployees.toString()
                updateAmountPerEmployee(totalAmount)
            }

            findViewById<Button>(R.id.btnDecreaseEmployees).setOnClickListener {
                if (numEmployees > 1) {
                    numEmployees--
                    findViewById<TextView>(R.id.txtNumEmployees).text = numEmployees.toString()
                    updateAmountPerEmployee(totalAmount)
                }
            }

            updateAmountPerEmployee(totalAmount)
        }

        private fun updateAmountPerEmployee(totalAmount: Double) {
            val amountPerEmployee = totalAmount / numEmployees
            findViewById<TextView>(R.id.txtAmountPerEmployee).text = "Amount per Employee: $amountPerEmployee"
        }
    }
