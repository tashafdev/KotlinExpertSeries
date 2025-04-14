/**
 * -----------------------------------------------------
 * ✅ Lecture: Bridge Pattern (Structural)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * The Bridge Pattern decouples an abstraction from its implementation
 * so that the two can vary independently.
 *
 * 📦 Use Case:
 * - Combine abstractions with multiple implementations
 * - Avoid tight coupling between layers
 *
 * 🧠 Why use it?
 * - Avoids class explosion with multiple combinations
 * - Separates abstraction from implementation
 *
 * -----------------------------------------------------
 * 🧪 Example: S20Sd Notification Bridge
 * -----------------------------------------------------
 */

interface S20Sd_MessageSender {
    fun send(message: String)
}

class S20Sd_EmailSender : S20Sd_MessageSender {
    override fun send(message: String) {
        println("📧 Sending Email: $message")
    }
}

class S20Sd_SMSSender : S20Sd_MessageSender {
    override fun send(message: String) {
        println("📱 Sending SMS: $message")
    }
}

abstract class S20Sd_Notification(protected val sender: S20Sd_MessageSender) {
    abstract fun notify(message: String)
}

class S20Sd_UrgentNotification(sender: S20Sd_MessageSender) : S20Sd_Notification(sender) {
    override fun notify(message: String) {
        println("🚨 URGENT")
        sender.send(message)
    }
}

class S20Sd_CasualNotification(sender: S20Sd_MessageSender) : S20Sd_Notification(sender) {
    override fun notify(message: String) {
        sender.send("FYI: $message")
    }
}

fun main() {
    val urgent = S20Sd_UrgentNotification(S20Sd_SMSSender())
    urgent.notify("Server down!")

    val casual = S20Sd_CasualNotification(S20Sd_EmailSender())
    casual.notify("Lunch at 1 PM")
}


/*
 * -----------------------------------------------------
 * 📱 Bridge Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ MediaPlayer ↔ Output Devices:
 *    - Abstraction: MediaPlayer
 *    - Implementation: Plays audio via Bluetooth, Speaker, or Headphones.

 * ✅ Jetpack Compose ViewModel (State) ↔ Composables (UI):
 *    - Abstraction: UI logic in Composable
 *    - Implementation: Provided via injected or shared ViewModel

 * ✅ Themes / Styling Systems:
 *    - Abstraction: UI element (Button, Text)
 *    - Implementation: Light/Dark/Custom Theme values injected at runtime.

 * ✅ Repository ↔ Data Sources:
 *    - Abstraction: Repository
 *    - Implementation: Network API, Local DB, or Cache — swappable without changing repository interface.

 * ✅ Clean Architecture:
 *    - Use cases (domain) are abstracted from data layer implementations.

 * 🔹 Use this pattern when:
 *    - You want to **separate abstraction from implementation**, especially when each can evolve separately.
 *    - You have **multiple combinations** of logic and implementation (e.g., data sources + response types).
 */



