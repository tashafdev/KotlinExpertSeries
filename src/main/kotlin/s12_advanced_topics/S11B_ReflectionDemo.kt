package s12_advanced_topics


import kotlin.reflect.*
import kotlin.reflect.full.*
import kotlin.reflect.jvm.*

/*
 * -----------------------------------------------------
 * ✅ Kotlin Advanced — Reflection Basics
 * -----------------------------------------------------
 * Kotlin Reflection lets you inspect and modify classes,
 * properties, functions, and annotations at runtime.
 *
 * Use with care — it’s powerful but can impact performance.
 */

/*
 * 📌 Section 1 — Accessing class metadata
 */
class Person(val name: String, var age: Int) {
    fun greet() = "Hello, I'm $name"
}

fun s12b_reflectClassMetadata() {
    val kClass = Person::class
    println("🔍 Class Name: ${kClass.simpleName}")
    println("📦 Constructors: ${kClass.constructors}")
    println("📋 Properties: ${kClass.memberProperties.map { it.name }}")
    println("📘 Functions: ${kClass.memberFunctions.map { it.name }}")
}

/*
 * 📌 Section 2 — Accessing and modifying properties
 */
fun s12b_reflectPropertyReadWrite() {
    val p = Person("Tashy", 30)
    val kProperty = Person::age
    println("🧠 Age before: ${kProperty.get(p)}")

    kProperty.setter.call(p, 35)
    println("🎂 Age after: ${kProperty.get(p)}")
}

/*
 * 📌 Section 3 — Calling functions dynamically
 */
fun s12b_callFunctionReflectively() {
    val instance = Person("Boss", 27)
    val method = Person::class.memberFunctions.find { it.name == "greet" }
    val result = method?.call(instance)
    println("🗣️ Greet Result: $result")
}

/*
 * 🧠 What You Will Learn:
 * - What Kotlin Reflection is
 * - How to inspect properties, functions, classes at runtime
 * - How to call functions and change property values using reflection

 * 🚀 Quick Summary:
 * ✅ Kotlin reflection is in `kotlin.reflect` package
 * ✅ Access members via `::class`, `::property`, `memberFunctions`, etc.
 * ✅ You can read/write properties, call methods, and explore metadata

 * 💡 Real-World Use Cases:
 * - Annotation processing
 * - Serialization (e.g., Moshi, kotlinx.serialization)
 * - Dependency Injection (Koin, Dagger)
 * - Debugging and dynamic testing tools

 * 🧼 Clean Code Insight:
 * Use reflection responsibly.
 * It breaks encapsulation — great for tooling, bad for everyday logic.
 */
