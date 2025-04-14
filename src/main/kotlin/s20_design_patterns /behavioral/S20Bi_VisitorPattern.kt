/**
 * -----------------------------------------------------
 * ✅ Lecture: Visitor Pattern (Behavioral)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * Visitor Pattern allows adding new operations to existing object structures
 * without modifying the classes of the elements on which it operates.
 *
 * 📦 Use Case:
 * - Performing operations across object hierarchies (e.g., ASTs, UI trees)
 * - Externalizing behaviors without touching internal models
 *
 * 🧠 Why use it?
 * - Adds extensibility to complex structures
 * - Separates operation logic from object data structure
 *
 * -----------------------------------------------------
 * 🧪 Example: UI Component Visitor
 * -----------------------------------------------------
 */

interface UIComponent {
    fun accept(visitor: UIVisitor)
}

class ButtonComponent(val text: String) : UIComponent {
    override fun accept(visitor: UIVisitor) = visitor.visitButton(this)
}

class TextViewComponent(val content: String) : UIComponent {
    override fun accept(visitor: UIVisitor) = visitor.visitTextView(this)
}

interface UIVisitor {
    fun visitButton(button: ButtonComponent)
    fun visitTextView(textView: TextViewComponent)
}

class RenderVisitor : UIVisitor {
    override fun visitButton(button: ButtonComponent) {
        println("🖲️ Rendering button: ${button.text}")
    }

    override fun visitTextView(textView: TextViewComponent) {
        println("📝 Rendering text view: ${textView.content}")
    }
}

fun main() {
    val components: List<UIComponent> = listOf(
        ButtonComponent("Submit"),
        TextViewComponent("Welcome"),
        ButtonComponent("Cancel")
    )

    val renderer = RenderVisitor()

    components.forEach { it.accept(renderer) }
}


/*
 * -----------------------------------------------------
 * 📱 Visitor Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ Sealed Class Hierarchies (UI State, ViewType, etc.):
 *    - Use sealed classes with `when` branches or visitor interfaces to handle multiple types without modifying original structure.

 * ✅ RecyclerView with Multiple View Types:
 *    - You can use the visitor pattern to separate binding logic based on item type (e.g., header, item, ad).

 * ✅ XML Layout Parsers:
 *    - Tools that walk through layouts and apply transformation/validation logic use a visitor-like approach.

 * ✅ Analytics/Event Logging:
 *    - Visitor can be used to collect metrics from various UI components by “visiting” each screen or view model.

 * ✅ Testing UI Components:
 *    - Test frameworks sometimes use the visitor pattern internally to walk the view hierarchy and validate behavior.

 * 🔹 Use this pattern when:
 *    - You want to apply **new operations to complex object structures** without changing their internal classes.
 *    - You want to **separate concerns** (e.g., render, export, track).
 */
