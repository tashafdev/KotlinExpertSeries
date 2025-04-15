package s22_algorithms.search

/*
 * -----------------------------------------------------
 * 📚 Lecture: Binary Search (S22Ab_BinarySearch.kt)
 * -----------------------------------------------------
 * Binary Search:
 * - Efficient search on sorted arrays or lists.
 * - Time Complexity: O(log n)
 * - Space Complexity: O(1) for iterative, O(log n) for recursive.
 * - Works by repeatedly dividing the search interval in half.
 *
 * This lecture covers:
 * 1️⃣ Iterative implementation on IntArray
 * 2️⃣ Recursive implementation on IntArray
 * 3️⃣ Generic implementation on List<T> where T : Comparable<T>
 * 4️⃣ Demo in main()
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Iterative Binary Search for IntArray
/**
 * Searches for target in sorted array.
 * Returns index if found, or -1 if not found.
 */
fun binarySearchIterative(array: IntArray, target: Int): Int {
    var left = 0
    var right = array.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            array[mid] == target -> return mid
            array[mid] < target  -> left = mid + 1
            else                  -> right = mid - 1
        }
    }
    return -1
}

// 2️⃣ Recursive Binary Search for IntArray
/**
 * Recursive helper function for binary search.
 */
fun binarySearchRecursive(
    array: IntArray,
    target: Int,
    left: Int = 0,
    right: Int = array.size - 1
): Int {
    if (left > right) return -1
    val mid = left + (right - left) / 2
    return when {
        array[mid] == target -> mid
        array[mid] < target  -> binarySearchRecursive(array, target, mid + 1, right)
        else                  -> binarySearchRecursive(array, target, left, mid - 1)
    }
}

// 3️⃣ Generic Binary Search for List<T>
/**
 * Searches for target in sorted list.
 * Returns index if found, or -1 if not found.
 */
fun <T : Comparable<T>> binarySearch(list: List<T>, target: T): Int {
    var left = 0
    var right = list.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        val cmp = list[mid].compareTo(target)
        when {
            cmp == 0    -> return mid
            cmp < 0     -> left = mid + 1
            else        -> right = mid - 1
        }
    }
    return -1
}

// 4️⃣ Demo in main()
fun main() {
    println("\n✅ Binary Search Demo")

    // Iterative search
    val sortedNumbers = intArrayOf(1, 3, 5, 7, 9, 11)
    val targetNum = 7
    println("Iterative search for $targetNum → Index: ${binarySearchIterative(sortedNumbers, targetNum)}")

    // Recursive search
    println("Recursive search for $targetNum → Index: ${binarySearchRecursive(sortedNumbers, targetNum)}")

    // Generic list search
    val sortedList = listOf("Apple", "Banana", "Cherry", "Date", "Fig")
    val searchKey = "Date"
    println("Generic search for \"$searchKey\" → Index: ${binarySearch(sortedList, searchKey)}")
}

/*
 * 🔍 Android Use Cases:
 * - Contact Lookup: Find a contact in a sorted list by name or phone number.
 * - Log Analysis: Search timestamps in sorted sensor or event logs.
 * - Configuration Retrieval: Binary search on sorted config keys or resource identifiers.
 * - Map Overlays: Locate geolocation points in a sorted coordinate array for map rendering.
 * - Version Management: Find specific version codes or release dates in sorted lists.
 *
 * 🔟 Summary:
 * ✅ Binary Search runs in O(log n) on sorted data.
 * ✅ Use iterative for constant space, recursive for readability.
 * ✅ Generic version works on any Comparable<T> list.
 */
