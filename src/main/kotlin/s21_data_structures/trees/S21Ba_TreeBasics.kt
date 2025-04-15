package s21_data_structures.trees

/*
 * -----------------------------------------------------
 * ✅ Lecture: Binary Tree Basics (S21Ba_TreeBasics.kt)
 * -----------------------------------------------------
 *
 * 📌 A Binary Tree is a non-linear hierarchical data structure where each node
 *     can have at most two children — called `left` and `right`.
 *
 * 🧠 Useful for:
 * - Fast searching and sorted data (Binary Search Tree)
 * - Parsing expressions (Expression Tree)
 * - Representing hierarchies (UI, DOM, Filesystem)
 *
 * 🔍 Traversal Techniques:
 * - Preorder:    Root → Left → Right
 * - Inorder:     Left → Root → Right
 * - Postorder:   Left → Right → Root
 *
 * ✅ Time Complexities:
 * - Access/Search/Insert/Delete:
 *     - Best: O(log n)
 *     - Worst: O(n) (unbalanced)
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
    preorder(root) // A → B → D → C

    println("\n\nInorder Traversal:")
    inorder(root) // D → B → A → C

    println("\n\nPostorder Traversal:")
    postorder(root) // D → B → C → A
}


/*
 * -----------------------------------------------------
 * 📱 Binary Trees in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ View Hierarchy Tree:
 *    - Every ViewGroup (like ConstraintLayout) forms a tree of child views.

 * ✅ Navigation Graph:
 *    - Navigation destinations and subgraphs model a tree.

 * ✅ Expression Evaluators:
 *    - Calculator apps parse and evaluate input using expression trees.

 * ✅ File Managers / Browsers:
 *    - File directories and DOM trees are naturally represented as binary or N-ary trees.

 * ✅ AI in Games:
 *    - Game logic trees (like minimax) are based on binary trees for decision making.

 * 🔹 Use Binary Trees when:
 *    - You need hierarchical modeling
 *    - You want structured traversal or sorted access
 */
