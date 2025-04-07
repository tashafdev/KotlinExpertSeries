package s7_interfaces_and_inheritance


/*
 * ------------------------------------------------------------
 * ✅ Lecture: Visibility Modifiers in Kotlin (with Inheritance)
 * ------------------------------------------------------------
 * Kotlin provides 4 visibility modifiers:
 *
 * 🔹 `public`     → Default. Visible everywhere.
 * 🔹 `internal`   → Visible within the same module.
 * 🔹 `protected`  → Visible to the class and its subclasses.
 * 🔹 `private`    → Visible only within the class or file.
 *
 * In inheritance, `protected` is especially important.
 */

// Step 1️⃣: Base class with all visibility types
open class BaseComponent {

    public val publicTitle = "Public Title"
    internal val internalName = "Internal Name"
    protected val protectedId = "Protected ID"
    private val privateSecret = "Private Secret"

    fun printAccessibleFields() {
        println("Inside BaseComponent:")
        println(publicTitle)
        println(internalName)
        println(protectedId)
        println(privateSecret)
    }
}

// Step 2️⃣: Subclass accessing inherited fields
class UIComponent : BaseComponent() {

    fun printInheritedFields() {
        println("Inside UIComponent:")
        println(publicTitle)       // ✅ public — accessible
        println(internalName)      // ✅ internal — same module
        println(protectedId)       // ✅ protected — allowed in subclass
        // println(privateSecret)  // ❌ private — NOT accessible
    }
}

// Step 3️⃣: Outside access
fun main() {
    val ui = UIComponent()

    println("🔓 Outside access:")
    println(ui.publicTitle)         // ✅
    println(ui.internalName)        // ✅ (same module)
    // println(ui.protectedId)     // ❌ Cannot access protected outside class
    // println(ui.privateSecret)   // ❌ Cannot access private

    println("\n📦 Inherited access:")
    ui.printInheritedFields()

    println("\n🔐 Base class internal access:")
    ui.printAccessibleFields()
}
