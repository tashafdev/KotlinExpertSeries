package s5_collections

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 5D: Sequence Operations (Optional)
    📦 Package: kotlin.s5_collections
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What is a Sequence in Kotlin?
    - How it's different from List
    - Benefits of lazy evaluation
    - Creating sequences
    - Common sequence operations
    - When to prefer Sequences over Lists
    - Best practices

    ---------------------------------------------------------------------------
    🌀 What is a Sequence?
    ----------------------------------------------------------------------------
    - A sequence is a **lazy collection pipeline**.
    - Operations like `map`, `filter` are executed **only when needed**.
    - Great for **large or infinite** data flows.

    ✅ List → Eager (all intermediate ops executed immediately)
    ✅ Sequence → Lazy (ops executed only on terminal op like `.toList()`)

    ---------------------------------------------------------------------------
    🔧 Creating a Sequence
    ----------------------------------------------------------------------------
    ✅ From a list:
        val seq = listOf(1, 2, 3).asSequence()

    ✅ From scratch:
        sequence {
            yield(1)
            yield(2)
            yieldAll(3..5)
        }

    ✅ Infinite sequence:
        generateSequence(1) { it + 1 }

    ---------------------------------------------------------------------------
    🔁 Common Operations (Same as collections)
    ----------------------------------------------------------------------------
    - `map`, `filter`, `take`, `drop`, `distinct`, `sorted`, `forEach`
    - Terminal: `toList()`, `toSet()`, `count()`, `sum()`, etc.

    ---------------------------------------------------------------------------
    🆚 Sequence vs List

    ✅ Use Sequence when:
    - You have a large dataset
    - You chain multiple transformations (e.g. map → filter → take)
    - You want to avoid creating intermediate lists

    ✅ Use List when:
    - Dataset is small
    - Performance difference is negligible
    - You need random access or indexing

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Always finish a sequence with a terminal op (`toList()`, `sum()`, etc.)
    - Don't use sequences for random access
    - Avoid unnecessary `.asSequence()` on short lists
    ---------------------------------------------------------------------------
*/


fun main() {
    // ✅ Basic sequence
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val lazyResult = numbers
        .asSequence()
        .map {
            println("Mapping $it")
            it * it
        }
        .filter {
            println("Filtering $it")
            it > 10
        }
        .toList() // Terminal operation

    println("Result: $lazyResult")

    // ✅ Infinite sequence with take
    val infinite = generateSequence(1) { it + 1 }
        .filter { it % 2 == 0 }
        .take(5)
        .toList()

    println("First 5 even numbers: $infinite")

    // ✅ Yield-based sequence
    val yieldSeq = sequence {
        yield(10)
        yieldAll(20..22)
    }

    println("Yielded sequence:")
    yieldSeq.forEach { println(it) }
}
