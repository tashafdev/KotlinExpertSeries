package s21_data_structures


/*
 * -----------------------------------------------------
 * ✅ Lecture: Heap Structure (S21Bd_HeapStructure.kt)
 * -----------------------------------------------------
 * A Heap is a complete binary tree used to implement priority queues.
 * Two types:
 * - Min Heap → Parent <= Children (smallest at top)
 * - Max Heap → Parent >= Children (largest at top)
 * Heaps are great for scheduling, queues, and sorting (HeapSort).
 */

import java.util.PriorityQueue

fun main() {
    println("\n✅ Heap Structure Demo")

    // 1️⃣ Min Heap (default in Kotlin)
    println("\n1️⃣ Min Heap (Default PriorityQueue)")
    val minHeap = PriorityQueue<Int>()
    minHeap.addAll(listOf(40, 10, 30, 20))
    while (minHeap.isNotEmpty()) {
        print("${minHeap.remove()} → ") // Output: 10 → 20 → 30 → 40
    }

    // 2️⃣ Max Heap using Comparator
    println("\n\n2️⃣ Max Heap (Custom Comparator)")
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    maxHeap.addAll(listOf(40, 10, 30, 20))
    while (maxHeap.isNotEmpty()) {
        print("${maxHeap.remove()} → ") // Output: 40 → 30 → 20 → 10
    }

    // 3️⃣ Operations Supported
    println("\n\n3️⃣ Heap Operations")
    println("✔️ add(element) — Insert into heap")
    println("✔️ peek() — View top element without removing")
    println("✔️ remove() — Remove top priority element")

    // 4️⃣ Internal Structure
    println("\n4️⃣ Internal Heap Structure")
    println("✔️ Implemented as complete binary tree stored in array")
    println("✔️ Maintains heap property during insert/remove via sift up/down")

    // 🔟 Summary
    println("\n🔟 Summary")
    println("✅ Heap is a binary tree optimized for quick access to highest/lowest priority item")
    println("✅ Min Heap gives smallest value first. Max Heap gives largest.")
    println("✅ Built-in PriorityQueue class simplifies usage in Kotlin")
}

/*
 * 🔍 Real-World Use Cases:
 * - CPU & task scheduling
 * - Dijkstra’s shortest path
 * - Median maintenance
 * - Event-driven simulations
 */
