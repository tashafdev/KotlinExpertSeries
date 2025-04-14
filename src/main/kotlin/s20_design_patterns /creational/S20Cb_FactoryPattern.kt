/**
 * -----------------------------------------------------
 * ✅ Lecture: Factory Pattern (Creational)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * Factory Pattern provides an interface for creating objects,
 * but allows subclasses or methods to alter the type of objects that will be created.
 *
 * 📦 Use Case:
 * - When the exact type of object isn’t known until runtime
 * - UI Component creation based on platform or theme
 *
 * 🧠 Why use it?
 * - Decouples object creation from usage
 * - Improves scalability and code maintainability
 *
 * -----------------------------------------------------
 * 🧪 Example: Notification Factory
 * -----------------------------------------------------
 */

interface Notification {
    fun notifyUser()
}

class EmailNotification : Notification {
    override fun notifyUser() = println("📧 Sending Email Notification")
}

class SMSNotification : Notification {
    override fun notifyUser() = println("📱 Sending SMS Notification")
}

object NotificationFactory {
    fun createNotification(type: String): Notification? {
        return when (type.lowercase()) {
            "email" -> EmailNotification()
            "sms" -> SMSNotification()
            else -> null
        }
    }
}

fun main() {
    val notification = NotificationFactory.createNotification("email")
    notification?.notifyUser()
}


/*
 * -----------------------------------------------------
 * 📱 Real-World Usage in Android – Factory Pattern
 * -----------------------------------------------------
 *
 * 🔹 ViewModelProvider.Factory:
 *    - Android's official way to create ViewModels with arguments.
 *    - Custom ViewModelFactory classes implement Factory Pattern.
 *
 * 🔹 RecyclerView.Adapter.createViewHolder():
 *    - Based on viewType, creates specific ViewHolder instances.
 *    - Acts like a factory to produce different item types dynamically.
 *
 * 🔹 WorkManager:
 *    - Uses WorkerFactory to generate instances of custom Workers.
 *
 * 🔹 NotificationCompat.Builder:
 *    - Provides a flexible way to build Notification objects.
 *    - Internally uses Factory-like approach for different styles (BigText, Inbox).
 *
 * 🔹 Fragment.instantiate(...):
 *    - Dynamically creates Fragment instances based on class name.
 *
 * 🔹 Retrofit + Gson / Moshi Converter Factories:
 *    - Converts JSON to Kotlin using a plug-and-play Factory mechanism.
 *
 * ✅ Use Factory Pattern when:
 *    - You want to abstract complex object creation logic.
 *    - You want to return different implementations based on input or runtime conditions.
 */
