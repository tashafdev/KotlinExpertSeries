package s19_clean_code_and_principles.s19a_solid_principles


/*
 * -----------------------------------------------------
 * ✅ SOLID Principle: Liskov Substitution Principle (LSP)
 * -----------------------------------------------------
 * LSP = Subtypes must be **substitutable** for their base types.
 *
 * If a subclass breaks the expectations of the superclass,
 * it **violates** LSP and may cause bugs when polymorphism is used.
 */

/*
 * 📌 Section 1 — ❌ Violation: Subclass breaks expected behavior
 */
open class Bird {
    open fun fly() {
        println("🕊️ Bird is flying")
    }
}

class Ostrich : Bird() {
    override fun fly() {
        throw UnsupportedOperationException("❌ Ostrich can't fly")
    }
}

fun section1_LSPViolation() {
    val bird: Bird = Ostrich() // Compiles, but fails at runtime
    try {
        bird.fly() // ❌ Runtime error – LSP broken
    } catch (e: Exception) {
        println("💥 Error: ${e.message}")
    }
}

/*
 * 📌 Section 2 — ✅ LSP-Compliant Design using proper abstraction
 */
interface Flyable {
    fun fly()
}

open class FlyingBird : Flyable {
    override fun fly() {
        println("🕊️ FlyingBird flies")
    }
}

class Eagle : FlyingBird()

class ProperOstrich {
    fun walk() {
        println("🚶 Ostrich walks")
    }
}

fun section2_LSPCompliantDesign() {
    val eagle: Flyable = Eagle()
    eagle.fly() // ✅ Safe and expected

    val ostrich = ProperOstrich()
    ostrich.walk() // ✅ Doesn't pretend to fly
}

/*
 * 🧠 What You Will Learn:
 * - What breaks the Liskov Substitution Principle
 * - Why throwing exceptions in overridden methods is dangerous
 * - How to design better abstractions that reflect real behavior
 */

/*
 * 🚀 Quick Summary:
 * ✅ LSP = Subclass should behave like its superclass
 * ✅ Avoid violating expectations in overridden methods
 * ✅ Use interfaces to separate behavior cleanly
 */

/*
 * 📘 Key Takeaways:
 * - Don't override and break contracts (e.g. throw instead of act)
 * - Favor composition/interfaces over forced inheritance
 * - Be honest in your hierarchy — if it’s not truly substitutable, don’t extend it

 * 💡 Real-World Use Cases:
 * - UI components that override base lifecycle methods
 * - Base ViewModels that get wrongly extended
 * - Business logic polymorphism (e.g. PaymentMethod, AuthMethod)

 * 🧼 Clean Code Insight:
 * If your subclass can't safely replace the base class in ALL contexts,
 * you're better off using composition or a different interface.
 */
