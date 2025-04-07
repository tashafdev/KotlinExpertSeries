package s1_basics

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Basics – Lecture 9: Operators & Expressions
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What are operators?
    - What are expressions?
    - Arithmetic operators
    - Relational (comparison) operators
    - Logical operators
    - Assignment and compound assignment
    - Unary operators
    - Increment/Decrement (prefix/postfix)
    - Kotlin-specific behaviors (everything is an expression!)
    - Operator precedence
    - Best practices

    ---------------------------------------------------------------------------
    🔧 What are Operators?
    ----------------------------------------------------------------------------
    - Operators perform operations on values or variables.
    - Think of them as **symbols** that act on data.

    ---------------------------------------------------------------------------
    🔁 Arithmetic Operators
    ----------------------------------------------------------------------------
    ✅ `+`   Addition
    ✅ `-`   Subtraction
    ✅ `*`   Multiplication
    ✅ `/`   Division
    ✅ `%`   Modulo (Remainder)

    Example:
        val a = 10
        val b = 3
        println(a + b) // 13
        println(a % b) // 1

    ---------------------------------------------------------------------------
    📊 Relational (Comparison) Operators
    ----------------------------------------------------------------------------
    ✅ `==`  Equal to
    ✅ `!=`  Not equal to
    ✅ `>`   Greater than
    ✅ `<`   Less than
    ✅ `>=`  Greater than or equal to
    ✅ `<=`  Less than or equal to

    ---------------------------------------------------------------------------
    🔁 Assignment Operators
    ----------------------------------------------------------------------------
    ✅ `=`      Assignment
    ✅ `+=`     Addition assignment
    ✅ `-=`     Subtraction assignment
    ✅ `*=`     Multiplication assignment
    ✅ `/=`     Division assignment
    ✅ `%=`     Modulo assignment

    Example:
        var x = 5
        x += 3 // x = x + 3 → 8

    ---------------------------------------------------------------------------
    🔄 Unary Operators
    ----------------------------------------------------------------------------
    ✅ `+`  Unary plus (positive)
    ✅ `-`  Unary minus (negate)
    ✅ `++` Increment (prefix/postfix)
    ✅ `--` Decrement (prefix/postfix)

    Example:
        var a = 5
        println(++a) // 6 (prefix)
        println(a++) // 6 (postfix, becomes 7 after)

    ---------------------------------------------------------------------------
    🔁 Logical Operators
    ----------------------------------------------------------------------------
    ✅ `&&` Logical AND
    ✅ `||` Logical OR
    ✅ `!`  Logical NOT

    Example:
        val isAdult = true
        val hasID = false
        println(isAdult && hasID) // false

    ---------------------------------------------------------------------------
    🧠 Expressions in Kotlin
    ----------------------------------------------------------------------------
    - In Kotlin, **almost everything is an expression** (returns a value).
    - You can assign `if`, `when`, or even `try` blocks to a variable.

    Example:
        val max = if (a > b) a else b

    ---------------------------------------------------------------------------
    🔢 Operator Precedence (Order of Evaluation)
    ----------------------------------------------------------------------------
    ✅ Parentheses > Unary > Multiplication/Division > Addition/Subtraction > Relational > Logical

    Example:
        val result = 10 + 2 * 3      // 10 + 6 = 16
        val result2 = (10 + 2) * 3   // 12 * 3 = 36

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use parentheses for clarity, not just correctness
    - Prefer expressions over statements when possible
    - Avoid overusing compound assignments in complex expressions
    ---------------------------------------------------------------------------
*/


fun main() {
    // 🔢 Arithmetic
    val a = 15
    val b = 4
    println("Addition: ${a + b}")
    println("Subtraction: ${a - b}")
    println("Multiplication: ${a * b}")
    println("Division: ${a / b}")
    println("Modulo: ${a % b}")

    // 📊 Relational
    println("a == b: ${a == b}")
    println("a > b: ${a > b}")

    // 🔁 Assignment
    var x = 10
    x += 5
    println("x after += 5: $x")

    // 🔄 Unary
    var y = 3
    println("y (before): $y")
    println("++y (prefix): ${++y}")
    println("y++ (postfix): ${y++}")
    println("y (after): $y")

    // 🔁 Logical
    val isLoggedIn = true
    val isAdmin = false
    println("Logged in AND admin: ${isLoggedIn && isAdmin}")
    println("Logged in OR admin: ${isLoggedIn || isAdmin}")
    println("Not admin: ${!isAdmin}")

    // 🧠 Expressions
    val score = 80
    val grade = if (score >= 90) "A" else if (score >= 75) "B" else "C"
    println("Grade: $grade")

    // 🔢 Precedence
    val result1 = 10 + 2 * 3
    val result2 = (10 + 2) * 3
    println("10 + 2 * 3 = $result1")
    println("(10 + 2) * 3 = $result2")
}
