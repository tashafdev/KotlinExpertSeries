package s22_algorithms.search

/*
 * -----------------------------------------------------
 * 📚 Lecture: Search in Rotated Sorted Array (S22Ac_SearchInRotatedArray.kt)
 * -----------------------------------------------------
 * Problem:
 * - Given a sorted array that has been rotated at an unknown pivot,
 *   find the index of a given target value, or -1 if not found.
 * - Example: [4, 5, 6, 7, 0, 1, 2]
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 * This lecture covers:
 * 1️⃣ Algorithm explanation (binary search variant)
 * 2️⃣ Implementation on IntArray
 * 3️⃣ Demo in main()
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Search in Rotated Sorted Array using modified binary search
fun searchInRotatedArray(array: IntArray, target: Int): Int {
    var left = 0
    var right = array.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (array[mid] == target) return mid

        // Determine which half is sorted
        if (array[left] <= array[mid]) {
            // Left half is sorted
            if (target >= array[left] && target < array[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        } else {
            // Right half is sorted
            if (target > array[mid] && target <= array[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }
    return -1
}

// 2️⃣ Demo in main()
fun main() {
    println("\n✅ Search in Rotated Sorted Array Demo")

    val rotated = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    println("Array: ${rotated.toList()}")

    val targets = listOf(0, 3, 7, 8)
    for (t in targets) {
        val idx = searchInRotatedArray(rotated, t)
        println("Searching for $t → Index: $idx")
    }
}

/*
 * 🔍 Android Use Cases:
 * - Circular Buffer Search:
 *    Locate elements in rotated sensor data buffers.
 * - Time‑Boundary Logs:
 *    Search timestamps that wrap past midnight in log files.
 * - Carousel Menus:
 *    Find selected item in a circular UI carousel or picker.
 * - Stream Offset Recovery:
 *    Handle rotated offsets in streaming data (e.g., audio/video frames).
 * - Paging with Wrap‑around:
 *    Compute page indices in wrap‑around pagination schemes.
 *
 * 🔟 Summary:
 * ✅ Modified binary search handles rotation in O(log n).
 * ✅ Identify the sorted half each iteration to narrow the search.
 * ✅ Applicable to any circular or pivot‑rotated sorted dataset.
 */
