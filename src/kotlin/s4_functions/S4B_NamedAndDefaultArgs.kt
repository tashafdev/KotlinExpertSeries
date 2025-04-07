package kotlin.s4_functions

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 4C: Named and Default Arguments
    📦 Package: kotlin.s4_functions
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What are default arguments?
    - What are named arguments?
    - Combining both for flexible APIs
    - Order doesn't matter with named args
    - Real-world use-cases
    - Best practices and when to avoid overuse

    ---------------------------------------------------------------------------
    🔧 Default Arguments
    ----------------------------------------------------------------------------
    - Provide a **default value** for parameters so callers can skip them.

    Example:
        fun greet(name: String = \"Guest\") {
            println(\"Hello, $name!\")
        }

        greet()             // Hello, Guest
        greet(\"Tashy\")    // Hello, Tashy

    ---------------------------------------------------------------------------
    🏷️ Named Arguments
    ----------------------------------------------------------------------------
    - Call function parameters **by name**, not just order.
    - Useful when skipping parameters with defaults or improving readability.

    Example:
        fun createUser(name: String, role: String = \"User\", active: Boolean = true)

        createUser(name = \"Tashy\", active = false)

    ---------------------------------------------------------------------------
    🧠 Benefits:
    - Fewer overloads needed
    - Improved readability and clarity
    - Makes long parameter lists easier to manage

    ---------------------------------------------------------------------------
    ⚠️ Caveats & Best Practices:
    - Avoid overusing default args in public APIs if they affect binary compatibility
    - Prefer using default args over method overloading when possible
    - Use named args only when needed for clarity or skipping non-trailing params

    ---------------------------------------------------------------------------
*/


fun main() {
    // ✅ Default arguments
    greet1()
    greet1("Tashy")

    // ✅ Named arguments
    println("\n→ Named args in randomOrder:")
    sendMessage(message = "Hello Kotlin!", to = "DevTashy", isUrgent = true)

    println("\n→ Mixing defaults and named args:")
    sendMessage(
        "Hey!", isUrgent = false,
        message = TODO()
    )

    // ✅ Real-world use-case
    createUser("Tashy")
    createUser("Dev", active = false)
    createUser(role = "Admin", name = "AdminGuy", active = true)
}

// 🔧 Function with default arguments
fun greet1(name: String = "Guest") {
    println("Hello, $name!")
}

// 🏷️ Function with multiple default values
fun sendMessage(to: String = "Support", message: String, isUrgent: Boolean = false) {
    println("To: $to | Message: $message | Urgent: $isUrgent")
}

// 🧪 Real-world structure
fun createUser(name: String, role: String = "User", active: Boolean = true) {
    println("User: $name, Role: $role, Active: $active")
}
