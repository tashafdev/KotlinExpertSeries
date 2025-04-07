package s2_variables_and_types

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Series – Section 2C: Numeric Types
    📦 Package: kotlin.s2_variables_and_types
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - All numeric types in Kotlin (Byte, Short, Int, Long, Float, Double)
    - Their size, range, and default usage
    - Literal suffixes (`L`, `F`) and underscores in numbers
    - Type conversions (`toX()` functions)
    - Overflow behavior
    - Best practices when working with numbers

    ---------------------------------------------------------------------------
    🔢 Kotlin Numeric Types
    ----------------------------------------------------------------------------

    | Type   | Size   | Example        | Range                          |
    |--------|--------|----------------|--------------------------------|
    | Byte   | 8-bit  | val b: Byte    | -128 to 127                    |
    | Short  | 16-bit | val s: Short   | -32,768 to 32,767              |
    | Int    | 32-bit | val i: Int     | -2^31 to 2^31-1                |
    | Long   | 64-bit | val l: Long    | -2^63 to 2^63-1                |
    | Float  | 32-bit | val f: Float   | ~6-7 decimal digits precision  |
    | Double | 64-bit | val d: Double  | ~15-16 decimal digits precision|

    ---------------------------------------------------------------------------
    🔖 Literal Suffixes
    ----------------------------------------------------------------------------
    - `L`: Marks a `Long` literal → `val id = 1234L`
    - `F`: Marks a `Float` literal → `val pi = 3.14F`
    - Underscores can be used for readability → `1_000_000`

    ---------------------------------------------------------------------------
    🔁 Type Conversion (Must be Explicit)
    ----------------------------------------------------------------------------
    Kotlin doesn't allow implicit numeric conversions:

        val x: Int = 100
        val y: Long = x // ❌ Error
        val y: Long = x.toLong() ✅

    ✅ Common Conversion Functions:
    - `toByte()`, `toShort()`, `toInt()`, `toLong()`
    - `toFloat()`, `toDouble()`

    ---------------------------------------------------------------------------
    🧠 Overflow Behavior
    ----------------------------------------------------------------------------
    - Kotlin doesn't crash or warn on overflow by default — values wrap around.

    Example:
        val b: Byte = 127
        val overflowed = (b + 1).toByte() // -128

    ---------------------------------------------------------------------------
    ✅ Best Practices:
    - Use `Int` for whole numbers unless size/limits matter
    - Prefer `Double` over `Float` unless working with performance-limited systems
    - Always convert explicitly
    - Use underscores for large number readability
    ---------------------------------------------------------------------------
*/


fun main() {
    // 🔢 Integer types
    val b: Byte = 127
    val s: Short = 32_000
    val i: Int = 1_000_000
    val l: Long = 9_000_000_000L

    println("Byte: $b, Short: $s, Int: $i, Long: $l")

    // 🔣 Floating-point types
    val f: Float = 3.14F
    val d: Double = 3.141592653589

    println("Float: $f, Double: $d")

    // 🧮 Literal with underscores
    val bigInt = 2_000_000
    println("Big Int (with _): $bigInt")

    // 🔁 Type conversions
    val x = 42
    val y = x.toLong()
    val precise = x.toDouble()
    println("Converted to Long: $y, to Double: $precise")

    // 🔁 Overflow demo
    val maxByte: Byte = 127
    val wrappedByte = (maxByte + 1).toByte()
    println("Overflowed Byte: $wrappedByte")
}
