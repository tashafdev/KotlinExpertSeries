package s21_data_structures.linear

/*
 * -----------------------------------------------------
 * ✅ Lecture 10: Deque & PriorityQueue in Kotlin
 * -----------------------------------------------------
 *
 * 📌 DEQUE (Double-Ended Queue):
 * A linear structure where insertion and removal can happen
 * from both ends (front and rear).
 *
 * 📌 PRIORITY QUEUE:
 * Elements are ordered by priority, not insertion order.
 * The highest (or lowest) priority element is served first.
 */

import java.util.PriorityQueue

fun main() {

    // -----------------------------------------------------
    // 1️⃣ DEQUE BASICS (Using ArrayDeque)
    // -----------------------------------------------------
    println("1️⃣ Deque Example (Double-Ended Queue)")
    val deque = ArrayDeque<String>()

    deque.addLast("A")   // enqueue
    deque.addLast("B")
    deque.addFirst("Start")
    deque.addLast("End")

    println("Deque → $deque") // [Start, A, B, End]
    println("First → ${deque.first()}, Last → ${deque.last()}")

    deque.removeFirst() // removes "Start"
    deque.removeLast()  // removes "End"
    println("After Removals → $deque") // [A, B]

    // -----------------------------------------------------
    // 2️⃣ PRIORITY QUEUE BASICS (Min Heap)
    // -----------------------------------------------------
    println("\n2️⃣ PriorityQueue Example (Min Heap)")
    val pq = PriorityQueue<Int>()
    pq.add(30)
    pq.add(10)
    pq.add(20)

    while (pq.isNotEmpty()) {
        println("Removing → ${pq.remove()}") // ascending order: 10, 20, 30
    }

    // -----------------------------------------------------
    // 3️⃣ Custom Comparator for Max Heap
    // -----------------------------------------------------
    println("\n3️⃣ PriorityQueue as Max Heap")
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    maxHeap.addAll(listOf(5, 15, 1, 20))

    while (maxHeap.isNotEmpty()) {
        println("Max Removed → ${maxHeap.remove()}") // descending: 20, 15, 5, 1
    }
}


/*
 * -----------------------------------------------------
 * 📱 Deque & PriorityQueue in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ ArrayDeque:
 *    - Back/forward navigation stack in custom WebView or flow builder
 *    - Swipe action buffers in gesture-based apps
 *    - Animation queueing at both ends

 * ✅ PriorityQueue:
 *    - Task scheduling by priority (e.g., sync jobs)
 *    - Notifications (urgent > normal)
 *    - Offline retry queues (based on retry score/time)
 *    - Cache eviction policies (custom LRU, time-based)

 * ✅ Thread scheduling (in system level):
 *    - Task threads can be queued using priority

 * 🔹 Use Deque when:
 *    - You need double-ended access for insert/remove

 * 🔹 Use PriorityQueue when:
 *    - You want sorted access, not just FIFO
 */

