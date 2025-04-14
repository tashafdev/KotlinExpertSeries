/**
 * -----------------------------------------------------
 * ✅ Lecture: Chain of Responsibility Pattern (Behavioral)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * The Chain of Responsibility Pattern passes a request along a chain of handlers
 * until one of them handles it.
 *
 * 📦 Use Case:
 * - Event processing pipelines
 * - Input validation chains
 * - Middleware or filters
 *
 * 🧠 Why use it?
 * - Decouples sender and receiver
 * - Enables dynamic handler sequencing
 * - Cleaner alternative to deeply nested conditionals
 *
 * -----------------------------------------------------
 * 🧪 Example: Support Ticket Handling
 * -----------------------------------------------------
 */

abstract class SupportHandler(private val next: SupportHandler? = null) {
    abstract fun handle(issue: String)

    protected fun passToNext(issue: String) {
        next?.handle(issue)
    }
}

class Level1Support(next: SupportHandler?) : SupportHandler(next) {
    override fun handle(issue: String) {
        if (issue.contains("password")) {
            println("🔑 Level 1 resolved: $issue")
        } else {
            passToNext(issue)
        }
    }
}

class Level2Support(next: SupportHandler?) : SupportHandler(next) {
    override fun handle(issue: String) {
        if (issue.contains("connectivity")) {
            println("🌐 Level 2 resolved: $issue")
        } else {
            passToNext(issue)
        }
    }
}

class Level3Support : SupportHandler() {
    override fun handle(issue: String) {
        println("🧠 Level 3 expert handling: $issue")
    }
}

fun main() {
    val chain = Level1Support(Level2Support(Level3Support()))

    chain.handle("password reset required")
    chain.handle("connectivity issue on tablet")
    chain.handle("app crashes when opening image")
}

/*
 * -----------------------------------------------------
 * 📱 Chain of Responsibility Pattern in Android – Core Use Cases
 * -----------------------------------------------------
 *
 * ✅ OkHttp Interceptors (Networking):
 *    - Each interceptor (e.g., auth, logging, retry) handles or forwards the request.
 *    - Perfect real-world chain of handlers.

 * ✅ Input Validation:
 *    - Chaining multiple validators (e.g., non-empty, format, length).
 *    - Each validator decides to handle or pass to the next.

 * ✅ Touch/Event Handling:
 *    - Views propagate touch events up the view hierarchy.
 *    - Each parent decides whether to handle or let the event bubble up.

 * ✅ Exception Handling Chains:
 *    - Multiple `catch` blocks or delegated error handlers.

 * ✅ Middleware-like Logic in Clean Architecture:
 *    - Domain/use-case layers may pass actions down through chained policies (e.g., logging, permission, transformation).

 * 🔹 Use this pattern when:
 *    - You want to **process a request through multiple handlers**.
 *    - You want **each handler to decide whether to handle or pass**.
 */


