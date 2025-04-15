package s21_data_structures.graphs



/*
 * -----------------------------------------------------
 * ✅ Lecture: Graph Basics (S21Be_GraphBasics.kt)
 * -----------------------------------------------------
 * Graph:
 * - A collection of nodes (vertices) connected by edges.
 * - Directed vs Undirected graphs.
 * - Weighted vs Unweighted graphs.
 *
 * Android Use Cases:
 * ✅ Social Network Connections:
 *    - Model friendships or followers in social apps.
 * ✅ Navigation & Maps:
 *    - Represent road networks, POIs, and compute shortest paths.
 * ✅ Dependency Management:
 *    - Handle module or task dependencies in build systems.
 * ✅ Recommendation Systems:
 *    - Collaborative filtering using user-item graphs.
 *
 * 🔹 Use Graph when:
 *    - You need to model relationships or connectivity.
 *    - Pathfinding, clustering, or network analysis is required.
 */

// Simple adjacency-list based Graph implementation
class Graph(
    private val numVertices: Int,
    private val directed: Boolean = false
) {
    private val adjList: Array<MutableList<Int>> = Array(numVertices) { mutableListOf() }

    /**
     * Add an edge from u to v. For undirected graphs, adds both ways.
     */
    fun addEdge(u: Int, v: Int) {
        require(u in 0 until numVertices && v in 0 until numVertices) { "Vertex out of bounds" }
        adjList[u].add(v)
        if (!directed) {
            adjList[v].add(u)
        }
    }

    /**
     * Get neighbors (adjacent vertices) of a given vertex.
     */
    fun getNeighbors(vertex: Int): List<Int> {
        require(vertex in 0 until numVertices) { "Vertex out of bounds" }
        return adjList[vertex]
    }
}

// Example usage:
fun main() {
    val graph = Graph(numVertices = 5)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(3, 4)
    println("Neighbors of 0: ${graph.getNeighbors(0)}") // [1, 2]
}
