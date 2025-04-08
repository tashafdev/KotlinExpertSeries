package s21_data_structures


/*
 * -----------------------------------------------------
 * ✅ Lecture: Binary Tree Basics (S21Ba_TreeBasics.kt)
 * -----------------------------------------------------
 * A Binary Tree is a non-linear data structure where each node has at most two children.
 * Nodes are connected in a parent-child relationship.
 * Common operations include traversal (Preorder, Inorder, Postorder).
 */

// 1️⃣ Define a Node for Binary Tree
class TreeNode<T>(val value: T) {
    var left: TreeNode<T>? = null
    var right: TreeNode<T>? = null
}

// 2️⃣ Preorder Traversal (Root → Left → Right)
fun <T> preorder(node: TreeNode<T>?) {
    if (node == null) return
    print("${node.value} → ")
    preorder(node.left)
    preorder(node.right)
}

// 3️⃣ Inorder Traversal (Left → Root → Right)
fun <T> inorder(node: TreeNode<T>?) {
    if (node == null) return
    inorder(node.left)
    print("${node.value} → ")
    inorder(node.right)
}

// 4️⃣ Postorder Traversal (Left → Right → Root)
fun <T> postorder(node: TreeNode<T>?) {
    if (node == null) return
    postorder(node.left)
    postorder(node.right)
    print("${node.value} → ")
}

fun main() {
    println("\n✅ Binary Tree Demo")

    // 5️⃣ Create a sample binary tree
    //         A
    //        / \
    //       B   C
    //      /
    //     D

    val root = TreeNode("A")
    root.left = TreeNode("B")
    root.right = TreeNode("C")
    root.left?.left = TreeNode("D")

    // 6️⃣ Traversals
    println("\nPreorder Traversal:")
    preorder(root) // Output: A → B → D → C

    println("\n\nInorder Traversal:")
    inorder(root) // Output: D → B → A → C

    println("\n\nPostorder Traversal:")
    postorder(root) // Output: D → B → C → A
}

/*
 * 🔍 Real-World Use Cases:
 * - File system navigation (folders/files)
 * - Expression trees in compilers/calculators
 * - DOM representation in browsers
 * - AI decision-making trees
 *
 * 🔟 Summary:
 * ✅ A Binary Tree has up to 2 child nodes per parent
 * ✅ Traversal orders matter for different tasks (e.g., printing, evaluating)
 * ✅ Understanding trees is essential for advanced data structures (BST, Heap, AVL)
 */
