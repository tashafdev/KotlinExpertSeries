package s22_algorithms.graph_algorithms

/*
 * -----------------------------------------------------
 * 📚 Lecture: BFS Algorithm (S22Fb_BFSAlgorithm.kt)
 * -----------------------------------------------------
 * Breadth‑First Search (BFS):
 * - Explores all neighbors of a node before moving to the next level.
 * - Uses a queue to process nodes in FIFO order.
 * - Time Complexity: O(V + E), where V = vertices, E = edges.
 * - Space Complexity: O(V) for visited set + queue.
 *
 * This lecture covers:
 * 1️⃣ Graph representation (Adjacency List)
 * 2️⃣ BFS implementation using a queue
 * 3️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

import java.util.ArrayDeque

// 1️⃣ Define Graph using Adjacency List
class S22FbBFSAlgorithm {
    private val adjList: MutableMap<String, MutableList<String>> = mutableMapOf()

    fun addVertex(v: String) {
        adjList.putIfAbsent(v, mutableListOf())
    }

    fun addEdge(v1: String, v2: String) {
        adjList.putIfAbsent(v1, mutableListOf())
        adjList.putIfAbsent(v2, mutableListOf())
        adjList[v1]!!.add(v2)
        adjList[v2]!!.add(v1)
    }

    // 2️⃣ BFS using a queue
    fun bfs(start: String): List<String> {
        val visited = mutableSetOf<String>()
        val result = mutableListOf<String>()
        val queue = ArrayDeque<String>()

        visited += start
        queue.add(start)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            result += node
            for (neighbor in adjList[node] ?: emptyList()) {
                if (neighbor !in visited) {
                    visited += neighbor
                    queue.add(neighbor)
                }
            }
        }

        return result
    }
}

fun main() {
    println("\n✅ BFS Algorithm Demo")
    val graph = S22FbBFSAlgorithm()

    // 3️⃣ Build sample graph
    listOf("A", "B", "C", "D", "E", "F").forEach { graph.addVertex(it) }
    graph.addEdge("A", "B")
    graph.addEdge("A", "C")
    graph.addEdge("B", "D")
    graph.addEdge("B", "E")
    graph.addEdge("C", "F")

    // Perform BFS from "A"
    val order = graph.bfs("A")
    println("BFS order: $order")
}

/*
 * 🔍 Android Use Cases:
 * - **Level‑Order View Traversal:** Visit UI elements level by level for animations or inspections.
 * - **Shortest Path in Maps:** Find minimal hops between locations in offline routing graphs.
 * - **Network Broadcast:** Propagate events to connected components in peer‑to‑peer features.
 * - **Permission Requests:** Queue grouped permission dialogs by dependency level.
 * - **Layered Rendering:** Render scene graph nodes by depth for custom drawing engines.
 *
 * 🔟 Summary:
 * ✅ BFS uses a queue to explore level by level.
 * ✅ Guarantees shortest‑path (fewest edges) in unweighted graphs.
 * ✅ Track visited nodes to avoid cycles.
 * ✅ Ideal for level‑order tasks and shortest‑hop searches.
 */
