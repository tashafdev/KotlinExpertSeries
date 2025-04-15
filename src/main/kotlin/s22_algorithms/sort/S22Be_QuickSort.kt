package s22_algorithms.sort

/*
 * -----------------------------------------------------
 * 📚 Lecture: Quick Sort (S22Be_QuickSort.kt)
 * -----------------------------------------------------
 * Quick Sort:
 * - A divide‑and‑conquer, comparison‑based sorting algorithm.
 * - Picks a pivot element, partitions the array around the pivot,
 *   then recursively sorts the subarrays.
 * - Average Time Complexity: O(n log n)
 * - Worst‑Case Time Complexity: O(n²) (when pivot selection is poor)
 * - Space Complexity: O(log n) due to recursion stack
 * - In‑place: Yes (uses only a small auxiliary stack)
 * - Unstable: Yes (equal elements may change relative order)
 *
 * This lecture covers:
 * 1️⃣ Pivot selection & partitioning (Lomuto scheme)
 * 2️⃣ Kotlin implementation on IntArray
 * 3️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Partition using Lomuto’s scheme
private fun partition(array: IntArray, low: Int, high: Int): Int {
    val pivot = array[high]            // Choose the last element as pivot
    var i = low                        // Place for swapping smaller elements
    for (j in low until high) {
        if (array[j] < pivot) {
            array.swap(i, j)          // Swap smaller element to front
            i++
        }
    }
    array.swap(i, high)                // Move pivot to its correct position
    return i                           // Return pivot index
}

// Helper: swap two elements in IntArray
private fun IntArray.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

// 2️⃣ Recursive Quick Sort implementation
/**
 * Sorts the subarray from index low to high (inclusive).
 */
fun quickSort(array: IntArray, low: Int = 0, high: Int = array.size - 1) {
    if (low < high) {
        val pi = partition(array, low, high)  // Partition index
        quickSort(array, low, pi - 1)         // Sort left subarray
        quickSort(array, pi + 1, high)        // Sort right subarray
    }
}

// 3️⃣ Demo in main()
fun main() {
    println("\n✅ Quick Sort Demo")
    val data = intArrayOf(10, 7, 8, 9, 1, 5)
    println("Before: ${data.toList()}")    // [10, 7, 8, 9, 1, 5]
    quickSort(data)
    println("After:  ${data.toList()}")    // [1, 5, 7, 8, 9, 10]
}

/*
 * 🔍 Android Use Cases:
 * - **Large List Sorting:** Quickly sort large datasets (e.g., contact lists, message feeds) before binding to RecyclerView.
 * - **In‑App Search Indexing:** Order indexed search results for fast binary search lookups.
 * - **Animation Keyframe Ordering:** Sort animation frames or UI transitions by timestamp for smooth playback.
 * - **Game Leaderboards:** Efficiently sort high‑score tables in real‑time multiplayer games.
 * - **Offline Data Processing:** Sort data pulled from local databases (Room/SQLite) before UI rendering.
 *
 * 🔟 Summary:
 * ✅ Quick Sort is one of the fastest in‑place sorts on average.
 * ✅ Choose good pivots (e.g., median‑of‑three) to avoid worst‑case behavior.
 * ✅ Recursion depth is O(log n) on average; tail‑recursion optimizations can help.
 * ✅ Use for large, unsorted datasets when memory overhead must stay low.
 */
