package kotlin.s5_collections

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 5E: Collection Functions
    📦 Package: kotlin.s5_collections
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - Useful collection functions with real examples
    - Transformations: `map`, `flatMap`, `flatten`
    - Filtering: `filter`, `filterNot`, `takeWhile`
    - Aggregations: `sum`, `count`, `average`, `max`, `min`
    - Combining: `zip`, `union`, `plus`
    - Grouping and chunking: `groupBy`, `chunked`
    - Sorting: `sortedBy`, `reversed`, `shuffled`
    - Best practices

    ---------------------------------------------------------------------------
    🧠 Key Transformation Functions
    ----------------------------------------------------------------------------
    ✅ map { ... }           → transform each element
    ✅ flatMap { ... }       → map + flatten
    ✅ filter { ... }        → keep matching elements
    ✅ filterNot { ... }     → keep non-matching elements
    ✅ takeWhile { ... }     → take from start until false

    ---------------------------------------------------------------------------
    📊 Aggregation
    ----------------------------------------------------------------------------
    ✅ sum(), average(), count(), maxOrNull(), minOrNull()

    ---------------------------------------------------------------------------
    🔗 Combining & Relationships
    ----------------------------------------------------------------------------
    ✅ zip(list2) → pairwise merge
    ✅ union(otherList), plus(otherList)
    ✅ distinct(), intersect(), subtract()

    ---------------------------------------------------------------------------
    🔄 Utility Operations
    ----------------------------------------------------------------------------
    ✅ groupBy { ... }, chunked(n), windowed(n)
    ✅ sorted(), sortedBy(), reversed(), shuffled()
    ✅ any(), all(), none(), find(), first(), last()

    ---------------------------------------------------------------------------
*/


fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)

    // 🔁 map
    val squares = numbers.map { it * it }
    println("Squares: $squares")

    // 🔁 filter
    val even = numbers.filter { it % 2 == 0 }
    println("Even numbers: $even")

    // 🔁 flatMap
    val nested = listOf(listOf(1, 2), listOf(3, 4))
    val flat = nested.flatMap { it.map { n -> n * 10 } }
    println("Flattened & Mapped: $flat")

    // 🔁 filterNot
    println("Odd numbers: ${numbers.filterNot { it % 2 == 0 }}")

    // 🔁 takeWhile
    val until4 = numbers.takeWhile { it < 4 }
    println("Take while < 4: $until4")

    // 📊 Aggregation
    println("Sum: ${numbers.sum()}")
    println("Average: ${numbers.average()}")
    println("Count > 3: ${numbers.count { it > 3 }}")
    println("Max: ${numbers.maxOrNull()}, Min: ${numbers.minOrNull()}")

    // 🔗 zip
    val letters = listOf("A", "B", "C")
    val zipped = numbers.zip(letters)
    println("Zipped: $zipped")

    // ➕ union, plus
    val more = listOf(4, 5, 6, 7)
    println("Union: ${numbers.union(more)}")
    println("Plus: ${numbers + more}")

    // 🧩 groupBy
    val names = listOf("Ali", "Tom", "Tina", "Zee")
    val grouped = names.groupBy { it.first() }
    println("Grouped by first letter: $grouped")

    // 🔁 chunked
    val chunked = numbers.chunked(2)
    println("Chunked: $chunked")

    // 🎲 Randomized
    println("Shuffled: ${numbers.shuffled()}")
    println("Reversed: ${numbers.reversed()}")

    // ❓ Predicates
    println("Any > 5: ${numbers.any { it > 5 }}")
    println("All > 0: ${numbers.all { it > 0 }}")
    println("None negative: ${numbers.none { it < 0 }}")
}
