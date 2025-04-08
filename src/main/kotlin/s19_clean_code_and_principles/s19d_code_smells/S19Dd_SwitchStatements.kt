package s19_clean_code_and_principles.s19d_code_smells



/*
 * -----------------------------------------------------
 * ❌ Code Smell: Switch / When Overuse
 * -----------------------------------------------------
 * Overusing `when`/`switch` on types leads to:
 * - Repeated logic
 * - Tight coupling
 * - Poor extensibility
 *
 * Instead, prefer polymorphism: let **behavior live with data**.
 */

/*
 * 📌 Section 1 — ❌ BAD: Repeated `when` logic on string type
 */
fun section1_ProcessPaymentBad(type: String) {
    when (type) {
        "CARD" -> println("💳 Processing card payment")
        "CASH" -> println("💵 Processing cash payment")
        "UPI" -> println("📲 Processing UPI payment")
        else -> println("❌ Unknown type")
    }
}

fun section1_GenerateReceiptBad(type: String) {
    when (type) {
        "CARD" -> println("🧾 Card receipt printed")
        "CASH" -> println("🧾 Cash receipt printed")
        "UPI" -> println("🧾 UPI receipt printed")
        else -> println("❌ Unknown receipt type")
    }
}

/*
 * Problem:
 * Every time a new type is added (e.g. "CRYPTO"),
 * we have to modify every `when(type)` block. ❌
 */

/*
 * 📌 Section 2 — ✅ GOOD: Use sealed class to encapsulate behavior
 */
sealed class PaymentType {
    abstract fun process()
    abstract fun printReceipt()

    object Card : PaymentType() {
        override fun process() = println("💳 Processing card payment")
        override fun printReceipt() = println("🧾 Card receipt printed")
    }

    object Cash : PaymentType() {
        override fun process() = println("💵 Processing cash payment")
        override fun printReceipt() = println("🧾 Cash receipt printed")
    }

    object UPI : PaymentType() {
        override fun process() = println("📲 Processing UPI payment")
        override fun printReceipt() = println("🧾 UPI receipt printed")
    }
}

/*
 * 📌 Section 3 — Caller just uses the interface
 */
fun section3_PolymorphicExample() {
    val payments: List<PaymentType> = listOf(
        PaymentType.Card,
        PaymentType.Cash,
        PaymentType.UPI
    )

    for (payment in payments) {
        payment.process()
        payment.printReceipt()
    }
}

/*
 * 🧠 What You Will Learn:
 * - Why repeating `when` logic across the app is a red flag
 * - How polymorphism solves the problem once and for all
 * - Using sealed classes for clean Kotlin-style code
 */

/*
 * 🚀 Quick Summary:
 * ❌ Bad: `when(type)` everywhere = duplication and bugs
 * ✅ Good: `sealed class + abstract functions` = reusable and safe
 */

/*
 * 📘 Key Takeaways:
 * - If behavior is tied to type, encapsulate it!
 * - Don’t switch on type if Kotlin’s type system can handle it
 * - Let logic live with the data it acts on

 * 💡 Real-World Use Cases:
 * - Payment types
 * - View types (RecyclerView)
 * - UI state (Loading, Success, Error)

 * 🧼 Clean Code Insight:
 * The more `when(type)` you write, the more **polymorphism** is screaming to help.
 */
