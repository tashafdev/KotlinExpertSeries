package s6_classes_and_objects

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 6B: Properties and Methods
    📆 Package: kotlin.s6_classes_and_objects
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - Declaring and initializing properties
    - Getters and setters
    - Computed (custom) properties
    - Methods inside a class
    - Accessing members
    - Backing fields
    - Best practices

    ---------------------------------------------------------------------------
    📝 Property Basics
    ----------------------------------------------------------------------------
    - `val` = read-only
    - `var` = mutable
    - Properties can have default values or custom logic

    ✅ Example:
        class Book(val title: String, var pages: Int)

    ---------------------------------------------------------------------------
    🤨 Custom Getters & Setters
    ----------------------------------------------------------------------------
        var rating: Int = 0
            get() = field
            set(value) {
                field = if (value in 1..5) value else 3
            }

    - `field` keyword refers to the **backing field** (hidden storage)

    ---------------------------------------------------------------------------
    🔢 Computed Properties
    ----------------------------------------------------------------------------
        val isLong: Boolean
            get() = pages > 300

    - No backing field, just logic

    ---------------------------------------------------------------------------
    📖 Methods in a Class
    ----------------------------------------------------------------------------
        fun printDetails() {
            println("Book: $title has $pages pages")
        }

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use `val` whenever possible
    - Don’t overuse custom getters/setters unless needed
    - Keep methods focused and testable
    - Avoid exposing mutable internal state
    ---------------------------------------------------------------------------
*/


fun main() {
    val book = Book("Kotlin Mastery", 450)
    book.printDetails()

    book.rating = 7  // invalid, will default to 3
    println("Rating: ${book.rating}")

    println("Is long book? ${book.isLong}")
}

class Book(val title: String, var pages: Int) {

    // Custom setter with validation
    var rating: Int = 0
        get() = field
        set(value) {
            field = if (value in 1..5) value else 3
        }

    // Computed property
    val isLong: Boolean
        get() = pages > 300

    // Method
    fun printDetails() {
        println("Book: $title has $pages pages")
    }
}
