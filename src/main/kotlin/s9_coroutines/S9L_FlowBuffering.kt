package s9_coroutines


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*
 * -----------------------------------------------------
 * ✅ Kotlin Coroutines: Flow Buffering & Backpressure
 * -----------------------------------------------------
 * Flow collects **sequentially** by default → slow collector = slow flow
 *
 * Buffering helps:
 * 🔸 Improve performance
 * 🔸 Decouple emit from collect
 * 🔸 Control backpressure
 *
 * Key operators:
 * - `buffer()` → queue emissions ahead of collector
 * - `conflate()` → skip intermediate values
 * - `collectLatest()` → cancel previous collection on new item
 */

/*
 * 📌 Section 1 — Default behavior (sequential)
 */
fun s9l_flowWithoutBuffer(): Flow<Int> = flow {
    repeat(3) {
        println("⚙️ Emitting $it")
        emit(it)
        delay(100)
    }
}

fun s9l_collectWithoutBuffer() = runBlocking {
    s9l_flowWithoutBuffer().collect {
        delay(300)
        println("📥 Collected $it")
    }
}

/*
 * 📌 Section 2 — Use `buffer()` to allow emitter to run ahead
 */
fun s9l_collectWithBuffer() = runBlocking {
    s9l_flowWithoutBuffer()
        .buffer()
        .collect {
            delay(300)
            println("🚀 Collected with buffer: $it")
        }
}

/*
 * 📌 Section 3 — Use `conflate()` to skip values when collector lags
 */
fun s9l_collectWithConflate() = runBlocking {
    s9l_flowWithoutBuffer()
        .conflate()
        .collect {
            delay(300)
            println("⚡ Collected with conflate: $it")
        }
}

/*
 * 📌 Section 4 — Use `collectLatest()` to cancel previous collector
 */
fun s9l_collectWithLatest() = runBlocking {
    flow {
        repeat(3) {
            emit(it)
            delay(100)
        }
    }.collectLatest { value ->
        println("⚠️ Start collecting $value")
        delay(300)
        println("✅ Done with $value")
    }
}

/*
 * 🧠 What You Will Learn:
 * - Default Flow behavior is sequential: emit → collect → emit
 * - `buffer()` queues emissions in parallel
 * - `conflate()` skips intermediate values
 * - `collectLatest()` cancels ongoing collector job
 */

/*
 * 🚀 Quick Summary:
 * ✅ `buffer()` → parallelizes emit/collect (good for performance)
 * ✅ `conflate()` → keeps only latest value
 * ✅ `collectLatest()` → resets processing if new data comes in

 * 💡 Real-World Use Cases:
 * - Live search UI (cancel ongoing job with `collectLatest`)
 * - High-frequency sensors/data (use `conflate`)
 * - Stream + database sync (use `buffer()`)

 * 🧼 Clean Code Insight:
 * If your flow emits fast but collects slow — buffer it.
 * If your flow doesn't care about old values — conflate it.
 * If your flow must cancel old jobs — `collectLatest` is 🔑
 */
