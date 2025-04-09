package s6_classes_and_objects


/**
 * S6H_InterviewQuestionsAndAnswers.kt
 * Common Kotlin interview questions about classes and objects.
 */

fun main() {
    println("🧠 Kotlin Classes & Objects: Interview Q&A")
}

// 🔹 Q1: How do you define a class in Kotlin?
/*
Basic syntax:
class User(val name: String, var age: Int)
*/

// 🔹 Q2: What’s the difference between primary and secondary constructors?
/*
- Primary constructor is part of the class header.
- Secondary constructors are declared inside the class using `constructor(...)`.
*/

// 🔹 Q3: What is a data class?
/*
A class that automatically generates equals(), hashCode(), toString(), copy(), and componentN().
Must have at least one property in the primary constructor.
Example:
data class User(val name: String, val age: Int)
*/

// 🔹 Q4: Difference between object, companion object, and class?
/*
- `class`: You need to create instances.
- `object`: Singleton (only one instance).
- `companion object`: Acts like static; allows access to members via class name.
*/

// 🔹 Q5: When do you use sealed classes?
/*
To represent restricted class hierarchies — useful for handling different UI states or responses in a type-safe way.
All subclasses must be defined in the same file.
*/

// 🔹 Q6: What is the use of enum classes?
/*
Enum classes define a fixed set of constants. You can also associate properties and functions.
Example:
enum class Day { MON, TUE, WED }
*/

// 🔹 Q7: Difference between nested and inner class?
/*
- Nested class: No access to outer class members (like static).
- Inner class: Has access to outer class members using `inner` keyword.
*/

