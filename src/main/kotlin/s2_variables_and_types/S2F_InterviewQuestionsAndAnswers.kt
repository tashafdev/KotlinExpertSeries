package s2_variables_and_types


/**
 * S2F_InterviewQuestionsAndAnswers.kt
 * Common interview questions with answers related to Kotlin variables and types.
 */

fun main() {
    println("✅ Kotlin Interview Q&A — Variables & Types")
}

// 🔹 Q1: What's the difference between `val` and `var`?
/*
- `val` is read-only (immutable): value cannot be reassigned.
- `var` is mutable: value can be reassigned.
Example:
val name = "Tashy" // cannot change
var age = 25       // can change
*/

// 🔹 Q2: What is type inference in Kotlin?
/*
Kotlin can automatically detect variable type from the assigned value.
Example:
val city = "Dubai" // Inferred as String
val score = 90     // Inferred as Int
*/

// 🔹 Q3: Name Kotlin's numeric types.
/*
Byte, Short, Int, Long — whole numbers
Float, Double — decimal numbers
*/

// 🔹 Q4: How is string interpolation done in Kotlin?
/*
Use `$variableName` or `${expression}`
Example:
val name = "Kotlin"
println("Welcome to $name")
*/

// 🔹 Q5: What is null safety in Kotlin?
/*
Kotlin avoids null pointer exceptions by requiring nullable types explicitly.
Example:
val name: String? = null
val length = name?.length ?: 0 // safe call and Elvis operator
*/

// 🔹 Q6: What is a smart cast?
/*
Kotlin automatically casts a variable after a type check.
Example:
if (value is String) {
    println(value.length) // smart-cast to String
}
*/

// 🔹 Q7: Can we assign a nullable value to a non-null variable?
/*
No. It results in a compile-time error.
val name: String = null // ❌
Use nullable type: String?
*/

// 🔹 Q8: What happens if we use `!!` on a null variable?
/*
`!!` forces a non-null assertion. If the value is null, it throws a NullPointerException.
Use only when you're 100% sure the value isn't null.
*/

