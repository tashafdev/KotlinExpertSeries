package s19_clean_code_and_principles.s19d_code_smells


/*
 * -----------------------------------------------------
 * ❌ Code Smell: Duplicated Code
 * -----------------------------------------------------
 * Duplicated code is one of the **most common** and **most dangerous** smells.
 *
 * 🔁 It increases bugs, maintenance time, and effort.
 * DRY principle exists to eliminate this: **Don't Repeat Yourself**.
 */

/*
 * 📌 Section 1 — ❌ Same logic copy-pasted across features
 */
fun section1_CalculateTax_ProductA(price: Double): Double {
    return price * 0.18
}

fun section1_CalculateTax_ProductB(price: Double): Double {
    return price * 0.18
}

/*
 * ✅ Refactor: Move to reusable function
 */
fun calculateGST(price: Double): Double = price * 0.18

fun section1_CalculateTax_Refactored() {
    println("🧾 Product A: ${calculateGST(100.0)}")
    println("🧾 Product B: ${calculateGST(250.0)}")
}

/*
 * 📌 Section 2 — ❌ Repeating UI setup logic
 */
fun setupButtonA() {
    println("🎨 Set padding, textColor, background for Button A")
}

fun setupButtonB() {
    println("🎨 Set padding, textColor, background for Button B")
}

/*
 * ✅ Refactor to reusable helper
 */
fun setupCommonButtonStyle(name: String) {
    println("🎨 Styling for $name: padding, textColor, background")
}

fun section2_UseUIHelper() {
    setupCommonButtonStyle("Button A")
    setupCommonButtonStyle("Button B")
}

/*
 * 📌 Section 3 — DRY using extension functions
 */
fun Double.applyDiscount(rate: Double): Double = this - (this * rate)

fun section3_DiscountWithExtension() {
    println("💵 Final price: ${250.0.applyDiscount(0.2)}")
}

/*
 * 🧠 What You Will Learn:
 * - How duplication sneaks into logic and UI
 * - How to extract reusable helpers
 * - Using Kotlin's power (extensions, functions, constants) to stay DRY
 */

/*
 * 🚀 Quick Summary:
 * ❌ Duplication = wasted effort, more bugs
 * ✅ DRY = centralize logic once, reuse everywhere
 */

/*
 * 📘 Key Takeaways:
 * - Always ask: “Did I just copy-paste?”
 * - Extract shared code into:
 *     - Functions
 *     - Extensions
 *     - Constants
 *     - Helpers

 * 💡 Real-World Use Cases:
 * - Form validations
 * - Network retries
 * - Styling logic across multiple screens

 * 🧼 Clean Code Insight:
 * Copy-paste feels fast. But it’s a **trap**.
 * Refactor once → sleep better forever 😴
 */
