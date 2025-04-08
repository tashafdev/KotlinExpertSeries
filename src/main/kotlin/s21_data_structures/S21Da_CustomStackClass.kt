package s21_data_structures


/*
 * -----------------------------------------------------
 * ✅ Lecture: Custom Stack Class (S21Da_CustomStackClass.kt)
 * -----------------------------------------------------
 * A Stack is a LIFO (Last In, First Out) data structure.
 * This lecture shows how to implement a custom generic Stack class in Kotlin.
 */

class CustomStack<T> {
    private val items = mutableListOf<T>()

    fun push(element: T) {
        items.add(element)
    }

    fun pop(): T? {
        return if (items.isNotEmpty()) items.removeAt(items.size - 1) else null
    }

    fun peek(): T? = items.lastOrNull()

    fun isEmpty(): Boolean = items.isEmpty()

    fun size(): Int = items.size

    fun printStack() {
        println("Stack (top → bottom): ${items.asReversed()}")
    }
}

fun main() {
    println("\n✅ Custom Stack Class Demo")

    val stack = CustomStack<String>()
    stack.push("A")
    stack.push("B")
    stack.push("C")
    stack.printStack() // C → B → A

    println("\nPopped: ${stack.pop()}") // C
    stack.printStack()

    println("\nPeek: ${stack.peek()}") // B
    println("Is Empty: ${stack.isEmpty()}")
    println("Size: ${stack.size()}")
}

/*
 * 🔍 Real-World Use Cases:
 * - Undo/Redo operations
 * - Function call stack
 * - Backtracking algorithms
 * - Reversing data
 *
 * 🔟 Summary:
 * ✅ Stack = LIFO structure (Last In, First Out)
 * ✅ Core operations: push, pop, peek, isEmpty
 * ✅ Reusable for any data type using generics
 * ✅ Often used in recursive and backtracking problems
 */
