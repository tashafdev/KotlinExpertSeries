package s19_clean_code_and_principles.s19a_solid_principles


/*
 * -----------------------------------------------------
 * ✅ SOLID Principle: Dependency Inversion Principle (DIP)
 * -----------------------------------------------------
 * DIP = High-level modules should **not depend on low-level modules**.
 * Both should depend on abstractions (interfaces).
 *
 * Abstractions should not depend on details — details should depend on abstractions.
 */

/*
 * 📌 Section 1 — ❌ Violation: High-level class depends directly on low-level implementation
 */
class S19Ae_MailService {
    fun sendEmail(message: String) {
        println("📧 Sending email: $message")
    }
}

class S19Ae_NotificationManagerBad {
    private val mailService = S19Ae_MailService() // ❌ tightly coupled

    fun notifyUser() {
        mailService.sendEmail("Welcome to our app!")
    }
}

fun section1_DIPViolation() {
    val notifier = S19Ae_NotificationManagerBad()
    notifier.notifyUser()
}

/*
 * 📌 Section 2 — ✅ DIP-Compliant using interface + constructor injection
 */
interface Notifier {
    fun send(message: String)
}

class EmailNotifier : Notifier {
    override fun send(message: String) {
        println("📧 Email sent: $message")
    }
}

class SmsNotifier : Notifier {
    override fun send(message: String) {
        println("📱 SMS sent: $message")
    }
}

class S19Ae_NotificationManagerGood(private val notifier: Notifier) {
    fun notifyUser() {
        notifier.send("🎉 Welcome to DIP World!")
    }
}

fun section2_DIPCompliant() {
    val emailManager = S19Ae_NotificationManagerGood(EmailNotifier())
    val smsManager = S19Ae_NotificationManagerGood(SmsNotifier())

    emailManager.notifyUser()
    smsManager.notifyUser()
}

/*
 * 🧠 What You Will Learn:
 * - Why direct dependency on implementations is risky
 * - How to apply DIP using interfaces + injection
 * - Benefits of flexibility, testability, and reusability
 */

/*
 * 🚀 Quick Summary:
 * ✅ High-level code shouldn’t be tied to low-level details
 * ✅ Use interfaces for abstraction
 * ✅ Inject concrete dependencies from the outside
 */

/*
 * 📘 Key Takeaways:
 * - Dependency injection + abstraction = true flexibility
 * - Easy to swap implementations (Email, SMS, Push, etc.)
 * - Ideal for testing (mock the `Notifier` in unit tests)

 * 💡 Real-World Use Cases:
 * - ViewModels depending on Repositories
 * - Clean Architecture layers (Domain → Data)
 * - Replacing Firebase, Retrofit, or Analytics without rewriting logic

 * 🧼 Clean Code Insight:
 * Don’t “new” up dependencies inside your classes.
 * Instead, **depend on what you need, not how it’s done**.
 */
