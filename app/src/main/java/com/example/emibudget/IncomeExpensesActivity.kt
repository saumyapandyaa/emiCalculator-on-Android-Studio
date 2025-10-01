package com.example.emibudget

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class IncomeExpensesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_income_expenses)

        supportActionBar?.title = "Income & Expenses"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val etIncome = findViewById<EditText>(R.id.etIncome)
        val etExpense = findViewById<EditText>(R.id.etExpense)
        val btnSave = findViewById<Button>(R.id.btnSaveIncExp)

        btnSave.setOnClickListener {
            val income = etIncome.text.toString().toFloatOrNull()
            val expenses = etExpense.text.toString().toFloatOrNull()

            if (income != null && expenses != null) {
                Prefs.saveIncomeExpenses(this, income, expenses)
                Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
