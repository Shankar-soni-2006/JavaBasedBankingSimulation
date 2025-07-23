# JavaBasedBankingSimulation
# 🏦 Java Bank Account Management System

This is a simple console-based banking system written in **Java**. It allows users to create bank accounts, perform credit/debit operations, check account balances, and view account details. It’s built using Object-Oriented Programming (OOP) concepts like classes, objects, and encapsulation.

---

## 📌 Features

- ✅ Create a new bank account  
- 💳 Credit and debit money securely  
- 📊 Check current account balance  
- 🧾 Display full account details  
- 🔒 Auto-generate unique account numbers  
- 🛑 Input validation and basic error handling  

---

## 🛠️ Technologies Used

- Language: `Java`
- IDE: Any Java IDE (like IntelliJ IDEA, Eclipse, or VS Code)
- Input/Output: Java's built-in `Scanner` and `System.out`

---

## 📂 Project Structure

```plaintext
BankAccount.java   // Class that handles all account-related logic
Main.java          // Contains main method with interactive menu system
📥 Getting Started
1️⃣ Prerequisites
Java installed (JDK 8 or higher)

Any code editor (e.g., VS Code, IntelliJ)
# Navigate to your project directory
cd path/to/project

# Compile the files
javac Main.java

# Run the program
java Projects.Main
🧠 Code Flow (Chain-of-Thought)
User sees a main menu with 3 options.

If they select Create New Account:

Inputs are taken.

Account number is auto-generated and checked for uniqueness.

Details are stored in an array of BankAccount objects.

If they select Existing Account:

User enters account number.

If found, a submenu opens: Credit, Debit, Balance Check, or View Details.

User can perform operations or return to the main menu.

Exiting the program ends the loop.
