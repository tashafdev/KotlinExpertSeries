package s19_clean_code_and_principles.s19d_code_smells


/**
 * S19Dg_CodeSmells_PracticalExample.kt
 * Problem: Notification sender with long method, duplicated code, and switch/if chain.
 * Then shows refactored solution using clean Kotlin practices.
 */

fun runS19Dg_CodeSmellsExample() {
    println("❌ Code Smell Version Output:")
    val badSender = S19Dg_NotificationSenderSmelly()
    badSender.send("email", "Welcome!", "Tashy")

    println("\n✅ Clean Refactored Version Output:")
    val goodSender = S19Dg_NotificationSenderClean()
    goodSender.send(S19Dg_EmailNotification("Tashy", "Welcome!"))
}

// ❌ Code Smell: Long method + if-else chain + duplicate
class S19Dg_NotificationSenderSmelly {
    fun send(type: String, message: String, receiver: String) {
        println("Sending notification...")

        if (type == "email") {
            println("Connecting to SMTP...")
            println("Sending Email to $receiver: $message")
        } else if (type == "sms") {
            println("Connecting to SMS gateway...")
            println("Sending SMS to $receiver: $message")
        } else if (type == "push") {
            println("Connecting to Push Service...")
            println("Sending Push Notification to $receiver: $message")
        }

        println("Notification sent.")
    }
}

// ✅ Refactored with sealed class + polymorphism (no smell)
sealed class S19Dg_Notification(val receiver: String, val message: String) {
    abstract fun send()
}

class S19Dg_EmailNotification(receiver: String, message: String) : S19Dg_Notification(receiver, message) {
    override fun send() {
        println("📧 Sending Email to $receiver: $message")
    }
}

class S19Dg_SMSNotification(receiver: String, message: String) : S19Dg_Notification(receiver, message) {
    override fun send() {
        println("📱 Sending SMS to $receiver: $message")
    }
}

class S19Dg_PushNotification(receiver: String, message: String) : S19Dg_Notification(receiver, message) {
    override fun send() {
        println("🔔 Sending Push to $receiver: $message")
    }
}

class S19Dg_NotificationSenderClean {
    fun send(notification: S19Dg_Notification) {
        println("Connecting...")
        notification.send()
        println("✅ Done.")
    }
}
