package s19_clean_code_and_principles.s19a_solid_principles


/**
 * S19Ag_SOLIDPracticeExample.kt
 * Real-world Kotlin: E-Commerce Order Processing System
 * Demonstrates SRP, OCP, LSP, ISP, and DIP.
 */

fun runS19Ag_SOLIDPracticeExample() {
    println("🛒 Processing order in SOLID way...\n")

    val cart = S19Ag_Cart(listOf("Laptop", "Mouse"))
    val orderService = S19Ag_OrderService(S19Ag_ConsoleNotifier(), S19Ag_FileSaver())
    orderService.process(cart)
}

// 🔹 SRP: Each class has one responsibility
data class S19Ag_Cart(val items: List<String>)

interface S19Ag_Notifier {
    fun notifyUser(cart: S19Ag_Cart)
}

class S19Ag_ConsoleNotifier : S19Ag_Notifier {
    override fun notifyUser(cart: S19Ag_Cart) {
        println("📢 Notifying user: Order with ${cart.items.size} items placed.")
    }
}

interface S19Ag_DataSaver {
    fun saveOrder(cart: S19Ag_Cart)
}

class S19Ag_FileSaver : S19Ag_DataSaver {
    override fun saveOrder(cart: S19Ag_Cart) {
        println("💾 Order saved to file with items: ${cart.items.joinToString()}")
    }
}

// 🔹 OCP: Behavior can be extended by injecting different implementations
class S19Ag_OrderService(
    private val notifier: S19Ag_Notifier,
    private val saver: S19Ag_DataSaver
) {
    fun process(cart: S19Ag_Cart) {
        notifier.notifyUser(cart)
        saver.saveOrder(cart)
    }
}

// 🔹 LSP: Subtypes must be replaceable
open class S19Ag_Shipping {
    open fun getETA(): String = "3-5 business days"
}

class S19Ag_ExpressShipping : S19Ag_Shipping() {
    override fun getETA(): String = "1-2 business days"
}

// 🔹 ISP: Small, focused interfaces
interface S19Ag_Trackable {
    fun track()
}

interface S19Ag_Cancellable {
    fun cancel()
}

class S19Ag_OnlineOrder : S19Ag_Trackable, S19Ag_Cancellable {
    override fun track() = println("📍 Order is on the way.")
    override fun cancel() = println("❌ Order has been cancelled.")
}

// 🔹 DIP: High-level depends on abstraction
// (Already shown via Notifier and DataSaver being interfaces)
