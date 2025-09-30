package com.example.emibudget

import android.content.Context
import android.content.SharedPreferences

object Prefs {
    private const val NAME = "emibudget_prefs"
    private const val KEY_INCOME = "key_income"
    private const val KEY_EXPENSE = "key_expense"
    private const val KEY_EMI = "key_emi"

    private fun prefs(ctx: Context): SharedPreferences =
        ctx.getSharedPreferences(NAME, Context.MODE_PRIVATE)

    fun saveIncome(ctx: Context, income: Double) {
        prefs(ctx).edit().putLong(KEY_INCOME, java.lang.Double.doubleToRawLongBits(income)).apply()
    }
    fun saveExpense(ctx: Context, expense: Double) {
        prefs(ctx).edit().putLong(KEY_EXPENSE, java.lang.Double.doubleToRawLongBits(expense)).apply()
    }
    fun saveEmi(ctx: Context, emi: Double) {
        prefs(ctx).edit().putLong(KEY_EMI, java.lang.Double.doubleToRawLongBits(emi)).apply()
    }

    fun getIncome(ctx: Context): Double =
        java.lang.Double.longBitsToDouble(prefs(ctx).getLong(KEY_INCOME, java.lang.Double.doubleToRawLongBits(0.0)))

    fun getExpense(ctx: Context): Double =
        java.lang.Double.longBitsToDouble(prefs(ctx).getLong(KEY_EXPENSE, java.lang.Double.doubleToRawLongBits(0.0)))

    fun getEmi(ctx: Context): Double =
        java.lang.Double.longBitsToDouble(prefs(ctx).getLong(KEY_EMI, java.lang.Double.doubleToRawLongBits(0.0)))
}
