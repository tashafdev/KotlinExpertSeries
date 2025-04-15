package s22_algorithms.sort

/*
 * -----------------------------------------------------
 * 📚 Lecture: Selection Sort (S22Bb_SelectionSort.kt)
 * -----------------------------------------------------
 * Selection Sort:
 * - A comparison‑based sorting algorithm.
 * - Repeatedly selects the minimum element from the unsorted portion
 *   and swaps it with the first unsorted element.
 *
 * Characteristics:
 * - Time Complexity:
 *     • Best/Average/Worst: O(n²)
 * - Space Complexity: O(1) (in‑place)
 * - Stable: No (but can be made stable with slight modifications)
 *
 * This lecture covers:
 * 1️⃣ Algorithm breakdown
 * 2️⃣ Kotlin implementation on IntArray
 * 3️⃣ Demo in main()
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Selection Sort Implementation
fun selectionSort(array: IntArray) {
    val n = array.size
    for (i in 0 until n - 1) {
        // Assume the first unsorted element is the minimum
        var minIndex = i
        // Find the true minimum in the rest of the array
        for (j in i + 1 until n) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }
        // Swap the found minimum with the first unsorted element
        if (minIndex != i) {
            val temp = array[i]
            array[i] = array[minIndex]
            array[minIndex] = temp
        }
    }
}

fun main() {
    println("\n✅ Selection Sort Demo")
    val data = intArrayOf(29, 10, 14, 37, 14)
    println("Before: ${data.toList()}")
    selectionSort(data)
    println("After:  ${data.toList()}")
}

/*
 * 🔍 Android Use Cases:
 * - Sorting static menu or settings items alphabetically in a small list.
 * - Organizing tags or labels before display in a note‑taking app.
 * - Ranking a small leaderboard in casual games (low item count).
 * - Ordering preference entries in a settings screen.
 * - Preprocessing small collections (e.g., list of languages) where performance isn’t critical.
 *
 * 🔟 Summary:
 * ✅ Intuitive and easy to implement.
 * ✅ Minimal swaps (at most n‑1), but still O(n²) comparisons.
 * ✅ Not stable by default—equal elements may change order.
 * ✅ Best suited for small or nearly sorted datasets.
 */
