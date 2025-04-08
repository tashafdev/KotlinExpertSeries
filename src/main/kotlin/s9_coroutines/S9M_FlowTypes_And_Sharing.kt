package s9_coroutines


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*
 * -----------------------------------------------------
 * ✅ Kotlin Coroutines: Flow Types & Sharing
 * -----------------------------------------------------
 * Beyond basic `Flow`, Kotlin provides:
 *
 * 🔥 **Hot flows** — always active
 * ❄️ **Cold flows** — activate on collect
 *
 * 🔸 `StateFlow` → observable state holder (hot)
 * 🔸 `SharedFlow` → event broadcaster (hot)
 * 🔸 Use with `Mutable` prefix to emit values
 */

/*
 * 📌 Section 1 — Cold vs Hot Flow
 */
fun s9m_coldFlowExample(): Flow<Int> = flow {
    println("❄️ Cold flow started")
    emit(1)
    emit(2)
}

fun s9m_demoColdFlow() = runBlocking {
    val flow = s9m_coldFlowExample()
    println("🌙 Before collection")
    flow.collect { println("🧊 Collected: $it") }
}

/*
 * 📌 Section 2 — StateFlow (Hot stream, state holder)
 */
fun s9m_demoStateFlow() = runBlocking {
    val state = MutableStateFlow("🔵 Initial")

    val job = launch {
        state.collect {
            println("📡 StateFlow: $it")
        }
    }

    delay(500)
    state.value = "🟢 Updated"
    delay(500)
    state.value = "🔴 Final"
    delay(500)
    job.cancel()
}

/*
 * 📌 Section 3 — SharedFlow (Hot stream, emits to multiple collectors)
 */
fun s9m_demoSharedFlow() = runBlocking {
    val shared = MutableSharedFlow<String>()

    val collector1 = launch {
        shared.collect { println("🎧 Collector 1: $it") }
    }

    val collector2 = launch {
        shared.collect { println("🎧 Collector 2: $it") }
    }

    delay(200)
    shared.emit("📣 Hello")
    delay(200)
    shared.emit("📣 Again")

    delay(300)
    collector1.cancel()
    collector2.cancel()
}

/*
 * 📌 Section 4 — Key differences
 */
fun s9m_stateVsSharedSummary() {
    println(
        """
        🔍 Flow Type Summary:
        -----------------------------
        ❄️ Flow         - Cold stream, restart on collect
        🔥 StateFlow    - Hot stream, holds last value
        🔥 SharedFlow   - Hot stream, emits events to all collectors
        -----------------------------
        StateFlow = State holder (e.g. screen state)
        SharedFlow = One-time events (e.g. navigation, toast)
        """.trimIndent()
    )
}

/*
 * 🧠 What You Will Learn:
 * - Cold vs Hot streams
 * - How and when to use StateFlow vs SharedFlow
 * - When to convert Flow → hot stream using `.stateIn()` or `.shareIn()`
 */

/*
 * 🚀 Quick Summary:
 * ✅ Flow → cold, recreates logic on each collect
 * ✅ StateFlow → hot, keeps latest value
 * ✅ SharedFlow → hot, broadcasts emissions

 * 💡 Real-World Use Cases:
 * - ViewModel screen state = `StateFlow`
 * - Toast/event/navigation = `SharedFlow`
 * - Local storage / DB observation = `Flow`

 * 🧼 Clean Code Insight:
 * Use the right stream for the right job:
 * - UI state? → StateFlow
 * - UI events? → SharedFlow
 * - Cold logic/data? → Flow
 */
