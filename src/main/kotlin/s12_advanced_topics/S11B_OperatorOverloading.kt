package s12_advanced_topics


/*
 * -----------------------------------------------------
 * ✅ Kotlin Advanced — Operator Overloading
 * -----------------------------------------------------
 * Kotlin allows overloading of operators like `+`, `-`, `*`, `[]`, etc.
 * This is syntactic sugar — under the hood, it maps to specially named functions.
 *
 * Use carefully — make your types feel like natural primitives.
 */

/*
 * 📌 Section 1 — Simple operator overload
 */
data class Vector(val x: Int, val y: Int) {
    operator fun plus(other: Vector): Vector {
        return Vector(x + other.x, y + other.y)
    }
}

fun s12b_demoVectorAddition() {
    val a = Vector(2, 3)
    val b = Vector(4, 1)
    val result = a + b // 🔁 Calls operator fun plus
    println("🧮 Result: $result") // Output: Vector(x=6, y=4)
}

/*
 * 📌 Section 2 — Other supported operators
 */
class Counter(var count: Int) {
    operator fun inc(): Counter {
        count++
        return this
    }

    operator fun compareTo(other: Counter): Int {
        return this.count - other.count
    }

    operator fun not(): Counter {
        count = 0
        return this
    }
}

fun s12b_demoOtherOperators() {
    var c = Counter(5)
    c++
    println("🔢 Incremented: ${c.count}")

    val isGreater = c > Counter(2)
    println("📈 Greater than 2? $isGreater")

    val reset = !c
    println("❌ Reset: ${reset.count}")
}

/*
 * 🧠 What You Will Learn:
 * - How Kotlin maps `+`, `-`, `>`, `!`, `[]`, `()` to operator functions
 * - How to overload them cleanly in your own classes

 * 🚀 Quick Summary:
 * ✅ Operator overloading adds expressiveness
 * ✅ Behind the scenes = normal function calls
 * ✅ Use only when it improves readability

 * 💡 Real-World Use Cases:
 * - DSLs and frameworks (Compose UI, Kotlinx HTML)
 * - Custom data types (vectors, currencies, matrix ops)
 * - Domain modeling (Duration + Duration, Money * Rate)

 * 🧼 Clean Code Insight:
 * Operator overloading should feel intuitive.
 * Don’t surprise future readers — make your `+` feel like a real `+`.
 */
