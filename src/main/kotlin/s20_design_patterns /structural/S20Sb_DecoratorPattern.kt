/**
 * -----------------------------------------------------
 * ✅ Lecture: Decorator Pattern (Structural)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * The Decorator Pattern allows behavior to be added to an individual object,
 * dynamically, without affecting the behavior of other objects from the same class.
 *
 * 📦 Use Case:
 * - Dynamically adding responsibilities
 * - Wrapping base functionality
 *
 * 🧠 Why use it?
 * - Promotes Open/Closed Principle
 * - Avoids deep inheritance hierarchies
 * - Enhances flexibility in extending behavior
 *
 * -----------------------------------------------------
 * 🧪 Example: Coffee with Add-ons
 * -----------------------------------------------------
 */

interface Coffee {
    fun cost(): Int
    fun description(): String
}

class BasicCoffee : Coffee {
    override fun cost() = 5
    override fun description() = "Plain Coffee"
}

abstract class CoffeeDecorator(private val base: Coffee) : Coffee {
    override fun cost() = base.cost()
    override fun description() = base.description()
}

class MilkDecorator(base: Coffee) : CoffeeDecorator(base) {
    override fun cost() = super.cost() + 2
    override fun description() = super.description() + " + Milk"
}

class SugarDecorator(base: Coffee) : CoffeeDecorator(base) {
    override fun cost() = super.cost() + 1
    override fun description() = super.description() + " + Sugar"
}

fun main() {
    val coffee = SugarDecorator(MilkDecorator(BasicCoffee()))
    println("🧾 ${coffee.description()} = \$${coffee.cost()}")
}

/*
 * -----------------------------------------------------
 * 📱 Decorator Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ Drawable Wrapping:
 *    - `LayerDrawable`, `InsetDrawable`, and others wrap base drawables to add padding, tint, etc.

 * ✅ InputFilter on EditText:
 *    - You can chain or wrap filters to decorate EditText behavior (e.g., character limits, emoji blocking).

 * ✅ OkHttp Interceptors:
 *    - Request/response decorators that add headers, log data, handle retries, etc.

 * ✅ Jetpack Compose Modifiers:
 *    - Compose uses chained decorators: `.padding()`, `.clip()`, `.background()`, etc.
 *    - Each modifier wraps the Composable with added behavior.

 * ✅ RecyclerView ItemDecoration:
 *    - Adds extra drawing or spacing around items without modifying the adapter.

 * 🔹 Use this pattern when:
 *    - You want to **add optional behavior dynamically** to objects.
 *    - You want to **avoid subclassing for every variation**.
 */
