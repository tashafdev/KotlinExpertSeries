package kotlin.s7_interfaces_and_inheritance


/*
 * -----------------------------------------------------
 * ✅ Lecture: Inheritance Basics in Kotlin
 * -----------------------------------------------------
 * Inheritance allows you to create a class (child) that reuses code from another class (parent).
 *
 * 🔹 All classes in Kotlin are `final` by default. Use `open` to make a class inheritable.
 * 🔹 Methods and properties also need to be marked `open` to be overridden.
 */

// Step 1️⃣: Define a base (parent) class
open class AppUser(
    val name: String,
    val email: String
) {
    open fun welcomeMessage() = println("Welcome, $name!")
}

// Step 2️⃣: Create a derived (child) class
class PremiumUser(
    name: String,
    email: String,
    val subscriptionPlan: String
) : AppUser(name, email) {

    override fun welcomeMessage() {
        println("Welcome back, Premium $name!")
        println("Your plan: $subscriptionPlan")
    }
}

// Step 3️⃣: Another child class with additional behavior
class AdminUser(
    name: String,
    email: String,
    val accessLevel: Int
) : AppUser(name, email) {

    override fun welcomeMessage() {
        println("Hello Admin $name — Access Level $accessLevel")
    }

    fun deleteUser(user: AppUser) {
        println("Admin $name deleted user ${user.name}")
    }
}

// Step 4️⃣: Testing inheritance behavior
fun main() {
    val regularUser = AppUser("John Doe", "john@example.com")
    val premiumUser = PremiumUser("Alice", "alice@example.com", "Gold")
    val adminUser = AdminUser("Raj", "raj@example.com", 5)

    regularUser.welcomeMessage()
    println("-----")
    premiumUser.welcomeMessage()
    println("-----")
    adminUser.welcomeMessage()
    adminUser.deleteUser(premiumUser)
}
