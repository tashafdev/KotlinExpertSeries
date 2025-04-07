package kotlin.s1_basics

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Basics – Lecture 2: Hello World
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - Brief recap: What is Kotlin?
    - Deeper dive into the `main()` function.
    - Understanding `println()` and `print()`.
    - Execution flow of a Kotlin program.
    - String interpolation and inline math.
    - Kotlin syntax tips (semicolon rule, top-level functions).

    ---------------------------------------------------------------------------
    🔄 RECAP: What is Kotlin?
    ----------------------------------------------------------------------------
    - Kotlin is a modern, statically typed programming language developed by JetBrains.
    - It's officially supported by Google for Android development.
    - Kotlin runs on the JVM and fully interoperates with Java.
    - Known for being concise, expressive, and null-safe.

    ---------------------------------------------------------------------------
    🔍 The `main()` Function – Your Program’s Starting Point
    ----------------------------------------------------------------------------
    - The `main()` function is where every Kotlin program starts execution.
    - The compiler **must** find `fun main()` to run your code.

    ✅ Common Forms:
    - `fun main()` → Basic form without parameters.
    - `fun main(args: Array<String>)` → With command-line arguments.

    ✅ Rules:
    - Only one `main()` is allowed per entry file.
    - It must be a top-level function (not inside a class unless using a companion object).
    - The code runs line-by-line from top to bottom.

    ---------------------------------------------------------------------------
    🖨️ print() vs println():
    ----------------------------------------------------------------------------
    - `print("text")` → Prints text **without a newline**.
    - `println("text")` → Prints text **with a newline** at the end.

    🔁 Example:
        print("Hello")
        print("World") → Output: HelloWorld

        println("Hello")
        println("World") → Output:
        Hello
        World

    ---------------------------------------------------------------------------
    💬 String Templates:
    ----------------------------------------------------------------------------
    - Kotlin allows string interpolation using `$variable` or `${expression}`.

    🔁 Example:
        val name = "Tashy"
        println("Hello, $name!") → Hello, Tashy!

        println("2 + 2 = ${2 + 2}") → 2 + 2 = 4

    ---------------------------------------------------------------------------
    📌 Kotlin Syntax Tips:
    ----------------------------------------------------------------------------
    - Semicolons (`;`) are optional. Kotlin uses newlines instead of semicolons.
    - Kotlin supports **top-level functions**, no need to wrap code inside classes.

    ---------------------------------------------------------------------------
*/

fun main() {
    // 🎯 Starting point of execution
    println("Hello, World!") // Output: Hello, World!

    // 🎉 Personalized greeting using string interpolation
    val name = "Tashy"
    println("Welcome, $name! Let's master Kotlin together.")

    // 🧪 Demonstrating difference between print() and println()
    print("This is ")
    print("on the same line. ")
    println("← this now goes to a new line")

    // 🧮 Inline expression inside a string
    println("2 + 2 = ${2 + 2}") // Output: 2 + 2 = 4

    // 🧠 Kotlin runs top-to-bottom, line-by-line
}
