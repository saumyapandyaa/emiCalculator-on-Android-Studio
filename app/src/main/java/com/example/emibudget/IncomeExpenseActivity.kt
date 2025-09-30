package com.example.emibudget

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class IncomeExpenseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_income_expense)

        val etIncome = findViewById<EditText>(R.id.etIncome)
        val etExpense = findViewById<EditText>(R.id.etExpense)
        val btnSave = findViewById<Button>(R.id.btnSaveIncExp)

        // load existing if any
        etIncome.setText(String.format("%.2f", Prefs.getIncome(this)))
        etExpense.setText(String.format("%.2f", Prefs.getExpense(this)))

        btnSave.setOnClickListener {
            try {
                val income = etIncome.text.toString().toDouble()
                val expense = etExpense.text.toString().toDouble()
                Prefs.saveIncome(this, income)
                Prefs.saveExpense(this, expense)
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
            } catch (ex: Exception) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
