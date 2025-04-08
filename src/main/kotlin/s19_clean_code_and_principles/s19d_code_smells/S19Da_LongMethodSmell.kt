package s19_clean_code_and_principles.s19d_code_smells


/*
 * -----------------------------------------------------
 * ❌ Code Smell: Long Method
 * -----------------------------------------------------
 * A method that tries to do **too much** becomes hard to:
 * - Read 📖
 * - Test 🧪
 * - Maintain 🛠️
 *
 * Long methods often violate SRP and signal poor separation of concerns.
 */

/*
 * 📌 Section 1 — ❌ Long, bloated function doing everything
 */
fun section1_LongMethodBad() {
    val name = "Tashy"
    val email = "tashy@example.com"
    val age = 28

    // Validation
    if (name.isBlank() || email.isBlank() || age <= 0) {
        println("❌ Invalid input")
        return
    }

    // Logging
    println("📋 Registering user: $name, $email, $age")

    // Sending email
    println("📧 Sending welcome email to $email")

    // Saving to DB
    println("💾 Saving user $name to DB")
}

/*
 * 📌 Section 2 — ✅ Refactored into smaller focused functions
 */
fun validateInput(name: String, email: String, age: Int): Boolean {
    return name.isNotBlank() && email.isNotBlank() && age > 0
}

fun logUser(name: String, email: String, age: Int) {
    println("📋 Registering user: $name, $email, $age")
}

fun sendWelcomeEmail(email: String) {
    println("📧 Sending welcome email to $email")
}

fun saveUser(name: String) {
    println("💾 Saving user $name to DB")
}

fun section2_ShorterMethodGood() {
    val name = "Tashy"
    val email = "tashy@example.com"
    val age = 28

    if (!validateInput(name, email, age)) {
        println("❌ Invalid input")
        return
    }

    logUser(name, email, age)
    sendWelcomeEmail(email)
    saveUser(name)
}

/*
 * 🧠 What You Will Learn:
 * - Why long methods are a problem
 * - How to break them into single-responsibility units
 * - How Kotlin helps you keep methods clean and readable
 */

/*
 * 🚀 Quick Summary:
 * ❌ Long = unreadable, hard to reuse/test
 * ✅ Break logic into small, named helper functions
 * ✅ Each section does one thing → clean flow
 */

/*
 * 📘 Key Takeaways:
 * - Each function should express 1 clear idea
 * - Small functions are easier to debug and reuse
 * - IDE navigation, unit testing, and maintenance become smoother

 * 💡 Real-World Use Cases:
 * - OnClick handlers in Android
 * - Network responses with long if/else
 * - ViewModel business logic bloat

 * 🧼 Clean Code Insight:
 * If you scroll more than a screen to read a method —
 * it’s time to **extract and simplify**.
 */
