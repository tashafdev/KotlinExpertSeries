package kotlin.s6_classes_and_objects

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 6G: Sealed Classes
    📆 Package: kotlin.s6_classes_and_objects
    🎓 Lecture: Sealed Classes – Restricted Class Hierarchies for State Models
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What is a sealed class?
    - Benefits over enums and abstract classes
    - Use cases for modeling app states / results
    - Exhaustive `when` usage
    - Sealed interface (Kotlin 1.5+)
    - Best practices

    ---------------------------------------------------------------------------
    🛠 What is a Sealed Class?
    ----------------------------------------------------------------------------
    - A **restricted class hierarchy** that allows a fixed set of subclasses
    - All subclasses must be defined in the **same file**
    - Enables **exhaustive `when` expressions**

    ✅ Syntax:
        sealed class ApiResult

        class Success(val data: String): ApiResult()
        class Error(val message: String): ApiResult()

    ---------------------------------------------------------------------------
    🏛 Real Use Case: State Handling
    ----------------------------------------------------------------------------
        sealed class UiState

        object Loading: UiState()
        data class Success(val data: String): UiState()
        data class Error(val error: String): UiState()

        fun render(state: UiState) {
            when(state) {
                is Loading -> println("Loading...")
                is Success -> println("Data: ${state.data}")
                is Error -> println("Oops: ${state.error}")
            }
        }

    ---------------------------------------------------------------------------
    🤝 Sealed vs Enum vs Abstract
    ----------------------------------------------------------------------------
    - Sealed = smart choice when subclass **has data**
    - Enum = good for simple constants
    - Abstract = open for extension, less restrictive

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use sealed class when modeling states, actions, and events
    - Use `object` when no data is carried
    - Prefer `data class` for meaningful subclass data
    - Combine with `when` for safe and clear branching
    ---------------------------------------------------------------------------
*/


fun main() {
    val states = listOf(
        UiState.Loading,
        UiState.Success("Profile Loaded"),
        UiState.Error("No internet")
    )

    for (state in states) {
        render(state)
    }
}

// ✅ Sealed class with subclasses
sealed class UiState {
    object Loading : UiState()
    data class Success(val data: String) : UiState()
    data class Error(val error: String) : UiState()
}

// 🔢 Exhaustive when expression
fun render(state: UiState) {
    when (state) {
        is UiState.Loading -> println("⏳ Loading...")
        is UiState.Success -> println("🌟 Data: ${state.data}")
        is UiState.Error -> println("❌ Error: ${state.error}")
    }
}
