package s5_collections

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 5A: Collections Intro
    📦 Package: kotlin.s5_collections
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What are collections in Kotlin?
    - Kotlin collection types: List, Set, Map
    - Mutable vs Immutable collections
    - Collection interfaces & hierarchy
    - Initialization, printing, basic iteration
    - Best practices

    ---------------------------------------------------------------------------
    📦 What are Collections?
    ----------------------------------------------------------------------------
    - Collections are **containers** for holding groups of data.
    - Kotlin has a rich collection API that includes **immutable** and **mutable** versions.

    ---------------------------------------------------------------------------
    📚 Types of Collections

    ✅ List:
        - Ordered collection, allows duplicates
        - Immutable: `listOf(...)`
        - Mutable: `mutableListOf(...)`

    ✅ Set:
        - Unordered, **unique** elements
        - Immutable: `setOf(...)`
        - Mutable: `mutableSetOf(...)`

    ✅ Map:
        - Key-value pairs
        - Immutable: `mapOf(...)`
        - Mutable: `mutableMapOf(...)`

    ---------------------------------------------------------------------------
    🧱 Collection Hierarchy

    Common interfaces:
    - `Collection<T>` → implemented by `List<T>` & `Set<T>`
    - `Map<K, V>` → independent hierarchy

    ┌────────────────────────────┐
    │      Iterable<T>           │
    └────────────────────────────┘
             ▲
      ┌──────┴──────┐
      │             │
List<T>         Set<T>         Map<K, V> (separate)

    ---------------------------------------------------------------------------
    ✨ Immutable vs Mutable

    - Immutable: Cannot add/remove elements after creation.
    - Mutable: Can change contents (add, remove, update)

    Examples:
        val fruits = listOf(\"Apple\", \"Banana\")
        val mutableFruits = mutableListOf(\"Apple\", \"Banana\")
        mutableFruits.add(\"Cherry\")

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Prefer immutable collections unless mutation is required
    - Use type inference when possible (`val names = listOf(\"Tashy\")`)
    - Iterate with `for`, `forEach`, or collection functions
    ---------------------------------------------------------------------------
*/


fun main() {
    // ✅ Immutable List
    val names = listOf("Tashy", "Dev", "Code")
    println("Names (List): $names")

    // ✅ Mutable List
    val mutableNames = mutableListOf("Tashy", "Dev")
    mutableNames.add("AI")
    println("Mutable List: $mutableNames")

    // ✅ Immutable Set
    val uniqueTags = setOf("Kotlin", "Android", "Kotlin")
    println("Unique Tags (Set): $uniqueTags") // no duplicates

    // ✅ Mutable Set
    val tags = mutableSetOf("Compose", "Jetpack")
    tags.add("AI")
    println("Mutable Set: $tags")

    // ✅ Immutable Map
    val countryCodes = mapOf("IN" to "India", "AE" to "UAE")
    println("Country Codes (Map): $countryCodes")

    // ✅ Mutable Map
    val scores = mutableMapOf("Tashy" to 95)
    scores["Dev"] = 88
    println("Mutable Map: $scores")

    // 🔁 Basic Iteration
    println("Loop through List:")
    for (name in names) {
        println("👉 $name")
    }

    println("Loop through Map:")
    for ((key, value) in countryCodes) {
        println("$key → $value")
    }
}
