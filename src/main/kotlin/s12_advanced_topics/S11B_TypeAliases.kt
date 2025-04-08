package s12_advanced_topics


/*
 * -----------------------------------------------------
 * ✅ Kotlin Advanced — Type Aliases
 * -----------------------------------------------------
 * Type aliases let you give **custom names** to complex types.
 * 🔹 They don’t create new types
 * 🔹 They're just **shortcuts** for readability
 *
 * Think of them as safe nicknames for verbose or repeated types.
 */

/*
 * 📌 Section 1 — Simple alias
 */
typealias Username = String

fun s12b_typealias_simple() {
    val user: Username = "tashy_boss"
    println("👤 Username is: $user")
}

/*
 * 📌 Section 2 — Alias for function types
 */
typealias ClickListener = (Int) -> Unit

fun s12b_typealias_functionType(listener: ClickListener) {
    listener(5)
}

/*
 * 📌 Section 3 — Alias for generic/multilevel types
 */
typealias UserMap = Map<String, List<Pair<Int, String>>>

fun s12b_typealias_forGenerics() {
    val users: UserMap = mapOf(
        "devs" to listOf(1 to "Tashy", 2 to "Boss")
    )
    println("👥 Team: $users")
}

/*
 * 📌 Section 4 — TypeAlias + Class Interop
 */
class ApiResult<T>(val data: T?, val error: String?)
typealias StringResult = ApiResult<String>

fun s12b_typealias_withClass() {
    val result: StringResult = ApiResult("Success!", null)
    println("📦 Result: ${result.data}")
}

/*
 * 🧠 What You Will Learn:
 * - When to use `typealias` to simplify code
 * - How aliases make code more expressive
 * - What NOT to use them for (actual new types)

 * 🚀 Quick Summary:
 * ✅ `typealias` = rename an existing type
 * ✅ Great for readability and repeated types
 * ❌ Doesn’t introduce new behavior or validation

 * 💡 Real-World Use Cases:
 * - Clean up complex generics
 * - Express domain intent (e.g., `UserId`, `ProductName`)
 * - Simplify higher-order function types (e.g., `ClickListener`)

 * 🧼 Clean Code Insight:
 * Typealias is like giving your code a better vocabulary.
 * Use it where it makes your logic **speak clearly**.
 */
