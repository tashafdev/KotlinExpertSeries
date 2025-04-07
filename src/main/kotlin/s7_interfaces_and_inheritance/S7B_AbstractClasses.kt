package s7_interfaces_and_inheritance


/*
 * ------------------------------------------------
 * ✅ Lecture: Abstract Classes in Kotlin
 * ------------------------------------------------
 * Abstract classes serve as partially implemented blueprints.
 * They can have:
 * 🔹 Abstract members (no body)
 * 🔹 Concrete members (with body)
 * 🔹 Constructors (unlike interfaces)
 *
 * Use abstract classes when:
 * 🔸 You need to maintain state
 * 🔸 You want to define a base class with some shared logic
 * 🔸 You want to enforce a contract but allow common implementation
 */

// Step 1️⃣: Define an abstract class
abstract class Animal(val name: String) {
    abstract fun makeSound() // Abstract method

    fun sleep() = println("$name is sleeping") // Concrete method
}

// Step 2️⃣: Implement the abstract class
class Dog(name: String) : Animal(name) {
    override fun makeSound() = println("$name says: Woof!")
}

class Cat(name: String) : Animal(name) {
    override fun makeSound() = println("$name says: Meow!")
}

// Step 3️⃣: Abstract class with property + constructor
abstract class Vehicle(open val brand: String) {
    abstract fun drive()
    fun stop() = println("$brand vehicle stopped.")
}

class Car(override val brand: String) : Vehicle(brand) {
    override fun drive() = println("$brand car is driving")
}

class Bike(override val brand: String) : Vehicle(brand) {
    override fun drive() = println("$brand bike is zooming")
}

// Step 4️⃣: Testing abstract class behavior
fun main() {
    val dog = Dog("Buddy")
    val cat = Cat("Luna")

    dog.makeSound()
    dog.sleep()

    cat.makeSound()
    cat.sleep()

    println("-----------")

    val car = Car("Toyota")
    val bike = Bike("Yamaha")

    car.drive()
    car.stop()

    bike.drive()
    bike.stop()
}
