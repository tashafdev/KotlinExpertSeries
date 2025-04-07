package kotlin.s8_generics


/*
 * -----------------------------------------------------
 * ✅ Lecture: Generics Introduction in Kotlin
 * -----------------------------------------------------
 * Generics allow you to write flexible and reusable code.
 * Instead of hardcoding types, you use type parameters like <T>.
 *
 * 🔹 Common in collections: List<T>, Map<K, V>
 * 🔹 Used in functions, classes, interfaces, and extensions
 */

// Step 1️⃣: A simple generic function
fun <T> displayItem(item: T) {
    println("Item: $item")
}

// Step 2️⃣: Generic function with multiple type parameters
fun <K, V> printKeyValue(key: K, value: V) {
    println("Key = $key, Value = $value")
}

// Step 3️⃣: Using generics with collections
fun <T> printList(items: List<T>) {
    for (item in items) {
        println("-> $item")
    }
}

// Step 4️⃣: Using generic functions in main()
fun main() {
    displayItem("Hello World")
    displayItem(42)
    displayItem(true)

    println("-----")

    printKeyValue("UserID", 101)
    printKeyValue(1001, listOf("Apple", "Banana"))

    println("-----")

    val fruits = listOf("Apple", "Mango", "Pineapple")
    val numbers = listOf(1, 2, 3, 4, 5)

    printList(fruits)
    println("-----")
    printList(numbers)
}
