package s9_coroutines


import kotlinx.coroutines.*

/*
 * -----------------------------------------------------
 * ✅ Lecture: Introduction to Coroutines
 * -----------------------------------------------------
 * Coroutines are Kotlin’s lightweight concurrency tool.
 *
 * 🔹 Suspendable, non-blocking way to write asynchronous code
 * 🔹 Powered by structured concurrency + cooperative cancellation
 * 🔹 Built on top of regular threads, but more efficient
 *
 * Think of coroutines as "threads-lite" 🧵✨
 */

// Step 1️⃣: Basic coroutine using `launch`
fun main() {
    println("🔵 Main starts on thread: ${Thread.currentThread().name}")

    runBlocking {
        launch {
            delay(1000)
            println("🟢 Coroutine 1 on thread: ${Thread.currentThread().name}")
        }

        launch {
            delay(500)
            println("🟢 Coroutine 2 on thread: ${Thread.currentThread().name}")
        }

        println("⏳ Waiting for coroutines...")
    }

    println("🔵 Main ends")
}
