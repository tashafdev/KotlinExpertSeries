package s21_data_structures.advanced

/*
 * -----------------------------------------------------
 * ✅ Lecture: Disjoint Set Union (S21Df_DisjointSetUnion.kt)
 * -----------------------------------------------------
 * Disjoint Set Union (Union‑Find):
 * - Maintains a collection of disjoint sets.
 * - Operations:
 *    • makeSet(item): Create a new set containing item.
 *    • find(item): Return the representative (root) of item's set, with path compression.
 *    • union(a, b): Merge the sets containing a and b, using union by rank.
 */

class S21DfDisjointSetUnion<T> {
    private val parent = mutableMapOf<T, T>()
    private val rank   = mutableMapOf<T, Int>()

    // 1️⃣ Create a new set containing the given item
    fun makeSet(item: T) {
        parent[item] = item
        rank[item]   = 0
    }

    // 2️⃣ Find the representative of the set containing item (with path compression)
    fun find(item: T): T {
        val p = parent[item] ?: throw IllegalArgumentException("Element not found: $item")
        if (p != item) {
            parent[item] = find(p)
        }
        return parent[item]!!
    }

    // 3️⃣ Union the sets containing a and b (by rank)
    fun union(a: T, b: T) {
        val rootA = find(a)
        val rootB = find(b)
        if (rootA == rootB) return

        val rankA = rank[rootA]!!
        val rankB = rank[rootB]!!
        when {
            rankA < rankB -> parent[rootA] = rootB
            rankA > rankB -> parent[rootB] = rootA
            else -> {
                parent[rootB] = rootA
                rank[rootA] = rankA + 1
            }
        }
    }
}

fun main() {
    println("\n✅ Disjoint Set Union Demo")
    val dsu = S21DfDisjointSetUnion<String>()
    // Initialize sets
    listOf("A", "B", "C", "D", "E").forEach { dsu.makeSet(it) }

    // Perform unions
    dsu.union("A", "B")
    dsu.union("C", "D")

    // Queries
    println("A & B same set? ${dsu.find("A") == dsu.find("B")}") // true
    println("A & C same set? ${dsu.find("A") == dsu.find("C")}") // false
}

/*
 * 🔍 Android Use Cases:
 * - Social Group Management:
 *    Merge friend circles or chat groups when users join or leave communities.
 * - Connected Components in Maps:
 *    Determine if two locations are reachable in offline routing or clustering POIs.
 * - Image Segmentation:
 *    Union adjacent pixels/regions for filters, object detection, or panorama stitching.
 * - Resource Pooling:
 *    Group similar UI resources (themes, styles) for batched loading or caching.
 * - Permission Grouping:
 *    Cluster related runtime permissions to request them in batches.
 *
 * 🔟 Summary:
 * ✅ DSU provides near‑constant‑time union & find
 * ✅ Path compression + union by rank optimize performance
 * ✅ Ideal for connectivity, grouping, and clustering tasks
 */
