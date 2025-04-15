package s22_algorithms.graph_algorithms

/*
 * -----------------------------------------------------
 * 📚 Lecture: DFS Algorithm (S22Fa_DFSAlgorithm.kt)
 * -----------------------------------------------------
 * Depth‑First Search (DFS):
 * - Explores as far as possible along each branch before backtracking.
 * - Can be implemented recursively (call stack) or iteratively (explicit stack).
 * - Time Complexity: O(V + E) where V = vertices, E = edges.
 * - Space Complexity: O(V) for visited set + recursion/stack.
 *
 * This lecture covers:
 * 1️⃣ Graph representation (Adjacency List)
 * 2️⃣ Recursive DFS implementation
 * 3️⃣ Iterative DFS implementation
 * 4️⃣ Demo in `main()`
 * 🔍 Android Use Cases
 * 🔟 Summary
 */

// 1️⃣ Define Graph using Adjacency List
class S22FaDFSAlgorithm {
    private val adjList: MutableMap<String, MutableList<String>> = mutableMapOf()

    // Add a vertex if it doesn't exist
    fun addVertex(v: String) {
        adjList.putIfAbsent(v, mutableListOf())
    }

    // Add an undirected edge between v1 and v2
    fun addEdge(v1: String, v2: String) {
        adjList.putIfAbsent(v1, mutableListOf())
        adjList.putIfAbsent(v2, mutableListOf())
        adjList[v1]!!.add(v2)
        adjList[v2]!!.add(v1)
    }

    // 2️⃣ Recursive DFS
    fun dfsRecursive(start: String): List<String> {
        val visited = mutableSetOf<String>()
        val result = mutableListOf<String>()

        fun dfs(node: String) {
            if (node in visited) return             // Already visited
            visited += node                          // Mark as visited
            result += node                           // Process node
            for (neighbor in adjList[node] ?: emptyList()) {
                dfs(neighbor)                        // Recurse on neighbor
            }
        }

        dfs(start)
        return result
    }

    // 3️⃣ Iterative DFS using an explicit stack
    fun dfsIterative(start: String): List<String> {
        val visited = mutableSetOf<String>()
        val result = mutableListOf<String>()
        val stack = ArrayDeque<String>()

        stack.add(start)
        while (stack.isNotEmpty()) {
            val node = stack.removeLast()           // Pop from stack
            if (node in visited) continue           // Skip if seen
            visited += node                         // Mark as visited
            result += node                          // Process node
            // Push neighbors in reverse order for consistent traversal
            for (neighbor in (adjList[node] ?: emptyList()).asReversed()) {
                if (neighbor !in visited) {
                    stack.add(neighbor)
                }
            }
        }

        return result
    }
}

fun main() {
    println("\n✅ DFS Algorithm Demo")
    val graph = S22FaDFSAlgorithm()

    // 4️⃣ Build sample graph
    listOf("A", "B", "C", "D", "E", "F").forEach { graph.addVertex(it) }
    graph.addEdge("A", "B")
    graph.addEdge("A", "C")
    graph.addEdge("B", "D")
    graph.addEdge("B", "E")
    graph.addEdge("C", "F")

    // Recursive DFS from "A"
    val recOrder = graph.dfsRecursive("A")
    println("Recursive DFS order: $recOrder")

    // Iterative DFS from "A"
    val itrOrder = graph.dfsIterative("A")
    println("Iterative DFS order: $itrOrder")
}

/*
 * 🔍 Android Use Cases:
 * - **View Hierarchy Traversal:** Recursively search nested ViewGroups to find or modify specific Views.
 * - **File System Walk:** Explore directories/files for media pickers or custom file browsers.
 * - **Social Graph Discovery:** Find friend‑of‑friend connections in social networking features.
 * - **Maze/Pathfinding:** Traverse game maps or UI flow graphs for puzzle games.
 * - **Dependency Resolution:** Order module or resource loading based on graph dependencies.
 *
 * 🔟 Summary:
 * ✅ DFS explores deep before backtracking—good for reachability and path finding.
 * ✅ Recursive version is concise; iterative version avoids call‑stack limits.
 * ✅ Always track visited nodes to prevent infinite loops in cyclic graphs.
 */
