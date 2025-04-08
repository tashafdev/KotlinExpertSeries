package s13_annotation_and_reflection



import kotlin.reflect.full.*
import kotlin.reflect.jvm.*

/*
 * -----------------------------------------------------
 * ✅ Kotlin Annotations & Reflection Together
 * -----------------------------------------------------
 * Combine annotations and reflection to create powerful tools:
 * 🔹 Dynamic behavior
 * 🔹 Code generation
 * 🔹 Validation frameworks
 *
 * Let’s see how to inspect and use annotations with reflection!
 */

/*
 * 📌 Section 1 — Custom Annotation + Reflection Example
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Loggable(val level: String)

@Loggable(level = "INFO")
class LoggingService {
    fun doSomething() {
        println("Doing something important!")
    }
}

fun s13d_loggableReflection() {
    val loggableAnnotation = LoggingService::class.findAnnotation<Loggable>()
    if (loggableAnnotation != null) {
        println("🔖 Log level: ${loggableAnnotation.level}")
    } else {
        println("⚠️ No Loggable annotation found")
    }
}

/*
 * 📌 Section 2 — Accessing Annotations with Reflection
 */
fun s13d_reflectionAnnotationOnFunctions() {
    val method = LoggingService::class.memberFunctions.find { it.name == "doSomething" }
    val annotation = method?.findAnnotation<Loggable>()

    if (annotation != null) {
        println("🎯 Function is annotated with Loggable, level: ${annotation.level}")
    } else {
        println("❌ No annotation found on function.")
    }
}

/*
 * 📌 Section 3 — Validating Classes/Functions Dynamically
 */
fun s13d_dynamicValidationWithReflection() {
    val clazz = LoggingService::class
    val method = clazz.memberFunctions.find { it.name == "doSomething" }

    if (method?.findAnnotation<Loggable>() != null) {
        println("✅ Loggable annotation found! Ready to proceed.")
    } else {
        println("❌ No Loggable annotation. Skipping execution.")
    }
}

/*
 * 🧠 What You Will Learn:
 * - How to combine annotations and reflection in Kotlin
 * - How to dynamically inspect and act on annotations at runtime
 * - How annotations can drive behaviors like logging, validation, etc.

 * 🚀 Quick Summary:
 * ✅ Combine reflection and annotations for dynamic behavior
 * ✅ Access annotations via `findAnnotation()`
 * ✅ Useful for logging, validation, and code generation

 * 💡 Real-World Use Cases:
 * - Logging (e.g., Loggable annotations)
 * - Dependency Injection (e.g., `@Inject`)
 * - Input validation (e.g., `@NotNull`)
 * - API validation (e.g., `@Path`, `@Query` in Retrofit)

 * 🧼 Clean Code Insight:
 * Reflection + Annotations can **automate repetitive tasks** and **enforce rules**, but don't overcomplicate your code.
 */
