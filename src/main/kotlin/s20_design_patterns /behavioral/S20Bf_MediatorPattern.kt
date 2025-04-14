/**
 * -----------------------------------------------------
 * ✅ Lecture: Mediator Pattern (Behavioral)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * The Mediator Pattern defines an object that encapsulates how
 * a set of objects interact. It promotes loose coupling by preventing
 * objects from referring to each other directly.
 *
 * 📦 Use Case:
 * - Centralized control of component interaction
 * - Decoupling interdependent components (especially UIs)
 *
 * 🧠 Why use it?
 * - Reduces complexity and dependencies between components
 * - Centralizes communication in one place
 *
 * -----------------------------------------------------
 * 🧪 Example: Component Chat Mediator
 * -----------------------------------------------------
 */

interface ChatMediatorPattern {
    fun sendMessage(message: String, sender: ChatUser)
}

abstract class ChatUser(val name: String, private val mediator: ChatMediatorPattern) {
    fun send(message: String) {
        mediator.sendMessage(message, this)
    }

    abstract fun receive(message: String)
}

class ConcreteChatUser(name: String, mediator: ChatMediatorPattern) : ChatUser(name, mediator) {
    override fun receive(message: String) {
        println("📥 $name received: $message")
    }
}

class ChatRoomMediator : ChatMediatorPattern {
    private val participants = mutableListOf<ChatUser>()

    fun register(user: ChatUser) {
        participants.add(user)
    }

    override fun sendMessage(message: String, sender: ChatUser) {
        for (user in participants) {
            if (user != sender) {
                user.receive("${sender.name}: $message")
            }
        }
    }
}

fun main() {
    val mediator = ChatRoomMediator()

    val user1 = ConcreteChatUser("Alice", mediator)
    val user2 = ConcreteChatUser("Bob", mediator)

    mediator.register(user1)
    mediator.register(user2)

    user1.send("Hello, team!")
    user2.send("Hey Alice!")
}



/*
 * -----------------------------------------------------
 * 📱 Mediator Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ ViewModel in MVVM:
 *    - ViewModel mediates between UI and business logic.
 *    - Prevents Fragment/Activity from directly talking to repositories.

 * ✅ Shared ViewModel between Fragments:
 *    - Fragments don't communicate directly; they update shared state via ViewModel.
 *    - Clean fragment-to-fragment data flow.

 * ✅ CoordinatorLayout + Behavior:
 *    - View behaviors like `AppBarLayout` or `BottomNavigationView` coordinate actions through a mediator-like system.

 * ✅ Dialogs and BottomSheets:
 *    - Use callback interfaces or shared state (via ViewModel) instead of direct reference.

 * ✅ Modular Apps:
 *    - Feature modules interact through contracts/interfaces defined at the app level acting as a mediator.

 * 🔹 Use this pattern when:
 *    - Multiple components must communicate without tight coupling.
 *    - You want a **central coordinator** to manage shared behavior.
 */



