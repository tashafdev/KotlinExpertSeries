package s21_data_structures.advanced


/*
 * -----------------------------------------------------
 * ✅ Lecture: Custom Queue Class (S21Db_CustomQueueClass.kt)
 * -----------------------------------------------------
 * A Queue is a FIFO (First In, First Out) data structure.
 * This lecture shows how to implement a generic Queue class in Kotlin.
 */

class CustomQueue<T> {
    private val items = mutableListOf<T>()

    fun enqueue(element: T) {
        items.add(element)
    }

    fun dequeue(): T? {
        return if (items.isNotEmpty()) items.removeAt(0) else null
    }

    fun peek(): T? = items.firstOrNull()

    fun isEmpty(): Boolean = items.isEmpty()

    fun size(): Int = items.size

    fun printQueue() {
        println("Queue (front → rear): $items")
    }
}

fun main() {
    println("\n✅ Custom Queue Class Demo")

    val queue = CustomQueue<String>()
    queue.enqueue("One")
    queue.enqueue("Two")
    queue.enqueue("Three")
    queue.printQueue() // [One, Two, Three]

    println("\nDequeued: ${queue.dequeue()}") // One
    queue.printQueue()

    println("\nPeek: ${queue.peek()}") // Two
    println("Is Empty: ${queue.isEmpty()}")
    println("Size: ${queue.size()}")
}

/*
 * 🔍 Real-World Use Cases:
 * - Print job scheduling
 * - OS-level process scheduling
 * - Customer service ticketing systems
 * - BFS traversal in graphs
 *
 * 🔟 Summary:
 * ✅ Queue = FIFO structure (First In, First Out)
 * ✅ Core operations: enqueue, dequeue, peek, isEmpty
 * ✅ Generic and reusable for any data type
 * ✅ Great for real-time processing and buffering
 */