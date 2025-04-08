package s21_data_structures


/*
 * -----------------------------------------------------
 * ✅ Lecture 6: Queue Implementation Using List
 * -----------------------------------------------------
 * A Queue is a FIFO (First In, First Out) data structure.
 * Elements are added at the rear and removed from the front.
 */

class Queue<T> {
    private val items = mutableListOf<T>()

    // Enqueue: Add element at rear
    fun enqueue(element: T) {
        items.add(element)
    }

    // Dequeue: Remove and return element from front
    fun dequeue(): T? {
        if (isEmpty()) return null
        return items.removeAt(0)
    }

    // Peek: View front element
    fun peek(): T? = items.firstOrNull()

    // Check if queue is empty
    fun isEmpty(): Boolean = items.isEmpty()

    // Get queue size
    fun size(): Int = items.size

    // Print queue contents
    fun printQueue() {
        println("Queue (front → rear): $items")
    }
}

fun main() {
    println("\n✅ Queue Demo")
    val queue = Queue<String>()

    queue.enqueue("A")
    queue.enqueue("B")
    queue.enqueue("C")
    queue.printQueue() // Output: [A, B, C]

    println("Peek: ${queue.peek()}") // Output: A

    println("Dequeue: ${queue.dequeue()}") // Output: A
    queue.printQueue() // Output: [B, C]
}

/*
 * 🔍 Real-World Use Cases:
 * - Print job scheduling
 * - Task queues in systems
 * - Customer service lines
 * - Order processing systems
 *
 * 🔟 Summary:
 * ✅ Queue follows FIFO principle.
 * ✅ Use enqueue(), dequeue(), peek(), isEmpty() operations.
 * ✅ Great for ordered task processing scenarios.
 */
