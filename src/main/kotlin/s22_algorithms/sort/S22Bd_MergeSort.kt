package s22_algorithms.sort

/*
 * -----------------------------------------------------
 * 📚 Lecture: Merge Sort (S22Bd_MergeSort.kt)
 * -----------------------------------------------------
 * Merge Sort:
 * - A divide‑and‑conquer, comparison‑based sorting algorithm.
 * - Splits the array in half, recursively sorts each half, then merges them.
 * - Stable: Yes (preserves relative order of equal elements)
 * - Time Complexity: O(n log n) in all cases
 * - Space Complexity: O(n) due to auxiliary arrays
 *
 * This lecture covers:
 * 1️⃣ How Merge Sort works step‑by‑step
 * 2️⃣ Kotlin implementation returning a new sorted IntArray
 * 3️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Merge two sorted arrays into one sorted array
private fun merge(left: IntArray, right: IntArray): IntArray {
    val result = IntArray(left.size + right.size)
    var i = 0  // pointer for left
    var j = 0  // pointer for right
    var k = 0  // pointer for result

    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            result[k++] = left[i++]
        } else {
            result[k++] = right[j++]
        }
    }
    // Copy any remaining elements
    while (i < left.size)  result[k++] = left[i++]
    while (j < right.size) result[k++] = right[j++]

    return result
}

// 2️⃣ Recursive Merge Sort implementation
/**
 * Recursively splits the array into halves, sorts each half,
 * and merges them back together.
 */
fun mergeSort(array: IntArray): IntArray {
    if (array.size < 2) return array.copyOf() // base case

    val mid = array.size / 2
    val left  = array.sliceArray(0 until mid)
    val right = array.sliceArray(mid until array.size)

    val sortedLeft  = mergeSort(left)
    val sortedRight = mergeSort(right)

    return merge(sortedLeft, sortedRight)
}

// 3️⃣ Demo in main()
fun main() {
    println("\n✅ Merge Sort Demo")
    val data = intArrayOf(38, 27, 43, 3, 9, 82, 10)
    println("Before: ${data.toList()}")
    val sorted = mergeSort(data)
    println("After:  ${sorted.toList()}")
}

/*
 * 🔍 Android Use Cases:
 * - **Stable List Sorting:** Sort complex data models (e.g., messages by timestamp) while preserving insertion order for equal keys.
 * - **Large Data Handling:** Efficiently sort large datasets fetched from network or database before displaying (e.g., user feeds).
 * - **Merge Paged Results:** Combine and sort multiple pages of API results into a single sorted list.
 * - **Offline Data Sync:** Sort records from local cache and server merge operations during synchronization.
 * - **UI Diffing:** Prepare sorted lists for RecyclerView diff callbacks to animate only changed items.
 *
 * 🔟 Summary:
 * ✅ Merge Sort runs in O(n log n) consistently.
 * ✅ Uses extra memory for merging, but guarantees stability.
 * ✅ Ideal for large or nearly sorted datasets and when stability is required.
 */
