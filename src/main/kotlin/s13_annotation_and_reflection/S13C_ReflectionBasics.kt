package s13_annotation_and_reflection


import kotlin.reflect.*
import kotlin.reflect.full.*

///*
// * -----------------------------------------------------
// * ✅ Kotlin Reflection — Basics
// * -----------------------------------------------------
// * Reflection allows you to inspect and manipulate Kotlin classes,
// * properties, functions, and annotations at runtime.
// *
// * It's useful for things like:
// * 🔹 Serialization
// * 🔹 Dependency Injection
// * 🔹 Libraries like Gson, Moshi, and Room use it
// */
//
///*
// * 📌 Section 1 — Inspecting a Class with Reflection
// */
//class User(val name: String, var age: Int)
//
//fun s13c_reflectionBasics() {
//    val userClass = User::class
//    println("🧳 Class Name: ${userClass.simpleName}")
//    println("🔎 Properties: ${userClass.memberProperties.map { it.name }}")
//    println("🔧 Functions: ${userClass.memberFunctions.map { it.name }}")
//}
//
///*
// * 📌 Section 2 — Accessing and Modifying Properties via Reflection
// */
//fun s13c_accessingProperties() {
//    val user = User("Tashy", 25)
//
//    // Get the 'name' property
//    val nameProperty = User::class.memberProperties.find { it.name == "name" }
//    println("🧳 Property 'name': ${nameProperty?.getter?.call(user)}")
//
//    // Set the 'age' property
//    val ageProperty = User::class.memberProperties.find { it.name == "age" }
//    ageProperty?.setter?.call(user, 30)
//    println("🎂 Updated Age: ${user.age}")
//}
//
///*
// * 📌 Section 3 — Calling Functions Dynamically
// */
//fun s13c_callFunctionsDynamically() {
//    val user = User("Tashy", 25)
//
//    val greetMethod = User::class.memberFunctions.find { it.name == "toString" }
//    val result = greetMethod?.call(user)
//    println("🎤 Function call result: $result")
//}
//
///*
// * 🧠 What You Will Learn:
// * - How Kotlin reflection lets you inspect and interact with classes, properties, and functions at runtime
// * - How to use reflection to access private properties
// * - How to call functions dynamically using reflection
//
// * 🚀 Quick Summary:
// * ✅ Use `::class` for class inspection
// * ✅ Access properties with `memberProperties` and methods with `memberFunctions`
// * ✅ Reflection gives you runtime flexibility but should be used sparingly
//
// * 💡 Real-World Use Cases:
// * - Object serialization/deserialization
// * - Dependency Injection frameworks (e.g., Koin, Dagger)
// * - Dynamic UI rendering (e.g., data binding)
//
// * 🧼 Clean Code Insight:
// * Reflection can be **powerful**, but avoid using it in performance-critical paths, as it may degrade runtime speed.
// */
