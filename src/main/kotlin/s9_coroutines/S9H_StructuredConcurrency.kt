package s9_coroutines


import kotlinx.coroutines.*

/*
 * -------------------------------------------------------------------------
 * ✅ Lecture: Structured Concurrency in Kotlin
 * -------------------------------------------------------------------------
 * Structured concurrency ensures:
 * 🔹 Child coroutines are tied to their parent scope
 * 🔹 When parent is cancelled, all children are cancelled too
 * 🔹 No leaks, dangling jobs, or orphan background tasks
 *
 * Everything lives and dies together 👨‍👩‍👧
 */

// Step 1️⃣: Launching multiple children in a scope
fun structuredExample() = runBlocking {
    println("🌱 Parent scope starts on: ${Thread.currentThread().name}")

    launch {
        delay(500)
        println("🟢 Child 1 finished")
    }

    launch {
        delay(800)
        println("🟢 Child 2 finished")
    }

    println("⏳ Waiting for children...")
} // All children complete before exiting

// Step 2️⃣: Cancelling the parent cancels children
fun cancelHierarchy() = runBlocking {
    val parent = launch {
        launch {
            try {
                delay(1000)
                println("✅ Child 1 done")
            } catch (e: CancellationException) {
                println("❌ Child 1 cancelled")
            }
        }

        launch {
            try {
                delay(2000)
                println("✅ Child 2 done")
            } catch (e: CancellationException) {
                println("❌ Child 2 cancelled")
            }
        }
    }

    delay(800)
    println("🛑 Cancelling parent coroutine")
    parent.cancelAndJoin()
    println("🧹 Parent and children cleaned up")
}

// Step 3️⃣: Run both demos
fun main() {
    println("🔹 Structured Example:")
    structuredExample()

    println("\n🔹 Cancel Hierarchy:")
    cancelHierarchy()
}
