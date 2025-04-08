package s13_annotation_and_reflection


///*
// * -----------------------------------------------------
// * ✅ Kotlin Annotations & Reflection in Android
// * -----------------------------------------------------
// * Kotlin annotations and reflection can be extremely useful in Android development.
// * Some common Android-specific use cases are:
// * 🔹 Dependency Injection (Dagger, Koin)
// * 🔹 Retrofit API client annotations
// * 🔹 Room Database annotations
// * 🔹 ViewBinding and DataBinding
// * 🔹 Custom validation annotations
// */
//
///*
// * 📌 Section 1 — Room Database Annotations Example
// * Room uses annotations like `@Entity`, `@Dao`, etc., to generate SQL code.
// */
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//import androidx.room.Dao
//import androidx.room.Insert
//
//@Entity
//data class User(@PrimaryKey val id: Int, val name: String)
//
//@Dao
//interface UserDao {
//    @Insert
//    suspend fun insert(user: User)
//}
//
//fun s13e_roomAnnotations() {
//    val user = User(1, "Tashy")
//    println("📦 Room entity created: ${user.name}")
//}
//
///*
// * 📌 Section 2 — Retrofit API Annotations
// * Retrofit uses annotations like `@GET`, `@POST`, `@Query` to configure HTTP requests.
// */
//import retrofit2.http.GET
//import retrofit2.http.Query
//
//interface ApiService {
//    @GET("users")
//    suspend fun getUsers(@Query("page") page: Int): List<User>
//}
//
//fun s13e_retrofitAnnotations() {
//    println("🔗 Retrofit annotations handle API requests dynamically.")
//}
//
///*
// * 📌 Section 3 — Custom Validation Annotations
// * Custom annotations can enforce validation logic using reflection.
// */
//@Target(AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class NotEmpty
//
//data class Person(@NotEmpty val name: String, val age: Int)
//
//fun s13e_customValidationWithReflection() {
//    val person = Person("Tashy", 30)
//
//    val nameProperty = Person::class.memberProperties.find { it.name == "name" }
//    val annotation = nameProperty?.findAnnotation<NotEmpty>()
//
//    if (annotation != null && person.name.isEmpty()) {
//        println("❌ Name cannot be empty!")
//    } else {
//        println("✅ Validation passed for name: ${person.name}")
//    }
//}
//
///*
// * 🧠 What You Will Learn:
// * - How annotations are used in popular Android libraries like Room, Retrofit, and Dagger
// * - How to build custom annotations for validation and behavior
// * - How Kotlin's reflection can be used to validate and interact with annotations
//
// * 🚀 Quick Summary:
// * ✅ Use annotations for boilerplate generation (Room, Retrofit)
// * ✅ Use reflection for custom validation
// * ✅ Annotations improve clarity and reduce repetitive code
//
// * 💡 Real-World Use Cases:
// * - Room for DB entities (`@Entity`, `@PrimaryKey`, `@Dao`)
// * - Retrofit for API endpoints (`@GET`, `@POST`)
// * - Validation (e.g., `@NotEmpty`, `@Email`)
// * - Dependency Injection (e.g., `@Inject`, `@Module` in Dagger)
//
// * 🧼 Clean Code Insight:
// * Annotations make code **expressive** and **clear** without cluttering it.
// * Use them wisely for **validation**, **dependency injection**, and **tooling**.
// */
