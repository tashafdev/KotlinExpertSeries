package s22_algorithms.sort

/*
 * -----------------------------------------------------
 * 📚 Lecture: Counting Sort (S22Bg_CountingSort.kt)
 * -----------------------------------------------------
 * Counting Sort:
 * - Non‑comparison, integer sorting algorithm.
 * - Time Complexity: O(n + k), where n = number of elements, k = range of input values.
 * - Space Complexity: O(n + k) due to count and output arrays.
 * - Stable: Yes (preserves relative order of equal elements).
 *
 * This lecture covers:
 * 1️⃣ When to use Counting Sort
 * 2️⃣ Step‑by‑step algorithm explanation
 * 3️⃣ Kotlin implementation on IntArray
 * 4️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Counting Sort implementation for non‑negative integers
/**
 * Sorts the input array in place using Counting Sort.
 * Assumes all values are >= 0.
 */
fun countingSort(array: IntArray) {
    if (array.isEmpty()) return

    // Find maximum value to know range (0..maxVal)
    val maxVal = array.maxOrNull() ?: return

    // 2️⃣ Build count array of size maxVal+1
    val count = IntArray(maxVal + 1)
    for (v in array) {
        count[v]++
    }

    // 3️⃣ Transform count to prefix sums (cumulative counts)
    for (i in 1..maxVal) {
        count[i] += count[i - 1]
    }

    // 4️⃣ Build output array to maintain stability
    val output = IntArray(array.size)
    for (i in array.indices.reversed()) {
        val v = array[i]
        val pos = count[v] - 1
        output[pos] = v
        count[v]--
    }

    // 5️⃣ Copy back to original array
    for (i in array.indices) {
        array[i] = output[i]
    }
}

// 6️⃣ Demo in main()
fun main() {
    println("\n✅ Counting Sort Demo")
    val data = intArrayOf(4, 2, 2, 8, 3, 3, 1)
    println("Before: ${data.toList()}")   // [4, 2, 2, 8, 3, 3, 1]
    countingSort(data)
    println("After:  ${data.toList()}")   // [1, 2, 2, 3, 3, 4, 8]
}

/*
 * 🔍 Android Use Cases:
 * - **Grayscale Pixel Sorting:** Sort pixel intensity values (0–255) for histogram operations or filters.
 * - **Bucketed Counters:** Efficiently tally and sort event frequencies (e.g., taps per second).
 * - **Age/Level Bucketing:** Sort user ages or game levels when range is small and known.
 * - **Rating Histograms:** Build and sort star‑rating distributions for UI charts.
 * - **Fixed‑Range Data:** Sort small sensor readings (e.g., temperature 0–100) in IoT apps.
 *
 * 🔟 Summary:
 * ✅ Best when k (value range) is not much larger than n.
 * ✅ Stable and linear time for small k.
 * ✅ Uses extra memory proportional to k.
 * ✅ For large or unknown ranges, prefer comparison sorts (Quick, Merge).
 */
