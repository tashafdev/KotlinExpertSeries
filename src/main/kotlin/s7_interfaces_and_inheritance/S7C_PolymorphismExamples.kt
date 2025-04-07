package s7_interfaces_and_inheritance


/*
 * -----------------------------------------------------
 * ✅ Lecture: Polymorphism in Kotlin
 * -----------------------------------------------------
 * Polymorphism allows objects of different classes to be treated
 * as objects of a common super type (interface or abstract/base class).
 *
 * Polymorphism = "Many Forms"
 */

// Step 1️⃣: Interface Polymorphism - Drawing tools
interface Drawable {
    fun draw()
}

class DrawableCircle : Drawable {
    override fun draw() = println("Drawing a Circle")
}

class DrawableSquare : Drawable {
    override fun draw() = println("Drawing a Square")
}

class DrawableTriangle : Drawable {
    override fun draw() = println("Drawing a Triangle")
}

fun renderDrawable(drawable: Drawable) {
    drawable.draw()
}

// Step 2️⃣: Abstract Class Polymorphism - Farm animals
abstract class FarmAnimal {
    abstract fun makeSound()
}

class FarmCow : FarmAnimal() {
    override fun makeSound() = println("Moo")
}

class FarmSheep : FarmAnimal() {
    override fun makeSound() = println("Baa")
}

fun playFarmAnimalSound(animal: FarmAnimal) {
    animal.makeSound()
}

// Step 3️⃣: Real-world polymorphism - Payments
interface PaymentProcessor {
    fun pay(amount: Double)
}

class CreditCardProcessor : PaymentProcessor {
    override fun pay(amount: Double) = println("Paid $$amount using Credit Card")
}

class PayPalProcessor : PaymentProcessor {
    override fun pay(amount: Double) = println("Paid $$amount using PayPal")
}

fun executePayment(processor: PaymentProcessor, amount: Double) {
    processor.pay(amount)
}

// Step 4️⃣: Test polymorphism
fun main() {
    println("🎨 Drawable Examples:")
    val drawables: List<Drawable> = listOf(
        DrawableCircle(), DrawableSquare(), DrawableTriangle()
    )
    drawables.forEach { renderDrawable(it) }

    println("\n🐄 Farm Animal Sounds:")
    val animals: List<FarmAnimal> = listOf(FarmCow(), FarmSheep())
    animals.forEach { playFarmAnimalSound(it) }

    println("\n💳 Payment Processors:")
    val processors: List<PaymentProcessor> = listOf(
        CreditCardProcessor(), PayPalProcessor()
    )
    processors.forEach { executePayment(it, 49.99) }
}
