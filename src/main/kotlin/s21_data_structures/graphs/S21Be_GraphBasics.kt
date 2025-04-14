package s21_data_structures.graphs


/*
 * -----------------------------------------------------
 * ✅ Lecture: Graph Basics (S21Be_GraphBasics.kt)
 * -----------------------------------------------------
 * A Graph is a non-linear data structure consisting of:
 * - Nodes (aka Vertices)
 * - Edges (connections between nodes)
 * Graphs can be:
 * - Directed or Undirected
 * - Weighted or Unweighted
 * - Represented via Adjacency List or Matrix
 */

// 1️⃣ Define Graph using Adjacency List
class Graph {
    private val adjList: HashMap<String, MutableList<String>> = HashMap()

    // Add node
    fun addVertex(vertex: String) {
        adjList.putIfAbsent(vertex, mutableListOf())
    }

    // Add edge (undirected)
    fun addEdge(v1: String, v2: String) {
        adjList[v1]?.add(v2)
        adjList[v2]?.add(v1)
    }

    // Print graph
    fun printGraph() {
        println("\nGraph Adjacency List:")
        for ((vertex, edges) in adjList) {
            println("$vertex → $edges")
        }
    }
}

fun main() {
    println("\n✅ Graph Basics Demo")

    val graph = Graph()

    // 2️⃣ Create vertices
    listOf("A", "B", "C", "D", "E").forEach { graph.addVertex(it) }

    // 3️⃣ Connect with edges
    graph.addEdge("A", "B")
    graph.addEdge("A", "C")
    graph.addEdge("B", "D")
    graph.addEdge("C", "E")

    // 4️⃣ Display graph
    graph.printGraph()
}

/*
 * 🔍 Real-World Use Cases:
 * - Maps and navigation systems
 * - Social networks (friends/followers)
 * - Web page linking
 * - Network routing algorithms
 *
 * 🔟 Summary:
 * ✅ Graph = nodes + edges
 * ✅ Represented using Adjacency List (most common) or Matrix
 * ✅ Used in countless real-world systems requiring relationships and paths
 */