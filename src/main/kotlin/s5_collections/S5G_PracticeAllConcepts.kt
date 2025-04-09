package s5_collections


/**
 * S5G_PracticeAllConcepts.kt
 * Problem: Build a shopping cart system that uses List, Set, Map, Sequences,
 * and collection operations.
 */

fun main() {
    println("🛒 Shopping Cart Summary")

    // 🔹 Step 1: Shopping cart items (List)
    val cartItems = listOf("Apple", "Banana", "Apple", "Orange", "Banana")

    // 🔹 Step 2: Remove duplicates (Set)
    val uniqueItems: Set<String> = cartItems.toSet()

    println("🧺 Unique Items in Cart: $uniqueItems")

    // 🔹 Step 3: Prices map (Map)
    val itemPrices = mapOf(
        "Apple" to 1.5,
        "Banana" to 1.0,
        "Orange" to 2.0
    )

    // 🔹 Step 4: Count items (Map from List)
    val itemCounts = cartItems.groupingBy { it }.eachCount()

    println("📦 Item Counts: $itemCounts")

    // 🔹 Step 5: Total calculation using collection functions
    val total = itemCounts.entries.sumOf { (item, count) ->
        val price = itemPrices[item] ?: 0.0
        count * price
    }

    println("💰 Total Price: $${"%.2f".format(total)}")

    // 🔹 Step 6: Lazy sequence for discount preview
    val sequence = cartItems.asSequence()
        .distinct()
        .map { item -> "$item: $${itemPrices[item] ?: "N/A"}" }

    println("🔍 Lazy-loaded preview:")
    sequence.forEach { println(it) }
}
