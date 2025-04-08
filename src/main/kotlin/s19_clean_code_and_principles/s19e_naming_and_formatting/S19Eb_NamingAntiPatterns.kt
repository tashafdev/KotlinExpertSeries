package s19_clean_code_and_principles.s19e_naming_and_formatting


/*
 * -----------------------------------------------------
 * ❌ Naming Anti-Patterns
 * -----------------------------------------------------
 * Bad names lead to:
 * - Confusion 🤯
 * - Bugs 🐞
 * - Painful code reviews 😓
 *
 * Let’s explore **what NOT to do**, and how to fix it.
 */

/*
 * 📌 Section 1 — ❌ Vague & meaningless names
 */
fun doStuff(a: String, b: Int): Boolean {
    return a.length == b
}

fun section1_VagueNames() {
    val x = doStuff("Tashy", 5)
    println("x = $x")
}

/*
 * ✅ Fix: meaningful names
 */
fun isNameLengthEqual(name: String, expectedLength: Int): Boolean {
    return name.length == expectedLength
}

fun section1_GoodNames() {
    val isMatching = isNameLengthEqual("Tashy", 5)
    println("✅ Matches? $isMatching")
}

/*
 * 📌 Section 2 — ❌ Misleading names
 */
fun calculateTotalDiscount(price: Double): Double {
    return price * 0.05 // ❌ Only returns tax, not discount
}

/*
 * ✅ Fix: align name with behavior
 */
fun calculateTax(price: Double): Double {
    return price * 0.05
}

/*
 * 📌 Section 3 — ❌ Abbreviations that kill clarity
 */
val usrnm = "Tashy" // ❌ What is usrnm?

val userName = "Tashy" // ✅ Clear, expressive

/*
 * 📌 Section 4 — ❌ Prefix/suffix clutter
 */
class HelperUtilsManagerProcessorService // 😱 Who are you really?

class AuthService // ✅ Clear and sufficient

/*
 * 🧠 What You Will Learn:
 * - Real naming mistakes developers make
 * - How to refactor misleading or vague names
 * - Why clarity always beats cleverness
 */

/*
 * 🚀 Quick Summary:
 * ❌ Bad names = confusion, bugs, rework
 * ✅ Good names = meaning, alignment, clarity
 */

/*
 * 📘 Key Takeaways:
 * - Avoid generic terms like: `stuff`, `data`, `manager`, `thing`
 * - Avoid misleading verbs — `calculateTotal()` should actually calculate a total
 * - Don't abbreviate unless it's a standard (e.g., `URL`, `ID`)

 * 💡 Real-World Use Cases:
 * - Avoid `dataManager` or `helperUtils`
 * - Use `AuthService`, `UserRepository`, `ImageCompressor`
 * - Don’t name ViewModels as `MainVM` — use full purpose

 * 🧼 Clean Code Insight:
 * A good name explains itself.
 * A bad name hides its intention — and that’s a trap. 🔒
 */
