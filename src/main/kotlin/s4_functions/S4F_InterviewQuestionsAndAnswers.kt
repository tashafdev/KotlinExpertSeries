package s4_functions


/**
 * S4F_InterviewQuestionsAndAnswers.kt
 * Kotlin interview questions and answers related to functions.
 */

fun main() {
    println("🧠 Kotlin Functions: Interview Q&A")
}

// 🔹 Q1: How do you define a function in Kotlin?
/*
Syntax:
fun greet(name: String): String {
    return "Hello, $name"
}
*/

// 🔹 Q2: What are named and default arguments in Kotlin?
/*
You can specify argument names and provide default values:
fun greet(name: String = "Guest") {
    println("Hello, $name")
}
greet()        // prints "Hello, Guest"
greet("Tashy") // prints "Hello, Tashy"
*/

// 🔹 Q3: What is an extension function?
/*
A function added to an existing class without modifying its source:
fun String.isLong(): Boolean = this.length > 10
"Hello Kotlin".isLong() // returns true
*/

// 🔹 Q4: What are inline functions?
/*
Functions marked with `inline` hint the compiler to insert their code at call sites.
Useful for performance with lambdas.
Example:
inline fun measure(block: () -> Unit) {
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    println("Time: ${end - start}")
}
*/

// 🔹 Q5: How is recursion used in Kotlin?
/*
A function calls itself for repetitive logic.
Example:
fun factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)
*/

// 🔹 Q6: Can functions be defined inside other functions in Kotlin?
/*
Yes. These are called **local functions**.
Useful for organizing logic within a specific scope.
*/

