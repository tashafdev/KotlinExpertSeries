package kotlin.s1_basics

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Basics – Lecture 4: Basic Syntax
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - Kotlin code structure
    - Statements vs Expressions
    - `val` vs `var` variables
    - Type inference vs explicit typing
    - Semicolon rule
    - Compile-time constants (`const val`)
    - Best practices for clean, readable syntax

    ---------------------------------------------------------------------------
    ✳️ Statements vs Expressions
    ----------------------------------------------------------------------------
    ✅ Statement:
       - A line of code that performs an action.
       - Example: `val age = 25`

    ✅ Expression:
       - Produces a value. Can be used in other statements.
       - Example: `val result = age + 5`

    ---------------------------------------------------------------------------
    📦 Variables: `val` vs `var`
    ----------------------------------------------------------------------------
    ✅ `val` (immutable): Can’t be changed after it's assigned.
        val name = "Tashy"

    ✅ `var` (mutable): Can be reassigned.
        var age = 25
        age = 26 // OK

    ---------------------------------------------------------------------------
    🔍 Type Inference vs Explicit Typing
    ----------------------------------------------------------------------------
    ✅ Inferred: The compiler automatically detects the type.
        val language = "Kotlin"  // String

    ✅ Explicit:
        val score: Int = 100     // Int

    ---------------------------------------------------------------------------
    🚫 Semicolon Rule
    ----------------------------------------------------------------------------
    - Semicolons `;` are optional.
    - Only used if multiple statements are on one line (not recommended).

    ---------------------------------------------------------------------------
    📢 Constants: `const val`
    ----------------------------------------------------------------------------
    ✅ `const val` defines a **compile-time constant**.
       - Must be a **top-level declaration** (outside functions) or inside an `object`.
       - Cannot be assigned a result from a function or runtime expression.
       - Must be of **primitive** or **String** type.

    ✅ Example:
        const val APP_NAME = "KotlinExpert"

    ❌ Invalid:
        const val dynamic = getCurrentDate() // Not allowed

    🧠 Use `const val` for:
    - Tags
    - URLs
    - Default config values
    - Constants used across multiple files

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use `val` by default
    - Reserve `var` only when mutation is needed
    - Use `const val` for shared compile-time values
    - Write clean, one-statement-per-line code
    ---------------------------------------------------------------------------
*/



// ✅ Compile-time constant (declared at the top level)
const val APP_VERSION = "1.0.0"

fun main() {
    // ✳️ Statements and Expressions
    val a = 10               // Statement
    val b = a + 5            // Expression

    println("Value of a: $a")
    println("Value of b (a + 5): $b")

    // 🧪 val vs var
    val name = "Tashy"
    var age = 25
    age = 26

    println("Hello, $name. You are $age years old.")

    // 🔍 Type examples
    val language = "Kotlin"
    val score: Int = 95

    println("Language: $language, Score: $score")

    // 📢 Using constant
    println("App Version: $APP_VERSION")

    // 🚫 Semicolons not required
    val x = 1
    val y = 2
    println("Sum: ${x + y}")
}
