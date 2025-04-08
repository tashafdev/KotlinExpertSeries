package s21_data_structures


/*
 * -----------------------------------------------------
 * ✅ Lecture 7: Deque and PriorityQueue in Kotlin
 * -----------------------------------------------------
 * A Deque (Double-Ended Queue) allows insertion/removal from both ends.
 * A PriorityQueue processes elements based on priority, not insertion order.
 */

import java.util.ArrayDeque
import java.util.PriorityQueue

fun main() {

    // 1️⃣ Deque Basics
    println("\n1️⃣ Deque Basics")
    val deque: ArrayDeque<String> = ArrayDeque()
    deque.addFirst("Front")
    deque.addLast("Rear")
    deque.addLast("End")
    println("Deque → $deque") // Output: [Front, Rear, End]
    println("Removed from front: ${deque.removeFirst()}") // Front
    println("Removed from rear: ${deque.removeLast()}") // End
    println("Deque now → $deque") // Output: [Rear]

    // 2️⃣ Use Cases for Deque
    println("\n2️⃣ Use Cases for Deque")
    println("✔️ Useful for both stack and queue operations")
    println("✔️ Browser history (forward/back)")
    println("✔️ Palindrome checking")

    // 3️⃣ PriorityQueue Basics
    println("\n3️⃣ PriorityQueue Basics")
    val pq = PriorityQueue<Int>()
    pq.add(30)
    pq.add(10)
    pq.add(20)
    println("PriorityQueue (natural order):")
    while (pq.isNotEmpty()) {
        println(pq.remove()) // Output: 10, 20, 30
    }

    // 4️⃣ Custom Priority (Descending Order)
    println("\n4️⃣ Custom PriorityQueue (Descending)")
    val maxPQ = PriorityQueue<Int>(compareByDescending { it })
    maxPQ.addAll(listOf(5, 1, 9, 3))
    println("Descending PriorityQueue:")
    while (maxPQ.isNotEmpty()) {
        println(maxPQ.remove()) // Output: 9, 5, 3, 1
    }

    // 🔟 Summary
    println("\n🔟 Summary")
    println("✅ Deque: Flexible double-ended queue. Use ArrayDeque.")
    println("✅ PriorityQueue: Ordered queue based on priority, not time of insertion.")
    println("✅ Use Deque for dual-end operations. Use PriorityQueue for ranked tasks.")
}
