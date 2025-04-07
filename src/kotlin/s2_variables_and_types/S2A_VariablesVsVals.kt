package kotlin.s2_variables_and_types

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 2A: Variables vs Vals
    📦 Package: kotlin.s2_variables_and_types
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - Declaring variables with `val` and `var`
    - The difference between mutability and immutability
    - When to use each
    - Reassignment rules
    - Shadowing and scope
    - Compile-time constants with `const val`
    - Best practices for clean, safe Kotlin code

    ---------------------------------------------------------------------------
    🔁 val vs var – The Core Difference
    ----------------------------------------------------------------------------
    ✅ `val`: Immutable (read-only reference)
        - Once assigned, cannot be reassigned.
        - Think of it like a final variable in Java.

    ✅ `var`: Mutable (read/write reference)
        - Can be reassigned to a different value.

    ---------------------------------------------------------------------------
    🔄 Reassignment Example:

        val name = "Tashy"
        name = "Dev"      ❌ Error → reassignment is not allowed

        var age = 25
        age = 26          ✅ Allowed

    ---------------------------------------------------------------------------
    🔐 const val – Compile-Time Constant
    ----------------------------------------------------------------------------
    ✅ Used for values known **at compile time**
    ✅ Must be declared at the **top-level** or inside an `object`
    ✅ Only works with primitives and `String`

    Example:
        const val APP_VERSION = "1.0.0"

    ❌ You cannot use `const val` inside functions or with runtime values.

    ---------------------------------------------------------------------------
    🧠 Shadowing and Scope
    ----------------------------------------------------------------------------
    - Kotlin allows variable shadowing (a new variable with the same name in a nested scope)
    - Useful, but should be used carefully

    Example:
        val x = 10
        if (true) {
            val x = 5 // shadows outer x
            println(x) // prints 5
        }
        println(x) // prints 10

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Prefer `val` over `var` by default → safer, reduces bugs
    - Use `var` only when mutation is intentional
    - Use `const val` for config, tags, shared constants
    - Avoid unnecessary shadowing for cleaner readability
    ---------------------------------------------------------------------------
*/


// ✅ Compile-time constant (must be top-level or inside an object)
const val APP_NAME = "KotlinExpertSeries"

fun main() {
    // 🔐 Immutable variable
    val username = "Tashy"
    println("Username: $username")
    // username = "DevTashy" // ❌ Not allowed (val is read-only)

    // 🔄 Mutable variable
    var level = 1
    println("Level: $level")
    level = 2
    println("Level after update: $level")

    // 📦 Using constant
    println("Welcome to $APP_NAME!")

    // 🧠 Shadowing
    val score = 90
    if (score > 80) {
        val score = 100
        println("Shadowed score inside if: $score")
    }
    println("Original score outside if: $score")
}
