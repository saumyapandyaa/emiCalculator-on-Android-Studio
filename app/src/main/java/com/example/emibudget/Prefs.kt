package com.example.emibudget

import android.content.Context

object Prefs {
    private const val PREFS_NAME = "emi_prefs"
    private const val KEY_EMI = "key_emi"
    private const val KEY_INCOME = "key_income"
    private const val KEY_EXPENSES = "key_expenses"

    fun saveEmi(context: Context, emi: Float) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putFloat(KEY_EMI, emi).apply()
    }

    fun getEmi(context: Context): Float {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getFloat(KEY_EMI, 0f)
    }

    fun saveIncomeExpenses(context: Context, income: Float, expenses: Float) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit()
            .putFloat(KEY_INCOME, income)
            .putFloat(KEY_EXPENSES, expenses)
            .apply()
    }

    fun getIncome(context: Context): Float {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getFloat(KEY_INCOME, 0f)
    }

    fun getExpenses(context: Context): Float {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getFloat(KEY_EXPENSES, 0f)
    }
}
