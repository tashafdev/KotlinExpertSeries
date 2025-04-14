/**
 * -----------------------------------------------------
 * ✅ Lecture: Singleton Pattern (Creational)
 * -----------------------------------------------------
 *
 * 📌 Definition:
 * Singleton Pattern ensures that a class has only one instance
 * and provides a global point of access to it.
 *
 * 📦 Use Case:
 * - Logger
 * - Configuration Manager
 * - App-wide Database Helper
 *
 * 🧠 Why use it?
 * - Prevents multiple instances
 * - Saves memory
 * - Centralized control
 *
 * -----------------------------------------------------
 * 🧪 Example: App Logger Singleton
 * -----------------------------------------------------
 */

object Logger {
    fun log(message: String) {
        println("🔍 LOG: $message")
    }
}

fun main() {
    Logger.log("App started")
    Logger.log("User clicked on button")
}


/*
 * -----------------------------------------------------
 * 📱 Real-World Usage in Android – Singleton Pattern
 * -----------------------------------------------------
 *
 * 🔹 Retrofit Instance:
 *    - Usually initialized once using a Singleton to avoid multiple network clients.
 *    - Example: RetrofitClient.getInstance() or object RetrofitInstance
 *
 * 🔹 Room Database:
 *    - Database is created as a Singleton using Room.databaseBuilder(...)
 *    - Ensures single DB instance throughout the app lifecycle.
 *
 * 🔹 SharedPreferences:
 *    - PreferenceManager.getDefaultSharedPreferences(context)
 *    - Internally cached and reused.
 *
 * 🔹 Firebase:
 *    - FirebaseApp.initializeApp(context) returns a Singleton instance.
 *
 * 🔹 Dependency Injection:
 *    - Koin / Dagger Hilt use Singleton scopes (e.g., @Singleton) to inject app-wide objects.
 *
 * 🔹 ViewModel Factory:
 *    - Often created as an object to provide ViewModel instances consistently.
 *
 * ✅ Use Singleton when:
 *    - You need global access to a single instance (DB, network, auth, logging, etc.).
 *    - You want to reduce memory usage or prevent inconsistent states.
 */
