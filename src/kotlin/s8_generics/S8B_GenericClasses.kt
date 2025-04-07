package kotlin.s8_generics


/*
 * -----------------------------------------------------
 * ✅ Lecture: Generic Classes & Interfaces in Kotlin
 * -----------------------------------------------------
 * A class or interface can be generic by using <T>, <K, V>, etc.
 *
 * 🔹 Great for reusable containers, wrappers, or service interfaces
 * 🔹 Kotlin allows you to define type-safe, flexible structures
 */

// Step 1️⃣: Simple generic class
class Box<T>(val value: T) {
    fun printContent() {
        println("Box contains: $value")
    }
}

// Step 2️⃣: Multiple type parameters
class PairHolder<A, B>(val first: A, val second: B) {
    fun printPair() {
        println("First: $first, Second: $second")
    }
}

// Step 3️⃣: Generic interface
interface DataSource<T> {
    fun getData(): T
}

// Step 4️⃣: Implementing generic interface
class StringDataSource : DataSource<String> {
    override fun getData(): String = "Hello from StringDataSource"
}

class IntDataSource : DataSource<Int> {
    override fun getData(): Int = 42
}

// Step 5️⃣: Test in main()
fun main() {
    val stringBox = Box("Generics are powerful!")
    stringBox.printContent()

    val intBox = Box(123)
    intBox.printContent()

    println("-----")

    val pair = PairHolder("Kotlin", 1.9)
    pair.printPair()

    println("-----")

    val strSource: DataSource<String> = StringDataSource()
    val intSource: DataSource<Int> = IntDataSource()

    println("String source: ${strSource.getData()}")
    println("Int source: ${intSource.getData()}")
}
