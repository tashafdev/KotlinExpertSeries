package s9_coroutines




import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*
 * -----------------------------------------------------
 * ✅ Kotlin Coroutines: Flow Exception Handling
 * -----------------------------------------------------
 * Flows can fail just like suspend functions — we must handle:
 *
 * 🔸 Upstream errors (inside flow or operators) → with `catch {}`
 * 🔸 Completion (success or error) → with `onCompletion {}`
 * 🔸 Downstream errors (inside `collect {}`) → with `try/catch`
 */

/*
 * 📌 Section 1 — Simulate a failing flow
 */
fun s9k_flowWithRuntimeError(): Flow<Int> = flow {
    emit(1)
    emit(2)
    throw RuntimeException("💥 Simulated failure")
}

/*
 * 📌 Section 2 — ✅ Handle upstream error with `catch`
 */
fun s9k_handleErrorWithCatch() = runBlocking {
    s9k_flowWithRuntimeError()
        .catch { e -> println("❌ Caught in catch: ${e.message}") }
        .collect { value -> println("✅ Value: $value") }
}

/*
 * 📌 Section 3 — ✅ Use `onCompletion` to observe final state
 */
fun s9k_useOnCompletion() = runBlocking {
    s9k_flowWithRuntimeError()
        .onCompletion { cause ->
            if (cause == null) println("🎉 Flow completed normally")
            else println("⚠️ Flow ended with error: ${cause.message}")
        }
        .catch { e -> println("❌ Caught: ${e.message}") }
        .collect { println("📦 Emitted: $it") }
}

/*
 * 📌 Section 4 — ❌ Downstream error (e.g. inside `collect`)
 */
fun s9k_flowNoErrorButBadCollect(): Flow<String> = flowOf("One", "Two", "Three")

fun s9k_tryCatchAroundCollect() = runBlocking {
    try {
        s9k_flowNoErrorButBadCollect().collect {
            if (it == "Two") throw IllegalStateException("🔥 Invalid value")
            println("🟢 Received: $it")
        }
    } catch (e: Exception) {
        println("🚨 try/catch caught inside collect: ${e.message}")
    }
}

/*
 * 🧠 What You Will Learn:
 * - How to handle Flow errors from upstream vs downstream
 * - The order of `catch`, `onCompletion`, and `collect`
 * - Clean error handling for streaming use-cases
 */

/*
 * 🚀 Quick Summary:
 * ✅ `catch {}` → Handles exceptions in flow builder or operators
 * ✅ `onCompletion {}` → Always runs at end (success or failure)
 * ✅ `try/catch` → Only way to catch errors from inside `collect`

 * 💡 Real-World Use Cases:
 * - Retry on network failure
 * - Log analytics on flow completion
 * - Graceful UI fallback on exception

 * 🧼 Clean Code Insight:
 * Catch errors close to the source.
 * Fail loud, but clean.
 */
