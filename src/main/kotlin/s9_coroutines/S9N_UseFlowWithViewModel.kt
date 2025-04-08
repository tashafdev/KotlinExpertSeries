package s9_coroutines


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

/*
 * -----------------------------------------------------
 * ✅ Flow in MVVM: ViewModel + StateFlow + UI
 * -----------------------------------------------------
 * This is how you use Flow with ViewModel and UI layer:
 *
 * 🔸 `StateFlow` for screen state
 * 🔸 `SharedFlow` for one-time UI events
 * 🔸 Collect them inside `lifecycleScope.launchWhenStarted { ... }` in UI
 */

/*
 * 📌 Section 1 — Screen State Model
 */
sealed class ScreenState {
    object Loading : ScreenState()
    data class Success(val message: String) : ScreenState()
    data class Error(val error: String) : ScreenState()
}

/*
 * 📌 Section 2 — Fake ViewModel exposing StateFlow + SharedFlow
 */
class S9N_FakeViewModel {

    // 🔁 StateFlow for UI state
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Loading)
    val screenState: StateFlow<ScreenState> = _screenState.asStateFlow()

    // 🔁 SharedFlow for one-time UI events (e.g. Toast, Navigation)
    private val _eventFlow = MutableSharedFlow<String>()
    val eventFlow: SharedFlow<String> = _eventFlow.asSharedFlow()

    fun loadData() {
        CoroutineScope(Dispatchers.Default).launch {
            delay(1000)

            val success = Random.nextBoolean()
            if (success) {
                _screenState.value = ScreenState.Success("🎉 Data loaded!")
                _eventFlow.emit("✅ Show toast: Success")
            } else {
                _screenState.value = ScreenState.Error("❌ Something went wrong")
                _eventFlow.emit("⚠️ Show toast: Error")
            }
        }
    }
}

/*
 * 📌 Section 3 — Simulating a UI that observes the ViewModel
 */
fun s9n_simulateUiLayer() = runBlocking {
    val viewModel = S9N_FakeViewModel()

    // 🌊 State collector (would be lifecycleScope in real UI)
    val stateJob = launch {
        viewModel.screenState.collect { state ->
            when (state) {
                is ScreenState.Loading -> println("🔄 Loading...")
                is ScreenState.Success -> println("✅ Success: ${state.message}")
                is ScreenState.Error -> println("❌ Error: ${state.error}")
            }
        }
    }

    // 🌊 Event collector (one-time UI effects)
    val eventJob = launch {
        viewModel.eventFlow.collect {
            println("📢 Event: $it")
        }
    }

    viewModel.loadData()

    delay(2500)
    stateJob.cancel()
    eventJob.cancel()
}

/*
 * 🧠 What You Will Learn:
 * - Real MVVM pattern with Flow
 * - How to expose `StateFlow` and `SharedFlow` safely
 * - When to use `asStateFlow()` and `asSharedFlow()`
 */

/*
 * 🚀 Quick Summary:
 * ✅ ViewModel holds MutableStateFlow/SharedFlow privately
 * ✅ UI layer observes exposed `StateFlow`, `SharedFlow`
 * ✅ Use `lifecycleScope.launchWhenStarted` in Android UI to collect safely

 * 💡 Real-World Use Cases:
 * - UI loading state → StateFlow
 * - Form validation → StateFlow
 * - Toasts / Snackbars → SharedFlow
 * - Navigation triggers → SharedFlow

 * 🧼 Clean Code Insight:
 * Flow fits perfectly in MVVM —
 * Keep emission in ViewModel, observation in UI.
 * **State = Flow. Events = SharedFlow.**
 */
