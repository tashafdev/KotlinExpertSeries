package s2_variables_and_types

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 2B: Type Inference
    📦 Package: kotlin.s2_variables_and_types
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What is type inference?
    - How Kotlin determines variable types automatically
    - Explicit vs inferred type declaration
    - When to use which
    - Type inference in expressions and functions
    - Best practices and gotchas

    ---------------------------------------------------------------------------
    💡 What is Type Inference?
    ----------------------------------------------------------------------------
    - Kotlin is a **statically typed** language.
    - But thanks to type inference, the compiler can **guess the type** from the value.
    - This makes the code **cleaner** and **easier to write**.

    ✅ Example (inferred):
        val language = "Kotlin"   // Compiler infers this is a String

    ✅ Example (explicit):
        val year: Int = 2025      // You define the type yourself

    ---------------------------------------------------------------------------
    🤝 When to Use Explicit Types
    ----------------------------------------------------------------------------
    ✅ When you want to:
    - Improve **code clarity**
    - Document expected types for future readers
    - Avoid mistakes in complex expressions
    - Declare a variable without initializing immediately

    ---------------------------------------------------------------------------
    🧠 Inference in Expressions & Functions
    ----------------------------------------------------------------------------
    - Kotlin infers return types from expressions
    - If the function is simple, return type can be omitted

    Example:
        fun sum(a: Int, b: Int) = a + b  // Type inferred: Int

    - For complex or multi-line functions, it’s recommended to use explicit return types.

    ---------------------------------------------------------------------------
    🔄 Type Safety via Inference
    ----------------------------------------------------------------------------
    - Kotlin ensures type safety **even when inferring**.
    - You can’t accidentally assign incompatible types.

    Example:
        val x = 10          // Int
        x = "hello"         ❌ Compile error

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use inference when the value is obvious (`val score = 100`)
    - Use explicit types for:
        - public APIs
        - unclear assignments
        - uninitialized variables
    - Never sacrifice readability for fewer characters
    ---------------------------------------------------------------------------
*/


fun main() {
    // ✅ Inferred type
    val city = "Dubai" // Compiler knows it's a String
    val year = 2025    // Inferred as Int
    val pi = 3.14159   // Inferred as Double

    println("City: $city, Year: $year, Pi: $pi")

    // 🧠 Explicit type declaration
    val country: String = "UAE"
    val rating: Float = 4.5F
    val active: Boolean = true

    println("Country: $country, Rating: $rating, Active: $active")

    // ❌ Type mismatch example
    // val wrong: Int = "hello" // Uncommenting this will throw compile error

    // 🔁 Type inference in function
    fun multiply(a: Int, b: Int) = a * b  // return type inferred: Int

    println("Multiplication result: ${multiply(6, 9)}")
}
