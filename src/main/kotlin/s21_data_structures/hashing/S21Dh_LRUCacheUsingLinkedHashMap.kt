package s21_data_structures.hashing


/*
 * -----------------------------------------------------
 * ✅ Lecture: LRU Cache Using LinkedHashMap (S21Dh_LRUCacheUsingLinkedHashMap.kt)
 * -----------------------------------------------------
 * LRU Cache:
 * - Evicts the least-recently-used entry when capacity is exceeded.
 * - Use LinkedHashMap with accessOrder = true.
 * - Override removeEldestEntry() to enforce max size.
 *
 * Kotlin Use Case: Memoization with Limited Cache
 * - Cache function results with a fixed capacity.
 *
 * Kotlin Use Case: Data Processing Pipeline
 * - Cache recent computed segments for re-use.
 *
 * Example Implementation:
 */

class LruCache<K, V>(private val maxSize: Int) {
    private val cache = object : LinkedHashMap<K, V>(0, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>): Boolean {
            return size > maxSize
        }
    }

    fun put(key: K, value: V) {
        cache[key] = value
    }

    fun get(key: K): V? = cache[key]

    fun clear() = cache.clear()
}


/*
 * -----------------------------------------------------
 * 📱 LRU Cache via LinkedHashMap in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ Bitmap Memory Caching:
 *    - Store recently used images to avoid reloading from disk or network.
 *
 * ✅ Network Response Caching:
 *    - Cache API responses for lists or detail screens to reduce calls.
 *
 * ✅ View Inflation Cache:
 *    - Keep recently inflated layouts or views for quick reuse.
 *
 * ✅ Thumbnail Preloading:
 *    - Cache video or gallery thumbnails for smooth scrolling.
 *
 * ✅ Database Query Results:
 *    - Cache recent query results for offline or quick access.
 *
 * 🔹 Use LRU Cache when:
 *    - You need to limit memory usage by evicting least‑recently‑used items.
 *    - Predictable eviction policy based on access order is required.
 */
