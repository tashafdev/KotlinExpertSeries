package s21_data_structures.linear


/*
 * -----------------------------------------------------
 * ✅ Lecture 9: Queue Implementation Using List (Custom)
 * -----------------------------------------------------
 *
 * 📌 This lecture shows how to implement a basic Queue in Kotlin
 *     using a MutableList internally.
 *
 * 🧠 Key Operations:
 * - enqueue(item): Add at the end
 * - dequeue(): Remove from the front
 * - peek(): Get front without removing
 * - isEmpty(): Check if empty
 * - size(): Current number of elements
 */

class S21Ai_Queue<T> {
    private val items = mutableListOf<T>()

    fun enqueue(element: T) {
        items.add(element)
    }

    fun dequeue(): T? {
        if (items.isEmpty()) return null
        return items.removeFirst()
    }

    fun peek(): T? = items.firstOrNull()

    fun isEmpty(): Boolean = items.isEmpty()

    fun size(): Int = items.size

    fun print() {
        println("📦 Queue → $items")
    }
}

fun main() {
    val queue = S21Ai_Queue<String>()

    println("🔹 Enqueue: A, B, C")
    queue.enqueue("A")
    queue.enqueue("B")
    queue.enqueue("C")
    queue.print()

    println("\n🔹 Front → ${queue.peek()}")
    println("🔹 Dequeue → ${queue.dequeue()}")
    queue.print()

    println("\n🔹 Size → ${queue.size()}")
    println("🔹 Is Empty? → ${queue.isEmpty()}")
}

/*
 * -----------------------------------------------------
 * 📱 Custom Queue in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ Offline Sync Queue:
 *    - Queue user actions (likes, uploads) for retry when back online.

 * ✅ ViewModel Queues:
 *    - Queue UI events like animations, toasts, or one-time actions.

 * ✅ Job Scheduling:
 *    - Manage a pipeline of background jobs in order of creation.

 * ✅ Fragment/Navigation Queue:
 *    - Manually queue up navigation commands or transitions.

 * ✅ Print/Export Queue:
 *    - Apps that generate PDFs or reports often queue these tasks.

 * 🔹 Use a custom Queue when:
 *    - You want to test, debug, or trace item flow.
 *    - You need full control over behavior or memory efficiency.
 */
