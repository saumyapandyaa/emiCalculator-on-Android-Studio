package com.example.emibudget

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEmi = findViewById<Button>(R.id.btnEmi)
        val btnIncomeExpense = findViewById<Button>(R.id.btnIncomeExpense)
        val btnBalance = findViewById<Button>(R.id.btnBalance)

        btnEmi.setOnClickListener {
            startActivity(Intent(this, EmiActivity::class.java))
        }
        btnIncomeExpense.setOnClickListener {
            startActivity(Intent(this, IncomeExpenseActivity::class.java))
        }
        btnBalance.setOnClickListener {
            startActivity(Intent(this, BalanceActivity::class.java))
        }
    }
}
