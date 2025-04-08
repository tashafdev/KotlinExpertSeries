package s19_clean_code_and_principles.s19a_solid_principles


/*
 * -----------------------------------------------------
 * ✅ SOLID Principle: Open/Closed Principle (OCP)
 * -----------------------------------------------------
 * Software components (classes, modules, functions) should be:
 *
 * 🔹 **Open for extension**
 * 🔹 **Closed for modification**
 *
 * This allows new behavior to be added without changing existing, stable code.
 */

/*
 * 📌 Section 1 — ❌ Violation: Changing logic instead of extending it
 */
class S19Ab_DiscountCalculatorBad {
    fun calculateDiscount(type: String, price: Double): Double {
        return when (type) {
            "STUDENT" -> price * 0.9
            "SENIOR" -> price * 0.8
            else -> price
        }
    }
}

fun section1_UsingBadDiscountCalc() {
    val calc = S19Ab_DiscountCalculatorBad()
    println("🎓 Student: ${calc.calculateDiscount("STUDENT", 100.0)}")
    println("👴 Senior: ${calc.calculateDiscount("SENIOR", 100.0)}")
}

/*
 * Problem:
 * Every time we add a new discount type (e.g. "MILITARY"), we must modify the class!
 * That breaks OCP ❌
 */

/*
 * 📌 Section 2 — ✅ OCP-Compliant Refactor using polymorphism
 */
interface DiscountStrategy {
    fun apply(price: Double): Double
}

class StudentDiscount : DiscountStrategy {
    override fun apply(price: Double) = price * 0.9
}

class SeniorDiscount : DiscountStrategy {
    override fun apply(price: Double) = price * 0.8
}

class NoDiscount : DiscountStrategy {
    override fun apply(price: Double) = price
}

class S19Ab_DiscountCalculatorGood {
    fun calculate(price: Double, strategy: DiscountStrategy): Double {
        return strategy.apply(price)
    }
}

fun section2_UsingGoodDiscountCalc() {
    val calc = S19Ab_DiscountCalculatorGood()

    println("🎓 Student: ${calc.calculate(100.0, StudentDiscount())}")
    println("👴 Senior: ${calc.calculate(100.0, SeniorDiscount())}")
    println("🧍 Regular: ${calc.calculate(100.0, NoDiscount())}")
}

/*
 * 🧠 What You Will Learn:
 * - How to avoid modifying logic when adding new types
 * - How to use polymorphism for extension
 * - Why OCP increases system flexibility and maintainability
 */

/*
 * 🚀 Quick Summary:
 * ✅ OCP = Open to add new behavior, Closed to touch existing logic
 * ✅ Use interfaces + composition instead of `when` or `if` trees
 * ✅ Stable base, flexible extensions
 */

/*
 * 📘 Key Takeaways:
 * - Don’t keep editing existing classes to add new behavior
 * - In Kotlin, favor sealed classes, interfaces, and polymorphism
 * - Strategy pattern is a common OCP solution

 * 💡 Real-World Use Cases:
 * - Pricing strategies
 * - Payment gateways (extending without touching base logic)
 * - ViewModel behaviors injected via interfaces

 * 🧼 Clean Code Insight:
 * If you're editing the same class every time the feature list grows,
 * you're **violating OCP**. Let new things plug in — don’t patch the old.
 */
