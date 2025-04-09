package s1_basics


/**
 * S1K_InterviewQuestionsAndAnswers.kt
 * This file contains commonly asked Kotlin interview questions from the Basics section,
 * along with concise answers and examples where relevant.
 */

// 🔹 Q1: What are the key features of Kotlin?
/*
- Concise and expressive syntax
- Null safety built-in
- Interoperability with Java
- Functional and OOP support
- Coroutines for async programming
- Smart type inference
*/

// 🔹 Q2: How does a Kotlin program start execution?
/*
Execution starts from the `main()` function:
fun main() {
    println("Hello Kotlin!")
}
*/

// 🔹 Q3: What's the difference between `val` and `var`?
/*
- `val`: Immutable reference (like final in Java)
- `var`: Mutable reference
Example:
val name = "Tashy" // cannot reassign
var age = 30       // can reassign
*/

// 🔹 Q4: How is Kotlin’s null safety handled?
/*
Kotlin distinguishes nullable and non-nullable types.
Example:
val name: String = "John"       // Non-nullable
val nickname: String? = null    // Nullable
Use safe call: nickname?.length
*/

// 🔹 Q5: What is type inference in Kotlin?
/*
Kotlin can automatically detect the variable type based on the initializer:
val score = 95   // inferred as Int
val message = "Hi" // inferred as String
*/

// 🔹 Q6: How do you read input from the user in Kotlin?
/*
Use `readLine()` which returns a nullable String:
val input = readLine()
println("You typed: $input")
*/

// 🔹 Q7: How do you write a multiline comment in Kotlin?
/*
Use block comments:
/*
 This is
 a multiline comment
*/
*/

// 🔹 Q8: What's the result of the expression: `"5" + 2` in Kotlin?
/*
It results in "52" because `+` with a string does string concatenation.
*/

// 🔹 Q9: How are basic types represented in Kotlin?
/*
Kotlin has types like: Int, Double, Float, Boolean, Char, Byte, Short, Long
They are all classes under the hood.
*/

// 🔹 Q10: Can Kotlin code run without declaring a package?
/*
Yes. A file can omit a package declaration and still compile/run.
However, packages help in organizing code.
*/

// 🔹 Q11: What happens if you try to assign a null to a non-nullable variable?
/*
It causes a compilation error:
val name: String = null // ❌
Use nullable type: String?
*/

// 🔹 Q12: What is a smart cast in Kotlin?
/*
Kotlin automatically casts a variable to a target type after checking its type:
if (obj is String) {
    println(obj.length) // smart casted to String
}
*/

// 🔹 Q13: What is the purpose of `Unit` in Kotlin?
/*
`Unit` is similar to `void` in Java. It denotes that a function returns no meaningful value.
fun greet(): Unit {
    println("Hello!")
}
*/

// 🔹 Q14: How do you handle errors in Kotlin?
/*
Use try-catch blocks:
try {
    val num = "abc".toInt()
} catch (e: NumberFormatException) {
    println("Invalid number")
}
*/

// 🔹 Q15: What is the Kotlin file naming convention?
/*
Kotlin files can have any name and can contain multiple top-level functions or classes.
The file name does not need to match the class name.
*/

fun main() {
    println("✅ Interview Questions from S1 Basics section ready for review!")
}
