package s1_basics

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Basics – Lecture 8: Variables & Immutability
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - Declaring variables with `val` and `var`
    - Understanding immutability
    - Constant values with `const val`
    - Late initialization with `lateinit` and `lazy`
    - Variable shadowing and scope
    - Reassigning and nulling variables
    - Best practices

    ---------------------------------------------------------------------------
    🔄 `val` vs `var`
    ----------------------------------------------------------------------------
    ✅ `val`: Immutable (read-only) → value can't be changed once assigned
        val name = "Tashy"
        name = "Dev" ❌ Error

    ✅ `var`: Mutable (read/write) → value can be reassigned
        var age = 25
        age = 26 ✅ OK

    🧠 Rule of Thumb:
    - Use `val` by default
    - Only use `var` when mutation is necessary

    ---------------------------------------------------------------------------
    📢 Constants with `const val`
    ----------------------------------------------------------------------------
    ✅ Compile-time constants:
        - Must be `val`, declared at top-level or inside `object`
        - Must be of primitive or String type
        - Can't be assigned with a function result

    Example:
        const val APP_NAME = "KotlinExpertSeries"

    ---------------------------------------------------------------------------
    ⏳ Late Initialization
    ----------------------------------------------------------------------------
    ✅ `lateinit var` → Used with non-null types when you promise to init later
    ✅ Only allowed with **var**, non-primitive, non-nullable types

    Example:
        lateinit var name: String

    ✅ `lazy` → Used with `val` for delayed, one-time initialization

    Example:
        val config by lazy {
            println("Loaded once")
            "AppConfig"
        }

    ---------------------------------------------------------------------------
    🧠 Shadowing & Scope
    ----------------------------------------------------------------------------
    - Inner variable with same name overrides outer one
    - Works in blocks like `if`, `for`, functions

    Example:
        val x = 10
        if (true) {
            val x = 5 // shadows outer x
            println(x) // 5
        }
        println(x) // 10

    ---------------------------------------------------------------------------
    🗑️ Variable Removal / Nulling
    ----------------------------------------------------------------------------
    - You can't "remove" a variable, but you can set it to `null` if it's nullable:
        var email: String? = "abc@example.com"
        email = null ✅

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use `val` for immutability and safer code
    - Use `var` only when variable **must** change
    - Use `const val` for shared, unchanging values
    - Avoid shadowing unless absolutely needed
    - Always initialize variables with meaningful values
    ---------------------------------------------------------------------------
*/


// 🔐 Top-level constant
const val APP_NAME = "KotlinExpertSeries"

fun main() {
    // ✅ Immutable
    val user = "Tashy"
    println("User: $user")

    // ✅ Mutable
    var age = 25
    age = 26
    println("Updated Age: $age")

    // 🧠 Late initialization (not possible here because we're in main)
    // lateinit would be used in class-level vars only

    // 💤 Lazy initialization
    val config by lazy {
        println("Loading config...")
        "Release"
    }

    println("App config: $config") // Triggers lazy init only once

    // 🧪 Shadowing
    val level = 1
    println("Outer level: $level")
    if (true) {
        val level = 2
        println("Inner level: $level") // Shadows outer
    }

    // ❓ Nulling a variable (must be nullable)
    var token: String? = "abc123"
    token = null
    println("Token after nulling: $token")

    // 📢 Constant usage
    println("App: $APP_NAME")
}
