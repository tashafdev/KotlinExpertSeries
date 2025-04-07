package s3_control_flow

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 3B: Loops
    📦 Package: kotlin.s3_control_flow
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - `for`, `while`, and `do-while` loops
    - Ranges: `..`, `downTo`, `until`, `step`
    - Looping through arrays, lists, indices
    - Nested loops
    - Loop variable scopes
    - Best practices for readability and performance

    ---------------------------------------------------------------------------
    🔁 `for` Loop
    ----------------------------------------------------------------------------
    ✅ Basic loop:
        for (i in 1..5) {
            println(i)
        }

    ✅ With step:
        for (i in 1..10 step 2)

    ✅ Backward:
        for (i in 10 downTo 1)

    ✅ Until (exclusive):
        for (i in 1 until 5) // 1 to 4

    ✅ Looping through collections:
        val names = listOf("Tashy", "Dev")
        for (name in names) {
            println(name)
        }

    ✅ With index:
        for ((index, value) in names.withIndex()) {
            println("$index → $value")
        }

    ---------------------------------------------------------------------------
    🔄 `while` Loop
    ----------------------------------------------------------------------------
    - Runs as long as condition is true.
    - Condition is checked **before** each iteration.

    Example:
        var i = 1
        while (i <= 5) {
            println(i)
            i++
        }

    ---------------------------------------------------------------------------
    🔁 `do-while` Loop
    ----------------------------------------------------------------------------
    - Similar to `while`, but runs **at least once**.
    - Condition is checked **after** each iteration.

    Example:
        var j = 1
        do {
            println(j)
            j++
        } while (j <= 5)

    ---------------------------------------------------------------------------
    🧠 Best Practices:
    - Use `for` for known ranges or collections
    - Use `while`/`do-while` for unknown or input-driven conditions
    - Use `step` and `downTo` instead of manual increments/decrements
    - Avoid deeply nested loops when possible
    ---------------------------------------------------------------------------
*/


fun main() {
    // 🔁 Simple for loop
    println("→ For loop (1 to 5):")
    for (i in 1..5) {
        print("$i ")
    }
    println()

    // 🔁 Step & downTo
    println("→ For loop with step:")
    for (i in 1..10 step 2) {
        print("$i ")
    }
    println()

    println("→ For loop downTo:")
    for (i in 5 downTo 1) {
        print("$i ")
    }
    println()

    // 🔁 Until
    println("→ For loop with until:")
    for (i in 1 until 5) {
        print("$i ") // 1 to 4
    }
    println()

    // 🔁 List iteration
    val fruits = listOf("Apple", "Banana", "Cherry")
    println("→ Looping through fruits:")
    for (fruit in fruits) {
        println(fruit)
    }

    // 🔁 Index + value
    println("→ Loop with index:")
    for ((index, value) in fruits.withIndex()) {
        println("[$index] $value")
    }

    // 🔄 While loop
    var x = 3
    println("→ While loop:")
    while (x > 0) {
        println("x = $x")
        x--
    }

    // 🔁 Do-while loop
    var y = 0
    println("→ Do-while loop:")
    do {
        println("y = $y")
        y++
    } while (y < 3)
}
