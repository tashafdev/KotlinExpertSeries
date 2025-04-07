package s1_basics

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Basics – Lecture 7: Basic Data Types
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - Primitive data types in Kotlin
    - Default values and sizes
    - Literal values and suffixes
    - Type conversions
    - Nullable versions
    - Best practices for choosing types

    ---------------------------------------------------------------------------
    📦 Kotlin’s Core Data Types
    ----------------------------------------------------------------------------
    🔢 Numeric:
    - Byte (8-bit):     val b: Byte = 127
    - Short (16-bit):   val s: Short = 32000
    - Int (32-bit):     val i: Int = 1_000_000
    - Long (64-bit):    val l: Long = 9_000_000_000L

    🔣 Decimal:
    - Float (32-bit):   val f: Float = 3.14F
    - Double (64-bit):  val d: Double = 3.1415926535

    🔤 Text:
    - Char:             val letter: Char = 'A'
    - String:           val name: String = "Tashy"

    🔘 Boolean:
    - Boolean:          val isActive: Boolean = true

    ---------------------------------------------------------------------------
    🧠 Notes:
    - Float and Long literals require suffixes (`F`, `L`)
    - Strings use double quotes `" "`, characters use single quotes `' '`
    - `Boolean` can only be `true` or `false`

    ---------------------------------------------------------------------------
    🔄 Type Conversions (Explicit Required!)
    ----------------------------------------------------------------------------
    ❌ Kotlin doesn’t allow implicit conversions like Java

    Example:
        val x: Int = 5
        val y: Long = x  // ❌ Error
        val y: Long = x.toLong() // ✅

    ---------------------------------------------------------------------------
    ❓ Nullable Types
    ----------------------------------------------------------------------------
    - Add `?` to make a type nullable:
        val n: Int? = null

    ---------------------------------------------------------------------------
    🧹 Best Practices:
    - Use smallest type that fits your data (e.g., `Int` instead of `Long`)
    - Use `Double` over `Float` for precision math
    - Prefer immutable `val` over `var` when possible
    ---------------------------------------------------------------------------
*/


fun main() {
    // 🔢 Integers
    val byteVal: Byte = 100
    val shortVal: Short = 30000
    val intVal: Int = 1_000_000
    val longVal: Long = 9_000_000_000L

    println("Byte: $byteVal, Short: $shortVal, Int: $intVal, Long: $longVal")

    // 🔣 Floating point
    val floatVal: Float = 3.14F
    val doubleVal: Double = 3.141592653589

    println("Float: $floatVal, Double: $doubleVal")

    // 🔤 Characters and Strings
    val grade: Char = 'A'
    val fullName: String = "Tashy Dev"

    println("Grade: $grade, Name: $fullName")

    // 🔘 Boolean
    val isActive: Boolean = true
    println("Is Active: $isActive")

    // ❓ Nullable example
    val nullableAge: Int? = null
    println("Nullable Age: $nullableAge")

    // 🔄 Type conversion
    val smallNumber: Int = 42
    val bigNumber: Long = smallNumber.toLong() // Must convert explicitly
    println("Converted Int to Long: $bigNumber")
}
