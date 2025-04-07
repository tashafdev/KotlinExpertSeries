package kotlin.s2_variables_and_types

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 2D: String & Char Types
    📦 Package: kotlin.s2_variables_and_types
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What are Strings and Chars in Kotlin
    - String templates and escape sequences
    - Multiline (raw) strings
    - String operations (length, compare, join, split, etc.)
    - Char basics and operations
    - Char to Int/Code and vice versa
    - Best practices

    ---------------------------------------------------------------------------
    🧵 What is a String?
    ----------------------------------------------------------------------------
    - A `String` is a sequence of characters enclosed in double quotes `"..."`.
    - Strings are **immutable** in Kotlin.
    - Kotlin supports **string templates**, **multiline strings**, and standard string functions.

    ✅ Basic:
        val name: String = "Tashy"

    ✅ With Template:
        val age = 25
        println("Age: $age") → Age: 25

    ✅ With Expressions:
        println("Next year: ${age + 1}")

    ---------------------------------------------------------------------------
    📚 String Operations
    ----------------------------------------------------------------------------
    - `length`, `uppercase()`, `lowercase()`, `substring()`, `replace()`, etc.
    - `equals()` and `==` both work for string equality (recommended: use `==` in Kotlin)
    - `split()`, `joinToString()`, `contains()`, `startsWith()`, `endsWith()`

    ---------------------------------------------------------------------------
    🔖 Escape Sequences
    ----------------------------------------------------------------------------
    ✅ `\n` – newline
    ✅ `\t` – tab
    ✅ `\"` – quote
    ✅ `\\` – backslash

    ---------------------------------------------------------------------------
    📜 Raw (Multiline) Strings
    ----------------------------------------------------------------------------
    - Triple-quoted strings (`""" ... """`)
    - Preserve line breaks and indentation
    - Use `.trimMargin()` to clean formatting

    Example:
        val bio = """
            |Name: Tashy
            |Role: Kotlin Dev
        """.trimMargin()

    ---------------------------------------------------------------------------
    🔤 Char Type
    ----------------------------------------------------------------------------
    - A `Char` holds a **single Unicode character**.
    - Declared using single quotes `'A'`
    - Not interchangeable with `String` (must convert explicitly)

    ✅ Char operations:
        val letter: Char = 'A'
        println(letter + 1) // Outputs: 'B' as Char + Int = Unicode shift
        println(letter.code) // Get ASCII/Unicode: 65
        println(66.toChar()) // Get Char from code: 'B'

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use `val` for strings as they’re immutable
    - Prefer string templates over concatenation
    - Use raw strings for JSON, HTML, SQL, etc.
    - Avoid unnecessary conversion between Char/String
    ---------------------------------------------------------------------------
*/


fun main() {
    // ✅ Basic string
    val name = "Tashy"
    val age = 25
    println("Hello, my name is $name and I’m $age years old.")

    // 🔁 String template with expression
    println("In 5 years, I’ll be ${age + 5}.")

    // 🔖 Escape characters
    println("Tabbed\tspace and new\nline.")

    // 📜 Raw string
    val json = """
        {
            "name": "Tashy",
            "role": "Dev"
        }
    """.trimIndent()
    println("Raw JSON:\n$json")

    // 📚 Common string operations
    val title = "KotlinDeveloper"
    println("Length: ${title.length}")
    println("Uppercase: ${title.uppercase()}")
    println("Does it start with Kotlin? ${title.startsWith("Kotlin")}")
    println("Split: ${title.split("D")}")

    // 🔤 Char basics
    val grade: Char = 'A'
    println("Grade: $grade")
    println("Grade as code: ${grade.code}")
    println("Char from code 66: ${66.toChar()}")
}
