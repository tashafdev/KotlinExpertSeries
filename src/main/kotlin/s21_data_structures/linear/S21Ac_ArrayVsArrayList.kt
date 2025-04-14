package s21_data_structures.linear


/*
 * -----------------------------------------------------
 * ✅ Lecture 3: Array vs ArrayList in Kotlin
 * -----------------------------------------------------
 *
 * 📌 Goal:
 * Understand the difference between Arrays and ArrayLists
 * to decide which to use based on your app’s data requirements.
 *
 * 🧠 Key Concepts:
 * - Arrays are fixed-size and slightly more performant.
 * - ArrayLists are resizable and flexible.
 */

fun main() {

    // 1️⃣ Declaration
    println("1️⃣ Declaration")
    val array = arrayOf(10, 20, 30)                       // Fixed size
    val arrayList = arrayListOf(10, 20, 30)               // Dynamic size

    println("Array → ${array.joinToString()}")
    println("ArrayList → ${arrayList.joinToString()}")

    // 2️⃣ Adding Elements
    println("\n2️⃣ Adding Elements")
    // array[3] = 40 ❌ Not possible (IndexOutOfBounds)
    arrayList.add(40)
    println("ArrayList after add → $arrayList")

    // 3️⃣ Modifying Elements
    println("\n3️⃣ Modifying Elements")
    array[0] = 99
    arrayList[0] = 99
    println("Modified Array → ${array.joinToString()}")
    println("Modified ArrayList → $arrayList")

    // 4️⃣ Size
    println("\n4️⃣ Size")
    println("Array Size → ${array.size}")
    println("ArrayList Size → ${arrayList.size}")

    // 5️⃣ Iteration
    println("\n5️⃣ Iteration")
    println("Array:")
    for (value in array) println(" - $value")
    println("ArrayList:")
    arrayList.forEach { println(" - $it") }

    // 6️⃣ Use Cases
    println("\n6️⃣ Use Case Summary")
    println("✅ Array → Use when size is fixed and memory is tight.")
    println("✅ ArrayList → Use when you need to add/remove elements dynamically.")
}


/*
 * -----------------------------------------------------
 * 📱 Array vs ArrayList in Android – When to Use
 * -----------------------------------------------------
 *
 * ✅ Use Array when:
 *    - Working with constant resources like `getStringArray(R.array.my_items)`
 *    - Fixed data like months, weekdays, or sizes
 *    - Performance-critical sections (like native interop)

 * ✅ Use ArrayList when:
 *    - Backing a RecyclerView adapter
 *    - Building dynamic forms or adding/removing views
 *    - Manipulating screen data in ViewModel/Presenter

 * 🔹 Summary:
 *    - Use Array when data is static and size is known
 *    - Use ArrayList when data is dynamic and flexible
 */
