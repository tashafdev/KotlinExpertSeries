package s21_data_structures.graphs


/*
 * -----------------------------------------------------
 * ✅ Lecture: Graph Basics (S21Be_GraphBasics.kt)
 * -----------------------------------------------------
 * A Graph is a non‑linear data structure consisting of:
 * - Nodes (aka Vertices)
 * - Edges (connections between nodes)
 * Graphs can be:
 * - Directed or Undirected
 * - Weighted or Unweighted
 * - Represented via Adjacency List or Matrix
 */

// 1️⃣ Define Graph using Adjacency List
class S21BeGraphBasics {
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

    val graph = S21BeGraphBasics()

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
 * 🔍 Real‑World Use Cases (Android):
 * - Maps & navigation (e.g., offline routing)
 * - Social graphs (friends/followers)
 * - In‑app web‑view link graphs
 * - Network topology visualizers
 *
 * 🔟 Summary:
 * ✅ Graph = nodes + edges
 * ✅ Adjacency List is most common
 * ✅ Used everywhere relationships or paths matter
 */


/*
 * -----------------------------------------------------
 * 📱 Graph Basics – Android Use Cases
 * -----------------------------------------------------
 * - Maps & navigation (e.g., offline routing)
 * - Social graphs (friends/followers)
 * - In-app web-view link graphs
 * - Network topology visualizers
 * - Dependency graphs in modular apps
 * - Screen flow graphs for analytics
 * - Content recommendation networks
 */
