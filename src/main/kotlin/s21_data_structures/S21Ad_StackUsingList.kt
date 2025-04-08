package s21_data_structures


/*
 * -----------------------------------------------------
 * ✅ Lecture 5: Stack Implementation Using List
 * -----------------------------------------------------
 * A Stack is a LIFO (Last In, First Out) data structure.
 * Elements are added (pushed) and removed (popped) from the top.
 */

class Stack<T> {
    private val items = mutableListOf<T>()

    // Push: Add element to top
    fun push(element: T) {
        items.add(element)
    }

    // Pop: Remove and return top element
    fun pop(): T? {
        if (isEmpty()) return null
        return items.removeAt(items.size - 1)
    }

    // Peek: View top element
    fun peek(): T? = items.lastOrNull()

    // Check if stack is empty
    fun isEmpty(): Boolean = items.isEmpty()

    // Get stack size
    fun size(): Int = items.size

    // Print stack contents
    fun printStack() {
        println("Stack (top → bottom): ${items.asReversed()}")
    }
}

fun main() {
    println("\n✅ Stack Demo")
    val stack = Stack<String>()

    stack.push("A")
    stack.push("B")
    stack.push("C")
    stack.printStack() // Output: [C, B, A]

    println("Peek: ${stack.peek()}") // Output: C

    println("Pop: ${stack.pop()}") // Output: C
    stack.printStack() // Output: [B, A]
}

/*
 * 🔍 Real-World Use Cases:
 * - Back button navigation in browsers
 * - Undo functionality in editors
 * - Expression parsing
 * - Function call stack in programming
 *
 * 🔟 Summary:
 * ✅ Stack follows LIFO principle.
 * ✅ Use push(), pop(), peek(), isEmpty() operations.
 * ✅ Useful where reverse order tracking is needed.
 */
