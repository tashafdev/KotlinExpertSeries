package s7_interfaces_and_inheritance


/**
 * S7G_InheritanceInterviewQnA.kt
 * Common Kotlin interview questions and answers on interfaces and inheritance.
 */

fun runS7G_InterviewQnA() {
    println("🧠 Interfaces & Inheritance: Kotlin Interview Q&A")
}

// 🔹 Q1: What is inheritance in Kotlin?
/*
Inheritance allows a class to inherit properties and functions from another class using the `open` keyword.
Example:
open class Animal
class Dog : Animal()
*/

// 🔹 Q2: What are interfaces in Kotlin?
/*
Interfaces define contracts (methods/properties) that implementing classes must fulfill.
They can also contain default implementations.
*/

// 🔹 Q3: Difference between abstract class and interface?
/*
- Abstract class can hold state (fields), constructor logic.
- Interface cannot hold constructor state, but can have default implementations.
- Kotlin supports multiple interfaces, but only one superclass.
*/

// 🔹 Q4: What is polymorphism?
/*
Polymorphism allows objects to be treated as instances of their superclass or interface.
Example:
val animal: Animal = Dog()
animal.makeSound()
*/

// 🔹 Q5: How does Kotlin handle multiple inheritance?
/*
Kotlin allows multiple interfaces but only one base class.
If multiple interfaces have same method signature, class must override it and disambiguate.
*/

// 🔹 Q6: What visibility modifiers does Kotlin support?
/*
- `public` (default): visible everywhere
- `internal`: visible in the same module
- `protected`: visible in the class and subclasses
- `private`: visible in the class/file only
*/
