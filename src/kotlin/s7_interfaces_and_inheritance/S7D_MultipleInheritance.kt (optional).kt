package kotlin.s7_interfaces_and_inheritance


/*
 * ---------------------------------------------------------
 * ✅ Lecture: Multiple Inheritance in Kotlin (Interfaces Only)
 * ---------------------------------------------------------
 * Kotlin supports multiple inheritance **only through interfaces**.
 *
 * 🔹 A class can implement multiple interfaces.
 * 🔹 If two interfaces have the same method signature, the class must resolve the conflict.
 * 🔹 You can call the specific interface implementation using: `super<InterfaceName>.methodName()`
 */

// Step 1️⃣: Define two interfaces with same method name
interface Logger {
    fun log(message: String) = println("Log from Logger: $message")
}

interface CrashReporter {
    fun log(message: String) = println("Log from CrashReporter: $message")
}

// Step 2️⃣: Class that implements both interfaces
class LoggingCrashHandler : Logger, CrashReporter {
    override fun log(message: String) {
        println("Merged log output:")
        super<Logger>.log(message)
        super<CrashReporter>.log(message)
    }
}

// Step 3️⃣: Another example - Multiple behaviors
interface Swipeable {
    fun onGesture() = println("Swipe detected")
}

interface Touchable {
    fun onGesture() = println("Touch detected")
}

class GestureHandler : Swipeable, Touchable {
    override fun onGesture() {
        println("Handling gesture:")
        super<Swipeable>.onGesture()
        super<Touchable>.onGesture()
    }
}

// Step 4️⃣: Run test cases
fun main() {
    println("🧾 Logging Example:")
    val handler = LoggingCrashHandler()
    handler.log("File not found")

    println("\n👆 Gesture Example:")
    val gestureHandler = GestureHandler()
    gestureHandler.onGesture()
}
