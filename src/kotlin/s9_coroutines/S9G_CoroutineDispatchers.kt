package kotlin.s9_coroutines

package kotlin.s9_coroutines

import kotlinx.coroutines.*

/*
 * ---------------------------------------------------------------------
 * ✅ Lecture: Coroutine Dispatchers in Kotlin
 * ---------------------------------------------------------------------
 * Dispatchers decide **which thread** your coroutine runs on.
 *
 * 🔹 Dispatchers.Default → CPU-bound tasks (parallel calc, sorting)
 * 🔹 Dispatchers.IO → I/O-bound work (network, DB, file read)
 * 🔹 Dispatchers.Main → UI work (Android only)
 * 🔹 Dispatchers.Unconfined → Inherit current thread (rarely used)
 */

// Step 1️⃣: Default dispatcher - CPU-heavy work
fun usingDefaultDispatcher() = runBlocking {
    launch(Dispatchers.Default) {
        println("🧠 Doing CPU work on: ${Thread.currentThread().name}")
    }
}

// Step 2️⃣: IO dispatcher - good for file/network
fun usingIODispatcher() = runBlocking {
    launch(Dispatchers.IO) {
        println("💾 Doing I/O work on: ${Thread.currentThread().name}")
    }
}

// Step 3️⃣: Unconfined dispatcher (for testing / edge cases)
fun usingUnconfinedDispatcher() = runBlocking {
    launch(Dispatchers.Unconfined) {
        println("🌀 Unconfined runs on: ${Thread.currentThread().name}")
        delay(100)
        println("🌀 After delay: ${Thread.currentThread().name}")
    }
}

// Step 4️⃣: Dispatcher inheritance
fun dispatcherInheritance() = runBlocking(Dispatchers.IO) {
    println("🧬 Parent context: ${Thread.currentThread().name}")

    launch {
        println("🔗 Child (inherits IO): ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) {
        println("🔀 Explicit Default: ${Thread.currentThread().name}")
    }
}

// Step 5️⃣: Run all
fun main() {
    usingDefaultDispatcher()
    usingIODispatcher()
    usingUnconfinedDispatcher()
    dispatcherInheritance()
}