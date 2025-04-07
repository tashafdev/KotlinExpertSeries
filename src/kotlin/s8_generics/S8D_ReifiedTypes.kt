package kotlin.s8_generics


/*
 * -----------------------------------------------------
 * ✅ Lecture: Reified Type Parameters in Kotlin
 * -----------------------------------------------------
 * Normally, generic types are erased at runtime (type erasure).
 * But Kotlin allows access to the actual type with:
 *
 * 🔹 `inline` → tells Kotlin to copy the function at call site
 * 🔹 `reified` → keeps the type info available at runtime
 *
 * 💡 Must be used together: `inline fun <reified T>`
 */

// Step 1️⃣: Without reified (won't compile)
// fun <T> isString(value: T): Boolean {
//     return value is String // ❌ Type info is erased
// }

// Step 2️⃣: With inline + reified
inline fun <reified T> checkType(value: Any): Boolean {
    return value is T
}

// Step 3️⃣: Generic object factory
inline fun <reified T : Any> createInstance(): T? {
    return try {
        T::class.java.getDeclaredConstructor().newInstance()
    } catch (e: Exception) {
        null
    }
}

// Step 4️⃣: Real-world-style usage
inline fun <reified T> logIfMatch(value: Any) {
    if (value is T) {
        println("✅ $value is of type ${T::class.simpleName}")
    } else {
        println("❌ Not of type ${T::class.simpleName}")
    }
}

// Step 5️⃣: Test in main()
class Dummy

fun main() {
    println("🔍 Type Checking:")
    println(checkType<String>("Hello"))     // ✅ true
    println(checkType<Int>("Hello"))        // ❌ false

    println("-----")

    println("🏭 Create Instance:")
    val instance = createInstance<Dummy>()
    println("Created: $instance")

    println("-----")

    println("🪵 Log Type Matching:")
    logIfMatch<String>("Kotlin")
    logIfMatch<Double>(42)
}
