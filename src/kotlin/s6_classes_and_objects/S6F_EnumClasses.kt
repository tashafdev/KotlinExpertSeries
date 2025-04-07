package kotlin.s6_classes_and_objects

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 6F: Enum Classes
    📦 Package: kotlin.s6_classes_and_objects
    🎓 Lecture: Enum Classes – Roles, Status, and Finite State Models
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What is an enum class?
    - Declaring enums with and without properties
    - Adding methods to enum entries
    - `when` expression with enums
    - Iterating enum values
    - Best practices

    ---------------------------------------------------------------------------
    🎯 What is an Enum?
    ----------------------------------------------------------------------------
    - A type that has a **fixed set of constants**.
    - Often used for roles, states, modes, types, etc.

    ✅ Syntax:
        enum class Direction { NORTH, SOUTH, EAST, WEST }

    ---------------------------------------------------------------------------
    🧱 Enum With Properties and Methods
    ----------------------------------------------------------------------------
        enum class Status(val code: Int) {
            SUCCESS(200),
            ERROR(500),
            LOADING(102);

            fun isFinal(): Boolean = this == SUCCESS || this == ERROR
        }

    ---------------------------------------------------------------------------
    🔄 Useful Enum Functions
    ----------------------------------------------------------------------------
    ✅ `values()` → Returns all constants
    ✅ `valueOf(name)` → Convert string to enum
    ✅ Enum in `when` → Clean, exhaustive

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use enums for known finite options
    - Add behavior using functions inside the enum
    - Avoid adding mutable state
    ---------------------------------------------------------------------------
*/


fun main() {
    // 🔁 Basic enum usage
    val direction = Direction.NORTH
    println("Direction: $direction")

    // 🔁 Enum with property
    val status = Status.ERROR
    println("Status code: ${status.code}")
    println("Is Final? ${status.isFinal()}")

    // 🔄 Using when with enums
    when (direction) {
        Direction.NORTH -> println("You're going up")
        Direction.SOUTH -> println("You're going down")
        Direction.EAST -> println("To the right!")
        Direction.WEST -> println("To the left!")
    }

    // 🔁 values() and iteration
    println("All directions:")
    for (d in Direction.values()) {
        println("- $d")
    }

    val parsed = Direction.valueOf("WEST")
    println("Parsed enum: $parsed")
}

// ✅ Basic Enum
enum class Direction {
    NORTH, SOUTH, EAST, WEST
}

// ✅ Enum with property + method
enum class Status(val code: Int) {
    SUCCESS(200),
    ERROR(500),
    LOADING(102);

    fun isFinal(): Boolean = this == SUCCESS || this == ERROR
}
