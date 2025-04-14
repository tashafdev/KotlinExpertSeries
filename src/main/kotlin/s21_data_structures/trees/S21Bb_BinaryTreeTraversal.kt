package s21_data_structures.trees



/*
 * -----------------------------------------------------
 * ✅ Lecture: Binary Tree Traversals (S21Bc_BinaryTreeTraversal.kt)
 * -----------------------------------------------------
 * Traversal = Visiting all nodes in a tree in a specific order.
 * Types:
 * - Preorder (Root → Left → Right)
 * - Inorder (Left → Root → Right)
 * - Postorder (Left → Right → Root)
 * - Level Order (Top to Bottom, Left to Right)
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
