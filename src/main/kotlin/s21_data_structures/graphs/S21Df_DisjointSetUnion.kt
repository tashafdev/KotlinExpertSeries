package s21_data_structures.graphs

/*
 * -----------------------------------------------------
 * ✅ Lecture: Graph Basics (S21Be_GraphBasics.kt)
 * -----------------------------------------------------
 * Graph:
 * - Nodes and edges represent relationships between entities.
 * - Directed vs Undirected graphs.
 * - Weighted vs Unweighted graphs.
 * - Representation: Adjacency List vs Adjacency Matrix.
 *
 * Android Use Cases:
 * ✅ Navigation Graph (Jetpack Navigation):
 *    - Defines app destinations and navigation paths.
 * ✅ Social Graph Modeling:
 *    - Represents user connections, followers, and friend networks.
 * ✅ Network Topology Mapping:
 *    - Visualizes IoT device connections or server clusters.
 * ✅ Dependency Graphs:
 *    - Module or feature dependencies in build systems.
 *
 * 🔹 Use Graph when:
 *    - You need to model relationships between entities.
 *    - You require traversal algorithms like BFS/DFS.
 *    - You need to find shortest paths or connectivity.
 */

// Simple Graph representation using adjacency list
class GraphBasics<T> {
    private val adjacencyList = mutableMapOf<T, MutableList<T>>()

    // Add a node to the graph
    fun addNode(node: T) {
        adjacencyList.putIfAbsent(node, mutableListOf())
    }

    // Add an edge (undirected by default)
    fun addEdge(source: T, destination: T, bidirectional: Boolean = true) {
        adjacencyList.getOrPut(source) { mutableListOf() }.add(destination)
        if (bidirectional) {
            adjacencyList.getOrPut(destination) { mutableListOf() }.add(source)
        }
    }

    // Get neighbors of a node
    fun getNeighbors(node: T): List<T> {
        return adjacencyList[node] ?: emptyList()
    }

    // Display graph structure
    override fun toString(): String {
        return adjacencyList.entries.joinToString("\n") { (node, neighbors) ->
            "$node -> ${neighbors.joinToString(", ")}"
        }
    }
}






/*
 * -----------------------------------------------------
 * 📱 Disjoint Set Union in Android – Real Use Cases (S21Df_DisjointSetUnion.kt)
 * -----------------------------------------------------
 *
 * ✅ User Group Clustering: Merge users into communities based on interaction graphs.
 * ✅ Image Segmentation: Combine pixel regions for object detection and editing.
 * ✅ Connectivity Checks: Determine network reachability clusters in P2P features.
 * ✅ Friend-of-Friend Groups: Efficiently group social circles in chat applications.
 */
