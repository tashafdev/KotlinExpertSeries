package kotlin.s1_basics

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Basics – Lecture 10: Basic Error Handling
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What are exceptions?
    - The `try-catch` block
    - Using `finally` to clean up
    - Throwing exceptions with `throw`
    - Checked vs Unchecked exceptions in Kotlin
    - Smart use of `try` as an expression
    - Best practices for error handling

    ---------------------------------------------------------------------------
    ❗ What is an Exception?
    ----------------------------------------------------------------------------
    - An exception is an **unexpected error** that disrupts program execution.
    - Kotlin uses **unchecked exceptions**, like Java.

    Examples:
    - Division by zero
    - Invalid number format
    - File not found

    ---------------------------------------------------------------------------
    🔒 try-catch Block
    ----------------------------------------------------------------------------
    Syntax:
    try {
        // Code that may throw an exception
    } catch (e: ExceptionType) {
        // Code to handle the error
    }

    ✅ You can have multiple catch blocks for different exception types.

    ---------------------------------------------------------------------------
    🔁 finally Block
    ----------------------------------------------------------------------------
    - `finally` is optional.
    - Executes **regardless of success or failure**.
    - Commonly used to clean up resources (like closing files or DB).

    ---------------------------------------------------------------------------
    🚨 throw Statement
    ----------------------------------------------------------------------------
    - Use `throw` to manually raise an exception.
    - Can throw built-in or custom exceptions.

    Example:
        throw IllegalArgumentException("Invalid input")

    ---------------------------------------------------------------------------
    🧠 Kotlin-Specific: try as Expression
    ----------------------------------------------------------------------------
    ✅ You can assign the result of a try-catch directly:

    Example:
        val num = try {
            readLine()?.toInt()
        } catch (e: NumberFormatException) {
            null
        }

    ---------------------------------------------------------------------------
    ❌ Checked vs Unchecked in Kotlin
    ----------------------------------------------------------------------------
    - Kotlin has **only unchecked exceptions**.
    - You are **not forced** to catch or declare exceptions like Java’s `throws`.

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Catch only specific exceptions (not generic `Exception`)
    - Log or handle the exception meaningfully
    - Avoid using exceptions for control flow
    - Use null-safety (`toIntOrNull()`) when possible to avoid exceptions
    ---------------------------------------------------------------------------
*/


fun main() {
    // ✅ Try-Catch Example
    print("Enter a number: ")
    val input = readLine()

    val number = try {
        input?.toInt()
    } catch (e: NumberFormatException) {
        println("⚠️ That’s not a valid number.")
        null
    }

    if (number != null) {
        println("You entered: $number")
    } else {
        println("No valid number entered.")
    }

    // ✅ Try-Catch-Finally
    try {
        val result = 10 / 0 // This will throw ArithmeticException
        println("Result: $result")
    } catch (e: ArithmeticException) {
        println("⚠️ Cannot divide by zero.")
    } finally {
        println("✅ Cleanup complete (finally block).")
    }

    // 🚨 Manual throw
    val username = ""
    if (username.isBlank()) {
        throw IllegalArgumentException("Username cannot be blank")
    }
}
