package kotlin.s4_functions

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 4B: Extension Functions
    📦 Package: kotlin.s4_functions
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What are extension functions?
    - Syntax and structure
    - How they work under the hood
    - Null-safe extensions
    - Extension properties
    - Limitations
    - Best practices

    ---------------------------------------------------------------------------
    ➕ What are Extension Functions?
    ----------------------------------------------------------------------------
    - Add new functionality to **existing classes** (even standard ones!)
    - Without modifying the original class or using inheritance

    ✅ Syntax:
        fun ClassName.functionName(params): ReturnType {
            // access 'this' = the instance
        }

    ---------------------------------------------------------------------------
    ✅ Example 1: String Extension
        fun String.removeSpaces(): String {
            return this.replace(\" \", \"\")
        }

        val name = \"Tashy Dev\"
        println(name.removeSpaces()) // 👉 TashyDev

    ---------------------------------------------------------------------------
    ✅ Example 2: Int Extension
        fun Int.square(): Int = this * this

        val x = 4
        println(x.square()) // 👉 16

    ---------------------------------------------------------------------------
    ✅ Null-Safe Extension
        fun String?.safeLength(): Int {
            return this?.length ?: 0
        }

        val str: String? = null
        println(str.safeLength()) // 👉 0

    ---------------------------------------------------------------------------
    🧾 Extension Properties (read-only only)
        val String.firstChar: Char
            get() = this[0]

        println(\"Hello\".firstChar) // 👉 'H'

    ---------------------------------------------------------------------------
    ⚠️ Limitations:
    - They **do not actually modify** the class
    - They are **resolved statically**, not polymorphically
    - Can't access private/protected members

    Example:
        val view: TextView = MyCustomTextView()
        view.showToast() // if defined as extension on TextView
        // Will call TextView version, not MyCustomTextView version

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use for utility logic, validation, formatting
    - Group related extensions in files or objects
    - Avoid misusing for complex logic or state mutation
    ---------------------------------------------------------------------------
*/


fun main() {
    // ➕ String extension usage
    val raw = "Hello Kotlin Expert"
    println("No spaces: ${raw.removeSpaces()}")

    // ➕ Int extension usage
    println("Square of 7: ${7.square()}")

    // 🔒 Null-safe extension
    val maybeNull: String? = null
    println("Safe length: ${maybeNull.safeLength()}")

    // 📌 Extension property
    val tag = "Extension"
    println("First letter: ${tag.firstChar}")
}

// ✅ Custom String extension function
fun String.removeSpaces(): String {
    return this.replace(" ", "")
}

// ✅ Int extension
fun Int.square(): Int = this * this

// ✅ Null-safe String extension
fun String?.safeLength(): Int {
    return this?.length ?: 0
}

// ✅ Extension property
val String.firstChar: Char
    get() = this[0]
