package s3_control_flow


/**
 * S3D_InterviewQuestionsAndAnswers.kt
 * Kotlin control flow questions with answers: if, when, loops, break/continue/return
 */

fun main() {
    println("🧠 Kotlin Control Flow Interview Q&A")
}

// 🔹 Q1: What's the difference between `if` as a statement and as an expression?
/*
Statement: Used to perform actions
Expression: Returns a value
Example:
val max = if (a > b) a else b
*/

// 🔹 Q2: How does `when` differ from `switch` in Java?
/*
- More flexible: can check ranges, values, expressions
- Can be used as an expression
- No need for `break`

Example:
when (score) {
    in 90..100 -> "A"
    80 -> "B"
    else -> "Fail"
}
*/

// 🔹 Q3: What are the types of loops in Kotlin?
/*
- for loop (with ranges or collections)
- while loop
- do-while loop
*/

// 🔹 Q4: When to use `break`, `continue`, and `return`?
/*
- `break`: exits current loop
- `continue`: skips current iteration
- `return`: exits the function (or lambda if used with label)
*/

// 🔹 Q5: Can `when` be used without an argument?
/*
Yes. It can act like an advanced `if-else if` chain:
when {
    x > 0 -> "Positive"
    x < 0 -> "Negative"
    else -> "Zero"
}
*/
