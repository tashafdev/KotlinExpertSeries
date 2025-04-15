package s22_algorithms.graph_algorithms

/*
 * -----------------------------------------------------
 * 📚 Lecture: Dijkstra’s Algorithm (S22Fc_DijkstraAlgorithm.kt)
 * -----------------------------------------------------
 * Dijkstra’s Algorithm:
 * - Finds shortest paths from a source node to all other nodes
 *   in a weighted graph with non‑negative edge weights.
 * - Time Complexity: O((V + E) log V) using a priority queue.
 * - Space Complexity: O(V + E) for graph storage and O(V) for distances.
 *
 * Key Steps:
 * 1. Initialize distances: dist[source] = 0, others = ∞.
 * 2. Use a min‑heap (priority queue) keyed by current shortest distance.
 * 3. Extract the node u with smallest dist[u]; for each neighbor v:
 *    if dist[u] + weight(u,v) < dist[v], update dist[v] and enqueue v.
 * 4. Repeat until queue is empty.
 *
 * This lecture covers:
 * 1️⃣ Graph representation (adjacency list with weights)
 * 2️⃣ Dijkstra implementation using PriorityQueue
 * 3️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

import java.util.PriorityQueue

// 1️⃣ Graph representation: map each node to list of (neighbor, weight)
class S22FcDijkstraAlgorithm {
    private val adjList = mutableMapOf<String, MutableList<Pair<String, Int>>>()

    fun addVertex(v: String) {
        adjList.putIfAbsent(v, mutableListOf())
    }

    fun addEdge(u: String, v: String, weight: Int) {
        // Directed edge u→v with given weight
        adjList.putIfAbsent(u, mutableListOf())
        adjList.putIfAbsent(v, mutableListOf())
        adjList[u]!!.add(v to weight)
    }

    // 2️⃣ Dijkstra’s algorithm returning map of shortest distances
    fun shortestPaths(source: String): Map<String, Int> {
        // Initialize distances
        val dist = mutableMapOf<String, Int>().withDefault { Int.MAX_VALUE }
        dist[source] = 0

        // Min‑heap of (distance, node)
        val pq = PriorityQueue<Pair<String, Int>>(compareBy { it.second })
        pq.add(source to 0)

        while (pq.isNotEmpty()) {
            val (u, d) = pq.remove()
            if (d > dist.getValue(u)) continue  // Skip outdated entry

            // Relax edges
            for ((v, w) in adjList[u]!!) {
                val nd = d + w
                if (nd < dist.getValue(v)) {
                    dist[v] = nd
                    pq.add(v to nd)
                }
            }
        }
        return dist
    }
}

fun main() {
    println("\n✅ Dijkstra’s Algorithm Demo")

    val graph = S22FcDijkstraAlgorithm()
    // 3️⃣ Build sample weighted graph
    listOf("A", "B", "C", "D", "E").forEach { graph.addVertex(it) }
    graph.addEdge("A", "B", 4)
    graph.addEdge("A", "C", 2)
    graph.addEdge("B", "C", 5)
    graph.addEdge("B", "D", 10)
    graph.addEdge("C", "E", 3)
    graph.addEdge("E", "D", 4)
    graph.addEdge("D", "F", 11)
    graph.addVertex("F") // ensure F exists

    val source = "A"
    val distances = graph.shortestPaths(source)
    println("Shortest distances from $source:")
    distances.forEach { (node, dist) ->
        println("  → $node: ${if (dist == Int.MAX_VALUE) "∞" else dist}")
    }
}

/*
 * 🔍 Android Use Cases:
 * - **Offline Routing:** Compute shortest driving or walking paths in map apps.
 * - **Network Cost Estimation:** Find minimal data‑cost routes in mesh networks.
 * - **Game AI Pathfinding:** Determine optimal paths for characters on weighted terrains.
 * - **Media Streaming:** Select lowest‑latency server routes for live video.
 * - **Resource Scheduling:** Optimize task assignment costs in workflow managers.
 *
 * 🔟 Summary:
 * ✅ Dijkstra finds single‑source shortest paths with non‑negative weights.
 * ✅ PriorityQueue ensures O((V+E) log V) performance.
 * ✅ Suitable for any weighted‑graph pathfinding in Android apps.
 */
