EMI Budget App

An Android application that helps users calculate EMI, track income and expenses, and view their remaining budget balance (savings or deficit).
Built with Kotlin, Android Studio, and Material Design UI components for a modern, user-friendly experience.

✨ Features

📊 EMI Calculator

Input: Loan amount, Interest rate, Tenure (in months)

Output: Monthly EMI

💰 Income & Expenses

Add and save monthly income

Add and save monthly expenses

(Optional daily/recurrent expense input not included but extendable)

📉 Budget Balance

Calculates remaining savings or deficit = Income − (Expenses + EMI)

Displays result in a clean, card-style UI

🎨 UI/UX

Professional Material Design components

Card views for results

Ripple-effect interactive buttons

Simple, responsive, and beginner-friendly interface

🛠️ Tech Stack

Language: Kotlin

Framework: Android SDK

UI: Material Design Components (MaterialButton, MaterialCardView, TextInputLayout)

Data Storage: SharedPreferences (lightweight persistence)

IDE: Android Studio

📂 Project Structure
com.example.emibudget
 ├── MainActivity.kt              # Main navigation hub
 ├── EmiActivity.kt               # EMI calculation screen
 ├── IncomeExpensesActivity.kt    # Income & Expenses input screen
 ├── BalanceActivity.kt           # Budget balance display
 ├── Prefs.kt                     # SharedPreferences helper
 └── res/layout                   # XML layouts for each screen

🚀 How It Works

Navigate from MainActivity to either EMI Calculator, Income & Expenses, or Balance.

Enter values (loan, rate, tenure) to calculate EMI.

Save monthly income & expenses.

Check budget balance to see whether you are saving or running a deficit.

📋 Testing Guide

✅ Enter sample values to validate EMI calculations:

Loan = 100000, Rate = 10%, Tenure = 12 → EMI ≈ 8791.59

✅ Save Income = 50000, Expenses = 20000, EMI = 8791.59 → Balance = 21208.41

✅ Test edge cases (empty inputs, negative values → validation messages).

📦 Installation

Clone the repository:

git clone https://github.com/your-username/emi-budget-app.git


Open project in Android Studio.

Build & run on emulator or physical device.
