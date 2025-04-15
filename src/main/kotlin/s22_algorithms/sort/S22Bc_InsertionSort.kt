package s22_algorithms.sort

/*
 * -----------------------------------------------------
 * 📚 Lecture: Insertion Sort (S22Bc_InsertionSort.kt)
 * -----------------------------------------------------
 * Insertion Sort:
 * - Builds the sorted portion of the array one element at a time.
 * - Stable: Yes (preserves relative order of equal elements)
 * - In‑place: Yes (uses constant extra space)
 * - Time Complexity:
 *     • Best: O(n) when the array is already sorted
 *     • Average/Worst: O(n²)
 * - Space Complexity: O(1)
 *
 * This lecture covers:
 * 1️⃣ How the algorithm works step‑by‑step
 * 2️⃣ Kotlin implementation on IntArray
 * 3️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Insertion Sort Implementation
/**
 * For each element from index 1 to end, insert it into the correct position
 * within the sorted subarray to its left.
 */
fun insertionSort(array: IntArray) {
    val n = array.size
    for (i in 1 until n) {
        val key = array[i]
        var j = i - 1
        // Shift elements of the sorted subarray [0..i-1] that are greater than key
        // one position to the right
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j]
            j--
        }
        // Place key in its correct position
        array[j + 1] = key
    }
}

// 2️⃣ Demo in main()
fun main() {
    println("\n✅ Insertion Sort Demo")
    val data = intArrayOf(12, 11, 13, 5, 6)
    println("Before: ${data.toList()}")  // [12, 11, 13, 5, 6]
    insertionSort(data)
    println("After:  ${data.toList()}")  // [5, 6, 11, 12, 13]
}

/*
 * 🔍 Android Use Cases:
 * - **Chat Message Insertion:** Insert a newly received message into a sorted list by timestamp.
 * - **Real‑time Leaderboards:** Update and maintain a small leaderboard as new scores arrive.
 * - **Incremental Data Loads:** Merge small batches of sorted data (e.g., paged API results) into an existing sorted list.
 * - **UI Element Ordering:** Insert views (e.g., tags, chips) in sorted order when user adds items dynamically.
 * - **Nearly‑Sorted Lists:** Efficient for lists that change only slightly between updates (e.g., daily step counts).
 *
 * 🔟 Summary:
 * ✅ Best for small or nearly sorted datasets due to O(n²) worst‑case.
 * ✅ Stable and in‑place—no extra memory overhead.
 * ✅ O(n) when the data is already sorted, making it efficient for incremental inserts.
 */
