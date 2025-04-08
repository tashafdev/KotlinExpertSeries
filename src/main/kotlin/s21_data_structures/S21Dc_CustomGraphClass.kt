package s21_data_structures


/*
 * -----------------------------------------------------
 * ✅ Lecture: Custom Graph Class (S21Bg_CustomGraphClass.kt)
 * -----------------------------------------------------
 * A custom Graph class using an adjacency list.
 * Supports directed/undirected edges and generic node types.
 */

class CustomGraph<T> {
    private val adjList: HashMap<T, MutableList<T>> = HashMap()

    fun addVertex(vertex: T) {
        adjList.putIfAbsent(vertex, mutableListOf())
    }

    fun addEdge(src: T, dest: T, isDirected: Boolean = false) {
        adjList[src]?.add(dest)
        if (!isDirected) adjList[dest]?.add(src)
    }

    fun removeEdge(src: T, dest: T, isDirected: Boolean = false) {
        adjList[src]?.remove(dest)
        if (!isDirected) adjList[dest]?.remove(src)
    }

    fun removeVertex(vertex: T) {
        adjList.remove(vertex)
        for (edges in adjList.values) {
            edges.remove(vertex)
        }
    }

    fun printGraph() {
        println("\n📊 Graph Structure:")
        for ((vertex, edges) in adjList) {
            println("$vertex → $edges")
        }
    }

    fun hasEdge(src: T, dest: T): Boolean {
        return adjList[src]?.contains(dest) == true
    }

    fun getVertices(): Set<T> = adjList.keys
    fun getNeighbors(vertex: T): List<T> = adjList[vertex] ?: emptyList()
}

fun main() {
    println("\n✅ Custom Graph Class Demo")

    val graph = CustomGraph<String>()
    listOf("A", "B", "C", "D").forEach { graph.addVertex(it) }

    graph.addEdge("A", "B")
    graph.addEdge("A", "C")
    graph.addEdge("B", "D")

    graph.printGraph()

    println("\nRemoving edge A → C")
    graph.removeEdge("A", "C")
    graph.printGraph()

    println("\nRemoving vertex B")
    graph.removeVertex("B")
    graph.printGraph()
}

/*
 * 🔍 Real-World Use Cases:
 * - Network connections
 * - Maps and city routes
 * - Social media friend graphs
 * - Organizational hierarchies
 *
 * 🔟 Summary:
 * ✅ Adjacency List is space-efficient for sparse graphs
 * ✅ Supports adding/removing vertices & edges
 * ✅ Easily extendable to weighted or directed graphs
 */
