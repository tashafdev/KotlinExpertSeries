package kotlin.s2_variables_and_types

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 2E: Nullability & Smart Casts
    📦 Package: kotlin.s2_variables_and_types
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - Kotlin’s null safety system
    - Nullable vs non-nullable types
    - Safe call operator `?.`
    - Elvis operator `?:`
    - Non-null assertion `!!`
    - Smart casts using `is`, `!is`, and `as?`
    - The `let` scope function with nullable types
    - Best practices to avoid NullPointerException (NPE)

    ---------------------------------------------------------------------------
    ⚠️ Why Null Safety?
    ----------------------------------------------------------------------------
    - In Java, null is the leading cause of crashes (NPEs).
    - Kotlin fixes this by distinguishing:
      - ✅ Non-nullable types → `val name: String`
      - ⚠️ Nullable types → `val name: String?`

    ---------------------------------------------------------------------------
    ✅ Safe Call Operator: `?.`
    ----------------------------------------------------------------------------
    - Safely access a member only if the variable is not null.
    - Returns `null` if the variable is null.

    Example:
        val name: String? = null
        println(name?.length) // No crash, just prints: null

    ---------------------------------------------------------------------------
    🔁 Elvis Operator: `?:`
    ----------------------------------------------------------------------------
    - Provide a default value if the left-hand side is null.

    Example:
        val username: String? = null
        val displayName = username ?: "Guest"

    ---------------------------------------------------------------------------
    ❗ Non-Null Assertion: `!!`
    ----------------------------------------------------------------------------
    - Asserts that a value is **not null**
    - Crashes with `KotlinNullPointerException` if it's actually null
    - ❌ Avoid unless you're absolutely sure

    Example:
        val length = name!!.length // Dangerous

    ---------------------------------------------------------------------------
    🧠 Smart Casts: `is`, `!is`, `as?`
    ----------------------------------------------------------------------------
    ✅ `is` → Check type and auto-cast within the block
    ✅ `!is` → Negation
    ✅ `as?` → Safe cast (returns null on failure)

    Example:
        fun describe(obj: Any) {
            if (obj is String) {
                println("String of length: ${obj.length}") // smart casted
            }
        }

    ---------------------------------------------------------------------------
    🔗 Safe Scope with `let`
    ----------------------------------------------------------------------------
    - `let` runs the block only if the variable is non-null
    - Good for inline null checks

    Example:
        val email: String? = "hi@tashy.dev"
        email?.let {
            println("Sending to $it")
        }

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Avoid `!!` except in very rare edge-cases
    - Use safe calls and Elvis often
    - Prefer smart casts for clean type checks
    - Make variables non-nullable whenever possible
    ---------------------------------------------------------------------------
*/


fun main() {
    // ✅ Nullable declaration
    val name: String? = null
    val city: String? = "Dubai"

    // 🔍 Safe call
    println("Name length: ${name?.length}")
    println("City length: ${city?.length}")

    // 🔁 Elvis operator
    val user: String? = null
    val displayName = user ?: "Guest"
    println("Display Name: $displayName")

    // ❗ Non-null assertion (use with caution!)
    // println(name!!.length) // Uncommenting this will crash

    // 🧠 Smart cast example
    fun describe(obj: Any) {
        if (obj is String) {
            println("Smart-casted string length: ${obj.length}")
        } else {
            println("Not a string.")
        }
    }

    describe("Kotlin")
    describe(42)

    // 🔗 let + safe call
    val email: String? = "tashy@dev.com"
    email?.let {
        println("Sending email to: $it")
    }

    // ❌ Safe cast failure returns null, not crash
    val unknown: Any = 123
    val safeString: String? = unknown as? String
    println("Safely casted: $safeString") // null
}
