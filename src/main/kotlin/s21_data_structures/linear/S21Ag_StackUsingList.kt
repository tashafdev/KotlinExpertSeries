package s21_data_structures.linear


/*
 * -----------------------------------------------------
 * ✅ Lecture 7: Stack Implementation Using List (Custom)
 * -----------------------------------------------------
 *
 * 📌 In this lecture, we’ll implement a basic Stack class in Kotlin
 *     using a MutableList as the internal storage.
 *
 * 🧠 Key Methods:
 * - push(item): Add to top
 * - pop(): Remove top
 * - peek(): View top without removing
 * - isEmpty(): Check if stack is empty
 * - size(): Current size of stack
 */

class S21Ag_Stack<T> {
    private val items = mutableListOf<T>()

    fun push(element: T) {
        items.add(element)
    }

    fun pop(): T? {
        if (items.isEmpty()) return null
        return items.removeLast()
    }

    fun peek(): T? {
        return items.lastOrNull()
    }

    fun isEmpty(): Boolean = items.isEmpty()

    fun size(): Int = items.size

    fun print() {
        println("🧱 Stack → $items")
    }
}

fun main() {
    val stack = S21Ag_Stack<String>()

    println("🔹 Pushing: A, B, C")
    stack.push("A")
    stack.push("B")
    stack.push("C")
    stack.print()

    println("\n🔹 Top Element → ${stack.peek()}")
    println("🔹 Stack Size → ${stack.size()}")

    println("\n🔹 Popping → ${stack.pop()}")
    stack.print()

    println("\n🔹 Is Stack Empty? → ${stack.isEmpty()}")
}




/*
 * -----------------------------------------------------
 * 📱 Custom Stack in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ Undo/Redo Stacks in Drawing/Editor Apps:
 *    - Store previous actions as a stack of states or commands.

 * ✅ ViewModel State Stack:
 *    - Maintain screen or form state stack in memory for step-wise navigation.

 * ✅ Game Logic:
 *    - Manage turn-based or move history using a stack.

 * ✅ Navigation History:
 *    - Custom backstack implementation in single-activity apps.

 * ✅ Dialog Stack Manager:
 *    - Track open dialogs/modals manually using a stack of IDs or objects.

 * 🔹 Use a custom Stack class when:
 *    - You want better control, debugging, or structure.
 *    - Kotlin’s built-in `List` doesn’t expose clear “stack” semantics.
 */

