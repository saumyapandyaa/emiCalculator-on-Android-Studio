package com.example.emibudget

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class EmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emi)

        val etLoan = findViewById<EditText>(R.id.etLoan)
        val etRate = findViewById<EditText>(R.id.etRate)
        val etTenure = findViewById<EditText>(R.id.etTenure)
        val btnCalc = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvEmiResult)

        btnCalc.setOnClickListener {
            try {
                val p = etLoan.text.toString().toDouble()
                val annualRate = etRate.text.toString().toDouble()
                val years = etTenure.text.toString().toDouble()

                val r = annualRate / 12.0 / 100.0
                val n = years * 12.0

                val emi = if (r == 0.0) p / n else (p * r * (1 + r).pow(n)) / ((1 + r).pow(n) - 1)

                tvResult.text = String.format("Monthly EMI: %.2f", emi)
                // Persist EMI so Balance screen can use it
                Prefs.saveEmi(this, emi)
            } catch (ex: Exception) {
                Toast.makeText(this, "Enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
