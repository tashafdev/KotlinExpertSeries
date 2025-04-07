package s6_classes_and_objects

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 6E: Nested and Inner Classes (Optional)
    📦 Package: kotlin.s6_classes_and_objects
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What are nested classes?
    - What are inner classes?
    - Accessing outer class members from inner class
    - Real-world use cases (e.g., UI building, grouped logic)
    - Best practices

    ---------------------------------------------------------------------------
    🧱 Nested Class
    ----------------------------------------------------------------------------
    - Declared inside another class using `class Nested` (default behavior)
    - Does **not** hold reference to the outer class

    ✅ Example:
        class Outer {
            class Nested {
                fun greet() = "Hello from nested"
            }
        }

        val n = Outer.Nested().greet()

    ---------------------------------------------------------------------------
    🧩 Inner Class
    ----------------------------------------------------------------------------
    - Declared using `inner class` keyword
    - Has access to outer class members

    ✅ Example:
        class Car(val brand: String) {
            inner class Engine {
                fun getBrand() = "Engine of $brand"
            }
        }

        val engine = Car("Tesla").Engine().getBrand()

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use nested class for grouping logic that doesn’t need outer reference
    - Use inner class sparingly; prefer composition if possible
    - Be mindful of memory leaks with inner classes holding references
    ---------------------------------------------------------------------------
*/


fun main() {
    // ✅ Nested class
    val nestedMessage = Container.Nested().message()
    println(nestedMessage)

    // ✅ Inner class
    val smartphone = Device1("Pixel 9")
    val batteryInfo = smartphone.Battery().status()
    println(batteryInfo)
}

// 🧱 Nested class example
class Container {
    class Nested {
        fun message(): String = "📦 Hello from Nested class"
    }
}

// 🧩 Inner class example
class Device1(private val model: String) {
    inner class Battery {
        fun status(): String = "🔋 Battery connected to $model"
    }
}
