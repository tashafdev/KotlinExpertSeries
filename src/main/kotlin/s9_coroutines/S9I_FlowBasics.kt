package s9_coroutines


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*
 * -----------------------------------------------------
 * ✅ Kotlin Coroutines: Flow Basics
 * -----------------------------------------------------
 * Flow = Cold, asynchronous **stream** of values.
 * Think of it as a suspendable version of Sequence.
 *
 * Useful for:
 * 🔹 Emitting multiple values over time
 * 🔹 Chaining operators like map/filter
 * 🔹 Working in a coroutine-safe, reactive style
 */

/*
 * 📌 Section 1 — Creating a Flow
 */
fun section1_createSimpleFlow(): Flow<Int> = flow {
    emit(1)
    delay(100)
    emit(2)
    delay(100)
    emit(3)
}

/*
 * 📌 Section 2 — Collecting from a Flow
 */
fun section2_collectSimpleFlow() = runBlocking {
    println("🔄 Collecting flow...")
    section1_createSimpleFlow().collect { value ->
        println("🟢 Received: $value")
    }
}

/*
 * 📌 Section 3 — Difference from suspend function
 */
suspend fun getUserName(): String {
    delay(200)
    return "Tashy"
}

fun section3_compareSuspendVsFlow() = runBlocking {
    val name = getUserName()
    println("✅ suspend returns one value: $name")

    val flow = flowOf("Tashy", "Boss", "Commander")
    flow.collect {
        println("🌊 Flow emits: $it")
    }
}

/*
 * 📌 Section 4 — Flow is cold (lazy until collected)
 */
fun section4_coldNature() = runBlocking {
    val myFlow = flow {
        println("🔥 Flow started")
        emit("A")
        emit("B")
    }

    println("❄️ Nothing happens yet...")
    delay(500)
    println("📥 Starting collection...")
    myFlow.collect { println("👉 $it") }
}

/*
 * 🧠 What You Will Learn:
 * - How Flow represents a cold async stream
 * - How to create, emit, and collect values
 * - Flow vs suspend function difference
 */

/*
 * 🚀 Quick Summary:
 * ✅ Flow is suspend-aware and lazy
 * ✅ Can emit multiple values
 * ✅ Collected inside coroutine builders (e.g. `launch`, `runBlocking`)
 */

/*
 * 📘 Key Takeaways:
 * - Flows are cold = only start on collection
 * - Best used for streams like database updates, UI events, timers, etc.
 * - Use `.collect { }` to get values

 * 💡 Real-World Use Cases:
 * - Live search
 * - Pagination
 * - Timer-based UI (countdowns, updates)
 * - Sensor/data streaming

 * 🧼 Clean Code Insight:
 * Prefer Flow over callbacks or custom listeners for stream-like patterns.
 * It’s composable, testable, and coroutine-native.
 */
