package s10_functional_programming


/*
 * -----------------------------------------------------
 * ✅ Lecture: Functional Error Handling in Kotlin
 * -----------------------------------------------------
 * Instead of relying solely on `try/catch`, Kotlin encourages functional-style
 * error handling using:
 * 🔹 `Result<T>` API
 * 🔹 `runCatching { }`
 * 🔹 `sealed class` for custom success/failure types
 *
 * This leads to **cleaner, declarative, and safer** code 💡
 */

/*
 * 📌 Section 1 — Using `runCatching` and Result<T>
 */
fun section1_RunCatchingExample() {
    val result = runCatching {
        val a = 10
        val b = 0
        a / b // ❌ Will throw ArithmeticException
    }

    result
        .onSuccess { println("✅ Success: $it") }
        .onFailure { println("❌ Error: ${it.message}") }
}

/*
 * 📌 Section 2 — Chaining with map / mapCatching / recover
 */
fun section2_ResultChaining() {
    val result = runCatching { "123".toInt() }
        .map { it * 2 }
        .recover { -1 }

    println("🔁 Final value: $result") // 246 or fallback -1
}

/*
 * 📌 Section 3 — Functional wrapper with sealed class
 */
sealed class OperationResult<out T>
data class Success<T>(val data: T) : OperationResult<T>()
data class Failure(val error: String) : OperationResult<Nothing>()

fun safeDivide(a: Int, b: Int): OperationResult<Int> {
    return if (b == 0) Failure("Division by zero")
    else Success(a / b)
}

fun section3_SealedResultExample() {
    when (val result = safeDivide(10, 2)) {
        is Success -> println("✅ Success: ${result.data}")
        is Failure -> println("❌ Error: ${result.error}")
    }
}

/*
 * 📌 Section 4 — Custom higher-order error handling
 */
inline fun <T> section4_HandleSafely(block: () -> T): OperationResult<T> {
    return try {
        Success(block())
    } catch (e: Exception) {
        Failure("💥 Exception: ${e.message}")
    }
}

fun section4_CustomSafeWrapperExample() {
    val result = section4_HandleSafely {
        "456".toInt()
    }

    println("🛡️ Wrapped result = $result")
}

/*
 * 🧠 What You Will Learn:
 * - Handling errors without `try/catch` everywhere
 * - Using `Result<T>` and `runCatching`
 * - Creating sealed classes for predictable flow
 * - Building custom safe-execution wrappers
 */

/*
 * 🚀 Quick Summary:
 * ✅ `runCatching` = try/catch + result in one line
 * ✅ `Result.map` / `recover` = functional error flow
 * ✅ Sealed classes = explicit, safe, exhaustively handled
 */

/*
 * 📘 Key Takeaways:
 * - Stop throwing exceptions from regular business logic
 * - Return Result or sealed class and handle at call site
 * - Encourages predictable and testable code paths

 * 💡 Real-World Use Cases:
 * - Networking (API success/error)
 * - DB operations
 * - ViewModel logic with UI states

 * 🧼 Clean Code Insight:
 * Avoid `try/catch` pollution. Wrap risky operations into expressive, reusable safe functions.
 */
