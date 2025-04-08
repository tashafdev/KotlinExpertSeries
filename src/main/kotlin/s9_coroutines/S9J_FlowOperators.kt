package s9_coroutines


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*
 * -----------------------------------------------------
 * ✅ Kotlin Coroutines: Flow Operators
 * -----------------------------------------------------
 * Flow is **powerful because of operators**.
 *
 * You can:
 * 🔹 Transform values (map, filter)
 * 🔹 Side-effect logging (onEach)
 * 🔹 Collect only a subset (take, drop)
 * 🔹 Combine, merge, flatten — all composably
 */

/*
 * 📌 Section 1 — `map`: Transform each value
 */
fun section1_useMapOperator(): Flow<String> = flowOf(1, 2, 3)
    .map { "Number $it" }

/*
 * 📌 Section 2 — `filter`: Select values by condition
 */
fun section2_useFilterOperator(): Flow<Int> = flowOf(10, 15, 20, 25)
    .filter { it > 15 }

/*
 * 📌 Section 3 — `onEach`: Side effects (e.g. logging)
 */
fun section3_useOnEach(): Flow<String> = flowOf("A", "B", "C")
    .onEach { println("🔍 Emitting: $it") }

/*
 * 📌 Section 4 — `take` & `drop`: Limit or skip emissions
 */
fun section4_useTakeAndDrop(): Flow<Int> = flowOf(1, 2, 3, 4, 5)
    .drop(2)
    .take(2)

/*
 * 📌 Section 5 — Collecting results
 */
fun section5_collectAllOperators() = runBlocking {
    println("🧪 Map:")
    section1_useMapOperator().collect { println("✅ $it") }

    println("\n🧪 Filter:")
    section2_useFilterOperator().collect { println("✅ $it") }

    println("\n🧪 OnEach:")
    section3_useOnEach().collect { println("✅ $it") }

    println("\n🧪 Take + Drop:")
    section4_useTakeAndDrop().collect { println("✅ $it") }
}

/*
 * 🧠 What You Will Learn:
 * - How to use core Flow operators: map, filter, onEach, take, drop
 * - Compose transformation pipelines with ease
 * - Add side-effects without breaking the chain
 */

/*
 * 🚀 Quick Summary:
 * ✅ Operators = pure, chainable functions
 * ✅ Combine them into pipelines for readable async logic
 * ✅ Powerful for processing UI/stream data

 * 💡 Real-World Use Cases:
 * - Transforming search queries
 * - Filtering user actions
 * - Limiting items for preview/lazy lists
 * - Debugging Flow emissions without altering them

 * 🧼 Clean Code Insight:
 * Flow operators are like Unix pipes —
 * Build small steps that work beautifully together 🔧
 */
