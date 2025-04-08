package s10_functional_programming


/*
 * -----------------------------------------------------
 * ✅ Lecture: Partial Application & Currying in Kotlin
 * -----------------------------------------------------
 * These are **advanced functional concepts** used to:
 * 🔹 Fix or "pre-fill" arguments (Partial Application)
 * 🔹 Convert multi-arg functions into chained single-arg ones (Currying)
 *
 * They're useful for breaking down logic, improving reuse, and building custom DSLs.
 */

/*
 * 📌 Section 1 — Partial Application: Fixing one argument
 */
fun section1_PartialApplication() {
    fun multiply(a: Int, b: Int): Int = a * b

    // Partially apply first argument
    fun partialMultiplyBy(fixed: Int): (Int) -> Int = { b -> multiply(fixed, b) }

    val multiplyBy3 = partialMultiplyBy(3)
    println("🔢 multiplyBy3(5) = ${multiplyBy3(5)}") // Output: 15
}

/*
 * 📌 Section 2 — Currying: Breaking a multi-arg function into chained 1-arg functions
 */
fun section2_CurryingExample() {
    fun curriedAdd(a: Int): (Int) -> (Int) -> Int = { b -> { c -> a + b + c } }

    val step1 = curriedAdd(2)     // (b) -> (c) -> result
    val step2 = step1(3)          // (c) -> result
    val result = step2(5)         // 2 + 3 + 5 = 10

    println("📦 Curried sum = $result")
}

/*
 * 📌 Section 3 — Currying helper extension (2-arg function only)
 */
fun <A, B, R> ((A, B) -> R).curry(): (A) -> (B) -> R {
    return { a -> { b -> this(a, b) } }
}

fun section3_CurryExtensionExample() {
    val multiply: (Int, Int) -> Int = { a, b -> a * b }

    val curriedMultiply = multiply.curry()
    val times2 = curriedMultiply(2)

    println("🧠 Curried times2(6) = ${times2(6)}") // Output: 12
}

/*
 * 🧠 What You Will Learn:
 * - How to implement partial application
 * - How to break functions into curried chains
 * - When and why currying is useful in Kotlin
 */

/*
 * 🚀 Quick Summary:
 * ✅ Partial Application = fix one or more arguments ahead of time
 * ✅ Currying = break f(a, b, c) → f(a)(b)(c)
 * ✅ Useful for chaining and reusability
 */

/*
 * 📘 Key Takeaways:
 * - Compose and reuse logic by "pre-filling" functions
 * - Currying encourages small, testable components
 * - Helps create readable DSL-like APIs

 * 💡 Real-World Use Cases:
 * - Functional pipelines
 * - Reusing transformation steps
 * - Kotlin DSLs or use-case builders

 * 🧼 Clean Code Insight:
 * Don’t force currying in every case — it shines best in layered business logic or reusable components.
 */
