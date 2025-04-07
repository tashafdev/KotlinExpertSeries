package s3_control_flow

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 3C: break, continue, and return
    📦 Package: kotlin.s3_control_flow
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - `break`: exits the nearest loop
    - `continue`: skips current iteration and goes to next
    - `return`: exits the whole function
    - Labeled `break@`, `continue@`, `return@` for nested control
    - When and why to use these flow controls
    - Best practices for readability

    ---------------------------------------------------------------------------
    🔚 break – Exit the Loop
    ----------------------------------------------------------------------------
    - Immediately exits the nearest enclosing loop.

    Example:
        for (i in 1..10) {
            if (i == 5) break
            println(i)
        }

    ---------------------------------------------------------------------------
    🔁 continue – Skip Current Iteration
    ----------------------------------------------------------------------------
    - Skips current loop iteration and jumps to the next.

    Example:
        for (i in 1..5) {
            if (i == 3) continue
            println(i)
        }

    ---------------------------------------------------------------------------
    🚪 return – Exit from a Function
    ----------------------------------------------------------------------------
    - Immediately returns from the enclosing function.

    Example:
        fun greet(name: String) {
            if (name.isBlank()) return
            println("Hello, $name!")
        }

    ---------------------------------------------------------------------------
    🔖 Labeled Control Flow
    ----------------------------------------------------------------------------
    ✅ Use labels to control nested loops:

    Example:
        outer@ for (i in 1..3) {
            for (j in 1..3) {
                if (j == 2) break@outer
                println("i=$i, j=$j")
            }
        }

    ✅ You can label loops and return to them using:
    - `break@label`
    - `continue@label`
    - `return@label` (for lambdas or inline blocks)

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Avoid excessive use of `break`/`continue` unless needed
    - Prefer labeled control only in nested loop edge cases
    - Use early `return` to simplify function logic
    ---------------------------------------------------------------------------
*/


fun main() {
    // 🔚 break demo
    println("→ break example:")
    for (i in 1..5) {
        if (i == 3) break
        println("i = $i")
    }

    // 🔁 continue demo
    println("→ continue example:")
    for (i in 1..5) {
        if (i == 3) continue
        println("i = $i")
    }

    // 🚪 return demo in function
    fun greet(name: String) {
        if (name.isBlank()) return
        println("Hello, $name!")
    }

    greet("Tashy")
    greet("")

    // 🔖 labeled break in nested loops
    println("→ labeled break example:")
    outer@ for (i in 1..3) {
        for (j in 1..3) {
            if (j == 2) break@outer
            println("i=$i, j=$j")
        }
    }

    // 🔖 labeled continue example
    println("→ labeled continue example:")
    outer@ for (x in 1..2) {
        for (y in 1..3) {
            if (y == 2) continue@outer
            println("x=$x, y=$y")
        }
    }
}
