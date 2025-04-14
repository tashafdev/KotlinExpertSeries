/**
 * -----------------------------------------------------
 * ✅ Lecture: Builder Pattern (Creational)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * Builder Pattern separates the construction of a complex object
 * from its representation, allowing you to build it step-by-step.
 *
 * 📦 Use Case:
 * - Creating complex objects with many optional fields
 * - Constructing objects in multiple steps with different configurations
 *
 * 🧠 Why use it?
 * - Improves code readability and maintainability
 * - Supports immutability
 * - Prevents constructor overloading
 *
 * -----------------------------------------------------
 * 🧪 Example: Building a Pizza Order
 * -----------------------------------------------------
 */

class Pizza private constructor(
    val size: String,
    val cheese: Boolean,
    val pepperoni: Boolean,
    val mushrooms: Boolean
) {
    class Builder {
        private var size: String = "Medium"
        private var cheese: Boolean = false
        private var pepperoni: Boolean = false
        private var mushrooms: Boolean = false

        fun size(size: String) = apply { this.size = size }
        fun cheese(value: Boolean) = apply { this.cheese = value }
        fun pepperoni(value: Boolean) = apply { this.pepperoni = value }
        fun mushrooms(value: Boolean) = apply { this.mushrooms = value }

        fun build(): Pizza {
            return Pizza(size, cheese, pepperoni, mushrooms)
        }
    }

    fun describe() {
        println("🍕 Pizza [$size] - Cheese: $cheese, Pepperoni: $pepperoni, Mushrooms: $mushrooms")
    }
}

fun main() {
    val pizza = Pizza.Builder()
        .size("Large")
        .cheese(true)
        .pepperoni(true)
        .build()

    pizza.describe()
}


/*
 * -----------------------------------------------------
 * 📱 Real-World Usage in Android – Builder Pattern
 * -----------------------------------------------------
 *
 * 🔹 AlertDialog.Builder:
 *    - Classic example of Builder Pattern.
 *    - You configure title, message, buttons, and behavior step-by-step.
 *    - Finally call `create()` or `show()` to build the dialog.
 *
 * 🔹 NotificationCompat.Builder:
 *    - Used to build notifications with many optional settings.
 *    - Step-by-step configuration like title, content, icon, action buttons, etc.
 *
 * 🔹 Retrofit.Builder:
 *    - Configure base URL, converter factory, client, etc.
 *    - Then build the final Retrofit object.
 *
 * 🔹 WorkRequest.Builder (from WorkManager):
 *    - Used to configure constraints, delays, input data, and then build the work request.
 *
 * 🔹 ConstraintLayout.Builder (Jetpack Compose):
 *    - Compose encourages a declarative builder-like DSL to build UIs.
 *
 * ✅ Use Builder Pattern when:
 *    - You want to **construct complex objects** with many optional or nested parameters.
 *    - You want to **chain method calls** for better readability and flexibility.
 */
