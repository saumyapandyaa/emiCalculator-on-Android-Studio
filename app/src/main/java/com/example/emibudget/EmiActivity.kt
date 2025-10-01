package com.example.emibudget

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emi)

        supportActionBar?.title = "EMI Calculator"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val etLoan = findViewById<EditText>(R.id.etLoan)
        val etRate = findViewById<EditText>(R.id.etRate)
        val etTenure = findViewById<EditText>(R.id.etTenure)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvEmiResult = findViewById<TextView>(R.id.tvEmiResult)

        btnCalculate.setOnClickListener {
            val loan = etLoan.text.toString().toDoubleOrNull()
            val rate = etRate.text.toString().toDoubleOrNull()
            val tenure = etTenure.text.toString().toIntOrNull()

            if (loan != null && rate != null && tenure != null) {
                val monthlyRate = rate / (12 * 100)
                val emi = (loan * monthlyRate * Math.pow(1 + monthlyRate, tenure.toDouble())) /
                        (Math.pow(1 + monthlyRate, tenure.toDouble()) - 1)

                tvEmiResult.text = "Monthly EMI: %.2f".format(emi)

                Prefs.saveEmi(this, emi.toFloat())
            } else {
                tvEmiResult.text = "Enter valid values"
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
