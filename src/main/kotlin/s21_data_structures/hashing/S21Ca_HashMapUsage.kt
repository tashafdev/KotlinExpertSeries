package s21_data_structures.hashing


/*
 * -----------------------------------------------------
 * ✅ Lecture: HashMap Usage (S21Ca_HashMapUsage.kt)
 * -----------------------------------------------------
 * A HashMap is a key-value data structure that offers average O(1) access time.
 * Keys must be unique. Hashing is used to compute the storage index for keys.
 */

fun main() {
    println("\n✅ HashMap Usage Demo")

    // 1️⃣ Create and populate a HashMap
    val map = hashMapOf<Int, String>()
    map[1] = "One"
    map[2] = "Two"
    map[3] = "Three"
    println("HashMap: $map")

    // 2️⃣ Accessing values
    println("\nKey 2 maps to: ${map[2]}") // Two

    // 3️⃣ Updating and removing entries
    map[2] = "Two Updated"
    map.remove(1)
    println("Updated HashMap: $map")

    // 4️⃣ Iterating through entries
    println("\nIterating through entries:")
    for ((key, value) in map) {
        println("Key: $key → Value: $value")
    }

    // 5️⃣ Important notes about keys
    println("\n✔️ Keys must be unique")
    println("✔️ Values can be duplicated")

    // 6️⃣ Internal working
    println("\n✔️ Uses hashCode() to compute index")
    println("✔️ Handles collisions via chaining or open addressing")
}

/*
 * 🔍 Real-World Use Cases:
 * - Caching (key = URL, value = HTML content)
 * - Counting word frequency
 * - Implementing object lookups by ID
 * - Session or configuration storage
 *
 * 🔟 Summary:
 * ✅ Fast access to values via keys (O(1) average)
 * ✅ Keys must be unique
 * ✅ Uses internal hash function to map keys to buckets
 * ✅ Essential for caching, counting, and indexing
 */

/*
 * -----------------------------------------------------
 * 📱 HashMap in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ ViewHolder Caching in RecyclerView:
 *    - Map item view types or positions to recycled ViewHolders for fast binding.
 *
 * ✅ Intent Extras Storage:
 *    - Bundle primitive key‑value pairs for Activity/Fragment communication.
 *
 * ✅ Resource Lookup:
 *    - Cache mappings from resource names to resource IDs or drawables.
 *
 * ✅ Fragment Tag Management:
 *    - Associate fragment tags with fragment instances in FragmentManager.
 *
 * ✅ Preferences Simulation:
 *    - In‑memory key‑value store mirroring SharedPreferences behavior during tests.
 *
 * 🔹 Use HashMap when:
 *    - You need average O(1) access by key.
 *    - Order does not matter and you need frequent inserts/removals.
 */
