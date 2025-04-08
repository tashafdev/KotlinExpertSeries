package s19_clean_code_and_principles.s19d_code_smells


/*
 * -----------------------------------------------------
 * ❌ Code Smell: Too Many Dependencies
 * -----------------------------------------------------
 * A class that needs **too many dependencies** becomes:
 * - Hard to test 🧪
 * - Hard to maintain 🧱
 * - Hard to understand 🧠
 *
 * This usually means the class is doing too much (SRP violation)
 * or the design lacks proper modularization or delegation.
 */

/*
 * 📌 Section 1 — ❌ Bad: One class depends on too many things
 */
class S19De_AnalyticsManager
class S19De_RemoteLogger
class S19De_LocalCache
class S19De_Preferences
class S19De_DatabaseHelper
class S19De_NotificationHelper
class S19De_SessionManager

class S19De_UserControllerBad(
    private val analytics: S19De_AnalyticsManager,
    private val logger: S19De_RemoteLogger,
    private val cache: S19De_LocalCache,
    private val prefs: S19De_Preferences,
    private val db: S19De_DatabaseHelper,
    private val notifications: S19De_NotificationHelper,
    private val session: S19De_SessionManager
) {
    fun login() {
        println("🔐 Login triggered")
        // ... uses all 7 dependencies
    }
}

/*
 * 📌 Section 2 — ✅ Refactor: Delegate logic to coordinated helpers
 */
class LoginService(
    private val db: S19De_DatabaseHelper,
    private val session: S19De_SessionManager
) {
    fun performLogin() {
        println("🔐 Logging in user")
    }
}

class UserAnalytics(private val analytics: S19De_AnalyticsManager, private val logger: S19De_RemoteLogger) {
    fun trackLogin() {
        println("📊 Tracking login")
    }
}

class UserController(
    private val loginService: LoginService,
    private val analytics: UserAnalytics
) {
    fun login() {
        loginService.performLogin()
        analytics.trackLogin()
    }
}

fun section2_SimplifiedDependencyFlow() {
    val controller = UserController(
        loginService = LoginService(S19De_DatabaseHelper(), S19De_SessionManager()),
        analytics = UserAnalytics(S19De_AnalyticsManager(), S19De_RemoteLogger())
    )
    controller.login()
}

/*
 * 🧠 What You Will Learn:
 * - Why many dependencies = high coupling
 * - How to refactor responsibilities into focused helpers
 * - Creating higher-level abstractions to reduce clutter
 */

/*
 * 🚀 Quick Summary:
 * ❌ Too many dependencies = fragile, bloated class
 * ✅ Use intermediate services/facades to reduce clutter
 * ✅ Apply SRP + DIP = maintainable design
 */

/*
 * 📘 Key Takeaways:
 * - More than 3–4 constructor params? Time to rethink
 * - Group related logic into cohesive units
 * - Use interface injection for flexibility

 * 💡 Real-World Use Cases:
 * - Complex ViewModels with 7–10 dependencies
 * - Activities/Fragments with too many use cases/services
 * - Feature classes acting like God objects

 * 🧼 Clean Code Insight:
 * Fewer dependencies → better testability, flexibility, and clarity.
 * Refactor from mess to modules.
 */
