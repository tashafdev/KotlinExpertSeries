package s19_clean_code_and_principles.s19a_solid_principles


/*
 * -----------------------------------------------------
 * ✅ SOLID Principle: Single Responsibility Principle (SRP)
 * -----------------------------------------------------
 * SRP = A class should have only ONE reason to change.
 * This means each class/function/module should do one thing and do it well.
 *
 * Violating SRP leads to bloated classes, tight coupling, and hard-to-test code.
 */

/*
 * 📌 Section 1 — ❌ Violation: Class doing too many things
 */
class S19Aa_UserManagerBad {
    fun registerUser(name: String, email: String) {
        println("✅ Registering $name with $email")
        sendEmail(email)
        saveToDatabase(name, email)
    }

    private fun sendEmail(email: String) {
        println("📧 Sending welcome email to $email")
    }

    private fun saveToDatabase(name: String, email: String) {
        println("💾 Saving $name to DB")
    }
}

/*
 * 📌 Section 2 — ✅ SRP-Compliant Refactor
 */
class EmailService {
    fun sendWelcomeEmail(email: String) {
        println("📧 Email sent to $email")
    }
}

class UserRepository {
    fun save(name: String, email: String) {
        println("💾 User $name saved to DB")
    }
}

class S19Aa_UserManagerGood(
    private val emailService: EmailService,
    private val userRepository: UserRepository
) {
    fun registerUser(name: String, email: String) {
        userRepository.save(name, email)
        emailService.sendWelcomeEmail(email)
    }
}

/*
 * 🧠 What You Will Learn:
 * - What is SRP and why it matters
 * - How to identify classes that do too much
 * - How to refactor responsibilities into separate components
 */

/*
 * 🚀 Quick Summary:
 * ✅ Each class/function should have one job
 * ✅ If a class has more than one reason to change → SRP is violated
 * ✅ Separate concerns like data, business logic, and side effects
 */

/*
 * 📘 Key Takeaways:
 * - Smaller responsibilities = more reusable & testable code
 * - Separation of concerns improves maintainability
 * - SRP is foundational for scalable software architecture

 * 💡 Real-World Use Cases:
 * - Break large `ViewModel`s into multiple interactors/services
 * - Separate UI, network, and DB logic in Android
 * - Clean Architecture: use-cases, repositories, helpers

 * 🧼 Clean Code Insight:
 * “If your class name has **and** in it, you're probably violating SRP.”
 */
