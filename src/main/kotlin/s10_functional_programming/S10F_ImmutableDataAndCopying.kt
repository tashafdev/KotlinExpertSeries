package s10_functional_programming


/*
 * -----------------------------------------------------
 * ✅ Lecture: Immutable Data & Copying in Kotlin
 * -----------------------------------------------------
 * Functional programming favours **immutability** over mutation.
 *
 * Kotlin makes this easy with:
 * 🔹 `val` declarations
 * 🔹 `data class` with `copy()` function
 * 🔹 Avoiding side-effects and mutable state
 */

/*
 * 📌 Section 1 — Using `val` to ensure immutability
 */
fun section1_ImmutableValExample() {
    val name = "Tashy"
    // name = "Someone else" ❌ Compile error – reassignment not allowed
    println("🛡️ Immutable name = $name")
}

/*
 * 📌 Section 2 — Immutable `data class` with `copy()`
 */
data class User(val name: String, val age: Int)

fun section2_DataClassCopyExample() {
    val user1 = User("Tashy", 28)
    val user2 = user1.copy(age = 29)

    println("👤 Original user: $user1")
    println("🔁 Copied user: $user2")
}

/*
 * 📌 Section 3 — Avoiding side effects in functions
 */
fun section3_PureFunctionExample(a: Int, b: Int): Int {
    return a + b // ✅ Pure – no global access, same output for same input
}

// ❌ Impure example
var counter = 0
fun section3_ImpureFunctionExample() {
    counter++ // ⚠️ Not pure – causes side effect
}

/*
 * 📌 Section 4 — Working with immutable lists
 */
fun section4_ImmutableCollections() {
    val original = listOf("Kotlin", "Java", "Python")
    val modified = original + "Rust" // returns new list

    println("📦 Original: $original")
    println("📦 Modified: $modified")
}

/*
 * 🧠 What You Will Learn:
 * - Why immutability matters
 * - How to use `val` and `data class copy()` safely
 * - The difference between pure and impure functions
 * - How to work with immutable collections
 */

/*
 * 🚀 Quick Summary:
 * ✅ `val` → safe from reassignment
 * ✅ `copy()` → update without mutation
 * ✅ Avoid side effects in reusable logic
 * ✅ Use immutable collections for clean state
 */

/*
 * 📘 Key Takeaways:
 * - Immutability = predictable, thread-safe, and testable code
 * - Pure functions should not rely on or modify global state
 * - Immutable data makes debugging and reasoning easier

 * 💡 Real-World Use Cases:
 * - ViewModel UI State
 * - Redux/MVI architecture
 * - Domain model transformations

 * 🧼 Clean Code Insight:
 * Treat all core logic as **stateless + immutable**.
 * Mutate only in tightly controlled layers (like repositories or reducers).
 */
