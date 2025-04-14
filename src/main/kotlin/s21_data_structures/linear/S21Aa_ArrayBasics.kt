package s21_data_structures.linear



/*
 * -----------------------------------------------------
 * ✅ Lecture 1: Array Basics in Kotlin
 * -----------------------------------------------------
 *
 * 📌 Arrays are fixed-size, ordered collections of elements of the same type.
 *    - Fast random access by index → O(1)
 *    - Fixed in size once initialized
 *
 * ✅ When to use:
 *    - You know the size ahead of time
 *    - You want high performance for indexed access
 *
 * 🧠 Time Complexities:
 *    - Access: O(1)
 *    - Search: O(n)
 *    - Insert/Delete at index: O(n)
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
    println("After → ${data.joinToString()}")

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
    println("Sorted → ${numbers.joinToString()}")
    println("Contains 5? → ${5 in numbers}")

    // 8️⃣ Arrays vs Lists (Quick View)
    println("\n8️⃣ Arrays vs Lists")
    val array = arrayOf(1, 2, 3)            // Fixed-size
    val list = mutableListOf(1, 2, 3)       // Resizable
    list.add(4)
    println("Array → ${array.joinToString()}")
    println("List → ${list.joinToString()}")

    // 9️⃣ Real-world Use Case
    println("\n9️⃣ Real-world Use Case")
    println("Use Arrays when performance and size predictability are important.")
    println("Example: 12 months, 7 days, fixed-size game board, grades array")

    // 🔟 Summary
    println("\n🔟 Summary")
    println("✅ Arrays are ordered, fixed-size containers of the same data type.")
    println("✅ Great for storing known-size collections with fast access needs.")
    println("✅ Use Lists when you need dynamic resizing.")
}


/*
 * -----------------------------------------------------
 * 📱 Arrays in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ Resource Arrays:
 *    - `res/values/arrays.xml` → Access via `getStringArray(R.array.months)`
 *
 * ✅ Adapter-based UIs:
 *    - Use arrays for ViewPager, Spinner, or GridView (when data is static)

 * ✅ Efficient Memory:
 *    - Image buffer or frame rendering where memory layout matters

 * ✅ Constant Tables:
 *    - For example: pre-defined mapping tables for language codes, flags, etc.

 * ✅ JNI Interop:
 *    - Native code bridges often require working with `IntArray`, `ByteArray`, etc.

 * 🔹 Use Arrays when:
 *    - Memory layout, indexing, and performance are critical
 *    - Data is predictable and doesn't need frequent resizing
 */
