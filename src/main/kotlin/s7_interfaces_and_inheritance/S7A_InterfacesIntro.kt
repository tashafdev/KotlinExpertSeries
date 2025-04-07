package s7_interfaces_and_inheritance


/*
 * -----------------------------------------------
 * ✅ Lecture: Introduction to Interfaces in Kotlin
 * -----------------------------------------------
 * An interface defines a *contract* that classes can implement.
 * It can contain:
 * 🔹 Abstract methods (no body)
 * 🔹 Default implementations (with body)
 * 🔹 Properties (abstract or with getter)
 *
 * Kotlin interfaces support multiple inheritance and provide default method resolution using `super<InterfaceName>`.
 */

// Step 1️⃣: Basic interface with abstract + default method
interface Clickable {
    fun click()                              // Abstract method
    fun showOff() = println("I'm clickable") // Default method
}

// Step 2️⃣: Class implementing interface
class Button : Clickable {
    override fun click() = println("Button clicked")
    // showOff() will be inherited from Clickable
}

// Step 3️⃣: Interface with property
interface Identifiable {
    val id: String                           // Abstract property
    val type: String                         // Property with getter
        get() = "Generic"
}

// Step 4️⃣: Implementing interface with property
class User(override val id: String) : Identifiable {
    // 'type' is inherited with default getter
}

// Step 5️⃣: Multiple interfaces with conflicting method
interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus")
    fun showOff() = println("I'm focusable")
}

// Step 6️⃣: Implementing multiple interfaces
class FancyButton : Clickable, Focusable {
    override fun click() = println("Fancy button clicked")

    // showOff() conflict – must resolve
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

// Step 7️⃣: Real-world style interface
interface Draggable {
    fun onDragStart()
    fun onDragEnd()
}

class PhotoItem : Draggable {
    override fun onDragStart() = println("Dragging photo started")
    override fun onDragEnd() = println("Dragging photo ended")
}

// Step 8️⃣: Testing all in main()
fun main() {
    val btn = Button()
    btn.click()
    btn.showOff()

    println("-----------")

    val fancy = FancyButton()
    fancy.click()
    fancy.setFocus(true)
    fancy.showOff()

    println("-----------")

    val user = User("U123")
    println("User ID: ${user.id}")
    println("User Type: ${user.type}")

    println("-----------")

    val photo = PhotoItem()
    photo.onDragStart()
    photo.onDragEnd()
}
