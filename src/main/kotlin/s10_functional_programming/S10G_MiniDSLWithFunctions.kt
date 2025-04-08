package s10_functional_programming



/*
 * -----------------------------------------------------
 * ✅ Lecture: Mini DSLs with Functions in Kotlin
 * -----------------------------------------------------
 * Kotlin’s support for **lambdas with receivers** lets you create
 * clean, expressive DSLs (Domain-Specific Languages).
 *
 * DSLs improve readability and allow you to write Kotlin like a custom language!
 */

/*
 * 📌 Section 1 — Basic builder-style DSL using lambdas
 */
class Pizza {
    val toppings = mutableListOf<String>()

    fun addTopping(topping: String) {
        toppings.add(topping)
    }

    override fun toString(): String {
        return "🍕 Pizza with: ${toppings.joinToString()}"
    }
}

fun section1_BuildPizzaDSL() {
    val pizza = Pizza().apply {
        addTopping("Cheese")
        addTopping("Tomato")
        addTopping("Olives")
    }

    println(pizza) // 🍕 Pizza with: Cheese, Tomato, Olives
}

/*
 * 📌 Section 2 — Custom DSL with lambda receiver
 */
fun buildPizza(block: Pizza.() -> Unit): Pizza {
    val pizza = Pizza()
    pizza.block()
    return pizza
}

fun section2_UseCustomPizzaDSL() {
    val myPizza = buildPizza {
        addTopping("Mushrooms")
        addTopping("Basil")
    }

    println("🍽️ Your order: $myPizza")
}

/*
 * 📌 Section 3 — Nesting DSLs using multiple receivers
 */
class Sauce {
    var type: String = "Tomato"

    override fun toString(): String = "🧂 Sauce: $type"
}

class PizzaWithSauce {
    val toppings = mutableListOf<String>()
    var sauce = Sauce()

    fun addTopping(t: String) = toppings.add(t)
    fun addSauce(block: Sauce.() -> Unit) {
        sauce.apply(block)
    }

    override fun toString(): String {
        return "🍕 Pizza with ${toppings.joinToString()} and $sauce"
    }
}

fun buildPizzaWithSauce(block: PizzaWithSauce.() -> Unit): PizzaWithSauce {
    val pizza = PizzaWithSauce()
    pizza.block()
    return pizza
}

fun section3_NestedDSLExample() {
    val fancyPizza = buildPizzaWithSauce {
        addTopping("Paneer")
        addTopping("Chilli flakes")
        addSauce {
            type = "Pesto"
        }
    }

    println("👨‍🍳 Chef's pick: $fancyPizza")
}

/*
 * 🧠 What You Will Learn:
 * - How Kotlin lets you build clean DSLs using lambdas with receivers
 * - How to encapsulate configuration logic
 * - Nesting DSLs like in Gradle or Jetpack Compose
 */

/*
 * 🚀 Quick Summary:
 * ✅ Lambdas with receivers → let you write cleaner builders
 * ✅ `apply`, `run`, or custom function with receiver = DSL magic
 * ✅ Compose nested DSLs for complex structures
 */

/*
 * 📘 Key Takeaways:
 * - DSLs make complex configs readable and safe
 * - Your own builder-style APIs become powerful tools
 * - Combine this with inline functions for performance and elegance

 * 💡 Real-World Use Cases:
 * - Gradle Kotlin DSL
 * - Jetpack Compose
 * - Custom View/UI builders
 * - Email builders, message templates, configs

 * 🧼 Clean Code Insight:
 * DSLs are code-as-configuration — keep naming clear, avoid over-nesting,
 * and document intent with readable receiver blocks.
 */
