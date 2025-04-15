package s21_data_structures.advanced

/*
 * -----------------------------------------------------
 * ✅ Lecture: Custom Tree Class (S21Dd_CustomTreeClass.kt)
 * -----------------------------------------------------
 * A Tree is a hierarchical data structure consisting of nodes.
 * Each node can have zero or more children.
 * This lecture shows how to implement a simple generic Tree in Kotlin.
 */

// 1️⃣ Define Tree Node
// Generic node holding a value and list of children
class TreeNode<T>(val value: T) {
    val children: MutableList<TreeNode<T>> = mutableListOf()
}

// 2️⃣ Define CustomTree Class
class CustomTree<T>(rootValue: T) {
    private val root = TreeNode(rootValue)

    /**
     * Add a child node under the node with parentValue.
     * Returns true if parent found and child added, false otherwise.
     */
    fun addChild(parentValue: T, childValue: T): Boolean {
        val parent = findNode(root, parentValue)
        return if (parent != null) {
            parent.children.add(TreeNode(childValue))
            true
        } else {
            false
        }
    }

    // 3️⃣ Find a node by value (DFS)
    private fun findNode(node: TreeNode<T>, value: T): TreeNode<T>? {
        if (node.value == value) return node
        for (child in node.children) {
            findNode(child, value)?.let { return it }
        }
        return null
    }

    // 4️⃣ Pre-order traversal
    fun traversePreOrder(action: (T) -> Unit) {
        traversePreOrderNode(root, action)
    }

    private fun traversePreOrderNode(node: TreeNode<T>, action: (T) -> Unit) {
        action(node.value)
        node.children.forEach { traversePreOrderNode(it, action) }
    }
}

fun main() {
    println("\n✅ Custom Tree Demo")
    val tree = CustomTree("Root")
    tree.addChild("Root", "Child1")
    tree.addChild("Root", "Child2")
    tree.addChild("Child1", "Grandchild1")
    println("Pre-order traversal:")
    tree.traversePreOrder { println(it) }
}

/*
 * 🔍 Android Use Cases:
 * - View Hierarchy Manipulation:
 *    Traverse or modify ViewGroup trees at runtime for dynamic UIs.
 * - Navigation Graph Representation:
 *    Model screen flows or deep links as a tree and traverse for navigation.
 * - Menu Structures:
 *    Manage nested menus (e.g., NavigationView) with tree traversal.
 * - Accessibility Node Trees:
 *    Inspect or modify AccessibilityNodeInfo trees for custom accessibility features.
 * - File System Browser:
 *    Display and traverse folder structures in file picker UIs.
 *
 * 🔟 Summary:
 * ✅ Tree = nodes with zero or more children
 * ✅ Implemented with TreeNode and DFS traversal
 * ✅ Ideal for hierarchical data in Android
 */
