package s19_clean_code_and_principles.s19b_dry_vs_wet


/*
 * -----------------------------------------------------
 * 🔧 Refactoring to DRY (Don't Repeat Yourself)
 * -----------------------------------------------------
 * DRY isn’t just a principle — it’s a mindset.
 *
 * In this lecture, we’ll:
 * 🔹 Take WET code from real-world scenarios
 * 🔹 Refactor it into clean, DRY Kotlin
 * 🔹 Use Kotlin features like extensions, sealed classes, constants
 */

/*
 * 📌 Section 1 — ❌ WET Example: Duplicated validation logic
 */
fun section1_Original_ValidateUserFormA(name: String, email: String): Boolean {
    return name.isNotBlank() && email.contains("@")
}

fun section1_Original_ValidateUserFormB(name: String, email: String): Boolean {
    return name.isNotBlank() && email.contains("@")
}

/*
 * ✅ Refactored using shared function
 */
fun isUserInputValid(name: String, email: String): Boolean {
    return name.isNotBlank() && email.contains("@")
}

fun section1_Refactored_UseDRY() {
    println("Form A valid: ${isUserInputValid("Tashy", "t@e.com")}")
    println("Form B valid: ${isUserInputValid("Boss", "b@e.com")}")
}

/*
 * 📌 Section 2 — ❌ WET Example: Duplicated status handling
 */
fun section2_BadStatusText(code: Int): String {
    return when (code) {
        1 -> "Pending"
        2 -> "Approved"
        3 -> "Rejected"
        else -> "Unknown"
    }
}

fun section2_BadStatusColor(code: Int): String {
    return when (code) {
        1 -> "Yellow"
        2 -> "Green"
        3 -> "Red"
        else -> "Gray"
    }
}

/*
 * ✅ Refactored using sealed class
 */
sealed class Status(val label: String, val color: String) {
    object Pending : Status("Pending", "Yellow")
    object Approved : Status("Approved", "Green")
    object Rejected : Status("Rejected", "Red")
    object Unknown : Status("Unknown", "Gray")

    companion object {
        fun from(code: Int): Status = when (code) {
            1 -> Pending
            2 -> Approved
            3 -> Rejected
            else -> Unknown
        }
    }
}

fun section2_Refactored_StatusDRY(code: Int) {
    val status = Status.from(code)
    println("Label: ${status.label}, Color: ${status.color}")
}

/*
 * 🧠 What You Will Learn:
 * - How to spot and refactor duplicated code
 * - Use shared functions, sealed classes, and constants to stay DRY
 * - Kotlin features to help reduce WETness
 */

/*
 * 🚀 Quick Summary:
 * ✅ DRY = reuse, centralize, refactor
 * ✅ Kotlin makes DRY easy with:
 *    - Functions
 *    - Extensions
 *    - Sealed classes
 *    - Data modeling
 */

/*
 * 📘 Key Takeaways:
 * - DRY saves time, bugs, and mental overload
 * - Even small bits of duplication add up
 * - Make reuse your default instinct 💡

 * 💡 Real-World Use Cases:
 * - Repeated business rules across features
 * - Enum-like switch logic in multiple screens
 * - API mappings and UI models

 * 🧼 Clean Code Insight:
 * DRY = Write once, use everywhere.
 * Repetition = 🚨 Refactor opportunity.
 */
