package s21_data_structures.advanced

/*
 * -----------------------------------------------------
 * ✅ Lecture: LRU Cache Using LinkedHashMap (S21Dh_LRUCacheUsingLinkedHashMap.kt)
 * -----------------------------------------------------
 * LRU Cache (generic Kotlin version):
 * - Evicts the least‑recently‑used entry when capacity is exceeded.
 * - Uses LinkedHashMap with accessOrder = true.
 * - Override removeEldestEntry() to enforce max size.
 *
 * Key Operations:
 * - put(key, value): Insert or update an entry.
 * - get(key): Retrieve an entry and mark as recently used.
 * - keys(): Return the current set of keys in LRU order.
 * - size(): Current number of entries.
 * - clear(): Remove all entries.
 */

import java.util.LinkedHashMap

// 1️⃣ Define a generic LRU Cache using LinkedHashMap
class S21DhLRUCacheUsingLinkedHashMap<K, V>(private val maxSize: Int) {
    private val cache = object : LinkedHashMap<K, V>(0, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>): Boolean {
            return size > maxSize
        }
    }

    // 2️⃣ Insert or update an entry
    fun put(key: K, value: V) {
        cache[key] = value
    }

    // 3️⃣ Retrieve an entry and mark as recently used
    fun get(key: K): V? = cache[key]

    // 4️⃣ Expose keys in LRU order (oldest first)
    fun keys(): Set<K> = cache.keys

    // 5️⃣ Current cache size
    fun size(): Int = cache.size

    // 6️⃣ Clear all entries
    fun clear() = cache.clear()
}

fun main() {
    println("\n✅ LRU Cache Demo (String→Int)")

    // 7️⃣ Initialize cache with max size 3
    val lru = S21DhLRUCacheUsingLinkedHashMap<String, Int>(3)

    // 8️⃣ Put entries
    lru.put("one", 1)
    lru.put("two", 2)
    lru.put("three", 3)
    println("Cache keys: ${lru.keys()}") // [one, two, three]

    // Access 'one' to mark it as recently used
    lru.get("one")

    // Insert 'four' – should evict 'two'
    lru.put("four", 4)
    println("Cache keys after insert four: ${lru.keys()}") // [three, one, four]
}

/*
 * 🔍 Pure Kotlin Use Cases:
 * - Memoization:
 *    Cache results of expensive function calls.
 * - Rate Limiting:
 *    Track and evict request timestamps to enforce limits.
 * - Session Management:
 *    Temporarily store user session data with eviction.
 * - Configuration Caching:
 *    Cache parsed config values (e.g., JSON, XML) for reuse.
 * - Simple In‑Memory Cache:
 *    Limit growth of any key‑value store in CLI or server apps.
 *
 * 🔟 Summary:
 * ✅ `LinkedHashMap(accessOrder=true)` + override `removeEldestEntry()` = LRU behavior.
 * ✅ Generic, pure Kotlin—no Android dependencies.
 * ✅ Near‑O(1) operations for put/get/evict.
 */

