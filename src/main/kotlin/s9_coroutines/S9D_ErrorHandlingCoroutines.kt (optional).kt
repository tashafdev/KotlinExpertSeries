package s9_coroutines


import kotlinx.coroutines.*

/*
 * ----------------------------------------------------------------------
 * ✅ Lecture: Error Handling in Coroutines
 * ----------------------------------------------------------------------
 * 🔹 Use `try/catch` around suspending calls or inside coroutine blocks.
 * 🔹 `CoroutineExceptionHandler` catches uncaught exceptions in `launch`.
 * 🔹 Use `supervisorScope` or `SupervisorJob` to isolate failures.
 */

// Step 1️⃣: Basic try/catch inside launch
fun simpleTryCatch() = runBlocking {
    launch {
        try {
            delay(500)
            throw RuntimeException("🚨 Boom!")
        } catch (e: Exception) {
            println("🧯 Caught in launch: ${e.message}")
        }
    }
    delay(1000)
}

// Step 2️⃣: Global error handler with CoroutineExceptionHandler
fun withGlobalHandler() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("🛑 Caught globally: ${exception.message}")
    }

    val job = launch(handler) {
        delay(300)
        throw IllegalArgumentException("🔥 Invalid input")
    }

    job.join()
}

// Step 3️⃣: supervisorScope – failure doesn’t cancel siblings
fun usingSupervisorScope() = runBlocking {
    supervisorScope {
        val job1 = launch {
            delay(300)
            throw Exception("❌ Failure in job1")
        }

        val job2 = launch {
            delay(500)
            println("✅ job2 still runs!")
        }

        // Wait for both to complete
        joinAll(job1, job2)
    }
}

// Step 4️⃣: Run tests
fun main() {
    println("🔹 Try/catch demo:")
    simpleTryCatch()

    println("\n🔹 Global handler demo:")
    withGlobalHandler()

    println("\n🔹 supervisorScope demo:")
    usingSupervisorScope()
}
