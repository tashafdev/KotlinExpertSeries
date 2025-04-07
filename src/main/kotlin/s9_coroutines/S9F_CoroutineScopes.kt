package s9_coroutines


import kotlinx.coroutines.*

/*
 * ------------------------------------------------------------------
 * ✅ Lecture: Coroutine Scopes in Kotlin
 * ------------------------------------------------------------------
 * Scopes define the lifecycle of coroutines.
 *
 * 🔹 Common scopes:
 *    - GlobalScope → bad for most cases 😬
 *    - CoroutineScope → recommended for custom scopes
 *    - lifecycleScope → Android-only
 *    - viewModelScope → Jetpack ViewModel only
 */

// Step 1️⃣: GlobalScope — DO NOT use for app logic
fun usingGlobalScope() {
    println("🚨 GlobalScope (Not recommended)")
    GlobalScope.launch {
        delay(1000)
        println("⚠️ GlobalScope is risky — no proper lifecycle control")
    }
    Thread.sleep(1500) // Block main to let coroutine finish
}

// Step 2️⃣: Custom CoroutineScope with manual job control
fun usingCustomScope() {
    println("✅ CoroutineScope with structured lifecycle")

    val parentJob = Job()
    val scope = CoroutineScope(Dispatchers.Default + parentJob)

    scope.launch {
        delay(500)
        println("🔁 Coroutine in custom scope")
    }

    Thread.sleep(1000)
    parentJob.cancel() // Cancel the whole scope (cleanup)
}

// Step 3️⃣: Simulating lifecycleScope or viewModelScope (in apps)
fun usingFakeViewModelScope() {
    println("🎯 Simulating viewModelScope")

    class FakeViewModel {
        private val viewModelJob = SupervisorJob()
        private val scope = CoroutineScope(Dispatchers.IO + viewModelJob)

        fun loadData() {
            scope.launch {
                delay(400)
                println("📦 Data loaded in ViewModel scope")
            }
        }

        fun onCleared() {
            println("🧹 ViewModel cleared, canceling jobs")
            viewModelJob.cancel()
        }
    }

    val vm = FakeViewModel()
    vm.loadData()

    Thread.sleep(600)
    vm.onCleared()
}

// Step 4️⃣: Run all
fun main() {
    usingGlobalScope()
    usingCustomScope()
    usingFakeViewModelScope()
}

