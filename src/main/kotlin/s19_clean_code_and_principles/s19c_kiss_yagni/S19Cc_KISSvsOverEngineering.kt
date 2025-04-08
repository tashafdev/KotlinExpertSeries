package s19_clean_code_and_principles.s19c_kiss_yagni


/*
 * -----------------------------------------------------
 * 🤜 KISS vs 🤛 Over-Engineering
 * -----------------------------------------------------
 * There’s a fine line between being **future-ready** and **overcomplicating**.
 *
 * KISS: Keep It Simple, Stupid
 * Overengineering: Trying to solve problems that don’t exist yet.
 */

/*
 * 📌 Section 1 — ❌ Over-abstracted solution for a single task
 */
interface PaymentStrategy {
    fun pay(amount: Double)
}

class PaypalPayment : PaymentStrategy {
    override fun pay(amount: Double) = println("💸 Paid $$amount via PayPal")
}

class StripePayment : PaymentStrategy {
    override fun pay(amount: Double) = println("💳 Paid $$amount via Stripe")
}

class PaymentProcessor(private val strategy: PaymentStrategy) {
    fun process(amount: Double) = strategy.pay(amount)
}

fun section1_OverEngineeredStrategyPattern() {
    val payment = PaymentProcessor(PaypalPayment())
    payment.process(99.0)
    // ❌ Too much abstraction if there's only one payment method
}

/*
 * ✅ KISS Alternative: Start simple. Add abstraction only when needed.
 */
fun section1_KissVersion() {
    fun pay(amount: Double) {
        println("💰 Paid $$amount via default processor")
    }

    pay(99.0)
}

/*
 * 📌 Section 2 — ❌ Building sealed hierarchies too early
 */
sealed class ApiResponse {
    data class Success(val data: String) : ApiResponse()
    data class Error(val message: String) : ApiResponse()
    data class Loading(val progress: Int) : ApiResponse()
    data class Timeout(val seconds: Int) : ApiResponse()
    object Idle : ApiResponse()
    // ❌ Premature explosion of states
}

fun section2_OverModeledStateExample() {
    val response: ApiResponse = ApiResponse.Success("Data!")
    println("📦 Got: $response")
}

/*
 * ✅ KISS: Only model what’s needed right now
 */
sealed class BasicApiResponse {
    data class Success(val data: String) : BasicApiResponse()
    data class Error(val message: String) : BasicApiResponse()
}

fun section2_KeepStatesSimple() {
    val result = BasicApiResponse.Success("Data loaded")
    println("📦 Basic: $result")
}

/*
 * 🧠 What You Will Learn:
 * - When abstraction is needed vs when it’s overkill
 * - Why KISS helps you grow code in the right direction
 * - How to spot overengineering in real-world projects
 */

/*
 * 🚀 Quick Summary:
 * ✅ KISS → simple, focused, no bloat
 * ❌ Overengineering → complexity, unused layers
 * ✅ Start small, refactor when needed
 */

/*
 * 📘 Key Takeaways:
 * - Abstractions should evolve out of duplication, not imagination
 * - Premature design = long-term regret
 * - Stay lean until growth demands structure

 * 💡 Real-World Use Cases:
 * - One screen = don’t build a full state machine
 * - One API = don’t add Retrofit + wrappers + transformers
 * - Don’t build a plugin system for something used once

 * 🧼 Clean Code Insight:
 * Solve real problems. Not potential ones.
 * **Simple is scalable. Overengineered dies early.**
 */
