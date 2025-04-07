package s6_classes_and_objects

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 6A: Introduction to Classes
    📆 Package: kotlin.s6_classes_and_objects
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What is a class in Kotlin?
    - Declaring a class
    - Primary and secondary constructors
    - Object creation and property access
    - Understanding `init` block
    - Overview of default visibility and structure
    - Best practices

    ---------------------------------------------------------------------------
    💼 What is a Class?
    ----------------------------------------------------------------------------
    - A class is a **blueprint** to create objects.
    - It groups **data (properties)** and **behavior (functions)**.

    ---------------------------------------------------------------------------
    🔧 Declaring a Basic Class
    ----------------------------------------------------------------------------
        class Person {
            var name: String = ""
            var age: Int = 0
        }

        val p = Person()
        p.name = "Tashy"
        p.age = 25

    ---------------------------------------------------------------------------
    🤣 Primary Constructor
    ----------------------------------------------------------------------------
        class User(val name: String, val age: Int)

        val u = User("Dev", 30)
        println(u.name) // Dev

    ---------------------------------------------------------------------------
    📊 init Block (executed during object creation)
    ----------------------------------------------------------------------------
        class Profile(val username: String) {
            init {
                println("New Profile: $username")
            }
        }

        Profile("Tashy")

    ---------------------------------------------------------------------------
    🦐 Secondary Constructor
    ----------------------------------------------------------------------------
        class Device(val model: String) {
            var os: String = "Unknown"

            constructor(model: String, os: String): this(model) {
                this.os = os
            }
        }

        val phone = Device("Galaxy", "Android")

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Keep classes focused (SRP)
    - Prefer primary constructor when possible
    - Avoid too much logic in `init`
    - Use `val` for read-only data and `var` only when mutation is needed
    ---------------------------------------------------------------------------
*/


fun main() {
    val p = Person()
    p.name = "Tashy"
    p.age = 28
    println("${p.name} is ${p.age} years old")

    val u = User("Dev", 30)
    println("User: ${u.name}, Age: ${u.age}")

    val profile = Profile("tashy_x")

    val device = Device("Pixel", "Android")
    println("Device: ${device.model}, OS: ${device.os}")
}

// Basic class
class Person {
    var name: String = ""
    var age: Int = 0
}

// Primary constructor
class User(val name: String, val age: Int)

// Class with init block
class Profile(val username: String) {
    init {
        println("New Profile Created for: $username")
    }
}

// Class with secondary constructor
class Device(val model: String) {
    var os: String = "Unknown"

    constructor(model: String, os: String) : this(model) {
        this.os = os
    }
}
