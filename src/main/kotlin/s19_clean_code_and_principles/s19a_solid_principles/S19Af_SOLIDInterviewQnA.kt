package s19_clean_code_and_principles.s19a_solid_principles


/**
 * S19Af_SOLIDInterviewQnA.kt
 * Kotlin Interview Questions and Answers for the 5 SOLID Principles
 */

fun runS19Af_SOLIDInterviewQnA() {
    println("🎯 Kotlin SOLID Principles: Interview Q&A")
}

// 🔹 Q1: What is the S in SOLID — Single Responsibility Principle (SRP)?
/*
A class should have only one reason to change — i.e., one responsibility.
In Kotlin, this often means separating logic into services, repositories, and UI.
*/

// 🔹 Q2: What is the O — Open/Closed Principle?
/*
Classes should be open for extension but closed for modification.
Use interfaces or abstract classes to extend behaviors without changing existing code.
*/

// 🔹 Q3: What is the L — Liskov Substitution Principle?
/*
Subtypes must be substitutable for their base types.
If class B is a subtype of A, then objects of type A should be replaceable with objects of type B without breaking the application.
*/

// 🔹 Q4: What is the I — Interface Segregation Principle?
/*
Don’t force classes to implement interfaces they don't use.
Split large interfaces into smaller, more specific ones.
*/

// 🔹 Q5: What is the D — Dependency Inversion Principle?
/*
High-level modules should not depend on low-level modules. Both should depend on abstractions.
Use interfaces and inject them via constructor or function parameters.
*/
