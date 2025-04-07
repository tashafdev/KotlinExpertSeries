package s6_classes_and_objects

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 6C: Data Classes
    📆 Package: kotlin.s6_classes_and_objects
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What is a data class?
    - Benefits and auto-generated functions
    - Equality and `toString()`
    - Copying and immutability
    - `componentN()` destructuring
    - Data class vs regular class
    - Best practices

    ---------------------------------------------------------------------------
    🔢 What is a Data Class?
    ----------------------------------------------------------------------------
    - A class primarily used to **hold data**
    - Auto-generates:
        - `toString()`
        - `equals()` / `hashCode()`
        - `copy()`
        - `componentN()` functions

    ✅ Syntax:
        data class ProfileData(val name: String, val age: Int)

    ---------------------------------------------------------------------------
    🤝 Comparison with Regular Class
    ----------------------------------------------------------------------------
    - Regular class requires manual override of equals, hashCode, etc.
    - Data class handles that automatically

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use for immutable models / DTOs / UI states
    - Keep properties in primary constructor
    - Avoid inheritance (data classes can't be open or abstract)
    ---------------------------------------------------------------------------
*/


fun main() {
    val user1 = ProfileData("Tashy", 28)
    val user2 = ProfileData("Tashy", 28)
    val user3 = user2.copy(age = 30)

    println(user1)                      // toString()
    println("Equals: ${user1 == user2}") // equals()
    println("Hash: ${user1.hashCode()}")

    // Destructuring
    val (n, a) = user3
    println("Name: $n | Age: $a")
}

data class ProfileData(val name: String, val age: Int)
