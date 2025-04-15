package s22_algorithms.sort

/*
 * -----------------------------------------------------
 * 📚 Lecture: Heap Sort (S22Bf_HeapSort.kt)
 * -----------------------------------------------------
 * Heap Sort:
 * - A comparison‑based, in‑place sorting algorithm.
 * - Builds a max‑heap (complete binary tree) then repeatedly extracts
 *   the maximum element to sort the array.
 *
 * Characteristics:
 * - Time Complexity: O(n log n) in all cases
 * - Space Complexity: O(1) (in‑place, aside from recursion/stack)
 * - Stable: No (equal elements may change order)
 *
 * This lecture covers:
 * 1️⃣ What is a Heap & array representation
 * 2️⃣ Building the max‑heap (heapify)
 * 3️⃣ Heap Sort algorithm steps
 * 4️⃣ Kotlin implementation on IntArray
 * 5️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Swap helper
private fun IntArray.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

// 2️⃣ Heapify subtree rooted at index i, for heap size n
private fun heapify(array: IntArray, n: Int, i: Int) {
    var largest = i             // Initialize largest as root
    val left  = 2 * i + 1       // left child index
    val right = 2 * i + 2       // right child index

    // If left child exists and is greater than root
    if (left < n && array[left] > array[largest]) {
        largest = left
    }
    // If right child exists and is greater than current largest
    if (right < n && array[right] > array[largest]) {
        largest = right
    }
    // If largest is not root, swap and continue heapifying
    if (largest != i) {
        array.swap(i, largest)
        heapify(array, n, largest)
    }
}

// 3️⃣ Heap Sort implementation
/**
 * 1. Build max‑heap: for i from n/2−1 down to 0, call heapify.
 * 2. Extract elements one by one: swap root with last element,
 *    reduce heap size by 1, then heapify root.
 */
fun heapSort(array: IntArray) {
    val n = array.size

    // Build max‑heap
    for (i in n / 2 - 1 downTo 0) {
        heapify(array, n, i)
    }

    // One by one extract elements
    for (i in n - 1 downTo 1) {
        // Move current root (max) to end
        array.swap(0, i)
        // Heapify reduced heap
        heapify(array, i, 0)
    }
}

// 4️⃣ Demo in main()
fun main() {
    println("\n✅ Heap Sort Demo")
    val data = intArrayOf(12, 11, 13, 5, 6, 7)
    println("Before: ${data.toList()}")   // [12, 11, 13, 5, 6, 7]
    heapSort(data)
    println("After:  ${data.toList()}")   // [5, 6, 7, 11, 12, 13]
}

/*
 * 🔍 Android Use Cases:
 * - **Priority Queues:** Implement custom priority‑based task scheduling (e.g., urgent jobs first).
 * - **Media Buffer Management:** Sort buffer segments by timestamp for playback ordering.
 * - **Resource Loading:** Prioritize asset loading (images, fonts) based on importance.
 * - **Game AI:** Order game entities by threat level or distance for processing.
 * - **Analytics Bucketing:** Sort event counts or metrics for reporting dashboards.
 *
 * 🔟 Summary:
 * ✅ Heap Sort runs in O(n log n) consistently.
 * ✅ In‑place but not stable.
 * ✅ Good when you need guaranteed O(n log n) and minimal extra memory.
 * ✅ Leverages binary‑heap properties for efficient selection of max elements.
 */
