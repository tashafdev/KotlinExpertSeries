
/**
 * -----------------------------------------------------
 * ✅ Lecture: Composite Pattern (Structural)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * Composite Pattern lets you treat individual objects and compositions
 * of objects uniformly. It enables tree-like structures where a "part" and "whole"
 * follow the same interface.
 *
 * 📦 Use Case:
 * - UI hierarchies
 * - File systems
 * - Menu or tree structures
 *
 * 🧠 Why use it?
 * - Simplifies tree structure management
 * - Supports recursive operations (e.g., rendering, events)
 * - Treats all components the same (composite or leaf)
 *
 * -----------------------------------------------------
 * 🧪 Example: S20Se UI Components Tree
 * -----------------------------------------------------
 */

interface S20Se_UIComponent {
    fun render()
}

class S20Se_Button(private val label: String) : S20Se_UIComponent {
    override fun render() {
        println("🖲️ Render Button: $label")
    }
}

class S20Se_Text(private val content: String) : S20Se_UIComponent {
    override fun render() {
        println("📝 Render Text: $content")
    }
}

class S20Se_ViewGroup(private val name: String) : S20Se_UIComponent {
    private val children = mutableListOf<S20Se_UIComponent>()

    fun add(child: S20Se_UIComponent) {
        children.add(child)
    }

    override fun render() {
        println("📦 Render Container: $name")
        children.forEach { it.render() }
    }
}

fun main() {
    val button = S20Se_Button("Submit")
    val text = S20Se_Text("Welcome to the app")

    val rootLayout = S20Se_ViewGroup("RootLayout")
    val rowLayout = S20Se_ViewGroup("RowLayout")

    rowLayout.add(text)
    rowLayout.add(button)

    rootLayout.add(rowLayout)
    rootLayout.render()
}


/*
 * -----------------------------------------------------
 * 📱 Composite Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ ViewGroup + View hierarchy:
 *    - `ViewGroup` contains `View` or other `ViewGroup`s.
 *    - `addView()`, `removeView()`, and `draw()` treat leaf and composite views uniformly.

 * ✅ Menus:
 *    - Android menu system supports nested menus via MenuGroup/MenuItem.

 * ✅ Jetpack Compose:
 *    - Compose UI trees are built recursively — Composables return nested content via tree structure.

 * ✅ File Manager Apps:
 *    - Represent folders and files using the same `FileNode` abstraction — composite for folders, leaf for files.

 * ✅ RecyclerView with expandable items:
 *    - Composite data structure for parent-child hierarchy (e.g., categories with items).

 * 🔹 Use this pattern when:
 *    - You need to handle **hierarchical or nested structures**.
 *    - You want to treat **individual and grouped items the same way**.
 */
