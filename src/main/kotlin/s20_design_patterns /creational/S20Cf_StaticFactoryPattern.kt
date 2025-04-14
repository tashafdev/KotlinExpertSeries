/**
 * -----------------------------------------------------
 * ✅ Lecture: Static Factory Pattern (Optional Creational)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * A variation of the Factory Method Pattern using static methods
 * (like companion objects in Kotlin) to encapsulate object creation.
 *
 * 📦 Use Case:
 * - Simplifying instance creation logic
 * - Replacing complex constructors with meaningful names
 *
 * 🧠 Why use it?
 * - Improves readability with named methods like `of()`, `newInstance()`
 * - Hides constructor logic
 * - Can control instance caching or reuse
 *
 * ⚠️ Note:
 * - Not part of original GoF patterns, but widely used in real-world Kotlin & Java apps
 *
 * -----------------------------------------------------
 * 🧪 Example: Creating a User using `of()` and `fromEmail()`
 * -----------------------------------------------------
 */

class User private constructor(val username: String, val email: String) {
    companion object {
        fun of(username: String, email: String): User {
            println("🧑 Creating user using 'of'")
            return User(username, email)
        }

        fun fromEmail(email: String): User {
            val username = email.substringBefore("@")
            println("📧 Creating user using 'fromEmail'")
            return User(username, email)
        }
    }

    fun printInfo() {
        println("👤 User: $username | Email: $email")
    }
}

fun main() {
    val user1 = User.of("tashy", "tashy@example.com")
    val user2 = User.fromEmail("john@sample.com")

    user1.printInfo()
    user2.printInfo()
}

/*
 * -----------------------------------------------------
 * 📱 Real-World Usage in Android – Static Factory Pattern
 * -----------------------------------------------------
 *
 * 🔹 Room.databaseBuilder(...) / Room.inMemoryDatabaseBuilder(...):
 *    - Instead of directly calling constructors, Room offers factory methods with descriptive names.
 *
 * 🔹 LiveData / MutableLiveData:
 *    - `MutableLiveData()` is a factory-like method that creates a reactive data holder.
 *    - You might also define `fun newInstance()` in companion objects for custom state holders.
 *
 * 🔹 Firebase:
 *    - Methods like `FirebaseAuth.getInstance()` act like static factories.
 *
 * 🔹 Kotlin Companion Objects:
 *    - Frequently used to provide factory methods (e.g., `of()`, `fromJson()`, `create()`).
 *
 * 🔹 ViewModelProviders.of(...) [deprecated] and now:
 *    - `ViewModelProvider.Factory` instances with named creation functions.
 *
 * ✅ Use Static Factory Pattern when:
 *    - You want **meaningful names** instead of overloaded constructors.
 *    - You want to **hide object creation logic** and control return types (e.g., caching, subtypes).
 */

