/**
 * -----------------------------------------------------
 * ✅ Lecture: Strategy Pattern (Behavioral)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * Strategy Pattern defines a family of algorithms, encapsulates each one,
 * and makes them interchangeable at runtime.
 *
 * 📦 Use Case:
 * - When you have multiple ways to execute a task (sorting, payment, filtering)
 * - You want to avoid long `if-else` or `when` chains
 *
 * 🧠 Why use it?
 * - Promotes Open/Closed Principle
 * - Makes algorithms swappable without modifying the client
 * - Clean, maintainable code
 *
 * -----------------------------------------------------
 * 🧪 Example: Payment Strategy
 * -----------------------------------------------------
 */

interface PaymentStrategy {
    fun pay(amount: Int)
}

class CreditCardPayment : PaymentStrategy {
    override fun pay(amount: Int) {
        println("💳 Paid $amount using Credit Card")
    }
}

class PayPalPayment : PaymentStrategy {
    override fun pay(amount: Int) {
        println("📧 Paid $amount using PayPal")
    }
}

class PaymentProcessor(private var strategy: PaymentStrategy) {
    fun setStrategy(newStrategy: PaymentStrategy) {
        strategy = newStrategy
    }

    fun process(amount: Int) {
        strategy.pay(amount)
    }
}

fun main() {
    val processor = PaymentProcessor(CreditCardPayment())
    processor.process(150)

    processor.setStrategy(PayPalPayment())
    processor.process(75)
}

/*
 * -----------------------------------------------------
 * 📱 Strategy Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ Image Loading Libraries (Glide, Coil, Picasso):
 *    - Different strategies for disk cache, memory cache, decode format.
 *    - Developers can switch strategies using config methods or custom components.

 * ✅ RecyclerView Click Strategies:
 *    - Use custom strategy interfaces to change item click behavior (e.g., single-select vs multi-select).

 * ✅ Navigation Handling:
 *    - You can define strategies for fragment navigation (SafeArgs, manual, deep links) and swap them based on context.

 * ✅ Logging Frameworks:
 *    - Strategy to plug in different logging mechanisms: Logcat, Timber, Crashlytics, etc.

 * ✅ Input Validation:
 *    - You can apply different strategies for validating input fields: length check, regex, required fields, etc.

 * 🔹 Use this pattern when:
 *    - You want to provide multiple interchangeable behaviors.
 *    - You want to isolate and encapsulate each behavior in a separate class or object.
 */

