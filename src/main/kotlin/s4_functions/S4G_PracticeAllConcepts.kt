package s4_functions


/**
 * S4G_PracticeAllConcepts.kt
 * Problem: Create a health calculator using multiple functions:
 * - Function basics
 * - Named and default args
 * - Extension functions
 * - Inline function
 * - Recursion (optional)
 */

fun main() {
    println("🏃 Welcome to Smart Health Tracker")

    val name = "Tashy"
    greetUser1(name)

    // Using named + default arguments
    val bmi = calculateBMI(weightKg = 65.0, heightMeters = 1.7)
    println("✅ BMI: ${"%.2f".format(bmi)}")

    // Extension function usage
    println("BMI Category: ${bmi.bmiCategory()}")

    // Inline function for measuring time
    measure {
        println("⏳ Calculating Fibonacci(10): ${fibonacci(10)}")
    }
}

// 🔹 Function basics
fun greetUser1(name: String) {
    println("Hello, $name! Let's track your health.")
}

// 🔹 Named + default arguments
fun calculateBMI(weightKg: Double, heightMeters: Double = 1.75): Double {
    return weightKg / (heightMeters * heightMeters)
}

// 🔹 Extension function for Double
fun Double.bmiCategory(): String = when {
    this < 18.5 -> "Underweight"
    this < 24.9 -> "Normal"
    this < 29.9 -> "Overweight"
    else -> "Obese"
}

// 🔹 Inline function for performance check
inline fun measure(block: () -> Unit) {
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    println("⌛ Time taken: ${end - start} ns")
}

// 🔹 Recursion example
fun fibonacci(n: Int): Int {
    return if (n <= 1) n else fibonacci(n - 1) + fibonacci(n - 2)
}
