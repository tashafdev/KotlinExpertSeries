package s21_data_structures.linear

/*
 * -----------------------------------------------------
 * ✅ Lecture 5: Custom Singly Linked List Implementation
 * -----------------------------------------------------
 *
 * 📌 A custom implementation of a basic Singly Linked List.
 *    Each node holds a value and reference to the next node.
 *
 * ✅ What you'll learn:
 * - How nodes are linked together
 * - How to insert, delete, and traverse a linked list
 */

class S21Ae_Node<T>(var data: T) {
    var next: S21Ae_Node<T>? = null
}

class S21Ae_LinkedList<T> {
    private var head: S21Ae_Node<T>? = null

    fun insertAtEnd(value: T) {
        val newNode = S21Ae_Node(value)
        if (head == null) {
            head = newNode
            return
        }

        var current = head
        while (current?.next != null) {
            current = current.next
        }
        current?.next = newNode
    }

    fun insertAtStart(value: T) {
        val newNode = S21Ae_Node(value)
        newNode.next = head
        head = newNode
    }

    fun deleteValue(value: T) {
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

    fun printList() {
        var current = head
        print("🧩 Linked List → ")
        while (current != null) {
            print("${current.data} -> ")
            current = current.next
        }
        println("null")
    }
}

fun main() {
    val list = S21Ae_LinkedList<String>()

    list.insertAtEnd("Node1")
    list.insertAtEnd("Node2")
    list.insertAtStart("Head")
    list.insertAtEnd("Node3")
    list.printList()

    list.deleteValue("Node2")
    list.printList()
}

/*
 * -----------------------------------------------------
 * 📱 Custom Linked List in Android – Use Cases
 * -----------------------------------------------------
 *
 * ✅ LRU Cache:
 *    - Manual implementation using HashMap + DoublyLinkedList.

 * ✅ Undo/Redo:
 *    - Custom drawing apps store actions as linked nodes.

 * ✅ History Management:
 *    - Track screen navigation or recent activities in a linked sequence.

 * ✅ Scroll Tracking:
 *    - Track user scroll position, time, or actions using linked list snapshots.

 * 🔹 Use custom implementation when:
 *    - You want full control over node behavior, traversal, or memory.
 *    - Kotlin built-ins don’t give you enough control or performance tuning.
 */
