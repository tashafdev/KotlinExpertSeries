package s21_data_structures.trees


/*
 * -----------------------------------------------------
 * ✅ Lecture: Custom N-ary Tree Class (S21Dd_CustomTreeClass.kt)
 * -----------------------------------------------------
 *
 * 📌 A Generic (N-ary) Tree is a tree where each node can have
 *     zero or more children — not limited to 2 like Binary Trees.
 *
 * 🧠 Use When:
 * - You need flexible parent-child hierarchies
 * - Each node may have any number of subitems (folders, UI, etc.)
 *
 * 📈 Time Complexity (per operation):
 * - Insert / Search / Traverse → O(n)
 *   (depends on number of children and levels)
 */

class S21Dd_GenericTreeNode<T>(val data: T) {
    val children = mutableListOf<S21Dd_GenericTreeNode<T>>()
}

fun <T> printGenericTreeDFS(node: S21Dd_GenericTreeNode<T>, level: Int = 0) {
    println("${"  ".repeat(level)}📍 ${node.data}")
    node.children.forEach { printGenericTreeDFS(it, level + 1) }
}

fun main() {
    // 1️⃣ Build a custom tree structure
    val root = S21Dd_GenericTreeNode("CEO")

    val vp1 = S21Dd_GenericTreeNode("VP - Engineering")
    val vp2 = S21Dd_GenericTreeNode("VP - Marketing")

    val eng1 = S21Dd_GenericTreeNode("Engineer 1")
    val eng2 = S21Dd_GenericTreeNode("Engineer 2")
    val mkt1 = S21Dd_GenericTreeNode("Marketer 1")

    // 2️⃣ Create hierarchy
    vp1.children.add(eng1)
    vp1.children.add(eng2)
    vp2.children.add(mkt1)

    root.children.add(vp1)
    root.children.add(vp2)

    // 3️⃣ Traverse
    println("🏢 Company Org Chart Tree:")
    printGenericTreeDFS(root)
}


/*
 * -----------------------------------------------------
 * 📱 Generic Tree in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ Navigation Graph (Nested):
 *    - Subgraphs with nested destinations form a multi-level tree.

 * ✅ Expandable Menus / Lists:
 *    - Multi-level category menus (e.g., Shopping, Settings) use generic trees.

 * ✅ Folder/Note Structure:
 *    - File managers or note apps that allow nested folders.

 * ✅ UI Components:
 *    - Custom layout managers or view trees can model deeply nested items.

 * ✅ Chat Threads / Replies:
 *    - Comment threads (e.g., Reddit-style) with arbitrary nesting.

 * 🔹 Use this when:
 *    - You need a flexible, expandable tree where each node has 0–N children
 *    - Hierarchies go beyond the binary constraint
 */
