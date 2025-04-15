package s22_algorithms.graph_algorithms

/*
 * -----------------------------------------------------
 * 📚 Lecture: Kruskal’s & Prim’s Algorithms (S22Fd_KruskalAndPrim.kt)
 * -----------------------------------------------------
 * Minimum Spanning Tree (MST):
 * - A subset of edges connecting all vertices with minimum total weight.
 * - Kruskal’s: Sort edges, add smallest if it doesn’t form a cycle (uses Union‑Find).
 * - Prim’s: Grow tree from a start node, repeatedly add cheapest edge crossing the cut (uses min‑heap).
 *
 * Characteristics:
 * - Kruskal’s Time: O(E log E + E α(V)) with Union‑Find.
 * - Prim’s Time: O(E log V) with adjacency list + priority queue.
 * - Both produce the same total weight for connected, undirected graphs.
 *
 * This lecture covers:
 * 1️⃣ Graph & Edge data classes
 * 2️⃣ Union‑Find helper for Kruskal’s
 * 3️⃣ Kruskal’s implementation
 * 4️⃣ Prim’s implementation
 * 5️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

import java.util.PriorityQueue

// 1️⃣ Data classes for vertices & edges
data class Edge(val u: String, val v: String, val weight: Int)
data class AdjEdge(val to: String, val weight: Int)

// 2️⃣ Union‑Find (Disjoint Set) for Kruskal’s
class UnionFind<T> {
    private val parent = mutableMapOf<T, T>()
    private val rank   = mutableMapOf<T, Int>()

    fun makeSet(x: T) {
        parent[x] = x
        rank[x] = 0
    }

    fun find(x: T): T {
        if (parent[x] != x) parent[x] = find(parent[x]!!)
        return parent[x]!!
    }

    fun union(a: T, b: T) {
        val ra = find(a); val rb = find(b)
        if (ra == rb) return
        when {
            rank[ra]!! < rank[rb]!! -> parent[ra] = rb
            rank[ra]!! > rank[rb]!! -> parent[rb] = ra
            else -> {
                parent[rb] = ra
                rank[ra] = rank[ra]!! + 1
            }
        }
    }
}

// 3️⃣ Kruskal’s MST
fun kruskalMST(vertices: Set<String>, edges: List<Edge>): List<Edge> {
    val uf = UnionFind<String>()
    vertices.forEach { uf.makeSet(it) }

    return edges
        .sortedBy { it.weight }
        .fold(mutableListOf<Edge>()) { mst, edge ->
            if (uf.find(edge.u) != uf.find(edge.v)) {
                uf.union(edge.u, edge.v)
                mst += edge
            }
            mst
        }
}

// 4️⃣ Prim’s MST
fun primMST(start: String, graph: Map<String, List<AdjEdge>>): List<Edge> {
    val visited = mutableSetOf<String>()
    val pq = PriorityQueue<Edge>(compareBy { it.weight })
    val mst = mutableListOf<Edge>()

    // Add edges from start
    visited += start
    graph[start]?.forEach { pq.add(Edge(start, it.to, it.weight)) }

    while (pq.isNotEmpty()) {
        val (u, v, w) = pq.remove()
        if (v in visited) continue
        // Accept edge
        visited += v
        mst += Edge(u, v, w)
        // Add new crossing edges
        graph[v]?.forEach { pq.add(Edge(v, it.to, it.weight)) }
    }
    return mst
}

// 5️⃣ Demo in main()
fun main() {
    println("\n✅ Kruskal’s & Prim’s MST Demo")

    val vertices = setOf("A","B","C","D","E")
    val edges = listOf(
        Edge("A","B",4), Edge("A","C",2),
        Edge("B","C",1), Edge("B","D",5),
        Edge("C","D",8), Edge("C","E",10),
        Edge("D","E",2)
    )

    // Build adjacency list for Prim’s
    val graph = vertices.associateWith { mutableListOf<AdjEdge>() }
        .toMutableMap().also { g ->
            edges.forEach { e ->
                g[e.u]?.add(AdjEdge(e.v, e.weight))
                g[e.v]?.add(AdjEdge(e.u, e.weight))
            }
        }

    // Kruskal’s
    val kruskalMst = kruskalMST(vertices, edges)
    println("Kruskal’s MST edges:")
    kruskalMst.forEach { println("  ${it.u}–${it.v} (${it.weight})") }

    // Prim’s
    val primMst = primMST("A", graph)
    println("\nPrim’s MST edges:")
    primMst.forEach { println("  ${it.u}–${it.v} (${it.weight})") }
}

/*
 * 🔍 Android Use Cases:
 * - **Network Design:** Compute minimal backbone links in mesh or IoT networks.
 * - **Resource Distribution:** Optimize cable or route layouts for utilities in mapping apps.
 * - **Clustering:** Build minimal connection trees for clustering GPS waypoints.
 * - **Game Map Generation:** Connect game regions with minimal paths for traversal.
 * - **Media Syncing:** Minimize cross‑device data transfer paths in peer‑to‑peer features.
 *
 * 🔟 Summary:
 * ✅ Kruskal’s sorts edges and uses Union‑Find to avoid cycles.
 * ✅ Prim’s grows a tree using a priority queue from a start node.
 * ✅ Both yield an MST with total weight minimized.
 * ✅ Choose Kruskal’s when edges ≪ vertices²; choose Prim’s for dense graphs with adjacency lists.
 */
