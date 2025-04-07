package s8_generics



/*
 * ------------------------------------------------------------------
 * ✅ Lecture: Variance in Kotlin — `in`, `out`, and Type Safety
 * ------------------------------------------------------------------
 * Kotlin generics are invariant by default. This means:
 * List<Dog> is NOT a subtype of List<Animal>, even if Dog : Animal.
 *
 * 🔹 Use `out` for producers (covariant)
 * 🔹 Use `in` for consumers (contravariant)
 * 🔹 Helps make APIs flexible and type-safe
 *
 * Mnemonic:
 *    - `out` = you get OUT values → read only
 *    - `in`  = you put IN values  → write only
 */

// 🐾 Step 1️⃣: Covariant example using `out`
open class Animal(val name: String)
class Dog(name: String) : Animal(name)

class AnimalCage<out T : Animal>(private val animal: T) {
    fun getAnimal(): T = animal // ✅ Safe to return
    // fun setAnimal(a: T) ❌ Not allowed — 'T' is 'out'
}

// 🥩 Step 2️⃣: Contravariant example using `in`
interface AnimalFeeder<in T> {
    fun feed(animal: T)
}

class DogFeeder : AnimalFeeder<Dog> {
    override fun feed(animal: Dog) {
        println("Feeding dog: ${animal.name}")
    }
}

// 📦 Step 3️⃣: Use `out` at call site
fun printAnimalNames(cage: AnimalCage<Animal>) {
    println("Animal: ${cage.getAnimal().name}")
}

// 🧪 Step 4️⃣: Run test cases
fun main() {
    println("🦴 Covariance (`out`) Example:")
    val dogCage = AnimalCage(Dog("Rocky"))
    printAnimalNames(dogCage) // ✅ Works due to `out T`

    println("\n🍗 Contravariance (`in`) Example:")
    val dogFeeder: AnimalFeeder<Dog> = DogFeeder()

    // ✅ Allowed due to `in T`: AnimalFeeder<Dog> is a subtype of AnimalFeeder<Animal>
    val animalFeeder: AnimalFeeder<Dog> = dogFeeder
    animalFeeder.feed(Dog("Leo")) // We feed it a Dog, which works
}

