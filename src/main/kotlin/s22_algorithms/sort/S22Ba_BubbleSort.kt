package s22_algorithms.sort

/*
 * -----------------------------------------------------
 * 📚 Lecture: Bubble Sort (S22Ba_BubbleSort.kt)
 * -----------------------------------------------------
 * Bubble Sort:
 * - A simple comparison‑based sorting algorithm.
 * - Repeatedly steps through the list, compares adjacent items,
 *   and swaps them if they are in the wrong order.
 * - Continues passes until no swaps occur (the list is sorted).
 *
 * Characteristics:
 * - Time Complexity:
 *     • Best: O(n) (already sorted, with optimization)
 *     • Average/Worst: O(n²)
 * - Space Complexity: O(1) (in‑place)
 * - Stable: Yes (equal elements keep relative order)
 *
 * This lecture covers:
 * 1️⃣ Step‑by‑step explanation
 * 2️⃣ Optimized Kotlin implementation
 * 3️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Bubble Sort Implementation (optimized with early exit)
fun bubbleSort(array: IntArray) {
    val n = array.size
    for (i in 0 until n - 1) {
        var swapped = false
        // After i passes, the last i elements are in place
        for (j in 0 until n - i - 1) {
            if (array[j] > array[j + 1]) {
                // Swap adjacent elements
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
                swapped = true
            }
        }
        // If no swaps in this pass, array is sorted
        if (!swapped) break
    }
}

// 2️⃣ Demo in main()
fun main() {
    println("\n✅ Bubble Sort Demo")
    val data = intArrayOf(64, 34, 25, 12, 22, 11, 90)
    println("Before: ${data.toList()}")
    bubbleSort(data)
    println("After:  ${data.toList()}")
}

/*
 * 🔍 Android Use Cases:
 * - Sorting RecyclerView items by user rating or timestamp.
 * - Ordering contact list alphabetically when data set is small.
 * - Simple leaderboard or high‑score display in games.
 * - Sorting preferences or settings options in small lists.
 *
 * 🔟 Summary:
 * ✅ Bubble Sort is intuitive and easy to implement.
 * ✅ Best for tiny or nearly‑sorted lists due to O(n²) worst‑case.
 * ✅ Use optimized version (early exit) to detect sorted arrays.
 * ✅ For large datasets, prefer more efficient sorts (Merge, Quick).
 */
