package s19_clean_code_and_principles.s19d_code_smells



/**
 * S19Df_CodeSmells_InterviewQnA.kt
 * Kotlin Interview Questions and Answers on common code smells.
 */

fun runS19Df_CodeSmellsQnA() {
    println("🧠 Code Smells: Interview Q&A")
}

// 🔹 Q1: What is a code smell?
/*
A code smell is a surface indication that usually corresponds to a deeper problem in the system.
It doesn't always mean a bug, but suggests refactoring is needed.
*/

// 🔹 Q2: What are examples of common code smells?
/*
- Long Method
- Large Class
- Duplicated Code
- Too Many Dependencies
- Switch/If Chain (when misused)
*/

// 🔹 Q3: Why are long methods a problem?
/*
They are harder to understand, test, and maintain. Usually indicate multiple responsibilities (SRP violation).
*/

// 🔹 Q4: What’s wrong with large classes?
/*
They often do too many things and violate the SRP.
Refactor into smaller cohesive classes/modules.
*/

// 🔹 Q5: How do you eliminate duplicate code?
/*
Extract common logic into functions, extensions, or utilities. DRY principle!
*/

// 🔹 Q6: When is using `when` or `if-else` a code smell?
/*
When used as a substitute for polymorphism (like replacing behavior branching with type checking).
Can be refactored using sealed classes, strategy pattern, etc.
*/

// 🔹 Q7: Why are too many constructor dependencies bad?
/*
It makes classes harder to test and violates the Single Responsibility Principle.
Refactor using delegation or composition.
*/