package s19_clean_code_and_principles.s19b_dry_vs_wet


/*
 * -----------------------------------------------------
 * ❌ WET Anti-Pattern: Write Everything Twice
 * -----------------------------------------------------
 * WET = "We Enjoy Typing" / "Write Everything Twice"
 *
 * This happens when logic is **repeated unnecessarily** across files,
 * classes, or layers. It leads to:
 * - Inconsistencies
 * - Maintenance pain
 * - Bug duplication
 */

/*
 * 📌 Section 1 — ❌ Repeated logic in multiple places
 */
fun section1_ValidationForm1(name: String, age: Int): Boolean {
    if (name.isBlank()) return false
    if (age < 18) return false
    return true
}

fun section1_ValidationForm2(name: String, age: Int): Boolean {
    if (name.isBlank()) return false
    if (age < 18) return false
    return true
}

/*
 * 📌 Section 2 — ❌ Repeated formatting logic
 */
fun section2_InvoicePrintA(amount: Double): String {
    return "$${"%.2f".format(amount)}"
}

fun section2_InvoicePrintB(amount: Double): String {
    return "$${"%.2f".format(amount)}"
}

/*
 * 📌 Section 3 — ❌ Hardcoding same values in multiple places
 */
fun section3_BadApiUsage() {
    val baseUrl = "https://api.example.com/"
    val loginEndpoint = baseUrl + "auth/login"
    val profileEndpoint = baseUrl + "user/profile"
    // elsewhere...
    val hardcodedAgain = "https://api.example.com/user/profile"
}

/*
 * 🧠 What You Will Learn:
 * - What WET code looks like in real Kotlin projects
 * - The risk of repeating logic, literals, and structure
 * - Why refactor opportunities often hide in "copy-paste" habits
 */

/*
 * 🚀 Quick Summary:
 * ❌ WET = duplicated logic, config, and structure
 * ❌ Hard to update, easy to forget
 * ❌ Easy to break one and not the other

 * ✅ DRY > WET always
 */

/*
 * 📘 Key Takeaways:
 * - Don’t repeat logic across files → extract it
 * - Don’t repeat values → centralize constants/config
 * - Don’t repeat formatting → use extensions/helpers

 * 💡 Real-World Use Cases:
 * - Copy-pasted validation
 * - Hardcoded strings, endpoints, DB queries
 * - Repeated View logic or Adapter boilerplate

 * 🧼 Clean Code Insight:
 * If you see the **same logic more than once**, pause and ask:
 * "Can this be moved to a function, class, or constant?"
 */
