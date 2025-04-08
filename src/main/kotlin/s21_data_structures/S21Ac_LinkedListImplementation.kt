package s21_data_structures


/*
 * -----------------------------------------------------
 * ✅ Lecture 4: Linked List Implementation in Kotlin
 * -----------------------------------------------------
 * A Linked List is a linear data structure where elements (nodes) point to the next.
 * Unlike arrays, elements are not stored in contiguous memory.
 */

// 1️⃣ Node Class
class Node<T>(var data: T) {
    var next: Node<T>? = null
}

// 2️⃣ Linked List Class
class LinkedList<T> {
    private var head: Node<T>? = null

    // Insert at the end
    fun insert(data: T) {
        val newNode = Node(data)
        if (head == null) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    // Print all nodes
    fun printList() {
        var current = head
        print("LinkedList: ")
        while (current != null) {
            print("${current.data} → ")
            current = current.next
        }
        println("null")
    }

    // Delete by value
    fun delete(value: T) {
        if (head == null) return

        if (head?.data == value) {
            head = head?.next
            return
        }

        var current = head
        while (current?.next != null) {
            if (current.next?.data == value) {
                current.next = current.next?.next
                return
            }
            current = current.next
        }
    }
}

fun main() {
    println("\n✅ Linked List Demo")
    val list = LinkedList<Int>()
    list.insert(10)
    list.insert(20)
    list.insert(30)
    list.printList() // Output: 10 → 20 → 30 → null

    println("Deleting 20")
    list.delete(20)
    list.printList() // Output: 10 → 30 → null
}

/*
 * 🔍 Real-World Use Cases:
 * - Music playlist navigation
 * - Undo-redo systems
 * - Dynamic memory allocation
 * - Browser history
 *
 * 🔟 Summary:
 * ✅ LinkedList uses nodes connected via 'next' references.
 * ✅ Great for dynamic insertions/deletions.
 * ✅ Slower access time than arrays but efficient for modification-heavy scenarios.
 */
