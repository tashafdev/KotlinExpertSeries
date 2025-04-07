package kotlin.s9_coroutines

package kotlin.s9_coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

/*
 * ---------------------------------------------------------------------
 * ✅ Lecture: Channels and Flows in Kotlin Coroutines
 * ---------------------------------------------------------------------
 * 🔹 Channel: Hot stream of values (push-based, like a pipe)
 * 🔹 Flow: Cold stream of values (pull-based, like a sequence)
 *
 * Channels are useful for coroutine-to-coroutine communication.
 * Flows are ideal for reactive-style transformation pipelines.
 */

fun demoChannel() = runBlocking {
    println("📦 Channel Example")

    val channel = Channel<Int>()

    // Producer coroutine
    launch {
        for (i in 1..3) {
            delay(300)
            println("📤 Sending: $i")
            channel.send(i)
        }
        channel.close()
    }

    // Consumer coroutine
    launch {
        for (value in channel) {
            println("📥 Received: $value")
        }
    }
}

fun demoFlow(): Flow<Int> = flow {
    println("🌊 Flow started")
    for (i in 1..3) {
        delay(300)
        emit(i)
        println("🔁 Emitted: $i")
    }
}.flowOn(Dispatchers.Default)

fun collectFlow() = runBlocking {
    println("📡 Flow Collection")

    demoFlow().collect { value ->
        println("✅ Collected: $value")
    }
}

// Step 3️⃣: Run both demos
fun main() {
    demoChannel()

    println("\n----------------------------\n")

    collectFlow()
}
