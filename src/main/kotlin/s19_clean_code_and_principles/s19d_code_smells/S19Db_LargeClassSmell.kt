package s19_clean_code_and_principles.s19d_code_smells


/*
 * -----------------------------------------------------
 * ❌ Code Smell: Large Class (aka God Class)
 * -----------------------------------------------------
 * A class doing too much violates SRP and makes code:
 * - Hard to understand 😵
 * - Hard to test 🧪
 * - Hard to reuse 🛑
 *
 * Symptoms:
 * - Too many responsibilities
 * - Too many methods/fields
 * - Tries to “control” everything
 */

/*
 * 📌 Section 1 — ❌ A class doing way too much
 */
class S19Db_UserManagerBad {
    fun registerUser(name: String, email: String) {
        println("✅ Registered $name ($email)")
        sendEmail(email)
        saveToDB(name, email)
        generateWelcomeMessage(name)
        syncWithCRM(name)
    }

    fun sendEmail(email: String) {
        println("📧 Email sent to $email")
    }

    fun saveToDB(name: String, email: String) {
        println("💾 Saved $name to DB")
    }

    fun generateWelcomeMessage(name: String) {
        println("🎉 Welcome $name!")
    }

    fun syncWithCRM(name: String) {
        println("🔁 Synced $name with CRM")
    }
}

/*
 * 📌 Section 2 — ✅ Refactor: Break into smaller focused classes
 */
class EmailService {
    fun send(to: String) = println("📧 Email sent to $to")
}

class UserRepository {
    fun save(name: String, email: String) = println("💾 Saved $name to DB")
}

class WelcomeService {
    fun generate(name: String) = println("🎉 Welcome $name!")
}

class CRMIntegrator {
    fun sync(name: String) = println("🔁 Synced $name with CRM")
}

class S19Db_UserManagerGood(
    private val emailService: EmailService,
    private val userRepository: UserRepository,
    private val welcomeService: WelcomeService,
    private val crmIntegrator: CRMIntegrator
) {
    fun registerUser(name: String, email: String) {
        userRepository.save(name, email)
        emailService.send(email)
        welcomeService.generate(name)
        crmIntegrator.sync(name)
    }
}

fun section2_UseSmallerClasses() {
    val manager = S19Db_UserManagerGood(
        EmailService(),
        UserRepository(),
        WelcomeService(),
        CRMIntegrator()
    )

    manager.registerUser("Tashy", "tashy@code.com")
}

/*
 * 🧠 What You Will Learn:
 * - Why large classes are dangerous
 * - How to apply SRP to break responsibilities apart
 * - How to increase modularity and reuse
 */

/*
 * 🚀 Quick Summary:
 * ❌ Large Class = too much responsibility, low cohesion
 * ✅ Small, focused classes = readable, testable, composable
 */

/*
 * 📘 Key Takeaways:
 * - If your class knows too much or does too much, it’s a smell
 * - Break by role: repo, service, helper, config
 * - Don’t fear creating new classes — fear giant ones

 * 💡 Real-World Use Cases:
 * - ViewModels with too much UI + business logic
 * - Activities that handle navigation, UI, DB, network
 * - Managers that mutate everything

 * 🧼 Clean Code Insight:
 * Small is powerful. Make your classes surgical, not swollen.
 */
