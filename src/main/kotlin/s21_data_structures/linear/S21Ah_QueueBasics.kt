package s21_data_structures.linear

/*
 * -----------------------------------------------------
 * ✅ Lecture 8: Queue Basics in Kotlin
 * -----------------------------------------------------
 *
 * 📌 A Queue is a linear data structure that follows the
 *     First In, First Out (FIFO) principle.
 *
 * 🧠 Key Operations:
 * - enqueue(item): Add to rear
 * - dequeue(): Remove from front
 * - peek(): View front element
 * - isEmpty(): Check if queue is empty
 *
 * ✅ Real-world examples:
 * - Printer queue
 * - Call center queues
 * - Task scheduling
 */

fun main() {

    // 1️⃣ Create a Queue using MutableList
    println("1️⃣ Creating a Queue")
    val queue = mutableListOf<String>()

    // 2️⃣ Enqueue (add to rear)
    println("\n2️⃣ Enqueue Elements")
    queue.add("User1")
    queue.add("User2")
    queue.add("User3")
    println("Queue → $queue")

    // 3️⃣ Peek front
    println("\n3️⃣ Peek Front")
    println("Front → ${queue.first()}")

    // 4️⃣ Dequeue (remove from front)
    println("\n4️⃣ Dequeue")
    val removed = queue.removeFirst()
    println("Dequeued → $removed")
    println("Queue now → $queue")

    // 5️⃣ isEmpty
    println("\n5️⃣ isEmpty Check")
    println("Is queue empty? → ${queue.isEmpty()}")

    // 6️⃣ Summary
    println("\n6️⃣ Summary")
    println("✅ Queue uses FIFO → First In, First Out")
    println("✅ Enqueue = add(), Dequeue = removeFirst()")
}


/*
 * -----------------------------------------------------
 * 📱 Queue in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ Network Request Queues:
 *    - Retrofit, Volley, or custom job queues process requests FIFO.

 * ✅ Notification Manager:
 *    - Queue notifications and show them one by one.

 * ✅ Message/Event Queues:
 *    - Handler/Looper or Coroutine Dispatchers manage internal message queues.

 * ✅ WorkManager:
 *    - Enqueues background work requests in order.

 * ✅ Playback Queues:
 *    - Music/Video apps maintain a queue of tracks or videos.

 * 🔹 Use Queue when:
 *    - You need to **process items in the order they arrived**
 *    - You're modeling real-world queues (tasks, people, requests)
 */

