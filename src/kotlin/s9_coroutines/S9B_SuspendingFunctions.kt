package kotlin.s9_coroutines

package kotlin.s9_coroutines

import kotlinx.coroutines.*

/*
 * ----------------------------------------------------------
 * ✅ Lecture: Suspending Functions in Kotlin
 * ----------------------------------------------------------
 * A `suspend` function can pause execution and resume later.
 * It can only be called from a coroutine or another suspend function.
 *
 * 🔹 Non-blocking → suspends the coroutine, not the thread
 * 🔹 Works with `delay()`, `withContext`, APIs like Retrofit, Room, etc.
 */

// Step 1️⃣: Define a suspend function
suspend fun downloadData(): String {
    println("📡 Downloading... (${Thread.currentThread().name})")
    delay(1500) // Pretend to do some IO
    return "✅ Data received"
}

// Step 2️⃣: Another suspend function that uses it
suspend fun processData() {
    println("🛠️ Processing...")
    val data = downloadData()
    println("📦 Processed: $data")
}

// Step 3️⃣: Call from runBlocking
fun main() = runBlocking {
    println("🚀 Starting suspending example")

    processData() // Calls both suspend functions

    println("🏁 Done")
}
