package kotlin.s8_generics


/*
 * -----------------------------------------------------
 * ✅ Lecture: Type Constraints in Kotlin Generics
 * -----------------------------------------------------
 * Type constraints restrict the kinds of types that can be used
 * as type arguments for a generic type parameter.
 *
 * 🔹 Upper bounds are defined using `:`
 * 🔹 Multiple constraints use `where`
 */

// Step 1️⃣: Constrain type to Comparable<T>
fun <T : Comparable<T>> findMax(a: T, b: T): T {
    return if (a > b) a else b
}

// Step 2️⃣: Use with custom comparable class
data class Version(val code: Int) : Comparable<Version> {
    override fun compareTo(other: Version): Int = this.code - other.code
}

// Step 3️⃣: Multiple constraints using `where`
fun <T> printLengthIfMatch(item: T)
        where T : CharSequence, T : Appendable {
    println("Length: ${item.length}")
    item.append(" [modified]")
    println("After append: $item")
}

// Step 4️⃣: Test type constraints
fun main() {
    println("🔢 Comparable Constraint:")
    println("Max of 42 and 67: ${findMax(42, 67)}")

    val v1 = Version(1)
    val v2 = Version(5)
    println("Newer version: ${findMax(v1, v2)}")

    println("-----")

    println("📏 Multiple Constraints:")
    val sb = StringBuilder("Kotlin")
    printLengthIfMatch(sb)

    // printLengthIfMatch("string") ❌ Not allowed, String is CharSequence but not Appendable
}
