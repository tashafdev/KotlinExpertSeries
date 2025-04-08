package s21_data_structures


/*
 * -----------------------------------------------------
 * ✅ Lecture 1: Array Basics in Kotlin
 * -----------------------------------------------------
 * Arrays are fixed-size, ordered collections of elements of the same type.
 * Useful when you know the number of elements in advance and want fast access.
 */

fun main() {

    // 1️⃣ What is an Array?
    println("\n1️⃣ What is an Array?")
    println("An Array stores elements in a fixed-size and ordered manner.")

    // 2️⃣ How to Declare an Array
    println("\n2️⃣ How to Declare an Array")
    val intArray = arrayOf(1, 2, 3, 4)
    val stringArray = arrayOf("apple", "banana", "cherry")
    println("Int Array → ${intArray.joinToString()}")
    println("String Array → ${stringArray.joinToString()}")

    // 3️⃣ Using Array Constructor
    println("\n3️⃣ Using Array Constructor")
    val squareArray = Array(5) { i -> i * i }
    println("Square Array → ${squareArray.joinToString()}") // Output: 0, 1, 4, 9, 16

    // 4️⃣ Accessing and Modifying Elements
    println("\n4️⃣ Accessing and Modifying Elements")
    val data = arrayOf(10, 20, 30)
    println("Before → ${data.joinToString()}")
    data[1] = 99
    println("After → ${data.joinToString()}") // Output: 10, 99, 30

    // 5️⃣ Getting Array Size
    println("\n5️⃣ Getting Array Size")
    println("Size = ${data.size}")

    // 6️⃣ Iterating an Array
    println("\n6️⃣ Iterating an Array")
    for (element in data) {
        println("Element = $element")
    }

    // 7️⃣ Common Array Operations
    println("\n7️⃣ Common Array Operations")
    val numbers = arrayOf(5, 2, 9, 1)
    numbers.sort()
    println("Sorted → ${numbers.joinToString()}") // Output: 1, 2, 5, 9
    println("Contains 5? → ${5 in numbers}") // Output: true

    // 8️⃣ Arrays vs Lists (Quick View)
    println("\n8️⃣ Arrays vs Lists")
    val array = arrayOf(1, 2, 3)            // Fixed-size
    val list = mutableListOf(1, 2, 3)      // Resizable
    list.add(4)
    println("Array → ${array.joinToString()}")
    println("List → ${list.joinToString()}")

    // 9️⃣ Real-world Use Case
    println("\n9️⃣ Real-world Use Case")
    println("Use Arrays when performance and size predictability are important.\nExample: Storing 12 months, 7 days, grades of students, etc.")

    // 🔟 Summary
    println("\n🔟 Summary")
    println("✅ Arrays are ordered, fixed-size containers of the same data type.")
    println("✅ Great for storing known-size collections with fast access needs.")
    println("✅ Use Lists when you need dynamic resizing.")
}
