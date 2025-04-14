/**
 * -----------------------------------------------------
 * ✅ Lecture: Facade Pattern (Structural)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * The Facade Pattern provides a unified, simplified interface
 * to a complex subsystem or set of APIs.
 *
 * 📦 Use Case:
 * - Hide complex logic or configurations behind a single entry point
 * - Provide an easy-to-use API for consumers
 *
 * 🧠 Why use it?
 * - Reduces system complexity for the client
 * - Improves readability and maintainability
 * - Decouples internal implementation from external access
 *
 * -----------------------------------------------------
 * 🧪 Example: Home Theater Facade
 * -----------------------------------------------------
 */

class DVDPlayer {
    fun turnOn() = println("💿 DVD Player ON")
    fun play(movie: String) = println("🎬 Playing '$movie'")
    fun turnOff() = println("💿 DVD Player OFF")
}

class Projector {
    fun turnOn() = println("📽️ Projector ON")
    fun turnOff() = println("📽️ Projector OFF")
}

class SoundSystem {
    fun turnOn() = println("🔊 Sound System ON")
    fun turnOff() = println("🔊 Sound System OFF")
}

class HomeTheaterFacade(
    private val dvd: DVDPlayer,
    private val projector: Projector,
    private val sound: SoundSystem
) {
    fun startMovie(movie: String) {
        println("🎥 Starting movie night...")
        dvd.turnOn()
        projector.turnOn()
        sound.turnOn()
        dvd.play(movie)
    }

    fun endMovie() {
        println("🛑 Ending movie...")
        dvd.turnOff()
        projector.turnOff()
        sound.turnOff()
    }
}

fun main() {
    val theater = HomeTheaterFacade(DVDPlayer(), Projector(), SoundSystem())
    theater.startMovie("Inception")
    theater.endMovie()
}

/*
 * -----------------------------------------------------
 * 📱 Facade Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ Room Database:
 *    - Provides a simple DAO interface.
 *    - Internally hides SQL, threading, and mapping complexity.

 * ✅ Firebase SDK:
 *    - Facade over multiple services (Auth, Firestore, Storage).
 *    - You only interact with high-level APIs like `FirebaseAuth.getInstance()`.

 * ✅ Jetpack Navigation Component:
 *    - `NavController` hides fragment transactions, back stack, deep links, etc.

 * ✅ WorkManager:
 *    - Simplifies complex background task chaining, retries, constraints.
 *    - Offers a clean API while managing execution logic internally.

 * ✅ Custom Helpers (Utils, Managers):
 *    - Common in large apps to wrap complex SDKs or APIs for feature modules.

 * 🔹 Use this pattern when:
 *    - You want to **simplify usage of a complex subsystem**.
 *    - You want to provide a **clean and unified interface** to the rest of the app.
 */
