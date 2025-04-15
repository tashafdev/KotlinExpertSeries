package s22_algorithms.divide_and_conquer

/*
 * -----------------------------------------------------
 * 📘 Lecture: Divide & Conquer Intro (S22Ec_DivideAndConquerIntro.kt)
 * -----------------------------------------------------
 * Divide & Conquer:
 * - Break a problem into smaller subproblems of the same type.
 * - Conquer: solve subproblems recursively.
 * - Combine: merge subproblem solutions into the overall solution.
 * - Often leads to efficient algorithms (e.g., Merge Sort, Quick Sort, Binary Search).
 *
 * Key Steps:
 * 1. Divide the input into subproblems.
 * 2. Conquer each subproblem recursively.
 * 3. Combine results to form the final solution.
 *
 * Time Complexity:
 * - T(n) = a T(n/b) + f(n) (Master theorem).
 * - Common patterns: O(n log n), O(n), etc.
 *
 * This lecture covers:
 * 1️⃣ Max in Array (Divide & Conquer example)
 * 2️⃣ Demo in main()
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Find maximum element in array using divide & conquer
fun findMax(array: IntArray, left: Int = 0, right: Int = array.size - 1): Int {
    if (left == right) return array[left] // base case
    val mid = left + (right - left) / 2
    val maxLeft = findMax(array, left, mid)
    val maxRight = findMax(array, mid + 1, right)
    return if (maxLeft >= maxRight) maxLeft else maxRight
}

// 2️⃣ Demo in main()
fun main() {
    println("\n✅ Divide & Conquer Intro Demo")
    val data = intArrayOf(3, 6, 2, 9, 4, 8, 1, 7)
    println("Array: ${data.toList()}")
    val max = findMax(data)
    println("Maximum value: $max")
}

/*
 * 🔍 Android Use Cases:
 * - **Parallel Image Processing:** Split image into tiles, process each, then merge.
 * - **Multi-threaded Data Sync:** Partition data sets for concurrent network requests and merge results.
 * - **Layout Partitioning:** Divide complex UI into sections for independent rendering.
 * - **Game Map Generation:** Recursively subdivide terrain for quad-tree spatial indexing.
 * - **Fractal Generation:** Compute fractal regions recursively and combine into full image.
 *
 * 🔟 Summary:
 * ✅ Divide & Conquer splits problems for simpler recursive solutions.
 * ✅ Efficient for algorithms like Merge Sort (O(n log n)), Quick Sort (avg O(n log n)).
 * ✅ Master theorem guides time complexity analysis.
 */