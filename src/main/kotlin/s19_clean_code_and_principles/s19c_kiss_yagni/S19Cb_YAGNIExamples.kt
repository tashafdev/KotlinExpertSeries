package s19_clean_code_and_principles.s19c_kiss_yagni


/*
 * -----------------------------------------------------
 * ✅ Clean Code Principle: YAGNI — You Aren’t Gonna Need It
 * -----------------------------------------------------
 * YAGNI reminds us to **not build things until we absolutely need them**.
 *
 * Premature abstraction, features, or flexibility leads to:
 * ❌ Wasted effort
 * ❌ Unused complexity
 * ❌ Technical debt
 *
 * Focus on what’s needed **right now**, not what *might* be needed.
 */

/*
 * 📌 Section 1 — ❌ Adding unused flexibility "just in case"
 */
class S19Cb_NetworkManagerBad {
    fun fetchData(url: String, retries: Int = 3, timeout: Int = 30, transform: ((String) -> Any)? = null): Any {
        val data = "server response"
        return transform?.invoke(data) ?: data
    }
}

fun section1_TooMuchTooSoon() {
    val manager = S19Cb_NetworkManagerBad()
    val result = manager.fetchData("https://api.example.com")
    println("📡 Got: $result")
    // ❌ All that extra config & transform for no real use
}

/*
 * ✅ YAGNI-Compliant version
 */
class S19Cb_NetworkManagerGood {
    fun fetchData(url: String): String {
        return "Mocked server response from $url"
    }
}

fun section1_JustEnoughLogic() {
    val manager = S19Cb_NetworkManagerGood()
    val result = manager.fetchData("https://api.example.com")
    println("📡 Got: $result")
}

/*
 * 📌 Section 2 — ❌ Designing future-proof extension interfaces too early
 */
interface SuperAdvancedLogger {
    fun logDebug(tag: String, msg: String)
    fun logInfo(tag: String, msg: String)
    fun logError(tag: String, msg: String, throwable: Throwable? = null)
    fun logJson(tag: String, json: String)
    fun logSecure(tag: String, msg: String, level: Int)
}

class ConsoleLogger : SuperAdvancedLogger {
    override fun logDebug(tag: String, msg: String) = println("🐞 $tag: $msg")
    override fun logInfo(tag: String, msg: String) = println("ℹ️ $tag: $msg")
    override fun logError(tag: String, msg: String, throwable: Throwable?) = println("❌ $tag: $msg")
    override fun logJson(tag: String, json: String) = println("📦 $tag: $json")
    override fun logSecure(tag: String, msg: String, level: Int) = println("🔒 $tag [L$level]: $msg")
}

fun section2_YAGNI_InterfaceBloat() {
    val logger = ConsoleLogger()
    logger.logInfo("MainActivity", "App started")
    // ❌ Rest of the methods are never used
}

/*
 * ✅ Keep it small and extend later when needed
 */
interface Logger {
    fun log(message: String)
}

class SimpleLogger : Logger {
    override fun log(message: String) = println("📋 $message")
}

fun section2_MinimalLogger() {
    val logger = SimpleLogger()
    logger.log("App started")
}

/*
 * 🧠 What You Will Learn:
 * - YAGNI = Build only what is needed **now**
 * - Don’t design for future you can't predict
 * - Simpler solutions win until proven otherwise
 */

/*
 * 🚀 Quick Summary:
 * ✅ Focus on real problems, not imaginary ones
 * ✅ Don’t generalize too soon
 * ✅ Expand when a real use-case demands it
 */

/*
 * 📘 Key Takeaways:
 * - Premature flexibility = future regret
 * - Small + focused is easier to grow than bulky + unused
 * - Avoid “what if we later need…” traps

 * 💡 Real-World Use Cases:
 * - Services with too many optional parameters
 * - Interfaces with unused methods
 * - Deep layers for “scalability” before any traffic

 * 🧼 Clean Code Insight:
 * Ask yourself: “Am I solving today's problem?”
 * If not... YAGNI 👋
 */
