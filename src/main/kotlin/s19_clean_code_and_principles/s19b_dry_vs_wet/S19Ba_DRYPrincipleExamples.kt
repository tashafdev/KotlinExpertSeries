package s19_clean_code_and_principles.s19b_dry_vs_wet


/*
 * -----------------------------------------------------
 * ✅ Clean Code Principle: DRY – Don't Repeat Yourself
 * -----------------------------------------------------
 * DRY = Every piece of knowledge must have a single, unambiguous representation.
 *
 * Avoid copy-pasting logic. Instead, **extract** and **reuse**.
 * Duplication leads to bugs, inconsistencies, and extra maintenance.
 */

/*
 * 📌 Section 1 — ❌ Violation: Duplicated logic across functions
 */
fun section1_CalculateDiscountBad(price: Double, type: String): Double {
    return when (type) {
        "STUDENT" -> price - (price * 0.1)
        "SENIOR" -> price - (price * 0.2)
        else -> price
    }
}

fun section1_ShowDiscountLabelBad(type: String): String {
    return when (type) {
        "STUDENT" -> "10% discount"
        "SENIOR" -> "20% discount"
        else -> "No discount"
    }
}

/*
 * 📌 Section 2 — ✅ DRY-Compliant: Use shared data structure
 */
val discountMap = mapOf(
    "STUDENT" to 0.10,
    "SENIOR" to 0.20
)

fun section2_CalculateDiscountGood(price: Double, type: String): Double {
    val discount = discountMap[type] ?: 0.0
    return price - (price * discount)
}

fun section2_ShowDiscountLabelGood(type: String): String {
    val discount = discountMap[type]
    return if (discount != null) "${(discount * 100).toInt()}% discount"
    else "No discount"
}

/*
 * 📌 Section 3 — DRY with reusable extension function
 */
fun Double.applyDiscount(rate: Double): Double = this - (this * rate)

fun section3_UseExtensionToDRY(price: Double, type: String): Double {
    val discount = discountMap[type] ?: 0.0
    return price.applyDiscount(discount)
}

/*
 * 🧠 What You Will Learn:
 * - What is DRY and how duplication hurts
 * - How to identify similar logic and extract it
 * - Using Kotlin features like maps & extensions to stay DRY
 */

/*
 * 🚀 Quick Summary:
 * ✅ DRY = eliminate repetition, centralize logic
 * ✅ Use shared data, helper methods, and reuse patterns
 * ✅ In Kotlin: use `when`, maps, extensions, sealed classes, etc.
 */

/*
 * 📘 Key Takeaways:
 * - Duplication multiplies bugs and increases refactor cost
 * - DRY improves maintainability and consistency
 * - You DRY up UI, logic, config, and even error handling

 * 💡 Real-World Use Cases:
 * - Repeated logic in ViewModels, adapters, or utilities
 * - Status mapping, error messages, color codes
 * - Redundant `when`/`if` chains across layers

 * 🧼 Clean Code Insight:
 * If you update code in one place but forget to do it elsewhere,
 * it means you **violated DRY**. Reuse > Rewrite.
 */
