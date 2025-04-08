package s19_clean_code_and_principles.s19c_kiss_yagni


/*
 * -----------------------------------------------------
 * ✅ Clean Code Principle: KISS — Keep It Simple, Stupid
 * -----------------------------------------------------
 * The KISS principle reminds us:
 * 🔹 Simpler code is easier to read, test, and maintain.
 * 🔹 Complex logic should be **avoided** unless absolutely needed.
 *
 * “Clever” ≠ “Good”. Clear code > smart code.
 */

/*
 * 📌 Section 1 — ❌ Overengineered logic for a simple task
 */
fun section1_OverComplicatedLogic(input: String): String {
    val reversed = input.toCharArray().reversed().joinToString("")
    val mapped = reversed.mapIndexed { index, char -> char + index }.joinToString()
    return mapped
    // ❌ Unclear, hard to reason, unnecessary transformation
}

/*
 * ✅ KISS: Simple, meaningful logic
 */
fun section1_SimpleReverse(input: String): String {
    return input.reversed()
}

/*
 * 📌 Section 2 — ❌ Trying to build generic abstractions too early
 */
fun <T> doSomethingWithCallback(data: T, callback: (T) -> Unit) {
    callback(data)
}

fun section2_GenericOverkill() {
    doSomethingWithCallback("Hello") {
        println("👋 $it")
    }
    // ❌ Was a plain `println` really needing a generic + callback?
}

/*
 * ✅ Simpler alternative
 */
fun section2_JustDoTheThing() {
    val message = "Hello"
    println("👋 $message")
}

/*
 * 🧠 What You Will Learn:
 * - Why simplicity wins in most cases
 * - How overengineering creeps into code
 * - When to simplify vs abstract
 */

/*
 * 🚀 Quick Summary:
 * ✅ KISS = Simple logic wins
 * ✅ Avoid “flexibility” unless needed
 * ✅ Don't hide intent behind complexity
 */

/*
 * 📘 Key Takeaways:
 * - If it looks smart but feels confusing — simplify it
 * - Choose clear, readable code over premature abstraction
 * - Refactor **after** the problem is real, not before

 * 💡 Real-World Use Cases:
 * - Avoiding unnecessary sealed hierarchies or factories
 * - Preferring simple `if`/`when` over complex state machines
 * - Using plain Kotlin syntax when DSLs aren't needed

 * 🧼 Clean Code Insight:
 * Ask: “Can someone else understand this in 5 seconds?”
 * If not, it’s time to KISS 😘
 */
