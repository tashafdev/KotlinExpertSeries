package s21_data_structures


/*
 * -----------------------------------------------------
 * ✅ Lecture: Binary Search Tree (Insert & Search) (S21Bc_BinarySearchTree.kt)
 * -----------------------------------------------------
 * A Binary Search Tree (BST) is a binary tree with ordered structure:
 * - Left child < Root < Right child
 * - Fast insertion, search, and deletion (avg O(log n))
 */

// 1️⃣ Define the Node class
class BSTNode(val value: Int) {
    var left: BSTNode? = null
    var right: BSTNode? = null
}

// 2️⃣ Define the BST with insert and search operations
class BinarySearchTree {
    var root: BSTNode? = null

    // Insert a value into BST
    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    private fun insertRec(node: BSTNode?, value: Int): BSTNode {
        if (node == null) return BSTNode(value)
        if (value < node.value) node.left = insertRec(node.left, value)
        else if (value > node.value) node.right = insertRec(node.right, value)
        return node
    }

    // Search for a value
    fun search(value: Int): Boolean {
        return searchRec(root, value)
    }

    private fun searchRec(node: BSTNode?, value: Int): Boolean {
        if (node == null) return false
        if (node.value == value) return true
        return if (value < node.value) searchRec(node.left, value)
        else searchRec(node.right, value)
    }

    // Inorder traversal
    fun inorder(node: BSTNode? = root) {
        if (node == null) return
        inorder(node.left)
        print("${node.value} → ")
        inorder(node.right)
    }
}

fun main() {
    println("\n✅ Binary Search Tree: Insert & Search Demo")

    val bst = BinarySearchTree()
    listOf(50, 30, 70, 20, 40, 60, 80).forEach { bst.insert(it) }

    println("\n1️⃣ Inorder Traversal:")
    bst.inorder() // Output: 20 → 30 → 40 → 50 → 60 → 70 → 80

    println("\n\n2️⃣ Search Operations:")
    println("Search 60 → ${bst.search(60)}") // true
    println("Search 15 → ${bst.search(15)}") // false
}

/*
 * 🔍 Real-World Use Cases:
 * - Fast data lookup systems
 * - Auto-complete features
 * - Indexing in databases
 * - Maintaining sorted data
 *
 * 🔟 Summary:
 * ✅ BST is a structured binary tree where left < root < right
 * ✅ Insertion and search use recursion and binary comparisons
 * ✅ Inorder traversal gives sorted data
 * ✅ Ideal for fast searching and dynamic data updates
 */

