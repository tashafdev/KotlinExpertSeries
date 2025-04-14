package s19_clean_code_and_principles.s19a_solid_principles


/**
 * Introduction to SOLID Principles
 *
 * The SOLID principles are five foundational guidelines for writing clean, scalable, and maintainable object-oriented code.
 * Coined by Robert C. Martin (Uncle Bob), these principles help avoid code smells and support agile development practices.
 *
 *
 * ✅ Benefits of SOLID Principles:
 *  * -------------------------------
 *  * - Makes code **easier to understand**
 *  * - Reduces the risk of bugs during changes
 *  * - Improves **modularity** and **testability**
 *  * - Encourages **loose coupling** and **high cohesion**
 *  * - Supports **clean architecture** and **team collaboration**
 *
 *
 * ------------------------------------------------------------
 * 🔍 FULL FORM AND DETAILED DEFINITIONS
 * ------------------------------------------------------------
 *
 * 1. **S – Single Responsibility Principle (SRP)**
 *    A class, function, or module should have **only one reason to change**.
 *    It should do **one specific thing** and be responsible for only one part of the functionality.
 *    ➤ Example: A `UserService` should handle user logic, not logging or file writing.
 *
 * 2. **O – Open/Closed Principle (OCP)**
 *    Software entities (classes, functions, modules) should be **open for extension** but **closed for modification**.
 *    You should be able to add new functionality without changing existing code.
 *    ➤ Example: Use interfaces, inheritance, or strategy patterns to extend behavior without altering core logic.
 *
 * 3. **L – Liskov Substitution Principle (LSP)**
 *    Subtypes must be **substitutable** for their base types **without altering the correctness** of the program.
 *    Any instance of a parent class should be replaceable by its child class without breaking the system.
 *    ➤ Example: If `Bird` has a `fly()` method, `Penguin` shouldn't extend `Bird` since penguins can't fly.
 *
 * 4. **I – Interface Segregation Principle (ISP)**
 *    No client should be forced to depend on methods it does not use.
 *    It is better to have multiple **small, specific interfaces** than one large, general-purpose one.
 *    ➤ Example: Use `Readable`, `Writable`, `Printable` instead of one `IMultiFunctionDevice` interface.
 *
 * 5. **D – Dependency Inversion Principle (DIP)**
 *    High-level modules should not depend on low-level modules.
 *    Both should depend on **abstractions (interfaces)**.
 *    Abstractions should not depend on details; **details should depend on abstractions**.
 *    ➤ Example: A `NotificationManager` should depend on `INotificationService` interface,
 *       not directly on `EmailService` or `SMSService`.
 *
 * ------------------------------------------------------------
 * ✅ Summary:
 * ------------------------------------------------------------
 * Mastering SOLID principles empowers you to write:
 * - Cleaner code
 * - Loosely coupled architecture
 * - Easily testable and extendable features
 *
 * 🧠 Why learn SOLID?
 * - Helps in writing **robust and modular code**
 * - Encourages **encapsulation, abstraction, and loose coupling**
 * - Makes your codebase **easier to test, maintain, and scale**
 *
 * In this module:
 * - We'll explore each principle with Kotlin examples
 * - Understand common mistakes and how to fix them
 * - Cover interview QnA and practical usage
 *
 * Let’s begin the journey to writing **clean and professional Kotlin code** ✨
 */
fun solidIntro() {
    println("Welcome to the SOLID Principles in Kotlin!")
}
