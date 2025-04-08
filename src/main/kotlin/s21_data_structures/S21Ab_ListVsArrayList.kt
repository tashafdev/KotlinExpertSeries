package s21_data_structures


/*
 * -----------------------------------------------------
 * ✅ Lecture 2: List vs ArrayList (as Data Structures)
 * -----------------------------------------------------
 * In Kotlin, List, MutableList, and ArrayList are all ways to store ordered collections.
 * But they differ in mutability, implementation, and intended use case.
 *
 * This lecture focuses on their role as data structures.
 */

fun main() {

    // 1️⃣ What is a List?
    println("\n1️⃣ What is a List?")
    val readOnlyList = listOf("Apple", "Banana", "Cherry")
    println("Read-only List → $readOnlyList")
    println("List is fixed in size and content. You can't add/remove elements.")

    // 2️⃣ What is a MutableList?
    println("\n2️⃣ What is a MutableList?")
    val mutableList = mutableListOf("Dog", "Cat")
    mutableList.add("Rabbit")
    println("Mutable List → $mutableList")
    println("MutableList allows dynamic changes: add, remove, update elements.")

    // 3️⃣ What is an ArrayList?
    println("\n3️⃣ What is an ArrayList?")
    val arrayList = arrayListOf(1, 2, 3)
    arrayList.add(4)
    println("ArrayList → $arrayList")
    println("ArrayList is a concrete class that implements MutableList. It uses resizable array under the hood.")

    // 4️⃣ Internal Behavior
    println("\n4️⃣ Internal Behavior")
    println("List → Backed by an immutable view of data")
    println("MutableList → Backed by a resizable structure")
    println("ArrayList → Backed by Java's resizable array (ArrayList<E>)")

    // 5️⃣ Access and Iteration
    println("\n5️⃣ Access and Iteration")
    println("Second item in readOnlyList = ${readOnlyList[1]}")
    println("Iterating MutableList:")
    for (item in mutableList) println(item)

    // 6️⃣ Use Case Differences
    println("\n6️⃣ Use Case Differences")
    println("✔️ Use List when the data is constant (e.g. days of week, month names)")
    println("✔️ Use MutableList when items change during program flow")
    println("✔️ Use ArrayList when performance matters and you want fine control")

    // 7️⃣ Real-World Usage
    println("\n7️⃣ Real-World Usage")
    println("List → App intro pages, constants, navigation tabs")
    println("MutableList → User's shopping cart, dynamic search history")
    println("ArrayList → Large datasets where resizing and random access is common")

    // 🔟 Summary
    println("\n🔟 Summary")
    println("✅ List = Read-only. Fixed size. Safe. Created using listOf().")
    println("✅ MutableList = Interface for modifiable lists. Created using mutableListOf().")
    println("✅ ArrayList = Concrete class. Implements MutableList. Created using arrayListOf().")
    println("✅ Choose based on mutability, performance needs, and usage context.")
}
