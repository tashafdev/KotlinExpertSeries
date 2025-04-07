package kotlin.s1_basics

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Basics – Lecture 6: Simple Input and Output
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - How to print output using `print()` and `println()`
    - How to read user input using `readLine()`
    - Converting string input to types like `Int`, `Double`, etc.
    - Safe input conversion with `?.toIntOrNull()`
    - Basic interaction pattern in CLI apps

    ---------------------------------------------------------------------------
    🖨️ Output in Kotlin
    ----------------------------------------------------------------------------
    ✅ print() → Prints text on the **same line**.
    ✅ println() → Prints text and moves to the **next line**.

    Example:
        print("Enter your name: ")
        println("Welcome!") → goes to new line

    ---------------------------------------------------------------------------
    📥 Input in Kotlin
    ----------------------------------------------------------------------------
    ✅ readLine() → Reads input from the user **as a nullable String**.
    - It returns `String?` because input might be null (e.g., EOF or no input).
    - You should handle null or blank values safely.

    Example:
        val name = readLine()
        println("Hello, $name!")

    ---------------------------------------------------------------------------
    🔁 Type Conversion
    ----------------------------------------------------------------------------
    ✅ To read numbers from input, you must convert from String.

    Example:
        val age = readLine()?.toInt()    // risky: throws if input isn’t a number
        val ageSafe = readLine()?.toIntOrNull() // safer: returns null if invalid

    ---------------------------------------------------------------------------
    ⚠️ readLine() is supported in Kotlin console apps,
    but not in Android (we use EditText there instead).
    ---------------------------------------------------------------------------

    ✅ Best Practices:
    - Always **prompt** before asking input
    - Use `toXOrNull()` for safe conversions
    - Print friendly feedback to guide users

    ---------------------------------------------------------------------------
*/


fun main() {
    // 🖨️ Output prompt
    print("Enter your name: ")

    // 📥 Reading user input (String?)
    val name = readLine()

    // 💬 Greeting with safe null handling
    println("Hello, ${name ?: "Guest"}!")

    // 🚀 Asking for age and converting to Int
    print("Enter your age: ")
    val ageInput = readLine()
    val age = ageInput?.toIntOrNull()

    // ✅ Conditional output
    if (age != null) {
        println("You are $age years old.")
        println("In 5 years, you’ll be ${age + 5}.")
    } else {
        println("That doesn’t look like a valid age.")
    }
}
