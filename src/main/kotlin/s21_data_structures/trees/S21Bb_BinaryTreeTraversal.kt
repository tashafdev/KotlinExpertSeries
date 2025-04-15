package s21_data_structures.trees



/*
 * -----------------------------------------------------
 * ✅ Lecture: Binary Tree Traversals (S21Bc_BinaryTreeTraversal.kt)
 * -----------------------------------------------------
 *
 * 📌 Traversal refers to the process of visiting each node in a tree exactly once,
 *     in a specific, well-defined order.
 *
 * 🧠 Why is traversal important?
 * - Allows you to print, search, modify, or evaluate the structure.
 * - Different traversal orders solve different problems (e.g., sorted output, expression evaluation).
 *
 * 🔄 Types of Traversals:
 *
 * 1️⃣ Preorder       → Root → Left → Right
 *     - Use case: Serialize or clone a tree structure.
 *
 * 2️⃣ Inorder        → Left → Root → Right
 *     - Use case: Retrieve sorted data (in BSTs).
 *
 * 3️⃣ Postorder      → Left → Right → Root
 *     - Use case: Safely delete nodes, evaluate expression trees.
 *
 * 4️⃣ Level Order    → Breadth-First (Top to Bottom, Left to Right)
 *     - Use case: UI layout trees, file systems, social graphs.
 *
 * 🧠 Tip:
 * - Recursive methods are common, but iterative methods with stack/queue
 *   are used in interview scenarios for space optimization.
 */


import java.util.LinkedList
import java.util.Queue

// 1️⃣ Tree Node Definition
class BTNode(val value: String) {
    var left: BTNode? = null
    var right: BTNode? = null
}

// 2️⃣ Preorder Traversal
fun preorderTraversal(node: BTNode?) {
    if (node == null) return
    print("${node.value} → ")
    preorderTraversal(node.left)
    preorderTraversal(node.right)
}

// 3️⃣ Inorder Traversal
fun inorderTraversal(node: BTNode?) {
    if (node == null) return
    inorderTraversal(node.left)
    print("${node.value} → ")
    inorderTraversal(node.right)
}

// 4️⃣ Postorder Traversal
fun postorderTraversal(node: BTNode?) {
    if (node == null) return
    postorderTraversal(node.left)
    postorderTraversal(node.right)
    print("${node.value} → ")
}

// 5️⃣ Level Order Traversal (Breadth-First)
fun levelOrderTraversal(root: BTNode?) {
    if (root == null) return
    val queue: Queue<BTNode> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val current = queue.remove()
        print("${current.value} → ")

        if (current.left != null) queue.add(current.left)
        if (current.right != null) queue.add(current.right)
    }
}

fun main() {
    println("\n✅ Binary Tree Traversal Demo")

    // Tree structure:
    //        A
    //       / \
    //      B   C
    //     / \
    //    D   E

    val root = BTNode("A")
    root.left = BTNode("B")
    root.right = BTNode("C")
    root.left?.left = BTNode("D")
    root.left?.right = BTNode("E")

    println("\n1️⃣ Preorder Traversal:")
    preorderTraversal(root) // A → B → D → E → C

    println("\n\n2️⃣ Inorder Traversal:")
    inorderTraversal(root) // D → B → E → A → C

    println("\n\n3️⃣ Postorder Traversal:")
    postorderTraversal(root) // D → E → B → C → A

    println("\n\n4️⃣ Level Order Traversal:")
    levelOrderTraversal(root) // A → B → C → D → E
}

/*
 * 🔍 Real-World Use Cases:
 * - Inorder → Sorting BST
 * - Preorder → Serialize/Copy Trees
 * - Postorder → Delete/Free Nodes
 * - Level Order → Print/Display tree levels
 *
 * 🔟 Summary:
 * ✅ Each traversal has a use-case depending on when/what you want to access
 * ✅ Understand the recursive vs iterative nature of each
 * ✅ Level Order requires a Queue (Breadth-First)
 */


/*
 * -----------------------------------------------------
 * 📱 Binary Tree in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ View Hierarchy Rendering:
 *    - The entire UI layout is a tree of views (ViewGroup → View → View).
 *    - `ConstraintLayout`, `LinearLayout`, etc., follow parent-child relationships.

 * ✅ Navigation Graph (Jetpack):
 *    - Represents destinations and subgraphs as a hierarchical structure.
 *    - Supports nested graphs and backstack traversal.

 * ✅ XML Layout Parsing:
 *    - Android parses XML into a tree structure before rendering.

 * ✅ File System Navigation:
 *    - Folder-to-file hierarchy in file manager apps mimics a binary/N-ary tree.

 * ✅ Expression Evaluation:
 *    - Calculator or parser apps use expression trees to compute results.
 *
 * ✅ AI & Decision Trees:
 *    - Game AI, recommendation engines, or form validation flows.

 * 🔹 Use Binary Trees when:
 *    - You need to represent hierarchical relationships.
 *    - You need to traverse, search, or modify data in a structured way.
 */
