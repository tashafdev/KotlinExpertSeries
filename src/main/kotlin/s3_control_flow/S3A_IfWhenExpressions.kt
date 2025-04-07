package s3_control_flow

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 3A: If & When Expressions
    📦 Package: kotlin.s3_control_flow
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - `if`, `else if`, `else` statements
    - `if` as an expression (not just a control structure)
    - `when` as a powerful replacement for switch
    - `when` with values, ranges, conditions, and types
    - Smart casts and return usage
    - Exhaustive `when`
    - Best practices

    ---------------------------------------------------------------------------
    🔁 `if`, `else if`, `else`
    ----------------------------------------------------------------------------
    - Used to branch code execution based on conditions.
    - Kotlin’s `if` is also an **expression** that returns a value.

    ✅ Example:
        val age = 20
        val status = if (age >= 18) "Adult" else "Minor"

    ✅ You can use full blocks:
        if (score >= 90) {
            println("Grade: A")
        } else if (score >= 75) {
            println("Grade: B")
        } else {
            println("Grade: C")
        }

    ---------------------------------------------------------------------------
    🧠 `if` as Expression
    ----------------------------------------------------------------------------
    - You can assign the result of an `if` directly to a variable.

    Example:
        val max = if (a > b) a else b

    ---------------------------------------------------------------------------
    🔁 `when` Expression
    ----------------------------------------------------------------------------
    - Replaces traditional `switch-case` with a cleaner syntax
    - Matches against values, ranges, types, and conditions

    ✅ Basic usage:
        when (day) {
            "Mon" -> println("Start of week")
            "Fri" -> println("Weekend vibes")
            else -> println("Midweek grind")
        }

    ✅ `when` as an expression:
        val message = when (score) {
            10 -> "Perfect"
            in 7..9 -> "Good"
            in 0..6 -> "Needs work"
            else -> "Invalid"
        }

    ✅ `when` without argument:
        when {
            temp > 30 -> println("Hot")
            temp in 20..30 -> println("Warm")
            else -> println("Cool")
        }

    ✅ Type checking with smart casts:
        fun printType(x: Any) = when (x) {
            is Int -> println("Integer: $x")
            is String -> println("String length: ${x.length}")
            else -> println("Unknown type")
        }

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use `if` for simple decisions, `when` for multiple conditions
    - Always handle `else` unless all cases are covered
    - Prefer `when` expression over deep nested `if-else`
    - Keep branches concise and readable
    ---------------------------------------------------------------------------
*/


fun main() {
    // ✅ if-else as statement
    val score = 82
    if (score >= 90) {
        println("Grade: A")
    } else if (score >= 75) {
        println("Grade: B")
    } else {
        println("Grade: C")
    }

    // ✅ if as expression
    val age = 20
    val status = if (age >= 18) "Adult" else "Minor"
    println("You are an $status")

    // ✅ when as statement
    val day = "Fri"
    when (day) {
        "Mon" -> println("Start of week")
        "Fri" -> println("Weekend vibes")
        else -> println("Midweek grind")
    }

    // ✅ when as expression
    val grade = when (score) {
        in 90..100 -> "A"
        in 75..89 -> "B"
        in 0..74 -> "C"
        else -> "Invalid"
    }
    println("Calculated Grade: $grade")

    // ✅ when without argument
    val temp = 26
    when {
        temp > 30 -> println("Hot")
        temp in 20..30 -> println("Warm")
        else -> println("Cool")
    }

    // ✅ when with smart cast
    fun describe(x: Any) = when (x) {
        is Int -> "It's an Int: $x"
        is Double -> "It's a Double: $x"
        is String -> "It's a String of length ${x.length}"
        else -> "Unknown type"
    }

    println(describe(42))
    println(describe("Kotlin"))
}
