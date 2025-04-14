package s21_data_structures.linear


/*
 * -----------------------------------------------------
 * ✅ Lecture 2: ArrayList Basics in Kotlin
 * -----------------------------------------------------
 *
 * 📌 ArrayList is a resizable, mutable collection of elements.
 *    - Elements are ordered (indexed) like arrays
 *    - You can add, remove, or update elements dynamically
 *
 * ✅ When to use:
 *    - You don’t know the exact size in advance
 *    - You need frequent add/remove operations
 *
 * 🧠 Time Complexity:
 *    - Access: O(1)
 *    - Add (end): O(1) amortized
 *    - Add/Remove (middle): O(n)
 */

fun main() {

    // 1️⃣ Creating an Empty ArrayList
    println("1️⃣ Creating an Empty ArrayList")
    val items = ArrayList<String>()
    items.add("Apple")
    items.add("Banana")
    println("ArrayList → $items")

    // 2️⃣ Declaring with Initial Elements
    println("\n2️⃣ Initializing with Elements")
    val colors = arrayListOf("Red", "Green", "Blue")
    println("Colors → $colors")

    // 3️⃣ Accessing & Modifying Elements
    println("\n3️⃣ Accessing & Modifying")
    println("First Color → ${colors[0]}")
    colors[1] = "Yellow"
    println("Modified Colors → $colors")

    // 4️⃣ Adding & Removing Elements
    println("\n4️⃣ Adding & Removing")
    colors.add("Orange")
    colors.remove("Red")
    println("Updated Colors → $colors")

    // 5️⃣ Iterating Over ArrayList
    println("\n5️⃣ Iterating with forEach")
    colors.forEachIndexed { index, color ->
        println("Index $index → $color")
    }

    // 6️⃣ Checking Size and Contains
    println("\n6️⃣ Size & Contains")
    println("Size → ${colors.size}")
    println("Contains 'Blue'? → ${"Blue" in colors}")

    // 7️⃣ Summary
    println("\n7️⃣ Summary")
    println("✅ ArrayList is mutable and resizable.")
    println("✅ Use it when data needs to grow/shrink at runtime.")
}

/*
 * -----------------------------------------------------
 * 📱 ArrayList in Android – Real Use Cases
 * -----------------------------------------------------
 *
 * ✅ RecyclerView Adapter:
 *    - ArrayList is often used to store and update item data.

 * ✅ ViewModel Lists:
 *    - Mutable lists inside ViewModel to hold dynamic screen data.

 * ✅ Dynamic Form Builders:
 *    - Adding/removing input fields in forms dynamically.

 * ✅ Multi-step Wizards:
 *    - Store steps/screens dynamically based on logic.

 * ✅ Custom UI Components:
 *    - Maintain child views, states, or configuration options in lists.

 * 🔹 Use ArrayList when:
 *    - You need flexibility in adding/removing elements.
 *    - You're dealing with UI lists or dynamic data sources.
 */
