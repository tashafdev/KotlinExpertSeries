package s6_classes_and_objects

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 6D: Singleton and Companion Objects
    📆 Package: kotlin.s6_classes_and_objects
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What is an object declaration (singleton)?
    - Companion objects inside classes
    - Static-like behavior in Kotlin
    - Factory patterns with companion
    - Singleton vs companion differences
    - Best practices

    ---------------------------------------------------------------------------
    🔍 Singleton: Object Declaration
    ----------------------------------------------------------------------------
    - Declared using `object` keyword
    - Only one instance exists throughout app lifetime

    ✅ Example:
        object AppLogger {
            fun log(msg: String) = println("[LOG] $msg")
        }

    ---------------------------------------------------------------------------
    🔹 Companion Object (Static-like Members)
    ----------------------------------------------------------------------------
    - Defined inside a class using `companion object`
    - Can access private members of the outer class

    ✅ Example:
        class UserManager private constructor() {
            companion object {
                fun create(): UserManager = UserManager()
            }
        }

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use `object` for single-use classes: managers, loggers, constants
    - Use `companion object` for static factory methods or shared tools
    - Prefer dependency injection over tightly coupled singletons when possible
    ---------------------------------------------------------------------------
*/


fun main() {
    // 📍 Singleton usage
    AppLogger.log("App Started")
    AppLogger.log("User clicked button")

    // 🧑‍💼 Create instance using companion factory
    val db = DBHelper.create("MyDatabase")
    println("DB Name: ${db.dbName}")
}

// 📅 Singleton object
object AppLogger {
    fun log(msg: String) = println("[LOG] $msg")
}

// 💼 Class with Companion Object
class DBHelper private constructor(val dbName: String) {
    companion object {
        fun create(name: String): DBHelper = DBHelper(name)
    }
}
