
/**
 * -----------------------------------------------------
 * ✅ Lecture: State Pattern (Behavioral)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * The State Pattern allows an object to change its behavior
 * when its internal state changes, appearing as if it changed its class.
 *
 * 📦 Use Case:
 * - Finite state machines
 * - UI state transitions
 * - Workflow or process control
 *
 * 🧠 Why use it?
 * - Removes complex `if-else` or `when` chains
 * - Makes state behavior isolated and easier to maintain
 * - Encourages encapsulation of state-specific logic
 *
 * -----------------------------------------------------
 * 🧪 Example: Media Player – Playing, Paused, Stopped
 * -----------------------------------------------------
 */

interface PlayerState {
    fun pressPlay(player: MediaPlayer)
}

class PlayingState : PlayerState {
    override fun pressPlay(player: MediaPlayer) {
        println("⏸️ Pausing media...")
        player.state = PausedState()
    }
}

class PausedState : PlayerState {
    override fun pressPlay(player: MediaPlayer) {
        println("▶️ Resuming media...")
        player.state = PlayingState()
    }
}

class StoppedState : PlayerState {
    override fun pressPlay(player: MediaPlayer) {
        println("▶️ Starting media from beginning...")
        player.state = PlayingState()
    }
}

class MediaPlayer {
    var state: PlayerState = StoppedState()

    fun pressPlay() {
        state.pressPlay(this)
    }
}

fun main() {
    val player = MediaPlayer()
    player.pressPlay() // ▶️ Starting media
    player.pressPlay() // ⏸️ Pausing media
    player.pressPlay() // ▶️ Resuming media
}


/*
 * -----------------------------------------------------
 * 📱 State Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ UI State Handling (Loading, Success, Error):
 *    - ViewModel holds UI state using sealed classes or enums.
 *    - UI reacts differently based on the current state.

 * ✅ ExoPlayer / MediaPlayer:
 *    - Internal state transitions: Idle, Buffering, Playing, Paused, Stopped.
 *    - Each state has different behavior for controls like Play/Pause.

 * ✅ Fragment/Activity Lifecycle:
 *    - Lifecycle states (CREATED, STARTED, RESUMED) influence logic and event handling.

 * ✅ Navigation Component:
 *    - State-driven navigation where screen flows depend on current authentication or onboarding state.

 * ✅ Custom View Components:
 *    - For example, a `Button` may behave differently in Enabled, Disabled, or Loading states.

 * 🔹 Use this pattern when:
 *    - You want to avoid massive `if/else` or `when` checks based on state.
 *    - You need clean transitions between well-defined behaviors.
 */
