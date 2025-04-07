package kotlin.s9_coroutines

package kotlin.s9_coroutines

import kotlinx.coroutines.*

/*
 * ----------------------------------------------------------------
 * ✅ Lecture: `launch` vs `async` in Kotlin Coroutines
 * ----------------------------------------------------------------
 * 🔹 `launch` → fire-and-forget (returns Job)
 * 🔹 `async` → returns a result (returns Deferred<T>)
 *
 * Both are builders to start new coroutines, but have different intent.
 */

// Step 1️⃣: Using launch - doesn't return a result
fun usingLaunch() = runBlocking {
    println("🚀 usingLaunch(): Starting...")

    val job = launch {
        delay(1000)
        println("✅ Task done (launch)")
    }

    println("🔄 Waiting for job to finish...")
    job.join() // Wait for coroutine to complete

    println("🏁 usingLaunch() done\n")
}

// Step 2️⃣: Using async - returns a result
fun usingAsync() = runBlocking {
    println("🚀 usingAsync(): Starting...")

    val deferred: Deferred<String> = async {
        delay(1000)
        "✅ Result from async"
    }

    println("🔄 Awaiting result...")
    val result = deferred.await()
    println("📦 Got result: $result")

    println("🏁 usingAsync() done\n")
}

// Step 3️⃣: Run both examples
fun main() {
    usingLaunch()
    usingAsync()
}
