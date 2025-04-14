package s21_data_structures.linear

/*
 * -----------------------------------------------------
 * ✅ Lecture 6: Stack Basics in Kotlin
 * -----------------------------------------------------
 *
 * 📌 A Stack is a linear data structure that follows the
 *     Last In, First Out (LIFO) principle.
 *
 * 🧠 Key Operations:
 * - push(element): Add to top
 * - pop(): Remove from top
 * - peek(): View top element without removing
 * - isEmpty(): Check if stack is empty
 *
 * ✅ Real-world examples:
 * - Undo/Redo
 * - Browser back button
 * - Function call stack
 */

fun main() {

    // 1️⃣ Create a Stack Using MutableList
    println("1️⃣ Creating a Stack")
    val stack = mutableListOf<String>()

    // 2️⃣ Push elements onto the stack
    println("\n2️⃣ Pushing elements")
    stack.add("A")
    stack.add("B")
    stack.add("C")
    println("Stack → $stack")

    // 3️⃣ Peek (top element)
    println("\n3️⃣ Peek Top")
    val top = stack.last()
    println("Top → $top")

    // 4️⃣ Pop elements (LIFO)
    println("\n4️⃣ Popping elements")
    val popped = stack.removeLast()
    println("Popped → $popped")
    println("Stack now → $stack")

    // 5️⃣ isEmpty
    println("\n5️⃣ isEmpty Check")
    println("Is stack empty? → ${stack.isEmpty()}")

    // 6️⃣ Summary
    println("\n6️⃣ Summary")
    println("✅ Stack follows LIFO — Last In, First Out.")
    println("✅ Use push (add), pop (removeLast), and peek (last).")
}


/*
 * -----------------------------------------------------
 * 📱 Stack in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ Fragment Back Stack:
 *    - Each fragment transaction is pushed onto a stack by the FragmentManager.

 * ✅ Undo/Redo Systems:
 *    - Drawing apps or text editors use two stacks (undo & redo).

 * ✅ Recursive Function Calls:
 *    - The call stack internally follows LIFO order.

 * ✅ Navigation Controllers:
 *    - Jetpack Navigation handles destination back stack using stack structure.

 * ✅ Action Replay / History:
 *    - Track user decisions or app events using a stack model.

 * 🔹 Use Stack when:
 *    - You need to reverse actions or trace back steps
 *    - You’re implementing Undo/Redo or history features
 */


