/**
 * -----------------------------------------------------
 * ✅ Lecture: Command Pattern (Behavioral)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * The Command Pattern encapsulates a request as an object,
 * allowing you to parameterize clients, queue requests, and support undo/redo.
 *
 * 📦 Use Case:
 * - Decoupling sender and receiver
 * - Undo/redo functionality
 * - Event queues or task scheduling
 *
 * 🧠 Why use it?
 * - Encourages loose coupling
 * - Adds flexibility in executing operations
 * - Supports logging and undo mechanisms
 *
 * -----------------------------------------------------
 * 🧪 Example: Remote Control Commands
 * -----------------------------------------------------
 */

interface Command {
    fun execute()
}

class Light {
    fun turnOn() = println("💡 Light turned ON")
    fun turnOff() = println("💡 Light turned OFF")
}

class LightOnCommand(private val light: Light) : Command {
    override fun execute() = light.turnOn()
}

class LightOffCommand(private val light: Light) : Command {
    override fun execute() = light.turnOff()
}

class RemoteControl {
    private val commandQueue = mutableListOf<Command>()

    fun setCommand(command: Command) {
        commandQueue.add(command)
    }

    fun run() {
        commandQueue.forEach { it.execute() }
        commandQueue.clear()
    }
}

fun main() {
    val light = Light()
    val remote = RemoteControl()

    remote.setCommand(LightOnCommand(light))
    remote.setCommand(LightOffCommand(light))

    remote.run()
}


/*
 * -----------------------------------------------------
 * 📱 Command Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ OnClickListeners:
 *    - `View.setOnClickListener { ... }` is a direct use of command pattern.
 *    - You're passing an action (command) to be executed on a specific event.

 * ✅ Undo/Redo in Text Editors, Drawing Apps:
 *    - Each action (e.g., drawing stroke, typing) is encapsulated as a command.
 *    - You can store them in a stack and support undo by reversing commands.

 * ✅ ViewAction (Espresso UI Tests):
 *    - UI test framework uses encapsulated commands to define actions like click, swipe, type.

 * ✅ Navigation Actions:
 *    - SafeArgs or NavController calls can be modeled as commands when stored and executed later (e.g., deep links).

 * ✅ WorkManager:
 *    - Each WorkRequest is like a queued command that runs asynchronously.

 * 🔹 Use this pattern when:
 *    - You want to encapsulate **actions as objects**.
 *    - You want to support **undo/redo**, task queues, or **delayed execution**.
 */

