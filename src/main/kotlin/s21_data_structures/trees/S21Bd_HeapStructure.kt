package s21_data_structures.trees


/*
 * -----------------------------------------------------
 * ✅ Lecture: Heap Structure (S21Bd_HeapStructure.kt)
 * -----------------------------------------------------
 *
 * 📌 A Heap is a special type of complete binary tree used primarily
 *     to implement **priority queues**. It satisfies the "heap property":
 *
 * 🔹 Min Heap → Each parent node is ≤ its children
 * 🔹 Max Heap → Each parent node is ≥ its children
 *
 * 🧠 Key Properties:
 * - Complete Binary Tree: All levels are fully filled except possibly the last.
 * - Always balanced → operations maintain logarithmic height.
 * - Typically implemented as an array for efficient indexing.
 *
 * ✅ Time Complexity:
 * - Insert → O(log n)
 * - Remove (min/max) → O(log n)
 * - Peek → O(1)
 *
 * 🧮 Use Cases:
 * - Priority-based task scheduling
 * - Real-time leaderboards
 * - Finding top K elements
 * - HeapSort algorithm
 * - Dijkstra’s shortest path (via Min Heap)
 *
 * ⚠️ Note:
 * - A Heap is **not a sorted structure**, only the root has guaranteed order.
 * - If full sorting is needed, use TreeMap/SortedSet or sort a list manually.
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

/*
 * -----------------------------------------------------
 * 📱 Heap in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ Priority Queues (Task Scheduling):
 *    - Heaps are used to implement PriorityQueue in Android.
 *    - Useful for deferring jobs (e.g., background tasks, sync queues, alarms).

 * ✅ WorkManager Internals:
 *    - Internally prioritizes work requests using priority-based queues.

 * ✅ Notification Ranking:
 *    - Systems like Android OS sort and manage notifications
 *      using importance or urgency levels (conceptually similar to a Max Heap).

 * ✅ Media or Download Queues:
 *    - Handling music playback or download queues by user-set or auto-priorities.

 * ✅ Dijkstra’s Algorithm in GPS/Maps:
 *    - Used for shortest path calculations — MinHeap stores closest nodes.

 * ✅ Real-Time Leaderboards:
 *    - Use MaxHeap to always show top N players, scores, or results.

 * ✅ Memory Management:
 *    - Garbage collection or memory priority decisions may rely on heap-like data structures.

 * 🔹 Use Heap when:
 *    - You need to **always access the highest/lowest priority item first**
 *    - You need fast insertions with automatic reordering
 */
