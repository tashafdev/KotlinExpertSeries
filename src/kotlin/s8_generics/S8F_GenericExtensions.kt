package kotlin.s8_generics


/*
 * -----------------------------------------------------
 * ✅ Lecture: Generic Extension Functions in Kotlin
 * -----------------------------------------------------
 * Extension functions in Kotlin can also be generic!
 *
 * 🔹 Syntax: fun <T> List<T>.someExtension()
 * 🔹 Work great for building custom tools, helpers, and utilities
 * 🔹 Reuse logic across different types safely
 */

// Step 1️⃣: Generic extension on List<T>
fun <T> List<T>.printAll() {
    forEach { println("🔹 $it") }
}

// Step 2️⃣: Filter items by type using reified
inline fun <reified T> List<*>.filterByType(): List<T> {
    return filterIsInstance<T>()
}

// Step 3️⃣: Swap two items in a MutableList
fun <T> MutableList<T>.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

// Step 4️⃣: Pretty print map entries
fun <K, V> Map<K, V>.printMap() {
    for ((key, value) in this) {
        println("🗝️ $key → $value")
    }
}

// Step 5️⃣: Run extension utilities
fun main() {
    println("📦 Generic List Printer:")
    val names = listOf("Tashy", "Raj", "Zara")
    names.printAll()

    println("\n🎯 Filter By Type:")
    val mixed = listOf("One", 2, "Three", 4.5, true)
    val stringsOnly: List<String> = mixed.filterByType()
    stringsOnly.printAll()

    println("\n🔁 Swap Items:")
    val numbers = mutableListOf(10, 20, 30, 40)
    numbers.swap(1, 3)
    numbers.printAll()

    println("\n🗺️ Print Map:")
    val userMap = mapOf(101 to "Alice", 102 to "Bob")
    userMap.printMap()
}
