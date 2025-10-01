package com.example.emibudget

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BalanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance)

        supportActionBar?.title = "Budget Balance"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvBalance = findViewById<TextView>(R.id.tvBalance)

        val income = Prefs.getIncome(this)
        val expenses = Prefs.getExpenses(this)
        val emi = Prefs.getEmi(this)

        val savings = income - (expenses + emi)

        tvBalance.text = if (savings >= 0) {
            "You are saving: %.2f".format(savings)
        } else {
            "You are in deficit: %.2f".format(-savings)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
