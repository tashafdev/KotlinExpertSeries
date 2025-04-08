package s19_clean_code_and_principles.s19e_naming_and_formatting



/*
 * -----------------------------------------------------
 * ✅ Clean Code Practice: Code Formatting Tips
 * -----------------------------------------------------
 * Formatting doesn’t change logic — but it **massively affects readability**.
 * Clean formatting = easier to read, review, and maintain code 📚🧠
 */

/*
 * 📌 Section 1 — ❌ Inconsistent indentation & spacing
 */
fun section1_BadFormattingExample() {
    println("❌ Messy format hurts readability")
}

fun section1_GoodFormattingExample() {
    val x = 5
    println("✅ Result: $x")
}

/*
 * 📌 Section 2 — Braces & line breaks
 */
fun section2_BracesAndLineBreaks() {
    val isValid = "Tashy".isNotBlank() &&
            28 > 0 // ✅ Break at logical points
    println("Is valid? $isValid")
}

/*
 * 📌 Section 3 — Consistent spacing around code
 */
fun section3_ConsistentSpacing() {
    val name = "Tashy"  // ✅ One space before comment

    val result = calculateSection3(name) // ✅ No cramping
    println("Result: $result")
}

fun calculateSection3(name: String): String {
    return name.uppercase()
}

/*
 * 📌 Section 4 — Code grouped into logical blocks
 */
fun section4_GroupingCodeBlocks() {
    // Input
    val email = "user@example.com"
    val password = "123456"

    // Validation
    if (email.isBlank() || password.length < 6) {
        println("❌ Invalid input")
        return
    }

    // Proceed
    println("✅ Logging in...")
}

/*
 * 📌 Section 5 — Class formatting & field ordering
 */
fun section5_ClassFormattingDemo() {
    val user = S19EcUser("Tashy", "t@code.com")
    user.greet()
}

class S19EcUser(
    val name: String,
    val email: String
) {
    fun greet() = println("👋 Hello, $name")
}

/*
 * 🧠 What You Will Learn:
 * - The visual impact of clean formatting
 * - Kotlin formatting conventions
 * - How formatting improves understanding across teams
 */

/*
 * 🚀 Quick Summary:
 * ✅ Follow consistent line spacing, indentation, braces
 * ✅ Break up long logic into readable pieces
 * ✅ Organize code into input → processing → output
 */

/*
 * 📘 Key Takeaways:
 * - Use auto-format (Ctrl+Alt+L / Cmd+Option+L)
 * - Prefer vertical clarity over horizontal cramping
 * - Structure matters just as much as syntax

 * 💡 Real-World Use Cases:
 * - Big PRs get rejected due to formatting alone
 * - Mixed formatting = painful merges
 * - Formatting helps code live longer across teams

 * 🧼 Clean Code Insight:
 * The best code is not just correct — it's beautiful.
 * Treat your code like a UI: **form and function**.
 */
