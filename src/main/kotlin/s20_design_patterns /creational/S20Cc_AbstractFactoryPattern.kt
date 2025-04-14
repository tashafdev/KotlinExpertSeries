/**
 * -----------------------------------------------------
 * ✅ Lecture: Abstract Factory Pattern (Creational)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * Abstract Factory Pattern provides an interface to create **families of related objects**
 * without specifying their concrete classes.
 *
 * 📦 Use Case:
 * - UI toolkit with multiple themes (e.g., LightThemeFactory, DarkThemeFactory)
 * - Cross-platform UIs (WindowsFactory, MacOSFactory)
 *
 * 🧠 Why use it?
 * - Groups related objects
 * - Enforces consistency in object families
 * - Enhances flexibility and scalability
 *
 * -----------------------------------------------------
 * 🧪 Example: UI Components - Light vs Dark Theme
 * -----------------------------------------------------
 */

// 🔹 Product Interfaces
interface Button {
    fun render()
}

interface Checkbox {
    fun toggle()
}

// 🔹 Concrete Products (Light Theme)
class LightButton : Button {
    override fun render() = println("🔘 Rendering Light Button")
}

class LightCheckbox : Checkbox {
    override fun toggle() = println("☑️ Toggling Light Checkbox")
}

// 🔹 Concrete Products (Dark Theme)
class DarkButton : Button {
    override fun render() = println("🌑 Rendering Dark Button")
}

class DarkCheckbox : Checkbox {
    override fun toggle() = println("🌙 Toggling Dark Checkbox")
}

// 🔹 Abstract Factory
interface UIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}

// 🔹 Concrete Factories
class LightUIFactory : UIFactory {
    override fun createButton() = LightButton()
    override fun createCheckbox() = LightCheckbox()
}

class DarkUIFactory : UIFactory {
    override fun createButton() = DarkButton()
    override fun createCheckbox() = DarkCheckbox()
}

// 🔹 Client Code
fun renderUI(factory: UIFactory) {
    val button = factory.createButton()
    val checkbox = factory.createCheckbox()
    button.render()
    checkbox.toggle()
}

fun main() {
    println("🌞 Light Theme UI:")
    renderUI(LightUIFactory())

    println("\n🌚 Dark Theme UI:")
    renderUI(DarkUIFactory())
}

/*
 * -----------------------------------------------------
 * 📱 Real-World Usage in Android – Abstract Factory Pattern
 * -----------------------------------------------------
 *
 * 🔹 UI Theming:
 *    - You can design an AbstractFactory to produce theme-specific UI components.
 *    - Example: `MaterialTheme.colorScheme` or `AppCompatDelegate.setDefaultNightMode(...)`
 *    - Based on user setting (light/dark/system), you return a family of themed views.
 *
 * 🔹 Jetpack Compose Design Systems:
 *    - When building your own design system, you may provide factories that generate:
 *      - Buttons, Cards, Typography, etc. for Light/Dark/Custom themes.
 *
 * 🔹 Custom View Renderers in Modular Apps:
 *    - Different modules may use factories to create consistent UI elements across features (e.g., PaymentButtonFactory).
 *
 * 🔹 Platform-Specific Abstractions:
 *    - Think multiplatform apps: Android vs. iOS vs. Desktop.
 *    - Abstract factory can help return platform-specific implementations.
 *
 * ✅ Use Abstract Factory when:
 *    - You need to create **families of related objects** (e.g., UI components) without binding to concrete classes.
 *    - You want to **enforce consistency** across themes or platforms.
 */
