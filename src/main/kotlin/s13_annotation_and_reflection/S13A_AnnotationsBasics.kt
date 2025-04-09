package s13_annotation_and_reflection

//
///*
// * -----------------------------------------------------
// * ✅ Kotlin Annotations — Basics
// * -----------------------------------------------------
// * Annotations are metadata attached to:
// * 🔹 Classes
// * 🔹 Functions
// * 🔹 Properties
// * 🔹 Parameters
// *
// * They **do nothing by themselves**, but can be:
// * ✅ Read at runtime (via reflection)
// * ✅ Used by compilers/tools (like kapt)
// */
//
///*
// * 📌 Section 1 — Defining and Using a Basic Annotation
// */
//@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class Loggable
//
//@Loggable
//class S13A_MyService {
//    fun greet() = "Hello from service!"
//}
//
///*
// * 📌 Section 2 — Annotation Targets
// * You can target:
// * - class, function, property, field, parameter, etc.
// */
//@Target(AnnotationTarget.VALUE_PARAMETER)
//annotation class ImportantParam
//
//fun sendMessage(@ImportantParam msg: String) {
//    println("✉️ Message: $msg")
//}
//
///*
// * 📌 Section 3 — Retention Levels
// * - SOURCE: Gone after compilation
// * - BINARY: In .class file but not accessible via reflection
// * - RUNTIME: Available via reflection (most common)
// */
//@Target(AnnotationTarget.PROPERTY)
//@Retention(AnnotationRetention.SOURCE)
//annotation class DeveloperNote(val message: String)
//
///*
// * 🧠 What You Will Learn:
// * - How to define and use annotations in Kotlin
// * - What targets and retention mean
// * - Where annotations are useful in modern Kotlin apps
//
// * 🚀 Quick Summary:
// * ✅ Use `@Target` to declare where it can be applied
// * ✅ Use `@Retention` to control visibility
// * ✅ Annotations are powerful when combined with reflection or kapt
//
// * 💡 Real-World Use Cases:
// * - Logging, validation, DI (e.g., `@Inject`, `@Module`)
// * - Room, Moshi, Retrofit, Dagger
// * - Custom compiler tools (kapt, ksp)
//
// * 🧼 Clean Code Insight:
// * Annotations are like metadata hints —
// * powerful when tools know how to **read and act on them**.
// */
