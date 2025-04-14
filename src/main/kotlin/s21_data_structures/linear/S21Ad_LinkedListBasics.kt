package s21_data_structures.linear


/*
 * -----------------------------------------------------
 * ✅ Lecture 4: LinkedList Basics in Kotlin
 * -----------------------------------------------------
 *
 * 📌 A LinkedList is a linear data structure where each element (node)
 *    contains data and a reference (pointer) to the next node.
 *
 * 🧠 Key Idea:
 * - Elements are not stored in contiguous memory like arrays
 * - Each node is connected via links
 *
 * ✅ When to use:
 * - When you need fast insert/delete at the beginning or middle
 * - When array resizing is too costly
 *
 * 🧠 Performance (Singly Linked List):
 * - Access: O(n)
 * - Insert/Delete (start): O(1)
 * - Insert/Delete (middle/end): O(n)
 */

fun main() {

    // 1️⃣ Simulated LinkedList Using Kotlin's Built-in
    println("1️⃣ Using Kotlin's LinkedList (via Java interop)")
    val linkedList = java.util.LinkedList<String>()
    linkedList.add("Node1")
    linkedList.add("Node2")
    linkedList.addFirst("Head")
    linkedList.addLast("Tail")
    println("LinkedList → $linkedList")

    // 2️⃣ Accessing Elements
    println("\n2️⃣ Accessing Elements")
    println("First → ${linkedList.first}")
    println("Last → ${linkedList.last}")
    println("At Index 1 → ${linkedList[1]}")

    // 3️⃣ Removing Elements
    println("\n3️⃣ Removing Elements")
    linkedList.removeFirst()
    linkedList.remove("Node2")
    println("After removal → $linkedList")

    // 4️⃣ Iteration
    println("\n4️⃣ Iteration")
    linkedList.forEach { println(" - $it") }

    // 5️⃣ Summary
    println("\n5️⃣ Summary")
    println("✅ LinkedList stores elements as nodes with pointers.")
    println("✅ Efficient insert/delete at start or middle.")
    println("❌ Slower access than arrays for random index lookup.")
}
/*
 * -----------------------------------------------------
 * 📱 LinkedList in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ Undo/Redo Stacks:
 *    - Can be implemented using doubly linked list to traverse back and forth.

 * ✅ History Navigation:
 *    - WebView or navigation history can use linked list–like structure.

 * ✅ Music/Media Queues:
 *    - Linked nodes (current, next, previous) make playlist traversal easy.

 * ✅ Custom Views / Canvas Drawing:
 *    - Drawing actions (line, erase, etc.) can be linked and replayed.

 * ✅ LRU Cache Implementation:
 *    - Doubly linked list is often used in tandem with HashMap for LRU logic.

 * 🔹 Use LinkedList when:
 *    - You need frequent insertions/removals in the middle
 *    - You don’t need fast random access
 */
