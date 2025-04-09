package s1_basics


/**
 * S1K_AllConceptsPractice.kt
 * A full-practice file combining everything from the s1_basics section using
 * a mini real-world calculator app with user input, validation, and clean output.
 */

fun main() {
    // 🔹 Welcome (Hello World + Syntax)
    println("👋 Welcome to the Kotlin Basic Info & BMI Calculator App!")

    // 🔹 User input (Simple Input/Output + Comments)
    // Asking name and showing comments
    print("Please enter your name: ") // This is a single-line comment
    val name = readLine()?.takeIf { it.isNotBlank() } ?: "Guest"

    /*
     * Asking for user's age.
     * Multi-line comment explaining the reason:
     * - We'll validate and convert input to integer
     */
    print("Enter your age: ")
    val ageInput = readLine()
    val age = try {
        ageInput?.toInt() ?: -1
    } catch (e: NumberFormatException) {
        -1
    }

    // 🔹 Show error if invalid input
    if (age < 0) {
        println("⚠️ Invalid age. We'll continue without it.")
    }

    // 🔹 Ask for height and weight (Double input, Basic Data Types)
    print("Enter your height in meters (e.g., 1.75): ")
    val height = readLine()?.toDoubleOrNull() ?: 0.0

    print("Enter your weight in kg (e.g., 70): ")
    val weight = readLine()?.toDoubleOrNull() ?: 0.0

    // 🔹 Use variables (val vs var) and expressions
    val bmi: Double = if (height > 0) weight / (height * height) else 0.0

    // 🔹 Use operators & expressions + string templates
    println("🧮 Calculating BMI for $name...")

    // 🔹 Output Result
    if (bmi > 0) {
        println("Hi $name, your BMI is ${"%.2f".format(bmi)}")
    } else {
        println("⚠️ Could not calculate BMI due to missing/invalid data.")
    }

    // 🔹 Final message (Hello World / Output again)
    println("✅ Thank you for using the app. Stay healthy, $name! 🎉")
}
