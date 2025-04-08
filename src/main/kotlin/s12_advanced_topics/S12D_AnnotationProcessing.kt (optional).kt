package s12_advanced_topics


/*
 * -----------------------------------------------------
 * ✅ Kotlin Advanced — Annotation Processing (KAPT)
 * -----------------------------------------------------
 * Annotation processing is a way to:
 * 🔹 Read annotations at compile time
 * 🔹 Generate code (e.g., Dagger, Room, Moshi)
 * 🔹 Automate repetitive boilerplate
 *
 * Kotlin uses **KAPT (Kotlin Annotation Processing Tool)** for this.
 */

/*
 * 📌 Section 1 — What is Annotation Processing?
 *
 * - It runs **at compile time**
 * - Looks for annotated classes/functions
 * - Generates new source files automatically
 *
 * Example: `@Entity` in Room generates table classes
 */

/*
 * 📌 Section 2 — Using KAPT in Gradle
 *
 * For Kotlin JVM/Android projects, add:
 *
 * plugins {
 *     kotlin("kapt")
 * }
 *
 * dependencies {
 *     kapt("some.annotation.processor:version")
 * }
 *
 * Source files generated will appear in:
 * build/generated/source/kapt/
 */

/*
 * 📌 Section 3 — Real-World Libraries Using KAPT
 */
fun s12d_annotationProcessingExamples() {
    println(
        """
        🔍 Libraries using annotation processing:

        ✅ Room — @Entity, @Dao → SQL DB code
        ✅ Dagger 2 — @Inject, @Module → DI graphs
        ✅ Moshi — @JsonClass → model adapters
        ✅ Glide — @GlideModule → image pipeline setup
        ✅ AutoValue — immutable data models (Google)

        All of these use annotations + KAPT to generate boilerplate.
        """.trimIndent()
    )
}

/*
 * 🧠 What You Will Learn:
 * - What annotation processing is and how it works
 * - What KAPT does in Kotlin
 * - How frameworks like Room/Dagger/Moshi use it

 * 🚀 Quick Summary:
 * ✅ KAPT = Kotlin's bridge to Java annotation processors
 * ✅ Used by many Android and Kotlin libraries
 * ✅ Great for boilerplate reduction

 * 💡 Real-World Use Cases:
 * - Code generation from annotations
 * - Dependency injection graphs
 * - Model parsing adapters (e.g. JSON)

 * 🧼 Clean Code Insight:
 * Let annotation processors do the heavy lifting.
 * You focus on clean, declarative business logic.
 */
