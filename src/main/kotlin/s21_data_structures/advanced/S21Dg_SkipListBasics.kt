package s21_data_structures.advanced

/*
 * -----------------------------------------------------
 * ✅ Lecture: Custom Queue Class (S21Db_CustomQueueClass.kt)
 * -----------------------------------------------------
 * A Queue is a FIFO (First In, First Out) data structure.
 * It stores elements in insertion order and removes them in the same order.
 *
 * Key Operations:
 * - enqueue(item): Add an element to the end of the queue.
 * - dequeue(): Remove and return the element at the front; returns null if empty.
 * - peek(): Return the front element without removing it; returns null if empty.
 * - isEmpty(): Check if the queue has no elements.
 * - size(): Get the number of elements in the queue.
 */

// 1️⃣ Custom generic Queue implementation
class CustomQueue1<T> {
    private val elements = mutableListOf<T>()

    // Add an element to the end of the queue
    fun enqueue(item: T) {
        elements.add(item)
    }

    // Remove and return the front element
    fun dequeue(): T? = if (elements.isEmpty()) null else elements.removeAt(0)

    // Peek at the front element without removing it
    fun peek(): T? = elements.firstOrNull()

    // Check if the queue is empty
    fun isEmpty(): Boolean = elements.isEmpty()

    // Get the current size of the queue
    fun size(): Int = elements.size
}

fun main() {
    println("\n✅ Custom Queue Demo")
    val queue = CustomQueue<String>()

    // 2️⃣ Demonstrate operations
    queue.enqueue("A")
    queue.enqueue("B")
    println("Front element: ${queue.peek()}")   // A
    println("Dequeued: ${queue.dequeue()}")      // A
    println("Size after dequeue: ${queue.size()}") // 1
}

/*
 * 🔍 Android Use Cases:
 * - Task Scheduling:
 *    Manage background tasks or jobs in order of arrival (WorkManager, JobScheduler).
 * - Event Queue:
 *    Handle user input events or sensor data sequentially (MotionEvents, SensorEventListener).
 * - Message Processing:
 *    Process chat messages or notifications in FIFO order before displaying.
 * - Request Throttling:
 *    Queue network calls (Retrofit/OkHttp) to prevent API rate limits.
 *
 * 🔟 Summary:
 * ✅ Queue = FIFO (First In, First Out)
 * ✅ Provides enqueue, dequeue, peek, isEmpty, size operations
 * ✅ Ideal for ordered processing and scheduling tasks
 */
