package s10_functional_programming



/*
 * -----------------------------------------------------
 * ✅ Lecture: Function Composition in Kotlin
 * -----------------------------------------------------
 * Function Composition = combining multiple functions into a single pipeline.
 *
 * It helps break problems into small reusable pieces and **chain logic together**
 * in a clean, declarative style.
 */

/*
 * 📌 Section 1 — Compose two functions manually
 */
fun section1_ManualFunctionComposition() {
    val double: (Int) -> Int = { it * 2 }
    val increment: (Int) -> Int = { it + 1 }

    val doubleThenIncrement = { x: Int -> increment(double(x)) }

    println("👉 Composed manually: ${doubleThenIncrement(5)}") // Output: 11
}

/*
 * 📌 Section 2 — Reusable `compose()` extension (f(g(x)))
 * Applies function **right to left**: outer.compose(inner)
 */
infix fun <A, B, C> ((B) -> C).compose(inner: (A) -> B): (A) -> C {
    return { x -> this(inner(x)) }
}

fun section2_ReusableComposeFunction() {
    val double: (Int) -> Int = { it * 2 }
    val increment: (Int) -> Int = { it + 1 }

    val composed = increment compose double // increment(double(x))
    println("📦 Using compose(): ${composed(4)}") // Output: 9
}

/*
 * 📌 Section 3 — Reusable `andThen()` extension (g(f(x)))
 * Applies function **left to right**: first.andThen(next)
 */
infix fun <A, B, C> ((A) -> B).andThen(next: (B) -> C): (A) -> C {
    return { x -> next(this(x)) }
}

fun section3_ReusableAndThenFunction() {
    val double: (Int) -> Int = { it * 2 }
    val increment: (Int) -> Int = { it + 1 }

    val andThen = double andThen increment // increment(double(x))
    println("➡️ Using andThen(): ${andThen(4)}") // Output: 9
}

/*
 * 📌 Section 4 — Chaining multiple functions in a pipeline
 */
fun section4_ChainingMultipleFunctions() {
    val square: (Int) -> Int = { it * it }
    val half: (Int) -> Int = { it / 2 }
    val toLabel: (Int) -> String = { "Result = $it" }

    val pipeline = square andThen half andThen toLabel

    println("🧪 Final pipeline output: ${pipeline(6)}") // Output: Result = 18
}

/*
 * 🧠 What You Will Learn:
 * - How to manually compose functions
 * - Create reusable `compose()` and `andThen()` extensions
 * - Use composition for chaining transformations
 */

/*
 * 🚀 Quick Summary:
 * ✅ `compose(f, g)` = f(g(x)) — right to left
 * ✅ `andThen(f, g)` = g(f(x)) — left to right
 * ✅ Use for chaining small functions into powerful pipelines
 */

/*
 * 📘 Key Takeaways:
 * - Improves modularity and reusability
 * - Reduces nested or imperative code
 * - Easy to test and refactor
 */

/*
 * 💡 Real-World Use Cases:
 * - Input validation pipelines
 * - Business logic transformation layers
 * - Formatter chains (e.g. UI → Domain → DB models)
 */

/*
 * 🧼 Clean Code Insight:
 * Small pure functions + composition = beautiful code.
 * Don’t overuse clever chaining—clarity is king 👑
 */
