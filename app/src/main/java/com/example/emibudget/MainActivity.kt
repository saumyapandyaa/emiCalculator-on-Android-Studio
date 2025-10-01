package com.example.emibudget

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEmi = findViewById<Button>(R.id.btnEmi)
        val btnIncomeExpenses = findViewById<Button>(R.id.btnIncomeExpenses)
        val btnBalance = findViewById<Button>(R.id.btnBalance)

        btnEmi.setOnClickListener {
            startActivity(Intent(this, EmiActivity::class.java))
        }

        btnIncomeExpenses.setOnClickListener {
            startActivity(Intent(this, IncomeExpensesActivity::class.java))
        }

        btnBalance.setOnClickListener {
            startActivity(Intent(this, BalanceActivity::class.java))
        }
    }
}
