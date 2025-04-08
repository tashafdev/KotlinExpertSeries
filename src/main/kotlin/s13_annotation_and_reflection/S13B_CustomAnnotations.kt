package s13_annotation_and_reflection

import kotlin.reflect.full.findAnnotation


/*
 * -----------------------------------------------------
 * ✅ Kotlin Custom Annotations
 * -----------------------------------------------------
 * Create custom annotations that fit your application’s needs.
 * Use them for code generation, validation, and more.
 */

/*
 * 📌 Section 1 — Creating a Custom Annotation
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class SecureEndpoint(val role: String)

@SecureEndpoint(role = "ADMIN")
class AdminService {
    fun manage() = "Admin access granted"
}

/*
 * 📌 Section 2 — Accessing Custom Annotations via Reflection
 */
fun checkSecurityEndpoint() {
    val clazz = AdminService::class
    val annotation = clazz.findAnnotation<SecureEndpoint>()

    if (annotation != null) {
        println("🔐 Role required: ${annotation.role}")
    } else {
        println("⚠️ No security annotation present")
    }
}

/*
 * 📌 Section 3 — Use Case Example (Code Generation, Logging)
 * Custom annotations can be used with libraries like Dagger, Retrofit, or Room.
 * Here, we're just printing for simplicity.
 */
fun s13b_loggingUseCase() {
    val service = AdminService()
    val method = AdminService::class.members.find { it.name == "manage" }
    val logAnnotation = method?.findAnnotation<SecureEndpoint>()

    if (logAnnotation != null) {
        println("📜 Log: Accessing '${method.name}' with role ${logAnnotation.role}")
    }
}

/*
 * 🧠 What You Will Learn:
 * - How to create and use custom annotations
 * - How annotations can be applied for access control, logging, validation, etc.
 * - How to use reflection to read annotations

 * 🚀 Quick Summary:
 * ✅ `@Target` and `@Retention` are key for custom annotations
 * ✅ Annotations are very useful for runtime checking and logging
 * ✅ You can extend their capabilities to code generation with kapt

 * 💡 Real-World Use Cases:
 * - Authentication and authorization (e.g., roles)
 * - Validation in frameworks (e.g., `@Valid`, `@NotNull`)
 * - Code generation and mapping (e.g., Room, Moshi)
 * - Logging, tracing, and monitoring

 * 🧼 Clean Code Insight:
 * Annotations help you **declaratively** define behavior
 * without mixing implementation details.
 */
