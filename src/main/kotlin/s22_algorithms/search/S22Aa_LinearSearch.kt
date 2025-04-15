package s22_algorithms.search

/*
 * -----------------------------------------------------
 * 📚 Lecture: Linear Search (S22Aa_LinearSearch.kt)
 * -----------------------------------------------------
 * Linear Search:
 * - A simple search algorithm that checks each element until the target is found.
 * - Time Complexity: O(n) — checks up to n elements in the worst case.
 * - Space Complexity: O(1) — uses constant extra space.
 *
 * This lecture covers:
 * 1️⃣ Basic IntArray implementation
 * 2️⃣ Generic List<T> implementation with predicate
 * 3️⃣ Searching complex objects (e.g., data class)
 * 4️⃣ Demo in main()
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Basic Linear Search for IntArray
/**
 * Scans the array from start to end, returning the index of the first occurrence
 * of target, or -1 if not found.
 */
fun linearSearch(array: IntArray, target: Int): Int {
    for (index in array.indices) {
        if (array[index] == target) {
            return index // Found at this index
        }
    }
    return -1 // Not found
}

// 2️⃣ Generic Linear Search for List<T> using a predicate
/**
 * Scans the list, returning the index of the first element matching the predicate,
 * or -1 if none match.
 */
fun <T> linearSearch(list: List<T>, predicate: (T) -> Boolean): Int {
    for ((index, element) in list.withIndex()) {
        if (predicate(element)) {
            return index // Found matching element
        }
    }
    return -1 // No match found
}

// 3️⃣ Example: Searching a data class list
data class User(val id: Int, val name: String)

/**
 * Finds the first User with the given id, or null if not found.
 */
fun findUserById(users: List<User>, userId: Int): User? {
    val idx = linearSearch(users) { it.id == userId }
    return if (idx != -1) users[idx] else null
}

// 4️⃣ Demo in main()
fun main() {
    println("\n✅ Linear Search Demo")

    // Basic IntArray search
    val numbers = intArrayOf(4, 8, 15, 16, 23, 42)
    val target = 15
    val pos = linearSearch(numbers, target)
    println("Searching for $target in ${numbers.toList()} → Index: $pos")

    // Generic List search
    val users = listOf(User(1, "Alice"), User(2, "Bob"), User(3, "Charlie"))
    val searchId = 2
    val foundUser = findUserById(users, searchId)
    println("Searching for userId=$searchId → Found: $foundUser")
}

/*
 * 🔍 Android Use Cases:
 * - View Lookup:
 *    Find a specific View in a list of Views by tag or ID.
 * - Contact Search:
 *    Scan a list of Contact objects to locate one by phone number or name.
 * - Preference Retrieval:
 *    Search SharedPreferences entries loaded into a Map for a given key.
 * - Sensor Data Filtering:
 *    Locate the first sensor reading above a threshold in a buffer.
 * - Form Validation:
 *    Check user inputs in sequence to find the first invalid field.
 *
 * 🔟 Summary:
 * ✅ Linear Search is easy to implement and understand.
 * ✅ Best for small or unsorted data.
 * ✅ For large or sorted datasets, consider more efficient algorithms (e.g., Binary Search).
 */