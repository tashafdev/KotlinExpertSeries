package s19_clean_code_and_principles.s19e_naming_and_formatting


/*
 * -----------------------------------------------------
 * ✅ Clean Code Practice: Good Naming
 * -----------------------------------------------------
 * Great names make code **read like prose**.
 *
 * ✅ Clear, consistent, meaningful names:
 * - Reduce confusion 🤔
 * - Improve collaboration 🤝
 * - Speed up onboarding 🚀
 *
 * Bad names cost hours. Good names pay dividends.
 */

/*
 * 📌 Section 1 — ❌ Bad variable and function names
 */
fun d1(x: Int): Int {
    return x * 12
}

fun section1_BadNamingExample() {
    val y = d1(5)
    println("Result = $y") // ❌ What is `d1`? What is `y`?
}

/*
 * ✅ Clear version
 */
fun calculateMonthlySalary(hourlyRate: Int): Int {
    return hourlyRate * 12
}

fun section1_GoodNamingExample() {
    val monthlySalary = calculateMonthlySalary(5)
    println("Monthly Salary = $monthlySalary") // ✅ Clear intent
}

/*
 * 📌 Section 2 — ❌ Ambiguous class names
 */
class StuffManager
class ThingProcessor

// ✅ Better
class PaymentProcessor
class UserRegistrationService

/*
 * 📌 Section 3 — ✅ Naming Conventions for Kotlin
 * - functions: camelCase → doSomething()
 * - classes: PascalCase → LoginManager
 * - constants: UPPER_SNAKE_CASE → API_KEY
 * - packages: lowercase → com.example.billing
 */

/*
 * 📌 Section 4 — Naming tips:
 */
fun section4_NamingTips() {
    val userList = listOf("Alice", "Bob") // ✅ 'userList' > 'data' or 'x'

    fun isEmailValid(email: String): Boolean = email.contains("@") // ✅ boolean = starts with 'is' or 'has'

    val maxAttempts = 3 // ✅ nouns for constants
}

/*
 * 🧠 What You Will Learn:
 * - The power of naming in clean code
 * - Real before/after naming examples
 * - Kotlin naming conventions for clarity
 */

/*
 * 🚀 Quick Summary:
 * ✅ Good names = better code readability
 * ✅ Avoid abbreviations, vague names, or clever tricks
 * ✅ Name things based on what they **do**, not how they're implemented
 */

/*
 * 📘 Key Takeaways:
 * - A function should read like a sentence: `calculateTotal()`, `isEmailValid()`
 * - Variables should explain their content: `userList`, `discountRate`
 * - Don’t be afraid of long names — be afraid of **wrong** names

 * 💡 Real-World Use Cases:
 * - ViewModel methods like `onLoginClicked()` instead of `goNext()`
 * - Repositories named `UserRepository` not `DataManager`
 * - Extension functions like `String.isValidPhoneNumber()`

 * 🧼 Clean Code Insight:
 * Code is read **10x more** than it's written.
 * Make every name a silent teammate 👥
 */
