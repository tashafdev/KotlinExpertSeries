package s19_clean_code_and_principles.s19b_dry_vs_wet


/**
 * S19Bd_DRYvsWET_InterviewQnA.kt
 * Kotlin Interview Questions and Answers about DRY and WET principles
 */

fun runS19Bd_DRYvsWET_InterviewQnA() {
    println("🧠 DRY vs WET: Kotlin Clean Code Interview Q&A")
}

// 🔹 Q1: What is the DRY principle?
/*
DRY = Don't Repeat Yourself.
Every piece of knowledge must have a single, unambiguous, authoritative representation in the system.
Avoid duplicate code, logic, and structure.
*/

// 🔹 Q2: What is the WET principle?
/*
WET = Write Everything Twice (or We Enjoy Typing).
It's the opposite of DRY — where duplication is not eliminated, leading to maintenance issues.
*/

// 🔹 Q3: Why is DRY important?
/*
- Makes code reusable
- Easier to maintain and debug
- Reduces chances of inconsistency and bugs
- Improves readability and team efficiency
*/

// 🔹 Q4: What are common signs of WET code?
/*
- Repeating the same logic across multiple places
- Hard-coded strings or values used everywhere
- Copy-pasting large chunks of code
- Similar-looking functions with minor changes
*/

// 🔹 Q5: How can you apply DRY in Kotlin?
/*
- Use functions for reusable logic
- Use constants/companion objects for shared values
- Apply extension functions and sealed classes
- Use abstraction for common logic and behavior
*/
