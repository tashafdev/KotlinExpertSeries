package s10_functional_programming


/*
 * -----------------------------------------------------
 * ✅ Lecture: Functional Collection Operations in Kotlin
 * -----------------------------------------------------
 * Kotlin collections support a wide range of **functional-style operators** like:
 * 🔹 map, filter, reduce, fold, flatMap
 * 🔹 all, any, none, count
 *
 * These allow for declarative, clean, and testable data transformations 🚀
 */

/*
 * 📌 Section 1 — Mapping and filtering collections
 */
fun section1_MapAndFilterExample() {
    val numbers = listOf(1, 2, 3, 4, 5)

    val squared = numbers.map { it * it }
    val even = numbers.filter { it % 2 == 0 }

    println("🟦 Squared: $squared") // [1, 4, 9, 16, 25]
    println("🟩 Even: $even")       // [2, 4]
}

/*
 * 📌 Section 2 — Folding and reducing values
 */
fun section2_FoldAndReduceExample() {
    val numbers = listOf(1, 2, 3, 4, 5)

    val sum = numbers.reduce { acc, i -> acc + i }         // No initial value
    val product = numbers.fold(1) { acc, i -> acc * i }    // Starts from 1

    println("➕ Sum (reduce): $sum")       // 15
    println("✖️ Product (fold): $product") // 120
}

/*
 * 📌 Section 3 — flatMap for nested list transformations
 */
fun section3_FlatMapExample() {
    val chars = listOf("a", "b", "c")
    val transformed = chars.flatMap { listOf(it, it.uppercase()) }

    println("🔀 flatMap result: $transformed") // [a, A, b, B, c, C]
}

/*
 * 📌 Section 4 — Using all/any/none/count
 */
fun section4_CollectionPredicatesExample() {
    val items = listOf(3, 5, 7, 9)

    println("✅ All odd? ${items.all { it % 2 != 0 }}")
    println("❓ Any divisible by 4? ${items.any { it % 4 == 0 }}")
    println("🚫 None negative? ${items.none { it < 0 }}")
    println("🔢 Count > 5: ${items.count { it > 5 }}")
}

/*
 * 📌 Section 5 — Lazy sequences for better performance
 */
fun section5_UsingSequences() {
    val numbers = (1..1000).toList()

    val result = numbers
        .asSequence()
        .filter { it % 2 == 0 }
        .map { it * it }
        .take(5)
        .toList()

    println("🦥 Lazy result: $result") // [4, 16, 36, 64, 100]
}

/*
 * 🧠 What You Will Learn:
 * - Core collection operators in functional style
 * - Transforming, filtering, reducing lists declaratively
 * - When to use sequences for large/streamed data
 */

/*
 * 🚀 Quick Summary:
 * ✅ `map`, `filter` → transform/filter values
 * ✅ `fold`, `reduce` → accumulate results
 * ✅ `flatMap` → flatten nested lists
 * ✅ `asSequence()` → lazy processing chain
 */

/*
 * 📘 Key Takeaways:
 * - Functional collections = cleaner + reusable + immutable logic
 * - Use `fold()` for initial value, `reduce()` when initial isn’t needed
 * - Sequences prevent unnecessary intermediate list creations

 * 💡 Real-World Use Cases:
 * - Transforming API results
 * - Preparing data for RecyclerViews
 * - Reactive-style ViewModel logic

 * 🧼 Clean Code Insight:
 * Prefer chaining + immutability. Avoid `for` loops unless necessary.
 * Break chains into named functions when logic gets long or nested.
 */
