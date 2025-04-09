package s19_clean_code_and_principles.s19c_kiss_yagni


/**
 * S19Ce_KISS_YAGNI_PracticalExample.kt
 * Problem: You want to print a welcome message.
 * Version A: Overengineered (violates KISS/YAGNI).
 * Version B: Simple and to-the-point.
 */

fun runS19Ce_KISS_YAGNI_Practice() {
    println("❌ Overengineered:")
    val service = MessageServiceFactory.create()
    val processor = WelcomeMessageProcessor(service)
    processor.showWelcomeMessage("Tashy")

    println("\n✅ KISS/YAGNI version:")
    simpleWelcome("Tashy")
}

// 🔹 ❌ Overengineered version (bad)
class WelcomeMessageProcessor(private val service: MessageService) {
    fun showWelcomeMessage(name: String) {
        val message = service.generate(name)
        println(message)
    }
}

interface MessageService {
    fun generate(name: String): String
}

class DefaultMessageService : MessageService {
    override fun generate(name: String): String {
        return "Hello, $name! Welcome to the app."
    }
}

object MessageServiceFactory {
    fun create(): MessageService = DefaultMessageService()
}

// 🔹 ✅ KISS + YAGNI-compliant version
fun simpleWelcome(name: String) {
    println("Hello, $name! Welcome to the app.")
}
