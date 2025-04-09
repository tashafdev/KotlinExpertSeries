package s5_collections


/**
 * S5F_InterviewQuestionsAndAnswers.kt
 * Kotlin interview questions and answers for Collections.
 */

fun main() {
    println("🧠 Kotlin Collections Q&A")
}

// 🔹 Q1: What types of collections does Kotlin offer?
/*
- List: ordered collection (may contain duplicates)
- Set: unordered collection with unique elements
- Map: key-value pairs
*/

// 🔹 Q2: What’s the difference between mutable and immutable collections?
/*
- Immutable: Cannot modify after creation (default types like listOf(), mapOf())
- Mutable: Can add, remove, or change elements (mutableListOf(), mutableMapOf())
*/

// 🔹 Q3: How are Kotlin collections different from Java collections?
/*
Kotlin collections are more concise, offer extension functions, null safety, and are split into mutable/immutable interfaces.
*/

// 🔹 Q4: What are some common operations on collections?
/*
- filter, map, reduce, fold, forEach
- contains(), indexOf(), distinct(), sortedBy(), etc.
*/

// 🔹 Q5: What is the difference between `map()` and `flatMap()`?
/*
- `map`: Transforms each element
- `flatMap`: Transforms and flattens nested collections
Example:
listOf("Hi", "Kotlin").flatMap { it.toList() } // [H, i, K, o, t, l, i, n]
*/

// 🔹 Q6: What are sequences in Kotlin?
/*
Sequences are lazily evaluated collections—useful for large chains of operations to avoid intermediate data creation.
Example:
listOf(1, 2, 3).asSequence().map { it * 2 }.toList()
*/
