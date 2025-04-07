package s5_collections

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 5B: List & Set Operations
    📦 Package: kotlin.s5_collections
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - Common list operations: filter, map, sort, distinct, etc.
    - Set operations: union, intersect, subtract
    - Conversions between sets/lists
    - Searching, grouping, chunking
    - Best practices for functional collection handling

    ---------------------------------------------------------------------------
    📚 List Operations
    ----------------------------------------------------------------------------
    ✅ Transform:
        - `map { it.length }`, `mapIndexed { i, v -> ... }`

    ✅ Filter:
        - `filter { it.startsWith("T") }`, `filterNot { it.contains("x") }`

    ✅ Search:
        - `first`, `last`, `find`, `any`, `all`, `none`, `indexOf`

    ✅ Sort:
        - `sorted()`, `sortedBy`, `reversed()`, `shuffled()`

    ✅ Distinct & Duplicates:
        - `distinct()`, `toSet()`

    ✅ Grouping & chunking:
        - `groupBy { it.first() }`, `chunked(2)`

    ---------------------------------------------------------------------------
    🔁 Set Operations
    ----------------------------------------------------------------------------
    - Sets are unordered and don’t allow duplicates.

    ✅ Set math:
        - `union()`, `intersect()`, `subtract()`
        - Convert back using `.toList()` or `.toMutableSet()`

    ✅ Set + List Conversion:
        - `list.toSet()` → removes duplicates
        - `set.toList()` → converts to indexed list

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use `map` and `filter` instead of loops for transformation
    - Prefer `distinct()` or `toSet()` for unique collections
    - Combine operations with chaining: `.filter().map().sorted()`
    ---------------------------------------------------------------------------
*/


fun main() {
    val names = listOf("Tashy", "Dev", "Tashy", "AI", "Kotlin")

    // ✅ Filter names starting with 'T'
    val tNames = names.filter { it.startsWith("T") }
    println("Names starting with T: $tNames")

    // ✅ Map to name lengths
    val nameLengths = names.map { it.length }
    println("Lengths: $nameLengths")

    // ✅ Sort alphabetically & reverse
    val sortedNames = names.sorted()
    val reversedNames = names.reversed()
    println("Sorted: $sortedNames")
    println("Reversed: $reversedNames")

    // ✅ Distinct
    println("Unique names: ${names.distinct()}")

    // ✅ Group by first letter
    val grouped = names.groupBy { it.first() }
    println("Grouped: $grouped")

    // ✅ Chunked
    val chunked = names.chunked(2)
    println("Chunked: $chunked")

    // ✅ Searching
    println("First: ${names.first()}")
    println("Find 'AI': ${names.find { it == "AI" }}")
    println("Any starts with D? ${names.any { it.startsWith("D") }}")
    println("All longer than 2 chars? ${names.all { it.length > 2 }}")

    // 🟣 Set operations
    val devTags = setOf("Kotlin", "Jetpack", "Compose", "AI")
    val aiTags = setOf("AI", "ML", "Kotlin")

    println("Union: ${devTags union aiTags}")
    println("Intersect: ${devTags intersect aiTags}")
    println("Subtract: ${devTags subtract aiTags}")

    // ✅ Set ↔ List conversion
    val toSet = names.toSet()
    println("List to Set: $toSet")

    val backToList = toSet.toList()
    println("Set to List: $backToList")
}
