package com.example.emibudget

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import java.text.NumberFormat
import java.util.Locale

class BalanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance)

        val tvSummary = findViewById<TextView>(R.id.tvSummary)
        val btnRefresh = findViewById<Button>(R.id.btnRefresh)

        fun update() {
            val income = Prefs.getIncome(this)
            val expense = Prefs.getExpense(this)
            val emi = Prefs.getEmi(this)
            val totalOut = expense + emi
            val balance = income - totalOut

            val nf = NumberFormat.getCurrencyInstance(Locale.getDefault())
            val s = StringBuilder()
            s.append("Monthly Income: ${nf.format(income)}\n")
            s.append("Monthly Expenses: ${nf.format(expense)}\n")
            s.append("Monthly EMI: ${nf.format(emi)}\n")
            s.append("--------------------------\n")
            s.append(
                if (balance >= 0)
                    "Monthly Savings: ${nf.format(balance)}"
                else
                    "Monthly Deficit: ${nf.format(-balance)}"
            )
            tvSummary.text = s.toString()
        }

        btnRefresh.setOnClickListener { update() }

        update()
    }
}
